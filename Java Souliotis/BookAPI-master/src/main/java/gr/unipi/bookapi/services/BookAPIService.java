package gr.unipi.bookapi.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;

import gr.unipi.bookapi.exception.BookAPIException;
import gr.unipi.bookapi.model.BookInfo;
import gr.unipi.bookapi.model.UserInfo;
import gr.unipi.bookapi.model.thebookdb.ErrorResponse;
import gr.unipi.bookapi.model.thebookdb.MainSearch;
import gr.unipi.bookapi.model.thebookdb.MainUserSearch;
import gr.unipi.bookapi.model.thebookdb.UserData;
import gr.unipi.bookapi.model.thebookdb.Item;

public class BookAPIService {

	private final String API_URL;
	private final String API_KEY;

	public BookAPIService(String API_URL, String API_KEY) {
		this.API_URL = API_URL;
		this.API_KEY = API_KEY;
	}

	// This gonna save all the searches
	private List<BookInfo> allSearches = new ArrayList<>();

	public List<BookInfo> getSearches(int num) {
		int size = allSearches.size();
		if (num > size) {
			System.out.printf("Only %d searches have been saved.%n", size);
			num = size;
		}
		int startIndex = Math.max(0, size - num);
		int endIndex = Math.min(size, startIndex + num);
		return allSearches.subList(startIndex, endIndex);
	}

	// get books matching the search query
	public List<BookInfo> searchBooks(String query) throws BookAPIException {
		MainSearch result = getAPIData("", "", "search", query, BookApiServiceOptionEnum.NONE, -1, -1, API_URL, API_KEY,
				MainSearch.class);
		List<BookInfo> bookInfoList = new ArrayList<>(result.getItems().size());
		for (Item item : result.getItems()) {
			bookInfoList.add(new BookInfo(item));
			allSearches.addAll(bookInfoList);
		}
		return bookInfoList;
	}

	// get books with matching text in title
	public List<BookInfo> searchBooksByTitle(String userId, String bookselfId, String title,
			BookApiServiceOptionEnum optinal,
			Integer startIndex,
			Integer maxResults) throws BookAPIException {
		MainSearch result = getAPIData(userId, bookselfId, "search", "intitle:" + title, optinal, startIndex,
				maxResults, API_URL,
				API_KEY,
				MainSearch.class);
		List<BookInfo> bookInfoList = new ArrayList<>(result.getItems().size());
		for (Item item : result.getItems()) {
			bookInfoList.add(new BookInfo(item));
			allSearches.addAll(bookInfoList);
		}
		return bookInfoList;
	}

	// get books with matching author
	public List<BookInfo> searchBooksByAuthor(String userId, String bookselfId, String author,
			BookApiServiceOptionEnum optinal,
			Integer startIndex,
			Integer maxResults) throws BookAPIException {
		MainSearch result = getAPIData(userId, bookselfId, "search", "inauthor:" + author, optinal, startIndex,
				maxResults, API_URL,
				API_KEY, MainSearch.class);
		List<BookInfo> bookInfoList = new ArrayList<>(result.getItems().size());
		for (Item item : result.getItems()) {
			bookInfoList.add(new BookInfo(item));
			allSearches.addAll(bookInfoList);
		}
		return bookInfoList;
	}

	// get books with matching publisher
	public List<BookInfo> searchBooksByPublisher(String userId, String publisher, String bookselfId,
			BookApiServiceOptionEnum optinal, Integer startIndex,
			Integer maxResults) throws BookAPIException {
		MainSearch result = getAPIData(userId, bookselfId, "search", "inpublisher:" + publisher, optinal, startIndex,
				maxResults,
				API_URL,
				API_KEY,
				MainSearch.class);
		List<BookInfo> bookInfoList = new ArrayList<>(result.getItems().size());
		for (Item item : result.getItems()) {
			bookInfoList.add(new BookInfo(item));
			allSearches.addAll(bookInfoList);
		}
		return bookInfoList;
	}

