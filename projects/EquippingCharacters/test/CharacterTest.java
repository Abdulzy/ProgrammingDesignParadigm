import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import gears.AttackGear;
import gears.Character;
import gears.Characters;
import gears.DefenseGear;
import gears.FootGear;
import gears.Gear;
import gears.HandGear;
import gears.HeadGear;
import gears.Jewelry;

import static org.junit.Assert.*;

public class CharacterTest {
  private DefenseGear head;
  private AttackGear foot;
  private AttackGear attackHand;
  private DefenseGear defenseHand;
  private AttackGear attackJewel;
  private DefenseGear defenseJewel;
  private Characters player;
  private Characters equipPlayer;
  private List<Gear> gears;

  @Before
  public void setUp() {
    head = new HeadGear("Helm", "Flight", true, 100);
    foot = new FootGear("Boots", "Electricity", true, 100);
    attackHand = new HandGear.HandFactory().createAttackHandGear("Ring", "Shock", true, 100);
    defenseHand = new HandGear.HandFactory().createDefenseHandGear("Signet", "Speed", true, 100);
    attackJewel = new Jewelry.JewelryFactory().createAttackJewelry("Amulet", "Heft", true, 100);
    defenseJewel = new Jewelry.JewelryFactory().createDefenseJewelry("Necklace", "Invincibility", true, 100);
    gears = new ArrayList<>();
    player = new Character("Abdul", 100, 50, 60);
    equipPlayer = new Character("Vic", 100, 50, 60);
    gears.add(head);
    gears.add(foot);
    gears.add(attackHand);
    gears.add(defenseHand);
    gears.add(attackJewel);
    gears.add(defenseJewel);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNull() {
    player = new Character(null, 100, 50, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyName() {
    player = new Character(" ", 100, 50, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nonPositiveHitPoint() {
    player = new Character("Abdul", 0, 50, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nonPositiveDefense() {
    player = new Character("Abdul", 100, 0, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nonPositiveAttack() {
    player = new Character("Abdul", 100, 0, 0);
  }

  /**
   * Test the constructor and the toString().
   */
  @Test
  public void constructor() {
    Characters playerTwo = new Character("Sam", 100, 50, 60);
    assertEquals("sam is currently wearing:\n"
            + "Headgear: \n"
            + "Footgear: \n"
            + "Handgear: \n"
            + "Jewelry: \n"
            + "With a base attack of: 50\n"
            + "With a base defense of: 60\n"
            + "With a modified attack of: 50\n"
            + "With a modified defense of: 60", playerTwo.toString());
  }

  @Test
  public void getName() {
    assertEquals("abdul", player.getName());
  }

  @Test
  public void getHitPoint() {
    assertEquals(100, player.getHitPoint());
  }

  @Test
  public void getBaseAttack() {
    assertEquals(50, player.getBaseAttack());
  }

  @Test
  public void getBaseDefense() {
    assertEquals(60, player.getBaseDefense());
  }

  /**
   * Test the modifiedAttack method and equip method.
   */
  @Test
  public void getModifiedAttack() {
    assertEquals(50, player.getModifiedAttack());
    player.equip(foot);
    assertEquals(150, player.getModifiedAttack());
    player.equip(attackHand);
    assertEquals(250, player.getModifiedAttack());
    player.equip(attackJewel);
    assertEquals(350, player.getModifiedAttack());
  }

  /**
   * Test the modifiedDefense method and equip method.
   */
  @Test
  public void getModifiedDefense() {
    assertEquals(60, player.getModifiedDefense());
    player.equip(head);
    assertEquals(160, player.getModifiedDefense());
    player.equip(defenseHand);
    assertEquals(260, player.getModifiedDefense());
    player.equip(defenseJewel);
    assertEquals(360, player.getModifiedDefense());
  }

  @Test
  public void equip() {
    for (Gear i : gears) {
      equipPlayer.equip(i);
    }
    assertEquals("vic is currently wearing:\n"
            + "Headgear: helm of flight\n"
            + "Footgear: boots of electricity\n"
            + "Handgear: ring of shock, and speed\n"
            + "Jewelry: amulet of heft, and invincibility\n"
            + "With a base attack of: 50\n"
            + "With a base defense of: 60\n"
            + "With a modified attack of: 350\n"
            + "With a modified defense of: 360", equipPlayer.toString());
  }

  @Test
  public void wearOut() {
    for (Gear i : gears) {
      equipPlayer.equip(i);
    }
    assertEquals(360, equipPlayer.getModifiedDefense());
    assertEquals(350, equipPlayer.getModifiedAttack());
    equipPlayer.wearOut();
    assertEquals(357, equipPlayer.getModifiedDefense());
    assertEquals(347, equipPlayer.getModifiedAttack());
  }

  @Test
  public void maxHead() {
    DefenseGear headTwo = new HeadGear("Helmet", "rock", true, 120);
    player.equip(head);
    assertEquals(160, player.getModifiedDefense());
    player.equip(headTwo);
    assertEquals(180, player.getModifiedDefense());
  }

  @Test
  public void maxFoot() {
    AttackGear footTwo = new FootGear("slipper", "fire", true, 120);
    AttackGear footThree = new FootGear("slides", "water", true, 130);
    player.equip(foot);
    assertEquals(150, player.getModifiedAttack());
    player.equip(footTwo);
    assertEquals(270, player.getModifiedAttack());
    player.equip(footThree);
    assertEquals(300, player.getModifiedAttack());
  }

  @Test
  public void maxHand() {
    AttackGear attackHandOne = new HandGear.HandFactory().createAttackHandGear("Glove", "Speed", true, 110);
    AttackGear attackHandTwo = new HandGear.HandFactory().createAttackHandGear("BrassKnuckles", "Healing", true, 120);
    AttackGear attackHandThree = new HandGear.HandFactory().createAttackHandGear("Gauntlet", "Flame", true, 130);
    AttackGear attackHandFour = new HandGear.HandFactory().createAttackHandGear("Watch", "Escape", true, 140);
    AttackGear attackHandFive = new HandGear.HandFactory().createAttackHandGear("Bracelet", "Ruin", true, 150);
    DefenseGear defenseHandSix = new HandGear.HandFactory().createDefenseHandGear("Nail knife", "Telepathy", true, 110);
    DefenseGear defenseHandSeven = new HandGear.HandFactory().createDefenseHandGear("mitten ", "Strength", true, 120);
    DefenseGear defenseHandEight = new HandGear.HandFactory().createDefenseHandGear("bangle", "Ice", true, 130);
    DefenseGear defenseHandNine = new HandGear.HandFactory().createDefenseHandGear("Fit Band ", "Wind", true, 140);
    DefenseGear defenseHandTen = new HandGear.HandFactory().createDefenseHandGear("Knuckle Duster", "Explosion", true, 150);
    player.equip(attackHand);
    player.equip(defenseHand);
    player.equip(attackHandOne);
    player.equip(attackHandTwo);
    player.equip(attackHandThree);
    player.equip(attackHandFour);
    player.equip(defenseHandSix);
    player.equip(defenseHandSeven);
    player.equip(defenseHandEight);
    player.equip(defenseHandNine);
    assertEquals(650, player.getModifiedAttack());
    assertEquals(660, player.getModifiedDefense());
    player.equip(attackHandFive);
    player.equip(defenseHandTen);
    assertEquals(700, player.getModifiedAttack());
    assertEquals(710, player.getModifiedDefense());
  }
}