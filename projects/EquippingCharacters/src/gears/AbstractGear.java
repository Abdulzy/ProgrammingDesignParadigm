package gears;

import java.util.List;

/**
 * This class represents the AbstractGear
 * which implements the gear interface that can be extended.
 */
public abstract class AbstractGear implements Gear{
  protected final String gearName;
  protected final String gearAdjective;
  protected final boolean gearWearOut;

  /**
   * The constructor of the AbstractGear class.
   * @param gearsName name of the gear
   * @param gearsAdjective adjective of the gear
   * @param wearOutValue if the gear can be worn out
   * @throws IllegalArgumentException If the gear name or adjective is a null
   * @throws IllegalArgumentException If the gear name or adjective is empty
   */
  public AbstractGear(String gearsName, String gearsAdjective,  boolean wearOutValue) throws IllegalArgumentException {
    if (gearsName == null | gearsAdjective == null){
      throw new IllegalArgumentException("Null values aren't allowed");
    }
    if (gearsName.trim().isEmpty() | gearsAdjective.trim().isEmpty()) {
      throw new IllegalArgumentException("Didn't put in a gear name and gear adjective");
    }
    this.gearName = gearsName.toLowerCase().trim();
    this.gearAdjective = gearsAdjective.toLowerCase().trim();
    this.gearWearOut = wearOutValue;
  }


  /**
   * Returns the name of the gear.
   *
   * @return name
   */
  @Override
  public String getName() {
    return gearName;
  }

  /**
   * Returns the adjective of the gear.
   *
   * @return adjective
   */
  @Override
  public String getAdjective() {
    return gearAdjective;
  }


  /**
   * Returns the combined string of all the gears.
   * @param a a list of abstractGears.
   * @return combined string
   */
  @Override
  public String combineName(List<AbstractGear> a){
    StringBuilder combinedName = new StringBuilder();
    for(int i = 0; i < a.size(); i++){
      if(i == 0) {
        combinedName.append(a.get(0).toString());
      }
      else if(a.size() > 1){
        if(i == a.size()-1){
          combinedName.append(", and ").append(a.get(i).getAdjective());
        }
      }
      else {
        combinedName.append(", ").append(a.get(i).getAdjective());
      }

    }
    return combinedName.toString();
  }

  /**
   * Returns the combined attack of all the gears.
   * @param a a list of abstractGears.
   * @return combined attack
   */
  @Override
  public int combineAttackPower(List<AbstractGear> a){
    int combinedPower = 0;
    for(AbstractGear i : a){
      if(i instanceof AttackGear){
        combinedPower = combinedPower + ((AttackGear) i).getAttack();
      }
    }
    return combinedPower;
  }

  /**
   * Returns the combined defense of all the gears.
   * @param a a list of abstractGears.
   * @return combined defense
   */
  @Override
  public int combineDefensePower(List<AbstractGear> a){
    int combinedPower = 0;
    for(AbstractGear i : a){
      if(i instanceof DefenseGear){
        combinedPower = combinedPower + ((DefenseGear) i).getDefense();
      }
    }
    return combinedPower;
  }

  /**
   * Returns whether the gear is a head gear or not.
   * @return false
   */
  @Override
  public boolean isHeadGear(){
    return false;
  }

  /**
   * Returns whether the gear is a foot gear or not.
   * @return false
   */
  @Override
  public boolean isFootGear(){
    return false;
  }

  /**
   * Returns whether the gear is a hand gear or not.
   * @return false
   */
  @Override
  public boolean isHandGear(){
    return false;
  }

  /**
   * Returns whether the gear is a jewelry or not.
   * @return false
   */
  @Override
  public boolean isJewelry(){
    return false;
  }

  /**
   * Returns -1, which places any gear below it.
   *
   * @param o The gear object.
   * @return -1
   */
  public int compareToHeadGear(Gear o) {
    return -1;
  }

  /**
   * Returns -1, which places any gear below it.
   *
   * @param o The gear object.
   * @return -1
   */
  public int compareToFootGear(Gear o) {
    return -1;
  }

  /**
   * Returns -1, which places any gear below it.
   *
   * @param o The gear object.
   * @return -1
   */
  public int compareToHandGear(Gear o) {
    return -1;
  }

  /**
   * Returns 1, which places any gear above it.
   *
   * @param o The gear object.
   * @return 1
   */
  public int compareToJewelry(Gear o) {
    return 1;
  }

  /**
   * Returns the toString.
   *
   * @return toString
   */
  @Override
  public String toString() {
    return String.format("%s of %s",getName(),getAdjective());
  }
}
