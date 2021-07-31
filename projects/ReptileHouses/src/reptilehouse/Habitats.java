package reptilehouse;

import java.util.List;

/**
 * An interface called Habitats.
 */
public interface Habitats {
  /**
   * Adds an animal to the habitat.
   */
  void add(Animal animal);

  /**
   * Returns the name of the habitat.
   *
   * @return Habitat name
   */
  String getHabitatLocation();

  /**
   * Returns the name of the habitat.
   *
   * @return Habitat size
   */
  int getHabitatSize();

  /**
   * Returns an array of all the natural features.
   *
   * @return Natural features
   */
  List<String> naturalFeatures();

  /**
   * Returns boolean for searched species.
   *
   * @return boolean.
   */
  Boolean habitatLookUP(String s);

  /**
   * Returns a sign of the habitat.
   *
   * @return Habitat sign.
   */
  String getHabitatSign();

  /**
   * Returns an map of the habitat.
   *
   * @return Habitat map.
   */
  String getHabitatMap();

  /**
   * Returns an index of the habitat.
   *
   * @return Habitat index.
   */
  String getHabitatIndex();

}
