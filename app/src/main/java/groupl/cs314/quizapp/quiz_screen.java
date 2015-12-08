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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class quiz_screen extends Activity {

    protected final int numQuestions = 10;
    protected int currentQuestion = 1;
    ArrayList<Integer> quizQuestions = getRandomArray(4*numQuestions);
    ArrayList<ArrayList<Integer>> questionArray = new ArrayList<>(numQuestions);

    //keeps track of the correct answers
    //null = not answerd, "correct" = correct, "incorrect" = incorrect
    protected static String[] answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);
        answers = new String[numQuestions];
        initializeQuestions();
        displayQuestion(1);
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
            nextQuestion();
        }
        else{
            Toast toast = Toast.makeText(quiz_screen.this, "Question not answered", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL| Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        }

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
        if(currentQuestion == numQuestions){
            goToResults();
        }
        else{
            currentQuestion++;
            displayQuestion(currentQuestion);
        }
    }

    private void displayQuestion(int questionNumber){

        ((TextView)findViewById(R.id.questionNumberText)).setText("Question " + questionNumber);
        ((RadioGroup)findViewById(R.id.answerRadioGroup)).clearCheck();
        ((TextView)findViewById(R.id.questionText)).setText(getResources().getStringArray(R.array.words)[quizQuestions.get((currentQuestion-1)*4)]);
        ((TextView)findViewById(R.id.answerOneRadio  )).setText(getResources().getStringArray(R.array.definitions)[quizQuestions.get(((currentQuestion-1)*4) + (questionArray.get(currentQuestion-1)).get(0))]);
        ((TextView)findViewById(R.id.answerTwoRadio  )).setText(getResources().getStringArray(R.array.definitions)[quizQuestions.get(((currentQuestion-1)*4) + (questionArray.get(currentQuestion-1)).get(1))]);
        ((TextView)findViewById(R.id.answerThreeRadio)).setText(getResources().getStringArray(R.array.definitions)[quizQuestions.get(((currentQuestion-1)*4) + (questionArray.get(currentQuestion-1)).get(2))]);
        ((TextView)findViewById(R.id.answerFourRadio )).setText(getResources().getStringArray(R.array.definitions)[quizQuestions.get(((currentQuestion-1)*4) + (questionArray.get(currentQuestion-1)).get(3))]);

    }

    //return true if the answer is correct.
    private boolean checkAnswer(String answer){
        //int questionIndex = 0;
        int questionIndex = quizQuestions.get((currentQuestion-1)*4);
        //check if answer is right or wrong
        //update array of responses to keep track of right and wrong answers
        if(answer != null){
            if(getResources().getStringArray(R.array.definitions)[questionIndex].equals(answer)) {
                answers[currentQuestion-1] = "correct";
                return true;
            }
            else {
                answers[currentQuestion-1] = "incorrect";
                return false;
            }
        }
        //if answer is null then the user did not attempt the question
        answers[currentQuestion-1] = null;
        return false;

    }

    private ArrayList<Integer> getRandomArray(int max){
        ArrayList<Integer> ra = new ArrayList<>();
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

    private void initializeQuestions(){
        for(int i=0; i<numQuestions; i++){
            questionArray.add( getRandomArray(4) );
        }
    }

}
