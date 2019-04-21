package comnicoletangsyinfinite.httpsgithub.infinite;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
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

public class RightHandPractice extends AppCompatActivity{
    public static final RecordedMusicNotes A_RECORDED_MUSIC_NOTES = new RecordedMusicNotes();
    private boolean mStartRecording = true;
    private boolean mStartPlaying = true;
    private static final String LOG_TAG = "AudioRecordTest";
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private static String mFileName = null;
    private ImageView greenLineView;
    private Animation greenLineAnim;
    private ImageView greenLineView2;
    private Animation greenLineAnim2;
    private ImageView greenLineView3;
    private Animation greenLineAnim3;
    public double prevPitch = 0.0;
    public double curPitch = 0.0;

    //private RecordButton mRecordButton = null;
    private MediaRecorder mRecorder = null;

    //private PlayButton mPlayButton = null;
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
        if (!permissionToRecordAccepted ) finish();

    }

    private void onRecord(boolean start, Button playRecordButton) {
        if (start) {
            startRecording();
        } else {
            //stopRecording();
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
            Log.e(LOG_TAG, "prepare() failed");
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }

    private void startRecording() {
        /*mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }*/

        AudioDispatcher dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(22050,1024,0);
        PitchDetectionHandler pdh = new PitchDetectionHandler() {
            @Override
            public void handlePitch(PitchDetectionResult result, AudioEvent e) {
                final float pitchInHz = result.getPitch();
                final Pitch pitch = new Pitch(pitchInHz);
                final aNote newNote = new aNote(pitch.getNote(), 4); //Assume noteDuration  = 4
                curPitch = newNote.getNote();
                if (newNote.getNote()>0.0 || curPitch!=prevPitch) {
                    A_RECORDED_MUSIC_NOTES.addNotes(newNote);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TextView text = (TextView) findViewById(R.id.textView2);
                            text.setText("Added: pitchInHz = " + pitchInHz + ", pitch = " + pitch.getPitch() + ", note = " + newNote.getNote());
                        }
                    });
                    prevPitch = curPitch;
                }


                /*curPitch = pitch.getPitch();
                if ((prevPitch.equals("") || !curPitch.equals(prevPitch)) && !curPitch.equals("")) {
                    A_RECORDED_MUSIC_NOTES.addNotes(newNote);
                    Log.e(LOG_TAG, "Pitchadded = " + curPitch);
                    prevPitch = curPitch;
                }*/
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

        AudioProcessor p = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.AMDF, 22050, 2048, pdh);
        dispatcher.addAudioProcessor(p);
        new Thread(dispatcher,"Audio Dispatcher").start();

        //mRecorder.start();
    }

    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_hand_practice);

        final Button recordButton = (Button)findViewById(R.id.recordButton);
        final Button playRecordButton = (Button)findViewById(R.id.playRecordButton);
        Button analyzeButton = (Button)findViewById(R.id.analyzeButton);
        final TextView text2 = (TextView) findViewById(R.id.textView2);
        greenLineView = (ImageView)findViewById(R.id.greenLineView);
        greenLineView2 = (ImageView)findViewById(R.id.greenLineView2);
        greenLineView3 = (ImageView)findViewById(R.id.greenLineView3);

         //text2.setText("Piano sheet animation");

        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        playRecordButton.setVisibility(View.GONE);

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

        mStartRecording = true;
        recordButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onRecord(mStartRecording,playRecordButton);

                if (mStartRecording) {
                    recordButton.setBackgroundResource(R.drawable.stopbutton);
                } else {
                    recordButton.setBackgroundResource(R.drawable.recordbutton);
                }
                mStartRecording = !mStartRecording;
            }
        });


        mStartPlaying = true;
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
