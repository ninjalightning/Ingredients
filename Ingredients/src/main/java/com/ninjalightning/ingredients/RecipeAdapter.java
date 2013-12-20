package com.ninjalightning.ingredients;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by jacobelliott on 12/14/13.
 */
public class RecipeAdapter extends ArrayAdapter<RecipeData> {
    Context mContext;
    int mLayoutResourceId;
    RecipeData mData[] = null;

    public RecipeAdapter(Context context, int layoutResourceId, RecipeData[] data){
        super(context,layoutResourceId,data);
        this.mContext = context;
        this.mLayoutResourceId = layoutResourceId;
        this.mData = data;

    }

    @Override
    public RecipeData getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        PlaceHolder holder = null;

        if(row == null){
            // inflate a new row
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId, parent, false);
            // construct an object that is an instance of PlaceHolder class
            holder = new PlaceHolder();
            // assign view location to object created above
            holder.nameView = (TextView) row.findViewById(R.id.recipe_title);
            //holder.imageView = (ImageView) row.findViewById(R.id.imageView);
            // use setTag() to place (holder) object into inflated row
            row.setTag(holder);
        } else {
            // reassign holder object
            holder = (PlaceHolder) row.getTag();
        }
        // get data from array to reflect data
        RecipeData recipeData = mData[position];
        // set view to reflect data we need to show
        holder.nameView.setText(recipeData.recipeTitle);

        //set the image for this particular row.
        //int resId = mContext.getResources().getIdentifier(ingredientsData.name, "drawable", mContext.getPackageName());
        //holder.imageView.setImageResource(resId);

        return row;
    }

    static class PlaceHolder {
        TextView nameView;
        //ImageView imageView;
    }
}

//link Recipe Fragment to Main Activity