package com.ppship.common.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

abstract public class BaseObject implements Serializable {
	private static final long serialVersionUID = 3648673596657711830L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
