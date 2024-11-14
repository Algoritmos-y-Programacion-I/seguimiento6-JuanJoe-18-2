package ui;

import java.util.Scanner;
import model.SpeciesController;

public class SpeciesExecutable {

	private Scanner rd;
	private SpeciesController speciesController;

	public static void main(String[] args) {
		SpeciesExecutable exe = new SpeciesExecutable();
		exe.showMainMenu();
	}

	public SpeciesExecutable() {
		rd = new Scanner(System.in);
		speciesController = new SpeciesController();
	}

	public void showMainMenu() {
		System.out.println("Welcome to Icesi Species");

		boolean stopFlag = false;

		do {
			System.out.println("\nType an option");
			System.out.println("""
                1. Register a Species
                2. Edit a Species
                3. Delete a Species
                4. Show Species
                0. Exit
            """);

			int mainOption = rd.nextInt();

			switch (mainOption) {
				case 1:
					registerSpecies();
					break;
				case 2:
					editSpecies();
					break;
				case 3:
					deleteSpecies();
					break;
				case 4:
					showSpecies();
					break;
				case 0:
					System.out.println("Thanks for using our system");
					stopFlag = true;
					break;
				default:
					System.out.println("You must type a valid option");
					break;
			}
		} while (!stopFlag);
	}

	public void registerSpecies() {
		System.out.println("Select the type of Species to register:");
		System.out.println("""
            1. Flora
            2. Fauna
        """);
		int type = rd.nextInt();

		System.out.println("Type the new Species' name: ");
		String name = rd.next();

		System.out.println("Type the new Species' scientific name: ");
		String scientificName = rd.next();

		boolean success = false;

		switch (type) {
			case 1:
				System.out.println("Does it have flowers? (true/false): ");
				boolean hasFlowers = rd.nextBoolean();

				System.out.println("Does it have fruits? (true/false): ");
				boolean hasFruits = rd.nextBoolean();

				System.out.println("Type the maximum height: ");
				double maxHeight = rd.nextDouble();

				success = speciesController.registerFlora(name, scientificName, hasFlowers, hasFruits, maxHeight);
				break;
			case 2:
				System.out.println("Is it migratory? (true/false): ");
				boolean isMigratory = rd.nextBoolean();

				System.out.println("Type the maximum weight: ");
				double maxWeight = rd.nextDouble();

				success = speciesController.registerFauna(name, scientificName, isMigratory, maxWeight);
				break;
			default:
				System.out.println("Invalid type selected");
				break;
		}

		if (success) {
			System.out.println("Species registered successfully");
		} else {
			System.out.println("Error, Species couldn't be registered");
		}
	}

	public void editSpecies() {
		rd.nextLine();

		System.out.println("Which Species do you want to edit?");
		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);
			System.out.println("Type the number of the species to edit: ");
			int index = rd.nextInt() - 1;

			System.out.println("Select the type of Species to edit:");
			System.out.println("""
                1. Flora
                2. Fauna
            """);
			int type = rd.nextInt();

			System.out.println("Type the new Species' name: ");
			String name = rd.next();

			System.out.println("Type the new Species' scientific name: ");
			String scientificName = rd.next();

			boolean success = false;

			switch (type) {
				case 1:
					System.out.println("Does it have flowers? (true/false): ");
					boolean hasFlowers = rd.nextBoolean();

					System.out.println("Does it have fruits? (true/false): ");
					boolean hasFruits = rd.nextBoolean();

					System.out.println("Type the maximum height: ");
					double maxHeight = rd.nextDouble();

					success = speciesController.editFlora(index, name, scientificName, hasFlowers, hasFruits, maxHeight);
					break;
				case 2:
					System.out.println("Is it migratory? (true/false): ");
					boolean isMigratory = rd.nextBoolean();

					System.out.println("Type the maximum weight: ");
					double maxWeight = rd.nextDouble();

					success = speciesController.editFauna(index, name, scientificName, isMigratory, maxWeight);
					break;
				default:
					System.out.println("Invalid type selected");
					break;
			}

			if (success) {
				System.out.println("Species edited successfully");
			} else {
				System.out.println("Error, Species couldn't be edited");
			}
		} else {
			System.out.println("There aren't any species registered yet");
		}
	}

	public void deleteSpecies() {
		System.out.println("Which Species do you want to delete?");
		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);
			System.out.println("Type the number of the species to delete: ");
			int index = rd.nextInt() - 1;

			if (speciesController.deleteSpecies(index)) {
				System.out.println("Species deleted successfully");
			} else {
				System.out.println("Error, Species couldn't be deleted");
			}
		} else {
			System.out.println("There aren't any species registered yet");
		}
	}

	public void showSpecies() {
		System.out.println("List of all registered species:");
		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);
		} else {
			System.out.println("There aren't any species registered yet");
		}
	}
}