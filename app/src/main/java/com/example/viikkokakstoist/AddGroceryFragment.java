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

        View view = inflater.inflate(R.layout.fragment_add_grocery, container, false);

        editGroceryName = view.findViewById(R.id.editGroceryName);
        editGroceryNote = view.findViewById(R.id.editGroceryNote);
        checkImportant = view.findViewById(R.id.checkImportant);
        buttonAddGrocery = view.findViewById(R.id.buttonAddGrocery);

        listGrocery = ListGrocery.getInstance();

        buttonAddGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addGroceryItem();
            }
        });

        return view;
    }

    private void addGroceryItem() {
        String name = editGroceryName.getText().toString();
        String note = editGroceryNote.getText().toString();
        boolean important = checkImportant.isChecked();

        // Validate input
        if (validateInput(name, note)) {
            Grocery grocery = new Grocery(name, note, important);

            listGrocery.addGrocery(grocery);

            clearInputFields();

            updateBottomFragment();
        }
    }

    private boolean validateInput(String name, String note) {
        return !name.isEmpty() && !note.isEmpty();
    }

    private void clearInputFields() {
        editGroceryName.setText("");
        editGroceryNote.setText("");
        checkImportant.setChecked(false);
    }

    private void updateBottomFragment() {
        BottomFragment bottomFragment = (BottomFragment)
                getParentFragmentManager().findFragmentById(R.id.frameBottom);

        if (bottomFragment != null) {
            bottomFragment.updateImportantItems();
        }
    }
}