	// get books with matching subject
	public List<BookInfo> searchBooksBySubject(String userId, String bookselfId, String subject,
			BookApiServiceOptionEnum optinal,
			Integer startIndex,
			Integer maxResults)
			throws BookAPIException {
		MainSearch result = getAPIData(userId, bookselfId, "search", "subject:" + subject, optinal, startIndex,
				maxResults, API_URL,
				API_KEY, MainSearch.class);
		List<BookInfo> bookInfoList = new ArrayList<>(result.getItems().size());
		for (Item item : result.getItems()) {
			bookInfoList.add(new BookInfo(item));
			allSearches.addAll(bookInfoList);
		}
		return bookInfoList;
	}

	// get books with matching ISBN
	public List<BookInfo> searchBooksByISBN(String userId, String bookselfId, String isbn,
			BookApiServiceOptionEnum optinal,
			Integer startIndex,
			Integer maxResults) throws BookAPIException {
		MainSearch result = getAPIData(userId, bookselfId, "search", "isbn:" + isbn, optinal, startIndex, maxResults,
				API_URL,
				API_KEY,
				MainSearch.class);
		List<BookInfo> bookInfoList = new ArrayList<>(result.getItems().size());
		for (Item item : result.getItems()) {
			bookInfoList.add(new BookInfo(item));
			allSearches.addAll(bookInfoList);

		}
		return bookInfoList;
	}

	public String getBookInfo(String bookId) throws BookAPIException {
		Item result = getAPIData("", "", "volume", bookId, BookApiServiceOptionEnum.NONE, -1, -1, API_URL, API_KEY,
				Item.class);
		return result.toString();
	}

	public List<UserInfo> getUserBookshelves(String userId) throws BookAPIException {
		MainUserSearch result = getAPIData(userId, "", "", "", BookApiServiceOptionEnum.NONE, -1, -1, API_URL,
				API_KEY,
				MainUserSearch.class);
		List<UserInfo> userInfoList = new ArrayList<>(result.getItems().size());
		for (UserData item : result.getItems()) {
			userInfoList.add(new UserInfo(item));
		}
		return userInfoList;
	}

	public List<BookInfo> getBooksInBookshelf(String userId, String bookselfId) throws BookAPIException {
		MainSearch result = getAPIData(userId, bookselfId,
				"volume", "", BookApiServiceOptionEnum.NONE, -1, -1, API_URL,
				API_KEY,
				MainSearch.class);
		List<BookInfo> bookInBookInShelf = new ArrayList<>(result.getItems().size());
		for (Item item : result.getItems()) {
			bookInBookInShelf.add(new BookInfo(item));
		}
		return bookInBookInShelf;
	}

