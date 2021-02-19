package com.chcraft.sqlrelation.entity;

public class Column {
	private String name;
	private String datatype;

	public Column() {
	}

	public Column(String name, String datatype) {
		this.name = name;
		this.datatype = datatype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
}
