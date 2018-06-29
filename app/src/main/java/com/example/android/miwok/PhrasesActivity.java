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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<word> words = new ArrayList<word>();
        words.add(new word("Where are you going?","minto wuksus"));
        words.add(new word("What is your name?","tinnә oyaase'nә"));
        words.add(new word("My name is...","oyaaset michәksәs"));
        words.add(new word("How are you feeling?","michәksәs?"));
        words.add(new word("I'm feeling good.","kuchi achit"));
        words.add(new word("Are you coming?","әәnәs'aa?"));
        words.add(new word("Yes, i'm coming.","hәә' әәnәm"));
        words.add(new word("i'm coming.","әәnәm"));
        words.add(new word("Let's go.","yoowutis"));
        words.add(new word("Come here.","әnni'nem"));


//        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);
//
//        for (int index = 0; index <words.size(); index ++){
//
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(index));
//            rootView.addView(wordView);
//
//        }

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }

}
