package groupl.cs314.quizapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class QuizScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);
    }

    public void onClickBack(View view){
        Toast toast = Toast.makeText(QuizScreen.this, "Previous question", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    public void onClickAnswer(View view){
        Toast toast = Toast.makeText(QuizScreen.this, "Answered the question", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    public void onClickNext(View view){
        Toast toast = Toast.makeText(QuizScreen.this, "Next question", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    public void onClickFinish(View view){
        Toast toast = Toast.makeText(QuizScreen.this, "Finish quiz", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}
