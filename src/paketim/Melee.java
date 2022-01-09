package paketim;

public class Melee extends Weapon {
    public int charge_damage;
    public int knock_up_chance;

    public Melee() {

    }

    @Override
    public String toString() {
        return "Melee{" +
                "charge_damage=" + charge_damage +
                ", knock_up_chance=" + knock_up_chance +
                ", price=" + price +
                ", damage=" + damage +
                ", critic_chance=" + critic_chance +
                '}';
    }

    public Melee(int damage, int critic_chance, int price, int charge_damage, int knock_up_chance) {
        super(price, damage, critic_chance);
        this.charge_damage = charge_damage;
        this.knock_up_chance = knock_up_chance;
    }

}
