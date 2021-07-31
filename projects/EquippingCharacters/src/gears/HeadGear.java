package gears;

/**
 * This class represents the information of a head gear.
 */
public class HeadGear extends AbstractGear implements DefenseGear {
  private int defensePower;

  /**
   * The constructor of the Head gear class which calls the abstractGear class.
   *
   * @param gearsName      name of the gear
   * @param gearsAdjective adjective of the gear
   * @param wearOutValue   if the gear can be worn out
   * @param defense        the defense value for gear
   * @throws IllegalArgumentException If the defense is 0
   */
  public HeadGear(String gearsName, String gearsAdjective, boolean wearOutValue, int defense) throws IllegalArgumentException {
    super(gearsName, gearsAdjective, wearOutValue);
    if (defense == 0) {
      throw new IllegalArgumentException("Must have a positive or negative attack.");
    }
    defensePower = defense;
  }

  /**
   * Returns the defense power of the gear.
   *
   * @return defense
   */
  @Override
  public int getDefense() {
    int defense = defensePower;
    return defense;
  }

  /**
   * Returns whether the gear is a head gear or not.
   *
   * @return boolean
   */
  @Override
  public boolean areYouMe(Gear a) {
    AbstractGear aGear = (AbstractGear) a;
    return aGear.isHeadGear();
  }

  /**
   * Returns whether the gear is a head gear or not.
   *
   * @return true
   */
  @Override
  public boolean isHeadGear() {
    return true;
  }

  /**
   * Wears out the gear by 1.
   */
  @Override
  public void wearOut() {
    if (gearWearOut) {
      defensePower = defensePower - 1;
    }
  }


  /**
   * Compares two different Gear objects.
   *
   * @param o The Gear object being compared to this object.
   * @return comparison
   * @throws IllegalArgumentException If the object doesn't extend AbstractGear.
   */
  @Override
  public int compareTo(Gear o) {
    if (!(o instanceof AbstractGear)) {
      throw new IllegalArgumentException("Can't be compared");
    }
    AbstractGear aGear = (AbstractGear) o;
    return aGear.compareToHeadGear(this);
  }

  /**
   * Compares the question for two different gear objects.
   *
   * @param o The gear object being compared to this object.
   * @return comparison
   */
  @Override
  public int compareToHeadGear(Gear o) {
    HeadGear aGear = (HeadGear) o;
    if (aGear.getDefense() >= this.getDefense()) {
      return -1;
    }
    return 1;
  }

  /**
   * Returns -1, which places this gear above any foot gear.
   *
   * @param o The gear object.
   * @return -1
   */
  @Override
  public int compareToFootGear(Gear o) {
    return 1;
  }

  /**
   * Returns 1, which places this gear above any hand gear.
   *
   * @param o The gear object.
   * @return -1
   */
  @Override
  public int compareToHandGear(Gear o) {
    return 1;
  }

}
