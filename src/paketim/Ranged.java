package paketim;

public class Ranged extends Weapon {
    public int range;
    public int bulls_eye_chance;


    public Ranged() {

    }

    @Override
    public String toString() {
        return "Ranged{" +
                "range=" + range +
                ", bulls_eye_chance=" + bulls_eye_chance +
                ", price=" + price +
                ", damage=" + damage +
                ", critic_chance=" + critic_chance +
                '}';
    }

    public Ranged(int damage, int critic_chance, int price, int range, int bulls_eye_chance) {
        super(price, damage, critic_chance);
        this.range = range;
        this.bulls_eye_chance = bulls_eye_chance;
    }

}
