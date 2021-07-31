package gears;

import java.util.List;

/**
 * This is a gear interface.
 */
public interface Gear extends Comparable<Gear> {

  /**
   * Returns the name of the gear.
   *
   * @return name
   */
  String getName();

  /**
   * Returns the adjective of the gear.
   *
   * @return adjective
   */
  String getAdjective();

  /**
   * Wears out the gear by a specified value by the user.
   */
  void wearOut();

  /**
   * Returns the combined string of all the gears.
   *
   * @param a
   * @return combined string
   */
  String combineName(List<AbstractGear> a);

  /**
   * Returns the combined attack of all the gears.
   *
   * @param a
   * @return combined power
   */
  int combineAttackPower(List<AbstractGear> a);

  /**
   * Returns the combined defense of all the gears.
   *
   * @param a
   * @return combined power
   */
  int combineDefensePower(List<AbstractGear> a);

  /**
   * Returns whether the gear is a hand gear or not.
   *
   * @return boolean
   */
  boolean areYouMe(Gear a);

  /**
   * Returns whether the gear is a head gear or not.
   *
   * @return boolean
   */
  boolean isHeadGear();

  /**
   * Returns whether the gear is a foot gear or not.
   *
   * @return boolean
   */
  boolean isFootGear();

  /**
   * Returns whether the gear is a hand gear or not.
   *
   * @return boolean
   */
  boolean isHandGear();

  /**
   * Returns whether the gear is a jewelry or not.
   *
   * @return boolean
   */
  boolean isJewelry();

}
