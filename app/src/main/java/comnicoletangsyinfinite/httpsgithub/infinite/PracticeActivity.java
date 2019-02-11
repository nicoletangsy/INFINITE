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
import 	android.app.AlertDialog;
import android.content.DialogInterface;

import org.w3c.dom.Text;

public class PracticeActivity extends AppCompatActivity {
    TextView question;
    TextView correctCount;
    ImageView questionImg;
    Handler handler = new Handler();

    Random r;

    Integer[] questions = {
            R.drawable.q1,
            R.drawable.q9,
            R.drawable.q16,
            R.drawable.q23,
            R.drawable.q30,
            R.drawable.q17,
            R.drawable.q24,
            R.drawable.q33,
            R.drawable.q40,
            R.drawable.q2,
            R.drawable.q10,
            R.drawable.q18,
            R.drawable.q25,
            R.drawable.q41,
            R.drawable.q99,
            R.drawable.q3,
            R.drawable.q11,
            R.drawable.q35,
            R.drawable.q42,
            R.drawable.q4,
            R.drawable.q12,
            R.drawable.q19,
            R.drawable.q26,
            R.drawable.q20,
            R.drawable.q27,
            R.drawable.q36,
            R.drawable.q43,

            R.drawable.q5,
            R.drawable.q13,

            R.drawable.q21,
            R.drawable.q28,
            R.drawable.q37,
            R.drawable.q44,

            R.drawable.q6,
            R.drawable.q14,

            R.drawable.q22,
            R.drawable.q29,
            R.drawable.q31,
            R.drawable.q38,
            R.drawable.q45,

            R.drawable.q7,
            R.drawable.q8,
            R.drawable.q15,
            R.drawable.q32,
            R.drawable.q39,
    };

    int answer;
    int currentQuestionNumber;
    int correctQ=0;
    double total=0;
    Button C;
    Button D;
    Button E;
    Button F;
    Button G;
    Button A;
    Button B;
    Button Cc;
    Button Dd;
    Button Ff;
    Button Gg;
    Button Aa;

    public void checkEnd(){
        if(total==15) {
            int wrong=(int)total-correctQ;
            // setup the alert builder
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Finished !");
            builder.setMessage("Correct : "+correctQ+"\nWrong : "+wrong+"\nYour accuracy : "+Math.round((correctQ/total)*100)+"%");

            // add a button
            builder.setPositiveButton("Back to Main Menu", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(PracticeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            builder.setNegativeButton("Try again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(PracticeActivity.this, PracticeActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }


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
                total++;
                answer=0;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber||answer+2==currentQuestionNumber||answer+3==currentQuestionNumber||answer+4==currentQuestionNumber){
                    C.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else C.setBackgroundColor(Color.RED);
                checkEnd();
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
                total++;
                answer=9;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    D.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else D.setBackgroundColor(Color.RED);
                checkEnd();
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
                total++;
                answer=15;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber||answer+2==currentQuestionNumber||answer+3==currentQuestionNumber){
                    E.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else E.setBackgroundColor(Color.RED);
                checkEnd();
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
                total++;
                answer=19;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber||answer+2==currentQuestionNumber||answer+3==currentQuestionNumber){
                    F.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else F.setBackgroundColor(Color.RED);
                checkEnd();
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
                total++;
                answer=27;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    G.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else G.setBackgroundColor(Color.RED);
                checkEnd();
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
                total++;
                answer=33;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    A.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else A.setBackgroundColor(Color.RED);
                checkEnd();
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
                total++;
                answer=40;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber||answer+2==currentQuestionNumber||answer+3==currentQuestionNumber||answer+4==currentQuestionNumber){
                    B.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else B.setBackgroundColor(Color.RED);
                checkEnd();
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
        Cc=(Button)findViewById(R.id.Cckey);
        Cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total++;
                answer=5;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber||answer+2==currentQuestionNumber||answer+3==currentQuestionNumber){
                    Cc.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else Cc.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        Cc.setBackgroundResource(R.drawable.blackkey);
                    }
                }, 2000);
            }
        });
        Dd=(Button)findViewById(R.id.Ddkey);
        Dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total++;
                answer=11;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber||answer+2==currentQuestionNumber||answer+3==currentQuestionNumber){
                    Dd.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else Dd.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        Dd.setBackgroundResource(R.drawable.blackkey);
                    }
                }, 2000);
            }
        });

        Ff=(Button)findViewById(R.id.Ffkey);
        Ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total++;
                answer=23;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber||answer+2==currentQuestionNumber||answer+3==currentQuestionNumber){
                    Ff.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else Ff.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        Ff.setBackgroundResource(R.drawable.blackkey);
                    }
                }, 2000);
            }
        });
        Gg=(Button)findViewById(R.id.Ggkey);
        Gg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total++;
                answer=29;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber||answer+2==currentQuestionNumber||answer+3==currentQuestionNumber){
                    Gg.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else Gg.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        Gg.setBackgroundResource(R.drawable.blackkey);
                    }
                }, 2000);
            }
        });
        Aa=(Button)findViewById(R.id.Aakey);
        Aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total++;
                answer=35;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber||answer+2==currentQuestionNumber||answer+3==currentQuestionNumber||answer+4==currentQuestionNumber){
                    Aa.setBackgroundColor(Color.GREEN);
                    correctQ++;
                    correctCount.setText("Correct: "+correctQ+"/15");
                } else Aa.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        Aa.setBackgroundResource(R.drawable.blackkey);
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
