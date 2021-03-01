package com.chcraft.sqlrelation.entity;

import java.util.ArrayList;
import java.util.List;

public class Entity {
	private String name;
	private List<Column> columns;

	public Entity() {
		this.columns = new ArrayList<>();
	}

	public Entity(String name) {
		this.name = name;
		this.columns = new ArrayList<>();
	}

	public Entity(String name, List<Column> columns) {
		this.name = name;
		this.columns = columns;
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

	/***
	 * @return primary key column if exist. if primary key is not exist return null.
	 */
	public Column getPrimaryKey() {
		for(Column column : columns) {
			for(ColumnOption option : column.getOptions()) {
				if(option == ColumnOption.PK)
					return column;
			}
		}
		return null;
	}

	public boolean addColumn(Column column) {
		return this.columns.add(column);
	}
}
