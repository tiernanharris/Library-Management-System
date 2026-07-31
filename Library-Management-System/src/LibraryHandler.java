import java.util.ArrayList;
import uulib.OutputFile;
import uulib.InputFile;
import java.io.File;
public class LibraryHandler {
    private ArrayList<BookRecord> books = new ArrayList<>();

    public void addBook(String title) {
        books.add(new BookRecord(title));
    }

    public int findBook(String title) {
        for (int i = 0; i < books.size(); i++) {                        //linear search
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;                                                       // prevents crashing or an exception
    }

    public void borrowBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.get(index).incrementBorrow();
        }
    }

    public void showPopularityReport() {
        if (books.isEmpty()) return;
        ArrayList<BookRecord> sortedCopy = new ArrayList<>(books);
        //selection sort by popularity
        for (int i = 0; i < sortedCopy.size() - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < sortedCopy.size(); j++) {
                if (sortedCopy.get(j).getBorrowCount() > sortedCopy.get(maxIdx).getBorrowCount()) {
                    maxIdx = j;
                }
            }
            BookRecord temp = sortedCopy.get(i);                        //swap
            sortedCopy.set(i, sortedCopy.get(maxIdx));
            sortedCopy.set(maxIdx, temp);
        }
        for (BookRecord br : sortedCopy) {
            System.out.println("---Popularity Report---");
            System.out.println(br.getDetails());
        }
    }

    public void saveToFile(String filename) {
        OutputFile out = new OutputFile(filename);
        out.println(books.size());

        for (BookRecord br : books) {
            out.println(br.getTitle().replace(" ", "_"));
            out.println(br.getBorrowCount());
        }
        out.close();
    }

    public void loadFromFile(String filename) {
        File f = new File(filename);
                                                                     // loads output data from filename
        if (f.exists()) {
            InputFile in = new InputFile(filename);
            int count = in.readInt();
            for (int i = 0; i < count; i++) {
                String title = in.readString().replace("_", " ");
                int borrows = in.readInt();
                BookRecord temp = new BookRecord(title);
                for (int j = 0; j < borrows; j++) {
                    temp.incrementBorrow();

                }
                books.add(temp);
            }
            in.close();
        }
    }
}

