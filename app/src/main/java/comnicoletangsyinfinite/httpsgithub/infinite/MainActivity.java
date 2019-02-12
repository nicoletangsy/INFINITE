package comnicoletangsyinfinite.httpsgithub.infinite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button exerciseButton = findViewById(R.id.exerciseButton);
        Button readingButton = findViewById(R.id.readingButton);
        Button settingButton = findViewById(R.id.settingButton);
        ImageView imageView = findViewById(R.id.imageView3);

        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);



        exerciseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openExercisePage();
            }
        });

        readingButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openSightReadingMenuPage();
            }  });

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingPage();
            }
        });

        imageView.setImageResource(R.drawable.image);


    }
    public void openExercisePage() {
        Intent intent = new Intent(this, PracticeActivity.class);
        startActivity(intent);
    }

    public void openSightReadingMenuPage() {
        Intent intent = new Intent(this, SightReadingMenuActivity.class);
        startActivity(intent);
    }

    public void openSettingPage(){
        //edit to test page
        Intent intent = new Intent(this, testActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


}
