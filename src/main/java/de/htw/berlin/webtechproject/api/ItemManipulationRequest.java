package de.htw.berlin.webtechproject.api;

public class  ItemManipulationRequest {
    private String fullName;
    private int amount;
    private boolean selected;

    public ItemManipulationRequest(String fullName, int amount, boolean selected) {
        this.fullName = fullName;
        this.amount = amount;
        this.selected = selected;
    }

    public ItemManipulationRequest() {}

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
