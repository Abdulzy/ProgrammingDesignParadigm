package gears;

/**
 * This is a Character interface.
 */
public interface Characters {
  /**
   * Returns the name of the character.
   *
   * @return name
   */
  String getName();

  /**
   * Returns the base hitpoint of the character.
   *
   * @return hitpoint
   */
  int getHitPoint();

  /**
   * Returns the attack of the character.
   *
   * @return attack
   */
  int getBaseAttack();

  /**
   * Returns the defense of the character.
   *
   * @return defense
   */
  int getBaseDefense();

  /**
   * Returns the attack of the character plus the attack of the gear.
   *
   * @return attack
   */
  int getModifiedAttack();

  /**
   * Returns the defense of the character plus the defense of the gear.
   *
   * @return defense
   */
  int getModifiedDefense();

  /**
   * Wears out the all gear being used by the user by  a specified value.
   */
  void wearOut();

  /**
   * Equips the character with a gear.
   *
   * @param o Gear object
   */
  void equip(Gear o);

}
