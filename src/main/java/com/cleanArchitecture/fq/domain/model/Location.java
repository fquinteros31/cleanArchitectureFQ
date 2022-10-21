package com.cleanArchitecture.fq.domain.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Location implements Serializable{

	private int id;
	private String name;
	private String type;
	private String dimension;
	private List<String> residents;
	private String url;
	private Date created;

	public Location() {
	}

	public Location(int id, String name, String type, String dimension, List<String> residents, String url, Date created) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.dimension = dimension;
		this.residents = residents;
		this.url = url;
		this.created = created;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public List<String> getResidents() {
		return residents;
	}

	public void setResidents(List<String> residents) {
		this.residents = residents;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
