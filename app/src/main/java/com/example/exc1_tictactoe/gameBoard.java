package com.example.exc1_tictactoe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class gameBoard extends View {

    private final int boardColor;
    private final int XColor;
    private final int OColor;
    private final int winningLineColor; //TODO remove

    private final Paint paint = new Paint();

    private final GameLogic game;

    private int cellSize = getWidth()/3;

    public gameBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        game = new GameLogic();

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.gameBoard, 0,0);

        try {
            boardColor = a.getInteger(R.styleable.gameBoard_boardColor, 0);
            XColor = a.getInteger(R.styleable.gameBoard_XColor,0);
            OColor = a.getInteger(R.styleable.gameBoard_OColor,0);
            winningLineColor = a.getInteger(R.styleable.gameBoard_winningLineColor,0); //TODO remove


        }finally {
            a.recycle();
        }
    }

    @Override
    protected  void onMeasure(int width, int height){
        super.onMeasure(width, height);

        int dimension = Math.min(getMeasuredWidth(), getMeasuredHeight());
        cellSize = dimension/3;

        setMeasuredDimension(dimension, dimension);


    }
    @Override
    protected void onDraw(Canvas canvas){
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        drawGameBoard(canvas);
        drawMarkers(canvas);

    }

    @SuppressLint("ClickableViewAccessibility")
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        int action = event.getAction();

        if (action == MotionEvent.ACTION_DOWN){
            int row = (int) Math.ceil(y/cellSize);
            int col = (int) Math.ceil(x/cellSize);

            if(game.updateGameBoard(row, col)){
                invalidate();

                if (game.getPlayer() %2 ==0){
                    game.setPlayer((game.getPlayer()-1));
                }
                else{
                    game.setPlayer((game.getPlayer()+1));
                }
            }

            invalidate();

            return true;


        }
        return false;
    }

    private void drawGameBoard(Canvas canvas){

        paint.setColor(boardColor);
        paint.setStrokeWidth(16);

        for (int c=1; c<3; c++){
            canvas.drawLine(cellSize*c, 0, cellSize*c, canvas.getWidth(), paint);
        }

        for (int r=1; r<3; r++){
            canvas.drawLine(0, cellSize*r, canvas.getWidth(), cellSize*r, paint);
        }

    }

    private void drawMarkers(Canvas canvas) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (game.getGameBoard()[r][c] != 0) {
                    if (game.getGameBoard()[r][c] == 1) {
                        drawX(canvas, r, c);

                    }
                    else{
                        drawO(canvas, r, c);
                    }
                }
            }
        }
    }

    private void drawX(Canvas canvas, int row, int col){
        paint.setColor(XColor);

        canvas.drawLine((float) ((col+1)*cellSize-cellSize*0.15),
                (float) (row*cellSize + cellSize*0.15),
                (float) (col*cellSize +cellSize*0.15),
                (float) ((row+1)*cellSize - cellSize*0.15),
                paint);

        canvas.drawLine((float) ((col)*cellSize + cellSize*0.15),
                (float) (row*cellSize + cellSize*0.15),
                (float) ((col+1)*cellSize - cellSize*0.15),
                (float) ((row+1)*cellSize - cellSize*0.15),
                paint);


    }

    private void drawO(Canvas canvas, int row, int col){
        paint.setColor(OColor);

        canvas.drawOval((float) (col*cellSize + cellSize*0.15),
                (float) (row*cellSize+ cellSize*0.15),
                (float) ((col*cellSize +cellSize)- cellSize*0.15),
                (float) ((row*cellSize+cellSize)- cellSize*0.15),
                paint);

    }

    public void resetGame(){
        game.resetGame();
    }


}
