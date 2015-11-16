package com.ppship.sns.user.model;

import java.util.Date;

import com.ppship.common.model.BaseObject;

public class User extends BaseObject {
	private static final long serialVersionUID = 7813366511716071857L;
	
	private Long no;
	private String id;
	private String name;
	private Date createdAt;
	private Date updatedAt;
}
