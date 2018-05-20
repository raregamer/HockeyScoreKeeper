package com.example.samuel.hockeyscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int homeTeamScore = 0;
    int awayTeamScore = 0;

    int homeTeamShotsOnGoal = 0;
    int awayTeamShotsOnGoal = 0;

    boolean homeTeamPowerPlay = false;
    boolean awayTeamPowerPlay = true;


//    TextView homeTeamScore;
//    TextView awayTeamScore;
//
//    TextView homeTeamShotsOnGoal;
//    TextView awayTeamShotsOnGoal;
//
//    Button homeTeamGoalButton;
//    Button awayTeamGoalButton;
//
//    Button homeTeamShotsOnGoalButton;
//    Button awayTeamShotsOnGoalButton;
//
//    Button homeTeamPowerPlayButton;
//    Button awayTeamPowerPlayButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}
