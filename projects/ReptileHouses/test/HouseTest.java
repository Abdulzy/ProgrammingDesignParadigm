import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import reptilehouse.Animal;
import reptilehouse.Habitat;
import reptilehouse.Habitats;
import reptilehouse.House;
import reptilehouse.Houses;
import reptilehouse.Reptile;


/**
 * Test House class.
 */
public class HouseTest {
  private Houses life;
  private Habitats game;
  private Habitats gym;
  private Habitats lab;
  private Animal abdul;
  private Animal frags;
  private Animal somto;

  /**
   * Initializing values.
   */
  @Before
  public void setUp() {
    frags = new Reptile(" sNaKe ", "it has no legs", 2,
            " ForEst ", -20, 25,
            false, 3, true);
    abdul = new Reptile(" croCodIle ", "it has tough skin",
            2, " lake ", 20,
            30, false, 3, false);
    somto = new Reptile(" alligator ", "it has tough skin",
            2, " lake ", 31,
            35, false, 3, true);
    game = new Habitat("illinois", 15);
    gym = new Habitat("boston", 15);
    lab = new Habitat("lagos", 15);
    life = new House(3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSize() {
    Houses home = new House(-3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMaxHabitat() {
    Houses home = new House(2);
    home.addHabitat(game);
    home.addHabitat(gym);
    home.addHabitat(lab);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExtinctAnimal() {
    Animal bolu = new Reptile(" lizard ", "it can regrow it's tail",
            2, " lake ", 31,
            35, false, 1, true);
    life.addAnimal(bolu);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoHabitat() {
    life.addAnimal(somto);
  }

  @Test(expected = IllegalArgumentException.class)
  public void lookUpSpecies() {
    life.addHabitat(lab);
    life.addAnimal(somto);
    life.lookUp("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void failedFeatures() {
    life.reportNaturalFeatures();
  }

  @Test(expected = IllegalArgumentException.class)
  public void failedSign() {
    life.printSign();
  }

  @Test(expected = IllegalArgumentException.class)
  public void failedMap() {
    life.printMap();
  }

  @Test(expected = IllegalArgumentException.class)
  public void failedIndex() {
    life.printIndex();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullAnimal() {
    life.addAnimal(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullHabitat() {
    life.addHabitat(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNulllookUp() {
    life.lookUp(null);
  }

  @Test
  public void testingConstructor() {
    Houses death = new House(3);
    assertEquals("constructor passed", 3, death.getMaxAmountOfHabitats());
  }

  @Test
  public void addAnimal() {
    life.addHabitat(game);
    life.addHabitat(lab);
    life.addAnimal(somto);
    life.addAnimal(abdul);
    assertEquals("add passed", "The alligator can be found in:\n"
            + "illinois\n", life.lookUp("alligator"));
  }

  @Test
  public void addHabitat() {
    life.addHabitat(lab);
    life.addHabitat(gym);
    assertEquals("add passed", 2, life.getAmountOfHabitats());
  }

  @Test
  public void getAmountOfHabitats() {
    life.addHabitat(game);
    life.addHabitat(gym);
    assertEquals("add passed", 2, life.getAmountOfHabitats());
  }

  @Test
  public void reportNaturalFeatures() {
    Animal bolu = new Reptile(" monster ", "it has a beard",
            2, " cooch ", -10,
            10, false, 3, true);
    life.addHabitat(game);
    life.addAnimal(frags);
    life.addAnimal(bolu);
    assertEquals("add passed", "All natural features are listed below:\n"
            + "The Habitat located at illinois has [cooch, forest] "
            + "with 5 square meter space left.\n", life.reportNaturalFeatures());
  }

  @Test
  public void lookUp() {
    life.addHabitat(game);
    life.addAnimal(frags);
    assertEquals("add passed", "The snake can be found in:\n"
            + "illinois\n", life.lookUp("snake"));
  }

  @Test
  public void failedLookUp() {
    life.addHabitat(game);
    life.addHabitat(gym);
    life.addAnimal(frags);
    life.addAnimal(abdul);
    assertEquals("add passed", "The dragon is currently not "
            + "in the reptile house.", life.lookUp("dragon"));
  }

  @Test
  public void inAndOutOfHabitat() {
    Animal bolu = new Reptile(" sNaKe ", "it has no legs", 2,
            " ForEst ", -20, 25,
            false, 3, false);
    life.addHabitat(game);
    life.addAnimal(frags);
    life.addAnimal(bolu);
    assertEquals("add passed", "The snake can be found in:\n"
            + "illinois\nThe snake is also outside a "
            + "habitat but in the reptile house.", life.lookUp("snake"));
  }

  @Test
  public void multipleHabitat() {
    Animal bolu = new Reptile(" sNaKe ", "it has no legs", 2,
            " ForEst ", -20, 25,
            false, 3, false);
    life.addHabitat(game);
    life.addHabitat(gym);
    life.addAnimal(bolu);
    life.addAnimal(frags);
    assertEquals("add passed", "The snake can be found in:\n"
            + "illinois\n"
            + "boston\n", life.lookUp("snake"));
  }

  @Test
  public void sign() {
    life.addHabitat(game);
    life.addHabitat(gym);
    life.addAnimal(frags);
    life.addAnimal(abdul);
    assertEquals("add passed", "These are the signs for each habitat:\n"
            + "The Habitat sign of illinois:\n"
            + "There are 1 amount of snake.\n"
            + "The snake, a reptile. it has no legs. Also it is false for being "
            + "poisonous, false for being extinct and false for being endangered.\n"
            + "The Habitat sign of boston:\n"
            + "There are 1 amount of crocodile.\n"
            + "The crocodile, a reptile. it has tough skin. "
            + "Also it is false for being poisonous, false for "
            + "being extinct and false for being endangered.\n", life.printSign());
  }

  @Test
  public void map() {
    life.addHabitat(game);
    life.addAnimal(frags);
    assertEquals("add passed", "This is a map that list are all the "
            + "habitats by location and the natural features "
            + "in the habitat and species they house:\n"
            + "This is the map of the Habitat at illinois:\n"
            + "Natural features:\n[forest].\n" + "Species:\n[snake].\n", life.printMap());
  }

  @Test
  public void print() {
    life.addHabitat(game);
    life.addAnimal(frags);
    assertEquals("add passed", "These are all the index of species in each "
            + "of their habitats:\nThe Habitat located at illinois has "
            + "the following animal species:\n[snake].\n", life.printIndex());
  }

  @Test
  public void testingToString() {
    life.addHabitat(game);
    life.addAnimal(frags);
    assertEquals("add passed", "The reptile House has 3 habitat(s) "
            + "with 0 homeless animals.space left.\n", life.toString());
  }

  @Test
  public void testToString() {
    assertEquals("add passed", "There are no animals "
            + "in reptile House.\n", life.toString());
  }
}