package com.example.yashvarma.mentalhealthandpsychosocialsupportapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    //0:x ,1:0, 2:empty
    int activePlayer=0;




    boolean gameOver=false;

    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    boolean gameActive=true;

    // color change
    Handler handler = new Handler();
    int[] colors = {Color.BLUE, Color.GRAY, Color.RED, Color.BLACK,};
    int i=0;
    //

    public void dropIn(View view){


        ImageView counter=(ImageView)view;

        int tappedCounter=Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter]==2 && gameActive) {
            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1500);

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.x);
                activePlayer = 1;
            } else {

                counter.setImageResource(R.drawable.o4);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(1200);

            for (int[] winningPosition : winningPositions) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                    gameActive = false;
                    String winner = "";
                    if (activePlayer == 1) {
                        winner = "X";

                    } else {
                        winner = "O";
                    }

                    // someone has won


                    Button playAgain = (Button) findViewById(R.id.playAgainButton);
                    final TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

                    winnerTextView.setText(winner + " has won!");

                    gameOver = true;


                    playAgain.setVisibility(view.VISIBLE);
                    winnerTextView.setVisibility(view.VISIBLE);

                    //color change

                    Runnable runnable = new Runnable () {
                        @Override
                        public void run() {
                            i = i % colors.length;
                            winnerTextView.setTextColor(colors[i]);
                            i++;
                            handler.postDelayed(this, 1000);
                        }
                    };handler.postDelayed(runnable, 1000);


                }
            }


            //draw condition

            boolean emptySquare = false;
            for (int squareState : gameState) {
                if (squareState == 2) {
                    emptySquare = true;
                    break;
                }
            }

            if (!emptySquare && !gameOver) {
                // Game is a draw

                gameOver = true;
                // Set draw message here...
                Button playAgain1=(Button)findViewById(R.id.playAgainButton);
                final TextView winnerTextView1=(TextView)findViewById(R.id.winnerTextView);
                winnerTextView1.setText(" Draw! ");

                playAgain1.setVisibility(view.VISIBLE);
                winnerTextView1.setVisibility(view.VISIBLE);
                Runnable runnable = new Runnable () {
                    @Override
                    public void run() {
                        i = i % colors.length;
                        winnerTextView1.setTextColor(colors[i]);
                        i++;
                        handler.postDelayed(this, 1000);
                    }
                };handler.postDelayed(runnable, 1000);



            }






        }
    }

    public void playAgain(View view){

        Button playAgain=(Button)findViewById(R.id.playAgainButton);
        TextView winnerTextView=(TextView)findViewById(R.id.winnerTextView);


        playAgain.setVisibility(view.INVISIBLE);
        winnerTextView.setVisibility(view.INVISIBLE);


        GridLayout gridLayout=(GridLayout)findViewById(R.id.gridLayout);


        for(int i=0; i<gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            // do stuff with child view
            counter.setImageDrawable(null);
        }
        activePlayer=0;

        for(int i=0;i<gameState.length;i++) {
            gameState[i]=2;

        }

        gameActive=true;
        gameOver=false;




    }



    @Override
    public void onBackPressed(){

        Intent i5=new Intent(Game.this,HomeActivity.class);
        startActivity(i5);
        finish();


    }

















    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
}
