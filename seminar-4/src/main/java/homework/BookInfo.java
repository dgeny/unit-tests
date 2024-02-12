package homework;

public class BookInfo {
    public String name;
    public String ISBN;

    public BookInfo(String isbn, String someBook) {
        this.ISBN = isbn;
        this.name = someBook;
    }

    @Override
    public boolean equals(Object obj) {

        return obj.getClass() == this.getClass() &&
                (((BookInfo)obj).ISBN.equals(this.ISBN) &&
                        ((BookInfo)obj).name.equals(this.name));
    }
}
