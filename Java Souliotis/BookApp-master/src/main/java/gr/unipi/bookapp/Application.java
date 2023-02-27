package gr.unipi.bookapp;

import java.util.List;
import java.util.Scanner;

import gr.unipi.bookapi.BookApi;
import gr.unipi.bookapi.exception.BookAPIException;
import gr.unipi.bookapi.model.BookInfo;
import gr.unipi.bookapi.model.UserInfo;
import gr.unipi.bookapi.services.BookAPIService;
import gr.unipi.bookapi.services.BookApiServiceOptionEnum;

public class Application {

	public static void main(String[] args) {
		final BookAPIService bookDBService = BookApi.getBookDBService();

		System.out.println("Welcome the the Book App");

		while (true) {
			System.out.println("Select one from the following options: ");
			System.out.println("1. Search for a books");
			System.out.println("2. Quick Search");
			System.out.println("3. Search in the last searches.");
			System.out.println("4. Search for detailed info with Book Id");
			System.out.println("5. Retrieving a list of a user's public bookshelves");
			System.out.println("6. Exit.");
			System.out.println("Your choice: ");

			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();

			System.out.println("Your choice: " + input);

			switch (input) {
				case "1":
					System.out.println("Selected 1");
					Application.searchBooksByKeyword("", "");
					break;
				case "2":
					System.out.println("Selected 2");
					System.out.print("Enter search parameter: ");
					String searchParam = sc.nextLine();
					try {
						final List<BookInfo> results = bookDBService.searchBooks(searchParam);
						System.out.println("Results are: ");
						System.out.println(results);
					} catch (BookAPIException e) {
						System.err.println(e.getMessage());
					}
					break;
				case "3":
					System.out.println("Enter the number of saved searches to retrieve: ");
					int num = sc.nextInt();
					List<BookInfo> savedSearchesToDisplay = bookDBService.getSearches(num);
					System.out.printf("%d saved searches found.%n", savedSearchesToDisplay.size());
					for (BookInfo bookInfo : savedSearchesToDisplay) {
						System.out.println(bookInfo);
					}
					break;
				case "4":
					System.out.println("Enter the specific BookID for detailed info :");
					String id = sc.nextLine();
					try {
						String resultId = bookDBService.getBookInfo(id);
						System.out.println(resultId);
					} catch (BookAPIException e) {
						System.err.println(e.getMessage());
					}
					break;
				case "5":
					System.out.println("Enter the User ID to search for:");
					String userId = sc.nextLine();
					try {
						List<UserInfo> userResults = bookDBService.getUserBookshelves(userId);
						System.out.println("Results: ");
						System.out.println(userResults);
						System.out.println("Do you want to retrieve a specific bookshelf for this user? (Y/N)");
						String answer = sc.nextLine();
						if (answer.equalsIgnoreCase("Y")) {
							System.out.println("Available bookshelf IDs for this user:");
							for (UserInfo userInfo : userResults) {
								System.out.println(userInfo.getId());
							}
							System.out.println("Enter the bookshelf ID to retrieve:");
							String bookshelfId = sc.nextLine();
							try {
								System.out
										.println("Do you want to specify this search? (Y/N)");
								answer = sc.nextLine();
								if (answer.equalsIgnoreCase("Y")) {
									Application.searchBooksByKeyword(userId, bookshelfId);
								} else {
									List<BookInfo> books = bookDBService.getBooksInBookshelf(userId, bookshelfId);
									System.out.println("Books in bookshelf " + bookshelfId + ":");
									System.out.println(books);
								}
							} catch (BookAPIException e) {
								System.err.println(e.getMessage());
							}
						}
					} catch (BookAPIException e) {
						System.err.println(e.getMessage());
					}
					break;
				case "6":
					System.out.println("Selected 6");
					System.exit(0);
					break;

				default:
					System.out.println("Invalid input");
			}

		}

	}

