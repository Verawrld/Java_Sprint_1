import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Patron> patrons = new ArrayList<>();

    public Library () {
        this.items = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }


    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public void editPatron(int index, Patron newPatron) {
        if (index >= 0 && index < patrons.size()) {
            patrons.set(index, newPatron);
        } else {
            System.out.println("Patron not found.");
        }
    }

    public void deletePatron(int index) {
        if (index >= 0 && index < patrons.size()) {
            patrons.remove(index);
        } else {
            System.out.println("Patron not found.");
        }
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public LibraryItem getItemById(int id) {
        for (LibraryItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    
    public List<LibraryItem> searchItems(String query) {
        List<LibraryItem> results = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    item.getAuthor().getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    public void borrowItem(Patron patron, LibraryItem item) {
        if (item.isAvailable() && patron.canBorrow()) {
            patron.borrowItem(item);
        }
    }
    
    public void returnItem(Patron patron, LibraryItem item) {
        patron.returnItem(item);
        item.setAvailable(true);
        System.out.println("Item return completed");
    }

    public Patron getPatronById(int patronId){
        for (Patron patron : patrons) {
            if (patron instanceof Student) {
                Student student = (Student) patron;
                if (student.getStudentID() == patronId) {
                    return student;
                } 
            }
        }
        return null;
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    public void editAuthor(int index, Author newAuthor){
        if (index >= 0 && index < authors.size()) {
            authors.set(index, newAuthor);
        }else{
            System.out.println("Author Not Found");
        }
    }

    public void deleteAuthor(int index) {
        if (index >= 0 && index < authors.size()) {
            authors.remove(index);
        } else {
            System.out.println("Author not found.");
        }
    }

    public List<Author> getAuthors() {
        return authors;
    }
}