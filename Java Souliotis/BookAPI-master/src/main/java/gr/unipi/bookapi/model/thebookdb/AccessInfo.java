package gr.unipi.bookapi.model.thebookdb;

import java.util.LinkedHashMap;
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
        "country",
        "viewability",
        "embeddable",
        "publicDomain",
        "textToSpeechPermission",
        "epub",
        "pdf",
        "webReaderLink",
        "accessViewStatus",
        "quoteSharingAllowed"
})
@Generated("jsonschema2pojo")
public class AccessInfo {

    @JsonProperty("country")
    private String country;
    @JsonProperty("viewability")
    private String viewability;
    @JsonProperty("embeddable")
    private Boolean embeddable;
    @JsonProperty("publicDomain")
    private Boolean publicDomain;
    @JsonProperty("textToSpeechPermission")
    private String textToSpeechPermission;
    @JsonProperty("epub")
    private Epub epub;
    @JsonProperty("pdf")
    private Pdf pdf;
    @JsonProperty("webReaderLink")
    private String webReaderLink;
    @JsonProperty("accessViewStatus")
    private String accessViewStatus;
    @JsonProperty("quoteSharingAllowed")
    private Boolean quoteSharingAllowed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("viewability")
    public String getViewability() {
        return viewability;
    }

    @JsonProperty("viewability")
    public void setViewability(String viewability) {
        this.viewability = viewability;
    }

    @JsonProperty("embeddable")
    public Boolean getEmbeddable() {
        return embeddable;
    }

    @JsonProperty("embeddable")
    public void setEmbeddable(Boolean embeddable) {
        this.embeddable = embeddable;
    }

    @JsonProperty("publicDomain")
    public Boolean getPublicDomain() {
        return publicDomain;
    }

    @JsonProperty("publicDomain")
    public void setPublicDomain(Boolean publicDomain) {
        this.publicDomain = publicDomain;
    }

    @JsonProperty("textToSpeechPermission")
    public String getTextToSpeechPermission() {
        return textToSpeechPermission;
    }

    @JsonProperty("textToSpeechPermission")
    public void setTextToSpeechPermission(String textToSpeechPermission) {
        this.textToSpeechPermission = textToSpeechPermission;
    }

    @JsonProperty("epub")
    public Epub getEpub() {
        return epub;
    }

    @JsonProperty("epub")
    public void setEpub(Epub epub) {
        this.epub = epub;
    }

    @JsonProperty("pdf")
    public Pdf getPdf() {
        return pdf;
    }

    @JsonProperty("pdf")
    public void setPdf(Pdf pdf) {
        this.pdf = pdf;
    }

    @JsonProperty("webReaderLink")
    public String getWebReaderLink() {
        return webReaderLink;
    }

    @JsonProperty("webReaderLink")
    public void setWebReaderLink(String webReaderLink) {
        this.webReaderLink = webReaderLink;
    }

    @JsonProperty("accessViewStatus")
    public String getAccessViewStatus() {
        return accessViewStatus;
    }

    @JsonProperty("accessViewStatus")
    public void setAccessViewStatus(String accessViewStatus) {
        this.accessViewStatus = accessViewStatus;
    }

    @JsonProperty("quoteSharingAllowed")
    public Boolean getQuoteSharingAllowed() {
        return quoteSharingAllowed;
    }

    @JsonProperty("quoteSharingAllowed")
    public void setQuoteSharingAllowed(Boolean quoteSharingAllowed) {
        this.quoteSharingAllowed = quoteSharingAllowed;
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
        sb.append("Country ");
        sb.append(": ");
        sb.append(((this.country == null) ? "<null>" : this.country));
        sb.append("\n");
        sb.append("Viewability ");
        sb.append(": ");
        sb.append(((this.viewability == null) ? "<null>" : this.viewability));
        sb.append("\n");
        sb.append("Embeddable ");
        sb.append(": ");
        sb.append(((this.embeddable == null) ? "<null>" : this.embeddable));
        sb.append("\n");
        sb.append("PublicDomain ");
        sb.append(": ");
        sb.append(((this.publicDomain == null) ? "<null>" : this.publicDomain));
        sb.append("\n");
        sb.append("TextToSpeechPermission ");
        sb.append(": ");
        sb.append(((this.textToSpeechPermission == null) ? "<null>" : this.textToSpeechPermission));
        sb.append("\n");
        sb.append("Epub ");
        sb.append(": ");
        sb.append(((this.epub == null) ? "<null>" : this.epub.toString()));
        sb.append("\n");
        sb.append("Pdf ");
        sb.append(": ");
        sb.append(((this.pdf == null) ? "<null>" : this.pdf.toString()));
        sb.append("\n");
        sb.append("WebReaderLink ");
        sb.append(": ");
        sb.append(((this.webReaderLink == null) ? "<null>" : this.webReaderLink));
        sb.append("\n");
        sb.append("AccessViewStatus ");
        sb.append(": ");
        sb.append(((this.accessViewStatus == null) ? "<null>" : this.accessViewStatus));
        sb.append("\n");
        sb.append("QuoteSharingAllowed ");
        sb.append(": ");
        sb.append(((this.quoteSharingAllowed == null) ? "<null>" : this.quoteSharingAllowed));
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
