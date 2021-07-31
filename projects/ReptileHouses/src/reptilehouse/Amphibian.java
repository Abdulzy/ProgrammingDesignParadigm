package reptilehouse;

/**
 * Amphibian class that consist of characteristics of the amphibian.
 */
public class Amphibian implements Animal {
  private final String animalName;
  private final String animalCharacteristics;
  private final int animalSize;
  private final String naturalFeature;
  private final int lowerTemperature;
  private final int higherTemperature;
  private final Boolean poison;
  private final int extinctOrEndangered;
  private final Boolean coExist;

  /**
   * Creates an amphibian object with the information about the amphibian.
   *
   * @param name                   Species name of amphibian.
   * @param description            characteristics of reptile.
   * @param size                   Size of amphibian.
   * @param feature                Natural feature of amphibian.
   * @param lowerTemperatureRange  Lower temperature range of amphibian.
   * @param higherTemperatureRange higher temperature range of amphibian.
   * @param poisonous              If the animal is poisonous.
   * @param survivalState          Survival state of the amphibian.
   * @param shareSpace             If animal can co exist.
   * @throws IllegalArgumentException If size of the amphibian is negative.
   * @throws IllegalArgumentException If size of the amphibian greater than 3.
   * @throws IllegalArgumentException If any string has no value in it.
   * @throws IllegalArgumentException If lower temperature range  is greater than or equal to higher
   *                                  temperature range.
   * @throws IllegalArgumentException If any value is null.
   */
  public Amphibian(String name, String description, int size, String feature,
                   int lowerTemperatureRange, int higherTemperatureRange,
                   Boolean poisonous, int survivalState, Boolean shareSpace)
          throws IllegalArgumentException {
    if (name == null | description == null | feature == null
            | poisonous == null | shareSpace == null) {
      throw new IllegalArgumentException("We don't take in null values.");
    }
    if (size <= 0) {
      throw new IllegalArgumentException("Takes in only positive values between 1-3 ");
    }
    if (size > 3) {
      throw new IllegalArgumentException("Value out of range must be between 1-3 ");
    }
    if (name.isEmpty() | description.isEmpty() | feature.isEmpty()) {
      throw new IllegalArgumentException("String length must be positive");
    }
    if (lowerTemperatureRange >= higherTemperatureRange) {
      throw new IllegalArgumentException("Incorrect placement of temperature range.");
    }
    name = name.trim();
    animalName = name.toLowerCase();
    description = description.trim();
    animalCharacteristics = description.toLowerCase();
    animalSize = size;
    feature = feature.trim();
    naturalFeature = feature.toLowerCase();
    lowerTemperature = lowerTemperatureRange;
    higherTemperature = higherTemperatureRange;
    poison = poisonous;
    extinctOrEndangered = survivalState;
    coExist = shareSpace;
  }

  /**
   * Returns the species name of the animal.
   *
   * @return animal name
   */
  @Override
  public String getAnimalSpecies() {
    return animalName;
  }

  /**
   * Returns the characteristics of the animal.
   *
   * @return animal characteristics
   */
  @Override
  public String getAnimalCharacteristics() {
    return animalCharacteristics;
  }

  /**
   * Returns the size of the animal.
   *
   * @return animal size
   */
  @Override
  public String getAnimalSize() {
    if (animalSize == 1) {
      return "small";
    } else if (animalSize == 2) {
      return "medium";
    } else {
      return "large";
    }
  }

  /**
   * Returns the natural feature of the animal.
   *
   * @return natural feature
   */
  @Override
  public String getNaturalFeature() {
    return naturalFeature;
  }

  /**
   * Returns the lower temperature range of the animal.
   *
   * @return lower temperature
   */
  @Override
  public int lowerTemperature() {
    return lowerTemperature;
  }

  /**
   * Returns the higher temperature range of the animal.
   *
   * @return higher temperature
   */
  @Override
  public int higherTemperature() {
    return higherTemperature;
  }

  /**
   * Checks if animal is poisonous, Returns boolean.
   *
   * @return poison
   */
  @Override
  public boolean checkPoison() {
    return poison;
  }

  /**
   * Checks if animal is extinct, Returns boolean.
   *
   * @return extinct
   */
  @Override
  public boolean checkExtinct() {
    return (extinctOrEndangered == 1);
  }

  /**
   * Checks if animal is endangered, Returns boolean.
   *
   * @return endangered
   */
  @Override
  public boolean checkEndangered() {
    return (extinctOrEndangered == 2);
  }

  /**
   * Using poison and extinctOrEndangered to find out if animal can co-exist with other animals,
   * returns boolean.
   *
   * @return co-exist
   */
  @Override
  public boolean coExist() {
    return coExist;
  }

  /**
   * Returns the toString.
   * @return The toString of the amphibian class.
   */
  @Override
  public String toString() {
    return String.format("The %s, an amphibian. %s."
            + " Also it is %s for being poisonous,"
            + " %s for being extinct and %s for being "
            + "endangered.", animalName, animalCharacteristics,
            poison, checkExtinct(), checkEndangered());
  }
}
