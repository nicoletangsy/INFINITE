package comnicoletangsyinfinite.httpsgithub.infinite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SightReadingMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sight_reading_menu);

        Button lButton = findViewById(R.id.leftHandPracticeButton);
        Button rButton = findViewById(R.id.rightHandPracticeButton);
        Button bButton = findViewById(R.id.bothHandsPracticeButton);

        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);



        lButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openleftHandPracticePage();
            }
        });

        rButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openrightHandPracticePage();
            }  });

        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbothHandsPracticePage();
            }
        });

    }
    public void openleftHandPracticePage() {
        //Intent intent = new Intent(this, PracticeActivity.class);
        //startActivity(intent);
    }

    public void openrightHandPracticePage() {
        Intent intent = new Intent(this, RightHandPractice.class);
        startActivity(intent);
    }

    public void openbothHandsPracticePage(){
        //Intent intent = new Intent(this, SettingActivity.class);
        //startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


}
