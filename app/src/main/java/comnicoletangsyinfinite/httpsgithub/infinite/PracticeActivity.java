package comnicoletangsyinfinite.httpsgithub.infinite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import android.graphics.Color;

import org.w3c.dom.Text;

public class PracticeActivity extends AppCompatActivity {
    TextView question;
    TextView correctCount;
    ImageView questionImg;

    Random r;

    Integer[] questions = {
            R.drawable.q1,
            R.drawable.q2,
            R.drawable.q3,
    };

    int answer;
    int currentQuestionNumber;
    Button C;
    Button D;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        r = new Random();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_layout);

        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ImageView questionImg= (ImageView) findViewById(R.id.imageView);
        currentQuestionNumber=r.nextInt(questions.length);
        questionImg.setImageResource(questions[currentQuestionNumber]);


        question= (TextView) findViewById(R.id.question);
        question.setText("Which note is it?");

        correctCount= (TextView) findViewById(R.id.correctCount);
        //need to be change to count the correct answer
        correctCount.setText("Correct:1/15");

        C=(Button)findViewById(R.id.Ckey);
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer=0;
                if(answer==currentQuestionNumber){
                    C.setBackgroundColor(Color.GREEN);
                } else C.setBackgroundColor(Color.RED);
            }
        });



    }

    //To Do
    //random ask 15 question
    //change piano key to green if correct
    //change piano key to red and show the correct answer on green
    //endButton end game even not answering 15 questions

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            Intent intent = new Intent(PracticeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
