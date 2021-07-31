package gears;

/**
 * An interface for creating attacking gear.
 */
public interface AttackGear extends Gear {
  /**
   * Returns the Attack power of the gear.
   * @return Attack
   */
  int getAttack();

}
