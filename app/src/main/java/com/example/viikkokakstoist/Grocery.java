package com.example.viikkokakstoist;

public class Grocery {
    private String name;
    private String note;
    private boolean isImportant;

    public Grocery(String name, String note, boolean isImportant) {
        this.name = name;
        this.note = note;
        this.isImportant = isImportant;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }
}
