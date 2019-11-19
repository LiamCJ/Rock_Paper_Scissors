package com.icebox.rock_paper_scissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ImageView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView outcome = findViewById(R.id.outcome);
    ImageView playerImage = findViewById(R.id.player_view);
    ImageView comImage = findViewById(R.id.cpu_view);
    String playerOutput = "logic" , comOutput = "logic";
    String[] comHand = {"rock", "paper", "scissors"};
    boolean chosen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRockClick (View view) {
        chosen = true;
        playerOutput = "rock";
        playerImage.setImageResource(R.mipmap.rock);
    }

    public void onPaperClick (View view) {
        chosen = true;
        playerOutput = "paper";
        playerImage.setImageResource(R.mipmap.paper);
    }

    public void onScissClick (View view) {
        chosen = true;
        playerOutput = "scissors";
        playerImage.setImageResource(R.mipmap.scissors);
    }

    public void winner () {
        if (playerOutput.equals(comOutput) ) { //if the users input is the same as the "comOutput" line 14 will take place
            outcome.setText("IT IS A TIE!"); // displays "IT IS A TIE!"

        } else if ( // if the the following conditions occur the user wins and line 21 will take place
                (playerOutput.equals("rock") && comOutput.equals("scissors") ) ||
                        (playerOutput.equals("paper") && comOutput.equals("rock") ) ||
                        (playerOutput.equals("scissors") && comOutput.equals("paper") )
        ) {
            outcome.setText("YOU WIN!");
        } else { // if any other outcome occurs the user losers and line 23 will take place
            outcome.setText("YOU LOSE!");
        }
    }

    public void beginGame (View view){
        outcome.setText("");
        chosen = false;

        if(chosen) {
            comOutput = comHand[(int) (Math.random() * 3)];

            switch(comOutput){
                case "rock":
                    comImage.setImageResource(R.mipmap.rock);
                    break;
                case "paper":
                    comImage.setImageResource(R.mipmap.paper);
                    break;
                case "scissors":
                    comImage.setImageResource(R.mipmap.scissors);
                    break;
            }

            winner();
        }

    }
}
