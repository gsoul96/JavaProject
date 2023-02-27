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
        "smallThumbnail",
        "thumbnail"
})
@Generated("jsonschema2pojo")
public class ImageLinks {

    @JsonProperty("smallThumbnail")
    private String smallThumbnail;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("smallThumbnail")
    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    @JsonProperty("smallThumbnail")
    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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
        sb.append("SmallThumbnail ");
        sb.append(": ");
        sb.append(((this.smallThumbnail == null) ? "<null>" : this.smallThumbnail));
        sb.append("\n");
        sb.append("Thumbnail ");
        sb.append(": ");
        sb.append(((this.thumbnail == null) ? "<null>" : this.thumbnail));
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
