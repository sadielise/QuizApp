package groupl.cs314.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class result_screen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);
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
            Toast toast = Toast.makeText(result_screen.this, "Thanks for Playing!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL| Gravity.CENTER_HORIZONTAL, 0, 300);
            toast.show();
            ExitApp();
    }

    public void onClickPlayAgain(View view) {
        Intent intent = new Intent(this, start_screen.class);
        startActivity(intent);
    }
}
