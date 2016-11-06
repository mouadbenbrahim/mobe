package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_listview);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("red","xone"));
        words.add(new Word("green","xtwo"));
        words.add(new Word("brown","xthree"));
        words.add(new Word("gray","xfour"));
        words.add(new Word("black","xfive"));
        words.add(new Word("white","xsix"));
        words.add(new Word("dusty yellow","xseven"));
        words.add(new Word("mustard yellow","xeight"));

        String wSize = Integer.toString(words.size()); // Convert int to String
        Log.v("words.size: ", wSize);

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.word_list_id);
        listView.setAdapter(adapter);

    }
}
