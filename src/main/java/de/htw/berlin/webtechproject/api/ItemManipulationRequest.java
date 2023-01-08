package de.htw.berlin.webtechproject.api;

import java.time.LocalDateTime;

public class  ItemManipulationRequest {
    private String name;
    private String imageUrl;
    private boolean completed;
    private LocalDateTime dateAdded;

    public ItemManipulationRequest(String name, String imageUrl, boolean completed, LocalDateTime dateAdded) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.completed = completed;
        this.dateAdded = dateAdded;
    }

    public ItemManipulationRequest() {}

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {return imageUrl;}

    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

    public boolean isCompleted() {return completed;}

    public void setCompleted(boolean completed) {this.completed = completed;}

    public LocalDateTime getDateAdded() {return dateAdded;}

    public void setDateAdded(LocalDateTime dateAdded) {this.dateAdded = dateAdded;}
}
