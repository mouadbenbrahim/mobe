/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);


        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


    }
}


/*

        //actionBar = getActionBar();
        //this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView numbers = (TextView) findViewById(R.id.numbers);
        TextView colors = (TextView) findViewById(R.id.colors);
        TextView family = (TextView) findViewById(R.id.family);
        TextView phrases = (TextView) findViewById(R.id.phrases);


        //doing it through the new class MyClickListener
        //MyClickListener clickListener = new MyClickListener();
        //numbers.setOnClickListener(clickListener);

        //doing it through inline code
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(myintent);
                //Toast.makeText(view.getContext(),"Toas.makeText : mon message: numbers ", Toast.LENGTH_SHORT).show();
            }
        });

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(myintent);
                //Toast.makeText(view.getContext(),"Toas.makeText : mon message: colors", Toast.LENGTH_SHORT).show();
            }
        });

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(myintent);
                //Toast.makeText(view.getContext(),"Toas.makeText : mon message: family", Toast.LENGTH_SHORT).show();
            }
        });

        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(myintent);
                //Toast.makeText(view.getContext(),"Toas.makeText : mon message: phrases", Toast.LENGTH_SHORT).show();
            }
        });


    }


    public void openNumbersList(View view) {
        Intent i = new Intent(this, NumbersActivity.class);
        startActivity(i);
    }
*/