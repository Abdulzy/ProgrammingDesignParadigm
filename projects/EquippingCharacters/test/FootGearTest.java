import org.junit.Before;
import org.junit.Test;

import gears.AttackGear;
import gears.DefenseGear;
import gears.FootGear;
import gears.HandGear;
import gears.HeadGear;
import gears.Jewelry;

import static org.junit.Assert.*;
/**
 * Testing the Footgear class.
 */
public class FootGearTest {
  private DefenseGear head;
  private AttackGear foot;
  private AttackGear attackHand;
  private AttackGear attackJewel;

  @Before
  public void setUp() {
    head = new HeadGear("Helm", "Flight", false, 100);
    foot = new FootGear("Boots", "Electricity", true, 100);
    attackHand = new HandGear.HandFactory().createAttackHandGear("Ring", "Shock", true, 100);
    attackJewel = new Jewelry.JewelryFactory().createAttackJewelry("Amulet", "Heft", true, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullFoot() {
    foot = new FootGear("Helm", null, false, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyNameFoot() {
    foot = new FootGear(" ", "heft ", false, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAdjectiveFoot() {
    foot = new FootGear("Helm", " ", false, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void zeroPower() {
    foot = new FootGear("Helm", "heft", false, 0);
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void constructorFoot() {
    foot = new FootGear("Boots", "Electricity", false, 100);
    assertEquals("boots of electricity", foot.toString());
  }

  @Test
  public void getName() {
    assertEquals("boots", foot.getName());
  }

  @Test
  public void getAdjective() {
    assertEquals("electricity", foot.getAdjective());
  }

  @Test
  public void getFootAttack() {
    assertEquals(100, foot.getAttack());
  }

  @Test
  public void wearFootTrue() {
    foot.wearOut();
    assertEquals(99, foot.getAttack());
  }

  @Test
  public void wearFootFalse() {
    foot = new FootGear("Boots", "Electricity", false, 100);
    foot.wearOut();
    assertEquals(100, foot.getAttack());
  }

  @Test
  public void compareFootToFoot() {
    AttackGear footTwo = new FootGear("Helm", "Flight", false, 50);
    assertEquals(-1, foot.compareTo(footTwo));
    assertEquals(1, footTwo.compareTo(foot));
  }

  @Test
  public void compareFootToHead() {
    assertEquals(1, foot.compareTo(head));
  }

  @Test
  public void compareFootToHand() {
    assertEquals(-1, foot.compareTo(attackHand));
  }

  @Test
  public void compareFootToJewel() {
    assertEquals(-1, foot.compareTo(attackJewel));
  }

}