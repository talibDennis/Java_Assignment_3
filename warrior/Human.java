package warrior;

public class Human extends Warrior {
    private int minHealth = 200; // min amount a Human warrior starts with
    private int bonusHealth = 40; // the bonus or extra range for the health stat
    private int minStrength = 80;
    private int bonusStrength = 30;
    private int minDexterity = 50;
    private int bonusDexterity = 50;

    public Human() {
        super("Human");
        // 0 - 39 + 200 = 200 to 239 health range
        super.setHealth(super.randNum.nextInt(this.bonusHealth) + this.minHealth);
        super.setStrength(super.randNum.nextInt(this.bonusStrength) + this.minStrength);
        super.setDexterity(super.randNum.nextInt(this.bonusDexterity) + this.minDexterity);
    } // contructor

    // getters

    // setters

} // class
