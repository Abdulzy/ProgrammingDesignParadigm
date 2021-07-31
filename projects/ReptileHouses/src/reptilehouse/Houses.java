package reptilehouse;

/**
 * An interface called Houses.
 */
public interface Houses {

  /**
   * Adds an animal to the reptile house.
   */
  void addAnimal(Animal animal);

  /**
   * Adds a habitat to the reptile house.
   */
  void addHabitat(Habitats habitat);

  /**
   * Returns the amount of habitat in reptile house.
   *
   * @return amount of habitats
   */
  int getAmountOfHabitats();

  /**
   * Returns the maximum amount of habitat in reptile house.
   *
   * @return amount of habitats
   */
  int getMaxAmountOfHabitats();

  /**
   * Report the natural features that are currently being used in alphabetical order. This list
   * should include the habitat(s) where the natural feature is located and how much space is left
   * in the habitat for additional animals measured in square meters.
   */
  String reportNaturalFeatures();

  /**
   * Look up which habitat(s) that house a particular species. If a species is found but not
   * currently inhabiting a habitat, it should report this.
   */
  String lookUp(String species);


  /**
   * Print a sign for any given habitat that lists the species that it houses along with a
   * description of the species and an indicator of how many of that species is housed in
   * that habitat. Each species description should include their name,
   * their defining characteristics, as well as
   * other interesting features (poisonous, extinct, endangered)
   */
  String printSign();

  /**
   * Print a “map” that lists all the habitats by location and the natural features in the habitat
   * and species they house.
   */
  String printMap();

  /**
   * Print an index that lists all species in the Reptile House in alphabetical order and their
   * location(s).
   */
  String printIndex();
}
