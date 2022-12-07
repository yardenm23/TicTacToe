package com.example.exc1_tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {

    private gameBoard game_board;

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        Button playAgainBTN = findViewById(R.id.button8);
        Button homeBTN = findViewById(R.id.button9);
        TextView playerTurn = findViewById(R.id.textView2);

        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);


        //String[] PLayerNames = {"X", "O"};

        playerTurn.setText("X TURN");


        game_board = findViewById(R.id.gameBoard10);

        game_board.setUpGame(playAgainBTN, homeBTN, playerTurn);

    }

    public void playAgainButtonClick(View view){
        game_board.resetGame();
        game_board.invalidate();

    }
    public void homeButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}