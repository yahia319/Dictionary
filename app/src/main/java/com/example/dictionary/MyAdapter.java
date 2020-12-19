package com.example.dictionary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<List_item> {

    ArrayList<List_item> Items = new ArrayList<List_item>();

    ArrayList<List_item>  filteredData;

    public MyAdapter(Context context, ArrayList<List_item> Items) {
        super(context, 0);
        this.Items = Items;
        this.filteredData = Items;
    }//end const

    @NonNull
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults results = new FilterResults();

                if (constraint == null || constraint.length() == 0) {
                    results.values = Items;
                    results.count = Items.size();
                } else {
                    ArrayList<List_item>  filterResultsData = new   ArrayList<List_item> ();

                       /* for(ArrayList<list_Item> data : Items)
                        {
                            //In this loop, you'll filter through originalData and compare each item to charSequence.
                            //If you find a match, add it to your new ArrayList
                            //I'm not sure how you're going to do comparison, so you'll need to fill out this conditional
                            if(data. data matches your filter criteria)
                            {
                                filterResultsData.add(data);
                            }
                        }*/

                    //String filterParent = constraint.toString().toLowerCase();
                    for (List_item element : Items) {
                        if ((element.getNameEng().toLowerCase().contains(constraint))) {
                            filterResultsData.add(element);
                        } else {
                            if (element.getNameAr().toLowerCase().contains(constraint)) {
                                filterResultsData.add(element);
                            }
                        }



                           }results.values = filterResultsData;
                    results.count = filterResultsData.size();
                }//end else

                // FilterResults results = new FilterResults();

                // results.count = elements.size();
                // results.values = elements;

                // results.values = filterResultsData;
                // results.count = filteredResultsData.size();

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                  /*  clear();
                    System.out.println(results.values.toString());
                    addAll((ArrayList<list_Item>) results.values);
                    notifyDataSetChanged();*/
                filteredData = (ArrayList<List_item> ) results.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getCount() {
        return filteredData.size();
    }//end getCount

    @Override
    public List_item getItem(int position) {
        return filteredData.get(position);
    }//end getItem


    @Override
    public long getItemId(int position) {
        return position;
    }//end getItemId

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater lInflater = LayoutInflater.from(getContext());
        View view1 = lInflater.inflate(R.layout.row_view, null);

        TextView nameEng = view1.findViewById(R.id.name_eng);
        nameEng.setText(filteredData.get(i).getNameEng());

        TextView nameAr = view1.findViewById(R.id.name_ar);
        nameAr.setText(filteredData.get(i).getNameAr());

        return view1;
    }//end getView


}//end myAdapter