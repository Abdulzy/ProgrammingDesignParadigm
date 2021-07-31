package reptilehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Habitat class that consist of characteristics of the habitat.
 */
public class Habitat implements Habitats {
  private List<Animal> inhabitants;
  private final String habitatLocation;
  private final int habitatSize;
  private int remainingSize;
  private List<String> naturalFeature;

  /**
   * Creates a habitat object with the information about the habitat.
   *
   * @param location The name of the habitat's location.
   * @param size     The size of the habitat.
   * @throws IllegalArgumentException If size of the habitat is negative.
   * @throws IllegalArgumentException If any string has no value in it.
   * @throws IllegalArgumentException If any value is null.
   */
  public Habitat(String location, int size) throws IllegalArgumentException {
    if (location == null) {
      throw new IllegalArgumentException("We don't take in null values.");
    }
    if (size <= 0) {
      throw new IllegalArgumentException("Takes in only positive values");
    }
    if (location.length() <= 0) {
      throw new IllegalArgumentException("String length must be positive");
    }
    location = location.trim();
    habitatLocation = location.toLowerCase();
    habitatSize = size;
    remainingSize = size;
    inhabitants = new ArrayList<>();
    naturalFeature = new ArrayList<>();
  }

  /**
   * Adds an animal to the habitat.
   *
   * @param animal The animal object.
   * @throws IllegalArgumentException If animal is extinct.
   * @throws IllegalArgumentException If animal can't co-exist.
   * @throws IllegalArgumentException If animal being added has a different type compared to the
   *                                  animal currently in the habitat.
   * @throws IllegalArgumentException If the animal has no overlapping temperature ranges with any
   *                                  animal in the habitat.
   * @throws IllegalArgumentException If animal natural feature is not part of the habitat and it
   *                                  cannot be added.
   * @throws IllegalArgumentException If there is no space of the animal.
   * @throws NullPointerException If any value is null.
   */
  @Override
  public void add(Animal animal) throws IllegalArgumentException {
    if (animal == null) {
      throw new IllegalArgumentException("We don't take in null values.");
    }
    if (!(inhabitants.isEmpty())) {
      if (!(inhabitants.get(0).coExist())) {
        throw new IllegalArgumentException("Animal can't CoExist");
      }
      if (!(animal.coExist())) {
        throw new IllegalArgumentException("Animal can't CoExist");
      }
    }
    if (!(checkCompatability(animal))) {
      throw new IllegalArgumentException("Amphibians can't live with reptiles and vice versa.");
    }
    if (!(checkTemperatureRange(animal))) {
      throw new IllegalArgumentException("Temperature ranges don't overlap");
    }
    if (!(checkNaturalFeature(animal))) {
      throw new IllegalArgumentException("Animal feature does not exist and cannot be added.");
    }
    if (!(checkSize(animal))) {
      throw new IllegalArgumentException("No space for animal");
    }

    inhabitants.add(animal);
    if (!(naturalFeature.contains(animal.getNaturalFeature()))) {
      naturalFeature.add(animal.getNaturalFeature());
    }
  }

  /**
   * Checks if animal being added is the same type of species in habitat.
   *
   * @param a Animal object.
   * @return boolean
   */
  private boolean checkCompatability(Animal a) {
    if (inhabitants.isEmpty()) {
      return true;
    }
    Animal test = inhabitants.get(0);
    if (test instanceof Reptile && a instanceof Reptile) {
      return true;
    }
    return test instanceof Amphibian && a instanceof Amphibian;
  }

  /**
   * Checks if there is space for the animal to be added into.
   *
   * @param a Animal object
   * @return boolean
   */
  private boolean checkSize(Animal a) {
    int animalSize = 0;
    switch (a.getAnimalSize()) {
      case "small":
        animalSize = 1;
        break;
      case "medium":
        animalSize = 5;
        break;
      case "large":
        animalSize = 10;
        break;
      default :
        break;
    }
    if (animalSize > remainingSize) {
      return false;
    }
    remainingSize = remainingSize - animalSize;
    return true;
  }

