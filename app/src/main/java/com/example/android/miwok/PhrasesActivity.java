package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_listview);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Where are you going?","xone"));
        words.add(new Word("What is your name?","xtwo"));
        words.add(new Word("My name is...","xthree"));
        words.add(new Word("How are you feeling?","xfour"));
        words.add(new Word("I’m feeling good.","xfive"));
        words.add(new Word("Are you coming?","xsix"));
        words.add(new Word("Yes, I’m comin","xseven"));
        words.add(new Word("I’m coming.","xeight"));
        words.add(new Word("Let’s go.","xeight"));
        words.add(new Word("Come here.","xeight"));


        String wSize = Integer.toString(words.size()); // Convert int to String
        Log.v("words.size: ", wSize);

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.word_list_id);
        listView.setAdapter(adapter);

    }
}