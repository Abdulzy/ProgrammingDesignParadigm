package gears;

import java.util.ArrayList;
import java.util.List;

public class Main {
  /**
   * Main class.
   * @param args Declaration.
   */
  public static void main(String []args) {

    Characters playerOne = new Character("Abdul", 100,50,60);
    Characters playerTwo = new Character("Vic", 100,60,50);
    Battles fight = new Battle(6,10,18,20,playerOne,playerTwo);
    // Head gears
    DefenseGear head = new HeadGear("Helm", "Flight", false, 100);
    DefenseGear headTwo = new HeadGear("Mask", "rock", true, 120);
    DefenseGear headThree = new HeadGear("Headband", "Flame", false, 110);
    DefenseGear headFour = new HeadGear("Cap", "Healing", true, 120);
    DefenseGear headFive = new HeadGear("Balaclava", "Speed", false, 110);
    DefenseGear headSix = new HeadGear("Hood", "Persuasion", true, 120);
    fight.addHeadGear(head);
    fight.addHeadGear(headTwo);
    fight.addHeadGear(headThree);
    fight.addHeadGear(headFour);
    fight.addHeadGear(headFive);
    fight.addHeadGear(headSix);

    // Foot gears
    AttackGear foot = new FootGear("Boots", "Electricity", true, 100);
    AttackGear footTwo = new FootGear("slipper", "fire", true, 120);
    AttackGear footThree = new FootGear("slides", "water", false, 130);
    AttackGear footFour = new FootGear("Shoes", "Magic", true, 120);
    AttackGear footFive = new FootGear("Sneaker", "Ruin", false, 130);
    AttackGear footSix = new FootGear("anklet", "Sleep", true, 100);
    AttackGear footSeven = new FootGear("Hoverboard", "Vision", true, 120);
    AttackGear footEight = new FootGear("RollerBlades", "Disguise", false, 130);
    AttackGear footNine = new FootGear("Segway", "Rain", true, 120);
    AttackGear footTen = new FootGear("Skates", "Ice", false, 130);
    fight.addFootGear(foot);
    fight.addFootGear(footTwo);
    fight.addFootGear(footThree);
    fight.addFootGear(footFour);
    fight.addFootGear(footFive);
    fight.addFootGear(footSix);
    fight.addFootGear(footSeven);
    fight.addFootGear(footEight);
    fight.addFootGear(footNine);
    fight.addFootGear(footTen);

    // Hand  gears
    AttackGear attackHand = new HandGear.HandFactory().createAttackHandGear("Ring", "Shock", true, 100);
    DefenseGear defenseHand = new HandGear.HandFactory().createDefenseHandGear("Signet", "Speed", true, 100);
    AttackGear attackHandOne = new HandGear.HandFactory().createAttackHandGear("Glove", "Speed", false, 110);
    AttackGear attackHandTwo = new HandGear.HandFactory().createAttackHandGear("BrassKnuckles", "Healing", true, 120);
    AttackGear attackHandThree = new HandGear.HandFactory().createAttackHandGear("Gauntlet", "Flame", false, 130);
    AttackGear attackHandFour = new HandGear.HandFactory().createAttackHandGear("Watch", "Escape", true, 140);
    AttackGear attackHandFive = new HandGear.HandFactory().createAttackHandGear("Bracelet", "Ruin", false, 150);
    DefenseGear defenseHandSix = new HandGear.HandFactory().createDefenseHandGear("Nail knife", "Telepathy", true, 110);
    DefenseGear defenseHandSeven = new HandGear.HandFactory().createDefenseHandGear("mitten ", "Strength", true, 120);
    DefenseGear defenseHandEight = new HandGear.HandFactory().createDefenseHandGear("bangle", "Ice", false, 130);
    DefenseGear defenseHandNine = new HandGear.HandFactory().createDefenseHandGear("Fit Band ", "Wind", true, 140);
    DefenseGear defenseHandTen = new HandGear.HandFactory().createDefenseHandGear("Knuckle Duster", "Explosion", true, 150);
    AttackGear attackHandEleven = new HandGear.HandFactory().createAttackHandGear("Bracelet", "Ruin", false, 150);
    DefenseGear defenseHandTwelve = new HandGear.HandFactory().createDefenseHandGear("Nail knife", "Telepathy", true, 110);
    DefenseGear defenseHandThird = new HandGear.HandFactory().createDefenseHandGear("mitten ", "Strength", true, 120);
    DefenseGear defenseHandFourth = new HandGear.HandFactory().createDefenseHandGear("bangle", "Ice", false, 130);
    DefenseGear defenseHandFifth = new HandGear.HandFactory().createDefenseHandGear("Fit Band ", "Wind", true, 140);
    DefenseGear defenseHandSixth = new HandGear.HandFactory().createDefenseHandGear("Knuckle Duster", "Explosion", false, 150);
    fight.addHandGear(attackHand);
    fight.addHandGear(attackHandOne);
    fight.addHandGear(attackHandTwo);
    fight.addHandGear(attackHandThree);
    fight.addHandGear(attackHandFour);
    fight.addHandGear(attackHandFive);
    fight.addHandGear(attackHandEleven);
    fight.addHandGear(defenseHand);
    fight.addHandGear(defenseHandSix);
    fight.addHandGear(defenseHandSeven);
    fight.addHandGear(defenseHandEight);
    fight.addHandGear(defenseHandNine);
    fight.addHandGear(defenseHandTen);
    fight.addHandGear(defenseHandTwelve);
    fight.addHandGear(defenseHandThird);
    fight.addHandGear(defenseHandFourth);
    fight.addHandGear(defenseHandFifth);
    fight.addHandGear(defenseHandSixth);

    // Jewelry
    AttackGear  attackJewel = new Jewelry.JewelryFactory().createAttackJewelry("Amulet", "Heft", false, 130);
    DefenseGear defenseJewel = new Jewelry.JewelryFactory().createDefenseJewelry("Necklace", "Invincibility", true, 120);
    AttackGear  attackJewelOne = new Jewelry.JewelryFactory().createAttackJewelry("Scarab", "Flight", false, 150);
    DefenseGear defenseJewelOne = new Jewelry.JewelryFactory().createDefenseJewelry("Collar", "Electricity", true, 110);
    AttackGear  attackJewelTwo = new Jewelry.JewelryFactory().createAttackJewelry("Brooch", "Speed", false, 120);
    DefenseGear defenseJewelTwo = new Jewelry.JewelryFactory().createDefenseJewelry("Ribbon", "Swimming", true, 100);
    AttackGear  attackJewelThree = new Jewelry.JewelryFactory().createAttackJewelry("BowTie", "Drunkenness", false, 130);
    DefenseGear defenseJewelThree = new Jewelry.JewelryFactory().createDefenseJewelry("Chain", "Sight", true, 120);
    AttackGear  attackJewelFour = new Jewelry.JewelryFactory().createAttackJewelry("Pendant", "Healing", false, 140);
    DefenseGear defenseJewelFour = new Jewelry.JewelryFactory().createDefenseJewelry("chain", "Sleep", true, 110);
    AttackGear  attackJewelFive = new Jewelry.JewelryFactory().createAttackJewelry("Amulet", "Magic", false, 150);
    DefenseGear defenseJewelFive = new Jewelry.JewelryFactory().createDefenseJewelry("Necklace", "Flame", true, 120);
    AttackGear  attackJewelSix = new Jewelry.JewelryFactory().createAttackJewelry("chain", "Burning", false, 130);
    DefenseGear defenseJewelSix = new Jewelry.JewelryFactory().createDefenseJewelry("Scarab", "Escape", true, 100);
    AttackGear  attackJewelSeven = new Jewelry.JewelryFactory().createAttackJewelry("Collar", "Ruin", false, 110);
    DefenseGear defenseJewelSeven = new Jewelry.JewelryFactory().createDefenseJewelry("Brooch", "Telepathy", true, 150);
    AttackGear  attackJewelEight = new Jewelry.JewelryFactory().createAttackJewelry("Ribbon", "Teleportation", false, 120);
    DefenseGear defenseJewelEight = new Jewelry.JewelryFactory().createDefenseJewelry("BowTie", "Strength", true, 140);
    AttackGear  attackJewelNine = new Jewelry.JewelryFactory().createAttackJewelry("Chain", "Explosion", false, 120);
    DefenseGear defenseJewelNine = new Jewelry.JewelryFactory().createDefenseJewelry("Pendant", "Ice", true, 130);
    fight.addJewelry(attackJewel);
    fight.addJewelry(attackJewelTwo);
    fight.addJewelry(attackJewelThree);
    fight.addJewelry(attackJewelFour);
    fight.addJewelry(attackJewelFive);
    fight.addJewelry(attackJewelSix);
    fight.addJewelry(attackJewelSeven);
    fight.addJewelry(attackJewelEight);
    fight.addJewelry(attackJewelNine);
    fight.addJewelry(attackJewelOne);
    fight.addJewelry(defenseJewel);
    fight.addJewelry(defenseJewelOne);
    fight.addJewelry(defenseJewelTwo);
    fight.addJewelry(defenseJewelThree);
    fight.addJewelry(defenseJewelFour);
    fight.addJewelry(defenseJewelFive);
    fight.addJewelry(defenseJewelSix);
    fight.addJewelry(defenseJewelSeven);
    fight.addJewelry(defenseJewelEight);
    fight.addJewelry(defenseJewelNine);
    // predict the battle

    fight.predict();



    List<Gear> gears = new ArrayList<>();
    List<Gear> gearsTwo = new ArrayList<>();



  }
}
