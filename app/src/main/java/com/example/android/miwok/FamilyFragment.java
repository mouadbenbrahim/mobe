package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {

    private MediaPlayer mPlayer;
    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

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
                    mPlayer.seekTo(0);
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    mPlayer.pause();
                    mPlayer.seekTo(0);
                    break;
            }
        }
    };


    public FamilyFragment() {
        // Required empty public constructor
    }

    private ArrayList<Word> loadWords(){
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
        return words;
    }


    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_listview,container,false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Word> words;  //declared final so it can be used inside interface SetOnclikListener
        words = loadWords();

        //WordAdapter is a custom class from interface/class: ArrayAdapter:
        // To build dynamically a view with data: words=data, the view layout used is defined on the WordAdapter class = list_item.xml
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_family);

        //ListView listView2 = (ListView) rootView;
        ListView listView = (ListView) rootView.findViewById(R.id.word_list_id);
        listView.setAdapter(adapter); //attach the adapter to the listview

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(mAudioFocusListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mPlayer = MediaPlayer.create(getActivity(), words.get(position).getmAudioResourceId());
                    mPlayer.start();
                    mPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });


        return rootView;
    }

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

            mAudioManager.abandonAudioFocus(mAudioFocusListener);

        }

    }


}


//String wSize = Integer.toString(words.size()); // Convert int to String
//Log.v("words.size: ", wSize);
