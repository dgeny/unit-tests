package homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository repo;

    BookService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new BookService();
    }

    @Test
    void getBookInfoByISBN() {
        String isbn = "SomeTestISBN";
        when(repo.searchByISBN(isbn)).thenReturn(new BookInfo(isbn, "Some Book"));
        BookInfo bookinfo = service.getBookInfoByISBN(repo, isbn);
        assertEquals(new BookInfo(isbn, "Some Book"), bookinfo);
        assertNull(service.getBookInfoByISBN(repo,"WrongISBN"));
        verify(repo, times(1)).searchByISBN(isbn);
    }

    @Test
    void getBooksByName() {
        String mask = "SuperPopularName";
        String isbn = "SomeTestISBN";
        ArrayList<String> arrVal = new ArrayList<>();
        arrVal.add(isbn);
        arrVal.add(isbn);
        when(repo.searchByName(mask)).thenReturn(arrVal);
        when(repo.searchByISBN(isbn)).thenReturn(new BookInfo(isbn, "Some Book"));
        List<BookInfo> result = service.getBooksByName(repo, mask);
        assertArrayEquals(new BookInfo []{
                new BookInfo(isbn, "Some Book"),
                new BookInfo(isbn, "Some Book")},
        result.toArray());

        verify(repo, times(2)).searchByISBN("SomeTestISBN");
    }

    @Test
    void getBooksByNameNotFound() {
        String mask = "SuperPopularName";
        when(repo.searchByName(mask)).thenReturn(null);
        assertNull(service.getBooksByName(repo, mask));
        verify(repo, times(0)).searchByISBN("SomeTestISBN");
    }
}