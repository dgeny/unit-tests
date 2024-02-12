package homework;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    public BookInfo getBookInfoByISBN(BookRepository repo, String isbn){
        BookInfo bi = repo.searchByISBN(isbn);
        if (bi != null){
            return bi;
        }
        else{
            System.out.print("Book not found");
            return null;
        }
    }

    public List<BookInfo> getBooksByName(BookRepository repo, String name){
        ArrayList<String> bi = repo.searchByName(name);
        if (bi != null){
            List<BookInfo> detailed = new ArrayList<BookInfo>();
            for (String s : bi) {
                BookInfo found = this.getBookInfoByISBN(repo, s);
                if (found != null) {
                    detailed.add(found);
                }
            }
            return detailed;
        }
        else{
            return null;
        }
    }
}
