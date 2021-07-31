# Reptile House

Reptile house is a program that implements and designs a tracking system for many Reptile Houses which house reptiles and amphibians in a number of different habitats.

## About

The problem was to find a way to track all Reptile houses, the possible Habitats in those houses, and the Animals in and out of Habitats but inside the Reptile House. All of which have their own class.
Tracking an Animal with an object which can be stored in an List in both the Habitat and Reptile House. Tracking the habitat with an object of type Habitat which can also be stored in a List in the Reptile House.
All the classes are in a package called reptilehouse.

```java
package reptilehouse
```
###The fields for the Amphibian and Reptile class:
```java
private final String animalName;
private final String animalCharacteristics;
private final int animalSize;
private final String naturalFeature;
private final int lowerTemperature;
private final int higherTemperature;
private final Boolean poison;
private final int extinctOrEndangered;
private final  Boolean coExist;
```

###The fields for the Habitat class:
```java
private List<Animal> inhabitants;
private final String habitatLocation;
private final int habitatSize;
private int remainingSize;
private List<String> naturalFeature;
```

###The fields for the House(Reptile House)class:
```java
private List<Animal> homelessAnimals;
private List<Habitats> habitats;
private final int maxHabitat;
```

## List Of Features

###The features of the Amphibian and Reptile class:
```java
  /**
   * Returns the name of the animal.
   *
   * @return animal name
   */
  String getAnimalSpecies();

  /**
   * Returns the size of the animal.
   *
   * @return animal size
   */
  String getAnimalSize();

  /**
   * Returns the characteristics of the animal.
   *
   * @return animal characteristics
   */
  String getAnimalCharacteristics();

  /**
   * Returns the natural feature of the animal.
   *
   * @return natural feature
   */
  String getNaturalFeature();

  /**
   * Returns the lower temperature range of the animal.
   *
   * @return lower temperature
   */
  int lowerTemperature();

  /**
   * Returns the higher temperature range of the animal.
   *
   * @return higher temperature
   */
  int higherTemperature();

  /**
   * Checks if animal is poisonous, Returns boolean.
   *
   * @return poison
   */
  boolean checkPoison();

  /**
   * Checks if animal is extinct, Returns boolean.
   *
   * @return extinct
   */
  boolean checkExtinct();

  /**
   * Checks if animal is endangered, Returns boolean.
   *
   * @return endangered
   */
  boolean checkEndangered();

  /**
   * Using extinct, posionous and endangered to find out if animal can co-exist with other animals,
   * returns boolean.
   *
   * @return co-exist
   */
  boolean coExist();
```

###The features of the Habitat class:
```java
  /**
   * Adds an animal to the habitat.
   */
  void add(Animal animal);

  /**
   * Returns the name of the habitat.
   *
   * @return Habitat name
   */
  String getHabitatLocation();

  /**
   * Returns the name of the habitat.
   *
   * @return Habitat size
   */
  int getHabitatSize();

  /**
   * Returns an array of all the natural features.
   *
   * @return Natural features
   */
  List<String> naturalFeatures();

  /**
   * Returns boolean for searched species.
   *
   * @return boolean.
   */
  Boolean habitatLookUP(String s);

  /**
   * Returns a sign of the habitat.
   *
   * @return Habitat sign.
   */
  String getHabitatSign();

  /**
   * Returns an map of the habitat.
   *
   * @return Habitat map.
   */
  String getHabitatMap();

  /**
   * Returns an index of the habitat.
   *
   * @return Habitat index.
   */
  String getHabitatIndex();
```

###The features of the House(Reptile House) class:
```java
  /**
   * Adds an animal to the reptile house.
   */
  void addAnimal(Animal animal);

  /**
   * Adds a habitat to the reptile house.
   */
  void addHabitat(Habitats habitat);

  /**
   * Returns the amount of habitat in reptile house.
   *
   * @return amount of habitats
   */
  int getAmountOfHabitats();

  /**
   * Returns the maximum amount of habitat in reptile house.
   *
   * @return amount of habitats
   */
  int getMaxAmountOfHabitats();

  /**
   * Report the natural features that are currently being used in alphabetical order. This list
   * should include the habitat(s) where the natural feature is located and how much space is left
   * in the habitat for additional animals measured in square meters.
   */
  String reportNaturalFeatures();

  /**
   * Look up which habitat(s) that house a particular species. If a species is found but not
   * currently inhabiting a habitat, it should report this.
   */
  String lookUp(String species);


  /**
   * Print a sign for any given habitat that lists the species that it houses along with a
   * description of the species and an indicator of how many of that species is housed in
   * that habitat. Each species description should include their name,
   * their defining characteristics, as well as
   * other interesting features (poisonous, extinct, endangered)
   */
  String printSign();

  /**
   * Print a “map” that lists all the habitats by location and the natural features in the habitat
   * and species they house.
   */
  String printMap();

  /**
   * Print an index that lists all species in the Reptile House in alphabetical order and their
   * location(s).
   */
  String printIndex();
```

## How To Run
Click [here](https://www.jetbrains.com/help/idea/compiling-applications.html) to see how to run .jar file.
My .jar file has no arguments, using the link above you can run it to see the example of my run which was hard coded.

## How to Use the Program
Using the functionality of any specific class follow the format of "object name of specific class"."name of method()" e.g "boston.getHabitatSize()", boston being a Habitat object.
Looking at the ExampleRun1.txt file you can see how to create objets for specific classes. It can be run in multiple ways that 

## Description of Example Runs.
Run 1 -- Filename: ExampleRun1.txt:
1. It prints information about the reptile house
2. modify reptile house.
3. Prints information about modified reptile house.

## Design/Model Changes
Compared to my version 1, I have added multiple interfaces to the design.



## Assumptions
if the temperature range has exactly the same value it counts as overlapping. Also assumed that client inputs actual words inside any string argument instead of words that aren't descriptive.


## Limitations
I used a list and a couple of for loops and nested for loops which has a not so wonderful time complexity and also space complexity. Apart from the way data is saved and iterated through, there seems to be no other limitations I am aware of.
