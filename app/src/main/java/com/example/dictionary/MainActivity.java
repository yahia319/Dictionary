package com.example.dictionary;


import androidx.appcompat.app.AppCompatActivity;

import android.widget.SearchView;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textViewLanguage1, textViewLanguage2, textViewReverse;
    SearchView searchView;
    MyAdapter myAdapter;
    ArrayList<List_item> Items;
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
                if ((textViewLanguage1.getText()).equals("French")) {
                    textViewLanguage1.setText("Arabic");
                    textViewLanguage2.setText("French");
                    searchView.setQueryHint("French...");
                }//end if
                else {
                    textViewLanguage1.setText("French");
                    textViewLanguage2.setText("Arabic");
                    searchView.setQueryHint("Arabic...");
                }//end else
            }//end onClick

        });//end setOnClickListener

        fileReader("myFile.txt");

        searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO: filter list using query
                android.widget.Toast.makeText(MainActivity.this, ""+query, android.widget.Toast.LENGTH_SHORT).show();
                myAdapter.getFilter().filter(query);
                // update adapter using list then refresh it.
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.getFilter().filter(newText);
                return false;
            }
        });


    }// end onCreate

    public void fileReader(String file){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open(""+file)));
            String mLine;


            Items = new ArrayList<List_item>();

            while ((mLine = reader.readLine()) != null) {
                String[] elements = mLine.split("#");
                Items.add(new List_item(elements[0], elements[1]));
            }//end while

            myAdapter = new MyAdapter(getApplicationContext(), Items);

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
    }


}//end class