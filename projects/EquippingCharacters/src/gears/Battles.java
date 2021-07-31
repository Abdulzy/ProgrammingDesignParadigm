package gears;

/**
 * This is a battle interface.
 */
public interface Battles {

  /**
   * Adds head gear to chest options.
   *
   * @param o headgear object
   */
  void addHeadGear(Gear o);

  /**
   * Adds hand gear to chest options.
   *
   * @param o footgear object
   */
  void addFootGear(Gear o);

  /**
   * Adds hand gear to chest options.
   *
   * @param o handgear object
   */
  void addHandGear(Gear o);

  /**
   * Adds hand gear to chest options.
   *
   * @param o jewelry object
   */
  void addJewelry(Gear o);

  /**
   * predicts the fight between two characters.
   */
  void predict();
}
