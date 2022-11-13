package de.htw.berlin.webtechproject.api;

public class Item {

    private long id;
    private String Name;
    private int amount;
    private boolean selected;


    public Item(long id, String name, int amount, boolean selected) {
        this.id = id;
        Name = name;
        this.amount = amount;
        this.selected = selected;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
