package comnicoletangsyinfinite.httpsgithub.infinite;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;

import static comnicoletangsyinfinite.httpsgithub.infinite.MainActivity.soundPool;
import static comnicoletangsyinfinite.httpsgithub.infinite.MainActivity.sounds;
import static comnicoletangsyinfinite.httpsgithub.infinite.RightHandReading.A_GENERATED_MUSIC_NOTES;

public class PracticeWithPianoActivity extends AppCompatActivity {
    private AudioDispatcher dispatcher;
    double randomNote;
    private TextView correctText;

    // Requesting permission to RECORD_AUDIO
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private boolean permissionToRecordAccepted = false;
    private String[] permissions = {Manifest.permission.RECORD_AUDIO};

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_RECORD_AUDIO_PERMISSION:
                permissionToRecordAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (!permissionToRecordAccepted) finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_with_piano);

        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);

        correctText = (TextView) findViewById(R.id.checkCorrectText);
        setRandomNote();
        dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);
        PitchDetectionHandler pdh = new PitchDetectionHandler() {
            @Override
            public void handlePitch(PitchDetectionResult result, AudioEvent e) {
                final float pitchInHz = result.getPitch();
                if (pitchInHz > 254 && pitchInHz < 680) {
                    final Pitch pitch = new Pitch(pitchInHz);
                    if (pitch.getNote()==randomNote) {
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                correctText.setText("Correct!");
                            }
                        }, 1000);
                        setRandomNote();
                    } else {
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                correctText.setText("Wrong! Please Try Again!");
                            }
                        }, 1000);
                    }
                }
            }
        };
        AudioProcessor p = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.AMDF, 22050, 1024, pdh);
        dispatcher.addAudioProcessor(p);
        new Thread(dispatcher, "Audio Dispatcher").start();


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
            Intent intent = new Intent(PracticeWithPianoActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    protected void onStop() {
        super.onStop();
        dispatcher.stop();
    }

    public void setRandomNote() {
        int random = (int) Math.random()*30 + 34;
        randomNote = (double) random;
        //implements draw note...
    }
}
