package com.chcraft.sqlrelation.query;

import com.chcraft.sqlrelation.EntityRelationshipModel;
import com.chcraft.sqlrelation.entity.Column;
import com.chcraft.sqlrelation.entity.Entity;
import com.chcraft.sqlrelation.relation.Relation;

public class QueryMaker {

	public String createQuery(EntityRelationshipModel model) {
		StringBuilder query = new StringBuilder();

		//Create tables first
		for(Entity entity : model.getEntities()) {
			query.append(createQuery(entity));
			query.append(";\n\n");
		}

		//Add foreign key constraint and foreign key field
		for(Relation relation : model.getRelations()) {
			//ALTER TABLE ... FOREIGN KEY CONSTRAINT ...
			query.append(createQuery(relation));
			query.append("대충 외래키 제약조건하고 외래키 필드 추가했다는 내용.\n\n");
		}

		return query.toString();
	}

	public String createQuery(Entity entity) {
		StringBuilder query = new StringBuilder();

		query.append(SQLKeyword.CREATE);
		query.append(" ");
		query.append(SQLKeyword.TABLE);
		query.append(" ");
		query.append(entity.getName());
		query.append(" ");
		query.append("(");

		char seperator = ' ';
		for(Column column : entity.getColumns()) {
			query.append(seperator);
			query.append('\n');
			seperator = ',';

			query.append(column.getName());
			query.append(" ");
			query.append(column.getDatatype());
			query.append(" ");
			//query.append(Column options); COLUMN NOT YET SUPPORT COLUMN OPTIONS
		}

		query.append("\n)");

		return query.toString();
	}

	public String createQuery(Relation relation) {
		//TODO : not implemented method
		return null;
	}
}
