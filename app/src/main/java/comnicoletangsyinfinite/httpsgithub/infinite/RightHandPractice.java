package comnicoletangsyinfinite.httpsgithub.infinite;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioFormat;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;

import static comnicoletangsyinfinite.httpsgithub.infinite.RightHandReading.A_Music_Sheet_Type;
import static comnicoletangsyinfinite.httpsgithub.infinite.PianoSheetView.FIRST_NOTE;
import static comnicoletangsyinfinite.httpsgithub.infinite.RightHandReading.A_GENERATED_MUSIC_NOTES;

public class RightHandPractice extends AppCompatActivity{
    public static final RecordedMusicNotes A_RECORDED_MUSIC_NOTES = new RecordedMusicNotes();
    public static final CompareMusicSheet A_COMPARE_MUSIC_SHEET = new CompareMusicSheet();

    private AudioDispatcher dispatcher;
    private boolean mStartRecording = true;
    private boolean mStartPlaying = true;
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private static String mFileName = null;
    private static final int sampleRate = 22050;
    private static final int byteBuffer = 1024;

    private ImageView greenLineView;
    private Animation greenLineAnim;
    private ImageView greenLineView2;
    private Animation greenLineAnim2;
    private ImageView greenLineView3;
    private Animation greenLineAnim3;
    public double prevPitch = 0.0;
    public double curPitch = 0.0;

    String added = "";
    private MediaRecorder mRecorder = null;
    private MediaPlayer mPlayer = null;

