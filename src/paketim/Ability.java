package paketim;

import java.util.Random;

public class Ability {
    public boolean Silah_Efsunlama = false;
    public boolean Charge_Potion = false;
    public boolean Hırsızlık_Potu = false;

    public void Silah_Efsunlama(String karakter, Ranged ranged) {
        if (Silah_Efsunlama) {
            if (Main.Yüzde_ihtimali(25)) {
                System.out.println("İşlem BAŞARILI !");
                Main.PlayerList.get(karakter).longbow.damage += (Main.PlayerList.get(karakter).longbow.damage / 10);
                System.out.println("Elinizdeki Longbowun damagesi %10 artıp '" + Main.PlayerList.get(karakter).longbow.damage + "' seviyesine yükseldi.");
            } else System.out.println("İhtimal tutmadı.Başarısız!");

            Silah_Efsunlama = false;
        } else System.out.println("Lütfen önce potu satın alınız ! ");
    }

    public void Silah_Efsunlama(Melee melee) {
        if (Silah_Efsunlama) {
            if (Main.Yüzde_ihtimali(25)) { // 25
                System.out.println("İşlem BAŞARILI !");
                melee.damage += (melee.damage / 10);
                System.out.println("Elinizdeki silahın damagesi %10 artıp '" + melee.damage + "' seviyesine yükseldi.");
            } else System.out.println("İhtimal tutmadı.Başarısız!");

            Silah_Efsunlama = false;
        } else System.out.println("Lütfen önce potu satın alınız ! ");
    }


    public int Charge_Potion(float charge_damage, Melee melee) {
        if (Charge_Potion) {
            if (Main.Yüzde_ihtimali(40)) { // normalde 40
                System.out.println("İhtimal  BAŞARILI !");
                int hücüm_hasari = (int) (melee.damage * (charge_damage / 100)); // sorun burada charge damage 0 olarak gözüküyor !
                System.out.println("Hücümden gelen bonus hasar +" + (hücüm_hasari) + " kadardır.");
                Charge_Potion = false;
                return hücüm_hasari;
            } else {
                System.out.println("İhtimal tutmadı.Başarısız!");
                Charge_Potion = false;
                return 0;
            }
        } else {
            System.out.println("Lütfen önce potu satın alınız ! ");
            return 0;
        }

    }

    public void Hırsızlık_potu(String karakter, String hedef) {
        if (Hırsızlık_Potu) {
            boolean truth = true;
            if (Main.Yüzde_ihtimali(10)) { // normalde 10
                Random random = new Random();
                if (Main.PlayerList.get(hedef).silah_envanteri.size() == 0) {
                    System.out.println("Rakibinizin Silahi yok ! ");
                    return;
                }
                while (truth) {
                    int rastgele_sayi = random.nextInt(6) + 1; // 1-6 arası alcak 2 side dahil
                    switch (rastgele_sayi) {
                        case 1:
                            if (Main.PlayerList.get(hedef).silah_envanteri.containsKey("firesword")) {
                                Main.PlayerList.get(hedef).envanter.remove("firesword");
                                Main.PlayerList.get(hedef).silah_envanteri.remove("firesword");
                                System.out.println("Hedeften firesword silahi çalındı ! ");
                                Main.PlayerList.get(karakter).envanter.put("firesword", Main.PlayerList.get(karakter).firesword);
                                Main.PlayerList.get(karakter).silah_envanteri.put("firesword", Main.PlayerList.get(karakter).firesword);

                                truth = false;
                            }
                            break;
                        case 2:
                            if (Main.PlayerList.get(hedef).silah_envanteri.containsKey("axe")) {
                                Main.PlayerList.get(hedef).envanter.remove("axe");
                                Main.PlayerList.get(hedef).silah_envanteri.remove("axe");
                                System.out.println("Hedeften axe silahi çalındı ! ");
                                Main.PlayerList.get(karakter).silah_envanteri.put("axe", Main.PlayerList.get(karakter).axe);
                                Main.PlayerList.get(karakter).envanter.put("axe", Main.PlayerList.get(karakter).axe);

                                truth = false;
                            }
                            break;
                        case 3:
                            if (Main.PlayerList.get(hedef).silah_envanteri.containsKey("katana")) {
                                Main.PlayerList.get(hedef).envanter.remove("katana");
                                Main.PlayerList.get(hedef).silah_envanteri.remove("katana");

                                System.out.println("Hedeften katana silahi çalındı ! ");
                                Main.PlayerList.get(karakter).envanter.put("katana", Main.PlayerList.get(karakter).katana);
                                Main.PlayerList.get(karakter).silah_envanteri.put("katana", Main.PlayerList.get(karakter).katana);

                                truth = false;
                            }
                            break;
                        case 4:
                            if (Main.PlayerList.get(hedef).silah_envanteri.containsKey("LightSaber")) {
                                Main.PlayerList.get(hedef).envanter.remove("Lightsaber");
                                Main.PlayerList.get(hedef).silah_envanteri.remove("Lightsaber");

                                System.out.println("Hedeften LightSaber silahi çalındı ! ");
                                Main.PlayerList.get(karakter).envanter.put("LightSaber", Main.PlayerList.get(karakter).LightSaber);
                                Main.PlayerList.get(karakter).silah_envanteri.put("LightSaber", Main.PlayerList.get(karakter).LightSaber);

                                truth = false;
                            }
                            break;
                        case 5:
                            if (Main.PlayerList.get(hedef).silah_envanteri.containsKey("double_knife")) {
                                Main.PlayerList.get(hedef).envanter.remove("double_knife");
                                Main.PlayerList.get(hedef).silah_envanteri.remove("double_knife");

                                System.out.println("Hedeften double_knife silahi çalındı ! ");
                                Main.PlayerList.get(karakter).envanter.put("double_knife", Main.PlayerList.get(karakter).double_knife);
                                Main.PlayerList.get(karakter).silah_envanteri.put("double_knife", Main.PlayerList.get(karakter).double_knife);
                                truth = false;
                            }
                            break;
                        case 6:
                            if (Main.PlayerList.get(hedef).silah_envanteri.containsKey("longbow")) {
                                Main.PlayerList.get(hedef).envanter.remove("longbow");
                                Main.PlayerList.get(hedef).silah_envanteri.remove("longbow");

                                System.out.println("Hedeften longbow silahi çalındı ! ");
                                Main.PlayerList.get(karakter).envanter.put("longbow", Main.PlayerList.get(karakter).longbow);
                                Main.PlayerList.get(karakter).silah_envanteri.put("longbow", Main.PlayerList.get(karakter).longbow);
                                truth = false;
                            }
                            break;
                        default:
                            System.out.println("BUNUN GELMESİ İMKANSIZ !");
                            break;
                    }
                }
            } else System.out.println("ihtimal tutmadı başarısız.");

            Hırsızlık_Potu = false;
        } else System.out.println("Lütfen önce potu satın alınız ! ");
    }

}

