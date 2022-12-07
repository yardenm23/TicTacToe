package com.example.exc1_tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

public class GameDisplay extends AppCompatActivity {

    private gameBoard game_board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        game_board = findViewById(R.id.gameBoard10);
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