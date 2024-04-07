package com.example.viikkokakstoist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddGroceryFragment extends Fragment {
    private EditText editGroceryName;
    private EditText editGroceryNote;
    private CheckBox checkImportant;
    private Button buttonAddGrocery;
    private ListGrocery listGrocery;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_grocery, container, false);

        // Initialize the views
        editGroceryName = view.findViewById(R.id.editGroceryName);
        editGroceryNote = view.findViewById(R.id.editGroceryNote);
        checkImportant = view.findViewById(R.id.checkImportant);
        buttonAddGrocery = view.findViewById(R.id.buttonAddGrocery);

        // Initialize the ListGrocery singleton
        listGrocery = ListGrocery.getInstance();

        // Setup the button click listener
        buttonAddGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addGroceryItem();
            }
        });

        return view;
    }

    private void addGroceryItem() {
        // Get the entered name and note
        String name = editGroceryName.getText().toString();
        String note = editGroceryNote.getText().toString();
        boolean important = checkImportant.isChecked();

        // Validate input
        if (validateInput(name, note)) {
            // Create a new Grocery item
            Grocery grocery = new Grocery(name, note, important);

            // Add the item to the list
            listGrocery.addGrocery(grocery);

            // Clear the input fields
            clearInputFields();

            // Update the bottom fragment to show important items
            updateBottomFragment();
        }
    }

    private boolean validateInput(String name, String note) {
        // Add your input validation logic here, for example:
        return !name.isEmpty() && !note.isEmpty();
    }

    private void clearInputFields() {
        editGroceryName.setText("");
        editGroceryNote.setText("");
        checkImportant.setChecked(false);
    }

    private void updateBottomFragment() {
        // Find the BottomFragment
        BottomFragment bottomFragment = (BottomFragment)
                getParentFragmentManager().findFragmentById(R.id.frameBottom);

        // If it exists, update the important items list
        if (bottomFragment != null) {
            bottomFragment.updateImportantItems();
        }
    }
}
