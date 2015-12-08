package groupl.cs314.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import groupl.cs314.quizapp.quiz_screen;

public class result_screen extends Activity {
    private int answeredCorrect = 0;
    private int answeredWrong = 0;
    private int answered = 0;
    private int totalNumberQuestions = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);
        getResults();
        ((TextView)findViewById(R.id.totalNumberQuestionsText)).setText(
                ((TextView) findViewById(R.id.totalNumberQuestionsText)).getText() + ": " + totalNumberQuestions);
        ((TextView)findViewById(R.id.numberQuestionsAttemptedText)).setText(
                ((TextView) findViewById(R.id.numberQuestionsAttemptedText)).getText() + ": " + (answered));
        ((TextView)findViewById(R.id.numberCorrectAnswersText)).setText(
                ((TextView) findViewById(R.id.numberCorrectAnswersText)).getText() + ": " + answeredCorrect);
    }

    public void ExitApp()
    {
        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void onClickExit(View view){
        // go back to previous question unless you're on the first question
            Toast toast = Toast.makeText(result_screen.this, "Thanks for playing!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 400);
            toast.show();
            ExitApp();
    }

    public void onClickPlayAgain(View view) {
        Intent intent = new Intent(this, start_screen.class);
        startActivity(intent);
    }

    private void getResults(){
        String[] answers = quiz_screen.answers;
        totalNumberQuestions = answers.length;
        for(int i = 0; i < answers.length; i++){
            if(answers[i] != null) {
                answered++;
                if (answers[i].equals("correct")) {
                    answeredCorrect++;
                } else if (answers[i].equals("incorrect")) {
                    answeredWrong++;
                } else {
                    System.out.println("Unexpected value in answers array!!!");
                }
            }
        }
    }
}
