package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            Toast.makeText(NumbersActivity.this,"Fin music",Toast.LENGTH_SHORT).show();
            releaseMediaPlayer();
        }
    };

    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mAudioFocusListener = new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(int focusChange) {

            switch (focusChange) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    mPlayer.start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    mPlayer.stop();
                    releaseMediaPlayer();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    mPlayer.pause();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    mPlayer.pause();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_listview); //word_listview is a ListView Layout (main container: empty)




        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<Word>(); //declared final so it can be used inside interface SetOnclikListener

        words.add(new Word("one", "xone", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "xtwo", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "xthree", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "xfour", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "xfive", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "xsix", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "xseven", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "xeight", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "xnine", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "xten", R.drawable.number_ten, R.raw.number_ten));

        String wSize = Integer.toString(words.size()); // Convert int to String
        Log.v("words.size: ", wSize);

        //WordAdapter is a custom class from interface/class: ArrayAdapter:
        // To build dynamically a view with data: words=data, the view layout used is defined on the WordAdapter class = list_item.xml
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);


        ListView listView = (ListView) findViewById(R.id.word_list_id);
        listView.setAdapter(adapter); //attach the adapter to the listview

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                releaseMediaPlayer();
                mAudioManager.requestAudioFocus(mAudioFocusListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                mPlayer = MediaPlayer.create(NumbersActivity.this, words.get(position).getmAudioResourceId());
                mPlayer.start();

                mPlayer.setOnCompletionListener(mCompletionListener);

            }
        });

    } //OnCreate

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**

     * Clean up the media player by releasing its resources.

     */

    private void releaseMediaPlayer() {

        // If the media player is not null, then it may be currently playing a sound.

        if (mPlayer != null) {

            // Regardless of the current state of the media player, release its resources

            // because we no longer need it.

            mPlayer.release();



            // Set the media player back to null. For our code, we've decided that

            // setting the media player to null is an easy way to tell that the media player

            // is not configured to play an audio file at the moment.

            mPlayer = null;

        }

    }

} //Class end




/// CODES OTHER
// Arrays
        /*
        String [] words = new String[10];
        words[0]="one";
        words[1]="two";
        words[2]="three";
        */

//words.add("two");
//words.add("three");

// Convert int to String
// String wSize = "" + words.size();


// ArrayList<String> words = new ArrayList<String>();


//Log.v("NumbersActivity", "index 0 is " + words[0]);
//Log.v("NumbersActivity", "words index 0 is " + words.get(0));


//while loop
        /*
        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);
        int index = 0;
        while (index < words.size() ){
            TextView wordView = new TextView(this);
            wordView.setText(words.get(index));
            rootView.addView(wordView);
            index++;
        }
        */

//for loop
        /*
        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);
        for (int index = 0; index < words.size(); index++){
            TextView wordView = new TextView(this);
            wordView.setText(words.get(index));
            rootView.addView(wordView);
        }
        */

//ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);

//GridView listView = (GridView) findViewById(R.id.list);