  /**
   * Checks if animal temperature ranges overlap.
   *
   * @param a Animal object.
   * @return boolean
   */
  private boolean checkTemperatureRange(Animal a) {
    if (inhabitants.isEmpty()) {
      return true;
    }
    for (Animal inhabitant : inhabitants) {
      if ((a.lowerTemperature() >= inhabitant.lowerTemperature())
              && (a.lowerTemperature() <= inhabitant.higherTemperature())) {
        return true;
      }
      if ((a.higherTemperature() <= inhabitant.higherTemperature())
              && (a.higherTemperature() >= inhabitant.lowerTemperature())) {
        return true;
      }
      if ((inhabitant.lowerTemperature() >= a.lowerTemperature())
              && (inhabitant.lowerTemperature() <= a.higherTemperature())) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks if animal natural features exist in habitat.
   *
   * @param a Animal object.
   * @return boolean
   */
  private boolean checkNaturalFeature(Animal a) {
    if (inhabitants.isEmpty()) {
      return true;
    }
    if (naturalFeature.contains(a.getNaturalFeature())) {
      return true;
    }
    if (!(naturalFeature.contains(a.getNaturalFeature()))) {
      if (naturalFeature.size() < 3) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the name of the habitat.
   *
   * @return Habitat name
   */
  @Override
  public String getHabitatLocation() {
    return habitatLocation;
  }

  /**
   * Returns the name of the habitat.
   *
   * @return Habitat size
   */
  @Override
  public int getHabitatSize() {
    return habitatSize;
  }


  /**
   * Returns an array of all the natural features.
   *
   * @return Natural features
   */
  @Override
  public List<String> naturalFeatures() {
    return naturalFeature;
  }


  /**
   * Returns boolean for searched species.
   *
   * @return boolean.
   * @throws IllegalArgumentException If string has no value.
   * @throws NullPointerException If any value is null.
   */
  @Override
  public Boolean habitatLookUP(String s) throws IllegalArgumentException {
    if (s == null) {
      throw new IllegalArgumentException("We don't take in null values.");
    }
    if (s.isEmpty()) {
      throw new IllegalArgumentException("No species name input.");
    }
    String species = s.trim();
    species = species.toLowerCase();
    for (Animal inhabitant : inhabitants) {
      if (inhabitant.getAnimalSpecies().equals(species)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns a sign of the habitat.
   *
   * @return Habitat sign.
   */
  @Override
  public String getHabitatSign() {
    if (inhabitants.isEmpty()) {
      return "There are no animals in " + habitatLocation + " habitat.\n";
    }
    StringBuilder sign = new StringBuilder(String.format("The Habitat "
            + "sign of %s:\n", habitatLocation));
    for (int i = 0; i < inhabitants.size(); i++) {
      int count = 0;
      for (Animal inhabitant : inhabitants) {
        if (inhabitants.get(i).getAnimalSpecies().equals(inhabitant.getAnimalSpecies())) {
          count++;
        }
      }
      sign.append(String.format("There are %s amount of %s.\n",
              count, inhabitants.get(i).getAnimalSpecies()));
    }
    for (Animal inhabitant : inhabitants) {
      sign.append(inhabitant.toString()).append("\n");
    }
    return sign.toString();
  }

  /**
   * Returns an map of the habitat.
   *
   * @return Habitat map.
   */
  @Override
  public String getHabitatMap() {
    if (inhabitants.isEmpty()) {
      return "There are no animals in " + habitatLocation + " habitat.\n";
    }
    String map = String.format("This is the map of the Habitat at %s:\n"
            + "Natural features:\n%s.\n"
            + "Species:\n", habitatLocation, naturalFeature);
    List<String> names = new ArrayList<>();
    for (Animal inhabitant : inhabitants) {
      names.add(inhabitant.getAnimalSpecies());
    }
    map = map + String.format("%s.\n", names);
    return map;
  }

  /**
   * Returns an index of the habitat.
   *
   * @return Habitat index.
   */
  @Override
  public String getHabitatIndex() {
    if (inhabitants.isEmpty()) {
      return "There are no animals in " + habitatLocation + " habitat.\n";
    }
    String index = "";
    List<String> names = new ArrayList<>();
    for (Animal inhabitant : inhabitants) {
      names.add(inhabitant.getAnimalSpecies());
    }
    Collections.sort(names);
    index = index + String.format("The Habitat located at %s has the following animal "
            + "species:\n%s.\n", habitatLocation, names);

    return index;
  }

  /**
   * Returns the toString.
   * @return The toString of the Habitat class.
   */
  @Override
  public String toString() {
    if (inhabitants.isEmpty()) {
      return "There are no animals in " + habitatLocation + " habitat.\n";
    }
    Collections.sort(naturalFeature);
    return String.format("The Habitat located at %s has %s with %s square meter "
            + "space left.\n", habitatLocation, naturalFeature, remainingSize);
  }
}
