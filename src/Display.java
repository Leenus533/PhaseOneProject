import java.util.Scanner;

public class Display {

    boolean mainState = true;
    String[] mainOptions = {"1. Retrieve File Names", "2. Business-level operations", "3. Close application"};
    String[] fileOptions ={"1. Add a file","2. Delete a file","3. Search a file", "4. Return to Main Menu"};
    public void listOptions(){
        System.out.println("-------------------------------------");
        System.out.println(this.mainState ? "         Main Menu" : "        Business-level Operations");
        System.out.println("-------------------------------------");
        System.out.println("Select an Option:");

        for (String s : this.mainState ? mainOptions : fileOptions ){
                System.out.println(s);
        }
        getUserInput();
    }
    public void getUserInput(){
        Scanner scanner = new Scanner(System.in);
        int input;
        try {
            input = scanner.nextInt();
            if (this.mainState) {
                switch (input) {
                    case 1 -> Directory.listFiles();
                    case 2 -> this.mainState = false;
                    case 3 -> {
                        System.out.println("----------------------------");
                        System.out.println("Thanks for using/testing the application");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid Options");
                }
            } else {
                switch (input) {
                    case 1 -> addNewFile();
                    case 2 -> deleteFile();
                    case 3 -> findFile();
                    case 4 -> this.mainState = true;
                    default -> System.out.println("Invalid Options");
                }
            }
        }catch (Exception e){
            System.out.println("Input Should Only Contain Numbers");
        }
        listOptions();
    }

    public String inputString(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void addNewFile(){
        System.out.println("Enter the name of the file you would like to add:");
        String fileName = inputString();
        Directory.addFile(fileName);
    }
    public  void deleteFile(){
        System.out.println("Enter the name of the file you would like to delete:");
        String fileName = inputString();
        Directory.deleteFile(fileName);
    }
    public  void findFile(){
        System.out.println("Enter the name of the file you would like to search for:");
        String fileName = inputString();
        Directory.findFile(fileName);
    }

}
