package groupl.cs314.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class start_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

    }

    // Called when used clicks the Start Quiz button
    public void StartQuiz(View view) {
        Intent intent = new Intent(this, quiz_screen.class);
        startActivity(intent);
    }


}
