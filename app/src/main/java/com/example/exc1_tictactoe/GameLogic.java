package com.example.exc1_tictactoe;

class GameLogic {

    private  int [][] gameBoard;
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

            return true;
        }
        else{
            return false;
        }
    }
    public void resetGame() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                gameBoard[r][c] = 0;
            }
        }
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
