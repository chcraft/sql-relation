package com.chcraft.sqlrelation.entity;

import java.util.List;

public interface Entity {
	String getName();
	String getPrimaryKey();
	List<Column> getColumns();
}
