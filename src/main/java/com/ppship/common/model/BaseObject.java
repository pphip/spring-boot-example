package com.ppship.common.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ppship.common.util.JsonUtil;

abstract public class BaseObject implements Serializable {
	private static final long serialVersionUID = 3648673596657711830L;

	@Override
	public String toString() {
		return JsonUtil.getIndentedString(this);
	}
}
