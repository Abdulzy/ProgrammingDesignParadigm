import org.junit.Before;
import org.junit.Test;

import gears.AttackGear;
import gears.DefenseGear;
import gears.FootGear;
import gears.Gear;
import gears.HandGear;
import gears.HeadGear;
import gears.Jewelry;

import static org.junit.Assert.*;

/**
 * Testing the HandGear class.
 */
public class HandGearTest {

  private DefenseGear head;
  private AttackGear foot;
  private AttackGear attackHand;
  private DefenseGear defenseHand;
  private AttackGear attackJewel;

  @Before
  public void setUp() {
    head = new HeadGear("Helm", "Flight", false, 100);
    foot = new FootGear("Boots", "Electricity", true, 100);
    attackHand = new HandGear.HandFactory().createAttackHandGear("Ring", "Shock", true, 100);
    defenseHand = new HandGear.HandFactory().createDefenseHandGear("Signet", "Speed", true, 100);
    attackJewel = new Jewelry.JewelryFactory().createAttackJewelry("Amulet", "Heft", true, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullHand() {
    attackHand = new HandGear.HandFactory().createAttackHandGear("Helm", null, false, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyNameHand() {
    attackHand = new HandGear.HandFactory().createAttackHandGear(" ", "helm", false, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAdjectiveHand() {
    attackJewel = new HandGear.HandFactory().createAttackHandGear(" ", "fire ", false, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void zeroDefensePower() {
    defenseHand = new HandGear.HandFactory().createDefenseHandGear("Helm", "heft", false, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void zeroAttackPower() {
    attackHand = new HandGear.HandFactory().createAttackHandGear("Helm", "heft", false, 0);
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void constructorDefendHand() {
    defenseHand = new HandGear.HandFactory().createDefenseHandGear("Signet", "Speed", false, 100);
    assertEquals("signet of speed", defenseHand.toString());
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void constructorAttackHand() {
    attackHand = new HandGear.HandFactory().createAttackHandGear("Ring", "Shock", true, 100);
    assertEquals("ring of shock", attackHand.toString());
  }

  @Test
  public void getDefenseName() {
    assertEquals("signet", defenseHand.getName());
  }

  @Test
  public void getDefenseAdjective() {
    assertEquals("speed", defenseHand.getAdjective());
  }

  @Test
  public void getAttackName() {
    assertEquals("ring", attackHand.getName());
  }

  @Test
  public void getAttackAdjective() {
    assertEquals("shock", attackHand.getAdjective());
  }

  @Test
  public void getHandDefense() {
    assertEquals(100, defenseHand.getDefense());
  }

  @Test
  public void getHandAttack() {
    assertEquals(100, attackHand.getAttack());
  }

  @Test
  public void wearHandDefenseTrue() {
    defenseHand.wearOut();
    assertEquals(99, defenseHand.getDefense());
  }

  @Test
  public void wearHandDefenseFalse() {
    defenseHand = new HandGear.HandFactory().createDefenseHandGear("Signet", "Speed", false, 100);
    defenseHand.wearOut();
    assertEquals(100, defenseHand.getDefense());
  }
  @Test
  public void wearHandAttackTrue() {
    defenseHand.wearOut();
    assertEquals(99, defenseHand.getDefense());
  }

  @Test
  public void wearHandAttackFalse() {
    defenseHand = new HandGear.HandFactory().createDefenseHandGear("Signet", "Speed", false, 100);
    defenseHand.wearOut();
    assertEquals(100, defenseHand.getDefense());
  }

  @Test
  public void compareHandAToHandA() {
    AttackGear attackHandTwo = new HandGear.HandFactory().createAttackHandGear("Ring", "Shock", true, 50);
    assertEquals(-1, attackHand.compareTo(attackHandTwo));
    assertEquals(1, attackHandTwo.compareTo(attackHand));
  }

  @Test
  public void compareHandDToHandD() {
    DefenseGear defenseHandTwo = new HandGear.HandFactory().createDefenseHandGear("Signet", "Speed", true, 50);
    assertEquals(-1, defenseHand.compareTo(defenseHandTwo));
    assertEquals(1, defenseHandTwo.compareTo(defenseHand));
  }

  @Test
  public void compareHandAToHandD() {
    DefenseGear defenseHandTwo = new HandGear.HandFactory().createDefenseHandGear("Signet", "Speed", true, 50);
    assertEquals(-1, attackHand.compareTo(defenseHandTwo));
    assertEquals(1, defenseHandTwo.compareTo(attackHand));
  }

  @Test
  public void compareHandDToHandA() {
    AttackGear attackHandTwo = new HandGear.HandFactory().createAttackHandGear("Ring", "Shock", true, 50);
    assertEquals(-1, defenseHand.compareTo(attackHandTwo));
    assertEquals(1, attackHandTwo.compareTo(defenseHand));
  }

  @Test
  public void compareEqualPower() {
    assertEquals(-1, attackHand.compareTo(defenseHand));
    assertEquals(1, defenseHand.compareTo(attackHand));
  }

  @Test
  public void compareHandToHead() {
    assertEquals(1, attackHand.compareTo(head));
  }

  @Test
  public void compareHandToFoot() {
    assertEquals(1, attackHand.compareTo(foot));
  }

  @Test
  public void compareHandToJewel() {
    assertEquals(-1, attackHand.compareTo(attackJewel));
  }

}