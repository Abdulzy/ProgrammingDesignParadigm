package dungeon;


/**
 * The builder class for level.
 */
public class MedievalLevelBuilder {
  private final Level base;
  private final int room;
  private int remainingRoom;
  private int remainingTreasure;
  private int remainingMonster;
  private int addedRooms;

  /**
   * Constructs the MedievalLevelBuilder class.
   *
   * @param numberOfLevel    The level number.
   * @param amountOfRoom     The amount of rooms on the level.
   * @param amountOfTreasure The amount of treasure on the level.
   * @param amountOfMonster  The amount of monsters on the level.
   * @throws IllegalArgumentException If any value is not a non-negative.
   */
  public MedievalLevelBuilder(int numberOfLevel, int amountOfRoom, int amountOfMonster,
                              int amountOfTreasure)
          throws IllegalArgumentException {
    if (numberOfLevel < 0 | amountOfRoom < 0 | amountOfTreasure < 0 | amountOfMonster < 0) {
      throw new IllegalArgumentException("Takes in only non negative");
    }
    base = new Level(numberOfLevel);
    room = amountOfRoom;
    remainingTreasure = amountOfTreasure;
    remainingRoom = amountOfRoom;
    remainingMonster = amountOfMonster;
    addedRooms = 0;
  }

  /**
   * Adds a room to the level.
   *
   * @param roomDescription Description of the room.
   * @throws IllegalArgumentException If there is no description.
   * @throws IllegalArgumentException If there are already max amount of rooms.
   */
  public void addRoom(String roomDescription) {
    if (roomDescription.isEmpty()) {
      throw new IllegalArgumentException("Didn't put a description of room");
    }
    if (checkMax(remainingRoom, "monster")) {
      base.addRoom(roomDescription);
      remainingRoom = remainingRoom - 1;
      addedRooms = addedRooms + 1;
    }
  }

  /**
   * Adds a certain amount of goblins to a room.
   *
   * @param roomNumber      The specific room the goblin is added to.
   * @param amountOfGoblins The amount of goblins being added.
   * @throws IllegalArgumentException If amount of goblins is not positive.
   */
  public void addGoblins(int roomNumber, int amountOfGoblins) {
    if (amountOfGoblins <= 0) {
      throw new IllegalArgumentException("Put in an amount of goblins");
    }
    for (int i = 0; i < amountOfGoblins; i++) {
      if ((checkValidity(roomNumber)) && checkMax(remainingMonster, i + "monster")) {
        Monster monster = new Monster("goblin", "mischievous "
                + "and very unpleasant, vengeful, and greedy creature whose primary "
                + "purpose is to cause trouble to humankind", 7);
        base.addMonster(roomNumber, monster);
        remainingMonster = remainingMonster - 1;
      }
    }
  }

  /**
   * Adds an orc to a room.
   *
   * @param roomNumber The specific room the orc is added to.
   */
  public void addOrc(int roomNumber) {
    if ((checkValidity(roomNumber)) && checkMax(remainingMonster, "monster")) {
      Monster monster = new Monster("orc", "brutish, aggressive, "
              + "malevolent being serving evil", 20);
      base.addMonster(roomNumber, monster);
      remainingMonster = remainingMonster - 1;
    }
  }

  /**
   * Adds an ogre to a room.
   *
   * @param roomNumber The specific room the ogre is added to.
   */
  public void addOgre(int roomNumber) {
    if ((checkValidity(roomNumber)) && checkMax(remainingMonster, "monster")) {
      Monster monster = new Monster("ogre", "large, hideous "
              + "man-like being that likes to eat humans for lunch", 50);
      base.addMonster(roomNumber, monster);
      remainingMonster = remainingMonster - 1;
    }
  }

  /**
   * Adds a human to a room.
   *
   * @param roomNumber   The specific room the human is added to.
   * @param humanName    The name of the human.
   * @param humanDetails The details of the human.
   * @param hitPoints    The hitpoint of the human.
   * @throws IllegalArgumentException If there is no name or description of human.
   * @throws IllegalArgumentException If hitpoint is not a non negative.
   */
  public void addHuman(int roomNumber, String humanName, String humanDetails, int hitPoints) {
    if (humanDetails.isEmpty() | humanName.isEmpty()) {
      throw new IllegalArgumentException("Didn't put in any human name or details");
    }
    if (hitPoints < 0) {
      throw new IllegalArgumentException("Doesnt have a non-negative hitpoint.");
    }
    if ((checkValidity(roomNumber)) && checkMax(remainingMonster, "monster")) {
      Monster monster = new Monster(humanName, humanDetails, hitPoints);
      base.addMonster(roomNumber, monster);
      remainingMonster = remainingMonster - 1;
    }
  }

