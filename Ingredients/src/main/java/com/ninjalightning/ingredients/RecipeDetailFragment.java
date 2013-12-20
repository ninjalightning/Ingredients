package com.ninjalightning.ingredients;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

        mCurrentPosition = position;


//      make an object called detailedRecipe of the data type RecipeData and assign its value through
//      SampleData Class to a position in the RecipeData Array
        RecipeData detailedRecipe = SampleData.recipeData[position];

//      used v as getView( )
        View v = getView();

//     Make a TextView type object called whateverImReferringToView and assign its value using v.findViewById to refer to id'd TextView sections of the layout .xml
       TextView titleView = (TextView) v.findViewById(R.id.title);
//     whateverImReferringToView calls the setText method on the detailedRecipe object
       titleView.setText(detailedRecipe.recipeTitle);


//     set up a TextView object called whateverImReferringToView and assign its value using v.findViewById to refer to id'd TextView sections of the layout .xml
       TextView cookingTimeView = (TextView) v.findViewById(R.id.cooking_time);
//     whateverImReferringToView calls the setText method on the detailedRecipe object
       cookingTimeView.setText(detailedRecipe.cookingTime);


//     set up a TextView object called whateverImReferringToView and assign its value using v.findViewById to refer to id'd TextView sections of the layout .xml
       TextView ingredientsListView = (TextView) v.findViewById(R.id.ingredients_list);
//     whateverImReferringToView calls the setText method on the detailedRecipe object
       ingredientsListView.setText(detailedRecipe.ingredientList);


//     set up a TextView object called whateverImReferringToView and assign its value using v.findViewById to refer to id'd TextView sections of the layout .xml
       TextView directionsView = (TextView) v.findViewById(R.id.directions_view);
//     whateverImReferringToView calls the setText method on the detailedRecipe object
       directionsView.setText(detailedRecipe.directions);
}

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}
//shows all info about selected recipe