import dungeon.Level;
import dungeon.MedievalLevelBuilder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the MedievalLevelBuilder class.
 */
public class MedievalLevelBuilderTest {
  private MedievalLevelBuilder england;

  @Before
  public void setUp() {
    england = new MedievalLevelBuilder(1, 1, 2, 2);
  }

  @Test
  public void testConstructor() {
    MedievalLevelBuilder france = new MedievalLevelBuilder(1, 1, 2, 2);
    assertEquals("testConstructor passed", "Level 1 "
            + "contains 0 rooms:\n", france.toString());
  }

  @Test
  public void addRoom() {
    england.addRoom("Death room");
    assertEquals("addRoom passed", "Level 1 contains 1 rooms:\n\n"
            + "Room 0 -- Death room\n"
            + "Monsters:\n"
            + "\tNone\n"
            + "Treasures:\n"
            + "\tNone\n", england.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfNegative() {
    MedievalLevelBuilder france = new MedievalLevelBuilder(1, -1, 2, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyDescription() {
    MedievalLevelBuilder france = new MedievalLevelBuilder(1, 1, 2, 2);
    france.addRoom("");
  }

  @Test(expected = IllegalStateException.class)
  public void maxSpace() {
    MedievalLevelBuilder france = new MedievalLevelBuilder(1, 1, 2, 2);
    france.addRoom("begin");
    france.addRoom("end");
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeGoblins() {
    england.addRoom("Death room");
    england.addGoblins(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void humanDetails() {
    england.addRoom("Death room");
    england.addHuman(0, "Abdul","", 0);
  }

  @Test(expected = IllegalStateException.class)
  public void manyMonsters() {
    england.addRoom("Death room");
    england.addGoblins(0,3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void humanName() {
    england.addRoom("Death room");
    england.addHuman(0,"","weakling", -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void humanHitPoint() {
    england.addRoom("Death room");
    england.addHuman(0,"Joe" ,"weakling", -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void goldTreasure() {
    england.addRoom("Death room");
    england.addGold(0, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void weaponDescription() {
    england.addRoom("Death room");
    england.addWeapon(0, "");
  }

  @Test(expected = IllegalArgumentException.class)
  public void specialValue() {
    england.addRoom("Death room");
    england.addSpecial(0,"name", -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void specialDescription() {
    england.addRoom("Death room");
    england.addSpecial(0,"", 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void highRoom() {
    england.addRoom("Death room");
    england.addGold(1, 2);
  }

  @Test(expected = IllegalStateException.class)
  public void doesNotExist() {
    england.addGold(0, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeRoom() {
    england.addRoom("end");
    england.addGold(-1, 2);
  }

  @Test(expected = IllegalStateException.class)
  public void failedBuild() {
    england.addRoom("end");
    england.addGold(0, 2);
    Level end = england.build();
  }

  @Test
  public void addGoblins() {
    england.addRoom("Death room");
    england.addGoblins(0, 1);
    assertEquals("addGoblin passed", "Level 1 contains 1 rooms:\n\n"
            + "Room 0 -- Death room\n"
            + "Monsters:\n"
            + "\tgoblin (hitpoints = 7) is a mischievous and very unpleasant, vengeful, "
            + "and greedy creature whose primary purpose is to cause trouble to "
            + "humankind\nTreasures:\n"
            + "\tNone\n", england.toString());
  }

  @Test
  public void addOrc() {
    england.addRoom("Death room");
    england.addOrc(0);
    assertEquals("addOrc passed", "Level 1 contains 1 rooms:\n\n"
            + "Room 0 -- Death room\n"
            + "Monsters:\n"
            + "\torc (hitpoints = 20) is a brutish, aggressive, "
            + "malevolent being serving evil\nTreasures:\n"
            + "\tNone\n", england.toString());
  }

  @Test
  public void addOgre() {
    england.addRoom("Death room");
    england.addOgre(0);
    assertEquals("addOgre passed", "Level 1 contains 1 rooms:\n\n"
            + "Room 0 -- Death room\n"
            + "Monsters:\n"
            + "\togre (hitpoints = 50) is a large, hideous man-like being "
            + "that likes to eat humans for lunch\nTreasures:\n"
            + "\tNone\n", england.toString());
  }

  @Test
  public void addHuman() {
    england.addRoom("Death room");
    england.addHuman(0, "abdul","weakling", 100);
    assertEquals("addHuman passed", "Level 1 contains 1 rooms:\n\n"
            + "Room 0 -- Death room\n"
            + "Monsters:\n"
            + "\tabdul (hitpoints = 100) is a weakling\nTreasures:\n"
            + "\tNone\n", england.toString());
  }

  @Test
  public void addPotion() {
    england.addRoom("Death room");
    england.addPotion(0);
    assertEquals("addPotion passed", "Level 1 contains 1 rooms:\n" +
            "\n" +
            "Room 0 -- Death room\n" +
            "Monsters:\n" +
            "\tNone\n" +
            "Treasures:\n" +
            "\ta healing potion (value = 1)\n", england.toString());
  }

  @Test
  public void addGold() {
    england.addRoom("Death room");
    england.addGold(0, 10);
    assertEquals("addPotion passed", "Level 1 contains 1 rooms:\n" +
            "\n" +
            "Room 0 -- Death room\n" +
            "Monsters:\n" +
            "\tNone\n" +
            "Treasures:\n" +
            "\tpieces of gold (value = 10)\n", england.toString());
  }

  @Test
  public void addWeapon() {
    england.addRoom("Death room");
    england.addWeapon(0, "m4a1");
    assertEquals("addWeapon passed", "Level 1 contains 1 rooms:\n" +
            "\n" +
            "Room 0 -- Death room\n" +
            "Monsters:\n" +
            "\tNone\n" +
            "Treasures:\n" +
            "\tm4a1 (value = 10)\n", england.toString());
  }

  @Test
  public void addSpecial() {
    england.addRoom("Death room");
    england.addSpecial(0,"Ultimate sword", 10);
    assertEquals("addSpecial passed", "Level 1 contains 1 rooms:\n" +
            "\n" +
            "Room 0 -- Death room\n" +
            "Monsters:\n" +
            "\tNone\n" +
            "Treasures:\n" +
            "\tUltimate sword (value = 10)\n", england.toString());
  }

  @Test
  public void testingBuild() {
    england.addRoom("Death room");
    england.addOgre(0);
    england.addOgre(0);
    england.addGold(0, 100);
    england.addSpecial(0, "Ultimate sword",100);
    Level build = england.build();
    assertEquals("build passed", "Level 1 contains 1 rooms:\n\n"
            + "Room 0 -- Death room\n"
            + "Monsters:\n"
            + "\togre (hitpoints = 50) is a large, hideous "
            + "man-like being that likes to eat humans for lunch\n"
            + "\togre (hitpoints = 50) is a large, hideous man-like "
            + "being that likes to eat humans for lunch\n"
            + "Treasures:\n"
            + "\tpieces of gold (value = 100)\n"
            + "\tUltimate sword (value = 100)\n", build.toString());
  }


  @Test
  public void testToString() {
    assertEquals("testToString passed", "Level 1 "
            + "contains 0 rooms:\n", england.toString());
  }
}