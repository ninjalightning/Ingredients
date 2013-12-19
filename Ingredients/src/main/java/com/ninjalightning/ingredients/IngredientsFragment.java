package com.ninjalightning.ingredients;

import android.app.Activity;
import android.app.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by jacobelliott on 12/14/13.
 */
public class IngredientsFragment extends Fragment {

    ListView mListView;
    Button mSearchButton;
    OnButtonClickedListener buttonCallback;

    public interface OnButtonClickedListener {
        public void onButtonClicked();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ingredients_fragment, container, false);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            buttonCallback = (OnButtonClickedListener) activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.ingredients);

         IngredientsAdapter ingredientsAdapter = new IngredientsAdapter(getActivity(), R.layout.ingredient_row, SampleData.ingredientsDatas);


        mListView = (ListView) view.findViewById(R.id.ingredient_list);
        if(mListView != null) {
            mListView.setAdapter (ingredientsAdapter);
        }

        mSearchButton = (Button) view.findViewById(R.id.search_button);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonCallback.onButtonClicked();
            }
        });
    }


}
        //maintains a ListView of available ingredients