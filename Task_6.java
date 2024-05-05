import java.util.*;

public class PhoneBook {
    private static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean inter = true;
        while (inter) {
            System.out.println("Select a menu option:\n");
            System.out.println("1. View recordings");
            System.out.println("2. Add an entry");
            System.out.println("3. Exit");
            System.out.print("\nSelect an action: ");
            int menu = sc.nextInt();
            sc.nextLine();
            
            switch (menu) {
                case 1:
                    displayContact();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                inter = false;
                    break;
                default:
                    System.out.println("\n ERROR! Incorrect input!\n");
            }
        }
        System.out.println("\nThe work of the program is completed!\n");
    }

    private static void displayContact() {
        ArrayList<Map.Entry<String, ArrayList<String>>> sortInList = new ArrayList<>(phoneBook.entrySet());
        sortInList.sort((input1, input2) -> Integer.compare(input2.getValue().size(), input1.getValue().size()));
        System.out.println("The entries in the phone book are sorted!:\n");
            for (Map.Entry<String, ArrayList<String>> input : sortInList) {
                System.out.println(input.getKey() + ": " + input.getValue());
            }
    }

    private static void addContact() {
        System.out.print("Enter a name: ");
        String name = sc.nextLine();
        System.out.print("Enter the phone number: ");
        String phoneNumber = sc.nextLine();
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
        System.out.println("\nAn entry has been added: " + name + ": " + phoneNumber);
    }
}
