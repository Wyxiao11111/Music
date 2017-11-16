package com.example.wyx.music;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import java.io.IOException;

public class MusicActivity extends Activity {

    private MediaPlayer mp = null;

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
