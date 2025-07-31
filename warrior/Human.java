package warrior;

public class Human extends Warrior {
    private int minHealth = 100; // min amount a Human warrior starts with
    private int healthRange = 60; // the bonus or extra range for the health stat
    private int minStrength = 50;
    private int strengthRange = 50;
    private int minDexterity = 50;
    private int dexterityRange = 20;

    public Human() {
        super("Human");
        // 0 - 59 + 100 = 100 to 159
        super.setHealth(super.randNum.nextInt(this.healthRange) + this.minHealth);
        super.setStrength(super.randNum.nextInt(this.strengthRange) + this.minStrength);
        super.setDexterity(super.randNum.nextInt(this.dexterityRange) + this.minDexterity);
    }

    // getters

    // setters

} // class
