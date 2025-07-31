
import utility.*;
import warrior.*;
import weapon.*;

import java.util.Scanner;

public class Battle {
    // object creation
    private static Scanner input = new Scanner(System.in);
    private static Ink ink = new Ink();
    private static Warrior player;
    private static Weapon pWeapon;
    private static Warrior enemy;
    private static Weapon eWeapon;

    // variables
    private static boolean isPlayerTurn = true;
    private static boolean gameOver = false;

    public static void main(String[] args) {
        ink.welcome();

        // ============================================>>
        // === Warrior selection/creation ==>>
        ink.weapon(); // prints the warrior selecton menu
        int wepPick = input.nextInt();
        createWeapon(wepPick);
        ink.printWarriorStats(player);

        // ================================>>
        // === Main game loop ==>>
        while (!gameOver) {
            if (isPlayerTurn) { // Player's turn
                ink.attackMenu();
                int attackType = input.nextInt();
                int damage = pWeapon.strike(attackType, player.getStrength(), player.getDexterity());

                if (damage > 0) {
                    // damage the enemy!
                    // check to see if the enemy is defeated
                    if (enemy.getHealth() <= 0) {
                        System.out.println("Player Wins!");
                        gamOver = true;
                    }
                } else { // miss!
                         // print missed message
                }
            } else { // enemy's turn

            }
            isPlayerTurn = !isPlayerTurn; // toggles who's turn it is
        } // while

        input.close();
    } // main

    private static void createWarrior(int choice) {
        switch (choice) {
            case 1: // human
                player = new Human();
                break;
            case 2: // elf
                player = new Elf();
                break;
            case 3: // orc
                player = new Orc();
                break;

            default:
                System.out.println("oops!");
                break;
        }
    } // createWarrior()

    private static void createWeapon(int choice) {
        switch (choice) {
            case 1: // dagger();
                pWeapon = new Dagger();
                break;
            case 2: // sword
                pWeapon = new Sword();
                break;
            case 3: // axe
                pWeapon = new Axe();
                break;

            default:
                System.out.println("oops!");
                break;
        }
    } // createWeapon()

} // class
