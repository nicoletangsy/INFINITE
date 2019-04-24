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

import static comnicoletangsyinfinite.httpsgithub.infinite.RightHandPractice.A_RECORDED_MUSIC_NOTES;
//import static comnicoletangsyinfinite.httpsgithub.infinite.Analyzer.A_RECORDED_MUSIC_NOTES;
import static comnicoletangsyinfinite.httpsgithub.infinite.RightHandReading.A_Music_Sheet_Type;

public class RightHandFeedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_hand_feedback);

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
            Intent intent = new Intent(RightHandFeedback.this, RightHandPractice.class);
            startActivity(intent);
            finish();
            A_Music_Sheet_Type.changedToOriginal();
        }
        return super.onOptionsItemSelected(menuItem);
    }


}
