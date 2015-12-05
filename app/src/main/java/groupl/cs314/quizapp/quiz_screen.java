package groupl.cs314.quizapp;

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
        Toast toast = Toast.makeText(quiz_screen.this, "Previous question", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

        // go back to previous question unless you're on the first question

    }

    public void onClickAnswer(View view){
        Toast toast = Toast.makeText(quiz_screen.this, "Answered the question", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    public void onClickNext(View view){
        Toast toast = Toast.makeText(quiz_screen.this, "Next question", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    public void onClickFinish(View view){
        Toast toast = Toast.makeText(quiz_screen.this, "Finish quiz", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    private void displayQuestion(int questionNumber){

    }

}
