package com.ninjalightning.ingredients;

import android.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by jacobelliott on 12/14/13.
 */
public class IngredientsFragment extends Fragment {

    ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ingredients_fragment, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.ingredients);

        //PUT ARRAY HERE
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
            android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;

        ArrayAdapter<String> tempAdapter = new ArrayAdapter<String>(getActivity(), layout, SampleData.Ingredients);

        // IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(getApplicationContext(), R.layout.row, myIngredientsArray);

        // setListAdapter(new ArrayAdapter<String>(getActivity(), layout, SampleData.Ingredients));

        mListView = (ListView) view.findViewById(R.id.ingredient_list);

        if(mListView != null) {
            mListView.setAdapter (tempAdapter);
        }
    }
}
        //builds a list view of available ingredients