	public static void searchBooksByKeyword(String userId, String bookshelfId) {
		final BookAPIService bookDBService = BookApi.getBookDBService();
		Scanner sc = new Scanner(System.in);

		System.out.println("Do you want a specific search where this keyword is found:+\n");
		System.out.println("1:in the Book title\n");
		System.out.println("2:in the Book Author\n");
		System.out.println("3:in the Book publisher\n");
		System.out.println("4:in the Book subject\n");
		System.out.println("5:in the Book isbn\n");

		try {
			String searchOption = sc.nextLine();
			List<BookInfo> results;
			BookApiServiceOptionEnum optionalParameters = optionalSearchOptions();
			Integer paginationStart = -1;
			Integer paginationMaxResults = -1;
			if (optionalParameters == BookApiServiceOptionEnum.PAGINATION) {
				Integer[] paginationValues = pagination();
				paginationStart = paginationValues[0];
				paginationMaxResults = paginationValues[1];
			}
			switch (searchOption) {
				case "1":
					System.out.println("Enter the keyword to search in Book Title: ");
					String titleKeyword = sc.nextLine();
					results = bookDBService.searchBooksByTitle(userId, bookshelfId, titleKeyword, optionalParameters,
							paginationStart, paginationMaxResults);
					break;
				case "2":
					System.out.println("Enter the keyword to search in Book Author: ");
					String authorKeyword = sc.nextLine();
					results = bookDBService.searchBooksByAuthor(userId, bookshelfId, authorKeyword, optionalParameters,
							paginationStart, paginationMaxResults);
					break;
				case "3":
					System.out.println("Enter the keyword to search in Book Publisher: ");
					String publisherKeyword = sc.nextLine();
					results = bookDBService.searchBooksByPublisher(userId, bookshelfId, publisherKeyword,
							optionalParameters,
							paginationStart, paginationMaxResults);
					break;
				case "4":
					System.out.println("Enter the keyword to search in Book Subject: ");
					String subjectKeyword = sc.nextLine();
					results = bookDBService.searchBooksBySubject(userId, bookshelfId, subjectKeyword,
							optionalParameters,
							paginationStart, paginationMaxResults);
					break;
				case "5":
					System.out.println("Enter the keyword to search in Book ISBN: ");
					String isbnKeyword = sc.nextLine();
					results = bookDBService.searchBooksByISBN(userId, bookshelfId, isbnKeyword, optionalParameters,
							paginationStart, paginationMaxResults);
					break;
				default:
					System.out.println("Invalid search option selected");
					return;
			}

			System.out.println("Results are: ");
			System.out.println(results);
		} catch (BookAPIException e) {
			System.err.println(e.getMessage());
		}
	}

