package de.htw.berlin.webtechproject.persistence;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "is_completed")
    private boolean completed;

    @Column(name = "date_added")
    private LocalDateTime dateAdded;

    public ItemEntity(String name, String imageUrl, boolean completed, LocalDateTime dateAdded) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.completed = completed;
        this.dateAdded = dateAdded;
    }

    protected ItemEntity() {
    }

    public long getId() {
        return id;
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

    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}
    public boolean isCompleted() {return completed;}

    public void setCompleted(boolean completed) {this.completed = completed;}

    public LocalDateTime getDateAdded() {return dateAdded;}
    public void setDateAdded(LocalDateTime dateAdded) {this.dateAdded = dateAdded;}
}
