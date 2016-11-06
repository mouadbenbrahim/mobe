package com.example.android.miwok;

import android.view.View;
import android.widget.Toast;

/**
 * Created by mouad on 25/10/2016.
 */

public class MyClickListener implements View.OnClickListener{

    @Override
    public void onClick(View view){
        Toast.makeText(view.getContext(), "My toast message", Toast.LENGTH_SHORT).show();
    }

}
