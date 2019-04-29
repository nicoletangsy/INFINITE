package comnicoletangsyinfinite.httpsgithub.infinite;

import android.content.Intent;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

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

    public static SoundPool soundPool = new SoundPool.Builder().setMaxStreams(2).build();
    public static int[][][] sounds = new int[3][5][108]; //sounds[tempo][noteDuration][Notes];
    private static final String TAG = "Resource: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSoundPool();

        Button aboutButton = findViewById(R.id.aboutButton);
        Button tutorialButton = findViewById(R.id.tutorialButton);
        Button practiceButton = findViewById(R.id.practiceButton);
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

        tutorialButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openTutorialPage();
            }
        });

        practiceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPracticeMenuPage();
            }
        });

        sightReadingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSightReadingMenuPage();
            }
        });
    }

    public void openAboutUsPage() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void openTutorialPage() {
        Intent intent = new Intent(this, TutorialActivity.class);
        startActivity(intent);
    }

    public void openPracticeMenuPage() {
        Intent intent = new Intent(this, PracticeMenu.class);
        startActivity(intent);
    }

    public void openSightReadingMenuPage() {
        Intent intent = new Intent(this, SightReadingMenuActivity.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    private void startAsyncTask (View v) {

    }

    private class DownloadSoundsTask extends AsyncTask<Integer, Integer, String> {
        @Override
        protected String doInBackground(Integer... integers) {
            return "Finished!";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    public void initSoundPool() {
        for (int k=0; k<3; k++) {
            for (int i=0; i<5; i++) {
                for (int j=33; j<65; j++) {
                    String source = "raw/n" + k + "_" + i + "_" + j;
                    Log.i(TAG, "Resource: " + source);
                    int resID = getResources().getIdentifier(source, null, getPackageName());
                    if (resID!=0) {
                        Log.i(TAG, "Success!");
                        sounds[k][i][j] = soundPool.load(this, resID, 1);
                    } else {
                        sounds[0][i][j] = -1;
                    }
                }
            }
        }
    }
}
