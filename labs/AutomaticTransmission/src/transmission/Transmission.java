package transmission;

/**
 * An interface called transmission.
 */
public interface Transmission {


  /**
   * Increases this objects speed by 2.
   * Then returns the object.
   * @return Transmission object
   */
  Transmission increaseSpeed();

  /**
   * Decreases this objects speed by 2.
   * Then returns the object.
   * @return Transmission object
   */
  Transmission decreaseSpeed();


  /**
   * Returns the speed of the object that called it.
   * @return speed
   */
  int getSpeed();


  /**
   * Returns the gear of the object that called it.
   * @return gear
   */
  int getGear();
}
