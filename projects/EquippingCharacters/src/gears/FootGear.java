package gears;

/**
 * This class represents the information of a foot gear.
 */
public class FootGear extends AbstractGear implements AttackGear {
  private int attackPower;

  /**
   * The constructor of the Head gear class which calls the abstractGear class.
   *
   * @param gearsName      name of the gear
   * @param gearsAdjective adjective of the gear
   * @param wearOutValue   if the gear can be worn out
   * @param attack         the defense value for gear
   * @throws IllegalArgumentException If the attack is 0
   */
  public FootGear(String gearsName, String gearsAdjective, boolean wearOutValue, int attack) throws IllegalArgumentException {
    super(gearsName, gearsAdjective, wearOutValue);
    if (attack == 0) {
      throw new IllegalArgumentException("Must have a positive or negative attack.");
    }
    attackPower = attack;
  }

  /**
   * Returns the Attack power of the gear.
   *
   * @return Attack
   */
  @Override
  public int getAttack() {
    int attack = attackPower;
    return attack;
  }

  /**
   * Returns whether the gear is a foot gear or not.
   *
   * @return boolean
   */
  @Override
  public boolean areYouMe(Gear a) {
    AbstractGear aGear = (AbstractGear) a;
    return aGear.isFootGear();
  }

  /**
   * Returns whether the gear is a foot gear or not.
   *
   * @return true
   */
  @Override
  public boolean isFootGear() {
    return true;
  }

  /**
   * Wears out the gear by a specified value.
   */
  @Override
  public void wearOut() {
    if (gearWearOut) {
      attackPower = attackPower - 1;
    }
  }

  /**
   * Compares two different gear objects.
   *
   * @param o The gear object being compared to this object.
   * @return comparison
   * @throws IllegalArgumentException If the object doesn't extend AbstractGear.
   */
  @Override
  public int compareTo(Gear o) {
    if (!(o instanceof AbstractGear)) {
      throw new IllegalArgumentException("Can't be compared");
    }
    AbstractGear aGear = (AbstractGear) o;
    return aGear.compareToFootGear(this);
  }

  /**
   * Compares the question for two different foot gear objects.
   *
   * @param o The Question object being compared to this object.
   * @return comparison
   */
  @Override
  public int compareToFootGear(Gear o) {
    FootGear aGear = (FootGear) o;
    if (aGear.getAttack() >= this.getAttack()) {
      return -1;
    }
    return 1;
  }

  /**
   * Returns 1, which places this gear above any hand gear.
   *
   * @param o The gear object.
   * @return 1
   */
  public int compareToHandGear(Gear o) {
    return 1;
  }
}
