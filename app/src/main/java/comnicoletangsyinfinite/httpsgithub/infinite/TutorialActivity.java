package comnicoletangsyinfinite.httpsgithub.infinite;

import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import static comnicoletangsyinfinite.httpsgithub.infinite.MainActivity.soundPool;
import static comnicoletangsyinfinite.httpsgithub.infinite.MainActivity.sounds;

public class TutorialActivity extends AppCompatActivity implements View.OnClickListener {
    public static int note = 48;
    private String noteText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        final TextView NoteText = (TextView) findViewById(R.id.NoteText);
        final Button button = (Button) findViewById(R.id.button);
        final Map<String, Button> buttonMap = new HashMap<>();
        final String[] buttonKey = {"D", "E", "F", "G", "A", "B", "Cc", "Dd", "Gg", "Aa",
                "C1", "D1", "E1", "F1", "G1", "A1", "B1", "Cc1", "Dd1", "Ff1", "Gg1", "Aa1",
                "C2", "D2", "E2", "F2", "G2", "A2", "B2", "Cc2", "Dd2", "Ff2", "Gg2", "Aa2",
                "C3", "D3", "E3", "F3", "G3", "A3", "B3", "Cc3", "Dd3", "Ff3", "Gg3", "Aa3",
        };
        final Button C = (Button) findViewById(R.id.Ckey);
        final Button Ff = (Button) findViewById(R.id.Ffkey);

        C.setBackgroundColor(Color.GREEN);
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C.setBackgroundColor(Color.GREEN);
                Ff.setBackgroundColor(Color.BLACK);
                note = 48;
                NoteText.setText("middle C C4");
                Log.i("Note Changed", "" + note);
                //Change C4 View
            }
        });
        Ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ff.setBackgroundColor(Color.GREEN);
                C.setBackgroundResource(R.drawable.whitekey);
                note = 54;
                NoteText.setText("F sharp F#4");
                Log.i("Note Changed", "" + note);
                //Change F#4 View
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Play Sounds: ", "sound pool: sound[0][3][" + note + "]");
                soundPool.play(sounds[0][3][note], 1, 1, 0, 0, 1);
            }
        });


        for (int i=0; i<buttonKey.length; i++) {
            String source = buttonKey[i] + "key";
            Log.i("buttonKeyRID: ", "" + source);
            int resID = getResources().getIdentifier(source, "id", getPackageName());
            Button newButton = (Button) findViewById(resID);
            newButton.setOnClickListener(this);
            buttonMap.put(buttonKey[i], newButton);
        }
    }

    @Override
    public void onClick(View v) {

    }

    /*@Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.Ckey:
                break;
            case R.id.Dkey:
                break;
            case R.id.Ekey:
                break;
            case R.id.Fkey:
                break;
            case R.id.Gkey:
                break;
            case R.id.Akey:
                break;
            case R.id.Bkey:
                break;
            case R.id.Cckey:
                break;
            case R.id.Ddkey:
                break;
            case R.id.Ffkey:
                break;
            case R.id.Ggkey:
                break;
            case R.id.Aakey:
                break;
            case R.id.C1key:
                break;
            case R.id.D1key:
                break;
            case R.id.E1key:
                break;
            case R.id.F1key:
                break;
            case R.id.G1key:
                break;
            case R.id.A1key:
                break;
            case R.id.B1key:
                break;
            case R.id.Cc1key:
                break;
            case R.id.Dd1key:
                break;
            case R.id.Ff1key:
                break;
            case R.id.Gg1key:
                break;
            case R.id.Aa1key:
                break;
            case R.id.C2key:
                break;
            case R.id.D2key:
                break;
            case R.id.E2key:
                break;
            case R.id.F2key:
                break;
            case R.id.G2key:
                break;
            case R.id.A2key:
                break;
            case R.id.B2key:
                break;
            case R.id.Cc2key:
                break;
            case R.id.Dd2key:
                break;
            case R.id.Ff2key:
                break;
            case R.id.Gg2key:
                break;
            case R.id.Aa2key:
                break;
            case R.id.C3key:
                break;
            case R.id.D3key:
                break;
            case R.id.E3key:
                break;
            case R.id.F3key:
                break;
            case R.id.G3key:
                break;
            case R.id.A3key:
                break;
            case R.id.B3key:
                break;
            case R.id.Cc3key:
                break;
            case R.id.Dd3key:
                break;
            case R.id.Ff3key:
                break;
            case R.id.Gg3key:
                break;
            case R.id.Aa3key:
                break;
            case R.id.button:
                break;
        }*/
}
