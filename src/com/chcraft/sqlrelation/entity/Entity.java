package com.chcraft.sqlrelation.entity;

import java.util.HashMap;
import java.util.Map;

public class Entity {
	private String name;
	private Map<String, String> columns;
	private Map<String, String> foreignKeys;

	public Entity() {
		this.columns = new HashMap<>();
		this.foreignKeys = new HashMap<>();
	}

	public Entity(String name) {
		this.name = name;
		this.columns = new HashMap<>();
		this.foreignKeys = new HashMap<>();
	}

	public Entity(String name, Map<String, String> columns) {
		this.name = name;
		this.columns = columns;
	}

	public Entity(String name, Map<String, String> columns, Map<String, String> foreignKeys) {
		this.name = name;
		this.columns = columns;
		this.foreignKeys = foreignKeys;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, String> columns) {
		this.columns = columns;
	}

	public Map<String, String> getForeignKeys() {
		return foreignKeys;
	}

	public void setForeignKeys(Map<String, String> foreignKeys) {
		this.foreignKeys = foreignKeys;
	}
}
