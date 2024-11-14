package model;

public class SpeciesController {

	private Species[] species;
	private int speciesCount;

	public SpeciesController() {
		this.species = new Species[80];
		this.speciesCount = 0;
	}

	public boolean registerFlora(String name, String scientificName, boolean hasFlowers, boolean hasFruits, double maxHeight) {
		if (speciesCount < species.length) {
			species[speciesCount++] = new Flora(name, scientificName, hasFlowers, hasFruits, maxHeight);
			return true;
		}
		return false;
	}

	public boolean registerFauna(String name, String scientificName, boolean isMigratory, double maxWeight) {
		if (speciesCount < species.length) {
			species[speciesCount++] = new Fauna(name, scientificName, isMigratory, maxWeight);
			return true;
		}
		return false;
	}

	public boolean editFlora(int index, String name, String scientificName, boolean hasFlowers, boolean hasFruits, double maxHeight) {
		if (index >= 0 && index < speciesCount) {
			species[index] = new Flora(name, scientificName, hasFlowers, hasFruits, maxHeight);
			return true;
		}
		return false;
	}

	public boolean editFauna(int index, String name, String scientificName, boolean isMigratory, double maxWeight) {
		if (index >= 0 && index < speciesCount) {
			species[index] = new Fauna(name, scientificName, isMigratory, maxWeight);
			return true;
		}
		return false;
	}

	public boolean deleteSpecies(int index) {
		if (index >= 0 && index < speciesCount) {
			for (int i = index; i < speciesCount - 1; i++) {
				species[i] = species[i + 1];
			}
			species[--speciesCount] = null;
			return true;
		}
		return false;
	}

	public String showSpeciesList() {
		StringBuilder msg = new StringBuilder();
		for (int i = 0; i < speciesCount; i++) {
			msg.append("\n").append(i + 1).append(". ").append(species[i]);
		}
		return msg.toString();
	}
}