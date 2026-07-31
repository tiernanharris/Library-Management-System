public class BookRecord {
    private String title;
    private int borrowCount;

    public BookRecord(String title) {
        this.title = title;
        this.borrowCount = 0;
    }


    public void incrementBorrow() {
        borrowCount++;
    }

    public String getTitle() {
        return title;
    }

    public int getBorrowCount() {
        return borrowCount;
    }


    public String getDetails() {
        return "Title: " + title + " | Borrows: " + borrowCount;
    }
}
