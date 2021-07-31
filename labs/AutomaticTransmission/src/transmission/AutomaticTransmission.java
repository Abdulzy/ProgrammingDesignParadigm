package transmission;

/**
 * An Automatic transmission that changes an object gears based on the speed.
 */
public class AutomaticTransmission implements Transmission {

  private int speedThresholdOne;
  private int speedThresholdTwo;
  private int speedThresholdThree;
  private int speedThresholdFour;
  private int speedThresholdFive;
  private int speed;
  private int gear;

  /**
   * Creates an Automatic transmission that can display the speed and gear.
   * @param thresholdOne is for gear 1
   * @param thresholdTwo is for gear 3
   * @param thresholdThree is for gear 4
   * @param thresholdFour is for gear 5
   * @param thresholdFive is for gear 6
   * @throws IllegalArgumentException if values are not positive
   * @throws IllegalArgumentException if values are not in increasing order from the left
   */
  public AutomaticTransmission(int thresholdOne, int thresholdTwo, int thresholdThree,
                               int thresholdFour, int thresholdFive)
          throws IllegalArgumentException {
    if (thresholdOne <= 0 | thresholdTwo <= 0
            | thresholdThree <= 0
            | thresholdFour <= 0
            | thresholdFive <= 0) {
      throw new IllegalArgumentException("Takes in only non negative ");
    }
    if (thresholdTwo < thresholdOne
            | thresholdThree < thresholdTwo
            | thresholdFour < thresholdThree
            | thresholdFive < thresholdFour) {
      throw new IllegalArgumentException("integers in increasing order"
              + " from the left to the right.");
    }
    speedThresholdOne = thresholdOne;
    speedThresholdTwo = thresholdTwo;
    speedThresholdThree = thresholdThree;
    speedThresholdFour = thresholdFour;
    speedThresholdFive = thresholdFive;
    speed = 0;
    gear = 0;
  }

  @Override
  public String toString() {
    return String.format("Transmission (speed = %d, gear = %d)", speed, gear);
  }


  /**
   * Increases this objects speed by 2. Then returns the object.   *
   * @return Transmission object
   */
  @Override
  public Transmission increaseSpeed() {
    AutomaticTransmission temp = new AutomaticTransmission(speedThresholdOne,
            speedThresholdTwo, speedThresholdThree,
            speedThresholdFour, speedThresholdFive);
    temp.speed = speed + 2;
    temp.getGear();
    return temp;
  }

  /**
   * Decreases this objects speed by 2. Then returns the object.   *
   * @return Transmission object
   */
  @Override
  public Transmission decreaseSpeed() throws IllegalStateException {
    if (speed < 2) {
      throw new IllegalStateException("The value is too low to reduce.");
    }
    AutomaticTransmission temp = new AutomaticTransmission(speedThresholdOne,
            speedThresholdTwo, speedThresholdThree,
            speedThresholdFour, speedThresholdFive);
    temp.speed = speed - 2;
    temp.getGear();
    return temp;
  }

  /**
   * Returns the speed of the object that called it.   *
   * @return speed
   */
  @Override
  public int getSpeed() {
    return speed;
  }

  /**
   * Calculates the gear of object using the speed with the right threshold. Returns the gear of the
   * object that called it.   *
   * @return gear
   */
  @Override
  public int getGear() {
    if (speed == 0) {
      gear = 0;
    } else if (speed < speedThresholdOne) {
      gear = 1;
    } else if (speed < speedThresholdTwo) {
      gear = 2;
    } else if (speed < speedThresholdThree) {
      gear = 3;
    } else if (speed < speedThresholdFour) {
      gear = 4;
    } else if (speed < speedThresholdFive) {
      gear = 5;
    } else {
      gear = 6;
    }
    return gear;
  }
}
