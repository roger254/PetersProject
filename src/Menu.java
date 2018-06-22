import java.time.*;
import java.util.*;

public class Menu {
    private final Scanner IN = new Scanner(System.in);
    private ArrayList<Medicine> medArray = new ArrayList<>();

    public Menu(String access) {
        //menu loop
        while (true) {
            String welcomeNote = "Welcome to my program.\nType 1 to show Options and 'exit' to exit the program: ";
            System.out.print(welcomeNote);
            System.out.println();

            String input = IN.next(); // input for showing menu options or exit

            if (input.equals("exit")) //close program if exit is selected
            {
                new Login().welcomePage();
            }
            showOption(access); //show options as per access level
        }
    }

    private void showOption(String access) {
        System.out.print("Welcome to the programs menu,\ntype 'U to update the inventory 'D' to display the inventory \nand 'exit' to Exit from the Menu: ");
        String input = IN.next().toUpperCase();

        while (!input.equals("EXIT")) {
            if (input.equals("U")) { //update inventory
                if (access.equals("NONE")) //check is user has access to update
                {
                    System.out.println("You do not have the required permission to update the inventory");
                    break;
                }else {
                    updateInventory();
                    break;
                }
            } else if (input.equals("D")) {
                if (medArray.size() < 1) {
                    System.out.println("There is no information to display, add Items!");
                    break;
                }
                displayItems();
                break;
            }

        }
    }

    private void updateInventory() {
        System.out.println("Welcome to the inventory update.\n");
        boolean checker = true;
        while (checker) {
            System.out.print("Enter name of the medicine product: ");
            String medicineName = IN.next();
            if (medicineName.equals("exit")) break;

            System.out.print("Enter the medicine price: ");
            double price = IN.nextDouble();

            System.out.print("Enter the medicine quantity: ");
            int quantity = IN.nextInt();

            LocalDate date = LocalDate.now();
            int year = date.getYear();
            int month = date.getMonthValue();
            int day = date.getDayOfMonth();
            medArray.add(new Medicine(medicineName, price, quantity, year, month, day));

            System.out.println("Press 'a' to add an item an type 'exit' to Exit to the Menu");
            String input = IN.next().toUpperCase();
            if (input.equals("EXIT")) checker = false;
            else if (input.equals("A")) checker = true;
        }
    }

    private void displayItems() {
        for (Medicine m : medArray)
            System.out.println("Name=" + m.getName() + " Price=" + m.getPrice() + " Quantity=" + m.getQuantity() + " OrderId=" + m.getOrderId() + " Entry date =" + m.getEntryDate());
        System.out.println();
    }
}
