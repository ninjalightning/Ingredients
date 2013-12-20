package com.ninjalightning.ingredients;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity implements IngredientsFragment.OnButtonClickedListener, RecipeListFragment.OnRecipeSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new IngredientsFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onRecipeSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment


        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();

        Bundle args = new Bundle();
        args.putInt(RecipeDetailFragment.ARG_POSITION, position);
        recipeDetailFragment.setArguments(args);


        getFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, recipeDetailFragment)
                .commit();


    }

    @Override
    public void onButtonClicked() {
        RecipeListFragment recipeListFragment = new RecipeListFragment();
        getFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, recipeListFragment)
                .commit();
    }
}
