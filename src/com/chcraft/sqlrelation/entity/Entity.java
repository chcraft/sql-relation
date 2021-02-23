package com.chcraft.sqlrelation.entity;

import java.util.ArrayList;
import java.util.List;

public class Entity {
	private String name;
	private List<Column> columns;

	public Entity() {
		this.columns = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public Column getPrimaryKey() {
		// TODO : not implemented method.
		return null;
	}

	public boolean addColumn(Column column) {
		return this.columns.add(column);
	}
}
