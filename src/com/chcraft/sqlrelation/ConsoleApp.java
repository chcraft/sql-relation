package com.chcraft.sqlrelation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
	public static void main(String[] args) {
		List<EntityRelationshipModel> models = new ArrayList<EntityRelationshipModel>();

		System.out.println("SQL RELATION MODEL MAKER");
		System.out.println();
		while(true) {
			int command;
			showCommandList();
			command = readCommand();
			if(!executeCommand(command))
				break;
		}
		System.out.println("Bye~");
	}

	private static boolean executeCommand(int command) {
		switch(command) {
		case 1:
			return true;
		case 2:
			return true;
		case 3:
			return true;
		case 4:
			return false;
		}
		System.out.println("invalid command");
		return true;
	}

	private static void showCommandList() {
		System.out.println("--COMMANDS---------------------------------");
		System.out.println("|1. Show Entity Relationship Model List   |");
		System.out.println("|2. Create New Entity Relationship Model  |");
		System.out.println("|3. Modify Entity Relationship Model      |");
		System.out.println("|4. Quit                                  |");
		System.out.println("-------------------------------------------");
	}

	private static int readCommand() {
		int input = 0;

		try(Scanner sc = new Scanner(System.in);){
			input = sc.nextInt();
		}

		return input;
	}
}
