package com.chcraft.sqlrelation.query;

import com.chcraft.sqlrelation.EntityRelationshipModel;
import com.chcraft.sqlrelation.entity.Column;
import com.chcraft.sqlrelation.entity.Entity;
import com.chcraft.sqlrelation.relation.Relation;
import com.chcraft.sqlrelation.relation.RelationType;

public class QueryMaker {

	/***
	 * this method create query about entity without foreign key.
	 * after create tables, it add foreign key constraint and foreign key field.
	 * @param model
	 * @return entity and relation query
	 */
	public static String createQuery(EntityRelationshipModel model) {
		StringBuilder query = new StringBuilder();

		//Create tables first
		for(Entity entity : model.getEntities()) {
			query.append(createQuery(entity));
			query.append(";\n\n");
		}

		//Add foreign key constraint and foreign key field
		for(Relation relation : model.getRelations()) {
			if(relation.getRelationType() != RelationType.MANY_TO_ONE)
				continue;

			query.append(createQuery(relation));
			query.append(";\n\n");
		}

		return query.toString();
	}

	/***
	 * @param entity
	 * @return table create query about entity
	 */
	public static String createQuery(Entity entity) {
		StringBuilder query = new StringBuilder();

		/*
		 * CREATE TABLE [ENTITY_NAME] (
		 * COLUMN_NAME DATATYPE [OPTIONS...],
		 * ...
		 * )
		 */

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

	/***
	 * @param relation
	 * @return foreign key constraint query about relation
	 */
	public static String createQuery(Relation relation) {
		StringBuilder query = new StringBuilder();

		/*
		 * ALTER TABLE [ORIGIN_NAME]
		 * ADD COLUMN [FOREIGN_NAME]_[FOREIGN_PRIMARY_KEY_NAME] [FOREIGN_PRIMARY_KEY_DATATYPE],
		 * ADD FOREIGN KEY ([FOREIGN_NAME]_[FOREIGN_PRIMARY_KEY_NAME]) REFERENCES [FOREIGN_NAME]([FOREIGN_PRIMARY_KEY_NAME])
		 * */

		query.append(SQLKeyword.ALTER);
		query.append(" ");
		query.append(SQLKeyword.TABLE);
		query.append(" ");
		query.append(relation.getOrigin().getName());
		query.append("\n");
		query.append(SQLKeyword.ADD);
		query.append(" ");
		query.append(SQLKeyword.COLUMN);
		query.append(" ");
		query.append(relation.getForeign().getName());
		query.append("_");
		query.append(relation.getForeign().getPrimaryKey().getName());
		query.append(" ");
		query.append(relation.getForeign().getPrimaryKey().getDatatype());
		query.append(",\n");
		query.append(SQLKeyword.ADD);
		query.append(" ");
		query.append(SQLKeyword.FOREIGN);
		query.append(" ");
		query.append(SQLKeyword.KEY);
		query.append(" ");
		query.append("(");
		query.append(relation.getForeign().getName());
		query.append("_");
		query.append(relation.getForeign().getPrimaryKey().getName());
		query.append(")");
		query.append(" ");
		query.append(SQLKeyword.REFERENCES);
		query.append(" ");
		query.append(relation.getForeign().getName());
		query.append("(");
		query.append(relation.getForeign().getPrimaryKey().getName());
		query.append(")");

		return query.toString();
	}
}
