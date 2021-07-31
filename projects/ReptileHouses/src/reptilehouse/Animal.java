package reptilehouse;

/**
 * An interface called Animal.
 */
public interface Animal {

  /**
   * Returns the name of the animal.
   *
   * @return animal name
   */
  String getAnimalSpecies();

  /**
   * Returns the size of the animal.
   *
   * @return animal size
   */
  String getAnimalSize();

  /**
   * Returns the characteristics of the animal.
   *
   * @return animal characteristics
   */
  String getAnimalCharacteristics();

  /**
   * Returns the natural feature of the animal.
   *
   * @return natural feature
   */
  String getNaturalFeature();

  /**
   * Returns the lower temperature range of the animal.
   *
   * @return lower temperature
   */
  int lowerTemperature();

  /**
   * Returns the higher temperature range of the animal.
   *
   * @return higher temperature
   */
  int higherTemperature();

  /**
   * Checks if animal is poisonous, Returns boolean.
   *
   * @return poison
   */
  boolean checkPoison();

  /**
   * Checks if animal is extinct, Returns boolean.
   *
   * @return extinct
   */
  boolean checkExtinct();

  /**
   * Checks if animal is endangered, Returns boolean.
   *
   * @return endangered
   */
  boolean checkEndangered();

  /**
   * Using extinct, poisonous and endangered to find out if animal can co-exist with other animals,
   * returns boolean.
   *
   * @return co-exist
   */
  boolean coExist();
}
