package paketim;

public class Weapon {
    protected int price;
    protected int damage;
    protected int critic_chance;

    public Weapon(int price, int damage, int critic_chance) {
        this.price = price;
        this.damage = damage;
        this.critic_chance = critic_chance;
    }

    public Weapon() {

    }

    public Weapon(int price) {
        this.price = price;
    }

    public void Weapon_List() {
        System.out.println("**************Oyundaki Silahların Listesi******************");
        System.out.println("1-)Fire Sword\n2-)Axe\n3-)Katana\n4-)Lightsaber\n5-)Double Knife\n6-)LongBow");
    }

}



