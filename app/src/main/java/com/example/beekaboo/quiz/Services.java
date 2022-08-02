package com.example.beekaboo.quiz;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class Services extends Service {

    private MediaPlayer mMediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
        mMediaPlayer.start();
        mMediaPlayer.setLooping(true);
        return null;
    }

    public void onCreate(){

        mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
        mMediaPlayer.start();
        mMediaPlayer.setLooping(true);
    }

    public void onStart(Intent intent, int startid){
        mMediaPlayer.start();

    }

    public void onDestroy(){
        Toast.makeText(Services.this, "Stopped...", Toast.LENGTH_SHORT).show();
        mMediaPlayer.stop();

    }
}
