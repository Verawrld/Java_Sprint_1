
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class LibraryTest {
    public static void main(String[] args) throws ParseException {
        Library library = new Library();
        loadSampleData(library);

        // Display all items in the library
        System.out.println("Library Items:");
        for (LibraryItem item : library.searchItems("")) {
            System.out.println("ID: " + item.getId());
            System.out.println("Title: " + item.getTitle());
            System.out.println("Author: " + item.getAuthor().getName());
            System.out.println("ISBN: " + item.getISBN());
            System.out.println("Publisher: " + item.getPublisher());
            System.out.println("Number of Copies: " + item.getNumberOfCopies());
            System.out.println("Available: " + item.isAvailable());
            System.out.println();
        }

        // Display all patrons in the library
        System.out.println("Library Patrons:");
        for (Patron patron : library.getPatrons()) {
            System.out.println("ID: " + patron.getId());
            System.out.println("Name: " + patron.getName());
            System.out.println("Address: " + patron.getAddress());
            System.out.println("Phone Number: " + patron.getPhoneNum());
            System.out.println();
        }

        // Borrow an item
        Patron patron = library.getPatronById(1);
        LibraryItem item = library.getItemById(1);
        library.borrowItem(patron, item);

        // Return an item
        library.returnItem(patron, item);
    }

    private static void loadSampleData(Library library) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Author author1 = new Author("John Doe", dateFormat.parse("01/01/1990"));
        Author author2 = new Author("Jane Doe", dateFormat.parse("01/01/1995"));
        Author author3 = new Author("John Smith", dateFormat.parse("01/01/1990"));
        Author author4 = new Author("Jane Smith", dateFormat.parse("01/01/1995"));
        Author author5 = new Author("John Johnson", dateFormat.parse("01/01/1990"));

        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addAuthor(author3);
        library.addAuthor(author4);
        library.addAuthor(author5);

        Book book1 = new Book(1, "The Great Fighter", author1, "123456", "Dream", 5, "printed");
        Book book2 = new Book(2, "From The Great Abyss", author2, "987654", "BigBooks", 3, "printed");
        Book book3 = new Book(3, "Into The Storm", author3, "145678", "Bob & Joe", 4, "electronic");
        Book book4 = new Book(4, "Soda and Pop", author4, "567890", "Dream", 5, "audio");
        Book book5 = new Book(5, "Ninja War", author5, "678342", "HardCoreQuest", 2, "printed");

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(book4);
        library.addItem(book5);

        Periodical periodical1 = new Periodical(6, "Kung Fu", author1, "456784", "Dream", 5, 123, "23/04/2020", "printed");
        Periodical periodical2 = new Periodical(7, "Karate", author2, "345645", "BigBooks", 3, 456, "12/04/2019", "electronic");
        Periodical periodical3 = new Periodical(8, "Judo", author3, "295043", "Bob & Joe", 4, 156, "13/09/2020", "electronic");
        Periodical periodical4 = new Periodical(9, "Aikido", author4, "776343", "Dream", 5, 46, "01/01/2021", "printed");

        library.addItem(periodical1);
        library.addItem(periodical2);
        library.addItem(periodical3);
        library.addItem(periodical4);

        Student student1 = new Student(1, "John Stark", "1234 Main St", "123-456-7890", 1);
        Student student2 = new Student(2, "Josh Snow", "34 Wings Point Rd", "123-653-2785", 2);

        library.addPatron(student1);
        library.addPatron(student2);
    }
}