/*
    https://github.com/manask88/wiki/wiki/Speech-Recognition-Tutorial---LightBulb-Example
    me@manuelnakamurakare.com
    manuel@handsfreelearning.com
*/

package com.example.manuel.lightbulb;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements SpeechRecognizerManager.OnResultListener {

    private final String TAG = getClass().getSimpleName();
    private ImageView lightBulbImageView;
    private SpeechRecognizerManager mSpeechRecognizerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightBulbImageView = (ImageView) findViewById(R.id.lightBulbImageView);
        mSpeechRecognizerManager = new SpeechRecognizerManager(this);
        mSpeechRecognizerManager.setOnResultListener(this);
    }

    private void hideLightBulb(){
        lightBulbImageView.setVisibility(View.INVISIBLE);
    }

    private void showLightBulb(){
        lightBulbImageView.setVisibility(View.VISIBLE);
    }

    private void turnYellow(){
        lightBulbImageView.setImageResource(R.drawable.yellow);
        lightBulbImageView.setVisibility(View.VISIBLE);
    }

    private void turnBlue(){
        lightBulbImageView.setImageResource(R.drawable.blue);
        lightBulbImageView.setVisibility(View.VISIBLE);
    }

    private void turnPink(){
        lightBulbImageView.setImageResource(R.drawable.pink);
        lightBulbImageView.setVisibility(View.VISIBLE);
    }

    @Override
    public void OnResult(ArrayList<String> commands) {
        for (String command : commands) {
            if (command.contains("turn pink")) {
                turnPink();
                break;
            } else if (command.contains("turn blue")) {
                turnBlue();
                break;
            } else if (command.contains("turn yellow")) {
                turnYellow();
                break;
            } else if (command.contains("hide")) {
                hideLightBulb();
                break;
            } else {
                System.out.println("Command not recognized.");
            }
        }
    }
}
