package com.example.viikkokakstoist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;
import java.util.stream.Collectors;

public class BottomFragment extends Fragment {
    private TextView textImportant;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);
        textImportant = view.findViewById(R.id.textImportant);
        updateImportantItems();
        return view;
    }

    public void updateImportantItems() {
        List<Grocery> importantItems = ListGrocery.getInstance().getImportantGroceries();
        textImportant.setText(
                importantItems.stream()
                        .map(Grocery::getName)
                        .collect(Collectors.joining(", "))
        );
    }
}

