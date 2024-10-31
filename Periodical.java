public class Periodical extends LibraryItem {
    private int issueNumber;
    private String publicationDate;
    private String format;
    
    public Periodical(int id, String title, Author author, String ISBN, String publisher, int numberOfCopies, int issueNumber, String publicationDate, String format) {
        super(id, title, author, ISBN, publisher, numberOfCopies);
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
        this.format = format;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getPubDate() {
        return publicationDate;
    }

    public void setPubDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String getType() {
        return "Periodical";
    }
    
}
