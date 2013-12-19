package com.ninjalightning.ingredients;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jacobelliott on 12/16/13.
 */
public class RecipeListFragment extends ListFragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View recipeListView = inflater.inflate(R.layout.recipes_fragment,container,false);
        return recipeListView;
    }
}
//shows list view of recipe options