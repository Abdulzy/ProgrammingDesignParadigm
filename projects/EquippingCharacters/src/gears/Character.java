package gears;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * This class represents the information of a character.
 */
public class Character implements Characters {
  private final String cName;
  private final int chitPoint;
  private final int cAttack;
  private final int cDefense;
  private int modifiedAttack;
  private int modifiedDefense;
  private final DefenseGear dummyHead;
  private final AttackGear dummyFoot;
  private final AttackGear dummyHand;
  private final AttackGear dummyJewel;
  private final List<AbstractGear> headGears;
  private final List<AbstractGear> footGears;
  private final List<AbstractGear> handGears;
  private final List<AbstractGear> jewelrys;

  /**
   * The constructor of the Character class.
   *
   * @param cName     character name
   * @param chitPoint character hitpoint
   * @param cAttack   character attack
   * @param cDefense  character defense
   * @throws IllegalArgumentException if the character name is null
   * @throws IllegalArgumentException if the character name is empty
   * @throws IllegalArgumentException if the character hitpoint, attack and defense are non
   *                                  positive
   */
  public Character(String cName, int chitPoint, int cAttack, int cDefense) throws IllegalArgumentException {
    if (cName == null) {
      throw new IllegalArgumentException("Character name is needed");
    }
    if (cName.trim().isEmpty()) {
      throw new IllegalArgumentException("Character name is needed");
    }
    if (cAttack <= 0 | cDefense <= 0 | chitPoint <= 0) {
      throw new IllegalArgumentException("Character must have a "
              + "positive hitpoint, defense and attack power");
    }
    this.cName = cName.trim().toLowerCase();
    this.chitPoint = chitPoint;
    this.cAttack = cAttack;
    this.cDefense = cDefense;
    modifiedAttack = cAttack;
    modifiedDefense = cDefense;
    headGears = new ArrayList<>();
    footGears = new ArrayList<>();
    handGears = new ArrayList<>();
    jewelrys = new ArrayList<>();
    dummyHead = new HeadGear("Helm", "Flight", false, 50);
    dummyFoot = new FootGear("Boots", "Electricity", true, 100);
    dummyHand = new HandGear.HandFactory().createAttackHandGear("Ring", "Shock", true, 100);
    dummyJewel = new Jewelry.JewelryFactory().createAttackJewelry("amulet", "Shock", true, 100);
  }

  /**
   * Returns the name of the character.
   *
   * @return name
   */
  @Override
  public String getName() {
    return cName;
  }

  /**
   * Returns the base hitpoint of the character.
   *
   * @return hitpoint
   */
  @Override
  public int getHitPoint() {
    return chitPoint;
  }

  /**
   * Returns the attack of the character.
   *
   * @return attack
   */
  @Override
  public int getBaseAttack() {
    return cAttack;
  }

  /**
   * Returns the defense of the character.
   *
   * @return defense
   */
  @Override
  public int getBaseDefense() {
    return cDefense;
  }

  /**
   * Returns the attack of the character plus the attack of the gear.
   *
   * @return attack
   */
  @Override
  public int getModifiedAttack() {
    modifiedAttack = cAttack;
    if (!(footGears.isEmpty())) {
      modifiedAttack = modifiedAttack + footGears.get(0).combineAttackPower(footGears);
    }
    if (!(handGears.isEmpty())) {
      modifiedAttack = modifiedAttack + handGears.get(0).combineAttackPower(handGears);
    }
    if (!(jewelrys.isEmpty())) {
      modifiedAttack = modifiedAttack + jewelrys.get(0).combineAttackPower(jewelrys);
    }
    return modifiedAttack;
  }

  /**
   * Returns the defense of the character plus the defense of the gear.
   *
   * @return defense
   */
  @Override
  public int getModifiedDefense() {
    modifiedDefense = cDefense;
    if (!(headGears.isEmpty())) {
      modifiedDefense = modifiedDefense + headGears.get(0).combineDefensePower(headGears);
    }
    if (!(handGears.isEmpty())) {
      modifiedDefense = modifiedDefense + handGears.get(0).combineDefensePower(handGears);
    }
    if (!(jewelrys.isEmpty())) {
      modifiedDefense = modifiedDefense + jewelrys.get(0).combineDefensePower(jewelrys);
    }
    return modifiedDefense;
  }

