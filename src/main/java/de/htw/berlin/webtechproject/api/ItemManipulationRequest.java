package de.htw.berlin.webtechproject.api;

public class  ItemManipulationRequest {
    private String name;
    private String imageUrl;
    private boolean completed;

    public ItemManipulationRequest(String name, String imageUrl, boolean completed) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.completed = completed;
    }

    public ItemManipulationRequest() {}

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {return imageUrl;}

    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
