package groupl.cs314.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class quiz_screen extends Activity {

    protected int currentQuestion = 1;
    protected int numCorrectAnswers = 0;
    protected int numAttemptedQuestions = 0;

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
        Toast toast = Toast.makeText(quiz_screen.this, "Answered the question", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    public void onClickNext(View view){
        if(currentQuestion == 10){
            Toast toast = Toast.makeText(quiz_screen.this, "Quiz complete", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            /**Intent intent = new Intent(this, result_screen.class);
            startActivity(intent);**/
        }
        else{
            currentQuestion++;
            displayQuestion(currentQuestion);
        }
    }

    public void onClickFinish(View view){
        Toast toast = Toast.makeText(quiz_screen.this, "Quiz complete", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
        /**Intent intent = new Intent(this, result_screen.class);
        startActivity(intent);**/
    }

    private void displayQuestion(int questionNumber){

    }

}