  /**
   * Adds a potion to a room.
   *
   * @param roomNumber The specific room the potion is added to.
   * @throws IllegalArgumentException If there are already max amount of treasure.
   */
  public void addPotion(int roomNumber) {
    if ((checkValidity(roomNumber)) && checkMax(remainingTreasure, "treasure")) {
      Treasure treasure = new Treasure("a healing potion", 1);
      base.addTreasure(roomNumber, treasure);
      remainingTreasure = remainingTreasure - 1;
    }
  }

  /**
   * Adds gold to a room.
   *
   * @param roomNumber    The specific room the gold is added to.
   * @param treasureValue The value of gold.
   * @throws IllegalArgumentException If value of gold is negative.
   */
  public void addGold(int roomNumber, int treasureValue) {
    if (treasureValue < 0) {
      throw new IllegalArgumentException("Treasure must have non negative value");
    }
    if ((checkValidity(roomNumber)) && checkMax(remainingTreasure, "treasure")) {
      Treasure treasure = new Treasure("pieces of gold", treasureValue);
      base.addTreasure(roomNumber, treasure);
      remainingTreasure = remainingTreasure - 1;
    }
  }

  /**
   * Adds a weapon to a room.
   *
   * @param roomNumber        The specific room the weapon is added to.
   * @param weaponDescription The description of the weapon.
   * @throws IllegalArgumentException If there is no description of the weapon.
   */
  public void addWeapon(int roomNumber, String weaponDescription) {
    if (weaponDescription.isEmpty()) {
      throw new IllegalArgumentException("No description of weapon");
    }
    if ((checkValidity(roomNumber)) && checkMax(remainingTreasure, "treasure")) {
      Treasure treasure = new Treasure(weaponDescription, 10);
      base.addTreasure(roomNumber, treasure);
      remainingTreasure = remainingTreasure - 1;
    }
  }

  /**
   * Adds a special treasure to a room.
   *
   * @param roomNumber    The specific room the special treasure is added to.
   * @param treasureValue The value of the treasure.
   * @throws IllegalArgumentException If the description is negative.
   * @throws IllegalArgumentException If the treasure value is negative.
   */
  public void addSpecial(int roomNumber, String specialDescription, int treasureValue) {
    if (specialDescription.isEmpty()) {
      throw new IllegalArgumentException("String is empty");
    }
    if (treasureValue < 0) {
      throw new IllegalArgumentException("Treasure must have non negative value");
    }
    if ((checkValidity(roomNumber)) && checkMax(remainingTreasure, "treasure")) {
      Treasure treasure = new Treasure(specialDescription, treasureValue);
      base.addTreasure(roomNumber, treasure);
      remainingTreasure = remainingTreasure - 1;
    }
  }

  /**
   * Checks the validity of adding more rooms, treasures or monsters.
   *
   * @param remainingSpace Remaining space of the selected type
   * @param type           Rooms, treasures or monsters.
   * @return boolean
   * @throws IllegalArgumentException If there are already max amount of type.
   */
  private boolean checkMax(int remainingSpace, String type) {
    if (remainingSpace == 0) {
      throw new IllegalStateException("Max number of " + type);
    }

    return true;
  }


  /**
   * Checks the validity of the room.
   *
   * @param roomNumber The specific room that is being checked.
   * @return boolean
   * @throws IllegalArgumentException If the room number is either non existent or it has not been
   *                                  created.
   */
  private boolean checkValidity(int roomNumber) {
    if (room < roomNumber + 1 | 0 > roomNumber) {
      throw new IllegalArgumentException("Room doesn't exist");
    }
    if (addedRooms < roomNumber + 1 ) {
      throw new IllegalStateException("Room hasn't been created");
    }
    return true;
  }

  /**
   * Returns the toString of the class.
   *
   * @return toString
   */
  @Override
  public String toString() {
    return base.toString();
  }

  /**
   * Return a level.
   *
   * @return base
   * @throws IllegalStateException If the rooms, monsters, and treasures have not all been added.
   */
  public Level build() {
    if (remainingRoom > 0 | remainingMonster > 0 | remainingTreasure > 0) {
      throw new IllegalStateException("rooms is not fully created");
    }
    return base;
  }


}
