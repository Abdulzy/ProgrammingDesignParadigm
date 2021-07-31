import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import reptilehouse.Amphibian;
import reptilehouse.Animal;


/**
 * Test the amphibian class.
 */
public class AmphibianTest {
  private Animal abdul;

  @Before
  public void setUp() {
    abdul = new Amphibian(" sNaKe ", "it has no legs", 1, " ForEst ", -20, 25, false, 3, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfNegative() {
    abdul = new Amphibian(" sNaKe ", "it has no legs", -1, " ForEst ", -20, 25, false, 4, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNull() {
    abdul = new Amphibian(" sNaKe ", null, -1, " ForEst ", -20, 25, false, 4, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOverRange() {
    abdul = new Amphibian(" sNaKe ", "it has no legs", 4, " ForEst ", -20, 25, false, 4, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStringLength() {
    abdul = new Amphibian("", "it has no legs", 1, " ForEst ", -20, 25, false, 4, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTemperature() {
    abdul = new Amphibian("Snake", "it has no legs", 1, " ForEst ", -20, -25, false, 4, true);
  }

  @Test
  public void testingConstructor() {
    abdul = new Amphibian(" sNaKe ", "it has no legs", 1, " ForEst ", -20, 25, false, 3, true);
    assertEquals("animal size", "snake", abdul.getAnimalSpecies());
    assertEquals("animal size", "forest", abdul.getNaturalFeature());
  }

  @Test
  public void testingOtherSizes() {
    abdul = new Amphibian(" sNaKe ", "it has no legs", 2, " ForEst ", -20, 25, false, 3, true);
    Animal vic = new Amphibian(" sNaKe ", "it has no legs", 3, " ForEst ", -20, 25, false, 3, true);
    assertEquals("animal size", "medium", abdul.getAnimalSize());
    assertEquals("animal size", "large", vic.getAnimalSize());
  }

  @Test
  public void getAnimalSpecies() {
    assertEquals("animal size", "snake", abdul.getAnimalSpecies());
  }

  @Test
  public void getAnimalDescription() {
    assertEquals("toString passed", "it has no legs", abdul.getAnimalCharacteristics());
  }

  @Test
  public void getAnimalSize() {
    assertEquals("animal size passed", "small", abdul.getAnimalSize());
  }

  @Test
  public void getNaturalFeature() {
    assertEquals("natural feature passed", "forest", abdul.getNaturalFeature());
  }

  @Test
  public void lowerTemperature() {
    assertEquals("high temperature passed", -20, abdul.lowerTemperature());
  }

  @Test
  public void higherTemperature() {
    assertEquals("high temperature passed", 25, abdul.higherTemperature());
  }

  @Test
  public void checkPoison() {
    assertFalse("poison passed", abdul.checkPoison());
  }

  @Test
  public void checkExtinct() {
    assertFalse("extinct passed", abdul.checkExtinct());
  }

  @Test
  public void checkEndangered() {
    assertFalse("endangered passed", abdul.checkEndangered());
  }

  @Test
  public void coExist() {
    assertTrue("coExist passed", abdul.coExist());
  }

  @Test
  public void testingToString() {
    assertEquals("toString passed", "The snake, an amphibian. it has no legs."
            + " Also it is false for being poisonous, "
            + "false for being extinct and false for being endangered.", abdul.toString());
  }
}