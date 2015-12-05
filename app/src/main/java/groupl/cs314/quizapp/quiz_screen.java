package groupl.cs314.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class quiz_screen extends Activity {

    protected int currentQuestion = 1;
    ArrayList<Integer> quizQuestions = getRandomArray(40);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);
    }

    public void onClickBack(View view){
        // go back to previous question unless you're on the first question
        if(currentQuestion == 1){
            Toast toast = Toast.makeText(quiz_screen.this, "No previous question available", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }
        else{
            currentQuestion--;
            displayQuestion(currentQuestion);
        }
    }

    public void onClickAnswer(View view){
        boolean answer = checkAnswer();

        if(answer){
            Toast toast = Toast.makeText(quiz_screen.this, "Correct!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }
        else{
            Toast toast = Toast.makeText(quiz_screen.this, "Wrong answer!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }

        nextQuestion();
    }

    public void onClickNext(View view){
        nextQuestion();
    }

    public void onClickFinish(View view){
        goToResults();
    }

    private void goToResults(){
        Toast toast = Toast.makeText(quiz_screen.this, "Quiz complete", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
        Intent intent = new Intent(this, result_screen.class);
        startActivity(intent);
    }

    private void nextQuestion(){
        if(currentQuestion == 10){
            goToResults();
        }
        else{
            currentQuestion++;
            displayQuestion(currentQuestion);
        }
    }

    private void displayQuestion(int questionNumber){
        ((TextView)findViewById(R.id.questionNumberText)).setText("Question " + questionNumber);


    }

    private boolean checkAnswer(){
        return false;
    }

    private ArrayList<Integer> getRandomArray(int max){
        ArrayList<Integer> ra = new ArrayList<Integer>();
        Random gen = new Random();
        int rn = gen.nextInt(max);
        int governor = 0;
        while(ra.size()<max){
            //safety
            if(governor == 10){
                rn = 0;
                boolean status = true;
                while(status){
                    if(!ra.contains(rn))
                        status = false;
                    else
                        rn++;
                }
            }
            if(!ra.contains(rn)){
                ra.add(rn);
                governor = 0;
            }else{
                governor++;
            }
            rn = gen.nextInt(max);
        }
        return ra;
    }

}
