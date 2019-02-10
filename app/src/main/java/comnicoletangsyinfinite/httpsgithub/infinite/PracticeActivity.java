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
import android.os.Handler;
import org.w3c.dom.Text;

public class PracticeActivity extends AppCompatActivity {
    TextView question;
    TextView correctCount;
    ImageView questionImg;
    Handler handler = new Handler();

    Random r;

    Integer[] questions = {
            R.drawable.q1,
            R.drawable.q2,
            R.drawable.q3,
            R.drawable.q4,
            R.drawable.q5,
            R.drawable.q6,
            R.drawable.q7,
            R.drawable.q9,
            R.drawable.q10,
            R.drawable.q11,
            R.drawable.q12,
            R.drawable.q13,
            R.drawable.q14,
            R.drawable.q15,
            R.drawable.q8

    };

    int answer;
    int currentQuestionNumber;
    int correctQ=0;
    Button C;
    Button D;
    Button E;
    Button F;
    Button G;
    Button A;
    Button B;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        r = new Random();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_layout);

        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        questionImg= (ImageView) findViewById(R.id.imageView);
        currentQuestionNumber=r.nextInt(questions.length);
        questionImg.setImageResource(questions[currentQuestionNumber]);


        question= (TextView) findViewById(R.id.question);
        question.setText("Which note is it?");

        correctCount= (TextView) findViewById(R.id.correctCount);
        //need to be change to count the correct answer
        correctCount.setText("Correct:0/15");

        C=(Button)findViewById(R.id.Ckey);
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer=0;
                if(answer==currentQuestionNumber||answer+7==currentQuestionNumber){

                    C.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else C.setBackgroundColor(Color.RED);


                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        C.setBackgroundResource(R.drawable.whitekey);
                    }
                }, 2000);


            }
        });

        D=(Button)findViewById(R.id.Dkey);
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer=1;
                if(answer==currentQuestionNumber||answer+7==currentQuestionNumber){
                    D.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else D.setBackgroundColor(Color.RED);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        D.setBackgroundResource(R.drawable.whitekey);
                    }
                }, 2000);
            }
        });
        E=(Button)findViewById(R.id.Ekey);
        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer=2;
                if(answer==currentQuestionNumber||answer+7==currentQuestionNumber){
                    E.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else E.setBackgroundColor(Color.RED);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        E.setBackgroundResource(R.drawable.whitekey);
                    }
                }, 2000);
            }
        });
        F=(Button)findViewById(R.id.Fkey);
        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer=3;
                if(answer==currentQuestionNumber||answer+7==currentQuestionNumber){
                    F.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else F.setBackgroundColor(Color.RED);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        F.setBackgroundResource(R.drawable.whitekey);
                    }
                }, 2000);
            }
        });
        G=(Button)findViewById(R.id.Gkey);
        G.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer=4;
                if(answer==currentQuestionNumber||answer+7==currentQuestionNumber){
                    G.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else G.setBackgroundColor(Color.RED);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        G.setBackgroundResource(R.drawable.whitekey);
                    }
                }, 2000);
            }
        });
        A=(Button)findViewById(R.id.Akey);
        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer=5;
                if(answer==currentQuestionNumber||answer+7==currentQuestionNumber){
                    A.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else A.setBackgroundColor(Color.RED);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        A.setBackgroundResource(R.drawable.whitekey);
                    }
                }, 2000);
            }
        });
        B=(Button)findViewById(R.id.Bkey);
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer=6;
                if(answer==currentQuestionNumber||answer+7==currentQuestionNumber){
                    B.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else B.setBackgroundColor(Color.RED);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        B.setBackgroundResource(R.drawable.whitekey);
                    }
                }, 2000);
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
