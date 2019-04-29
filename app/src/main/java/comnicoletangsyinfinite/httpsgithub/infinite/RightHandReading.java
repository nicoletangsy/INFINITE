package comnicoletangsyinfinite.httpsgithub.infinite;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RightHandReading extends AppCompatActivity {
    public static final MusicSheetType A_Music_Sheet_Type = new MusicSheetType();
    public static final GeneratedMusicNotes A_GENERATED_MUSIC_NOTES = new GeneratedMusicNotes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_hand_reading);

        Intent intent = getIntent();
        int tempo = intent.getIntExtra("bpm",-1);
        int hand = intent.getIntExtra("hand",-1);
        int flatSharp = intent.getIntExtra("flatSharp",-1);
        int key = intent.getIntExtra("key",-1);



        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        A_GENERATED_MUSIC_NOTES.generateSheet((double)tempo,(double)hand,(double)flatSharp,(double)key);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Button startButton = findViewById(R.id.StartPractiseButton);
//        TextView bpmIcon = findViewById(R.id.bpmIcon);
//        TextView bpm = findViewById(R.id.bpm);
//        bpm.setTextColor(Color.BLACK);
//        bpmIcon.setTextColor(Color.BLACK);
//        bpmIcon.setTextSize(25);
//        bpmIcon.setText("\u2669");
//        bpm.setText(" = " + A_GENERATED_MUSIC_NOTES.getTempo());




        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSightReading();
            }
        });

    }

    public void startSightReading() {
        Intent intent = new Intent(this, RightHandPractice.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            Intent intent = new Intent(RightHandReading.this, SightReadingMenuActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
