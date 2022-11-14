package de.htw.berlin.webtechproject.persistence;


import javax.persistence.*;

@Entity(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String fullName;

    @Column(name = "amount")
    private int amount;

    @Column(name = "is_selected")
    private boolean selected;

    public ItemEntity(String fullName, int amount, boolean selected) {
        this.fullName = fullName;
        this.amount = amount;
        this.selected = selected;
    }

    protected ItemEntity() {}

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        fullName = fullName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
