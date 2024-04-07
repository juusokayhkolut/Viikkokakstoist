package com.example.viikkokakstoist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListGroceryFragment extends Fragment {
    private RecyclerView rvGroceries;
    private GroceryListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_grocery, container, false);

        // Initialize RecyclerView
        rvGroceries = view.findViewById(R.id.rvGroceries);
        rvGroceries.setLayoutManager(new LinearLayoutManager(view.getContext()));

        // Initialize the adapter with an empty list or a list from saved state
        adapter = new GroceryListAdapter(ListGrocery.getInstance().getGroceries());
        rvGroceries.setAdapter(adapter);

        return view;
    }

    // You might want to create a method to update the list when new data is added
    public void updateGroceryList() {
        adapter.notifyDataSetChanged();
    }
}
