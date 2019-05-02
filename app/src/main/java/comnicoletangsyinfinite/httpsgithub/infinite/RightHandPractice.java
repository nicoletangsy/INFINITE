package comnicoletangsyinfinite.httpsgithub.infinite;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
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
import android.view.animation.LinearInterpolator;
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

import static comnicoletangsyinfinite.httpsgithub.infinite.MainActivity.soundPool;
import static comnicoletangsyinfinite.httpsgithub.infinite.MainActivity.sounds;
import static comnicoletangsyinfinite.httpsgithub.infinite.RightHandReading.A_Music_Sheet_Type;
import static comnicoletangsyinfinite.httpsgithub.infinite.PianoSheetView.FIRST_NOTE;
import static comnicoletangsyinfinite.httpsgithub.infinite.RightHandReading.A_GENERATED_MUSIC_NOTES;

public class RightHandPractice extends AppCompatActivity {
    public static final RecordedMusicNotes A_RECORDED_MUSIC_NOTES = new RecordedMusicNotes();
    public static final CompareMusicSheet A_COMPARE_MUSIC_SHEET = new CompareMusicSheet();

    private AudioDispatcher dispatcher;
    private boolean mStartRecording = true;
    private boolean mStartPlaying = true;
    private boolean mStartPlayingNote = true;
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private static String mFileName = null;
    private static final int sampleRate = 22050;
    private static final int byteBuffer = 1024;


    private TextView tempo;
    String added = "";
    private MediaRecorder mRecorder = null;
    private MediaPlayer mPlayer = null;
    private MediaPlayer NotePlayer;
    private boolean isNotePlaying = false;

    Handler handler = new Handler();
    private static final String TAG = "Resource: ";
    private static final String TAG2 = "Recorded Note: ";

    // Requesting permission to RECORD_AUDIO
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

    private void onRecord(boolean start, Button playRecordButton) {
        if (start) {
            //startRecording();
            startDetecting();
        } else {
            stopRecording();
            //playRecordButton.setVisibility(View.VISIBLE);
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

    private void onPlayNote(boolean start) {
        if (start) {
            startPlayingNotes();
        } else {
            stopPlayingNotes();
        }
    }

    private void startPlayingNotes() {
        final int tempo = (int) A_GENERATED_MUSIC_NOTES.getTempo();
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            int i = 3;
            int temp = mapTempo(tempo);
            int note = ((int) Math.floor(A_GENERATED_MUSIC_NOTES.getPianoSheet().get(i).get(0)));
            int noteDuration = (int) Math.round(A_GENERATED_MUSIC_NOTES.getPianoSheet().get(i).get(1));
            int duration = mapDuration(noteDuration);
            int delay = (tempo) * 1000 / 60 * 4 / noteDuration;

            @Override
            public void run() {
                if (sounds[temp][duration][note] != -1) {
                    soundPool.play(sounds[temp][duration][note], 1, 1, 0, 0, 1);
                    Log.i(TAG, "Sound Play: [" + temp + "][" + duration + "][" + note + "]");
                } else {
                    Log.i(TAG, "No this note: sounds[" + temp + "][" + duration + "][" + note + "]");
                }
                handler.postDelayed(this, delay);
                if (i < A_GENERATED_MUSIC_NOTES.getPianoSheet().size() - 1) {
                    i++;
                    temp = mapTempo(tempo);
                    note = ((int) Math.floor(A_GENERATED_MUSIC_NOTES.getPianoSheet().get(i).get(0)));
                    noteDuration = (int) Math.round(A_GENERATED_MUSIC_NOTES.getPianoSheet().get(i).get(1));
                    duration = mapDuration(noteDuration);
                    delay = (tempo) * 1000 / 60 * 4 / noteDuration;
                } else {
                    handler.removeCallbacks(this);
                }
            }
        });
    }

