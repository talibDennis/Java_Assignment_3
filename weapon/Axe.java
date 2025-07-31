package weapon;

public class Axe extends Weapon {
    private int baseDamage = 150;
    private int baseDexterityCost = 50;

    public Axe() {
        super("Axe");
        super.setDamageAmount(baseDamage);
        super.setDexterityCost(baseDexterityCost);
    } // constructor

    // strike
  public int strike(int attackType, int strength, int dexterity) {
    int damageAmount = 0;


    return damageAmount;
  }
}// strike