    // Requesting permission to RECORD_AUDIO
    private boolean permissionToRecordAccepted = false;
    private String [] permissions = {Manifest.permission.RECORD_AUDIO};
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_RECORD_AUDIO_PERMISSION:
                permissionToRecordAccepted  = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (!permissionToRecordAccepted) finish();

    }

    private void onRecord(boolean start, Button playRecordButton) {
        if (start) {
            //startRecording();
            startDetecting();
        } else {
            stopRecording();
            playRecordButton.setVisibility(View.VISIBLE);
            A_Music_Sheet_Type.changedToUserPlay();
        }
    }
    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }

    private void startPlaying() {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(mFileName);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }

    private void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try {
            mRecorder.prepare();
        } catch (IOException e) {
        }
        mRecorder.start();
    }

    private void startDetecting() {
        A_RECORDED_MUSIC_NOTES.removeAllRecords();
        dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(22050,1024,0);
        PitchDetectionHandler pdh = new PitchDetectionHandler() {
            @Override
            public void handlePitch(PitchDetectionResult result, AudioEvent e) {
                final float pitchInHz = result.getPitch();
                if (pitchInHz>31 && pitchInHz<7900) {
                    final Pitch pitch = new Pitch(pitchInHz);
                    final double db = e.getdBSPL();
                    final double timeStamp = e.getTimeStamp();
                    final aNote newNote = new aNote(pitch.getNote(), db, timeStamp);
                    final TextView text = (TextView) findViewById(R.id.textView2);
                    String dBSPL = String.format("%.1f", db);
                    String time = String.format("%.2f", timeStamp);
                    added = added + "[" + dBSPL + ", " + time + ", " + pitchInHz + ", " + pitch.getPitch() + "] ";
                    A_RECORDED_MUSIC_NOTES.addNotes(newNote);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            text.setText(""); //added
                        }
                    });
                }
            }
        };
        float width = ((View) greenLineView.getParent()).getWidth();
        greenLineAnim = new TranslateAnimation(0,width-width/32-(float)FIRST_NOTE.getX(),0,0);
        greenLineAnim.setDuration((int)FIRST_NOTE.getSpeed());

        greenLineView.setVisibility(View.VISIBLE);
        greenLineView.startAnimation(greenLineAnim);
        greenLineView.setVisibility(View.INVISIBLE);

        greenLineAnim2 = new TranslateAnimation(0,width-width/32-(float)FIRST_NOTE.getX(),0,0);
        greenLineAnim2.setDuration((int)FIRST_NOTE.getSpeed());
        greenLineAnim2.setStartOffset((int)FIRST_NOTE.getSpeed());

        greenLineView2.setVisibility(View.VISIBLE);
        greenLineView2.startAnimation(greenLineAnim2);
        greenLineView2.setVisibility(View.INVISIBLE);

        greenLineAnim3 = new TranslateAnimation(0,width-width/32-(float)FIRST_NOTE.getX(),0,0);
        greenLineAnim3.setDuration((int)FIRST_NOTE.getSpeed());
        greenLineAnim3.setStartOffset((int)FIRST_NOTE.getSpeed()*2);

        greenLineView3.setVisibility(View.VISIBLE);
        greenLineView3.startAnimation(greenLineAnim3);
        greenLineView3.setVisibility(View.INVISIBLE);

        AudioProcessor p = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.AMDF, 22050, 1024, pdh);
        dispatcher.addAudioProcessor(p);
        new Thread(dispatcher,"Audio Dispatcher").start();
    }

    private void stopRecording() {
        A_RECORDED_MUSIC_NOTES.ProcessNote();
        dispatcher.stop();
        A_COMPARE_MUSIC_SHEET.setGeneratedMusicSheet(A_GENERATED_MUSIC_NOTES.getPianoSheet());
        A_COMPARE_MUSIC_SHEET.setRecordedMusicNotes(A_RECORDED_MUSIC_NOTES.getPianoSheet());
        A_COMPARE_MUSIC_SHEET.compareTwoSheet();
        /*mRecorder.stop();
        mRecorder.release();
        mRecorder = null;*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_hand_practice);

        final Button recordButton = (Button)findViewById(R.id.recordButton);
        final Button playRecordButton = (Button)findViewById(R.id.playRecordButton);
        playRecordButton.setVisibility(View.GONE);
        final Button analyzeButton = (Button)findViewById(R.id.analyzeButton);
        final TextView text2 = (TextView) findViewById(R.id.textView2);
        greenLineView = (ImageView)findViewById(R.id.greenLineView);
        greenLineView2 = (ImageView)findViewById(R.id.greenLineView2);
        greenLineView3 = (ImageView)findViewById(R.id.greenLineView3);

        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Record to the external cache directory for visibility
        mFileName = getExternalCacheDir().getAbsolutePath();
        mFileName += "/audiorecordtest.aac";
        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);

        greenLineView.setX((float)FIRST_NOTE.getX());
        greenLineView.setY((float)FIRST_NOTE.getY());
        greenLineView.getLayoutParams().height = (int)FIRST_NOTE.getHeight();

        greenLineView2.setX((float)FIRST_NOTE.getX());
        greenLineView2.setY((float)FIRST_NOTE.getLine2());
        greenLineView2.getLayoutParams().height = (int)FIRST_NOTE.getHeight();

        greenLineView3.setX((float)FIRST_NOTE.getX());
        greenLineView3.setY((float)FIRST_NOTE.getLine3());
        greenLineView3.getLayoutParams().height = (int)FIRST_NOTE.getHeight();

        recordButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onRecord(mStartRecording, playRecordButton);
                if (mStartRecording) {
                    recordButton.setBackgroundResource(R.drawable.stopbutton);
                } else {
                    recordButton.setBackgroundResource(R.drawable.recordbutton);
                }
                mStartRecording = !mStartRecording;
            }
        });

        playRecordButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onPlay(mStartPlaying);
                if (mStartPlaying) {
                    playRecordButton.setBackgroundResource(R.drawable.stopbutton);
                } else {
                    playRecordButton.setBackgroundResource(R.drawable.playbutton);
                }
                mStartPlaying = !mStartPlaying;
            }
        });

        analyzeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startAnalyze();
            }
        });
    }

    public void startAnalyze(){
        Intent intent = new Intent(this, RightHandFeedback.class);
        startActivity(intent);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mRecorder != null) {
            mRecorder.release();
            mRecorder = null;
        }
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
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
            Intent intent = new Intent(RightHandPractice.this, RightHandReading.class);
            startActivity(intent);
            finish();
            A_Music_Sheet_Type.changedToOriginal();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