    private void stopPlayingNotes() {
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
        dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);
        PitchDetectionHandler pdh = new PitchDetectionHandler() {
            @Override
            public void handlePitch(PitchDetectionResult result, AudioEvent e) {
                final float pitchInHz = result.getPitch();
                if (pitchInHz > 107 && pitchInHz < 719.5) {
                    final Pitch pitch = new Pitch(pitchInHz);
                    final double db = e.getdBSPL();
                    final double timeStamp = e.getTimeStamp();
                    final aNote newNote = new aNote(pitch.getNote(), db, timeStamp);
//                    final TextView text = (TextView) findViewById(R.id.textView2);
                    String dBSPL = String.format("%.1f", db);
                    String time = String.format("%.2f", timeStamp);
                    added = added + "[" + dBSPL + ", " + time + ", " + pitchInHz + ", " + pitch.getPitch() + "] ";
                    A_RECORDED_MUSIC_NOTES.addNotes(newNote);
                    Log.i(TAG2, added);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
//                            text.setText(""); //added
                        }
                    });
                }
            }
        };
        AudioProcessor p = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.AMDF, 22050, 1024, pdh);
        dispatcher.addAudioProcessor(p);
        new Thread(dispatcher, "Audio Dispatcher").start();
    }

    private void stopRecording() {
        A_RECORDED_MUSIC_NOTES.ProcessNote();
        String recorded = A_RECORDED_MUSIC_NOTES.getAllNotes();
        Log.i(TAG2, recorded);
        dispatcher.stop();
        A_COMPARE_MUSIC_SHEET.setGeneratedMusicSheet(A_GENERATED_MUSIC_NOTES.getPianoSheet());
        A_COMPARE_MUSIC_SHEET.setRecordedMusicNotes(A_RECORDED_MUSIC_NOTES.getPianoSheet());
        A_COMPARE_MUSIC_SHEET.compareTwoSheet();
//        A_COMPARE_MUSIC_SHEET.compareTwoSheet1();
//        A_COMPARE_MUSIC_SHEET.compareTwoSheet2();
        /*mRecorder.stop();
        mRecorder.release();
        mRecorder = null;*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_hand_practice);

        final Button recordButton = (Button) findViewById(R.id.recordButton);
        final Button playRecordButton = (Button) findViewById(R.id.playRecordButton);
        final Button playNoteButton = (Button) findViewById(R.id.playNoteButton);
        playRecordButton.setVisibility(View.GONE);
        final Button analyzeButton = (Button) findViewById(R.id.analyzeButton);
        final TextView text2 = (TextView) findViewById(R.id.textView2);

        Button startButton = findViewById(R.id.StartPractiseButton);

        TextView bpmIcon = findViewById(R.id.bpmIcon);
        TextView bpm = findViewById(R.id.bpm);


        Log.v("aqaqaqaqaq",""+A_GENERATED_MUSIC_NOTES.getPianoSheet());
        bpm.setText(" = " + A_GENERATED_MUSIC_NOTES.getPianoSheet().get(0).get(0));

        bpmIcon.setTextSize(25);
        bpmIcon.setText("\u2669");


        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Record to the external cache directory for visibility
        mFileName = getExternalCacheDir().getAbsolutePath();
        mFileName += "/audiorecordtest.aac";
        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);

        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecord(mStartRecording, playRecordButton);
                if (mStartRecording) {
                    recordButton.setText("Stop");
                    recordButton.setBackgroundResource(R.drawable.button_clicked);
                } else {
                    recordButton.setText("Start");
                    recordButton.setBackgroundResource(R.drawable.button);
                }
                mStartRecording = !mStartRecording;
            }
        });

        playRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlay(mStartPlaying);
                if (mStartPlaying) {
                    playRecordButton.setBackgroundResource(R.drawable.stopbutton);
                } else {
                    playRecordButton.setBackgroundResource(R.drawable.playbutton);
                }
                mStartPlaying = !mStartPlaying;
            }
        });

        playNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPlayNote(mStartPlayingNote);
                if (mStartPlayingNote) {
                    playRecordButton.setText("Stop");
                } else {
                    playRecordButton.setText("Hint");
                }
                mStartPlayingNote = !mStartPlayingNote;
            }
        });

        analyzeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnalyze();
            }
        });
    }

    public void startAnalyze() {
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
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public int mapTempo(int tempo) {
        if (tempo == 60) {
            return 0;
        } else if (tempo == 80) {
            return 1;
        } else if (tempo == 120) {
            return 2;
        } else {
            return 0;
        }
    }

    public int mapDuration(int noteDuration) {
        if (noteDuration == 1) {
            return 0;
        } else if (noteDuration == 3) {
            return 1;
        } else if (noteDuration == 2) {
            return 2;
        } else if (noteDuration == 4) {
            return 3;
        } else if (noteDuration == 8) {
            return 4;
        } else {
            return 0;
        }
    }

}
