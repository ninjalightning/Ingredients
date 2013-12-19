package com.ninjalightning.ingredients;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jacobelliott on 12/14/13.
 */
public class IngredientsAdapter extends ArrayAdapter<IngredientsData> {
    Context mContext;
    int mLayoutResourceId;
    IngredientsData mData[] = null;

    public IngredientsAdapter(Context context, int layoutResourceId, IngredientsData[] data){
        super(context,layoutResourceId,data);
        this.mContext = context;
        this.mLayoutResourceId = layoutResourceId;
        this.mData = data;

    }

    @Override
    public IngredientsData getItem(int position) {
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
            holder.nameView = (TextView) row.findViewById(R.id.ingredient);
            //holder.imageView = (ImageView) row.findViewById(R.id.imageView);
            // use setTag() to place (holder) object into inflated row
            row.setTag(holder);
        } else {
            // reassign holder object
            holder = (PlaceHolder) row.getTag();
        }
        // get data from array to reflect data
        IngredientsData ingredientsData = mData[position];
        // set view to reflect data we need to show
        holder.nameView.setText(ingredientsData.name);

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
//link Ingredients Fragment to Main Activity