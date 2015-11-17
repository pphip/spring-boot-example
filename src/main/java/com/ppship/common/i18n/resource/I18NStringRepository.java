package com.ppship.common.i18n.resource;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.ppship.common.i18n.model.I18NString;

public interface I18NStringRepository extends CrudRepository<I18NString, Long> {
	public Iterable<I18NString> findAllByNoGreaterThanEqualAndCreatedAtGreaterThanEqualOrderByNoAscCreatedAtAsc(Long no, Date createdAt);
}
