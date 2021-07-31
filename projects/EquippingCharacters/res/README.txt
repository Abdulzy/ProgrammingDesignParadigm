
# Equipping Characters

Equipping characters is a program that predicts a fight between 2 players.

## About

The program creates a battle ground which the user can specify the two players and the maximum amount of gear the chest can have which have a specified minimum. 
Adds a couple of gears to the chest, When the two players are predicted to fight the program would crash if the chest hasn't reach the mimum amount of gear. 
If it has reached the minimum then the players equip the gears and a prediction occurs. Rematch is possible if user types in true and ends the prediction if false.
All the classes implement the package called gears.

```java
package gears
```

## List Of Features

###The features of the Gear classes:
All the gear classes implement almost the same thing except for a seperation when a gear is either an attack gear or defense gear.
Gears after successful creation can return their:
Attack power or defense power.
Name.
Adjective.
If it can wear out then it would wear out when called.
Can combine names, attack power, defense power.
Can compare different gears.
Can verify which type of gear a gear is.
ToString that describes the gear.

####Gear class
```java
  /**
   * Returns the name of the gear.
   * @return name
   */
  String getName();

  /**
   * Returns the adjective of the gear.
   * @return adjective
   */
  String getAdjective();

  /**
   * Wears out the gear by a specified value by the user.
   */
  void wearOut();

  /**
   * Returns the combined string of all the gears.
   * @param a
   * @return combined string
   */
  String combineName(List<AbstractGear> a);

  /**
   * Returns the combined attack of all the gears.
   * @param a
   * @return combined power
   */
  int combineAttackPower(List<AbstractGear> a);

  /**
   * Returns the combined defense of all the gears.
   * @param a
   * @return combined power
   */
  int combineDefensePower(List<AbstractGear> a);

  /**
   * Returns whether the gear is a hand gear or not.
   * @return boolean
   */
  boolean areYouMe(Gear a);

  /**
   * Returns whether the gear is a head gear or not.
   * @return boolean
   */
  boolean isHeadGear();

  /**
   * Returns whether the gear is a foot gear or not.
   * @return boolean
   */
  boolean isFootGear();

  /**
   * Returns whether the gear is a hand gear or not.
   * @return boolean
   */
  boolean isHandGear();

  /**
   * Returns whether the gear is a jewelry or not.
   * @return boolean
   */
  boolean isJewelry();
```

#### AttackGear class
```java
 /**
   * Returns the Attack power of the gear.
   * @return Attack
   */
  int getAttack();
```
#### DefenseGear class
```java
 /**
   * Returns the defense power of the gear.
   * @return defense
   */
  int getDefense();
```

###The features of the Character class:
Characters after successful creation can return their:
Base attack power.
Base defense power.
Name.
Adjective.
HitPoints.
Equip gears.
Modified attack power due to equiping gear.
Modified defense power due to equiping gear.
Wear out the character which wears out the gear that is equipped.
ToString that describes the gear that is equipped and the base attack and defense with the modified attack and defense.

```java
  /**
   * Returns the name of the character.
   * @return name
   */
  String getName();

  /**
   * Returns the base hitpoint of the character.
   * @return hitpoint
   */
  int getHitPoint();

  /**
   * Returns the attack of the character.
   * @return attack
   */
  int getBaseAttack();

  /**
   * Returns the defense of the character.
   * @return defense
   */
  int getBaseDefense();

  /**
   * Returns the attack of the character plus the attack of the gear.
   * @return attack
   */
  int getModifiedAttack();

  /**
   * Returns the defense of the character plus the defense of the gear.
   * @return defense
   */
  int getModifiedDefense();

  /**
   * Wears out the all gear being used by the user by  a specified value.
   */
  void wearOut();

  /**
   * Equips the character with a gear.
   * @param o Gear object
   */
  void equip(Gear o); 
```

## How To Run
Click [here](https://www.jetbrains.com/help/idea/compiling-applications.html) to see how to run .jar file.
My .jar file has no arguments, using the link above you can run it to see the example of my run which was hard coded.

## How to Use the Program
Using the functionality of any specific class follow the format of "object name of specific class"."name of method()" e.g "playerOne.toString()", playerOne being a Character object.
Looking at the ExampleRun1.txt and ExampleRun2.txt files you can see how to create objets for specific classes. It can be run in multiple ways.

## Description of Example Runs.
Run 1 -- Filename: ExampleRun1.txt:
1. Create the battle object, 2 characters, multiple gears.
2. Add gears to the pausible chest options.
3. put in true for rematch a couple of times.
4. Prints information about the predicted fight.

Run 2 -- Filename: ExampleRun2.txt:
1. Create the battle object, 2 characters, multiple gears.
2. Add gears to the pausible chest options.
3. put in true for rematch a couple of times.
4. Prints information about the predicted fight.

## Design/Model Changes
Compared to my version 1, I have added multiple interfaces and different fields. See "Updated UML Diagram" for changes from "UML Diagram".



## Assumptions
Maximum amount of gears that can be added to the chest is 2 plus the minimum to avoid excessive amount of gears.
Hand gears and Jewelrys must be created through gearFactory class for optimum functionality.
A gear is considered cursed if it has negative defense or attack stats.
Character can't be constructed with non positive hitpoint, defense and attack values.

## Limitations
Chest can only be built when the prediction of characters battle happens. Chest also does not get updated after a prediction has been made, can only be updated before a battle is predicted.
Attacking or defending jewelry and hand gear can have values for defending or attacking, irespective of the type of gear.
Using an Attacking Jewelry or hand gear to get defense would result in an error and vice versa.
Can add multiple of the same object to the chest Battle(class) gears.
To rematch a fight client must put in true or false can't put in any other value or code would crash.