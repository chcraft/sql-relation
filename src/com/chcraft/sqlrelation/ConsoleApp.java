package com.chcraft.sqlrelation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.chcraft.sqlrelation.entity.Column;
import com.chcraft.sqlrelation.entity.ColumnOption;
import com.chcraft.sqlrelation.entity.Entity;
import com.chcraft.sqlrelation.relation.Relation;
import com.chcraft.sqlrelation.relation.RelationType;

public class ConsoleApp {
	private static List<EntityRelationshipModel> models = new ArrayList<EntityRelationshipModel>();
	private static List<Entity> entities = new ArrayList<>();
	private static List<Relation> relations = new ArrayList<>();

	private static Scanner sc = new Scanner(System.in);

	private static final int INVALID_COMMAND = 0;
	private static final int SHOW_ERM_COMMAND = 1;
	private static final int CREATE_ERM_COMMAND = 2;
	private static final int MODIFY_ERM_COMMAND = 3;
	private static final int QUIT_COMMAND = 4;

	public static void main(String[] args) {
		//add entity and relations for test
		Entity student = new Entity("student");
		Entity school = new Entity("school");

		Column id = new Column("id", "INT");
		id.addOption(ColumnOption.PK);
		id.addOption(ColumnOption.AI);
		Column name = new Column("name", "VARCHAR(50)");
		name.addOption(ColumnOption.NN);

		Relation studentSchool = new Relation(student, school, RelationType.MANY_TO_ONE);

		entities.add(student);
		entities.add(school);
		relations.add(studentSchool);

		System.out.println("SQL RELATION MODEL MAKER(demo)");
		System.out.println();
		int command;
		while (true) {
			showMainCommandList();
			command = readCommand();
			if (!executeCommand(command))
				break;
		}
		System.out.println("Bye~");
	}

	private static boolean executeCommand(int command) {
		// TODO : Add more case
		switch (command) {
		case INVALID_COMMAND:
			System.out.println("invalid command");
			return true;
		case SHOW_ERM_COMMAND:
			showModels();
			return true;
		case CREATE_ERM_COMMAND:
			createERMCommand();
			return true;
		case MODIFY_ERM_COMMAND:
			modifyERMCommand();
			return true;
		case QUIT_COMMAND:
			return false;
		}
		return true;
	}

	private static void showMainCommandList() {
		System.out.println("--COMMANDS---------------------------------");
		System.out.println("|1. Show Entity Relationship Model List   |");
		System.out.println("|2. Create New Entity Relationship Model  |");
		System.out.println("|3. Modify Entity Relationship Model      |");
		System.out.println("|4. Quit                                  |");
		System.out.println("-------------------------------------------");
	}

	private static void showModifyERMCommandList() {
		System.out.println("--COMMANDS---------------------------------");
		System.out.println("|1. Change Name                           |");
		System.out.println("|2. Add Entity      3. Remove Entity      |");
		System.out.println("|4. Add Relation    5. Remove Relation    |");
		System.out.println("|6. Quit                                  |");
		System.out.println("-------------------------------------------");
	}

	private static int readCommand() {
		String input;
		input = sc.next();

		int command = 0;

		try {
			command = Integer.parseInt(input);
		} catch (NumberFormatException nfe) {
			command = 0;
		}

		return command;
	}

	private static void createERMCommand() {
		int SAVE = 1;
		int QUIT_WITHOUT_SAVE = 2;

		EntityRelationshipModel model = new EntityRelationshipModel();
		System.out.print("model name:");
		String name = sc.next();
		model.setName(name);
		models.add(model);
		modifyERMCommand(name);

		// save or quit without save
		while (true) {
			System.out.println("--COMMANDS---------------------------------");
			System.out.println("|1. Save          2. Quit without save    |");
			System.out.println("-------------------------------------------");
			int command = readCommand();
			if (command == SAVE) {
				if(models.add(model)) {
					System.out.println("save success");
				} else {
					System.out.println("fail to save");
				}
				return;
			} else if (command == QUIT_WITHOUT_SAVE) {
				System.out.println("quit without save");
				models.remove(model);
				return;
			} else {
				System.out.println("invalid command");
			}
		}
	}

	private static void modifyERMCommand() {
		System.out.println("Select Entity Relationship Model by Name");
		showModels();
		String name;
		name = sc.next();
		modifyERMCommand(name);
	}

	// TODO : method not implemented
	private static void modifyERMCommand(String name) {
		final int CHANGE_NAME = 1;
		final int ADD_ENTITY = 2;
		final int REMOVE_ENTITY = 3;
		final int ADD_RELATION = 4;
		final int REMOVE_RELATION = 5;
		final int QUIT = 6;

		//find from models
		EntityRelationshipModel model = getModel(name);

		// 1. select modify command(change name, add entity, remove entity, add relation, remove relation, quit)
		showModifyERMCommandList();
		int command = readCommand();
		Entity entity;
		Relation relation;

		// 2. execute command
		switch(command) {
		case CHANGE_NAME:
			String newName = sc.next();
			model.setName(newName);
			break;
		case ADD_ENTITY:
			//1. show exist entity list
			showExistEntities();
			//2. select entity and add to model
			entity = selectEntity(entities);
			if(entity != null)
				model.addEntity(entity);
			break;
		case REMOVE_ENTITY:
			//1. show exist entity list
			showExistEntities(model.getEntities());
			//2. select entity and remove from model
			entity = selectEntity(model.getEntities());
			if(entity != null)
				model.removeEntity(entity);
			break;
		case ADD_RELATION:
			//1. show exist relation list
			showExistRelations();
			//2. select relation and add to model
			relation = selectRelation(relations);
			if(relation != null)
				model.addRelation(relation);
			break;
		case REMOVE_RELATION:
			//1. show exist relation list
			showExistRelations(model.getRelations());
			//2. select relation and remove from model
			relation = selectRelation(model.getRelations());
			if(relation != null)
				model.removeRelation(relation);
			break;
		case QUIT:
			return;
		}
	}

	private static Entity selectEntity(List<Entity> entities) {
		if(entities.size() == 0)
			return null;

		while(true) {
			int index = readCommand();
			if(index <= 0 || index > entities.size()) {
				System.out.println("out of range");
			}

			return entities.get(index - 1);
		}
	}

	private static void showExistEntities(List<Entity> entities) {
		System.out.println("Entity List");
		for(int i = 0; i < entities.size(); i++) {
			System.out.printf("%d. %s\n", i + 1, entities.get(i).toString());
		}

	}

	private static void showExistEntities() {
		showExistEntities(entities);
	}

	private static EntityRelationshipModel getModel(String name) {
		// TODO Auto-generated method stub
		for(EntityRelationshipModel model : models) {
			if(model.getName().equals(name))
				return model;
		}

		return null;
	}

	private static void showExistRelations() {
		showExistRelations(relations);
	}

	private static void showExistRelations(List<Relation> relations) {
		System.out.println("Relation List");
		for(int i = 0; i < relations.size(); i++) {
			System.out.printf("%d. %s\n", i + 1, relations.get(i).toString());
		}
	}

	private static Relation selectRelation(List<Relation> relations) {
		if(relations.size() == 0)
			return null;

		while(true) {
			int index = readCommand();
			if(index <= 0 || index > relations.size()) {
				System.out.println("out of range");
			}

			return relations.get(index - 1);
		}
	}

	private static void showModels() {
		for (EntityRelationshipModel model : models) {
			System.out.println("-" + model.getName());
		}
	}
}
