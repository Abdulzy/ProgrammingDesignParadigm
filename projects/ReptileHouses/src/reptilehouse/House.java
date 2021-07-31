package reptilehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Houses class that consist of characteristics of the reptile house.
 */
public class House implements Houses {
  private List<Animal> homelessAnimals;
  private List<Habitats> habitats;
  private final int maxAmountHabitat;

  /**
   * Creates a house object with the information about the reptile house.
   * @param size Max amount of habitats.
   * @throws IllegalArgumentException If the size is non positive.
   */
  public House(int size) throws IllegalArgumentException {
    if (size <= 0) {
      throw new IllegalArgumentException("Takes in only non negative ");
    }
    homelessAnimals = new ArrayList<>();
    habitats = new ArrayList<>();
    maxAmountHabitat = size;
  }

  /**
   * Adds an animal to the reptile house. If it can't be added to a
   * habitat it is added to homeless animals.
   * @param animal The animal object.
   * @throws IllegalArgumentException If the animal can't be added to a habitat but it is caught.
   * @throws IllegalArgumentException If any value is null.
   */
  @Override
  public void addAnimal(Animal animal) throws IllegalArgumentException {
    if (animal == null) {
      throw new IllegalArgumentException("We don't take in null values.");
    }
    if (animal.checkExtinct()) {
      throw new IllegalArgumentException("Animal is extinct, cannot be added.");
    }
    if (habitats.isEmpty()) {
      throw new IllegalArgumentException("There are no habitat in the reptile house. ");
    }
    boolean added = false;
    for (Habitats habitat : habitats) {
      try {
        if (!added) {
          habitat.add(animal);
          added = true;
        } else {
          break;
        }
      } catch (IllegalArgumentException ex) {
        //Catches the exception and continues to try and add the animal into other habitats.
      }
    }
    if (!added) {
      homelessAnimals.add(animal);
    }
  }

  /**
   * Adds a habitat to the reptile house.
   * @param habitat The habitat object.
   * @throws IllegalArgumentException If the habitat is at it's max.
   * @throws IllegalArgumentException If any value is null.
   */
  @Override
  public void addHabitat(Habitats habitat) throws IllegalArgumentException {
    if (habitat == null) {
      throw new IllegalArgumentException("We don't take in null values.");
    }
    if (habitats.size() >= maxAmountHabitat) {
      throw new IllegalArgumentException("Habitat has reached it's max.");
    }
    habitats.add(habitat);
  }

  /**
   * Returns the amount of habitat in reptile house.
   *
   * @return amount of habitats
   */
  @Override
  public int getAmountOfHabitats() {
    return habitats.size();
  }

  /**
   * Returns the maximum amount of habitat in reptile house.
   *
   * @return amount of habitats
   */
  @Override
  public int getMaxAmountOfHabitats() {
    return maxAmountHabitat;
  }

  /**
   * Report the natural features that are currently being used in alphabetical order. This list
   * should include the habitat(s) where the natural feature is located and how much space is left
   * in the habitat for additional animals measured in square meters.
   */
  @Override
  public String reportNaturalFeatures() throws IllegalArgumentException {
    if (habitats.isEmpty()) {
      throw new IllegalArgumentException("There are no habitats.");
    }
    StringBuilder report = new StringBuilder("All natural features are listed below:\n");
    for (Habitats habitat : habitats) {
      report.append(habitat.toString());
    }
    return report.toString();
  }


  /**
   * Looks for the species in reptile house.
   * @param species The species name.
   * @return string The location of the species.
   * @throws IllegalArgumentException If there was no written name.
   * @throws IllegalArgumentException If any value is null.
   */
  @Override
  public String lookUp(String species) throws IllegalArgumentException {
    if (species == null) {
      throw new IllegalArgumentException("We don't take in null values.");
    }
    if (species.length() <= 0) {
      throw new IllegalArgumentException("No species name inputed.");
    }
    String speciesName = species.trim();
    speciesName = speciesName.toLowerCase();
    StringBuilder looked = new StringBuilder();
    boolean found = false;
    for (Habitats habitat : habitats) {
      if (found && habitat.habitatLookUP(speciesName)) {
        looked.append(String.format("%s\n", habitat.getHabitatLocation()));
      } else if (habitat.habitatLookUP(speciesName)) {
        looked.append(String.format("The %s can be found in:\n%s\n", speciesName,
                habitat.getHabitatLocation()));
        found = true;
      }
    }
    for (Animal homelessAnimal : homelessAnimals) {
      if (speciesName.equals(homelessAnimal.getAnimalSpecies())) {
        looked.append(String.format("The %s is also outside a habitat "
                + "but in the reptile house.", speciesName));
        return looked.toString();
      }
    }
    if (!found) {
      looked.append(String.format("The %s is currently not in the reptile house.", speciesName));
      return looked.toString();
    }
    return looked.toString();
  }

  /**
   * Print a sign for any given habitat that lists the species that it houses along with a
   * description of the species and an indicator of how many of that species is housed in that
   * habitat. Each species description should include their name, their defining characteristics, as
   * well as other interesting features (poisonous, extinct, endangered)
   */
  @Override
  public String printSign() throws IllegalArgumentException {
    if (habitats.isEmpty()) {
      throw new IllegalArgumentException("There are no habitats.");
    }
    StringBuilder sign = new StringBuilder("These are the signs for each habitat:\n");
    for (Habitats habitat : habitats) {
      sign.append(habitat.getHabitatSign());
    }
    return sign.toString();
  }


  /**
   * Print a “map” that lists all the habitats by location and the natural features in the habitat
   * and species they house.
   */
  @Override
  public String printMap() throws IllegalArgumentException {
    if (habitats.isEmpty()) {
      throw new IllegalArgumentException("There are no habitats.");
    }
    StringBuilder map = new StringBuilder("This is a map that list are "
            + "all the habitats by location and the natural "
            + "features in the habitat and species they house:\n");
    for (Habitats habitat : habitats) {
      map.append(habitat.getHabitatMap());
    }
    return map.toString();
  }

  /**
   * Print an index that lists all species in the Reptile House in alphabetical order and their
   * location(s).
   */
  @Override
  public String printIndex() throws IllegalArgumentException {
    if (habitats.isEmpty()) {
      throw new IllegalArgumentException("There are no habitats.");
    }
    StringBuilder index = new StringBuilder("These are all the "
            + "index of species in each of their habitats:\n");
    for (Habitats habitat : habitats) {
      index.append(habitat.getHabitatIndex());
    }
    return index.toString();
  }

  /**
   * Returns the toString.
   * @return The toString of the House class.
   */
  @Override
  public String toString() {
    if (habitats.isEmpty()) {
      return "There are no animals in reptile House.\n";
    }
    return String.format("The reptile House has %s habitat(s) with %s homeless animals."
            + "space left.\n", maxAmountHabitat, homelessAnimals.size());
  }
}
