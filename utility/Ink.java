package utility;

import warrior.Warrior;
import weapon.*;
import armour.*;

public class Ink {
    // ANSI escape codes
    public static final String RESET ="\u001B[0m";
    public static final String BLACK = "\u001B[30m"; // not really black
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public void welcome() {
        System.out.println("=================================");
        System.out.println("== Welcome to the Warsim 2025! ==");
        System.out.println("=================================");
    } // welcome()

    public void warriorMenu() {
        System.out.println("\n===============================");
        System.out.println("== Select your warrior...");
        System.out.println("== 1) Human");
        System.out.println("== 2) Elf");
        System.out.println("== 3) Orc");
        System.out.println("===============================\n");
    } // warriorMenu()

    public void weaponMenu() {
        System.out.println("\n===============================");
        System.out.println("== Select your weapon...");
        System.out.println("== 1) Dagger");
        System.out.println("== 2) Sword");
        System.out.println("== 3) Axe");
        System.out.println("===============================\n");
    } // weaponMenu()

    public void attackMenu() {
        System.out.println("\n===============================");
        System.out.println("== Choose your attack:");
        System.out.println("== 1) Normal");
        System.out.println("== 2) Heavy");
        System.out.println("== 3) Special");
        System.out.println("===============================\n");
    } // attackMenu()

    public void printWarriorStats(Warrior warrior) {
        System.out.println("\n===============================");
        System.out.println("== Stats:");
        System.out.printf("== Health %d%n", warrior.getHealth());
        System.out.printf("== Strength %d%n", warrior.getStrength());
        System.out.printf("== Dexterity %d%n", warrior.getDexterity());
        System.out.println("===============================\n");
    } // printWarriorStats()

} // class
