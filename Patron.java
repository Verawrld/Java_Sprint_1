import java.util.ArrayList;
import java.util.List;

public abstract class Patron {
    private int patronid;
    private String name;
    private String address;
    private String phoneNum;
    private List<LibraryItem> borrowedItems;

    public Patron(int patronid, String name, String address, String phoneNum) {
            this.patronid = patronid;
            this.name = name;
            this.address = address;
            this.phoneNum = phoneNum;
            this.borrowedItems = new ArrayList<>();
        }

    public int getId() {
        return patronid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public boolean returnItem(LibraryItem item) {
        if (borrowedItems.remove(item)) {
            return true;
        } else {
            return false;
        }
    }

    public void borrowItem(LibraryItem item) {
        if (item.isAvailable() && canBorrow()) {
            item.setAvailable(false);
            borrowedItems.add(item);
            System.out.println("Item borrowed Completed");
        } else {
            System.out.println("Item is not available");
        }
    }

    public abstract boolean canBorrow();
}
