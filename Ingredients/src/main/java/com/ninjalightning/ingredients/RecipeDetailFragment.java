package com.ninjalightning.ingredients;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by jacobelliott on 12/14/13.
 */
public class RecipeDetailFragment extends Fragment {

    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        View recipeDetailView = inflater.inflate(R.layout.recipe_detail_fragment,container,false);
        return recipeDetailView;
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateRecipeDetailView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateRecipeDetailView(mCurrentPosition);
        }
    }

    public void updateRecipeDetailView(int position) {
        View v = getView();

        //need to get the correct recipe based off selection
        RelativeLayout recipe = (RelativeLayout) v;
        recipe.(SampleData.RecipeData[position]);
        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}
//shows all info about selected recipe