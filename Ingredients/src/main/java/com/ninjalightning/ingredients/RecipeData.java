package com.ninjalightning.ingredients;

import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by jacobelliott on 12/14/13.
 */
public class RecipeData {

    String ingredientList;
    String Directions;
    String cookingTime;
    String imageName;
    String recipeTitle;

    public RecipeData(String ingredientList, String directions, String cookingTime, String imageName, String recipeTitle) {
        this.ingredientList = ingredientList;
        Directions = directions;
        this.cookingTime = cookingTime;
        this.imageName = imageName;
        this.recipeTitle = recipeTitle;
    }
}
//stores recipes