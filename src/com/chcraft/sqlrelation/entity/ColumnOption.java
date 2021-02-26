package com.chcraft.sqlrelation.entity;

interface InitialToOrigin {
	String initialToOrigin();
}

public enum ColumnOption implements InitialToOrigin {
	PK {
		@Override
		public String initialToOrigin() {
			return "PRIMARY KEY";
		}
	},
	NN {
		@Override
		public String initialToOrigin() {
			return "NOT NULL";
		}
	},
	UQ {
		@Override
		public String initialToOrigin() {
			return "UNIQUE";
		}
	},
	AI {
		@Override
		public String initialToOrigin() {
			return "AUTO_INCREMENT";
		}
	};
}
