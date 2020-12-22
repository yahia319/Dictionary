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
                    searchView.setQueryHint("Arabic...");
                }//end if
                else {
                    textViewLanguage1.setText("French");
                    textViewLanguage2.setText("Arabic");
                    searchView.setQueryHint("French...");
                }//end else
            }//end onClick

        });//end setOnClickListener

        searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Toast.makeText(MainActivity.this, "" + query, Toast.LENGTH_SHORT).show();

                MyTask myTask = new MyTask();
                myTask.execute(query);
                listView = findViewById(R.id.list_view);
                listView.setAdapter(myAdapter);


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });



    }// end onCreate



private  class  MyTask extends AsyncTask<String,String,List<Univ>>{
    @Override
    protected List<Univ> doInBackground(String... strings) {

        List<Univ> mylist =  UnivRoomDb.getInstance(getApplicationContext()).univDao().getArabicTranslate(strings[0]);

        return mylist;
    }

    @Override
    protected void onPostExecute(List<Univ> univs) {
        super.onPostExecute(univs);
        Items.add(new List_item(univs.get(0).getFrench(),univs.get(0).getArabic()));
        myAdapter = new MyAdapter(getApplicationContext(),Items);
    }
}
}//end class