  /**
   * Equips the character with a gear.
   *
   * @param o Gear
   */
  public void equip(Gear o) {
    if (!(o instanceof AbstractGear)) {
      throw new IllegalArgumentException("Can't be equipped");
    }
    AbstractGear aGear = (AbstractGear) o;
    if (dummyHead.areYouMe(aGear)) {
      equipHeadGear(aGear);
    } else if (dummyFoot.areYouMe(aGear)) {
      equipFootGear(aGear);
    } else if (dummyHand.areYouMe(aGear)) {
      equipHandGear(aGear);
    } else if (dummyJewel.areYouMe(aGear)) {
      equipJewelry(aGear);
    }
  }

  /**
   * Equips the character with a head gear.
   *
   * @param o head gear
   */
  private void equipHeadGear(AbstractGear o) {
    if (headGears.isEmpty()) {
      headGears.add(o);
    } else if (headGears.get(0).compareTo(o) > 0) {
      System.out.printf("Replacing the %s "
              + "with the %s%n", headGears.get(0).toString(), o.toString());
      headGears.remove(0);
      headGears.add(o);
    }
    Collections.sort(headGears);
  }

  /**
   * Equips the character with a foot gear.
   *
   * @param o foot gear
   */
  private void equipFootGear(AbstractGear o) {
    if (footGears.size() < 2) {
      footGears.add(o);
    } else {
      if (footGears.get(1).compareTo(o) > 0) {
        System.out.printf("Replacing the %s "
                + "with the %s%n", footGears.get(1).toString(), o.toString());
        footGears.remove(1);
        footGears.add(o);
      }
    }
    Collections.sort(footGears);
  }

  /**
   * Equips the character with a hand gear.
   *
   * @param o hand gear
   */
  private void equipHandGear(AbstractGear o) {
    if (handGears.size() < 10) {
      handGears.add(o);
    } else {
      if (handGears.get(9).compareTo(o) > 0) {
        System.out.printf("Replacing the %s "
                + "with the %s%n", handGears.get(9).toString(), o.toString());
        handGears.remove(9);
        handGears.add(o);
      }
    }
    Collections.sort(handGears);
  }

  /**
   * Equips the character with a jewelry.
   *
   * @param o jewelry
   */
  private void equipJewelry(AbstractGear o) {
    jewelrys.add(o);
  }

  /**
   * Wears out the gear by a specified value.
   */
  @Override
  public void wearOut() {
    for (AbstractGear i : headGears) {
      HeadGear aGear = (HeadGear) i;
      aGear.wearOut();
    }
    for (AbstractGear i : footGears) {
      FootGear aGear = (FootGear) i;
      aGear.wearOut();
    }
    for (AbstractGear i : handGears) {
      HandGear aGear = (HandGear) i;
      aGear.wearOut();
    }
    for (AbstractGear i : jewelrys) {
      Jewelry aGear = (Jewelry) i;
      aGear.wearOut();
    }
  }

  private String allHeadGear() {
    if (!(headGears.isEmpty())) {
      return headGears.get(0).toString();
    }
    return "";
  }

  private String allFootGear() {
    if (!(footGears.isEmpty())) {
      return footGears.get(0).combineName(footGears);
    }
    return "";
  }

  private String allHandGear() {
    if (!(handGears.isEmpty())) {
      return handGears.get(0).combineName(handGears);
    }
    return "";
  }

  private String allJewelry() {
    if (!(jewelrys.isEmpty())) {
      return jewelrys.get(0).combineName(jewelrys);
    }
    return "";
  }


  /**
   * Returns the toString.
   *
   * @return toString
   */
  @Override
  public String toString() {
    StringBuilder character = new StringBuilder().append(cName).append(" is currently wearing:");
    character.append("\nHeadgear: ").append(allHeadGear());
    character.append("\nFootgear: ").append(allFootGear());
    character.append("\nHandgear: ").append(allHandGear());
    character.append("\nJewelry: ").append(allJewelry());
    character.append("\nWith a base attack of: ").append(getBaseAttack());
    character.append("\nWith a base defense of: ").append(getBaseDefense());
    character.append("\nWith a modified attack of: ").append(getModifiedAttack());
    character.append("\nWith a modified defense of: ").append(getModifiedDefense());
    return character.toString();
  }


}
