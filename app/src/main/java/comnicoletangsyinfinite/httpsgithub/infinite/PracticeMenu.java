package comnicoletangsyinfinite.httpsgithub.infinite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class PracticeMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_menu);

        Button fakePiano = findViewById(R.id.withFakePianoButton);
        Button realPiano = findViewById(R.id.withRealPianoButton);

        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        fakePiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFakePianoPractice();
            }
        });


        realPiano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRealPianoPage();
            }
        });
    }

    public void openFakePianoPractice() {
        Intent intent = new Intent(this, PracticeActivity.class);
        startActivity(intent);
    }

    public void openRealPianoPage() {
        Intent intent = new Intent(this, PracticeWithPianoActivity.class);
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
            Intent intent = new Intent(PracticeMenu.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
