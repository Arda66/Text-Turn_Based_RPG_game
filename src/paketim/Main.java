package paketim;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;

// MADE BY ARDA DUMANOGLU

public class Main {
    public static Player deneme = new Player();
    public static int rastgele_sayim;
    public static int oyuncu_sayisi = 1;
    public static HashMap<String, Player> PlayerList = new HashMap<>();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("********************************MAİN MENU************************************************************************");
            System.out.println("1-)Yeni oyuncu ekle \n2-)Seçtiğin Oyuncuyu Çıkart \n3-)Oyuncuları görüntüle \n4-)Silah ve Zırh Listesi \n5-)Oyun oynayarak para kazan yada kaybet! \n6-)Toplam para miktarim \n7-)Marketten satın al \n8-)İtemler ve Özellikleri \n9-)Rakibe Saldır. \n10-)Envanteri Göster. \n11-)Özel Yetenek satın al(mana ile)\n12-)Silah Efsunlama \n13-)Mana satın al\n14-)Çıkış yap");
            System.out.print("Seçimim : ");
            int seçim = input.nextInt();
            switch (seçim) {
                case 1:
                    yeni_oyuncu_ekle();
                    break;
                case 2:
                    oyuncu_çıkart();
                    break;
                case 3:
                    oyuncu_listesi();
                    break;
                case 4:
                    while (true) {
                        System.out.println("1-)Silah listesi\n2-)Armor Listesi ");
                        System.out.print("Cevabım : ");
                        int cevap = input.nextInt();
                        if (cevap == 1) {
                            Weapon_List();
                            break;
                        } else if (cevap == 2) {
                            Defence_İtem_List();
                            break;
                        } else System.out.println("lütfen 1 yada 2 giriniz !");
                    }
                    break;
                case 5:
                    System.out.println("*********************************************************************************************************");
                    System.out.println("1-)Şans oyunuyla para kazan yada kaybet 2-)Çarpma işlemi yaparak az para kazan(farm yap) yada kaybet! 3-)TAŞ-KAĞIT-MAKAS oyna(+/- 500GOLD)");
                    System.out.print("Seçimim : ");
                    int seçimim = input.nextInt();
                    if (seçimim == 1)
                        Şans_oyunu();
                    else if (seçimim == 2)
                        Çarpma_İşlemi();
                    else if (seçimim == 3)
                        Taş_kağıt_makas();
                    else System.out.println("Lütfen geçerli bir sayı giriniz ! ");
                    break;
                case 6:
                    System.out.print("hangi karakterin para miktarini görmek istion : ");
                    input.nextLine();
                    String isim = input.nextLine();
                    if (oyuncu_Varmı(isim))
                        System.out.println("Toplam para miktarin : " + PlayerList.get(isim).coin + " gold");
                    else System.out.println("Böyle bir oyuncu bulunamadı!");
                    break;
                case 7:
                    İtem_satin_Al();
                    break;
                case 8:
                    System.out.println("1-)Silahların Özellikleri \n2-)Defans itemlerinin özellikleri");
                    System.out.print("Cevabım : ");
                    int seçimm = input.nextInt();
                    if (seçimm == 1) {
                        Weapon_Attributes();
                    } else if (seçimm == 2) {
                        Defence_Equipment_Attributes();
                    } else System.out.println("lütfen 1 yada 2 seçiniz...");
                    break;
                case 9:
                    Hasar_vur();
                    break;
                case 10:
                    Envanteri_Göster();
                    break;
                case 11:
                    Özel_Yetenek_Satın_Alım();
                    break;
                case 12:
                    Silah_Efsunlama();
                    break;
                case 13:
                    Mana_Satın_Al();
                    break;
                case 14:
                    System.out.println("Çıkış yapılıyor...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lütfen 1-9 arası bir sayi giriniz !");
                    break;
            }
        }
    }

    public static void yeni_oyuncu_ekle() {
        Player player = new Player();
        System.out.print("Yeni oyuncunun adını giriniz : ");
        input.nextLine();
        String oyuncu_adı = input.nextLine();
        PlayerList.put(oyuncu_adı, player);
        System.out.println(oyuncu_sayisi + ". oyuncu '" + oyuncu_adı + "' oyuna eklendi");
        oyuncu_sayisi++;
    }

    public static void oyuncu_listesi() {
        if (PlayerList.size() == 0)
            System.out.println("HİÇBİR OYUNCU YOK. LÜTFEN ÖNCE OYUNCU EKLEYİN!");
        else {
            int i = 1;
            for (String string : PlayerList.keySet()) {
                System.out.println(i + "-)" + string);
                i++;
            }
        }
    }

    public static void oyuncu_çıkart() {
        if (PlayerList.size() == 0)
            System.out.println("HİÇBİR OYUNCU BULUNAMADI! Lütfen önce yeni oyuncu ekleyiniz.");
        else {
            System.out.println("Çıkartmak istediğiniz oyuncunun adını giriniz : ");
            System.out.print("Cevabım : ");
            input.nextLine();
            String oyuncu = input.nextLine();
            if (!oyuncu_Varmı(oyuncu))
                System.out.println("BÖYLE BİR OYUNCU BULUNAMADI. LÜTFEN TEKRAR DENEYİNİZ !");
            else {
                System.out.println("Seçtiğiniz oyuncu '" + oyuncu + "' başarılı bir şekilde çıkarıldı...");
                PlayerList.remove(oyuncu);
                oyuncu_sayisi--;
            }
        }
    }

    public static boolean oyuncu_Varmı(String isim) {
        // oyuncu varmı yokmu diye contains ile sürekli uğraşmak yerine döndürdüğü değere göre yorumlucaz...
        return PlayerList.containsKey(isim);
    }

    public static void Şans_oyunu() {
        String isim;
        int i = 1;
        System.out.println("Şans oyununa hoşgeldin maceraci! Burada para kazanabileceğin gibi  kaybedebileceğini de UNUTMA! \n Kural: 0-10 arasında (2side dahil) bir sayi istiyorum senden , senin sayın çıkana kadar 0 ile 10 arasında sürekli rastgele sayı üretilcek. Kaçıncı seferde tutturduğuna göre ödüllendirilecek yada cezalandırılacaksın!. ");
        System.out.println("ÖDÜL ORANLARI : TEK ATMAK +300 GOLD *** 2,3,4. seferde tutturmak +200 gold *** 5.seferde tutturmak +100 gold *** 6. seferde tutturmak -100 gold *** 7,8,9 tutturmak -200 gold , 10 ve üzeri tutturmak -300 gold.");
        Random random = new Random();
        while (true) {
            System.out.println("Hangi karakterle oynamak istiyorsun adını gir : ");
            input.nextLine();
            isim = input.nextLine();
            if (!oyuncu_Varmı(isim))
                System.out.println("Lütfen geçerli karakter giriniz !");
            else break;
        }
        while (true) {
            System.out.print("O zaman hazırsan başlayalım! Şanslı sayını gir bakalım (0-10) : ");
            rastgele_sayim = input.nextInt();
            if (rastgele_sayim > 10 || rastgele_sayim < 0) {
                System.out.println("Lütfen 0 ile 10 arasında bir sayi giriniz !");
            } else break;
        }
        while (true) {
            int random_sayi = random.nextInt(11);
            System.out.println(i + "-)" + random_sayi);
            if (rastgele_sayim == random_sayi) {
                System.out.println("İstediğiniz sayi '" + rastgele_sayim + "' " + i + ". denemede bulundu !");
                break;
            }
            i++;
        }
        switch (i) {
            case 1:
                System.out.println("Tek attınız ÖDÜLÜNÜZ +300 GOLD ");
                PlayerList.get(isim).coin += 300;
                System.out.println("Toplam paranız : " + PlayerList.get(isim).coin);
                break;
            case 2:
            case 3:
            case 4:
                System.out.println(i + ". Denemede bulduğunuz için ÖDÜLÜNÜZ +200 GOLD ");
                PlayerList.get(isim).coin += 200;
                System.out.println("Toplam paranız : " + PlayerList.get(isim).coin);
                break;
            case 5:
                System.out.println(i + ". Denemede bulduğunuz için ÖDÜLÜNÜZ +100 GOLD ");
                PlayerList.get(isim).coin += 100;
                System.out.println("Toplam paranız : " + PlayerList.get(isim).coin);
                break;
            case 6:
                System.out.println(i + ". Denemede bulduğunuz için Zararınız -100 GOLD ");
                PlayerList.get(isim).coin -= 100;
                System.out.println("Toplam paranız : " + PlayerList.get(isim).coin);
                break;
            case 7:
            case 8:
            case 9:
                System.out.println(i + ". Denemede bulduğunuz için Zararınız -200 GOLD ");
                PlayerList.get(isim).coin -= 200;
                System.out.println("Toplam paranız : " + PlayerList.get(isim).coin);
                break;
            default:
                System.out.println(i + ". Denemede bulduğunuz için Zararınız -300 GOLD ");
                PlayerList.get(isim).coin -= 300;
                System.out.println("Toplam paranız : " + PlayerList.get(isim).coin);
                break;
        }
    }

    public static void Çarpma_İşlemi() {
        boolean truth = true;
        String cevabim;
        System.out.println("Kural Çok basit ben sana rastgele çarpma işlemleri soracağım doğru girdikçe para kazanacaksın yanlış girdikçe para kaybedeceksin...");
        System.out.println("2 Basamaklı sayılarla işlem yapmak +500 gold .  3 basamaklı sayılarla işlem yapmak +1000 gold değerindedir. Aynı oranda kaybedebilirsinde.");
        while (truth) {
            while (true) {
                System.out.println("Önce oynayacağın karakteri gir : ");
                input.nextLine();
                cevabim = input.nextLine();
                if (oyuncu_Varmı(cevabim))
                    break;
                else System.out.println("Böyle Bir oyuncu bulunamadı. Tekrar deneyin!");
            }
            Random random = new Random();
            System.out.println(" 2 basamakla mı işlem yapacaksın 3 basamaklı mı  : ");
            System.out.print("Cevabım : ");
            int seçimim = input.nextInt();
            if (seçimim == 2) {
                int rastgele_sayi1 = random.nextInt(90) + 10;  // 0-90  +10   10-100 (100 dahil değil)
                int rastgele_sayi2 = random.nextInt(90) + 10;  // 0-90  +10   10-100
                System.out.println("Soru : " + rastgele_sayi1 + "x" + rastgele_sayi2 + " ?");
                System.out.print("Cevabım : ");
                int cevap = input.nextInt();
                if (cevap != (rastgele_sayi1 * rastgele_sayi2)) {
                    System.out.println("Yanlış cevap! Doğrusu : " + (rastgele_sayi1 * rastgele_sayi2));
                    System.out.println("-500 GOLD KAYBETTİNİZ ...");
                    PlayerList.get(cevabim).coin -= 500;
                    System.out.println("Seçtiğiniz  Karakterin en son toplam  parası : " + PlayerList.get(cevabim).coin);
                } else if (cevap == (rastgele_sayi1 * rastgele_sayi2)) {
                    System.out.println("Doğru cevap! +500 Gold kazandınız...");
                    PlayerList.get(cevabim).coin += 500;
                    System.out.println("Seçtiğiniz  Karakterin en son toplam  parası : " + PlayerList.get(cevabim).coin);
                }

                while (true) {
                    System.out.println("Tamam mı Devam mı ?");
                    System.out.print("Cevabım : "); //
                    String cevabimm = input.next();
                    if (cevabimm.equalsIgnoreCase("tamam")) {
                        System.out.println("Çıkış yapılıyor...");
                        System.out.println("Seçtiğiniz  Karakterin en son toplam  parası : " + PlayerList.get(cevabim).coin);
                        truth = false;
                        break;
                    } else if (cevabimm.equalsIgnoreCase("devam"))
                        break;
                    else System.out.println("Lütfen 'tamam' yada 'devam' giriniz !");
                }
            } else if (seçimim == 3) {
                int rastgele_sayi1 = random.nextInt(900) + 100;  // 0-900 +100 100-1000 (1000 dahil değil
                int rastgele_sayi2 = random.nextInt(900) + 100;
                System.out.println("Soru : " + rastgele_sayi1 + "x" + rastgele_sayi2 + " ?");
                System.out.println("Cevabım : ");
                int cevap = input.nextInt();
                if (cevap != (rastgele_sayi1 * rastgele_sayi2)) {
                    System.out.println("Yanlış cevap! Doğrusu : " + (rastgele_sayi1 * rastgele_sayi2));
                    System.out.println("-1000 GOLD KAYBETTİNİZ ...");
                    PlayerList.get(cevabim).coin -= 1000;
                    System.out.println("Seçtiğiniz  Karakterin en son toplam  parası : " + PlayerList.get(cevabim).coin);

                } else if (cevap == (rastgele_sayi1 * rastgele_sayi2)) {
                    System.out.println("Doğru cevap! +1000 Gold kazandınız...");
                    PlayerList.get(cevabim).coin += 1000;
                    System.out.println("Seçtiğiniz  Karakterin en son toplam  parası : " + PlayerList.get(cevabim).coin);
                }
                while (true) {
                    System.out.println("Tamam mı Devam mı ?");
                    System.out.print("Cevabım : ");
                    String cevabimm = input.next();
                    if (cevabimm.equalsIgnoreCase("tamam")) {
                        System.out.println("Çıkış yapılıyor...");
                        System.out.println("Seçtiğiniz  Karakterin en son toplam  parası : " + PlayerList.get(cevabim).coin);
                        truth = false;
                        break;
                    } else if (cevabimm.equalsIgnoreCase("devam"))
                        break;
                    else System.out.println("Lütfen 'tamam' yada 'devam' giriniz !");
                }
            } else System.out.println("Lütfen 2 yada 3 giriniz!");
        }
    }

    public static void Weapon_List() {
        Weapon weapon = new Weapon();
        weapon.Weapon_List();
    }

    public static void Defence_İtem_List() {
        DefenceEquipment defenceEquipment = new DefenceEquipment();
        defenceEquipment.Defensive_İtem_List();
    }

    public static void Weapon_Attributes() {
        Weapon weapon = new Weapon();
        boolean truth = true;
        while (truth) {
            truth = false;
            weapon.Weapon_List();
            System.out.println("Hangi silahin özelliklerini Görmek istersiniz  : ");
            System.out.print("Cevabım : ");
            int seçim = input.nextInt();
            switch (seçim) {
                case 1:
                    System.out.println(deneme.firesword);
                    break;
                case 2:
                    System.out.println(deneme.axe);
                    break;
                case 3:
                    System.out.println(deneme.katana);
                    break;
                case 4:
                    System.out.println(deneme.LightSaber);
                    break;
                case 5:
                    System.out.println(deneme.double_knife);
                    break;
                case 6:
                    System.out.println(deneme.longbow);
                    break;
                default:
                    System.out.println("Lütfen Geçerli bir sayiyi giriniz !");
                    truth = true;
                    break;
            }
        }
    }

    public static void Defence_Equipment_Attributes() {
        DefenceEquipment defenceEquipment = new DefenceEquipment();
        boolean truth = true;
        while (truth) {
            truth = false;
            defenceEquipment.Defensive_İtem_List();
            System.out.println("Hangi kıyafetin özelliklerini Görmek istersiniz  : ");
            System.out.print("Cevabım : ");
            int seçim = input.nextInt();
            switch (seçim) {
                case 1:
                    System.out.println(deneme.stainless_steel_armor);
                    break;
                case 2:
                    System.out.println(deneme.shogun_helmet);
                    break;
                case 3:
                    System.out.println(deneme.shield);
                    break;
                default:
                    System.out.println("Lütfen Geçerli bir sayiyi giriniz !");
                    truth = true;
                    break;
            }
        }
    }

    public static void İtem_satin_Al() {
        System.out.println("1-)Silah Satın Al \n2-)Defans itemi Satın Al.");
        System.out.print("Cevabım : ");
        int seçimmm = input.nextInt();
        if (seçimmm == 1) {
            System.out.println("Hangi karakterine silah satın almak istiyorsun  adını gir : ");
            input.nextLine();
            String karakter = input.nextLine();
            if (oyuncu_Varmı(karakter)) {
                System.out.println("Hesabınızda " + PlayerList.get(karakter).coin + " Gold var.");
                Weapon_List();
                System.out.println("Hangi Silahi Satın Almak istersin numarasını gir ?");
                System.out.print("Cevabım : ");
                int selection = input.nextInt();
                switch (selection) {
                    case 1: // aynı silahı 2 kere almamızı engellesin ! eğer bizde varsa
                        if (Envanterde_Varmı(karakter, "firesword"))
                            System.out.println("Karakterinizde zaten firesword itemi var !");
                        else
                            Satin_Alma(karakter, "firesword");
                        break;
                    case 2:
                        if (Envanterde_Varmı(karakter, "axe"))
                            System.out.println("Karakterinizde zaten axe itemi var !");
                        else
                            Satin_Alma(karakter, "axe");
                        break;
                    case 3:
                        if (Envanterde_Varmı(karakter, "katana"))
                            System.out.println("Karakterinizde zaten katana itemi var !");
                        else
                            Satin_Alma(karakter, "katana");
                        break;
                    case 4:
                        if (Envanterde_Varmı(karakter, "LightSaber"))
                            System.out.println("Karakterinizde zaten Lightsaber itemi var !");
                        else
                            Satin_Alma(karakter, "LightSaber");
                        break;
                    case 5:
                        if (Envanterde_Varmı(karakter, "double_knife"))
                            System.out.println("Karakterinizde zaten double knife itemi var !");
                        else
                            Satin_Alma(karakter, "double_knife");
                        break;
                    case 6:
                        if (Envanterde_Varmı(karakter, "longbow"))
                            System.out.println("Karakterinizde zaten longbow itemi var !");
                        else
                            Satin_Alma(karakter, "longbow");
                        break;
                    default:
                        System.out.println("lütfen 1 ile 6 arasında bir sayi giriniz.");
                        break;
                }


            } else System.out.println("Böyle bir karakter bulunamadı.");
        } else if (seçimmm == 2) {
            System.out.println("Hangi karakterine Kıyafet satın almak istiyorsun  adını gir : ");
            input.nextLine();
            String karakter = input.nextLine();
            if (oyuncu_Varmı(karakter)) {
                System.out.println("Hesabınızda " + PlayerList.get(karakter).coin + " Gold var.");
                Defence_İtem_List();
                System.out.println("Hangi Kıyafeti Satın Almak istersin numarasını gir ?");
                System.out.print("Cevabım : ");
                int selection = input.nextInt();
                switch (selection) {
                    case 1: //üstteki gibi aynı
                        if (Envanterde_Varmı(karakter, "Stainless Steel Armor"))
                            System.out.println("Karakterinizde zaten Stainless Steel Armoru  var !");
                        else {
                            Satin_Alma(karakter, "Stainless Steel Armor");
                            PlayerList.get(karakter).total_armor += PlayerList.get(karakter).stainless_steel_armor.armor;
                            PlayerList.get(karakter).hp += PlayerList.get(karakter).stainless_steel_armor.bonus_hp;
                            PlayerList.get(karakter).total_miss_chance += PlayerList.get(karakter).stainless_steel_armor.miss_chance;
                        }
                        break;
                    case 2:
                        if (Envanterde_Varmı(karakter, "Shogun Helmet"))
                            System.out.println("Karakterinizde zaten Shogun Helmeti  var !");
                        else {
                            Satin_Alma(karakter, "Shogun Helmet");
                            PlayerList.get(karakter).total_armor += PlayerList.get(karakter).shogun_helmet.armor;
                            PlayerList.get(karakter).hp += PlayerList.get(karakter).shogun_helmet.bonus_hp;
                            PlayerList.get(karakter).total_miss_chance += PlayerList.get(karakter).shogun_helmet.miss_chance;
                        }
                        break;
                    case 3:
                        if (Envanterde_Varmı(karakter, "Shield"))
                            System.out.println("Karakterinizde zaten shield   var !");
                        else {
                            Satin_Alma(karakter, "Shield");
                            PlayerList.get(karakter).total_armor += PlayerList.get(karakter).shield.armor;
                            PlayerList.get(karakter).hp += PlayerList.get(karakter).shield.bonus_hp;
                            PlayerList.get(karakter).total_miss_chance += PlayerList.get(karakter).shield.miss_chance;
                        }
                        break;
                    default:
                        System.out.println("lütfen 1 ile 3 arasında bir sayi giriniz.");
                        break;
                }
            } else System.out.println("Böyle bir karakter bulunamadı.");
        } else System.out.println("lütfen 1 yada 2 seçiniz...");
    }

    public static void Hasar_vur() {
        Player player = new Player();
        player.Hasar_Vur();
    }

    public static void Envanteri_Göster() {
        System.out.println("Hangi karakterin envanterini görmek istersin : ");
        System.out.print("Cevabım : ");
        input.nextLine();
        String karakter = input.nextLine();
        if (oyuncu_Varmı(karakter))
            PlayerList.get(karakter).Envanter_Göster();
        else System.out.println("Böyle bir oyuncu bulunamadı.");
    }

    public static boolean Yüzde_ihtimali(int ihtimal) {
        Random random = new Random();
        int rastgele_sayi = random.nextInt(101);
        if (ihtimal >= rastgele_sayi)
            return true;
        else
            return false;
    }

    public static boolean Envanterde_Varmı(String oyuncu_adı, String item_ismi) {
        if ((PlayerList.get(oyuncu_adı).envanter.containsKey(item_ismi)))
            return true;
        else
            return false;
    }

    public static void Satin_Alma(String oyuncu, String item_ismi) {
        if (PlayerList.get(oyuncu).Item_Seçim(item_ismi).price <= PlayerList.get(oyuncu).coin) {
            PlayerList.get(oyuncu).coin -= PlayerList.get(oyuncu).Item_Seçim(item_ismi).price;
            System.out.println("Satın alım başarılı !");
            System.out.println("Kalan bakiyeniz : " + PlayerList.get(oyuncu).coin);
            PlayerList.get(oyuncu).Envantere_Ekle(item_ismi, PlayerList.get(oyuncu).Item_Seçim(item_ismi));
            PlayerList.get(oyuncu).temp_item_listesi.clear();
        } else System.out.println("Yetersiz  Bakiye ");
    }

    public static void Özel_Yetenek_Satın_Alım() {
        Özel_Yetenek_Listesi();
        System.out.print("Satın alacağınız oyuncunun ismini giriniz : ");
        input.nextLine();
        String karakter = input.nextLine();
        if (oyuncu_Varmı(karakter)) {
            System.out.println("Hangi yeteneği satın alacaksınız Numarasını Giriniz (1-2) : ");
            int cevap = input.nextInt();
            switch (cevap) {
                case 1:
                    if (PlayerList.get(karakter).coin >= 6000 && PlayerList.get(karakter).mana >= 200) {
                        if (!PlayerList.get(karakter).ability.Charge_Potion) {
                            System.out.println("Satın alım başarılı....");
                            PlayerList.get(karakter).coin -= 6000;
                            PlayerList.get(karakter).mana -= 200;
                            System.out.println(karakter + " Karakterinizin toplam " + PlayerList.get(karakter).coin + " coini ve " + PlayerList.get(karakter).mana + " manası kaldı.");
                            PlayerList.get(karakter).ability.Charge_Potion = true;
                            PlayerList.get(karakter).special_ability_envanteri.add("Charge_Potion"); //ARRAYLİST OLMAZ HASHMAP AMA NASIL OLCAK BİLMİOZ
                        } else
                            System.out.println("Zaten daha önce bunu satın almışsınız . Lütfen  önce savaşta kullanın !");
                    } else System.out.println("Yetersiz bakiye...");
                    break;
                case 2:
                    if (PlayerList.get(karakter).coin >= 4000 && PlayerList.get(karakter).mana >= 200) {
                        if (!PlayerList.get(karakter).ability.Hırsızlık_Potu) {
                            System.out.println("Satın alım başarılı....");
                            PlayerList.get(karakter).coin -= 4000;
                            PlayerList.get(karakter).mana -= 200;
                            System.out.println(karakter + " karakterinizin toplam " + PlayerList.get(karakter).coin + " coini ve " + PlayerList.get(karakter).mana + " manası kaldı.");
                            PlayerList.get(karakter).ability.Hırsızlık_Potu = true;
                            PlayerList.get(karakter).special_ability_envanteri.add("Hırsızlık_Potu");
                        } else
                            System.out.println("Zaten daha önce bunu satın almışsınız . Lütfen  önce savaşta kullanın !");
                    } else System.out.println("Yetersiz bakiye...");
                    break;
                default:
                    System.out.println("Lütfen 1-3 arası numara giriniz ! ");
                    break;
            }

        } else System.out.println("Böyle bir oyuncu  bulunamadı...");

    }

    public static void Özel_Yetenek_Listesi() {
        System.out.println("---------Özel Yetenek Listesi-------");
        System.out.println("1-)Charge_Potion : Melee Silahların için %40 ihtimalle hücüm eder ve hasarını o an için % olarak charge_damage kadar arttırır.(6000 GOLD+200 MANA)");
        System.out.println("2-)Hırsızlık_Potu : %10 İhtimalle rakibinin  rastgele  itemini çalar. (4000 GOLD + 200 MANA)");
    }

    public static void Silah_Efsunlama() {
        System.out.println("Silah_Efsunlama : Silahının hasarını %25 ihtimalle kalıcı olarak %10 arttırır.Başarısız olursa yanar. (5000 GOLD+200 MANA)");
        System.out.println("Hangi karakterinin Silahına efsun basacaksın : ");
        System.out.print("Cevabım  : ");
        input.nextLine();
        String karakterim = input.nextLine();
        if (oyuncu_Varmı(karakterim)) {
            if (PlayerList.get(karakterim).silah_envanteri.size() == 0) {
                System.out.println("Lütfen önce karakterinize silah satın alın !");
                return;
            }
            if (PlayerList.get(karakterim).coin >= 5000 && PlayerList.get(karakterim).mana >= 200) {
                if (!PlayerList.get(karakterim).ability.Silah_Efsunlama) {
                    System.out.println("Satın alım başarılı....");
                    PlayerList.get(karakterim).coin -= 5000;
                    PlayerList.get(karakterim).mana -= 200;
                    System.out.println(karakterim + " Karakterinizin toplam " + PlayerList.get(karakterim).coin + " coini ve " + PlayerList.get(karakterim).mana + " manası kaldı.");
                    PlayerList.get(karakterim).ability.Silah_Efsunlama = true;
                    PlayerList.get(karakterim).Envanter_Göster();
                    Main.Weapon_List();
                    boolean truth = true;
                    while (truth) {
                        truth = false;
                        System.out.println("Hangi Silahınıza Efsun Basacaksınız : ");
                        int index = input.nextInt();
                        switch (index) {
                            case 1: // envanterde varmı kontrol
                                if (!PlayerList.get(karakterim).silah_envanteri.containsKey("firesword")) {
                                    System.out.println("Envanterde böyle bir silah bulunamadı ! ");
                                    truth = true;
                                } else {
                                    if (PlayerList.get(karakterim).ability.Silah_Efsunlama) {
                                        PlayerList.get(karakterim).ability.Silah_Efsunlama(PlayerList.get(karakterim).firesword);
                                        System.out.println("(FİRESWORD)");
                                    }
                                }
                                break;
                            case 2:
                                if (!PlayerList.get(karakterim).silah_envanteri.containsKey("axe")) {
                                    System.out.println("Envanterde böyle bir silah bulunamadı ! ");
                                    truth = true;
                                } else {
                                    if (PlayerList.get(karakterim).ability.Silah_Efsunlama) {
                                        PlayerList.get(karakterim).ability.Silah_Efsunlama(PlayerList.get(karakterim).axe);
                                        System.out.println("(AXE)");
                                    }
                                }
                                break;
                            case 3:
                                if (!PlayerList.get(karakterim).silah_envanteri.containsKey("katana")) {
                                    System.out.println("Envanterde böyle bir silah bulunamadı ! ");
                                    truth = true;
                                } else {
                                    if (Main.PlayerList.get(karakterim).ability.Silah_Efsunlama) {
                                        PlayerList.get(karakterim).ability.Silah_Efsunlama(PlayerList.get(karakterim).katana);
                                        System.out.println("(KATANA)");
                                    }
                                }
                                break;
                            case 4:
                                if (!Main.PlayerList.get(karakterim).silah_envanteri.containsKey("LightSaber")) {
                                    System.out.println("Envanterde böyle bir silah bulunamadı ! ");
                                    truth = true;
                                } else {
                                    if (Main.PlayerList.get(karakterim).ability.Silah_Efsunlama) {
                                        PlayerList.get(karakterim).ability.Silah_Efsunlama(PlayerList.get(karakterim).LightSaber);
                                        System.out.println("(LİGHTSABER)");
                                    }
                                }
                                break;
                            case 5:
                                if (!Main.PlayerList.get(karakterim).silah_envanteri.containsKey("double_knife")) {
                                    System.out.println("Envanterde böyle bir silah bulunamadı ! ");
                                    truth = true;
                                } else {
                                    if (Main.PlayerList.get(karakterim).ability.Silah_Efsunlama) {
                                        PlayerList.get(karakterim).ability.Silah_Efsunlama(PlayerList.get(karakterim).double_knife);
                                        System.out.println("(DOUBLE KNİFE)");
                                    }
                                }
                                break;
                            case 6:
                                if (!Main.PlayerList.get(karakterim).silah_envanteri.containsKey("longbow")) {
                                    System.out.println("Envanterde böyle bir silah bulunamadı ! ");
                                    truth = true;
                                } else {
                                    if (Main.PlayerList.get(karakterim).ability.Silah_Efsunlama) {
                                        PlayerList.get(karakterim).ability.Silah_Efsunlama(karakterim, PlayerList.get(karakterim).longbow);
                                        System.out.println("(LONGBOW)");
                                    }
                                }
                                break;
                            default:
                                System.out.println("Lütfen 1 ile 6 arasında değer giriniz .");
                                truth = true;
                                break;
                        }
                    }
                } else System.out.println("Zaten daha önce bunu satın almışsınız . Lütfen  önce savaşta kullanın !");
            } else System.out.println("Yetersiz bakiye...");
        } else System.out.println("Böyle bir oyuncu bulunamadı.");
    }

    public static void Mana_Satın_Al() {
        if (PlayerList.size() == 0)
            System.out.println("HİÇBİR OYUNCU BULUNAMADI! Lütfen önce yeni oyuncu ekleyiniz.");
        else {
            System.out.println("Karakter Listesi şu şekildedir:");
            oyuncu_listesi();
            while (true) {
                System.out.print("Lütfen mana satın alacağınız karakterin ismini giriniz : ");
                input.nextLine();
                String karakter = input.nextLine();
                if (oyuncu_Varmı(karakter)) {
                    System.out.println("Karakteriniz '" + karakter + "' " + PlayerList.get(karakter).coin + " altına sahiptir ve " + PlayerList.get(karakter).mana + " manası vardır.");
                    System.out.print("1 MANA = 50 ALTIN ORANI VARDIR.\nNe kadar mana satın almak istiyorsun : ");
                    int mana_miktari = input.nextInt();
                    if (mana_miktari * 50 > PlayerList.get(karakter).coin)
                        System.out.println("Yetersiz bakiye. Elinizdeki altınla maximum '" + PlayerList.get(karakter).coin / 50 + "' miktarda mana alabilirsiniz!");
                    else {
                        PlayerList.get(karakter).mana += mana_miktari;
                        PlayerList.get(karakter).coin -= mana_miktari * 50;
                        System.out.println(mana_miktari + " mana hesabına eklendi. Toplam mana miktarin '" + PlayerList.get(karakter).mana + "' oldu");
                        System.out.println("Karakterinizin toplam altını '" + PlayerList.get(karakter).coin + "' olarak güncellendi.");
                    }
                    break;
                } else
                    System.out.println("Böyle bir oyuncu bulunamadı lütfen listeden kontrol edip doğru ismi giriniz!");
            }
        }
    }

    public static void Taş_kağıt_makas() {
        System.out.println("KAZANIRSAN ÖDÜLÜN Standart olarak +500 GOLD , KAYBEDİRSEN -500 GOLD'DUR. İstersen miktarı (elindeki toplam parayı geçmemek şartıyla) kendin girebilirsin.Örneğin : 5000 TL ortaya koyarsan kaybedersen -5000 kazanırsan +5000 olur. ");
        System.out.println("Oynacağınız karakterin adını giriniz!");
        String karakter;
        Random random = new Random();
        int rastgele_sayi = random.nextInt(4);  // 1-) taş 2-) kağıt 3-) makas olarak varsaydık
        while (true) {
            input.nextLine();
            System.out.print("Karakterim : ");
            karakter = input.nextLine();
            if (oyuncu_Varmı(karakter))
                break;
            else System.out.println("Böyle bir karakter bulunamadı! Lütfen tekrar giriniz.");
        }
        System.out.println("1-)Standart miktar ile (500) oynayacağım \n2-)Miktari ben gireceğim ");
        System.out.print("Cevabım : ");
        int cevap = input.nextInt();
        if (cevap == 1) {
            if (PlayerList.get(karakter).coin >= 500) {
                System.out.println("1-)TAŞ \n2-)Kağıt \n3-)Makas lütfen birini seçiniz!");
                int seçim;
                while (true) {
                    System.out.print("Seçimim : ");
                    seçim = input.nextInt();
                    if (seçim == 1 || seçim == 2 || seçim == 3)
                        break;
                    else
                        System.out.println("Lütfen geçerli sayı giriniz!");
                }
                switch (Taş_Kağıt_Makas_Hesaplama(seçim, rastgele_sayi)) {
                    case 0: // kaybettin
                        System.out.println(karakter + " adlı karakteriniz -" + 500 + " gold kaybetti.");
                        PlayerList.get(karakter).coin -= 500;
                        System.out.println("Kalan total bakiyeniz : " + PlayerList.get(karakter).coin + " gold");
                        break;
                    case 1: // kazandın
                        System.out.println(karakter + " adlı karakteriniz +" + 500 + " gold kazandı.");
                        PlayerList.get(karakter).coin += 500;
                        System.out.println("Yeni total bakiyeniz : " + PlayerList.get(karakter).coin + " gold");
                        break;
                    case 2: //berabere
                        break;
                }
            } else System.out.println("Yetersiz bakiye !");
        } else if (cevap == 2) {
            System.out.print("Miktari giriniz : ");
            int miktar = input.nextInt();
            if (PlayerList.get(karakter).coin >= miktar) {
                System.out.println("1-)TAŞ \n2-)Kağıt \n3-)Makas lütfen birini seçiniz!");
                int seçim;
                while (true) {
                    System.out.print("Seçimim : ");
                    seçim = input.nextInt();
                    if (seçim == 1 || seçim == 2 || seçim == 3)
                        break;
                    else
                        System.out.println("Lütfen geçerli sayı giriniz!");
                }
                switch (Taş_Kağıt_Makas_Hesaplama(seçim, rastgele_sayi)) {
                    case 0: // kaybettin
                        System.out.println(karakter + " adlı karakteriniz -" + miktar + " gold kaybetti.");
                        PlayerList.get(karakter).coin -= miktar;
                        System.out.println("Kalan total bakiyeniz : " + PlayerList.get(karakter).coin + " gold");
                        break;
                    case 1: // kazandın
                        System.out.println(karakter + " adlı karakteriniz +" + miktar + " gold kazandı.");
                        PlayerList.get(karakter).coin += miktar;
                        System.out.println("Yeni total bakiyeniz : " + PlayerList.get(karakter).coin + " gold");
                        break;
                    case 2: //berabere
                        break;
                }
            } else System.out.println("Girilen miktar karakterinizin bakiyesinden büyük olamaz!");
        } else System.out.println("Lütfen geçerli bir sayi giriniz!");
    }

    public static int Taş_Kağıt_Makas_Hesaplama(int oyuncu_seçimi, int rastgele_seçim) {  // 0-) kaybetti 1-)kazandı 2-)berabere
        if (oyuncu_seçimi == 1) { //TAŞ
            switch (rastgele_seçim) {
                case 1:
                    System.out.println("(TAŞ-TAŞ) Berabere!");
                    return 2;
                case 2:
                    System.out.println("(TAŞ-KAĞIT) KAYBETTİNİZ!");
                    return 0;
                case 3:
                    System.out.println("(TAŞ-MAKAS) KAZANDINIZ!");
                    return 1;
            }
        } else if (oyuncu_seçimi == 2) { //KAĞIT
            switch (rastgele_seçim) {
                case 1:
                    System.out.println("(KAĞIT-TAŞ) KAZANDINIZ!");
                    return 1;
                case 2:
                    System.out.println("(KAĞIT-KAĞIT) BERABERE!");
                    return 2;
                case 3:
                    System.out.println("(KAĞIT-MAKAS) KAYBETTİNİZ!");
                    return 0;
            }
        } else if (oyuncu_seçimi == 3) { //MAKAS
            switch (rastgele_seçim) {
                case 1:
                    System.out.println("(MAKAS-TAŞ) KAYBETTİNİZ!");
                    return 0;
                case 2:
                    System.out.println("(MAKAS-KAĞIT) KAZANDINIZ!");
                    return 1;
                case 3:
                    System.out.println("(MAKAS-MAKAS) BERABERE!");
                    return 2;
            }
        }
        return 4; // null
    }
}





