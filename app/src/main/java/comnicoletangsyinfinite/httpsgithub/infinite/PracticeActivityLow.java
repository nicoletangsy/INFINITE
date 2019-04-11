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
import android.os.CountDownTimer;

import org.w3c.dom.Text;

public class PracticeActivityLow extends AppCompatActivity {
    TextView question;
    TextView correctCount;
    TextView time;
    ImageView questionImg;
    Handler handler = new Handler();

    Random r;

    Integer[] questions = {
            R.drawable.lc1,
            R.drawable.lc2,

            R.drawable.lcs1,
            R.drawable.lcs2,

            R.drawable.ld1,

            R.drawable.lds1,
            R.drawable.lds2,

            R.drawable.le1,
            R.drawable.le2,

            R.drawable.lf1,
            R.drawable.lf2,

            R.drawable.lfs1,
            R.drawable.lfs2,

            R.drawable.lg1,

            R.drawable.lgs1,
            R.drawable.lgs2,

            R.drawable.la1,

            R.drawable.las1,
            R.drawable.las2,

            R.drawable.lb1,
            R.drawable.lb2,


            R.drawable.lc21,
            R.drawable.lc22,

            R.drawable.lcs21,
            R.drawable.lcs22,

            R.drawable.ld21,

            R.drawable.lds21,
            R.drawable.lds22,

            R.drawable.le21,
            R.drawable.le22,

            R.drawable.lf21,
            R.drawable.lf22,

            R.drawable.lfs21,
            R.drawable.lfs22,

            R.drawable.lg21,

            R.drawable.lgs21,
            R.drawable.lgs22,

            R.drawable.la21,

            R.drawable.las21,
            R.drawable.las22,

            R.drawable.lb21,
            R.drawable.lb22,




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
    Button C1;
    Button D1;
    Button E1;
    Button F1;
    Button G1;
    Button A1;
    Button B1;
    Button Cc1;
    Button Dd1;
    Button Ff1;
    Button Gg1;
    Button Aa1;


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
                    Intent intent = new Intent(PracticeActivityLow.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            builder.setNegativeButton("Try again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(PracticeActivityLow.this, PracticeActivityLow.class);
                    startActivity(intent);
                    finish();
                }
            });

            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }

    public void updateQ(){
        correctCount.setText("Question:"+(int)(total+1)+"/15");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        r = new Random();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_layout_low);

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
        correctCount.setText("Question:1/15");
        time= (TextView) findViewById(R.id.time);

        final CountDownTimer myCountDownTimer=new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                time.setText("Times up!!");
                total++;
                updateQ();
                checkEnd();
                currentQuestionNumber=r.nextInt(questions.length);
                questionImg.setImageResource(questions[currentQuestionNumber]);
                this.start();
            }
        }.start();

        C1=(Button)findViewById(R.id.Ckey1);
        C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=21;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    C1.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else C1.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        C1.setBackgroundResource(R.drawable.whitekey);
                        myCountDownTimer.start();
                    }
                }, 2000);


            }
        });
        D1=(Button)findViewById(R.id.Dkey1);
        D1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=25;
                if(answer==currentQuestionNumber){
                    D1.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else D1.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        D1.setBackgroundResource(R.drawable.whitekey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        E1=(Button)findViewById(R.id.Ekey1);
        E1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=28;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    E1.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else E1.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        E1.setBackgroundResource(R.drawable.whitekey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        F1=(Button)findViewById(R.id.Fkey1);
        F1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=30;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    F1.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else F1.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        F1.setBackgroundResource(R.drawable.whitekey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        G1=(Button)findViewById(R.id.Gkey1);
        G1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=34;
                if(answer==currentQuestionNumber){
                    G1.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else G1.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        G1.setBackgroundResource(R.drawable.whitekey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        A1=(Button)findViewById(R.id.Akey1);
        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=37;
                if(answer==currentQuestionNumber){
                    A1.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else A1.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        A1.setBackgroundResource(R.drawable.whitekey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        B1=(Button)findViewById(R.id.Bkey1);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=40;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    B1.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else B1.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        B1.setBackgroundResource(R.drawable.whitekey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });

        Cc1=(Button)findViewById(R.id.Cckey1);
        Cc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=23;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    Cc1.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else Cc1.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        Cc1.setBackgroundResource(R.drawable.blackkey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        Dd1=(Button)findViewById(R.id.Ddkey1);
        Dd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=26;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    Dd1.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else Dd1.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        Dd1.setBackgroundResource(R.drawable.blackkey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });

        Ff1=(Button)findViewById(R.id.Ffkey1);
        Ff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=32;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    Ff1.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else Ff1.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        Ff1.setBackgroundResource(R.drawable.blackkey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        Gg1=(Button)findViewById(R.id.Ggkey1);
        Gg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=35;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    Gg1.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else Gg1.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        Gg1.setBackgroundResource(R.drawable.blackkey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        Aa1=(Button)findViewById(R.id.Aakey1);
        Aa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=38;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    Aa1.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else Aa1.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        Aa1.setBackgroundResource(R.drawable.blackkey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });


        C=(Button)findViewById(R.id.Ckey);
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=0;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    C.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else C.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        C.setBackgroundResource(R.drawable.whitekey);
                        myCountDownTimer.start();
                    }
                }, 2000);


            }
        });

        D=(Button)findViewById(R.id.Dkey);
        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=4;
                if(answer==currentQuestionNumber){
                    D.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else D.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        D.setBackgroundResource(R.drawable.whitekey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        E=(Button)findViewById(R.id.Ekey);
        E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=7;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    E.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else E.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        E.setBackgroundResource(R.drawable.whitekey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        F=(Button)findViewById(R.id.Fkey);
        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=9;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    F.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else F.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        F.setBackgroundResource(R.drawable.whitekey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        G=(Button)findViewById(R.id.Gkey);
        G.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=13;
                if(answer==currentQuestionNumber){
                    G.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else G.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        G.setBackgroundResource(R.drawable.whitekey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        A=(Button)findViewById(R.id.Akey);
        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=16;
                if(answer==currentQuestionNumber){
                    A.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else A.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        A.setBackgroundResource(R.drawable.whitekey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        B=(Button)findViewById(R.id.Bkey);
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=19;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    B.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else B.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        B.setBackgroundResource(R.drawable.whitekey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        Cc=(Button)findViewById(R.id.Cckey);
        Cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=2;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    Cc.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else Cc.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        Cc.setBackgroundResource(R.drawable.blackkey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        Dd=(Button)findViewById(R.id.Ddkey);
        Dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=5;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    Dd.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else Dd.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        Dd.setBackgroundResource(R.drawable.blackkey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });

        Ff=(Button)findViewById(R.id.Ffkey);
        Ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=11;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    Ff.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else Ff.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        Ff.setBackgroundResource(R.drawable.blackkey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        Gg=(Button)findViewById(R.id.Ggkey);
        Gg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=14;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    Gg.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else Gg.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        Gg.setBackgroundResource(R.drawable.blackkey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });
        Aa=(Button)findViewById(R.id.Aakey);
        Aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.cancel();
                total++;
                answer=17;
                if(answer==currentQuestionNumber||answer+1==currentQuestionNumber){
                    Aa.setBackgroundColor(Color.GREEN);
                    correctQ++;
                } else Aa.setBackgroundColor(Color.RED);
                checkEnd();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        updateQ();
                        currentQuestionNumber=r.nextInt(questions.length);
                        questionImg.setImageResource(questions[currentQuestionNumber]);
                        Aa.setBackgroundResource(R.drawable.blackkey);
                        myCountDownTimer.start();
                    }
                }, 2000);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            Intent intent = new Intent(PracticeActivityLow.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
