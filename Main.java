import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + "\t" + phone + "\t" + email;
    }
}

public class Main {
    static LinkedList<Contact> newList = new LinkedList<Contact>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char choice;

        do {
            System.out.println("#############################################");
            System.out.println("\n(A)dd \n(D)elete \n(E)mail Search \n(P)rint List \n(S)earch \n(Q)uit");
            System.out.println("\n#############################################");
            System.out.print("Select option: ");
            choice = input.next().charAt(0);
            input.nextLine();

            switch (choice) {
                case 'A' | 'a':
                    addContact(input);
                    break;
                case 'D' | 'd':
                    deleteContact(input);
                    break;
                case 'E' | 'e':
                    emailSearch(input);
                    break;
                case 'P' | 'p':
                    printList();
                    break;
                case 'S' | 's':
                    search(input);
                    break;
                case 'Q':
                    System.out.println("Program Terminating");
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        } while (choice != 'Q');

        input.close();
    }

    public static void addContact(Scanner input) {
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter phone number: ");
        String phone = input.nextLine();
        System.out.print("Enter email: ");
        String email = input.nextLine();

        Contact contact = new Contact(name, phone, email);
        newList.add(contact);
        System.out.println("Contact added.");
    }

    public static void deleteContact(Scanner input) {
        System.out.print("Enter name to delete: ");
        String name = input.nextLine();

        boolean removed = false;
        Iterator<Contact> iter = newList.iterator();
        while (iter.hasNext()) {
            Contact contact = iter.next();
            if (contact.name.equals(name)) {
                iter.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Contact has been deleted.");
        } else {
            System.out.println("Contact are not found.");
        }
    }

    public static void emailSearch(Scanner input) {
        System.out.print("Search email: ");
        String email = input.nextLine();

        boolean found = false;
        for (Contact contact : newList) {
            if (contact.email.equals(email)) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact are not found.");
        }
    }

    public static void printList() {
        if (newList.size() == 0) {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("Name\tPhone\tEmail");
            for (Contact contact : newList) {
                System.out.println(contact);
            }
        }
    }

    public static void search(Scanner input) {
        System.out.print("Search name: ");
        String name = input.nextLine();

        boolean found = false;
        for (Contact contact : newList) {
            if (contact.name.equals(name)) {
                System.out.println(contact);
                found = true;
                break;
            }
        }

        if (!found) ;
    }
}