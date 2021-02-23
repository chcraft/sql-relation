package com.chcraft.sqlrelation;

import java.util.ArrayList;
import java.util.List;

import com.chcraft.sqlrelation.entity.Entity;
import com.chcraft.sqlrelation.relation.Relation;

public class EntityRelationshipModel {
	private List<Entity> entities;
	private List<Relation> relations;

	public EntityRelationshipModel() {
		entities = new ArrayList<>();
		relations = new ArrayList<>();
	}

	public EntityRelationshipModel(List<Entity> entities, List<Relation> relations) {
		this.entities = entities;
		this.relations = relations;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}

	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

	public boolean addEntity(Entity entity) {
		return entities.add(entity);
	}

	public boolean addRelation(Relation relation) {
		return relations.add(relation);
	}

	public boolean removeEntity(Entity entity) {
		return entities.remove(entity);
	}

	public boolean removeRelation(Relation relation) {
		return relations.remove(relation);
	}
}