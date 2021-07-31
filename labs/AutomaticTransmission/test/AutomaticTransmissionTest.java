import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import transmission.AutomaticTransmission;
import transmission.Transmission;

/**
 * Testing the Automatic Transmission class.
 */
public class AutomaticTransmissionTest {
  private Transmission tesla;

  /**
   * Initiate value for test.
   * @throws Exception if value was negative or not in increasing order.
   */
  @Before
  public void setUp() throws Exception {
    tesla = new AutomaticTransmission(3,5,7,9,11);
  }


  /**
   * Testing  for negative value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfNegative() {
    tesla = new AutomaticTransmission(-2, 4,
            6,8 ,10);
  }

  /**
   * Test for when value is not in increasing order.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfLesser() {
    tesla = new AutomaticTransmission(2, 4,
            6,8 ,5);
  }

  /**
   * Test for toString.
   */
  @Test
  public void testString() {
    Transmission temp1 = tesla.increaseSpeed();
    assertEquals("toString passed", "Transmission (speed = 2, gear = 1)", temp1.toString());
  }

  /**
   * Test to increase speed.
   */
  @Test
  public void increaseSpeed() {
    Transmission temp1;
    Transmission temp2;
    Transmission temp3;
    Transmission temp4;
    Transmission temp5;
    temp1 = tesla.increaseSpeed();
    temp2 = temp1.increaseSpeed();
    temp3 = temp2.increaseSpeed();
    temp4 = temp3.increaseSpeed();
    temp5 = temp4.increaseSpeed();
    assertEquals("Increase Speed passed",12 , temp5.increaseSpeed().getSpeed());
  }

  /**
   * Test to decrease speed.
   */
  @Test
  public void decreaseSpeed() {
    Transmission temp1;
    Transmission temp2;
    Transmission temp3;
    Transmission temp4;
    Transmission temp5;
    temp1 = tesla.increaseSpeed();
    temp2 = temp1.increaseSpeed();
    temp3 = temp2.increaseSpeed();
    temp4 = temp3.increaseSpeed();
    temp5 = temp4.increaseSpeed();
    assertEquals("Decrease Speed passed", 8, temp5.decreaseSpeed().getSpeed());
  }

  /**
   * Test for increase speed for when gear would return 0.
   */
  @Test
  public void decreaseSpeedZero() {
    Transmission temp1;
    temp1 = tesla.increaseSpeed();
    assertEquals("Decrease Speed passed", 0, temp1.decreaseSpeed().getSpeed());
  }

  /**
   * Test to for when speed is less that 2 which returns an error.
   */
  @Test(expected = IllegalStateException.class)
  public void decreaseSpeedUnderTwo()  {
    tesla.decreaseSpeed();
  }

  /**
   * Test to get speed.
   */
  @Test
  public void getSpeed() {
    Transmission temp1 = tesla.increaseSpeed();
    assertEquals("Speed passed", 2, temp1.getSpeed());
  }

  /**
   * Test to get gear.
   */
  @Test
  public void getGear() {
    Transmission temp1 = tesla.increaseSpeed();
    assertEquals("Gear passed", 1, temp1.getGear());
  }
}