package gr.unipi.bookapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import gr.unipi.bookapi.model.thebookdb.UserData;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {

    private final String kind;
    private final Integer id;
    private final String title;
    private final Integer volumeCount;
    private final String description;

    public UserInfo(UserData item) {
        this.kind = item.getKind();
        this.id = item.getId();
        this.title = item.getTitle();
        this.volumeCount = item.getVolumeCount();
        this.description = item.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public String getDescription() {
        return description;
    }

    public Integer getVolumeCount() {
        return volumeCount;
    }

    @Override
    public String toString() {
        return "--User bookshelves info---" + "\n" +
                "Kind: " + kind + "\n" +
                "Id: " + id + "\n" +
                "Title: " + title + "\n" +
                "Description " + description + "\n" +
                "VolumesCount: " + volumeCount + "\n"
                + "--------------------------------"
                + "\n";
    }
}