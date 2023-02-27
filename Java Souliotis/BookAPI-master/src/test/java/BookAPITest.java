
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import gr.unipi.bookapi.BookApi;
import gr.unipi.bookapi.exception.BookAPIException;
import gr.unipi.bookapi.model.BookInfo;
import gr.unipi.bookapi.services.BookAPIService;
import gr.unipi.bookapi.services.BookApiServiceOptionEnum;

public class BookAPITest {

    @Test
    public void testSearchAPI() throws BookAPIException {
        final BookAPIService bookApiService = BookApi.getBookDBService();
        final List<BookInfo> results = bookApiService.searchBooks("Bible");
        Assert.assertFalse(results.isEmpty());
        results.forEach(System.out::println);
    }

    @Test
    public void testSearchBooks() throws BookAPIException {
        final BookAPIService bookApiService = BookApi.getBookDBService();
        List<BookInfo> bookInfoList = bookApiService.searchBooks("Harry Potter");
        assertNotNull(bookInfoList);
        assertTrue(bookInfoList.size() > 0);
    }

    @Test
    public void testSearchBooksByTitle() throws BookAPIException {
        final BookAPIService bookApiService = BookApi.getBookDBService();
        List<BookInfo> bookInfoList = bookApiService.searchBooksByTitle("", "", "The Lord of the Rings",
                BookApiServiceOptionEnum.NONE, -1, -1);
        assertNotNull(bookInfoList);
        assertTrue(bookInfoList.size() > 0);
    }

    @Test
    public void testSearchBooksByAuthor() throws BookAPIException {
        final BookAPIService bookApiService = BookApi.getBookDBService();
        List<BookInfo> bookInfoList = bookApiService.searchBooksByAuthor("", "", "J.K. Rowling",
                BookApiServiceOptionEnum.NONE, -1, -1);
        assertNotNull(bookInfoList);
        assertTrue(bookInfoList.size() > 0);
    }

}
