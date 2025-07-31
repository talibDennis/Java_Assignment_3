package weapon;

public class Dagger extends Weapon {
    private int baseDamage = 50;
    private int baseDexterityCost = 5;

    public Dagger() {
        super("Dagger");
        super.setDamageAmount(baseDamage);
        super.setDexterityCost(baseDexterityCost);
    } // constructor

    // strike
    public int strike(int attackType, int strength, int dexterity) {
        int damageAmount = 0;

        // can be different in many many ways!

        return damageAmount;
    } // strike

} // class