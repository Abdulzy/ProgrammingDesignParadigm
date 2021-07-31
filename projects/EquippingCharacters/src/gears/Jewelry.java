package gears;

public class Jewelry extends AbstractGear implements DefenseGear, AttackGear {
  private int attackPower;
  private int defensePower;

  public static class JewelryFactory {
    /**
     * Construct the attacking Jewelry
     *
     * @param name      name of gear
     * @param adjective name of adjective
     * @param wearOut   if the gear can wear out
     * @param power     the power of the attack of the gear
     * @return attacking Jewelry
     */
    public AttackGear createAttackJewelry(String name, String adjective, boolean wearOut, int power) {
      return new Jewelry(name, adjective, wearOut, power, 0);
    }

    /**
     * Construct the defending Jewelry
     *
     * @param name      name of gear
     * @param adjective name of adjective
     * @param wearOut   if the gear can wear out
     * @param power     the power of the attack of the gear
     * @return defending Jewelry
     */
    public DefenseGear createDefenseJewelry(String name, String adjective, boolean wearOut, int power) {
      return new Jewelry(name, adjective, wearOut, 0, power);
    }
  }

  private Jewelry(String gearsName, String gearsAdjective, boolean wearOutValue, int attack, int defense) throws IllegalArgumentException {
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
   * Returns whether the gear is a jewelry or not.
   *
   * @return boolean
   */
  @Override
  public boolean areYouMe(Gear a) {
    AbstractGear aGear = (AbstractGear) a;
    return aGear.isJewelry();
  }

  /**
   * Returns whether the gear is a jewelry or not.
   *
   * @return true
   */
  @Override
  public boolean isJewelry() {
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
   * Compares two different Gear objects.
   *
   * @param o The Question object being compared to this object.
   * @return comparison
   * @throws IllegalArgumentException If the object doesn't extend AbstractQuestion.
   */
  @Override
  public int compareTo(Gear o) {
    if (!(o instanceof AbstractGear)) {
      throw new IllegalArgumentException("Can't be compared");
    }
    AbstractGear aGear = (AbstractGear) o;
    return aGear.compareToJewelry(this);
  }

  /**
   * Compares the question for two different jewelry objects.
   *
   * @param o The Question object being compared to this object.
   * @return comparison
   */
  @Override
  public int compareToJewelry(Gear o) {
    Jewelry aGear = (Jewelry) o;
    if ((aGear.getAttack() >= this.getAttack()) && (aGear.getAttack() >= this.getDefense())) {
      return -1;
    } else if ((aGear.getDefense() >= this.getDefense()) && (aGear.getDefense() > this.getAttack())) {
      return -1;
    }
    return 1;
  }
}
