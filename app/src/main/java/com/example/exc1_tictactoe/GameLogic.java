package com.example.exc1_tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class GameLogic {

    private  int [][] gameBoard;

    private String[] playerNames = {"Player1", "player2"};

    private Button playeAgainBTN;
    private Button homeBTN;
    private TextView playerTurn;

    private int player = 1; //The player who is playing now. EveryGame Starts with 1(X)

    GameLogic() {

        // Marks the taken places (user can insert O or X int them)
        gameBoard = new int[3][3];
        for (int r=0; r<3; r++){
            for (int c=0; c<3; c++){
                gameBoard[r][c] =0;
            }
        }
    }

    public boolean updateGameBoard(int raw, int col){
        if (gameBoard[raw-1][col-1] == 0){
            gameBoard[raw-1][col-1] = player;

            if (player == 1){
                playerTurn.setText("O's Turn");
            }
            else{
                playerTurn.setText("X's Turn");
            }

            return true;
        }
        else{
            return false;
        }
    }
     public boolean winnerCheck(){
        boolean isWinner = false;
        int winner = 2;

        for (int r =0; r<3; r++) {
            if (gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2] &&
                    gameBoard[r][0] != 0) {
                isWinner = true;
                winner = gameBoard[r][0];
            }
        }
        for (int c =0; c<3; c++){

            if (gameBoard[0][c] == gameBoard[1][c] && gameBoard[2][c] == gameBoard[0][c] &&
                gameBoard[0][c] != 0){
            isWinner = true;
            winner = gameBoard[0][c];
            }
        }


         if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] &&
                 gameBoard[0][0] != 0){
             isWinner = true;
             winner = gameBoard[0][0];

         }

         if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] == gameBoard[0][2] &&
                 gameBoard[2][0] != 0){
             isWinner = true;
             winner = gameBoard[2][0];

         }

         int boardFilled = 0;

         for (int r =0; r <3; r++){
             for (int c=0; c<3; c++){
                 if (gameBoard[r][c] != 0){
                     boardFilled += 1;
                 }
             }
         }


        if (isWinner){
            playeAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            char winner_char = 'O';
            if (winner==1){
                winner_char = 'X';
            }
            playerTurn.setText("The winner is: " + winner_char );
            return true;
        }

         else if (boardFilled ==9){
             playeAgainBTN.setVisibility(View.VISIBLE);
             homeBTN.setVisibility(View.VISIBLE);
             playerTurn.setText("Nobody Wins! Try Again");
             return true;
         }

         else {
             return false;
        }
     }

    public void resetGame() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                gameBoard[r][c] = 0;
            }
        }

        player=1;

        playeAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);

        playerTurn.setText("player X");


    }

    public void setPlayeAgainBTN(Button playeAgainBTN) {
        this.playeAgainBTN = playeAgainBTN;
    }

    public void setHomeBTN(Button homeBTN) {
        this.homeBTN = homeBTN;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setPlayerNames(String[] playerNames){
        this.playerNames = playerNames;
    }



    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }
}
