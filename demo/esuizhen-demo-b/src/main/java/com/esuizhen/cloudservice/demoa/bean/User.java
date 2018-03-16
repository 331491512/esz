package com.esuizhen.cloudservice.demoa.bean;

import java.io.Serializable;

public class User implements Serializable
{
	private Long id;
	
	private String password;
	
	private String name;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "Demo [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
	
}
