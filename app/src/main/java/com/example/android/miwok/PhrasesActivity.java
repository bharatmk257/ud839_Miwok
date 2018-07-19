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

public class PhrasesActivity extends AppCompatActivity {

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
        Words.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_what_is_your_name));
        Words.add(new Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        Words.add(new Word("My name is...","oyaaset michәksәs",R.raw.phrase_my_name_is));
        Words.add(new Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        Words.add(new Word("I'm feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        Words.add(new Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        Words.add(new Word("Yes, i'm coming.","hәә' әәnәm",R.raw.phrase_yes_im_coming));
        Words.add(new Word("i'm coming.","әәnәm",R.raw.phrase_im_coming));
        Words.add(new Word("Let's go.","yoowutis",R.raw.phrase_lets_go));
        Words.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));


//        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);
//
//        for (int index = 0; index <Words.size(); index ++){
//
//            TextView wordView = new TextView(this);
//            wordView.setText(Words.get(index));
//            rootView.addView(wordView);
//
//        }

        WordAdapter adapter = new WordAdapter(this, Words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Word word = Words.get(position);

                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());

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
