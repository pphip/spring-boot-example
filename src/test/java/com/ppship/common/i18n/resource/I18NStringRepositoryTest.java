package com.ppship.common.i18n.resource;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.neovisionaries.i18n.CountryCode;
import com.ppship.common.CommonApplication;
import com.ppship.common.i18n.model.I18NString;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CommonApplication.class)
public class I18NStringRepositoryTest {
	@Autowired
	I18NStringRepository repo;

	@Test
	public void test() {
		System.out.println("- start test");

		System.out.println("- initial db state");
		Iterable<I18NString> list = repo.findAll();
		System.out.println(list);

		System.out.println("- insert start");
		I18NString param = new I18NString();
		Map<CountryCode, String> stringMap = Maps.newHashMap();
		stringMap.put(CountryCode.AC, "test1");
		stringMap.put(CountryCode.AD, "test2");
		param.setStringMap(stringMap);
		System.out.println("- before save");
		System.out.println(param);
		param = repo.save(param);
		System.out.println("- after save");
		System.out.println(param);
		System.out.println("- save end");

		System.out.println("- before delete");
		repo.delete(param);
		System.out.println("- after delete");
		list = repo.findAll();
		System.out.println(list);

		System.out.println("- last db state");
		list = repo.findAll();
		System.out.println(list);
		System.out.println("- end test");
	}

	@Test
	public void testPaging() {
		repo.deleteAll();

		for (int i = 0; i < 10; i++) {
			I18NString param = new I18NString();
			Map<CountryCode, String> stringMap = Maps.newHashMap();
			stringMap.put(CountryCode.AC, "test1");
			stringMap.put(CountryCode.AD, "test2");
			param.setStringMap(stringMap);
			param = repo.save(param);
		}
		Iterable<I18NString> iter = repo.findAll();
		List<I18NString> list = Lists.newArrayList();
		for (I18NString str : iter) {
			list.add(str);
		}
		
		System.out.println("- total");
		System.out.println(list);
		iter = repo.findAllByNoGreaterThanEqualAndCreatedAtGreaterThanEqualOrderByNoAscCreatedAtAsc(list.get(5).getNo(), list.get(5).getCreatedAt());
		System.out.println("- paging");
		System.out.println(iter);
	}
}
