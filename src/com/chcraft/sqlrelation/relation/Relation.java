package com.chcraft.sqlrelation.relation;

import com.chcraft.sqlrelation.entity.Entity;

public class Relation {
	private Entity origin;
	private Entity foreign;
	private RelationType relationType;

	public Relation() {
	}

	public Relation(Entity origin, Entity foreign, RelationType relationType) {
		this.origin = origin;
		this.foreign = foreign;
		this.relationType = relationType;
	}

	public Entity getOrigin() {
		return origin;
	}

	public void setOrigin(Entity origin) {
		this.origin = origin;
	}

	public Entity getForeign() {
		return foreign;
	}

	public void setForeign(Entity foreign) {
		this.foreign = foreign;
	}

	public RelationType getRelationType() {
		return relationType;
	}

	public void setRelationType(RelationType relationType) {
		this.relationType = relationType;
	}
}
