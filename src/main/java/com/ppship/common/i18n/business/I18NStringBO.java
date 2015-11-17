package com.ppship.common.i18n.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.ppship.common.i18n.model.I18NString;
import com.ppship.common.i18n.resource.I18NStringRepository;

@Component
public class I18NStringBO {
	@Autowired
	I18NStringRepository i18nStringRepository;

	public I18NString save(I18NString string) {
		return i18nStringRepository.save(string);
	}

	public void delete(I18NString string) {
		i18nStringRepository.delete(string);
	}

	public I18NString getByNo(Long no) {
		return i18nStringRepository.findOne(no);
	}

	public List<I18NString> getByNos(Long... no) {
		List<Long> param = Lists.asList(no[0], no);
		Iterable<I18NString> repoResult = i18nStringRepository.findAll(param);
		List<I18NString> list = Lists.newArrayList();
		if (repoResult != null) {
			for (I18NString string : repoResult) {
				if (string == null) {
					continue;
				}
				list.add(string);
			}
		}
		return list;
	}
}
