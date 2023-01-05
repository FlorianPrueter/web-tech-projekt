package de.htw.berlin.webtechproject.api;

public class  ItemManipulationRequest {
    private String name;
    private String imageUrl;

    public ItemManipulationRequest(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public ItemManipulationRequest() {}

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {return imageUrl;}

    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}
}
