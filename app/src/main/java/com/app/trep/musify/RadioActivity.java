package com.app.trep.musify;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RadioActivity extends AppCompatActivity {

    private ImageView playPauseBtn, nextBtn, previousBtn, radioIcon;
    private TextView radioName;
    RadioModel currentRadio;
    ArrayList<RadioModel> radioList;
    MediaPlayer mediaPlayer = MyMediaPlayer.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        playPauseBtn = findViewById(R.id.pause_play);
        nextBtn = findViewById(R.id.next);
        previousBtn = findViewById(R.id.previous);
        radioIcon = findViewById(R.id.music_icon_big);
        radioName = findViewById(R.id.song_title);

        radioList = new ArrayList<>();
        radioList.add(new RadioModel("FF","http://mp3.ffh.de/radioffh/hqlivestream.mp3"));
        radioList.add(new RadioModel("HIT RADIO FF","http://mp3.ffh.de/radiofth/hqlivestream.mp3"));



        setResourceWithMusic();
    }

    void setResourceWithMusic(){
        currentRadio  = radioList.get(0);
        radioName.setText(currentRadio.getRadioName());
        playPauseBtn.setOnClickListener(v -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
                playPauseBtn.setImageResource(R.drawable.ic_baseline_play_circle_outline_24);
                radioIcon.setRotation(0);
            }else{
                mediaPlayer.start();
                playPauseBtn.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24);
                radioIcon.setRotation(1);
            }
        });

        nextBtn.setOnClickListener(v -> {
            if(MyMediaPlayer.currentIndex == radioList.size()-1){
                MyMediaPlayer.currentIndex = 0;
            }else{
                MyMediaPlayer.currentIndex++;
            }
            setResourceWithMusic();
        });

        previousBtn.setOnClickListener(v -> {
            if(MyMediaPlayer.currentIndex == 0){
                MyMediaPlayer.currentIndex = radioList.size()-1;
            }else{
                MyMediaPlayer.currentIndex--;
            }
            setResourceWithMusic();
        });

        playRadio();

    }

    //write method to play radio music
    void playRadio(){
        try {
            mediaPlayer.setDataSource(currentRadio.getRadioUrl());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}