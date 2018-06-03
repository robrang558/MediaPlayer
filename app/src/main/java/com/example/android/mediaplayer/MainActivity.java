package com.example.android.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button play, pause, reset;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play =  findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        reset = findViewById(R.id.reset);

        mediaPlayer = MediaPlayer.create(this, R.raw.cherryohbaby);
        pause.setEnabled(false);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Playing", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                pause.setEnabled(true);
                play.setEnabled(false);
                reset.setEnabled(true);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Pausing",Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                pause.setEnabled(false);
                play.setEnabled(true);
                reset.setEnabled(true);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Reset",Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                pause.setEnabled(false);
                play.setEnabled(true);
                reset.setEnabled(false);
            }
        });
    }
}
