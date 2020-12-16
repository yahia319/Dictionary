package com.example.dictionary;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.SearchView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textViewLanguage1, textViewLanguage2, textViewReverse;
    SearchView searchView;
    myAdapter myAdapter;
    ArrayList<list_Item> Items;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewLanguage1 = findViewById(R.id.text_view_language_1);
        textViewLanguage2 = findViewById(R.id.text_view_language_2);
        textViewReverse = findViewById(R.id.text_view_reverse);

        textViewReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((textViewLanguage1.getText()).equals("English")) {
                    textViewLanguage1.setText("Arabic");
                    textViewLanguage2.setText("English");
                }//end if
                else {
                    textViewLanguage1.setText("English");
                    textViewLanguage2.setText("Arabic");
                }//end else
            }//end onClick

        });//end setOnClickListener


        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("myFile.txt")));
            String mLine;


            Items = new ArrayList<list_Item>();

            while ((mLine = reader.readLine()) != null) {
                String[] elements = mLine.split("#");
                Items.add(new list_Item(elements[0], elements[1]));
            }//end while

            myAdapter = new myAdapter(getApplicationContext(), Items);

            listView = findViewById(R.id.list_view);
            listView.setAdapter(myAdapter);

        }//end try

        catch (IOException e) {
            e.getMessage();
        }//end catch

        finally {
            //
            if (reader != null) {
                try {
                    reader.close();
                }//end try
                catch (IOException e) {
                    e.getMessage();
                }//end catch

            }//end if

        }//end finally

        searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO: filter list using query
                android.widget.Toast.makeText(MainActivity.this, "query", android.widget.Toast.LENGTH_SHORT).show();
                myAdapter.getFilter().filter(query);
                // update adapter using list then refresh it.
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


    }// end onCreate

    public class myAdapter extends ArrayAdapter<list_Item> {

        ArrayList<list_Item> Items = new ArrayList<list_Item>();

        ArrayList<list_Item>  filteredData;

        public myAdapter(Context context, ArrayList<list_Item> Items) {
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

                    ArrayList<list_Item> elements = new ArrayList();

                    FilterResults results = new FilterResults();

                    if (constraint == null || constraint.length() == 0) {
                        results.values = Items;
                        results.count = Items.size();
                    } else {
                        ArrayList<list_Item>  filterResultsData = new   ArrayList<list_Item> ();

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
                        for (list_Item element : Items) {
                            if ((element.getNameEng().toLowerCase().contains(constraint))) {
                                filterResultsData.add(element);
                            } else {
                                if (element.getNameAr().toLowerCase().contains(constraint)) {
                                    filterResultsData.add(element);
                                }
                            }
                        }

                        results.values = filterResultsData;
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
                    filteredData = (ArrayList<list_Item> ) results.values;
                    notifyDataSetChanged();
                }
            };
        }

        @Override
        public int getCount() {
            return filteredData.size();
        }//end getCount

        @Override
        public list_Item getItem(int position) {
            return filteredData.get(position);
        }//end getItem


        @Override
        public long getItemId(int position) {
            return position;
        }//end getItemId

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater lInflater = getLayoutInflater();
            View view1 = lInflater.inflate(R.layout.row_view, null);

            TextView nameEng = view1.findViewById(R.id.name_eng);
            nameEng.setText(filteredData.get(i).getNameEng());

            TextView nameAr = view1.findViewById(R.id.name_ar);
            nameAr.setText(filteredData.get(i).getNameAr());

            return view1;
        }//end getView


    }//end myAdapter

}//end class