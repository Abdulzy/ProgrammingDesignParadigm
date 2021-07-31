package gears;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Battle implements Battles {
  private final Characters firstPlayer;
  private final Characters secondPlayer;
  private final int maxHead;
  private final int maxFoot;
  private final int maxHand;
  private final int maxJewelry;
  private final List<HeadGear> headGears;
  private final List<FootGear> footGears;
  private final List<HandGear> handGears;
  private final List<Jewelry> jewelrys;
  private final List<Gear> chest;


  public Battle(int maxHeadGear, int maxFootGear, int maxHandGear, int maxJewelryGear, Characters playerOne, Characters playerTwo) throws IllegalArgumentException {
    if (playerOne == null | playerTwo == null) {
      throw new IllegalArgumentException("Characters can't be null");
    }
    if (maxHeadGear < 5) {
      throw new IllegalArgumentException("Head gears must be a minimum of 4");
    }
    if (maxFootGear < 9) {
      throw new IllegalArgumentException("Foot gears must be a minimum of 8");
    }
    if (maxHandGear < 16) {
      throw new IllegalArgumentException("Hand gears must be a minimum of 15");
    }
    if (maxJewelryGear < 16) {
      throw new IllegalArgumentException("Jewelry must be a minimum of 15");
    }
    maxHead = maxHeadGear;
    maxFoot = maxFootGear;
    maxHand = maxHandGear;
    maxJewelry = maxJewelryGear;
    firstPlayer = playerOne;
    secondPlayer = playerTwo;
    headGears = new ArrayList<>();
    footGears = new ArrayList<>();
    handGears = new ArrayList<>();
    jewelrys = new ArrayList<>();
    chest = new ArrayList<>();
  }

  @Override
  public void addHeadGear(Gear headGear) {
    if (headGears.size() == maxHead) {
      throw new IllegalArgumentException("Max amount of head gears reached");
    }
    headGears.add((HeadGear) headGear);
  }

  @Override
  public void addFootGear(Gear footGear) {
    if (footGears.size() == maxFoot) {
      throw new IllegalArgumentException("Max amount of head gears reached");
    }
    footGears.add((FootGear) footGear);
  }

  @Override
  public void addHandGear(Gear handGear) {
    if (handGears.size() == maxHand) {
      throw new IllegalArgumentException("Max amount of head gears reached");
    }
    handGears.add((HandGear) handGear);
  }

  @Override
  public void addJewelry(Gear jewelry) {
    if (jewelrys.size() == maxJewelry) {
      throw new IllegalArgumentException("Max amount of head gears reached");
    }
    jewelrys.add((Jewelry) jewelry);
  }

  private void buildChest() {
    if (headGears.size() < 4) {
      throw new IllegalArgumentException("Minimum number of head gears not added");
    }
    if (footGears.size() < 8) {
      throw new IllegalArgumentException("Minimum number of foot gears not added");
    }
    if (handGears.size() < 15) {
      throw new IllegalArgumentException("Minimum number of hand gears not added");
    }
    if (jewelrys.size() < 15) {
      throw new IllegalArgumentException("Minimum number of jewelry not added");
    }
    chest.clear();
    chest.addAll(headGears);
    chest.addAll(footGears);
    chest.addAll(handGears);
    chest.addAll(jewelrys);
  }

  private void dressFirstPlayer() {
    int amountOfItems = 0;
    Random rand = new Random();
    while (amountOfItems < 20) {
      int which = rand.nextInt(chest.size());
      firstPlayer.equip(chest.get(which));
      amountOfItems++;
    }
  }

  private void dressSecondPlayer() {
    int amountOfItems = 0;
    Random rand = new Random();
    while (amountOfItems < 20) {
      int which = rand.nextInt(chest.size());
      secondPlayer.equip(chest.get(which));
      amountOfItems++;
    }
  }

  public void predict() {
    buildChest();
    boolean rematch = true;
    while (rematch) {
      dressFirstPlayer();
      dressSecondPlayer();
      int firstPlayerDamage = secondPlayer.getModifiedAttack() - firstPlayer.getModifiedDefense();
      int secondPlayerDamage = firstPlayer.getModifiedAttack() - secondPlayer.getModifiedDefense();
      if (firstPlayerDamage < 1) {
        firstPlayerDamage = 1;
      }
      if (secondPlayerDamage < 1) {
        secondPlayerDamage = 1;
      }
      int playerOneRounds = firstPlayer.getHitPoint() / secondPlayerDamage;
      int playerTwoRounds = secondPlayer.getHitPoint() / firstPlayerDamage;
      if (playerOneRounds > playerTwoRounds) {
        System.out.printf("%s has won the fight.%n", firstPlayer.getName());
      } else if (playerTwoRounds > playerOneRounds) {
        System.out.printf("%s has won the fight.%n", secondPlayer.getName());
      } else {
        System.out.printf("The fight between %s and %s was a "
                + "tie.%n", firstPlayer.getName(), secondPlayer.getName());
      }
      firstPlayer.wearOut();
      secondPlayer.wearOut();
      System.out.println("Do want a rematch? true for yes/ false for no");
      Scanner in = new Scanner(System.in);
      rematch = in.nextBoolean();
    }
  }

}
