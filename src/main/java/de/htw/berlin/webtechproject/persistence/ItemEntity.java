package de.htw.berlin.webtechproject.persistence;


import javax.persistence.*;

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

    public ItemEntity(String name, String imageUrl, boolean completed) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.completed = completed;
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
        name = name;
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
