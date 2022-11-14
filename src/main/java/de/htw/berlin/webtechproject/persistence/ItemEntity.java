package de.htw.berlin.webtechproject.persistence;


import javax.persistence.*;

@Entity(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String Name;

    @Column(name = "amount")
    private int amount;

    @Column(name = "is_selected")
    private boolean selected;

    public ItemEntity(long id, String name, int amount, boolean selected) {
        this.id = id;
        Name = name;
        this.amount = amount;
        this.selected = selected;
    }

    protected ItemEntity() {}

    public long getId() {
        return id;
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

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
