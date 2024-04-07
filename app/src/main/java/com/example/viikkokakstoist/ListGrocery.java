package com.example.viikkokakstoist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListGrocery {
    private List<Grocery> groceries;
    private static ListGrocery instance;

    private ListGrocery() {
        groceries = new ArrayList<>();
    }

    public static ListGrocery getInstance() {
        if (instance == null) {
            instance = new ListGrocery();
        }
        return instance;
    }

    public void addGrocery(Grocery grocery) {
        groceries.add(grocery);
    }

    public List<Grocery> getGroceries() {
        return groceries;
    }

    public List<Grocery> getImportantGroceries() {
        return groceries.stream()
                .filter(Grocery::isImportant)
                .collect(Collectors.toList());
    }
}
