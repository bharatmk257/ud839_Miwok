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

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class NumbersActivity extends AppCompatActivity {

private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> Words = new ArrayList<Word>();
        Words.add(new Word("one","lutti",R.drawable.number_one,R.raw.number_one));
        Words.add(new Word("two","otiiko",R.drawable.number_two,R.raw.number_two));
        Words.add(new Word("three","tolookosu",R.drawable.number_three,R.raw.number_three));
        Words.add(new Word("four","oyyiisa",R.drawable.number_four,R.raw.number_four));
        Words.add(new Word("five","massokka",R.drawable.number_five,R.raw.number_five));
        Words.add(new Word("six","temmokka",R.drawable.number_six,R.raw.number_six));
        Words.add(new Word("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        Words.add(new Word("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        Words.add(new Word("nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        Words.add(new Word("ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));


//        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);
//
//        for (int index = 0; index <Words.size(); index ++){
//
//            TextView wordView = new TextView(this);
//            wordView.setText(Words.get(index));
//            rootView.addView(wordView);
//
//        }

        WordAdapter adapter = new WordAdapter(this, Words,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Word word = Words.get(position);

                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());

                mMediaPlayer.start();
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
