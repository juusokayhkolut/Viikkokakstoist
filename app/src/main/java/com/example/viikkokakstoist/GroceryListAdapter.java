package com.example.viikkokakstoist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryViewHolder> {
    private List<Grocery> groceries;

    public GroceryListAdapter(List<Grocery> groceries) {
        this.groceries = groceries;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grocery_item, parent, false);
        return new GroceryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        Grocery currentGrocery = groceries.get(position);
        holder.textGroceryName.setText(currentGrocery.getName());
        holder.textGroceryNote.setText(currentGrocery.getNote());
    }

    @Override
    public int getItemCount() {
        return groceries.size();
    }
}

