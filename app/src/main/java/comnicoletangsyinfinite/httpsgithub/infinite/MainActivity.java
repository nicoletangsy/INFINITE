package comnicoletangsyinfinite.httpsgithub.infinite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
//index for KeySight
    /* 
        @inproceedings{six2014tarsosdsp,
            author      = {Joren Six and Olmo Cornelis and Marc Leman},
            title       = {{TarsosDSP, a Real-Time Audio Processing Framework in Java}},
            booktitle   = {{Proceedings of the 53rd AES Conference (AES 53rd)}},
            year        =  2014
        }
        */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aboutButton = findViewById(R.id.aboutButton);
        Button practiceButton = findViewById(R.id.practiceButton);
        Button listenPracticeButton = findViewById(R.id.listenPracticeButton);
        Button sightReadingButton = findViewById(R.id.sightReadingButton);

        ImageView iconView = findViewById(R.id.iconView);

        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);


        aboutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openAboutUsPage();
            }
        });

        practiceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openExercisePage();
            }
        });

        //Not yet finished
        listenPracticeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openAboutUsPage();
            }
        });


        sightReadingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openSightReadingMenuPage();
            }  });




    }
    public void openExercisePage() {
        Intent intent = new Intent(this, PracticeActivity.class);
        startActivity(intent);
    }

    public void openSightReadingMenuPage() {
        Intent intent = new Intent(this, SightReadingMenuActivity.class);
        startActivity(intent);
    }

    public void openAboutUsPage() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


}
