
package warrior;

public class Elf extends Warrior {
    private int minHealth = 120; // min amount a Elf warrior starts with
    private int healthRange = 80; // the bonus or extra range for the health stat
    private int minStrength = 40;
    private int strengthRange = 30;
    private int minDexterity = 200;
    private int dexterityRange = 100;

    public Elf() {
        super("Elf");
        // 0 - 79 + 120 = 120 to 179
        super.setHealth(super.randNum.nextInt(this.healthRange) + this.minHealth);
        super.setStrength(super.randNum.nextInt(this.strengthRange) + this.minStrength);
        super.setDexterity(super.randNum.nextInt(this.dexterityRange) + this.minDexterity);
    }

    // getters

    // setters

} // class
