package gr.unipi.bookapi;

import gr.unipi.bookapi.services.BookAPIService;

public class BookApi {

	public static BookAPIService getBookDBService() {
		// API key needed. Register and generate API KEY
		// My API key used for testing was AIzaSyDjGp-oJ1EVHqH03ZJFB01VKZ5FVUHQ3FU
		return new BookAPIService("https://www.googleapis.com/", "");
	}

}
