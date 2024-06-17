import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class User implements Cloneable {
    private String name;
    private final String username;
    private final int userId;

    private Archer archer;
    private Healer healer;
    private Knight knight;
    private Mage mage;
    private MythicalCreature mythicalCreature;

    private int XP;
    private int goldCoins = 500;
    public boolean isOponent = false;
    private String homeGround;

    public Archer getArcher() {
        return archer;
    }

    public void setArcher(Archer archer) {
        this.archer = archer;
    }

    public Healer getHealer() {
        return healer;
    }

    public void setHealer(Healer healer) {
        this.healer = healer;
    }

    public Knight getKnight() {
        return knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    public Mage getMage() {
        return mage;
    }

    public void setMage(Mage mage) {
        this.mage = mage;
    }

    public MythicalCreature getMythicalCreature() {
        return mythicalCreature;
    }

    public void setMythicalCreature(MythicalCreature mythicalCreature) {
        this.mythicalCreature = mythicalCreature;
    }

    public String getHomeGround() {
        return homeGround;
    }

    public void setHomeGround(String homeGround) {
        this.homeGround = homeGround;
    }

    @Override
    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            // This should never happen since Army implements Cloneable
            throw new AssertionError();
        }
    }

    public int getXP() {
        return this.XP;
    }

    public void setXP(int xP) {
        this.XP = xP;
    }

    public User(String name, String username, int userId) {

        this.name = name;
        this.username = username;
        this.userId = userId;
    }

    public User(String name, String username, int XP, int userID, int goldCoins, String homeGround,
            Archer archer, Knight knight, Mage mage, Healer healer, MythicalCreature mythicalCreature) {
        this.name = name;
        this.username = username;
        this.XP = XP;
        this.goldCoins = goldCoins;
        this.homeGround = homeGround;
        this.archer = (Archer) archer.clone();
        this.knight = (Knight) knight.clone();
        this.mage = (Mage) mage.clone();
        this.healer = (Healer) healer.clone();
        this.mythicalCreature = (MythicalCreature) mythicalCreature.clone();
        this.userId = userID;
    }

    public void displayPlayerProfile() {
        System.out.println("Name: " + name);
        System.out.println("XP: " + XP);
        System.out.println("Archer: " + archer.getName());
        System.out.println("Knight: " + knight.getName());
        System.out.println("Mage: " + mage.getName());
        System.out.println("Healer: " + healer.getName());
        System.out.println("Mythical Creature: " + mythicalCreature.getName());
    }

    Scanner sc = new Scanner(System.in);

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }

    public int getGoldCoins() {
        return this.goldCoins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public int getUserID() {
        return userId;
    }

    public List<Army> getArmy() {
        List<Army> myArmy = new ArrayList<>();
        myArmy.add(this.archer);
        myArmy.add(this.knight);
        myArmy.add(this.mage);
        myArmy.add(this.healer);
        myArmy.add(this.mythicalCreature);

        return myArmy;

    }

    public void sellArmy(Army character) {
        double value = character.getPrice() * 0.9;
        int val = (int) Math.round(value);
        this.goldCoins += val;
    }

    // Method to handle archer purchase
    private void purchaseArcher(Archer archer, List<Archer> archerList, User player2, ArrayList<Army> objects) {
        if (archer != null) {
            if (this.goldCoins > archer.getPrice()) {
                this.goldCoins -= archer.getPrice();
                this.archer = (Archer) archer.clone();
                System.out.println();
                System.out.println("You bought " + archer.getName());

            } else {
                System.out.println("You don't have sufficient money to buy " + archer.getName() + ".");
                System.out.println("Choose another archer ");
                if (this.getGoldCoins() < 80) {
                    System.out.println("--------------------------------------------");
                    System.out.println("--------------------------------------------");
                    System.out.println("You don't have sufficient gold coins to complete the army.");
                    System.out.println("Let's recreate the Army!");
                    createArmy(player2, objects);
                }
                else{
                    buyArcher(archerList.get(0), archerList.get(1), archerList.get(2), archerList.get(3),
                        archerList.get(4), player2, objects);
                }
            }
        } else {
            System.out.println("Invalid archer name.");
        }
    }

    public void buyArcher(Archer shooter, Archer ranger, Archer sunfire, Archer zing, Archer saggitarius, User player2,
            ArrayList<Army> objects) {
        List<Archer> archerList = new ArrayList<>();
        archerList.add(shooter);
        archerList.add(ranger);
        archerList.add(sunfire);
        archerList.add(zing);
        archerList.add(saggitarius);

        System.out.println();

        System.out.println("               1       2       3       4         5   ");
        System.out.println("Name:       Shooter  Ranger  Sunfire  Zing  Saggitarius");
        System.out.println("Price:        80      115     160     200      230  ");
        System.out.println("Attack:       11       14      15      16       18  ");
        System.out.println("Defence:       4        5       5       9        7  ");
        System.out.println("Health:        6        8       7      11       12  ");
        System.out.println("Speed:         9       10      14      14       17  ");

        System.out.println();
        int archer;

        while (true) {
            try {
                System.out.println("Choose the relevent number :");
                archer = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter again!");
                sc.nextLine();
            }
        }

        switch (archer) {// Shooter
            case 1:
                purchaseArcher(shooter, archerList, player2, objects);
                break;
            case 2:
                purchaseArcher(ranger, archerList, player2, objects);
                break;
            case 3:
                purchaseArcher(sunfire, archerList, player2, objects);
                break;
            case 4:
                purchaseArcher(zing, archerList, player2, objects);
                break;
            case 5:
                purchaseArcher(saggitarius, archerList, player2, objects);
                break;
            default:
                System.out.println("Invalid input. Enter again!");
                buyArcher(shooter, ranger, sunfire, zing, saggitarius, player2, objects);
        }

    }

    // Method to handle knight purchase
    private void purchaseKnight(Knight knight, List<Knight> knightList, User player2, ArrayList<Army> objects) {
        if (knight != null) {
            if (this.goldCoins > knight.getPrice()) {
                this.goldCoins -= knight.getPrice();
                this.knight = (Knight) knight.clone();
                System.out.println();
                System.out.println("You bought " + knight.getName());
            } else {
                System.out.println("You don't have sufficient money to buy " + knight.getName() + ".");
                System.out.println("Choose another knight ");
                if (this.getGoldCoins() < 85) {
                    System.out.println("--------------------------------------------");
                    System.out.println("--------------------------------------------");
                    System.out.println("You don't have sufficient gold coins to complete the army.");
                    System.out.println("Let's recreate the Army!");
                    createArmy(player2, objects);
                }
                else{
                    buyKnight(knightList.get(0), knightList.get(1), knightList.get(2), knightList.get(3),
                        knightList.get(4), player2, objects);
                }
            }
        } else {
            System.out.println("Invalid knight name.");
        }
    }

    public void buyKnight(Knight squire, Knight cavalier, Knight templar, Knight zoro, Knight swiftblade, User player2,
            ArrayList<Army> objects) {
        List<Knight> knightList = new ArrayList<>();
        knightList.add(squire);
        knightList.add(cavalier);
        knightList.add(templar);
        knightList.add(zoro);
        knightList.add(swiftblade);

        System.out.println();
        System.out.println("               1       2        3       4         5   ");
        System.out.println("Name:       Squire  Cavalier  Templar  Zoro   Swiftblade");
        System.out.println("Price:        85      110      155     180      250  ");
        System.out.println("Attack:        8       10       14      17       18  ");
        System.out.println("Defence:       9       12       16      16       20  ");
        System.out.println("Health:        7        7       12      13       17  ");
        System.out.println("Speed:         8       10       12      14       13  ");

        System.out.println();
        int Knight;
        while (true) {
            try {
                System.out.println("Choose the relevent number :");
                Knight = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter again!");
                sc.nextLine();
            }
        }

        switch (Knight) {
            case 1:
                purchaseKnight(squire, knightList, player2, objects);
                break;
            case 2:
                purchaseKnight(cavalier, knightList, player2, objects);
                break;
            case 3:
                purchaseKnight(templar, knightList, player2, objects);
                break;
            case 4:
                purchaseKnight(zoro, knightList, player2, objects);
                break;
            case 5:
                purchaseKnight(swiftblade, knightList, player2, objects);
                break;
            default:
                System.out.println("Invalid input. Enter again!");
                buyKnight(squire, cavalier, templar, zoro, swiftblade, player2, objects);
        }

    }

    // Method to handle mage purchase
    private void purchaseMage(Mage mage, List<Mage> mageList, User player2, ArrayList<Army> objects) {
        if (mage != null) {
            if (this.goldCoins > mage.getPrice()) {
                this.goldCoins -= mage.getPrice();
                this.mage = (Mage) mage.clone();
                System.out.println();
                System.out.println("You bought " + mage.getName());
            } else {
                System.out.println("You don't have sufficient money to buy " + mage.getName() + ".");
                System.out.println("Choose another mage ");
                if (this.getGoldCoins() < 100) {
                    System.out.println("--------------------------------------------");
                    System.out.println("--------------------------------------------");
                    System.out.println("You don't have sufficient gold coins to complete the army.");
                    System.out.println("Let's recreate the Army!");
                    createArmy(player2, objects);
                }
                else{
                    buyMage(mageList.get(0), mageList.get(1), mageList.get(2), mageList.get(3),
                        mageList.get(4), player2, objects);
                }
            }
        } else {
            System.out.println("Invalid mage name.");
        }
    }

    public void buyMage(Mage warlock, Mage illusionist, Mage enchanter, Mage conjurer, Mage eldritch, User player2,
            ArrayList<Army> objects) {

        List<Mage> mageList = new ArrayList<>();
        mageList.add(warlock);
        mageList.add(illusionist);
        mageList.add(enchanter);
        mageList.add(conjurer);
        mageList.add(eldritch);

        System.out.println();

        System.out.println("               1          2           3           4         5   ");
        System.out.println("Name:        Warlock  Illusionist  Enchanter  Conjurer   Eldritch");
        System.out.println("Price:        100        120         160        195        270  ");
        System.out.println("Attack:        12         13          16         18         19  ");
        System.out.println("Defence:        7          8          10         15         17  ");
        System.out.println("Health:        10         12          13         14         18  ");
        System.out.println("Speed:         12         14          16         12         14  ");

        System.out.println();
        int Mage;

        while (true) {
            try {
                System.out.println("Choose the relevent number :");
                Mage = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter again!");
                sc.nextLine();
            }
        }

        switch (Mage) {
            case 1:
                purchaseMage(warlock, mageList, player2, objects);
                break;
            case 2:
                purchaseMage(illusionist, mageList, player2, objects);
                break;
            case 3:
                purchaseMage(enchanter, mageList, player2, objects);
                break;
            case 4:
                purchaseMage(conjurer, mageList, player2, objects);
                break;
            case 5:
                purchaseMage(eldritch, mageList, player2, objects);
                break;
            default:
                System.out.println("Invalid input. Enter again!");
                buyMage(warlock, illusionist, enchanter, conjurer, eldritch, player2, objects);
        }

    }

    // Method to handle Healer purchase
    private void purchaseHealer(Healer healer, List<Healer> healerList, User player2, ArrayList<Army> objects) {
        if (healer != null) {
            if (this.goldCoins > healer.getPrice()) {
                this.goldCoins -= healer.getPrice();
                this.healer = (Healer) healer.clone();
                System.out.println();
                System.out.println("You bought " + healer.getName());
            } else {
                System.out.println("You don't have sufficient money to buy " + healer.getName() + ".");
                System.out.println("Choose another healer ");
                if (this.getGoldCoins() < 95) {
                    System.out.println("--------------------------------------------");
                    System.out.println("--------------------------------------------");
                    System.out.println("You don't have sufficient gold coins to complete the army.");
                    System.out.println("Let's recreate the Army!");
                    createArmy(player2, objects);
                }
                else{
                    buyHealer(healerList.get(0), healerList.get(1), healerList.get(2), healerList.get(3),
                        healerList.get(4), player2, objects);
                }
                
            }
        } else {
            System.out.println("Invalid mage name.");
        }
    }

    public void buyHealer(Healer soother, Healer medic, Healer alchemist, Healer saint, Healer lightbringer,
            User player2, ArrayList<Army> objects) {
        List<Healer> healerList = new ArrayList<>();
        healerList.add(soother);
        healerList.add(medic);
        healerList.add(alchemist);
        healerList.add(saint);
        healerList.add(lightbringer);

        System.out.println();

        System.out.println("               1          2           3           4         5   ");
        System.out.println("Name:        Soother     Medic     Alchemist    Saint   Lightbringer");
        System.out.println("Price:         95        125         150         200        260  ");
        System.out.println("Attack:        10         12          13          16         17  ");
        System.out.println("Defence:        8          9          13          14         15  ");
        System.out.println("Health:         9         10          13          17         19  ");
        System.out.println("Speed:          6          7          13           9         12  ");

        System.out.println();
        int Healer;

        while (true) {
            try {
                System.out.println("Choose the relevent number :");
                Healer = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter again!");
                sc.nextLine();
            }
        }

        switch (Healer) {
            case 1:
                purchaseHealer(soother, healerList, player2, objects);
                break;
            case 2:
                purchaseHealer(medic, healerList, player2, objects);
                break;
            case 3:
                purchaseHealer(alchemist, healerList, player2, objects);
                break;
            case 4:
                purchaseHealer(saint, healerList, player2, objects);
                break;
            case 5:
                purchaseHealer(lightbringer, healerList, player2, objects);
                break;
            default:
                System.out.println("Invalid input. Enter again!");
                buyHealer(soother, medic, alchemist, saint, lightbringer, player2, objects);
        }
    }

    private void purchaseMythicalCreature(MythicalCreature mythicalCreature,
            List<MythicalCreature> mythicalCreaturesList, User player2, ArrayList<Army> objects) {
        if (mythicalCreature != null) {
            if (this.goldCoins > mythicalCreature.getPrice()) {
                this.goldCoins -= mythicalCreature.getPrice();
                this.mythicalCreature = (MythicalCreature) mythicalCreature.clone();
                System.out.println();
                System.out.println("You bought " + mythicalCreature.getName());
            } else {
                System.out.println("You don't have sufficient money to buy " + mythicalCreature.getName() + ".");
                System.out.println("Choose another mythical Creature ");
                if (this.getGoldCoins() < 120) {
                    System.out.println("--------------------------------------------");
                    System.out.println("--------------------------------------------");
                    System.out.println("You don't have sufficient gold coins to complete the army.");
                    System.out.println("Let's recreate the Army!");
                    createArmy(player2, objects);
                }
                else{
                    buyMythicalCreature(mythicalCreaturesList.get(0), mythicalCreaturesList.get(1),
                        mythicalCreaturesList.get(2), mythicalCreaturesList.get(3),
                        mythicalCreaturesList.get(4), player2, objects);
                }
            }
        } else {
            System.out.println("Invalid mythicalCreature name.");
        }
    }

    public void buyMythicalCreature(MythicalCreature dragon, MythicalCreature basilisk, MythicalCreature hydra,
            MythicalCreature phoenix, MythicalCreature pegasus, User player2, ArrayList<Army> objects) {

        List<MythicalCreature> mythicalCreaturesList = new ArrayList<>();
        mythicalCreaturesList.add(dragon);
        mythicalCreaturesList.add(basilisk);
        mythicalCreaturesList.add(hydra);
        mythicalCreaturesList.add(phoenix);
        mythicalCreaturesList.add(pegasus);

        System.out.println();

        System.out.println("               1          2           3           4          5   ");
        System.out.println("Name:        Dragon    Basilisk      Hydra     Phoenix    Pegasus");
        System.out.println("Price:        120        165          205        275        340  ");
        System.out.println("Attack:        12         15           12         17         14  ");
        System.out.println("Defence:       14         11           16         13         18  ");
        System.out.println("Health:        15         10           15         17         20  ");
        System.out.println("Speed:          8         12           11         19         20  ");

        System.out.println();
        int MythicalCreature;

        while (true) {
            try {
                System.out.println("Choose the relevent number :");
                MythicalCreature = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter again!");
                sc.nextLine();
            }
        }

        switch (MythicalCreature) {
            case 1:
                purchaseMythicalCreature(dragon, mythicalCreaturesList, player2, objects);
                break;
            case 2:
                purchaseMythicalCreature(basilisk, mythicalCreaturesList, player2, objects);
                break;
            case 3:
                purchaseMythicalCreature(hydra, mythicalCreaturesList, player2, objects);
                break;
            case 4:
                purchaseMythicalCreature(phoenix, mythicalCreaturesList, player2, objects);
                break;
            case 5:
                purchaseMythicalCreature(pegasus, mythicalCreaturesList, player2, objects);
                break;
            default:
                System.out.println("Invalid input. Enter again!");
                buyMythicalCreature(dragon, basilisk, hydra, phoenix, pegasus, player2, objects);
        }
    }

    private void purchaseArmour(Armour armour, Army character) {
        if (armour != null) {
            if (this.goldCoins > armour.getPrice()) {
                this.goldCoins -= armour.getPrice();
                character.setArmour((Armour) armour.clone());

                System.out.println();
                System.out.println("You bought " + armour.getName() + " armour for " + character.getName());

                double value = armour.getPrice() * 0.2;
                int val = (int) Math.round(value);
                character.setPrice(character.getPrice() + val);
            } else {
                System.out.println("You don't have sufficient money to buy " + armour.getName() + ".");
            }
        } else {
            System.out.println("Invalid knight name.");
        }
    }

    public void buyArmour(Armour chainmail, Armour regalia, Armour fleece, Army character) {
        System.out.println();

        System.out.println("                     1          2           3    ");
        System.out.println("Name:            Chainmail    Regalia     Fleece ");
        System.out.println("Price:              70          105        150  ");
        System.out.println("Attack Bonus:        0           0          0   ");
        System.out.println("Defence Bonus:       1           1          2   ");
        System.out.println("Health Bonus:        0           0          1   ");
        System.out.println("Speed Bonus:        -1           0         -1   ");

        System.out.println();
        System.out.println("If you don't want any armour for " + character.getName() + " enter 0");

        int Armour;

        while (true) {
            try {
                System.out.println("Choose the relevent number :");
                Armour = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter again!");
                sc.nextLine();
            }
        }

        switch (Armour) {
            case 0:
                break;
            case 1:
                purchaseArmour(chainmail, character);
                break;
            case 2:
                purchaseArmour(regalia, character);
                break;
            case 3:
                purchaseArmour(fleece, character);
                break;
            default:
                System.out.println("Invalid input. Enter again!");
                buyArmour(chainmail, regalia, fleece, character);
        }
    }

    private void purchaseArtefact(Artefact artefact, Army character) {
        if (artefact != null) {
            if (this.goldCoins > artefact.getPrice()) {
                this.goldCoins -= artefact.getPrice();
                character.setArtefact((Artefact) artefact.clone());

                double value = artefact.getPrice() * 0.2;
                int val = (int) Math.round(value);
                character.setPrice(character.getPrice() + val);
                System.out.println();
                System.out.println("You bought " + artefact.getName() + " artefact for " + character.getName());
            } else {
                System.out.println("You don't have sufficient money to buy " + artefact.getName() + ".");
            }
        } else {
            System.out.println("Invalid knight name.");
            purchaseArtefact(artefact, character);
        }
    }

    public void buyArtefact(Artefact excalibur, Artefact amulet, Artefact crystal, Army character) {
        System.out.println();

        System.out.println("                     1          2           3    ");
        System.out.println("Name:            Excalibur    Amulet     Crystal ");
        System.out.println("Price:             150         200         210  ");
        System.out.println("Attack Bonus:       2           1           2   ");
        System.out.println("Defence Bonus:      0          -1           1   ");
        System.out.println("Health Bonus:       0           1          -1   ");
        System.out.println("Speed Bonus:        0           1          -1   ");

        System.out.println();
        System.out.println("If you don't want any artefacts for " + character.getName() + " enter 0");

        int Artefact;

        while (true) {
            try {
                System.out.println("Choose the relevent number :");
                Artefact = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter again!");
                sc.nextLine();
            }
        }

        switch (Artefact) {
            case 0:
                break;
            case 1:
                purchaseArtefact(excalibur, character);
                break;
            case 2:
                purchaseArtefact(amulet, character);
                break;
            case 3:
                purchaseArtefact(crystal, character);
                break;
            default:
                System.out.println("Invalid input. Enter again!");
                buyArtefact(excalibur, amulet, crystal, character);
        }
    }

    public void createArmy(User player2, ArrayList<Army> objects) {
        this.goldCoins = 500;
        System.out.println();
        System.out.println("To start the game you should buy one character from each of the categories");
        System.out.println("\tArcher\n\tKnight\n\tMage\n\tHealer\n\tMythical creature");
        System.out.println();
        System.out.println("You have " + this.goldCoins + " gold coins");
        System.out.println();

        System.out.println("Select one from below Archers");
        player2.buyArcher((Archer) objects.get(0), (Archer) objects.get(1), (Archer) objects.get(2),
                (Archer) objects.get(3), (Archer) objects.get(4), player2, objects);
        System.out.println("Your balance is: " + player2.getGoldCoins() + " goldcoins");
        System.out.println();

        System.out.println("Select one from below Knights");
        player2.buyKnight((Knight) objects.get(5), (Knight) objects.get(6), (Knight) objects.get(7),
                (Knight) objects.get(8), (Knight) objects.get(9), player2, objects);
        System.out.println("Your balance is: " + player2.getGoldCoins() + " goldcoins");
        System.out.println();

        System.out.println("Select one from below Mages");
        player2.buyMage((Mage) objects.get(10), (Mage) objects.get(11), (Mage) objects.get(12), (Mage) objects.get(13),
                (Mage) objects.get(14), player2, objects);
        System.out.println("Your balance is: " + player2.getGoldCoins() + " goldcoins");
        System.out.println();

        System.out.println("Select one from below Healers");
        player2.buyHealer((Healer) objects.get(15), (Healer) objects.get(16), (Healer) objects.get(17),
                (Healer) objects.get(18), (Healer) objects.get(19), player2, objects);
        System.out.println("Your balance is: " + player2.getGoldCoins() + " goldcoins");
        System.out.println();

        System.out.println("Select one from below Mythical creature");
        player2.buyMythicalCreature((MythicalCreature) objects.get(20), (MythicalCreature) objects.get(21),
                (MythicalCreature) objects.get(22), (MythicalCreature) objects.get(23),
                (MythicalCreature) objects.get(24), player2, objects);
        System.out.println("Your balance is: " + player2.getGoldCoins() + " goldcoins");
        System.out.println();
    }

}