import java.util.Scanner;

public class ContactUI {
    private ContactManager contactManager;
    private Scanner scanner;

    public ContactUI() {
        this.contactManager = new ContactManager();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Contact Management System");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts");
        System.out.println("3. Search Contact by Name");
        System.out.println("4. Edit Contact");
        System.out.println("5. Delete Contact");
        System.out.println("6. Exit");
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    listAllContacts();
                    break;
                case 3:
                    searchContactByName();
                    break;
                case 4:
                    editContact();
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

    private void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        long phoneNumber = scanner.nextLong();
        scanner.nextLine(); 
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email, address);
        contactManager.addContact(contact);
        System.out.println("Contact added successfully!");
    }

    private void listAllContacts() {
        System.out.println("All Contacts:");
        for (Contact contact : contactManager.getAllContacts()) {
            System.out.println(contact);
        }
    }

    private void searchContactByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        Contact contact = contactManager.findContactByName(name);
        if (contact != null) {
            System.out.println("Contact found:");
            System.out.println(contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private void editContact() {
        System.out.print("Enter name of contact to edit: ");
        String name = scanner.nextLine();
        Contact contact = contactManager.findContactByName(name);
        if (contact != null) {
            System.out.println("Current details:");
            System.out.println(contact);
            System.out.println("Enter new details:");
            addContact(); 
            contactManager.updateContact(name, contact);
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private void deleteContact() {
        System.out.print("Enter name of contact to delete: ");
        String name = scanner.nextLine();
        boolean deleted = contactManager.deleteContact(name);
        if (deleted) {
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public static void main(String[] args) {
        ContactUI contactUI = new ContactUI();
        contactUI.run();
    }
}
