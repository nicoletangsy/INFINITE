package comnicoletangsyinfinite.httpsgithub.infinite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class SightReadingMenuActivity extends AppCompatActivity {
    ArrayList<Button> buttons = new ArrayList<>();
    ArrayList<Integer> buttonUp = new ArrayList<>();
    int bpm;
    int hand;
    int key;
    int flat;
    int[] bpms = {60, 80, 120, -1};
    int[] hands = {0, 1, -1};
    int[] no = {0, 4, 7, 23, 40};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sight_reading_menu);

        //0-35
        Button bpm60 = findViewById(R.id.bpm60);
        Button bpm80 = findViewById(R.id.bpm80);
        Button bpm120 = findViewById(R.id.bpm120);
        Button bpmRandom = findViewById(R.id.bpmRandom);

        Button leftHandButton = findViewById(R.id.leftHandButton);
        Button rightHandButton = findViewById(R.id.rightHandButton);
        Button handRandom = findViewById(R.id.handRandom);

        Button CMajorButton = findViewById(R.id.CMajorButton);
        Button DMajorButton = findViewById(R.id.DMajorButton);
        Button EMajorButton = findViewById(R.id.EMajorButton);
        Button FMajorButton = findViewById(R.id.FMajorButton);
        Button GMajorButton = findViewById(R.id.GMajorButton);
        Button AMajorButton = findViewById(R.id.AMajorButton);
        Button BMajorButton = findViewById(R.id.BMajorButton);
        Button CcMajorButton = findViewById(R.id.CcMajorButton);
        Button GgMajorButton = findViewById(R.id.GgMajorButton);
        Button DdMajorButton = findViewById(R.id.DdMajorButton);
        Button AaMajorButton = findViewById(R.id.AaMajorButton);
        Button EeMajorButton = findViewById(R.id.EeMajorButton);
        Button BbMajorButton = findViewById(R.id.BbMajorButton);
        Button FFMajorButton = findViewById(R.id.FFMajorButton);
        Button CCMajorButton = findViewById(R.id.CCMajorButton);

        Button CminorButton = findViewById(R.id.CminorButton);
        Button DminorButton = findViewById(R.id.DminorButton);
        Button EminorButton = findViewById(R.id.EminorButton);
        Button FminorButton = findViewById(R.id.FminorButton);
        Button GminorButton = findViewById(R.id.GminorButton);
        Button AminorButton = findViewById(R.id.AminorButton);
        Button BminorButton = findViewById(R.id.BminorButton);
        Button AaminorButton = findViewById(R.id.AaminorButton);
        Button EeminorButton = findViewById(R.id.EeminorButton);
        Button BbminorButton = findViewById(R.id.BbminorButton);
        Button FFminorButton = findViewById(R.id.FFminorButton);
        Button CCminorButton = findViewById(R.id.CCminorButton);
        Button GGminorButton = findViewById(R.id.GGminorButton);
        Button DDminorButton = findViewById(R.id.DDminorButton);
        Button AAminorButton = findViewById(R.id.AAminorButton);
        Button Random = findViewById(R.id.random);

        buttons.add(bpm60);
        buttons.add(bpm80);
        buttons.add(bpm120);
        buttons.add(bpmRandom);

        buttons.add(leftHandButton);
        buttons.add(rightHandButton);
        buttons.add(handRandom);


        buttons.add(CcMajorButton);
        buttons.add(GgMajorButton);
        buttons.add(DdMajorButton);
        buttons.add(AaMajorButton);
        buttons.add(EeMajorButton);
        buttons.add(BbMajorButton);
        buttons.add(FMajorButton);
        buttons.add(CMajorButton);
        buttons.add(GMajorButton);
        buttons.add(DMajorButton);
        buttons.add(AMajorButton);
        buttons.add(EMajorButton);
        buttons.add(BMajorButton);
        buttons.add(FFMajorButton);
        buttons.add(CCMajorButton);

        buttons.add(AaminorButton);
        buttons.add(EeminorButton);
        buttons.add(BbminorButton);
        buttons.add(FminorButton);
        buttons.add(CminorButton);
        buttons.add(GminorButton);
        buttons.add(DminorButton);
        buttons.add(AminorButton);
        buttons.add(EminorButton);
        buttons.add(BminorButton);
        buttons.add(FFminorButton);
        buttons.add(CCminorButton);
        buttons.add(GGminorButton);
        buttons.add(DDminorButton);
        buttons.add(AAminorButton);
        buttons.add(Random);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        buttons.get(3).setBackgroundResource(R.drawable.button_clicked);
        buttons.get(6).setBackgroundResource(R.drawable.button_clicked);
        buttons.get(37).setBackgroundResource(R.drawable.button_clicked);


        for (int i = 0; i < 38; i++) {
            buttonUp.add(0);
        }

        buttonUp.set(3, 1);
        buttonUp.set(6, 1);
        buttonUp.set(37, 1);


        for (int i = 0; i < 38; i++) {
            final int k = i;
            buttons.get(k).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkUp(k);
                }
            });
        }


    }

    public void checkUp(int k) {
        if (buttonUp.get(k) == 0) {
            buttons.get(k).setBackgroundResource(R.drawable.button_clicked);
            buttonUp.set(k, 1);
            change(k);
        }

    }

    public void change(int k) {
        if (k < 4) {
            bpm = bpms[k];
            othersBpmButton(k);
        } else if (k < 7) {
            hand = hands[k - 4];
            othersHandButton(k);
        } else {
            changeKey(k);
            othersMmButton(k);
        }
    }

    public void othersBpmButton(int k) {
        for (int a = 0; a < 4; a++) {
            if (a != k) {
                if (buttonUp.get(a) == 1) {
                    buttonReset(a);
                }
            }
        }
    }

    public void othersHandButton(int k) {
        for (int a = 4; a < 7; a++) {
            if (a != k) {
                if (buttonUp.get(a) == 1) {
                    buttonReset(a);
                }
            }
        }

    }

    public void othersMmButton(int k) {
        for (int a = 7; a < 38; a++) {
            if (a != k) {
                if (buttonUp.get(a) == 1) {
                    buttonReset(a);
                }
            }
        }

    }

    public void changeKey(int k){
        if(k<15){
            key = 14-k;
            flat = 0;
        }
        else if(k<22){
            key = k-14;
            flat = 1;
        }
        else if(k<30){
            key = 29-k;
            flat = 0;
        }
        else if(k<37){
            key = k-29;
            flat = 1;
        }
        Log.v("ififif",""+flat+":"+key);
    }
    public void buttonReset(int k) {
        buttons.get(k).setBackgroundResource(R.drawable.button);
        buttonUp.set(k, 0);
    }

    public void openleftHandPracticePage() {
        Intent intent = new Intent(this, LeftHandReading.class);
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
            Intent intent = new Intent(SightReadingMenuActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
