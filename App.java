import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static final boolean usernameExists = false;

    public static void main(String[] args) throws Exception {

        Archer shooter = new Archer("Shooter", 80, 11, 4, 6, 9, "Highlanders");
        Archer ranger = new Archer("Ranger", 115, 14, 5, 8, 10, "Highlanders");
        Archer sunfire = new Archer("Sunfire", 160, 15, 5, 7, 14, "Sunchildren");
        Archer zing = new Archer("Zing", 200, 16, 9, 11, 14, "Sunchildren");
        Archer saggitarius = new Archer("Saggitarius", 230, 18, 7, 12, 17, "Mystics");

        Knight squire = new Knight("Squire", 85, 8, 9, 7, 8, "Marshlanders");
        Knight cavalier = new Knight("Cavalier", 110, 10, 12, 7, 10, "Highlanders");
        Knight templar = new Knight("Templar", 155, 14, 16, 12, 12, "Sunchildren");
        Knight zoro = new Knight("Zoro", 180, 17, 16, 13, 14, "Highlanders");
        Knight swiftblade = new Knight("Swiftblade", 250, 18, 20, 17, 13, "Marshlanders");

        Mage warlock = new Mage("Warlock", 100, 12, 7, 10, 12, "Marshlanders");
        Mage illusionist = new Mage("Illusionist", 120, 13, 8, 12, 14, "Mystics");
        Mage enchanter = new Mage("Enchanter", 160, 16, 10, 13, 16, "Highlanders");
        Mage conjurer = new Mage("Conjurer", 195, 18, 15, 14, 12, "Highlanders");
        Mage eldritch = new Mage("Eldritch", 270, 19, 17, 18, 14, "Mystics");

        Healer soother = new Healer("Soother", 95, 10, 8, 9, 6, "Sunchildren");
        Healer medic = new Healer("Medic", 125, 12, 9, 10, 7, "Highlanders");
        Healer alchemist = new Healer("Alchemist", 150, 13, 13, 13, 13, "Marshlanders");
        Healer saint = new Healer("Saint", 200, 16, 14, 17, 9, "Mystics");
        Healer lightbringer = new Healer("Lightbringer", 260, 17, 15, 9, 12, "Sunchildren");

        MythicalCreature dragon = new MythicalCreature("Dragon", 120, 12, 14, 15, 8, "Sunchildren");
        MythicalCreature basilisk = new MythicalCreature("Basilisk", 165, 15, 11, 10, 12, "Marshlanders");
        MythicalCreature hydra = new MythicalCreature("Hydra", 205, 12, 16, 15, 11, "Marshlanders");
        MythicalCreature phoenix = new MythicalCreature("Phoenix", 275, 17, 13, 17, 19, "Sunchildren");
        MythicalCreature pegasus = new MythicalCreature("Pegasus", 340, 14, 18, 20, 20, "Mystics");

        Armour chainmail = new Armour("Chainmail", 70, 0, 1, 0, -1);
        Armour regalia = new Armour("Regalia", 105, 0, 1, 0, 0);
        Armour fleece = new Armour("Fleece", 150, 0, 2, 1, -1);

        Artefact excalibur = new Artefact("Excalibur", 150, 2, 0, 0, 0);
        Artefact amulet = new Artefact("Amulet", 200, 1, -1, 1, 1);
        Artefact crystal = new Artefact("Crystal", 210, 2, 1, -1, -1);

        ArrayList<Army> objects = new ArrayList<>();
        objects.add(shooter);
        objects.add(ranger);
        objects.add(sunfire);
        objects.add(zing);
        objects.add(saggitarius);
        objects.add(squire);
        objects.add(cavalier);
        objects.add(templar);
        objects.add(zoro);
        objects.add(swiftblade);
        objects.add(warlock);
        objects.add(illusionist);
        objects.add(enchanter);
        objects.add(conjurer);
        objects.add(eldritch);
        objects.add(soother);
        objects.add(medic);
        objects.add(alchemist);
        objects.add(saint);
        objects.add(lightbringer);
        objects.add(dragon);
        objects.add(basilisk);
        objects.add(hydra);
        objects.add(phoenix);
        objects.add(pegasus);

        ArrayList<Equipment> equipmentObjects = new ArrayList<>();
        equipmentObjects.add(chainmail);
        equipmentObjects.add(regalia);
        equipmentObjects.add(fleece);
        equipmentObjects.add(excalibur);
        equipmentObjects.add(amulet);
        equipmentObjects.add(crystal);

        User defaultPlayer1 = new User("GeraltofRivia", "whitewolf", 32, 1, 215, "Marshland", ranger, squire, warlock,
                medic, dragon);
        defaultPlayer1.getArcher().setArmour(chainmail);
        defaultPlayer1.getHealer().setArtefact(amulet);

        User defaultPlayer2 = new User("SwordMaster", "BladeKnight", 25, 2, 300, "Hillcrest", shooter, cavalier,
                illusionist, soother, phoenix);
        defaultPlayer2.getKnight().setArmour(fleece);

        User defaultPlayer3 = new User("Aurora", "EthernalDreamer", 40, 3, 200, "Desert", sunfire, templar, enchanter,
                alchemist, basilisk);
        defaultPlayer3.getMythicalCreature().setArtefact(crystal);

        FileWriter writer1 = null;
        try {
            writer1 = new FileWriter("usernames.txt", true);
            writer1.write("whitewolf\n");
            writer1.write("BladeKnight\n");
            writer1.write("EthernalDreamer\n");
            writer1.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer1 != null) {
                    writer1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter writer2 = null;
        try {
            writer2 = new FileWriter("userID.txt", true);
            writer2.write("3\n");
            writer2.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer2 != null) {
                    writer2.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        ArrayList<User> defaultPlayers = new ArrayList<>();
        defaultPlayers.add(defaultPlayer1.clone());
        defaultPlayers.add(defaultPlayer2.clone());
        defaultPlayers.add(defaultPlayer3.clone());

        User player1 = defaultPlayer1;

        Scanner sc = new Scanner(System.in);
        String filename2 = "userID.txt";

        String name2;
        String userName2;
        int userID2;

        System.out.println(" __  __           _   _        __  __             _                     ");
        System.out.println("|  \\/  |         | | (_)      |  \\/  |           | |                    ");
        System.out.println("| \\  / |_   _ ___| |_ _  ___  | \\  / | __ _ _   _| |__   ___ _ __ ___   ");
        System.out.println("| |\\/| | | | / __| __| |/ __| | |\\/| |/ _` | | | | '_ \\ / _ \\ '_ ` _ \\  ");
        System.out.println("| |  | | |_| \\__ \\ |_| | (__  | |  | | (_| | |_| | | | |  __/ | | | | | ");
        System.out.println("|_|  |_|\\__, |___/\\__|_|\\___| |_|  |_|\\__,_|\\__, |_| |_|\\___|_| |_| |_| ");
        System.out.println("         __/ |                               __/ |                      ");
        System.out.println("        |___/                               |___/       ");

        System.out.println();
        System.out.println("Let's create a player profile!");
        System.out.println("Press any key to continue.");

        sc.nextLine();

        System.out.println("Enter your name : ");
        name2 = sc.next();

        userName2 = getUniqueUsernameFromUser();
        writeUsernameToFile(userName2);

        int num = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("userID.txt"))) {
            String line;
            if ((line = reader.readLine()) != null) {
                num = Integer.parseInt(line.trim());

            }
        } catch (IOException | NumberFormatException e) {
            // Catching both IOException and NumberFormatException
            e.printStackTrace();
            num = 1; // Default value if an error occurs while reading or parsing the integer
        }

        userID2 = num + 1;

        try (FileWriter writer = new FileWriter(filename2)) {
            String numline = Integer.toString(userID2);
            writer.write(numline);
            writer.write("\n");
            // Optionally, you can add a newline character after writing the integer
            // writer.write(System.lineSeparator());

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        User player2 = new User(name2, userName2, userID2); // user

        // create army
        player2.createArmy(player2,objects);

        // create equipment
        System.out.println("Choose equipment for your characters");
        System.out.println("You can choose upto one armour and artefact");
        System.out.println();
        
        System.out.println("Do you want to buy equipment for any of your characters?");
        System.out.println("If YES enter 1");
        System.out.println("If NO enter 0");

        int option;

        while (true) {
            try {
                option = sc.nextInt();
                System.out.println();
                switch (option) {
                    case 0:
                        break;
                    case 1:
                        for (Army character : player2.getArmy()) {
                            System.out.println("You can buy equipment for " + character.getName());
                            System.out.println("Select one from below Armours");
                            player2.buyArmour(chainmail, regalia, fleece, character);
                            System.out.println("Your balance is: " + player2.getGoldCoins()+" goldcoins");
                            System.out.println();
                            System.out.println("Select one from below Artefacts");
                            player2.buyArtefact(excalibur, amulet, crystal, character);
                            System.out.println("Your balance is: " + player2.getGoldCoins()+" goldcoins");
                            System.out.println();
                        }
                        break;
        
                    default:
                        System.out.println("Invalid input. Enter again!");
                        continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter again!");
                sc.nextLine();
            }
        }

        Menu(player1, player2, objects, defaultPlayers, equipmentObjects);

        // end battle

    }

    public static void Menu(User player1, User player2, ArrayList<Army> objects, ArrayList<User> defaulPLayers,
            ArrayList<Equipment> equipmentobjects) {
        displayMenu();

        Scanner sc = new Scanner(System.in);
        int option;

        while (true) {
            try {
                System.out.println("Choose the relevent number :");
                option = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter again!");
                sc.nextLine();
            }
        }

        switch (option) {
            case 1:
                System.out.println("Enter the new name: ");
                String newName;
                newName = sc.next();
                player2.setName(newName);
                Menu(player1, player2, objects, defaulPLayers, equipmentobjects);
                break;

            case 2:
                changeCharacter(player2, objects, equipmentobjects, defaulPLayers, player1);
                break;

            case 3:
                changeEquipment(player2, objects, equipmentobjects, defaulPLayers, player1);
                break;

            case 4:
                selectHomeland(player2);
                player1 = chooseOpponent(player1, defaulPLayers);
                System.out.println();
                System.out.println("Do you want to challenge player1 ? ");
                System.out.println("1. YES");
                System.out.println("2. NO");
                System.out.println();

                int choose;

                while (true) {
                    try {
                        System.out.println("Choose the relevent number :");
                        choose = sc.nextInt();
                        if (choose == 1) {
                            player1.isOponent = true;
                            selectHomeland(player1, player2);
                            User clonePlayer1 = player1.clone();
                            User clonePlayer2 = player2.clone();
                            startBattle(player2, player1, objects, equipmentobjects, defaulPLayers);
                            player1 = clonePlayer1;
                            player2 = clonePlayer2;
        
                        } else if (choose == 2) {
                            player2.isOponent = true;
                            selectHomeland(player2, player1);
                            User clonePlayer1 = player1.clone();
                            User clonePlayer2 = player2.clone();
                            startBattle(player1, player2, objects, equipmentobjects, defaulPLayers);
                            player1 = clonePlayer1;
                            player2 = clonePlayer2;
        
                        } else{
                            System.out.println("Invalid input. Enter again!");
                            continue;
                        }

                        
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Enter again!");
                        sc.nextLine();
                    }
                }

                
            case 5:
                System.exit(0);

            default:
                System.out.println("Invalid input. Enter again!");
                sc.nextLine();
        }

    }

    public static void selectHomeland(User player2) {
        System.out.println("Select your home ground for the battle: ");
        System.out.println("1.Hillcrest\t2.Marshland\t3.Desert\t4.Arcane\t");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int homeland;
        
        while (true) {
            try {
                System.out.println("Choose the relevent number :");
                homeland = sc.nextInt();
                System.out.println();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter again!");
                sc.nextLine();
            }
        }

        switch (homeland) {
            case 1:
                player2.setHomeGround("Hillcrest");
                break;
            case 2:
                player2.setHomeGround("Marshland");
                break;
            case 3:
                player2.setHomeGround("Desert");
                break;
            case 4:
                player2.setHomeGround("Arcane");
                break;

            default:
                System.out.println("Invalid input. Enter again!");
                selectHomeland(player2);

        }
    }

    public static User chooseOpponent(User player1, ArrayList<User> defaultPlayers) {
        System.out.println("Choose your oponent: ");
        System.out.println("                            1               2             3      ");
        System.out.println("Name:                  GeralofRivia    SwordMaster      Aurora   ");
        System.out.println("XP:                       32              25              40     ");
        System.out.println("Archer:                  Ranger          Shooter         Sunfire ");
        System.out.println("Knight:                  Squire         Cavalier         Templar ");
        System.out.println("Mage:                    Warlock       Illusionist      Enchanter");
        System.out.println("Healer:                  Medic           Soother        Alchemist");
        System.out.println("Mythical Creature:       Dragon          Phoenix        Basilisk ");

        Scanner sc = new Scanner(System.in);
        int option;

        while (true) {
            try {
                System.out.println("Choose the relevent number :");
                option = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter again!");
                sc.nextLine();
            }
        }

        switch (option) {
            case 1:
                return defaultPlayers.get(0);
            case 2:
                return defaultPlayers.get(1);
            case 3:
                return defaultPlayers.get(2);

            default:
                System.out.println("Invalid number. Enter again!");
                chooseOpponent(player1, defaultPlayers);
        }
        return player1;

    }

    public static void displayMenu() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("|                                                         |");
        System.out.println("|                         MENU                            |");
        System.out.println("|                                                         |");
        System.out.println("|                   1. Change Name                        |");
        System.out.println("|                   2. Change Character                   |");
        System.out.println("|                   3. Change Equipment                   |");
        System.out.println("|                   4. Start a Battle                     |");
        System.out.println("|                   5. Exit game                          |");
        System.out.println("|                                                         |");
        System.out.println("-----------------------------------------------------------");
    }

    public static void changeCharacter(User player2, ArrayList<Army> objectList, ArrayList<Equipment> equipmentObjects,
            ArrayList<User> defaulPLayers, User player1) {
        System.out.println("Which army character do you want to change? ");
        System.out.println("1.Archer");
        System.out.println("2.Knight");
        System.out.println("3.Mage");
        System.out.println("4.Healer");
        System.out.println("5.Mythical creature");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        int option;

        while (true) {
            try {
                System.out.println("Choose the relevent number :");
                option = sc.nextInt();


                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter again!");
                System.out.println();
                sc.nextLine();
            }
        }

        switch (option) {
            case 1:
                if(player2.getGoldCoins()+player2.getArcher().getPrice()*(0.9)<80){
                    System.out.println("You can't sell this character.");
                    System.out.println("Insufficient money to buy another Archer!!");
                    Menu(player1, player2, objectList, defaulPLayers, equipmentObjects);
                }
                player2.sellArmy(player2.getArcher());
                player2.buyArcher((Archer) objectList.get(0), (Archer) objectList.get(1), (Archer) objectList.get(2),
                        (Archer) objectList.get(3), (Archer) objectList.get(4),player2,objectList);

                Menu(player1, player2, objectList, defaulPLayers, equipmentObjects);

            case 2:
            if(player2.getGoldCoins()+player2.getKnight().getPrice()*(0.9)<80){
                System.out.println("You can't sell this character.");
                System.out.println("Insufficient money to buy another Knight!!");
                Menu(player1, player2, objectList, defaulPLayers, equipmentObjects);
            }
                player2.sellArmy(player2.getKnight());
                player2.buyKnight((Knight) objectList.get(5), (Knight) objectList.get(6), (Knight) objectList.get(7),
                        (Knight) objectList.get(8), (Knight) objectList.get(9),player2,objectList);

                Menu(player1, player2, objectList, defaulPLayers, equipmentObjects);

            case 3:
            if(player2.getGoldCoins()+player2.getMage().getPrice()*(0.9)<80){
                System.out.println("You can't sell this character.");
                System.out.println("Insufficient money to buy another Mage!!");
                Menu(player1, player2, objectList, defaulPLayers, equipmentObjects);
            }
                player2.sellArmy(player2.getMage());
                player2.buyMage((Mage) objectList.get(10), (Mage) objectList.get(11), (Mage) objectList.get(12),
                        (Mage) objectList.get(13), (Mage) objectList.get(14),player2, objectList);

                Menu(player1, player2, objectList, defaulPLayers, equipmentObjects);

            case 4:
            if(player2.getGoldCoins()+player2.getHealer().getPrice()*(0.9)<80){
                System.out.println("You can't sell this character.");
                System.out.println("Insufficient money to buy another Healer!!");
                Menu(player1, player2, objectList, defaulPLayers, equipmentObjects);
            }
                player2.sellArmy(player2.getHealer());
                player2.buyHealer((Healer) objectList.get(15), (Healer) objectList.get(16), (Healer) objectList.get(17),
                        (Healer) objectList.get(18), (Healer) objectList.get(19),player2, objectList);

                Menu(player1, player2, objectList, defaulPLayers, equipmentObjects);

            case 5:
            if(player2.getGoldCoins()+player2.getMythicalCreature().getPrice()*(0.9)<80){
                System.out.println("You can't sell this character.");
                System.out.println("Insufficient money to buy another MythicalCreature!!");
                Menu(player1, player2, objectList, defaulPLayers, equipmentObjects);
            }
                player2.sellArmy(player2.getMythicalCreature());
                player2.buyMythicalCreature((MythicalCreature) objectList.get(15),
                        (MythicalCreature) objectList.get(16), (MythicalCreature) objectList.get(17),
                        (MythicalCreature) objectList.get(18), (MythicalCreature) objectList.get(19),player2, objectList);

                Menu(player1, player2, objectList, defaulPLayers, equipmentObjects);

            default:
                System.out.println("Invalid input. Enter again!");
                changeCharacter(player2, objectList, equipmentObjects, defaulPLayers, player1);
                break;

        }

    }

    public static void changeEquipment(User player2, ArrayList<Army> objectList, ArrayList<Equipment> EquipmentObjects,
            ArrayList<User> defaulPLayers, User player1) {
    
        System.out.println("In which charactor do you need to change the equipmnet?");
        System.out.println("Choose the relevent number:");
        System.out.println("1.Archer");
        System.out.println("2.Knight");
        System.out.println("3.Mage");
        System.out.println("4.Healer");
        System.out.println("5.MythicalCreater");
        Scanner sc = new Scanner(System.in);
        int option1 = sc.nextInt();
        System.out.println("Which equipment do you want to change? ");
        System.out.println("1.Armour");
        System.out.println("2.Artefact");
        int option2 = sc.nextInt();
        Army character=player2.getArcher();
        switch (option1) {
            case 1:
                character=player2.getArcher();
                break;

            case 2:
                character=player2.getKnight();
                break;

            case 3:
                character=player2.getMage();
                break;

            case 4:
                character=player2.getHealer();
                break;

            case 5:
                character=player2.getMythicalCreature();
                break;
        
            default:
                changeEquipment(player2, objectList, EquipmentObjects, defaulPLayers, player1);
                break;
        }

        switch (option2) {
            case 1:
                    
                    player2.buyArmour((Armour) EquipmentObjects.get(0), (Armour) EquipmentObjects.get(1),
                            (Armour) EquipmentObjects.get(2), character);
                Menu(player1, player2, objectList, defaulPLayers, EquipmentObjects);

            case 2:
                    player2.buyArtefact((Artefact) EquipmentObjects.get(3), (Artefact) EquipmentObjects.get(4),
                            (Artefact) EquipmentObjects.get(5), character);
                
                Menu(player1, player2, objectList, defaulPLayers, EquipmentObjects);

            default:
                changeEquipment(player2, objectList, EquipmentObjects, defaulPLayers, player1);
        }
    }

    // Method to check if a username already exists
    public static boolean isUsernameExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("usernames.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to write a username to a file
    public static void writeUsernameToFile(String username) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("usernames.txt", true));
            writer.append(username);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to get a unique username from the user
    public static String getUniqueUsernameFromUser() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String username;
        System.out.print("Enter a username: ");
        username = reader.readLine();
        while (isUsernameExists(username)) {
            System.out.print("Username exists. Enter another username: ");
            username = reader.readLine();
        }
        return username;
    }

    public static void startBattle(User challenger, User opponent, ArrayList<Army> objectList,
            ArrayList<Equipment> equipmentObjects, ArrayList<User> defaulPLayers) {

        ArrayList<Army> speedPriority1 = new ArrayList<>();
        ArrayList<Army> defencePriority1 = new ArrayList<>();

        ArrayList<Army> speedPriority2 = new ArrayList<>();
        ArrayList<Army> defencePriority2 = new ArrayList<>();

        ArrayList<Army> speedOrder1 = new ArrayList<>(5);
        speedOrder1.add(null);
        speedOrder1.add(null);
        speedOrder1.add(null);
        speedOrder1.add(null);
        speedOrder1.add(null);
        ArrayList<Army> speedOrder2 = new ArrayList<>(5);
        speedOrder2.add(null);
        speedOrder2.add(null);
        speedOrder2.add(null);
        speedOrder2.add(null);
        speedOrder2.add(null);

        ArrayList<Army> defenceOrder1 = new ArrayList<>(5);
        defenceOrder1.add(null);
        defenceOrder1.add(null);
        defenceOrder1.add(null);
        defenceOrder1.add(null);
        defenceOrder1.add(null);

        ArrayList<Army> defenceOrder2 = new ArrayList<>(5);
        defenceOrder2.add(null);
        defenceOrder2.add(null);
        defenceOrder2.add(null);
        defenceOrder2.add(null);
        defenceOrder2.add(null);

        ArrayList<Army> healthOrder1 = new ArrayList<>();
        ArrayList<Army> healthOrder2 = new ArrayList<>();

        speedPriority1.addAll(challenger.getArmy());
        defencePriority1.addAll(challenger.getArmy());

        speedPriority2.addAll(opponent.getArmy());
        defencePriority2.addAll(opponent.getArmy());

        for (Army character : speedPriority1) {
            if (character instanceof Archer) {
                speedOrder1.set(4, character); 
            } else if (character instanceof Knight) {
                speedOrder1.set(3, character);
            } else if (character instanceof MythicalCreature) {
                speedOrder1.set(2, character);
            } else if (character instanceof Mage) {
                speedOrder1.set(1, character);
            } else if (character instanceof Healer) {
                speedOrder1.set(0, character);
            }
        }

        for (Army character : defencePriority1) {
            if (character instanceof Mage) {
                defenceOrder1.set(0, character);
            } else if (character instanceof Knight) {
                defenceOrder1.set(1, character);
            } else if (character instanceof Archer) {
                defenceOrder1.set(2, character);
            } else if (character instanceof MythicalCreature) {
                defenceOrder1.set(3, character);
            } else if (character instanceof Healer) {
                defenceOrder1.set(4, character);
            }
        }

        for (Army character : speedPriority2) {
            if (character instanceof Archer) {
                speedOrder2.set(4, character);
            } else if (character instanceof Knight) {
                speedOrder2.set(3, character);
            } else if (character instanceof MythicalCreature) {
                speedOrder2.set(2, character);
            } else if (character instanceof Mage) {
                speedOrder2.set(1, character);
            } else if (character instanceof Healer) {
                speedOrder2.set(0, character);
            }
        }

        for (Army character : defencePriority2) {
            if (character instanceof Mage) {
                defenceOrder2.set(0, character);
            } else if (character instanceof Knight) {
                defenceOrder2.set(1, character);
            } else if (character instanceof Archer) {
                defenceOrder2.set(2, character);
            } else if (character instanceof MythicalCreature) {
                defenceOrder2.set(3, character);
            } else if (character instanceof Healer) {
                defenceOrder2.set(4, character);
            }
        }

        healthOrder1.addAll(challenger.getArmy());
        healthOrder2.addAll(opponent.getArmy());

        // Sort characters based on speed in descending order
        Collections.sort(speedOrder1, Comparator.comparingDouble(Army::getSpeed));
        Collections.sort(speedOrder2, Comparator.comparingDouble(Army::getSpeed));

        // Sort characters based on defence in ascending order
        Collections.sort(defenceOrder1, Comparator.comparingDouble(Army::getDefence));
        Collections.sort(defenceOrder2, Comparator.comparingDouble(Army::getDefence));

        // Sort characters based on health in ascending order
        Collections.sort(healthOrder1, Comparator.comparingDouble(Army::getHealth));
        Collections.sort(healthOrder2, Comparator.comparingDouble(Army::getHealth));

        int turns = 10;
        int currentTurn = 1;

        int numOfArmyC = 5;
        int numOfArmyO = 5;

        FileWriter writer = null;
        try {
            writer = new FileWriter("output.txt", true);
            System.out.println();
            System.out.println(challenger.getName() + " vs. " + opponent.getName());
            System.out.println();
            writer.write(challenger.getName() + " vs. " + opponent.getName() + "\n");
            writer.write("\n");
            writer.flush();

            while (currentTurn <= turns) {

                System.out.println("Turn: " + currentTurn + " " + challenger.getName());
                writer.write("Turn: " + currentTurn + " " + challenger.getName() + "\n");
                writer.flush();

                Army attacker = speedOrder1.get(speedOrder1.size() - 1);
                Army defender = defenceOrder2.get(0);

                if (attacker.getType() == "Highlander" && opponent.getHomeGround() == "Hillcrest") {
                    System.out.println("Bonus turn:"+opponent.getName());
                    if (attacker instanceof Healer) {
                        System.out.println(attacker.getName() + " heals " + healthOrder1.get(0).getName());
                        writer.write(attacker.getName() + " heals " + healthOrder1.get(0).getName() + "\n");
                        writer.flush();

                        double newHealth = healthOrder1.get(0).getHealth() + (0.1 * attacker.getAttack() * (0.2));
                        healthOrder1.get(0).setHealth(newHealth);
                        System.out.println(
                                healthOrder1.get(0).getName() + "'s health: " + healthOrder1.get(0).getHealth());
                        System.out.println();
                        writer.write(
                                healthOrder1.get(0).getName() + "'s health: " + healthOrder1.get(0).getHealth() + "\n");
                        System.out.println();
                        writer.flush();
                        Collections.sort(healthOrder1, Comparator.comparingDouble(Army::getHealth));
                    }

                    else {
                        System.out.println(attacker.getName() + " attacks " + defender.getName());
                        writer.write(attacker.getName() + " attacks " + defender.getName() + "\n");
                        writer.flush();
                        double newHealth = defender.getHealth()
                                - ((0.5 * attacker.getAttack() * (0.2)) - ((0.1) * defender.getDefence()));
                        defender.setHealth(newHealth);
                        System.out.print(defender.getName() + "'s health: " + defender.getHealth() + "  ");
                        System.out.println(attacker.getName() + "'s health: " + attacker.getHealth());
                        System.out.println();
                        writer.write(defender.getName() + "'s health: " + defender.getHealth() + "\t"
                                + attacker.getName() + "'s health: " + attacker.getHealth() + "\n");
                        writer.flush();

                        if (defender.getHealth() <= 0) {
                            System.out.println();
                            System.out.println(defender.getName() + " died!");
                            System.out.println();
                            writer.write(defender.getName() + " died!" + "\n");
                            writer.flush();
                            numOfArmyO--;

                            if (numOfArmyO == 0) {
                                System.out.println(challenger.getName() + "won!");
                                writer.write(challenger.getName() + "won!" + "\n");
                                writer.flush();
                                won(challenger, opponent);
                                Menu(challenger, opponent, objectList, defaulPLayers, equipmentObjects);
                                break;
                            }

                            defenceOrder2.remove(defender);
                            healthOrder2.remove(defender);
                            speedOrder2.remove(defender);
                        }

                        Collections.sort(healthOrder2, Comparator.comparingDouble(Army::getHealth));
                    }

                }

                if (attacker instanceof Healer) {
                    double newHealth = healthOrder1.get(0).getHealth() + (0.1 * attacker.getAttack());
                    System.out.println(attacker.getName() + " heals " + healthOrder1.get(0).getName());
                    writer.write(attacker.getName() + " heals " + healthOrder1.get(0).getName() + "\n");
                    writer.flush();
                    healthOrder1.get(0).setHealth(newHealth);
                    System.out.println(healthOrder1.get(0).getName() + "'s health: " + healthOrder1.get(0).getHealth());
                    writer.write(
                            healthOrder1.get(0).getName() + "'s health: " + healthOrder1.get(0).getHealth() + "\n");
                    writer.flush();
                    Collections.sort(healthOrder1, Comparator.comparingDouble(Army::getHealth));
                }

                else {
                    System.out.println(attacker.getName() + " attacks " + defender.getName());
                    writer.write(attacker.getName() + " attacks " + defender.getName() + "\n");
                    writer.flush();

                    double newHealth = defender.getHealth()
                            - ((0.5 * attacker.getAttack()) - ((0.1) * defender.getDefence()));
                    defender.setHealth(newHealth);

                    System.out.print(defender.getName() + "'s health: " + defender.getHealth() + "  ");
                    System.out.println(attacker.getName() + "'s health: " + attacker.getHealth());

                    writer.write(defender.getName() + "'s health: " + defender.getHealth() + "\t" + attacker.getName()
                            + "'s health: " + attacker.getHealth() + "\n");
                    writer.flush();

                    if (defender.getHealth() <= 0) {
                        System.out.println();
                        System.out.println(defender.getName() + " died!");
                        System.out.println();
                        writer.write(defender.getName() + " died!" + "\n");
                        writer.flush();

                        numOfArmyO--;

                        if (numOfArmyO == 0) {
                            System.out.println(challenger.getName() + "won!");
                            writer.write(challenger.getName() + "won!" + "\n");
                            writer.flush();
                            won(challenger, opponent);
                            Menu(challenger, opponent, objectList, defaulPLayers, equipmentObjects);
                            break;
                        }

                        defenceOrder2.remove(defender);
                        healthOrder2.remove(defender);
                        speedOrder2.remove(defender);
                    }

                    Collections.sort(healthOrder2, Comparator.comparingDouble(Army::getHealth));

                }

                System.out.println("Turn: " + currentTurn + " " + opponent.getName());
                writer.write("Turn: " + currentTurn + " " + opponent.getName() + "\n");
                writer.flush();

                attacker = speedOrder2.get(speedOrder2.size() - 1);
                defender = defenceOrder1.get(0);

                if (attacker.getType() == "Highlander" && opponent.getHomeGround() == "Hillcrest") {
                    System.out.println("Bonus turn:"+opponent.getName());
                    if (attacker instanceof Healer) {
                        double newHealth = healthOrder2.get(0).getHealth() + (0.1 * attacker.getAttack() * (0.2));
                        System.out.println(attacker.getName() + " heals " + healthOrder2.get(0).getName());
                        writer.write(attacker.getName() + " heals " + healthOrder2.get(0).getName() + "\n");
                        writer.flush();
                        healthOrder2.get(0).setHealth(newHealth);
                        Collections.sort(healthOrder2, Comparator.comparingDouble(Army::getHealth));
                    }

                    else {
                        System.out.println(attacker.getName() + " attacks " + defender.getName());
                        writer.write(attacker.getName() + " attacks " + defender.getName() + "\n");
                        writer.flush();

                        double newHealth = defender.getHealth()
                                - ((0.5 * attacker.getAttack() * (0.2)) - ((0.1) * defender.getDefence()));
                        defender.setHealth(newHealth);
                        System.out.print(defender.getName() + "'s health: " + defender.getHealth() + "  ");
                        System.out.println(attacker.getName() + "'s health: " + attacker.getHealth());

                        writer.write(defender.getName() + "'s health: " + defender.getHealth() + "\t"
                                + attacker.getName() + "'s health: " + attacker.getHealth() + "\n");
                        writer.flush();

                        if (defender.getHealth() <= 0) {
                            System.err.println();
                            System.out.println(defender.getName() + " died!");
                            writer.write(defender.getName() + " died!" + "\n");
                            writer.flush();
                            numOfArmyC--;

                            if (numOfArmyC == 0) {
                                System.out.println(opponent.getName() + "won!");
                                writer.write(opponent.getName() + "won!" + "\n");
                                writer.flush();

                                won(opponent, challenger);
                                Menu(challenger, opponent, objectList, defaulPLayers, equipmentObjects);
                                break;
                            }

                            defenceOrder1.remove(defender);
                            healthOrder1.remove(defender);
                            speedOrder1.remove(defender);
                        }

                        Collections.sort(healthOrder1, Comparator.comparingDouble(Army::getHealth));
                    }
                }

                if (attacker instanceof Healer) {
                    double newHealth = healthOrder2.get(0).getHealth() + (0.1 * attacker.getAttack());
                    System.out.println(attacker.getName() + " heals " + healthOrder2.get(0).getName());
                    writer.write(attacker.getName() + " heals " + healthOrder2.get(0).getName() + "\n");
                    writer.flush();

                    healthOrder2.get(0).setHealth(newHealth);
                    System.out.println(healthOrder1.get(0).getName() + "'s health: " + healthOrder1.get(0).getHealth());
                    writer.write(
                            healthOrder1.get(0).getName() + "'s health: " + healthOrder1.get(0).getHealth() + "\n");
                    writer.flush();

                    Collections.sort(healthOrder2, Comparator.comparingDouble(Army::getHealth));
                }

                else {
                    System.out.println(attacker.getName() + " attacks " + defender.getName());
                    writer.write(attacker.getName() + " attacks " + defender.getName() + "\n");
                    writer.flush();

                    double newHealth = defender.getHealth()
                            - ((0.5 * attacker.getAttack()) - ((0.1) * defender.getDefence()));
                    defender.setHealth(newHealth);
                    System.out.print(defender.getName() + "'s health: " + defender.getHealth() + "  ");
                    System.out.println(attacker.getName() + "'s health: " + attacker.getHealth());

                    writer.write(defender.getName() + "'s health: " + defender.getHealth() + "\t" + attacker.getName()
                            + "'s health: " + attacker.getHealth() + "\n");
                    writer.flush();

                    if (defender.getHealth() <= 0) {
                        System.out.println();
                        System.out.println(defender.getName() + " died!");
                        writer.write(defender.getName() + " died!" + "\n");
                        writer.flush();
                        numOfArmyC--;

                        if (numOfArmyC == 0) {
                            System.out.println(opponent.getName() + "won!");
                            writer.write(opponent.getName() + "won!" + "\n");
                            writer.flush();
                            won(opponent, challenger);
                            Menu(challenger, opponent, objectList, defaulPLayers, equipmentObjects);
                            break;
                        }

                        defenceOrder1.remove(defender);
                        healthOrder1.remove(defender);
                        speedOrder1.remove(defender);
                    }

                    Collections.sort(healthOrder1, Comparator.comparingDouble(Army::getHealth));

                }

                currentTurn++;
                System.out.println();
                System.out.println("-----------------------------------------------------");
                System.out.println("-----------------------------------------------------");
                System.out.println();

            }

            if (currentTurn == 11) {
                System.out.println("Draw");
                System.out.println();
                writer.write("Draw" + "\n");
                writer.flush();
                Menu(challenger, opponent, objectList, defaulPLayers, equipmentObjects);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void won(User winner, User loser) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("output.txt", true);
            double coins = loser.getGoldCoins() * (0.1);
            int wholeCoins = (int) Math.round(coins);
            winner.setGoldCoins(wholeCoins + winner.getGoldCoins());
            loser.setGoldCoins(loser.getGoldCoins() - wholeCoins);

            winner.setXP(winner.getXP() + 1);

            System.out.println(winner.getName() + " XP: " + winner.getXP() + "\t gold coins: " + winner.getGoldCoins());
            writer.write(winner.getName() + " XP: " + winner.getXP() + "\t gold coins: " + winner.getGoldCoins()+ "\n");
            writer.flush();

            System.out.println(loser.getName() + " XP: " + loser.getXP() + "\t gold coins: " + loser.getGoldCoins());
            writer.write(loser.getName() + " XP: " + loser.getXP() + "\t gold coins: " + loser.getGoldCoins()+ "\n");
            writer.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void selectHomeland(User opponent, User challenger) {

        ArrayList<Army> armylist = new ArrayList<>();
        armylist.addAll(opponent.getArmy());
        armylist.addAll(challenger.getArmy());

        switch (opponent.getHomeGround()) {
            case "Hillcrest":
                handleHillcrestBattle(armylist);
                break;
            case "Marshland":
                handleMarshlandBattle(armylist);
                break;
            case "Desert":
                handleDesertBattle(armylist);
                break;
            case "Arcane":
                handleArcaneBattle(armylist);
                break;
        }
    }

    public static void handleHillcrestBattle(ArrayList<Army> armyList) {
        for (Army character : armyList) {
            if (character.getType() == "Highlanders") {
                character.setAttack(character.getAttack() + 1);
                character.setDefence(character.getDefence() + 1);
            } else if (character.getType() == "Marshlanders" || character.getType() == "Sunchildren") {
                character.setSpeed(character.getSpeed() - 1);
            }
        }
    }

    public static void handleMarshlandBattle(ArrayList<Army> armyList) {
        for (Army character : armyList) {
            if (character.getType() == "Marshlanders") {
                character.setDefence(character.getDefence() + 2);
            } else if (character.getType() == "Sunchildren") {
                character.setAttack(character.getAttack() - 1);
            } else if (character.getType() == "Mystics") {
                character.setSpeed(character.getSpeed() - 1);
            }
        }
    }

    public static void handleDesertBattle(ArrayList<Army> armyList) {
        for (Army character : armyList) {
            if (character.getType() == "Marshlanders") {
                character.setHealth(character.getHealth() - 1);
            } else if (character.getType() == "Sunchildren") {
                character.setAttack(character.getAttack() + 1);
            }
        }
    }

    public static void handleArcaneBattle(ArrayList<Army> armyList) {
        for (Army character : armyList) {
            if (character.getType() == "Mystics") {
                character.setAttack(character.getAttack() + 2);
                character.setHealth(character.getHealth() * 1.1);
            } else if (character.getType() == "Marshlanders" || character.getType() == "Highlanders") {
                character.setSpeed(character.getSpeed() - 1);
                character.setDefence(character.getDefence() - 1);
            }
        }
    }

}