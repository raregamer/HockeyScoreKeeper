package com.example.samuel.hockeyscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation slideUpAnimation;
    Animation slideDownAnimation;

    int homeTeamScore = 0;
    int awayTeamScore = 0;

    int homeTeamShotsOnGoal = 0;
    int awayTeamShotsOnGoal = 0;

    int period = 1;

    TextView periodLabel;
    Button periodButton;

    Button newGame;

    boolean homeTeamPowerPlay = false;
    boolean awayTeamPowerPlay = false;


    TextView homeTeamScoreBoardLabel;
    TextView awayTeamScoreBoardLabel;
//
    TextView homeTeamShotsOnGoalLabel;
    TextView awayTeamShotsOnGoalLabel;


//
    Button homeTeamGoalButton;
    Button awayTeamGoalButton;


//
    Button homeTeamShotsOnGoalButton;
    Button awayTeamShotsOnGoalButton;
//
    Button homeTeamPowerPlayButton;
    Button awayTeamPowerPlayButton;

    TextView homePowerPlayLabel;
    TextView awayPowerPlayLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Score Boards for home and away teams
        homeTeamScoreBoardLabel = findViewById(R.id.homeTeamScore);
        awayTeamScoreBoardLabel = findViewById(R.id.awayTeamScore);

        //Shots on Goal Label home and away teams
        homeTeamShotsOnGoalLabel = findViewById(R.id.homeShotsOnGoalAmount);
        awayTeamShotsOnGoalLabel = findViewById(R.id.awayShotsOnGoalAmount);



        //home team goal button and update scoreboard
        homeTeamGoalButton = findViewById(R.id.homeGoalButton);
        homeTeamGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeTeamScore += 1;
                scoreBoardGoalUpdate(homeTeamScoreBoardLabel, homeTeamScore);
            }
        });

        //away team goal button and update scoreboard
        awayTeamGoalButton = findViewById(R.id.awayGoalButton);
        awayTeamGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                awayTeamScore += 1;
                scoreBoardGoalUpdate(awayTeamScoreBoardLabel, awayTeamScore);
            }
        });

        // home team shots on goal button and display
        homeTeamShotsOnGoalButton = findViewById(R.id.homeShotsOnGoalButton);
        homeTeamShotsOnGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeTeamShotsOnGoal += 1;
                scoreBoardShotsUpdate(homeTeamShotsOnGoalLabel, homeTeamShotsOnGoal);
            }
        });

        // away team shots on goal button and display
        awayTeamShotsOnGoalButton = findViewById(R.id.awayShotsOnGoalButton);
        awayTeamShotsOnGoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                awayTeamShotsOnGoal += 1;
                scoreBoardShotsUpdate(awayTeamShotsOnGoalLabel, awayTeamShotsOnGoal);
            }
        });


        //period logic and label
        periodLabel = findViewById(R.id.periodLabel);
        periodButton = findViewById(R.id.period);

        periodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (period < 4) {
                    period++;
                } else {
                    period = 1;
                }

                if (period <= 3) {
                    periodLabel.setText(String.valueOf(period));

                } else {
                    periodLabel.setText("OT");
                }

            }
        });

        newGame = findViewById(R.id.newGame);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetNewGame();

            }
        });


        //Animation for power play setup.
        slideUpAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up_animation);

        slideDownAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down_animation);


        homePowerPlayLabel = findViewById(R.id.homePowerPlayLabel);
        homeTeamPowerPlayButton = findViewById(R.id.homePowerPlayButton);
        homeTeamPowerPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!homeTeamPowerPlay) {
                    homeTeamPowerPlay = true;
                    startSlideUpAnimation(homePowerPlayLabel);
                } else {
                    homeTeamPowerPlay = false;
                    homePowerPlayLabel.setVisibility(View.INVISIBLE);
                }
            }
        });


        awayPowerPlayLabel = findViewById(R.id.awayPowerPlayLabel);
        awayTeamPowerPlayButton = findViewById(R.id.awayPowerPlayButton);
        awayTeamPowerPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!awayTeamPowerPlay) {
                    awayTeamPowerPlay = true;
                    startSlideUpAnimation(awayPowerPlayLabel);
                } else {
                    awayTeamPowerPlay = false;
                    awayPowerPlayLabel.setVisibility(View.INVISIBLE);
                }
            }
        });




    }

    public void startSlideUpAnimation(TextView teamPowerPlay){
        teamPowerPlay.setVisibility(View.VISIBLE);
        teamPowerPlay.startAnimation(slideUpAnimation);
    }

    //scoreboard(goals) update method for home or away team.
    public void scoreBoardGoalUpdate(TextView teamScoreBoard, int teamScore){

        teamScoreBoard.setText(String.valueOf(teamScore));

    }


    //scoreboard(shots on goal) update method for home or away team.
    public void scoreBoardShotsUpdate(TextView teamShotsOnGoalLabel, int shotsOnGoalAmount){

        teamShotsOnGoalLabel.setText(String.valueOf(shotsOnGoalAmount));

    }

    public void resetNewGame() {
        homeTeamScore = 0;
        awayTeamScore = 0;
        scoreBoardGoalUpdate(homeTeamScoreBoardLabel,homeTeamScore);
        scoreBoardGoalUpdate(awayTeamScoreBoardLabel,awayTeamScore);

        homeTeamShotsOnGoal = 0;
        awayTeamShotsOnGoal = 0;
        scoreBoardShotsUpdate(homeTeamShotsOnGoalLabel,homeTeamShotsOnGoal);
        scoreBoardShotsUpdate(awayTeamShotsOnGoalLabel, awayTeamShotsOnGoal);

        period = 1;
        periodLabel.setText(String.valueOf(period));

        homeTeamPowerPlay = false;
        homePowerPlayLabel.setVisibility(View.INVISIBLE);
        awayTeamPowerPlay = false;
        awayPowerPlayLabel.setVisibility(View.INVISIBLE);
    }




}
