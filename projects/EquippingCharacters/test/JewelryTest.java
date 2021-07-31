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
 * Testing the Jewelry class.
 */
public class JewelryTest {
  private DefenseGear head;
  private AttackGear foot;
  private AttackGear attackHand;
  private AttackGear attackJewel;
  private DefenseGear defenseJewel;

  @Before
  public void setUp() {
    head = new HeadGear("Helm", "Flight", false, 100);
    foot = new FootGear("Boots", "Electricity", true, 100);
    attackHand = new HandGear.HandFactory().createAttackHandGear("Ring", "Shock", true, 100);
    attackJewel = new Jewelry.JewelryFactory().createAttackJewelry("Amulet", "Heft", true, 100);
    defenseJewel = new Jewelry.JewelryFactory().createDefenseJewelry("Necklace", "Invincibility", true, 100);
  }



  @Test(expected = IllegalArgumentException.class)
  public void testNullJewelry() {
    attackJewel = new Jewelry.JewelryFactory().createAttackJewelry("Helm", null, false, 100);
  }



  @Test(expected = IllegalArgumentException.class)
  public void testEmptyNameJewelry() {
    attackJewel = new Jewelry.JewelryFactory().createAttackJewelry(" ", "heft ", false, 100);
  }



  @Test(expected = IllegalArgumentException.class)
  public void testEmptyAdjectiveJewelry() {
    defenseJewel = new Jewelry.JewelryFactory().createDefenseJewelry("Necklace", " ", false, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void zeroDefensePower() {
    defenseJewel = new Jewelry.JewelryFactory().createDefenseJewelry("Helm", "heft", false, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void zeroAttackPower() {
    attackJewel = new Jewelry.JewelryFactory().createAttackJewelry("Helm", "heft", false, 0);
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void constructorAttackJewelry() {
    attackJewel = new Jewelry.JewelryFactory().createAttackJewelry("Amulet", "Magic ", false, 100);
    assertEquals("amulet of magic", attackJewel.toString());
  }

  @Test
  public void getDefenseName() {
    assertEquals("necklace", defenseJewel.getName());
  }

  @Test
  public void getDefenseAdjective() {
    assertEquals("invincibility", defenseJewel.getAdjective());
  }

  @Test
  public void getAttackName() {
    assertEquals("amulet", attackJewel.getName());
  }

  @Test
  public void getAttackAdjective() { assertEquals("heft", attackJewel.getAdjective()); }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void constructorDefendJewelry() {
    defenseJewel = new Jewelry.JewelryFactory().createDefenseJewelry("Chain", "Ice ", false, 100);
    assertEquals("chain of ice", defenseJewel.toString());
  }

  @Test
  public void getJewelDefense() {
    assertEquals(100, defenseJewel.getDefense());
  }

  @Test
  public void getJewelAttack() {
    assertEquals(100, attackJewel.getAttack());
  }

  @Test
  public void wearJewelFalse() {
    defenseJewel = new Jewelry.JewelryFactory().createDefenseJewelry("Necklace", "Invincibility", false, 100);
    defenseJewel.wearOut();
    assertEquals(100, defenseJewel.getDefense());
  }

  @Test
  public void wearJewelTrue() {
    attackJewel.wearOut();
    assertEquals(99, attackJewel.getAttack());
  }

  @Test
  public void compareJewelAToJewelA() {
    AttackGear attackJewelTwo = new Jewelry.JewelryFactory().createAttackJewelry("Amulet", "Heft", true, 50);
    assertEquals(-1, attackJewel.compareTo(attackJewelTwo));
    assertEquals(1, attackJewelTwo.compareTo(attackJewel));
  }

  @Test
  public void compareJewelToJewelD() {
    DefenseGear defenseJewelTwo = new Jewelry.JewelryFactory().createDefenseJewelry("Necklace", "Invincibility", true, 50);
    assertEquals(-1, defenseJewel.compareTo(defenseJewelTwo));
    assertEquals(1, defenseJewelTwo.compareTo(defenseJewel));
  }

  @Test
  public void compareJewelAToJewelD() {
    DefenseGear defenseJewelTwo = new Jewelry.JewelryFactory().createDefenseJewelry("Necklace", "Invincibility", true, 50);
    assertEquals(-1, attackJewel.compareTo(defenseJewelTwo));
    assertEquals(1, defenseJewelTwo.compareTo(attackJewel));
  }

  @Test
  public void compareJewelToJewelA() {
    AttackGear attackJewelTwo = new Jewelry.JewelryFactory().createAttackJewelry("Amulet", "Heft", true, 50);
    assertEquals(-1, defenseJewel.compareTo(attackJewelTwo));
    assertEquals(1, attackJewelTwo.compareTo(defenseJewel));
  }

  @Test
  public void compareEqualPower() {
    assertEquals(-1, attackJewel.compareTo(defenseJewel));
    assertEquals(1, defenseJewel.compareTo(attackJewel));
  }

  @Test
  public void compareJewelToHead() {
    assertEquals(1, attackJewel.compareTo(head));
  }

  @Test
  public void compareJewelToFoot() {
    assertEquals(1, attackJewel.compareTo(foot));
  }

  @Test
  public void compareJewelToHand() {
    assertEquals(1, attackJewel.compareTo(attackHand));
  }

}