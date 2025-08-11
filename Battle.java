
import utility.*;
import warrior.*;
import weapon.*;
import armour.*;

import java.util.Random;

public class Battle {
    // object creation
    private static Ink ink = new Ink();
    private static Validator validator = new Validator();
    private static Random randNum = new Random();
    private static Warrior player;
    private static Weapon pWeapon;
    private static Armour pArmour;
    private static Warrior enemy;
    private static Weapon eWeapon;
    private static Armour eArmour;

    // variables
    private static boolean isPlayerTurn = true;
    private static boolean gameOver = false;
    private static float damageAmount;
    private static int maxWarriors = 3; // the number of warrior types
    private static int maxWeapons = 3; // the number of weapon types
    private static int maxArmours = 3; // the number of armour types
    private static int maxAttackOptions = 2; // the number of attack types

    public static void main(String[] args) {
        ink.welcome();
        gameSetup();

        ///////////////////////////
    // Main game loop
    while(!gameOver) {
      if(isPlayerTurn) { // player turn logic
        // ask for the attack type
        ink.attackMenu();
        int attackType = validator.validateAttackPick(maxAttackOptions);

        // strike the enemy
        damageAmount = pWeapon.strike(
          attackType, player.getStrength(), player.getDexterity(), pArmour.getDexCost());
                    // 50 *= .60 = 20 damage 
                    // test test test and test! 
        damageAmount *= ((float)eArmour.getProtectionAmount() / 100);
        
        // apply damage if any
        if(damageAmount > 0) { // hit!
          // remove health from the enemy
          enemy.reduceHealth(damageAmount);
          // check if we have won (does the enemy have zero or less health?)
          if(enemy.getHealth() <= 0) {
            System.out.println("Player Wins!");
            gameOver = true;
          }
        }
        // prints player turn results
        // ink.printResults("Player", damageAmount, enemy);
                            // damage, enemy, "Player"
        ink.attackResult(damageAmount, enemy, "Player");
        damageAmount = 0;
      }
      else { // enemy turn logic
        int attackType = randNum.nextInt(2) + 1;

        // strike the player
        // strike the enemy
        damageAmount = eWeapon.strike(
          attackType, enemy.getStrength(), enemy.getDexterity(), eArmour.getDexCost());
                    // 60 - 40 = 20 damage remains  
        damageAmount *= ((float)pArmour.getProtectionAmount() / 100);

        // apply damage if any
        if(damageAmount > 0) { // hit!
          // remove health from the player
          player.reduceHealth(damageAmount);
          // check if we have won (does the player have zero or less health?)
          if(player.getHealth() <= 0) {
            System.out.println("Enemy Wins!");
            gameOver = true;
          }
        }
        // prints enemy turn results
        // ink.printResults("Enemy", damageAmount, player);
                            // damage, enemy, "Enemy"
        ink.attackResult(damageAmount, player, "Enemy");
        damageAmount = 0;
      }
      isPlayerTurn = !isPlayerTurn; // toggles turn from player to enemy yada yada
    } // while

    ink.goodbye();
    
  } // main()

  // Helper methods
  private static void createWarrior(String who, int choice) {
    switch (choice) {
      case 1: // human
        if(who.equals("Player"))
          player = new Human();
        else
          enemy = new Human();
        break;
      case 2: // elf
        if(who.equals("Player"))
          player = new Elf();
        else
          enemy = new Elf();
        break;
      case 3: // orc
        if(who.equals("Player"))
          player = new Orc();
        else
          enemy = new Orc();
        break;
      
      default:
        System.out.println("Oops! Something went wrong, blame Google.");
        break;
    } // switch
  } // createWarrior()

  private static void createWeapon(String who, int choice) {
    switch (choice) {
      case 1: // dagger
        if(who.equals("Player"))
          pWeapon = new Dagger();
        else
          eWeapon = new Dagger();
        break;
      case 2: // sword
        if(who.equals("Player"))
          pWeapon = new Sword();
        else
          eWeapon = new Sword();
        break;
      case 3: // axe
        if(who.equals("Player"))
          pWeapon = new Axe();
        else
          eWeapon = new Axe();
        break;
      
      default:
        System.out.println("Oops! Something went wrong, blame Google.");
        break;
    } // switch
  } // createWeapon()

  private static void createArmour(String who, int choice) {
    switch (choice) {
      case 1: // leather
        if(who.equals("Player"))
          pArmour = new Leather();
        else
          eArmour = new Leather();
        break;
      case 2: // chainmail
        if(who.equals("Player"))
          pArmour = new Chainmail();
        else
          eArmour = new Chainmail();
        break;
      case 3: // platemail
        if(who.equals("Player"))
          pArmour = new Platemail();
        else
          eArmour = new Platemail();
        break;
      
      default:
        System.out.println("Oops! Something went wrong, blame Google.");
        break;
    } // switch
  } // createArmour()

  private static void gameSetup() {
    ///////////////////////////
    // Player Warrior Setup
    ink.warriorMenu();
    int warPick = validator.validatePick(maxWarriors);
    createWarrior("Player", warPick);

    ///////////////////////////
    // Player Weapon Setup
    ink.weaponMenu();
    int wepPick = validator.validatePick(maxWeapons);
    createWeapon("Player", wepPick);

    ///////////////////////////
    // Player Armour Setup
    ink.armourMenu();
    int armPick = validator.validatePick(maxArmours);
    createArmour("Player", armPick);


    ///////////////////////////
    // Enemy Warrior Setup
    warPick = randNum.nextInt(3) + 1;
    createWarrior("Enemy", warPick);

    ///////////////////////////
    // Enemy Weapon Setup
    wepPick = randNum.nextInt(3) + 1;
    createWeapon("Enemy", wepPick);

    ///////////////////////////
    // Enemy Armour Setup
    armPick = randNum.nextInt(3) + 1;
    createArmour("Enemy", armPick);


    // prints all the stats!
    ink.printStats(player, pWeapon, pArmour, enemy, eWeapon, eArmour);
  } // gameSetup()

} // class