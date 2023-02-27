package gr.unipi.bookapi.model.thebookdb;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "subtitle",
        "authors",
        "publisher",
        "publishedDate",
        "description",
        "industryIdentifiers",
        "readingModes",
        "pageCount",
        "printType",
        "categories",
        "averageRating",
        "ratingsCount",
        "maturityRating",
        "allowAnonLogging",
        "contentVersion",
        "panelizationSummary",
        "imageLinks",
        "language",
        "previewLink",
        "infoLink",
        "canonicalVolumeLink"
})
@Generated("jsonschema2pojo")
public class VolumeInfo {

    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("authors")
    private List<String> authors;
    @JsonProperty("publisher")
    private String publisher;
    @JsonProperty("publishedDate")
    private String publishedDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("industryIdentifiers")
    private List<IndustryIdentifier> industryIdentifiers;
    @JsonProperty("readingModes")
    private ReadingModes readingModes;
    @JsonProperty("pageCount")
    private Integer pageCount;
    @JsonProperty("printType")
    private String printType;
    @JsonProperty("categories")
    private List<String> categories;
    @JsonProperty("averageRating")
    private Integer averageRating;
    @JsonProperty("ratingsCount")
    private Integer ratingsCount;
    @JsonProperty("maturityRating")
    private String maturityRating;
    @JsonProperty("allowAnonLogging")
    private Boolean allowAnonLogging;
    @JsonProperty("contentVersion")
    private String contentVersion;
    @JsonProperty("panelizationSummary")
    private PanelizationSummary panelizationSummary;
    @JsonProperty("imageLinks")
    private ImageLinks imageLinks;
    @JsonProperty("language")
    private String language;
    @JsonProperty("previewLink")
    private String previewLink;
    @JsonProperty("infoLink")
    private String infoLink;
    @JsonProperty("canonicalVolumeLink")
    private String canonicalVolumeLink;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("subtitle")
    public String getSubtitle() {
        return subtitle;
    }

    @JsonProperty("subtitle")
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @JsonProperty("authors")
    public List<String> getAuthors() {
        return authors;
    }

    @JsonProperty("authors")
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @JsonProperty("publisher")
    public String getPublisher() {
        return publisher;
    }

    @JsonProperty("publisher")
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @JsonProperty("publishedDate")
    public String getPublishedDate() {
        return publishedDate;
    }

    @JsonProperty("publishedDate")
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("industryIdentifiers")
    public List<IndustryIdentifier> getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    @JsonProperty("industryIdentifiers")
    public void setIndustryIdentifiers(List<IndustryIdentifier> industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
    }

    @JsonProperty("readingModes")
    public ReadingModes getReadingModes() {
        return readingModes;
    }

    @JsonProperty("readingModes")
    public void setReadingModes(ReadingModes readingModes) {
        this.readingModes = readingModes;
    }

    @JsonProperty("pageCount")
    public Integer getPageCount() {
        return pageCount;
    }

    @JsonProperty("pageCount")
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @JsonProperty("printType")
    public String getPrintType() {
        return printType;
    }

    @JsonProperty("printType")
    public void setPrintType(String printType) {
        this.printType = printType;
    }

    @JsonProperty("categories")
    public List<String> getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @JsonProperty("averageRating")
    public Integer getAverageRating() {
        return averageRating;
    }

    @JsonProperty("averageRating")
    public void setAverageRating(Integer averageRating) {
        this.averageRating = averageRating;
    }

    @JsonProperty("ratingsCount")
    public Integer getRatingsCount() {
        return ratingsCount;
    }

    @JsonProperty("ratingsCount")
    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    @JsonProperty("maturityRating")
    public String getMaturityRating() {
        return maturityRating;
    }

