package paketim;



public class DefenceEquipment extends  Weapon {
    public int miss_chance;
    public int armor;
    public int bonus_hp;

    public DefenceEquipment() {

    }

    @Override
    public String toString() {
        return "DefenceEquipment{" +
                "miss_chance=" + miss_chance +
                ", armor=" + armor +
                ", price=" + price +
                ", bonus_hp=" + bonus_hp +
                '}';
    }

    public DefenceEquipment(int miss_chance, int armor, int price, int bonus_hp) {
        super(price);
        this.miss_chance = miss_chance;
        this.armor = armor;
        this.bonus_hp = bonus_hp;
    }

    public void Defensive_İtem_List() {
        System.out.println("*********OYUNDAKİ ZIRH VE KALKAN VE KASKLARIN LİSTESİ************");
        System.out.println("1-)Stainless Steel Armor\n2-)Shogun Helmet\n3-)Shield");
    }
}
