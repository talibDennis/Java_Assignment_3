package warrior;

public class Orc extends Warrior {
    private int minHealth = 180; // min amount a Orc warrior starts with
    private int healthRange = 100; // the bonus or extra range for the health stat
    private int minStrength = 150;
    private int strengthRange = 80;
    private int minDexterity = 20;
    private int dexterityRange = 30;

    public Orc() {
        super("Orc");
        // 0 - 99 + 180 = 180 to 279
        super.setHealth(super.randNum.nextInt(this.healthRange) + this.minHealth);
        super.setStrength(super.randNum.nextInt(this.strengthRange) + this.minStrength);
        super.setDexterity(super.randNum.nextInt(this.dexterityRange) + this.minDexterity);
    }

    // getters

    // setters

} // class