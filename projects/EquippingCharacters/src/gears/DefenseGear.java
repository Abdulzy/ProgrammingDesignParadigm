package gears;

/**
 * An interface for creating defense gear.
 */
public interface DefenseGear extends Gear {
  /**
   * Returns the defense power of the gear.
   *
   * @return defense
   */
  int getDefense();
}
