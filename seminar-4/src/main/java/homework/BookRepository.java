package homework;

import java.util.ArrayList;

public interface BookRepository {
    public BookInfo searchByISBN(String ISBN);

    ArrayList<String> searchByName(String name);
}
