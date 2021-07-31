package gears;

/**
 * This class represents the information of a hand gear.
 */
public class HandGear extends AbstractGear implements DefenseGear, AttackGear {
  private int attackPower;
  private int defensePower;

  public static class HandFactory {
    /**
     * Construct the attacking HandGear
     *
     * @param name      name of gear
     * @param adjective name of adjective
     * @param wearOut   if the gear can wear out
     * @param power     the power of the attack of the gear
     * @return attacking handgear
     */
    public AttackGear createAttackHandGear(String name, String adjective, boolean wearOut, int power) {
      return new HandGear(name, adjective, wearOut, power, 0);
    }

    /**
     * Construct the defending HandGear
     *
     * @param name      name of gear
     * @param adjective name of adjective
     * @param wearOut   if the gear can wear out
     * @param power     the power of the attack of the gear
     * @return defending handgear
     */
    public DefenseGear createDefenseHandGear(String name, String adjective, boolean wearOut, int power) {
      return new HandGear(name, adjective, wearOut, 0, power);
    }
  }

  /**
   * The constructor of the Hand gear class which calls the abstractGear class.
   *
   * @param gearsName      name of the gear
   * @param gearsAdjective adjective of the gear
   * @param wearOutValue   if the gear can be worn out
   * @param defense        the defense value for gear
   * @throws IllegalArgumentException If both the attack and defense values are 0.
   */
  private HandGear(String gearsName, String gearsAdjective, boolean wearOutValue, int attack, int defense) throws IllegalArgumentException {
    super(gearsName, gearsAdjective, wearOutValue);
    if ((attack == 0) && (defense == 0)) {
      throw new IllegalArgumentException("Jewelry can either be attack or defense but not both.");
    }
    attackPower = attack;
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
   * Returns whether the gear is a hand gear or not.
   *
   * @return boolean
   */
  @Override
  public boolean areYouMe(Gear a) {
    AbstractGear aGear = (AbstractGear) a;
    return aGear.isHandGear();
  }

  /**
   * Returns whether the gear is a hand gear or not.
   *
   * @return true
   */
  @Override
  public boolean isHandGear() {
    return true;
  }

  /**
   * Wears out the gear by 1.
   */
  @Override
  public void wearOut() {
    if (gearWearOut) {
      if (defensePower == 0) {
        attackPower = attackPower - 1;
      } else {
        defensePower = defensePower - 1;
      }
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
    return aGear.compareToHandGear(this);
  }

  /**
   * Compares the question for two different hand gear objects.
   *
   * @param o The Question object being compared to this object.
   * @return comparison
   */
  @Override
  public int compareToHandGear(Gear o) {
    HandGear aGear = (HandGear) o;
    if ((aGear.getAttack() >= this.getAttack()) && (aGear.getAttack() >= this.getDefense())) {
      return -1;
    } else if ((aGear.getDefense() >= this.getDefense()) && (aGear.getDefense() > this.getAttack())) {
      return -1;
    }
    return 1;
  }

}
