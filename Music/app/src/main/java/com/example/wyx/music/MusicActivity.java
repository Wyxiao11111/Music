package com.example.wyx.music;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;

public class MusicActivity extends Activity {

    private MediaPlayer mp = null;
    private String [] data={"song1","song2","song3","song4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        findViewById(R.id.btnPlaySong).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mp != null){
                    mp.start();
                }

            }
        });

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(
                MusicActivity.this, android.R.layout.simple_list_item_1,
                data);
        ListView listView = findViewById(R.id.list_item);
        listView.setAdapter(adapter);


    }

    @Override
    protected void onResume() {

        mp = MediaPlayer.create(this,R.raw.song);

        try {
            mp.prepare();
        } catch (IllegalStateException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.onResume();
    }

    @Override
    protected void onPause() {

        if(mp != null){
            mp.release();
        }

        super.onPause();
    }
}