	/**
	 * Sends an HTTP GET request to the Google Books API and returns the response as
	 * an object of type T.
	 * 
	 * @param userId            - the user ID (optional)
	 * @param bookshelfId       - the specific bookshelfId of the user
	 * @param apiFunction       - the API function to call (e.g., "search")
	 * @param parameter         - the parameter to pass to the API function
	 * @param optionalParameter - an optional parameter to further refine the API
	 *                          call
	 * @param startIndex        - the start index for pagination (optional)
	 * @param maxResults        - the maximum number of results to return (optional)
	 * @param API_URL           - the base URL for the API
	 * @param API_KEY           - the API key to use (optional)
	 * @param responseType      - the type of object to return (e.g., Book.class)
	 * @return an object of type T representing the API response
	 * @throws BookAPIException if an error occurs while sending the API request or
	 *                          parsing the response
	 */
	private <T> T getAPIData(String userId, String bookselfId, String apiFunction, String parameter,
			BookApiServiceOptionEnum optionalParameter,
			Integer startIndex, Integer maxResults,
			String API_URL, String API_KEY,
			Class<T> responseType)
			throws BookAPIException {
		try {

			URIBuilder uriBuilder;
			uriBuilder = new URIBuilder(API_URL);
			uriBuilder.setPathSegments("books", "v1");
			if (userId != "") {
				uriBuilder.setPathSegments("books", "v1", "users", userId, "bookshelves");
				if (bookselfId != "") {
					if (apiFunction == "search") {
						uriBuilder.setPathSegments("books", "v1", "users", userId, "bookshelves",
								bookselfId, "volumes");
						uriBuilder.addParameter("q", parameter);
					} else if (apiFunction == "volume") {
						uriBuilder.setPathSegments("books", "v1", "users", userId, "bookshelves", bookselfId,
								"volumes");
					}
				}
			} else {
				uriBuilder.setPathSegments("books", "v1", "volumes");
				if (apiFunction == "search") {
					uriBuilder.addParameter("q", parameter);
				} else if (apiFunction == "volume") {
					uriBuilder.setPathSegments("books", "v1", "volumes", parameter);
				}
			}
			if (optionalParameter == BookApiServiceOptionEnum.FILTER_EBOOKS) {
				uriBuilder.addParameter("filter", "free-ebooks");
			} else if (optionalParameter == BookApiServiceOptionEnum.ORDER_BY_RELEVANCE) {
				uriBuilder.addParameter("orderBy", "relevance");
			} else if (optionalParameter == BookApiServiceOptionEnum.ORDE_BY_NEWEST) {
				uriBuilder.addParameter("orderBy", "newest");
			} else if (optionalParameter == BookApiServiceOptionEnum.PROJECTION_FULL) {
				uriBuilder.addParameter("projection", "full");
			} else if (optionalParameter == BookApiServiceOptionEnum.PROJECTION_LITE) {
				uriBuilder.addParameter("projection", "lite");
			} else if (optionalParameter == BookApiServiceOptionEnum.PRINT_ALL) {
				uriBuilder.addParameter("printType", "all");
			} else if (optionalParameter == BookApiServiceOptionEnum.PRINT_MAGAZINES) {
				uriBuilder.addParameter("printType", "magazines");
			} else if (optionalParameter == BookApiServiceOptionEnum.PRINT_BOOKS) {
				uriBuilder.addParameter("printType", "books");
			} else if (optionalParameter == BookApiServiceOptionEnum.PAGINATION) {
				if (startIndex >= 0 && startIndex <= 40 && maxResults >= 0 && maxResults <= 40) {
					uriBuilder.addParameter("startIndex", Integer.toString(startIndex))
							.addParameter("maxResults", Integer.toString(maxResults));
				}
			} else if (optionalParameter == BookApiServiceOptionEnum.FILTER_PARTIAL) {
				uriBuilder.addParameter("filter", "partial");
			} else if (optionalParameter == BookApiServiceOptionEnum.FILTER_FULL) {
				uriBuilder.addParameter("filter", "full");
			} else if (optionalParameter == BookApiServiceOptionEnum.FILTER_FREE_EBOOKS) {
				uriBuilder.addParameter("filter", "free-ebooks");
			} else if (optionalParameter == BookApiServiceOptionEnum.FILTER_PAID_EBOOKS) {
				uriBuilder.addParameter("filter", "paid-ebooks");
			} else if (optionalParameter == BookApiServiceOptionEnum.NONE) {
				// do nothing
			} else {
				throw new IllegalArgumentException("Invalid optional parameter value");
			}

			if (API_KEY != "") {
				uriBuilder.addParameter("key", API_KEY);

			}

			final URI uri = uriBuilder.build();
			final HttpGet getRequest = new HttpGet(uri);
			final CloseableHttpClient httpclient = HttpClients.createDefault();
			try (CloseableHttpResponse response = httpclient.execute(getRequest)) {
				final HttpEntity entity = response.getEntity();
				final ObjectMapper mapper = new ObjectMapper();
				if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
					ErrorResponse errorResponse = mapper.readValue(entity.getContent(), ErrorResponse.class);
					if (errorResponse.getStatusMessage() != null)
						throw new BookAPIException(
								"Error occurred on API call: " + errorResponse.getStatusMessage());
				}

				return mapper.readValue(entity.getContent(), responseType);
			} catch (IOException e) {
				throw new BookAPIException("Error requesting data from the Google Books API.", e);
			}
		} catch (URISyntaxException e) {
			throw new BookAPIException("Unable to create request URI.", e);
		}
	}

}
