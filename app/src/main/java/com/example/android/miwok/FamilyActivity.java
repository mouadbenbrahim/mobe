package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_listview);

        // ArrayList<String> words = new ArrayList<String>();
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("father","xone"));
        words.add(new Word("mother","xtwo"));
        words.add(new Word("son","xthree"));
        words.add(new Word("daughter","xfour"));
        words.add(new Word("older brother","xfive"));
        words.add(new Word("younger brother","xsix"));
        words.add(new Word("older sister","xseven"));
        words.add(new Word("younger sister","xeight"));
        words.add(new Word("grandmother","xnine"));
        words.add(new Word("grandfather","xten"));

        String wSize = Integer.toString(words.size()); // Convert int to String

        Log.v("words.size: ", wSize);


        //ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
        WordAdapter adapter = new WordAdapter(this, words,R.color.category_family);


        ListView listView = (ListView) findViewById(R.id.word_list_id);
        //GridView listView = (GridView) findViewById(R.id.list);

        //listView.setAdapter(itemsAdapter);
        listView.setAdapter(adapter);

    }
}
