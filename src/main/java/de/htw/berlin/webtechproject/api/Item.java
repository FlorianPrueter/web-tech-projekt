package de.htw.berlin.webtechproject.api;

import java.time.LocalDateTime;

public class Item {

    private long id;
    private String name;
    private String imageUrl;
    private boolean completed;
    private LocalDateTime dateAdded;

    public Item(long id, String name, String imageUrl, boolean completed, LocalDateTime dateAdded) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.completed = completed;
        this.dateAdded = dateAdded;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
