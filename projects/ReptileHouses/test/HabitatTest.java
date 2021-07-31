import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import reptilehouse.Amphibian;
import reptilehouse.Animal;
import reptilehouse.Habitat;
import reptilehouse.Habitats;
import reptilehouse.Reptile;


/**
 * Test the Habitat class.
 */
public class HabitatTest {
  private Habitats game;
  private Animal abdul;
  private Animal frags;

  /**
   * Initializing some values.
   */
  @Before
  public void setUp() {
    frags = new Reptile(" sNaKe ", "it has no legs", 2,
            " ForEst ", -20, 25,
            false, 3, true);
    abdul = new Reptile(" croCodIle ", "it has tough skin",
            2, " grass ", 25,
            30, false, 3, true);
    game = new Habitat("lekKi", 15);
  }

  @Test
  public void testingConstructor() {
    game = new Habitat("lekKi", 15);
    assertEquals("animal size", 15, game.getHabitatSize());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfNegative() {
    game = new Habitat("lekKi", -15);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullConstruct() {
    game = new Habitat(null, -15);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullAdd() {
    game.add(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullLookUp() {
    game.habitatLookUP(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNonLookUp() {
    game.habitatLookUP("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDifferentTypes() {
    Animal vic = new Amphibian(" frog ", "it lays eggs", 1,
            " ForEst ", -20,
            25, false, 3, true);
    game.add(frags);
    game.add(vic);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCoExist() {
    Animal vic = new Reptile(" frog ", "it lays eggs", 1,
            " ForEst ", -20,
            25, true, 3, false);
    game.add(frags);
    game.add(vic);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFirstAnimal() {
    Animal vic = new Reptile(" gecko ", "it lays eggs", 1,
            " walls ", -10,
            25, false, 3, false);
    Animal somto = new Reptile(" lizard ", "it annoying", 1,
            " lake ", -10,
            20, false, 3, true);
    game.add(vic);
    game.add(somto);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLocationLength() {
    game = new Habitat("", 15);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTemperatureRange() {
    Animal vic = new Reptile(" frog ", "it lays eggs", 1,
            " ForEst ", 31,
            39, false, 3, true);
    game.add(frags);
    game.add(abdul);
    game.add(vic);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNaturalFeatures() {
    Animal vic = new Reptile(" frog ", "it lays eggs", 1,
            " tree trunks ", -10, 18,
            false, 3, true);
    Animal bolu = new Reptile(" chameleon ", "it can change skin colour",
            1, " game ", 0, 39,
            false, 3, true);
    game.add(frags);
    game.add(abdul);
    game.add(vic);
    game.add(bolu);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemainingSize() {
    Animal vic = new Reptile(" frog ", "it lays eggs", 2,
            " tree trunks ", -10, 18,
            false, 3, true);
    Animal time = new Reptile(" chameleon ", "it can change skin colour",
            1, " forest ", 0, 39,
            false, 3, true);
    game.add(frags);
    game.add(abdul);
    game.add(vic);
    game.add(time);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAmphibian() {
    Animal vic = new Amphibian(" frog ", "it lays eggs", 1,
            " wall ", 10,
            30, false, 3, true);
    Animal somto = new Amphibian(" toad ", "it can swim", 1,
            " wall ", 9,
            35, false, 3, true);
    game.add(abdul);
    game.add(frags);
    game.add(vic);
    game.add(somto);
  }

  @Test
  public void add() {
    game.add(frags);
    game.add(abdul);
    List<String> array = new ArrayList<>();
    array.add("forest");
    array.add("grass");
    assertEquals("add passed", array.get(0), game.naturalFeatures().get(0));
  }

  @Test
  public void getHabitatName() {
    assertEquals("Habitat name passed", "lekki", game.getHabitatLocation());
  }

  @Test
  public void getHabitatSize() {
    assertEquals("Habitat size passed", 15, game.getHabitatSize());
  }

  @Test
  public void habitatSize() {
    Animal vic = new Reptile(" snake ", "it lays eggs", 1,
            " fores ", -10,
            19, false, 1, true);
    Animal somto = new Reptile(" crocodile ", "They are predators", 3,
            " tree trunks ", -11,
            18, false, 3, true);
    game.add(vic);
    game.add(somto);
    assertEquals("space left passed", 15, game.getHabitatSize());
  }

  @Test
  public void naturalFeatures() {
    Animal vic = new Reptile(" snake ", "it lays eggs", 1,
            " fores ", -10,
            19, false, 1, true);
    Animal somto = new Reptile(" crocodile ", "They are predators", 3,
            " tree trunks ", -11,
            20, false, 3, true);
    game.add(vic);
    game.add(somto);
    List<String> array = new ArrayList<>();
    array.add("forest");
    array.add("tree trunks");
    assertEquals("Natural features passed", array.get(1), game.naturalFeatures().get(1));
  }


  @Test
  public void testLookUp() {
    game.add(frags);
    game.add(abdul);
    assertEquals("look up passed", true, game.habitatLookUP("snake"));
  }

  @Test
  public void testNotLookUp() {
    game.add(frags);
    game.add(abdul);
    assertEquals("look up passed", false, game.habitatLookUP("cat"));
  }

  @Test
  public void testSign() {
    String somto = "The Habitat sign of lekki:\nThere are 1 amount of snake.\n"
            + "There are 1 amount of crocodile.\n"
            + "The snake, a reptile. it has no legs. Also it is false for being "
            + "poisonous, false for being extinct and false for being endangered.\n"
            + "The crocodile, a reptile. it has tough skin. Also it is false for being "
            + "poisonous, false for being extinct and false for being endangered.\n";
    game.add(frags);
    game.add(abdul);
    assertEquals("Sign passed", somto, game.getHabitatSign());
  }

  @Test
  public void testEmptySign() {
    assertEquals("Sign passed", "There are no animals in "
            + "lekki habitat.\n", game.getHabitatSign());
  }

  @Test
  public void testMap() {
    String somto = "This is the map of the Habitat at lekki:\nNatural features:\n"
            + "[forest, grass].\nSpecies:\n[snake, crocodile].\n";
    game.add(frags);
    game.add(abdul);
    assertEquals("Map passed", somto, game.getHabitatMap());
  }

  @Test
  public void testEmptyMap() {
    assertEquals("Map passed", "There are no animals in "
            + "lekki habitat.\n", game.getHabitatMap());
  }


  @Test
  public void testIndex() {
    String somto = "The Habitat located at lekki has the following animal species:\n"
            + "[crocodile, snake].\n";
    game.add(frags);
    game.add(abdul);
    assertEquals("Index passed", somto, game.getHabitatIndex());
  }

  @Test
  public void testEmptyIndex() {
    assertEquals("Index passed", "There are no animals in "
            + "lekki habitat.\n", game.getHabitatIndex());
  }

  @Test
  public void testingToString() {
    game.add(frags);
    game.add(abdul);
    assertEquals("toString passed", "The Habitat located at lekki has "
            + "[forest, grass] with 5 square meter space left.\n", game.toString());
  }

  @Test
  public void testEmptyToString() {
    assertEquals("ToString passed", "There are no animals in "
            + "lekki habitat.\n", game.toString());
  }
}