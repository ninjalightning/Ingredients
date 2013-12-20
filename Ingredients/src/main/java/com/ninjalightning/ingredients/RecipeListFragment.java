package com.ninjalightning.ingredients;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by jacobelliott on 12/16/13.
 */
public class RecipeListFragment extends ListFragment{

    OnRecipeSelectedListener mCallback;

    // The container Activity must implement this interface so the frag can deliver messages
    public interface OnRecipeSelectedListener {
        /** Called by HeadlinesFragment when a list item is selected */
        public void onRecipeSelected(int position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View recipeListView = inflater.inflate(R.layout.recipe_list_fragment,container,false);
        return recipeListView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback = (OnRecipeSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnRecipeSelectedListener");
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecipeAdapter recipeAdapter = new RecipeAdapter(getActivity(), R.layout.recipe_row, SampleData.recipeData);

        if(getListView() != null) {
            getListView().setAdapter(recipeAdapter);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mCallback.onRecipeSelected(position);
    }

}
//shows list view of recipe options