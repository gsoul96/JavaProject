package gr.unipi.bookapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import gr.unipi.bookapi.model.thebookdb.Item;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookInfo {

    private final String title;
    private final String description;
    private final String author;
    private final String publisher;
    private final String publishedDate;
    private final String isbn;
    private final String id;

    public BookInfo(String title, String description, String author, String publisher, String publishedDate,
            String isbn, String id) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.isbn = isbn;
        this.id = id;
    }

    public BookInfo(Item item) {
        this.id = item.getId();
        this.title = item.getVolumeInfo().getTitle();
        this.description = item.getVolumeInfo().getDescription();
        this.author = item.getVolumeInfo().getAuthors() != null && !item.getVolumeInfo().getAuthors().isEmpty()
                ? item.getVolumeInfo().getAuthors().get(0)
                : "";
        this.publisher = item.getVolumeInfo().getPublisher();
        this.publishedDate = item.getVolumeInfo().getPublishedDate();
        this.isbn = item.getVolumeInfo().getIndustryIdentifiers() != null
                && !item.getVolumeInfo().getIndustryIdentifiers().isEmpty()
                        ? item.getVolumeInfo().getIndustryIdentifiers().get(0).getIdentifier()
                        : "";
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "--BookInfo---" + "\n" +
                "Id: " + id + "\n" +
                "Title: " + title + "\n" +
                "Description: " + description + "\n" +
                "Author: " + author + "\n" +
                "Publisher: " + publisher + "\n" +
                "PublishedDate: " + publishedDate + "\n" +
                "Isbn: " + isbn + "\n"
                + "--------------------------------"
                + "\n";
    }
}