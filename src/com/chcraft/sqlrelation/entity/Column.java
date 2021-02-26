package com.chcraft.sqlrelation.entity;

import java.util.ArrayList;
import java.util.List;

public class Column {
	private String name;
	private String datatype;
	private List<ColumnOption> options;

	public Column() {
		options = new ArrayList<>();
	}

	public Column(String name, String datatype) {
		this.name = name;
		this.datatype = datatype;
		options = new ArrayList<>();
	}

	public Column(String name, String datatype, List<ColumnOption> options) {
		this.name = name;
		this.datatype = datatype;
		this.options = options;
	}

	public boolean addOption(ColumnOption option) {
		return options.add(option);
	}

	public boolean removeOption(ColumnOption option) {
		return options.remove(option);
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

	public List<ColumnOption> getOptions() {
		return options;
	}

	public void setOptions(List<ColumnOption> options) {
		this.options = options;
	}
}
