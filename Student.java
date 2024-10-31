public class Student extends Patron { 
    private int studentID;

    public Student(int id, String name, String address, String phoneNumber, int studentID) {
        super(id, name, address, phoneNumber);
        this.studentID = studentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public boolean canBorrow() {
        return getBorrowedItems().size() < 5;
    }
    
}
