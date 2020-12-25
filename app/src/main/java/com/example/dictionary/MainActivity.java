package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.widget.SearchView;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textViewLanguage1, textViewLanguage2, textViewReverse;
    SearchView searchView;
    MyAdapter myAdapter;
    ArrayList<List_item> Items = new ArrayList<List_item>();
    ListView listView;
    boolean frenchQuery = true;

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
                    searchView.setQueryHint("Type An Arabic Text...");
                    frenchQuery = false;
                }//end if
                else {
                    textViewLanguage1.setText("French");
                    textViewLanguage2.setText("Arabic");
                    searchView.setQueryHint("Type a French Text...");
                    frenchQuery = true;
                }//end else

            }//end onClick

        });//end setOnClickListener

        searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Items.clear();
                MyTask myTask = new MyTask();
                myTask.execute(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                return false;
            }
        });


    }// end onCreate


    private class MyTask extends AsyncTask<String, String, List<Univ>> {

        @Override
        protected List<Univ> doInBackground(String... strings) {
            List<Univ> myList;
            if (frenchQuery) {

                myList = UnivRoomDb.getInstance(getApplicationContext()).univDao().getFrenchTranslate(strings[0]);

            } else {

                myList = UnivRoomDb.getInstance(getApplicationContext()).univDao().getArabicTranslate(strings[0]);

            }

            return myList;
        }

        @Override
        protected void onPostExecute(List<Univ> univs) {
            super.onPostExecute(univs);

            if (univs.size() == 0) {

                Toast.makeText(getApplicationContext(), "No Item Found", Toast.LENGTH_SHORT).show();

            } else {

                listView = findViewById(R.id.list_view);

                for (int index = 0; index < univs.size(); index++) {

                    Items.add(new List_item(univs.get(index).getFrench(), univs.get(index).getArabic()));
                }

                myAdapter = new MyAdapter(getApplicationContext(), Items);


                listView.setAdapter(myAdapter);

            }
        }

    }

}//end class