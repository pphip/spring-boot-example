package com.ppship.spring_boot_helloworld.param;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.ppship.spring_boot_helloworld.domain.CommonObject;

public class CityParam extends CommonObject{
	private static final long serialVersionUID = 2668494517015934897L;
	
	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
