package com.ppship.spring_boot_helloworld.param;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.ppship.spring_boot_helloworld.domain.CommonObject;

public class PersonCreateParam extends CommonObject{
	private static final long serialVersionUID = 4348967970844365588L;
	
	@NotNull
	private String name;
	@Valid
	@NotNull
	private CityParam city;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CityParam getCity() {
		return city;
	}

	public void setCity(CityParam city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
