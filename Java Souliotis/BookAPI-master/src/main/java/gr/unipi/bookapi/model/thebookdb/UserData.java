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
        "kind",
        "id",
        "selfLink",
        "title",
        "description",
        "access",
        "updated",
        "created",
        "volumeCount",
        "volumesLastUpdated"
})
@Generated("jsonschema2pojo")
public class UserData {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("selfLink")
    private String selfLink;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("access")
    private String access;
    @JsonProperty("updated")
    private String updated;
    @JsonProperty("created")
    private String created;
    @JsonProperty("volumeCount")
    private Integer volumeCount;
    @JsonProperty("volumesLastUpdated")
    private String volumesLastUpdated;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("selfLink")
    public String getSelfLink() {
        return selfLink;
    }

    @JsonProperty("selfLink")
    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("access")
    public String getAccess() {
        return access;
    }

    @JsonProperty("access")
    public void setAccess(String access) {
        this.access = access;
    }

    @JsonProperty("updated")
    public String getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("volumeCount")
    public Integer getVolumeCount() {
        return volumeCount;
    }

    @JsonProperty("volumeCount")
    public void setVolumeCount(Integer volumeCount) {
        this.volumeCount = volumeCount;
    }

    @JsonProperty("volumesLastUpdated")
    public String getVolumesLastUpdated() {
        return volumesLastUpdated;
    }

    @JsonProperty("volumesLastUpdated")
    public void setVolumesLastUpdated(String volumesLastUpdated) {
        this.volumesLastUpdated = volumesLastUpdated;
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
        sb.append("Kind ");
        sb.append(": ");
        sb.append(((this.kind == null) ? "<null>" : this.kind));
        sb.append("\n");
        sb.append("Id ");
        sb.append(": ");
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append("\n");
        sb.append("SelfLink ");
        sb.append(": ");
        sb.append(((this.selfLink == null) ? "<null>" : this.selfLink));
        sb.append("\n");
        sb.append("Title ");
        sb.append(": ");
        sb.append(((this.title == null) ? "<null>" : this.title));
        sb.append("\n");
        sb.append("Description ");
        sb.append(": ");
        sb.append(((this.description == null) ? "<null>" : this.description));
        sb.append("\n");
        sb.append("Access ");
        sb.append(": ");
        sb.append(((this.access == null) ? "<null>" : this.access));
        sb.append("\n");
        sb.append("Updated ");
        sb.append(": ");
        sb.append(((this.updated == null) ? "<null>" : this.updated));
        sb.append("\n");
        sb.append("Created ");
        sb.append(": ");
        sb.append(((this.created == null) ? "<null>" : this.created));
        sb.append("\n");
        sb.append("VolumeCount ");
        sb.append('=');
        sb.append(((this.volumeCount == null) ? "<null>" : this.volumeCount));
        sb.append("\n");
        sb.append("VolumesLastUpdated ");
        sb.append(": ");
        sb.append(((this.volumesLastUpdated == null) ? "<null>" : this.volumesLastUpdated));
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