	public static Integer[] pagination() {
		Scanner sc = new Scanner(System.in);
		Integer startIndex = null;
		Integer maxNumber = 10;
		try {
			System.out.println("Please provide start index:");
			String userInput = sc.nextLine();
			startIndex = Integer.parseInt(userInput);

			System.out.println("Please provide max results (max 40):");
			userInput = sc.nextLine();
			if (!userInput.isEmpty()) {
				maxNumber = Integer.parseInt(userInput);
				if (maxNumber > 40) {
					throw new IllegalArgumentException("Max results should be less than or equal to 40.");
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please provide a valid number.");
			return pagination();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return pagination();
		}
		return new Integer[] { startIndex, maxNumber };
	}

	public static BookApiServiceOptionEnum optionalSearchOptions() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Do you want to add optional search parameters?");
		System.out.println("Y/N");

		String userInput = sc.nextLine();
		if (userInput.equalsIgnoreCase("Y")) {
			System.out.println("You can add the following search parameters:\n");
			System.out.println("1. By Filtering\n");
			System.out.println("2. By pagination\n");
			System.out.println("3. By print type\n");
			System.out.println("4. By projection\n");
			System.out.println("5. By sorting\n");

			userInput = sc.nextLine();
			try {
				switch (userInput) {
					case "1":
						System.out.println("The available option for filtering are:\n");
						System.out.println(
								"1. Partial - Returns results where at least parts of the text are previewable\n");
						System.out.println("2. Full - Only returns results where all of the text is viewable\n");
						System.out.println("4. Free-ebooks - Only returns results that are free Google eBooks\n");
						System.out
								.println("5. Paid-ebooks - Only returns results that are Google eBooks with a price\n");
						System.out.println(
								"6. ebooks - Only returns results that are Google eBooks, paid or free. Examples of non-eBooks would be publisher content that is available in limited preview and not for sale, or magazines\n");

						userInput = sc.nextLine();
						switch (userInput) {
							case "1":
								return BookApiServiceOptionEnum.FILTER_PARTIAL;
							case "2":
								return BookApiServiceOptionEnum.FILTER_FULL;
							case "4":
								return BookApiServiceOptionEnum.FILTER_FREE_EBOOKS;
							case "5":
								return BookApiServiceOptionEnum.FILTER_PAID_EBOOKS;
							case "6":
								return BookApiServiceOptionEnum.FILTER_EBOOKS;
							default:
								System.out.println("Invalid input. Continuing without option search parameters.");
								return BookApiServiceOptionEnum.NONE;
						}

					case "2":
						System.out.println("For paginating the volumes you have to specify:\n");
						System.out.println(
								"startIndex - The position in the collection at which to start. The index of the first item is 0\n");
						System.out.println(
								"maxResults - The maximum number of results to return. The default is 10, and the maximum allowable value is 40\n");
						return BookApiServiceOptionEnum.PAGINATION;
					case "3":
						System.out.println("The available option for restricting the result by print type:\n");
						System.out.println("1 All - Does not restrict by print type (default).\n");
						System.out.println("2. Books - Returns only results that are books\n");
						System.out.println("3. Magazines - Returns results that are magazines.\n");
						userInput = sc.nextLine();
						switch (userInput) {
							case "1":
								return BookApiServiceOptionEnum.PRINT_ALL;
							case "2":
								return BookApiServiceOptionEnum.PRINT_BOOKS;
							case "3":
								return BookApiServiceOptionEnum.PRINT_MAGAZINES;
							default:
								System.out.println("Invalid input. Continuing without option search parameters.");
								return BookApiServiceOptionEnum.NONE;
						}

					case "4":
						System.out.println("The available option for restricting by projection:\n");
						System.out.println("1. Full - Returns all Volume fields\n");
						System.out.println("2. Lite - Returns only certain fields. \n");

						userInput = sc.nextLine();
						switch (userInput) {
							case "1":
								return BookApiServiceOptionEnum.PROJECTION_FULL;
							case "2":
								return BookApiServiceOptionEnum.PROJECTION_LITE;
							default:
								System.out.println("Invalid input. Continuing without option search parameters.");
								return BookApiServiceOptionEnum.NONE;
						}
					case "5":
						System.out.println("The available option for sorting the search request : \n");
						System.out
								.println("1. Relevance - Returns results in order of the relevance of search terms \n");
						System.out.println(
								"2. Newest - Returns results in order of most recently to least recently published.\n");
						userInput = sc.nextLine();
						switch (userInput) {
							case "1":
								return BookApiServiceOptionEnum.ORDER_BY_RELEVANCE;
							case "2":
								return BookApiServiceOptionEnum.ORDE_BY_NEWEST;
							default:
								System.out.println("Invalid input. Continuing without option search parameters.");
								return BookApiServiceOptionEnum.NONE;
						}
				}
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				return BookApiServiceOptionEnum.NONE;
			}

		} else if (userInput.equals("N")) {
			System.out.println("Continuing without option search parameters.");
			return BookApiServiceOptionEnum.NONE;
		} else {
			System.out.println("Invalid input. Continuing without option search parameters.");
			return BookApiServiceOptionEnum.NONE;
		}
		return BookApiServiceOptionEnum.NONE;

	}

}
