package groupl.cs314.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class quiz_screen extends Activity {

    protected final int numQuestions = 10;
    protected int currentQuestion = 1;

    //keeps track of the correct answers
    //null = not answerd, "correct" = correct, "incorrect" = incorrect
    protected String[] answers = new String[numQuestions];

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

        int responseNum = ((RadioGroup)findViewById(R.id.answerRadioGroup)).getCheckedRadioButtonId();
        String response = null;
        if(responseNum!=-1) {
            response = (String) ((RadioButton) findViewById(responseNum)).getText();
        }
        //for debugging...
//        Toast toast1 = Toast.makeText(quiz_screen.this, response, Toast.LENGTH_SHORT);
//        toast1.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
//        toast1.show();
        if(response!=null) {
            boolean answer = checkAnswer(response);
            if (answer) {
                Toast toast = Toast.makeText(quiz_screen.this, "Correct!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            } else {
                Toast toast = Toast.makeText(quiz_screen.this, "Wrong answer!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        }
        else{
            Toast toast = Toast.makeText(quiz_screen.this, "Question not answered", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL| Gravity.CENTER_HORIZONTAL, 0, 0);
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
    //NOTE!!!!!!  When Question 10 is answered and the answer button is selected, the app crashes
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
        //Tanner you should fix this because I'm just testing stuff :)
        ((RadioGroup)findViewById(R.id.answerRadioGroup)).clearCheck();
        ((TextView)findViewById(R.id.questionText)).setText(getResources().getStringArray(R.array.words)[0]);
        ((TextView)findViewById(R.id.answerOneRadio)).setText(getResources().getStringArray(R.array.definitions)[0]);
        ((TextView)findViewById(R.id.answerTwoRadio)).setText(getResources().getStringArray(R.array.definitions)[1]);
        ((TextView)findViewById(R.id.answerThreeRadio)).setText(getResources().getStringArray(R.array.definitions)[2]);
        ((TextView)findViewById(R.id.answerFourRadio)).setText(getResources().getStringArray(R.array.definitions)[3]);

    }

    //return true if the answer is correct.
    private boolean checkAnswer(String answer){
        int questionIndex = 0;
        //int questionIndex = tannersArray.get(currentQuestion);
        //check if answer is right or wrong
        //update array of responses to keep track of right and wrong answers
        if(answer != null){
            if(getResources().getStringArray(R.array.definitions)[questionIndex].equals(answer)) {
                answers[currentQuestion] = "correct";
                return true;
            }
            else {
                answers[currentQuestion] = "incorrect";
                return false;
            }
        }
        //if answer is null then the user did not attempt the question
        answers[currentQuestion] = null;
        return false;


    }

}
