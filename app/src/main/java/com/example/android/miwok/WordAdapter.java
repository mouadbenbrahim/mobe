package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


/**
 * Created by mouad on 28/10/2016.
 */
;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorId;
    //private MediaPlayer player1;

    public WordAdapter(Activity context, ArrayList<Word> words, int activityColorId){
        super(context, 0, words);
        mColorId = activityColorId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);

        TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.default_text_view);
        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.miwork_text_view);
        ImageView miworkImage = (ImageView) listItemView.findViewById(R.id.miwok_image_view) ;
        //Button playbutton = (Button) listItemView.findViewById(R.id.play_button);

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorId);
        textContainer.setBackgroundColor(color);


        defaultTranslation.setText(currentWord.getmDefaultTranslation());
        //defaultTranslation.setBackgroundColor(mColorId);
        miwokTranslation.setText(currentWord.getmMiwokTranslation());

        if (currentWord.hasImage()) {
            miworkImage.setImageResource(currentWord.getmImageResourceId());
        }
        else {
            miworkImage.setVisibility(View.GONE);
        }

        //player1 = MediaPlayer.create(this.getContext(), currentWord.getmAudioResourceId());

        //listItemView.set

/*        playbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                player1.start();
            }
        });*/


        return listItemView;

        //return super.getView(position, convertView, parent);

    }

}
