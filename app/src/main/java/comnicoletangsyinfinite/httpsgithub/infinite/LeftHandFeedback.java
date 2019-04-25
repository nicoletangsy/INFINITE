package comnicoletangsyinfinite.httpsgithub.infinite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import static comnicoletangsyinfinite.httpsgithub.infinite.LeftHandPractice.A_RECORDED_MUSIC_NOTES;
//import static comnicoletangsyinfinite.httpsgithub.infinite.Analyzer.A_RECORDED_MUSIC_NOTES;
import static comnicoletangsyinfinite.httpsgithub.infinite.LeftHandReading.A_Music_Sheet_Type;
import static comnicoletangsyinfinite.httpsgithub.infinite.LeftHandReading.A_GENERATED_MUSIC_NOTES;

public class LeftHandFeedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_hand_feedback);

        //Button playButton = findViewById(R.id.playButton);
        Button previousPageButton = findViewById(R.id.previousPageButton);
        Button nextPageButton = findViewById(R.id.nextPageButton);
        TextView pageNubmer = findViewById(R.id.pageNumber);
        //TextView original = findViewById(R.id.original2);
        String oNotes = "";
        //original.setText("" + oNotes);
        TextView result = findViewById(R.id.result2);
        result.setText(A_RECORDED_MUSIC_NOTES.getAllNotes());

        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        TextView feedback = findViewById(R.id.feedback);
//        String str = "";
//        if (oNotes.equals(A_RECORDED_MUSIC_NOTES.getAllNotes())) {
//            str = "Well Done! You're perfectly right!";
//        } else {
//            str = "Opps... Some notes play wrongly!";
//        }
//        feedback.setText(str);
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
            Intent intent = new Intent(LeftHandFeedback.this, LeftHandPractice.class);
            startActivity(intent);
            finish();
            A_Music_Sheet_Type.changedToOriginal();
        }

        return super.onOptionsItemSelected(menuItem);
    }


}
