package de.htw.berlin.webtechproject.api;

public class Item {

    private long id;
    private String fullName;
    private int amount;
    private boolean selected;


    public Item(long id, String fullName, int amount, boolean selected) {
        this.id = id;
        this.fullName = fullName;
        this.amount = amount;
        this.selected = selected;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
