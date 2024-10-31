import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;



public class Demo {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws ParseException {
        Library library = new Library();

        Author author1 = new Author("John Doe", new Date(1990, 1, 1));
        Author author2 = new Author("Jane Doe", new Date(1995, 1, 1));
        Author author3 = new Author("John Smith", new Date(1990, 1, 1));
        Author author4 = new Author("Jane Smith", new Date(1995, 1, 1));
        Author author5 = new Author("John Johnson", new Date(1990, 1, 1));

        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addAuthor(author3);
        library.addAuthor(author4);
        library.addAuthor(author5);

        Book book1 = new Book(1, "The Great Figher", author1, "123456", "Dream", 5, "printed");
        Book book2 = new Book(2, "From The Great Abys", author2, "987654", "BigBooks", 3, "pritned");
        Book book3 = new Book(3, "Into The Storm", author3, "145678", "Bob & Joe", 4, "electronic");
        Book book4 = new Book(4, "Soda and Pop", author4, "567890", "Dream", 5, "audio");
        Book book5 = new Book(5, "Ninja War", author5, "678342", "HardCoreQuest", 2, "printed");

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(book4);
        library.addItem(book5);
        
        Periodical periodical1 = new Periodical(6, "Kung Fu", author1, "456784", "Dream", 5, 123 ,"2020-04-23", "printed");
        Periodical periodical2 = new Periodical(7, "Karate", author2, "345645", "BigBooks", 3, 456 , "2019-04-12", "electronic" );
        Periodical periodical3 = new Periodical(8, "Judo", author3, "295043", "Bob & Joe", 4, 156, "2020-09-13",  "electronic");
        Periodical periodical4 = new Periodical(9, "Aikido", author4, "776343", "Dream", 5, 46, "2021-01-01", "printed");

        library.addItem(periodical1);
        library.addItem(periodical2);
        library.addItem(periodical3);
        library.addItem(periodical4);

        Student student1 = new Student(1,"John Stark", "1234 Main St", "123-456-7890", 1);
        Student student2 = new Student(2, "Josh Snow", "34 Wings Point Rd", "123-653-2785", 2);

        library.addPatron(student1);
        library.addPatron(student2);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n Library Management System");
            System.out.println("1. Add Items");
            System.out.println("2. Search Items");
            System.out.println("3. Borrow Items");
            System.out.println("4. Return Items");
            System.out.println("5. Add Author");
            System.out.println("6. Edit Author");
            System.out.println("7. Delete Author");
            System.out.println("8. Add Patron");
            System.out.println("9. Edit Patron");
            System.out.println("10. Delete Patron");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item ID: ");
                    int itemId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter item title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter author name: ");
                    String authorName = scanner.nextLine();
                    System.out.println("Enter authors birthday(dd/MM/yyyy): ");
                    String authorBirthday = scanner.nextLine();
                    Date authorBirthdate = new SimpleDateFormat("dd/MM/yyyy").parse(authorBirthday);
                    Author newAuthor = new Author(authorName, authorBirthdate);
                    System.out.println("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.println("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.println("Enter number of copies: ");
                    int numberOfCopies = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter format (printed, electronic, audio): ");
                    String format = scanner.nextLine();

                    Book book = new Book(itemId, title, newAuthor, isbn, publisher, numberOfCopies, format);
                    library.addItem(book);
                    break;
                case 2:
                    // Search for items by title or author
                    System.out.print("Enter search query: ");
                    String query = scanner.next().toLowerCase();
                    List<LibraryItem> results = library.searchItems(query);
                    if (results.isEmpty()) {
                        System.out.println("No items found. Make sure to check spelling");
                    } else {
                        System.out.println("Search Results:");
                        for (LibraryItem item : results) {
                            System.out.println("ID: " + item.getId());
                            System.out.println("Title: " + item.getTitle());
                            System.out.println("Author: " + item.getAuthor().getName());
                            System.out.println("ISBN: " + item.getISBN());
                            System.out.println("Publisher: " + item.getPublisher());
                            System.out.println("Number of Copies: " + item.getNumberOfCopies());
                            System.out.println("Available: " + item.isAvailable());
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    // Borrow an item
                    System.out.print("Enter item ID: ");
                    int itemIdToBorrow = scanner.nextInt();
                    System.out.print("Enter patron ID: ");
                    int patronId = scanner.nextInt();
                    LibraryItem itemToBorrow = library.getItemById(itemIdToBorrow);
                    Patron patron = library.getPatronById(patronId);
                    library.borrowItem(patron, itemToBorrow);
                    break;
                case 4:
                    // Return an item
                    System.out.print("Enter item ID: ");
                    int itemIdToReturn = scanner.nextInt();
                    System.out.print("Enter patron ID: ");
                    int returnPatronId = scanner.nextInt();
                    LibraryItem itemToReturn = library.getItemById(itemIdToReturn);
                    Patron returnPatron = library.getPatronById(returnPatronId);
                    library.returnItem(returnPatron, itemToReturn);
                    break;
                case 5:
                // add Author
                    System.out.print("Enter Author name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Author birthday(dd/MM/yyyy): ");
                    String birthday = scanner.nextLine();
                    Date birthdate = new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
                    Author author = new Author(name, birthdate);
                    library.addAuthor(author);
                    break;
                case 6:
                    // Edit Author
                    System.out.print("Enter Author ID: ");
                    int authorId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new author name: ");
                    String newAuthorName = scanner.nextLine();
                    System.out.println("Enter new author's birthday (dd/MM/yyyy): ");
                    String newAuthorBirthday = scanner.nextLine();
                    Date newAuthorBirthdate = new SimpleDateFormat("dd/MM/yyyy").parse(newAuthorBirthday);
                    Author editedAuthor = new Author(newAuthorName, newAuthorBirthdate);
                    library.editAuthor(authorId, editedAuthor);
                    break;
                case 7:
                    // Delete Author
                    System.out.println("Enter author index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    library.deleteAuthor(deleteIndex);
                    break;
                case 8:
                    // Add Patron
                    System.out.print("Enter Patron name: ");
                    String patronName = scanner.nextLine();
                    System.out.print("Enter Patron address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Patron phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Patron ID: ");
                    int patronid = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Student newPatron = new Student(patronid, patronName, address, phoneNumber, patronid);
                    library.addPatron(newPatron);
                    break;
                case 9:
                    // Edit Patron
                    System.out.print("Enter Patron ID: ");
                    int editPatronId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new Patron name: ");
                    String newPatronName = scanner.nextLine();
                    System.out.print("Enter new Patron address: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Enter new Patron phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    Patron editedPatron = new Student(editPatronId, newPatronName, newAddress, newPhoneNumber, editPatronId);
                    library.editPatron(editPatronId, editedPatron);
                    break;
                case 10:
                    // Delete Patron
                    System.out.print("Enter Patron ID to delete: ");
                    int deletePatronId = scanner.nextInt();
                    library.deletePatron(deletePatronId);
                    break;
                
                
                case 11:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 11);

        scanner.close();
    }
}