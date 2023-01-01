package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView player1Score,player2Score,player1_score,player2_score,whose_turn;
    Button btn_1_1, btn_1_2, btn_1_3, btn_2_1, btn_2_2, btn_2_3, btn_3_1, btn_3_2, btn_3_3;
    String btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

//lets take a boolean or maybe  we can take a integer which will be initialized to true
    boolean flg = false,blocker = false;
    int counter = 0,score1=0,score2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        Button playAgain = findViewById(R.id.play_again);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAgain();
            }
        });

        ImageButton reseTGame = findViewById(R.id.reset_game);
        reseTGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
    }

    private void init(){
        btn_1_1 = findViewById(R.id.btn_1_1);
        btn_1_2 = findViewById(R.id.btn_1_2);
        btn_1_3 = findViewById(R.id.btn_1_3);
        btn_2_1 = findViewById(R.id.btn_2_1);
        btn_2_2 = findViewById(R.id.btn_2_2);
        btn_2_3 = findViewById(R.id.btn_2_3);
        btn_3_1 = findViewById(R.id.btn_3_1);
        btn_3_2 = findViewById(R.id.btn_3_2);
        btn_3_3 = findViewById(R.id.btn_3_3);
//        play_again = findViewById(R.id.play_again);

        player1Score = findViewById(R.id.player1Score);
        player2Score = findViewById(R.id.player2_score);
        player1_score = findViewById(R.id.player1_score);
        player2_score = findViewById(R.id.player2_score);
        whose_turn = findViewById(R.id.whose_turn);


    }

    public void check_condition(View v){
        // I guess now I need to be working on making pairs
        // which is if a pair of three X or O are created then that current player has won

        // : minimum of 5 moves needs to be made, a counter needs to be made for made ig ( 5 moves at minimum is required b'coz well that is when there is a possibility that
        // there is a pair

        counter++;
        Button currentButton = (Button) v;


        //Once a value has been given in a cell, it is fixed think bout it, as it won't be changed a condition needs to be added
        if(currentButton.getText().toString().equals("") && blocker==false){
            if(counter%2==0 && counter!=9){
                whose_turn.setText("Player 1's turn");

            }
            else if(counter%2!=0 && counter!=9){
                whose_turn.setText("Player 2's turn");
            }
            if (flg == false){
                currentButton.setText("X");
                flg = true;
            }
            else{
                currentButton.setText("O");
                flg = false;
            }
            if(counter>=5){
                btn1 = btn_1_1.getText().toString();
                btn2 = btn_1_2.getText().toString();
                btn3 = btn_1_3.getText().toString();
                btn4 = btn_2_1.getText().toString();
                btn5 = btn_2_2.getText().toString();
                btn6 = btn_2_3.getText().toString();
                btn7 = btn_3_1.getText().toString();
                btn8 = btn_3_2.getText().toString();
                btn9 = btn_3_3.getText().toString();


                //So basically the logic is working alright, i guess now I have to update the value
                // like the winner etc in the buttons

                // these three conditions check if the buttons to the side(rows) are equal or not
                if (!btn1.equals("") && btn1.equals(btn2) && btn2.equals(btn3)){
//                    Toast.makeText(this, "->"+btn1, Toast.LENGTH_SHORT).show();
                    blocker = true;
                    declareWinner();
                }
                else if(!btn4.equals("") && btn4.equals(btn5) && btn5.equals(btn6)){
//                    Toast.makeText(this, "W = "+btn4, Toast.LENGTH_SHORT).show();
                    blocker = true;
                    declareWinner();
                }
                else if(!btn7.equals("") && btn7.equals(btn8) && btn8.equals(btn9)){
//                    Toast.makeText(this, "w = "+btn7, Toast.LENGTH_SHORT).show();
                    blocker = true;
                    declareWinner();
                }

                // these will check the columns
                else if(!btn1.equals("") && btn1.equals(btn4) && btn4.equals(btn7)){
//                    Toast.makeText(this, "w = "+btn1, Toast.LENGTH_SHORT).show();
                    blocker = true;
                    declareWinner();
                }
                else if(!btn2.equals("") && btn2.equals(btn5) && btn5.equals(btn8)){
//                    Toast.makeText(this, "w = "+btn2, Toast.LENGTH_SHORT).show();
                    blocker = true;
                    declareWinner();
                }
                else if(!btn3.equals("") && btn3.equals(btn6) && btn6.equals(btn9)){
//                    Toast.makeText(this, "w = "+btn3, Toast.LENGTH_SHORT).show();
                    blocker = true;
                    declareWinner();
                }


                //now the diagonals
                else if(!btn1.equals("") && btn1.equals(btn5) && btn5.equals(btn9)){
//                    Toast.makeText(this, "w = "+btn1, Toast.LENGTH_SHORT).show();
                    blocker = true;
                    declareWinner();
                }
                else if(!btn3.equals("") && btn3.equals(btn5) && btn5.equals(btn7)){
//                    Toast.makeText(this, "w = "+btn3, Toast.LENGTH_SHORT).show();
                    blocker = true;
                    declareWinner();
                    //restartGame();
                }
                else if(counter==9){
                    whose_turn.setText("Well, it is a draw");
                }
            }
        }


    }
    public void playAgain(){
        btn_1_1.setText("");
        btn_1_2.setText("");
        btn_1_3.setText("");
        btn_2_1.setText("");
        btn_2_2.setText("");
        btn_2_3.setText("");
        btn_3_1.setText("");
        btn_3_2.setText("");
        btn_3_3.setText("");
        counter = 0;
        flg = false;
        blocker = false;
        whose_turn.setText("");
    }
    public void declareWinner(){
        if(counter%2!=0){
            score1++;
            whose_turn.setText("Player 1 (X) has won");
            player1_score.setText(Integer.toString(score1));
        }
        else{
            score2++;
            whose_turn.setText("Player 2 (O) has won");
            player2_score.setText(Integer.toString(score2));
        }
    }
    public void resetGame(){
        score1=0;
        player1_score.setText(Integer.toString(score1));
        score2=0;
        player2_score.setText(Integer.toString(score2));
        btn_1_1.setText("");
        btn_1_2.setText("");
        btn_1_3.setText("");
        btn_2_1.setText("");
        btn_2_2.setText("");
        btn_2_3.setText("");
        btn_3_1.setText("");
        btn_3_2.setText("");
        btn_3_3.setText("");
        counter = 0;
        flg = false;
        blocker = false;
        whose_turn.setText("");
    }
}
// Since we have 9 buttons with similar functionality , so we are using onClick function on all of those buttons
//If the buttons had distinctively different functionality then we would have to create different onClick function for all the buttons, but since here all the buttons work
// in a similar fashion so creating one will work alright!