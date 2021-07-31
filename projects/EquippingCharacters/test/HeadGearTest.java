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
 * Testing the HeadGear class.
 */
public class HeadGearTest {

  private DefenseGear head;
  private AttackGear foot;
  private AttackGear attackHand;
  private AttackGear attackJewel;

  @Before
  public void setUp(){
    head = new HeadGear("Helm", "Flight", true, 100);
    foot = new FootGear("Boots", "Electricity", true, 100);
    attackHand = new HandGear.HandFactory().createAttackHandGear("Ring", "Shock", true, 100);
    attackJewel = new Jewelry.JewelryFactory().createAttackJewelry("Amulet", "Heft", true, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullHead() {
    head = new HeadGear("Helm", null, false, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyNameHead() {
    head = new HeadGear(" ", "heft ", false, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAdjectiveHead() {
    head = new HeadGear("Helm", " ", false, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void zeroPower() {
    head = new HeadGear("Helm", "heft", false, 0);
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void constructorHead() {
    head = new HeadGear("Helm", "heft", false, 100);
    assertEquals("helm of heft", head.toString());
  }

  @Test
  public void getHeadDefense() {
    assertEquals(100, head.getDefense());
  }

  @Test
  public void getName() {
    assertEquals("helm", head.getName());
  }

  @Test
  public void getAdjective() {
    assertEquals("flight", head.getAdjective());
  }

  /**
   * If the gear is false for wearOutValue then the value doesn't change,
   * If it's true then it changes, the examples are as follows.
   */
  @Test
  public void wearHeadDefenseFalse() {
    head = new HeadGear("Helm", "Flight", false, 100);
    head.wearOut();
    assertEquals(100, head.getDefense());
  }

  @Test
  public void wearHeadDefenseTrue() {
    head.wearOut();
    assertEquals(99, head.getDefense());
  }

  @Test
  public void compareHeadToHead() {
    DefenseGear headTwo = new HeadGear("Helm", "Flight", false, 50);
    assertEquals(-1, head.compareTo(headTwo));
    assertEquals(1, headTwo.compareTo(head));
  }

  @Test
  public void compareHeadToFoot() {
    assertEquals(-1, head.compareTo(foot));
  }

  @Test
  public void compareHeadToHand() {
    assertEquals(-1, head.compareTo(attackHand));
  }

  @Test
  public void compareHeadToJewel() {
    assertEquals(-1, head.compareTo(attackJewel));
  }

}