    @JsonProperty("maturityRating")
    public void setMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }

    @JsonProperty("allowAnonLogging")
    public Boolean getAllowAnonLogging() {
        return allowAnonLogging;
    }

    @JsonProperty("allowAnonLogging")
    public void setAllowAnonLogging(Boolean allowAnonLogging) {
        this.allowAnonLogging = allowAnonLogging;
    }

    @JsonProperty("contentVersion")
    public String getContentVersion() {
        return contentVersion;
    }

    @JsonProperty("contentVersion")
    public void setContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
    }

    @JsonProperty("panelizationSummary")
    public PanelizationSummary getPanelizationSummary() {
        return panelizationSummary;
    }

    @JsonProperty("panelizationSummary")
    public void setPanelizationSummary(PanelizationSummary panelizationSummary) {
        this.panelizationSummary = panelizationSummary;
    }

    @JsonProperty("imageLinks")
    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    @JsonProperty("imageLinks")
    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("previewLink")
    public String getPreviewLink() {
        return previewLink;
    }

    @JsonProperty("previewLink")
    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    @JsonProperty("infoLink")
    public String getInfoLink() {
        return infoLink;
    }

    @JsonProperty("infoLink")
    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    @JsonProperty("canonicalVolumeLink")
    public String getCanonicalVolumeLink() {
        return canonicalVolumeLink;
    }

    @JsonProperty("canonicalVolumeLink")
    public void setCanonicalVolumeLink(String canonicalVolumeLink) {
        this.canonicalVolumeLink = canonicalVolumeLink;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title ");
        sb.append(": ");
        sb.append(((this.title == null) ? "<null>" : this.title));
        sb.append("\n");
        sb.append("Subtitle ");
        sb.append(": ");
        sb.append(((this.subtitle == null) ? "<null>" : this.subtitle));
        sb.append("\n");
        sb.append("Authors ");
        sb.append(": ");
        sb.append(((this.authors == null) ? "<null>" : this.authors));
        sb.append("\n");
        sb.append("Publisher ");
        sb.append(": ");
        sb.append(((this.publisher == null) ? "<null>" : this.publisher));
        sb.append("\n");
        sb.append("PublishedDate ");
        sb.append(": ");
        sb.append(((this.publishedDate == null) ? "<null>" : this.publishedDate));
        sb.append("\n");
        sb.append("Description ");
        sb.append(": ");
        sb.append(((this.description == null) ? "<null>" : this.description));
        sb.append("\n");
        sb.append("IndustryIdentifiers ");
        sb.append(": ");
        sb.append(((this.industryIdentifiers == null) ? "<null>" : this.industryIdentifiers.toString()));
        sb.append("\n");
        sb.append("ReadingModes ");
        sb.append(": ");
        sb.append(((this.readingModes == null) ? "<null>" : this.readingModes.toString()));
        sb.append("\n");
        sb.append("PageCount ");
        sb.append(": ");
        sb.append(((this.pageCount == null) ? "<null>" : this.pageCount));
        sb.append("\n");
        sb.append("PrintType ");
        sb.append(": ");
        sb.append(((this.printType == null) ? "<null>" : this.printType));
        sb.append("\n");
        sb.append("Categories ");
        sb.append(": ");
        sb.append(((this.categories == null) ? "<null>" : this.categories));
        sb.append("\n");
        sb.append("AverageRating ");
        sb.append(": ");
        sb.append(((this.averageRating == null) ? "<null>" : this.averageRating));
        sb.append("\n");
        sb.append("RatingsCount ");
        sb.append(": ");
        sb.append(((this.ratingsCount == null) ? "<null>" : this.ratingsCount));
        sb.append("\n");
        sb.append("MaturityRating ");
        sb.append(": ");
        sb.append(((this.maturityRating == null) ? "<null>" : this.maturityRating));
        sb.append("\n");
        sb.append("AllowAnonLogging ");
        sb.append(": ");
        sb.append(((this.allowAnonLogging == null) ? "<null>" : this.allowAnonLogging));
        sb.append("\n");
        sb.append("ContentVersion ");
        sb.append(": ");
        sb.append(((this.contentVersion == null) ? "<null>" : this.contentVersion));
        sb.append("\n");
        sb.append("PanelizationSummary ");
        sb.append(": ");
        sb.append(((this.panelizationSummary == null) ? "<null>" : this.panelizationSummary.toString()));
        sb.append("\n");
        sb.append("ImageLinks ");
        sb.append(": ");
        sb.append(((this.imageLinks == null) ? "<null>" : this.imageLinks.toString()));
        sb.append("\n");
        sb.append("Language ");
        sb.append(": ");
        sb.append(((this.language == null) ? "<null>" : this.language));
        sb.append("\n");
        sb.append("PreviewLink ");
        sb.append(": ");
        sb.append(((this.previewLink == null) ? "<null>" : this.previewLink));
        sb.append("\n");
        sb.append("InfoLink ");
        sb.append(": ");
        sb.append(((this.infoLink == null) ? "<null>" : this.infoLink));
        sb.append("\n");
        sb.append("CanonicalVolumeLink ");
        sb.append(": ");
        sb.append(((this.canonicalVolumeLink == null) ? "<null>" : this.canonicalVolumeLink));
        sb.append("\n");
        sb.append("AdditionalProperties ");
        sb.append(": ");
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append("\n");
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
