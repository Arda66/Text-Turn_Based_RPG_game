package paketim;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Player {  //HER PLAYER OLUŞTUĞUNDA ONA ÖZGÜ YENİ RANGED MELEE OLUŞUYOR
    public HashMap<String, Weapon> envanter = new HashMap<>();
    public HashMap<String, Weapon> silah_envanteri = new HashMap<>();
    public HashMap<String, Weapon> temp_item_listesi = new HashMap<>();
    public ArrayList<String> special_ability_envanteri = new ArrayList<>();
    public Ability ability = new Ability();
    public Melee firesword = new Melee(50, 25, 1500, 20, 5);
    public Melee axe = new Melee(70, 15, 2000, 30, 10);
    public Melee katana = new Melee(60, 55, 3500, 10, 5);
    public Melee LightSaber = new Melee(90, 10, 1000, 10, 10);
    public Melee double_knife = new Melee(100, 24, 1500, 25, 10);
    public Ranged longbow = new Ranged(255, 50, 70000, 650, 5);
    public DefenceEquipment stainless_steel_armor = new DefenceEquipment(8, 80, 8000, 800);
    public DefenceEquipment shogun_helmet = new DefenceEquipment(7, 30, 4000, 500);
    public DefenceEquipment shield = new DefenceEquipment(5, 50, 5000, 200);

    public int total_armor = 0;
    public int total_miss_chance = 0;
    public int coin = 5000;
    public int hp = 1000;
    public int mana = 400;

    public Weapon Item_Seçim(String item_ismi) { //SATİN_ALMA METODU İÇİN LİGHTSABER VE DİĞERLERİNE ERİŞMEM GEREKTİ
        temp_item_listesi.put("firesword", firesword);
        temp_item_listesi.put("axe", axe);
        temp_item_listesi.put("katana", katana);
        temp_item_listesi.put("LightSaber", LightSaber);
        temp_item_listesi.put("double_knife", double_knife);
        temp_item_listesi.put("longbow", longbow);
        temp_item_listesi.put("Stainless Steel Armor", stainless_steel_armor);
        temp_item_listesi.put("Shogun Helmet", shogun_helmet);
        temp_item_listesi.put("Shield", shield);
        return temp_item_listesi.get(item_ismi);
    }

    public void Envantere_Ekle(String isim, Weapon weapon) {
        envanter.put(isim, weapon);
        silah_envanteri.put(isim, weapon);
    }

    public void Yetenek_Envanterini_Göster() {
        if (special_ability_envanteri.size() == 0) {
            System.out.println("Envanter boş lütfen önce marketten özel yetenek satın al !");
        } else {
            System.out.println("****ÖZEL YETENEK ENVANTERİM**********");
            int i = 1;
            for (String string : special_ability_envanteri) {
                System.out.println(i + "-)" + string);
                i++;
            }
        }
    }

    public void Envantere_Ekle(String isim, DefenceEquipment defenceEquipment) {

        envanter.put(isim, defenceEquipment);
    }

    public void Envanter_Göster() {

        if (envanter.size() == 0)
            System.out.println("Envanter boş lütfen önce marketten birşeyler satın  alın !");
        else {
            System.out.println("********ENVANTERİM*********");
            int i = 1;
            for (String string : envanter.keySet()) {
                System.out.println(i + "-)" + string);
                i++;
            }
        }
    }

    public void Hasar_Vur() {
        int hücüm_hasari = 0;
        Melee melee = new Melee();
        Ranged ranged = new Ranged();
        String hedef, karakterim;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Hangi karakterle saldıracaksınız : ");
            karakterim = input.nextLine();
            if (Main.PlayerList.size() == 0) {
                System.out.println("Lütfen önce oyuna karakter ekleyin!");
                return;
            } else if (Main.oyuncu_Varmı(karakterim))
                break;
            else
                System.out.println("Böyle bir karakter bulunamadı. Tekrar giriniz.");
        }
        Main.PlayerList.get(karakterim).Envanter_Göster();
        if (Main.PlayerList.get(karakterim).silah_envanteri.size() == 0) {
            System.out.println("Lütfen önce karakterinize silah satın alın !");
            return;
        }

        Main.Weapon_List();
        //ENVANTER BOŞSA DEVAM ETTİRME METODU SONLANDIR return; ile
        boolean truth = true;
        while (truth) {
            truth = false;
            System.out.println("Hangi Silahla  Saldıracaksınız : ");
            int index = input.nextInt();
            switch (index) {
                case 1: // envanterde varmı kontrol
                    if (Main.PlayerList.get(karakterim).silah_envanteri.containsKey("firesword") == false) {
                        System.out.println("Envanterde böyle bir silah bulunamadı ! ");
                        truth = true;
                    } else
                        melee = Main.PlayerList.get(karakterim).firesword;
                    break;
                case 2:
                    if (Main.PlayerList.get(karakterim).silah_envanteri.containsKey("axe") == false) {
                        System.out.println("Envanterde böyle bir silah bulunamadı ! ");
                        truth = true;
                    } else
                        melee = Main.PlayerList.get(karakterim).axe; // meleenin gösterdiği yer artık axe
                    break;
                case 3:
                    if (Main.PlayerList.get(karakterim).silah_envanteri.containsKey("katana") == false) {
                        System.out.println("Envanterde böyle bir silah bulunamadı ! ");
                        truth = true;
                    } else
                        melee = Main.PlayerList.get(karakterim).katana;
                    break;

                case 4:
                    if (Main.PlayerList.get(karakterim).silah_envanteri.containsKey("LightSaber") == false) {
                        System.out.println("Envanterde böyle bir silah bulunamadı ! ");
                        truth = true;
                    } else
                        melee = Main.PlayerList.get(karakterim).LightSaber;
                    break;
                case 5:
                    if (Main.PlayerList.get(karakterim).silah_envanteri.containsKey("double_knife") == false) {
                        System.out.println("Envanterde böyle bir silah bulunamadı ! ");
                        truth = true;
                    } else
                        melee = Main.PlayerList.get(karakterim).double_knife;
                    break;
                case 6:
                    if (Main.PlayerList.get(karakterim).silah_envanteri.containsKey("longbow") == false) {
                        System.out.println("Envanterde böyle bir silah bulunamadı ! ");
                        truth = true;
                    } else
                        ranged = Main.PlayerList.get(karakterim).longbow;
                    break;
                default:
                    System.out.println("Lütfen 1 ile 6 arasında değer giriniz .");
                    truth = true;
                    break;
            }
        }
        while (true) {
            boolean bulls_eye_check = false;
            System.out.println("Saldıracağınız rakibin ismini giriniz  : ");
            System.out.print("Cevabım : ");
            input.nextLine();
            hedef = input.nextLine();
            if (Main.oyuncu_Varmı(hedef)) {
                System.out.println("Özel Yetenek kullanmak istermisiniz ? (EVET/HAYIR)");
                System.out.print("Cevabım : ");
                String cevap = input.next();
                cevap = cevap.toLowerCase();
                if (cevap.equals("evet")) {
                    Main.PlayerList.get(karakterim).Yetenek_Envanterini_Göster();
                    Main.Özel_Yetenek_Listesi();
                    System.out.println("LÜTFEN SEÇECEĞİNİZİN NUMARASINI  GİRİNİZ : ");
                    int seçim = input.nextInt();
                    switch (seçim) {
                        case 1:
                            if (Main.PlayerList.get(karakterim).ability.Charge_Potion) {
                                if (ranged.equals(Main.PlayerList.get(karakterim).longbow)) {
                                    System.out.println("Longbowda Charge_Potion yeteneğini kullanamazsın ?!");
                                } else { // DEMEKKİ MELEE SEÇMİŞİZ BURASI ONU GÖSTERİR
                                    hücüm_hasari = Main.PlayerList.get(karakterim).ability.Charge_Potion(melee.charge_damage, melee);
                                    Main.PlayerList.get(karakterim).special_ability_envanteri.remove("Charge_Potion");
                                }


                            } else
                                System.out.println("Lütfen sizde var olan bir yeteneği seçiniz yada marketten bu yeteneği satın alın ! ");
                            break;
                        case 2:
                            if (Main.PlayerList.get(karakterim).ability.Hırsızlık_Potu) {
                                Main.PlayerList.get(karakterim).ability.Hırsızlık_potu(karakterim, hedef);
                                Main.PlayerList.get(karakterim).special_ability_envanteri.remove("Hırsızlık_Potu");

                            } else
                                System.out.println("Lütfen sizde var olan bir yeteneği seçiniz yada marketten bu yeteneği satın alın ! ");
                            break;
                        default:
                            System.out.println("Lütfen 1-2 arası giriniz ! ");
                            break;
                    }


                }
                if (cevap.equals("hayır") || cevap.equals("evet")) {
                    if (Main.Yüzde_ihtimali(Main.PlayerList.get(hedef).total_miss_chance)) {
                        System.out.println("YOU Missed !!!! BY %" + Main.PlayerList.get(hedef).total_miss_chance + " chance !!!");
                        System.out.println("0 DAMAGE...");
                    } else {
                        if (ranged.equals(Main.PlayerList.get(karakterim).longbow)) {
                            if (Main.Yüzde_ihtimali(ranged.bulls_eye_chance)) {
                                System.out.println("BULLLSSS EYEEEE !!!!!!");
                                System.out.println("You kill your enemy with %" + ranged.bulls_eye_chance + " bulls eye chance!!!");
                                System.out.println("Oyuncu '" + hedef + "' öldü");
                                System.out.println("Ve Oyundan çıkarıldı...");
                                System.out.println("Öldürme ödülünüz +3000 gold...");
                                Main.PlayerList.get(karakterim).coin += 3000;
                                Main.PlayerList.remove(hedef);
                                bulls_eye_check = true;
                            } else if (Main.Yüzde_ihtimali(ranged.critic_chance)) {
                                System.out.println("%" + ranged.critic_chance + " ihtimalle KRİTİK VURULDU ! (DAMAGE X 2)");
                                System.out.println("hedefin " + (Main.PlayerList.get(hedef).total_armor) + " armoru var!.");
                                Main.PlayerList.get(hedef).hp -= ((ranged.damage * 2) - (Main.PlayerList.get(hedef).total_armor));
                                System.out.println(((ranged.damage * 2) - (Main.PlayerList.get(hedef).total_armor)) + " damage vuruldu...");
                            } else {
                                Main.PlayerList.get(hedef).hp -= ((ranged.damage) - (Main.PlayerList.get(hedef).total_armor));
                                System.out.println("hedefin " + (Main.PlayerList.get(hedef).total_armor) + " armoru var!.");
                                System.out.println(((ranged.damage) - (Main.PlayerList.get(hedef).total_armor)) + " damage vuruldu...");
                            }
                            if (Main.PlayerList.get(hedef).hp <= 0) {
                                System.out.println("Oyuncu '" + hedef + "' öldü");
                                System.out.println("Ve Oyundan çıkarıldı...");
                                System.out.println("Öldürme ödülünüz +3000 gold...");
                                Main.PlayerList.get(karakterim).coin += 3000;
                                Main.PlayerList.remove(hedef);
                            } else if (bulls_eye_check == false)
                                System.out.println("Oyuncu '" + hedef + "' '" + Main.PlayerList.get(hedef).hp + "' Canı kaldı");

                        } else {
                            if (Main.Yüzde_ihtimali(melee.critic_chance)) {
                                System.out.println("%" + melee.critic_chance + " ihtimalle KRİTİK VURULDU ! (DAMAGE X 2)");
                                System.out.println("hedefin " + (Main.PlayerList.get(hedef).total_armor) + " armoru var!.");
                                Main.PlayerList.get(hedef).hp -= ((melee.damage * 2) - (Main.PlayerList.get(hedef).total_armor)) + hücüm_hasari;
                                System.out.println(((melee.damage * 2) - (Main.PlayerList.get(hedef).total_armor)) + hücüm_hasari + " damage vuruldu...");
                            } else {
                                Main.PlayerList.get(hedef).hp -= ((melee.damage) - (Main.PlayerList.get(hedef).total_armor)) + hücüm_hasari;
                                System.out.println("hedefin " + (Main.PlayerList.get(hedef).total_armor) + " armoru var!.");

                                System.out.println(((melee.damage) - (Main.PlayerList.get(hedef).total_armor)) + hücüm_hasari + " damage vuruldu...");
                            }
                            if (Main.PlayerList.get(hedef).hp <= 0) {
                                System.out.println("Oyuncu '" + hedef + "' öldü");
                                System.out.println("Ve Oyundan çıkarıldı...");
                                System.out.println("Öldürme ödülünüz +3000 gold...");
                                Main.PlayerList.get(karakterim).coin += 3000;
                                Main.PlayerList.remove(hedef);
                            } else
                                System.out.println("Oyuncu '" + hedef + "' '" + Main.PlayerList.get(hedef).hp + "' Canı kaldı");
                        }
                        ranged = null;
                        melee = null;
                    }
                    break;

                } else System.out.println("Lütfen evet yada hayır giriniz!");
            } else
                System.out.println("Böyle bir  oyuncu bulunamadı... Tekrar deneyiniz.");
        }
    }


}



