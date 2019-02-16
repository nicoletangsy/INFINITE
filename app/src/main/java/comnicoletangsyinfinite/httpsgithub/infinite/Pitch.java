package comnicoletangsyinfinite.httpsgithub.infinite;

public class Pitch {
    String pitch = "";

    /*public Pitch(float pitchInHz) {
        frequencey = pitchInHz;
        pitchConverted();
    }*/

    public String getPitch () {
        return "" + pitch;
    }

    public void pitchConverted (float frequencey) {
        if (frequencey > 16) {
            if (frequencey < 294) {
                pitch = "C4";
            } else if (frequencey < 311) {
                pitch = "D4";
            } else if (frequencey < 349) {
                pitch = "E4";
            } else if (frequencey < 370) {
                pitch = "F4";
            } else if (frequencey < 415) {
                pitch = "G4";
            } else if (frequencey < 466) {
                pitch = "A4";
            } else if (frequencey < 523) {
                pitch = "B4";
            } else if (frequencey < 554) {
                pitch = "C5";
            }
            /*
            if (frequencey < 278) {
                pitch = "C4";
            } else if (frequencey < 294) {
                pitch = "C#4";
            } else if (frequencey < 311) {
                pitch = "D4";
            } else if (frequencey < 330) {
                pitch = "D#4";
            } else if (frequencey < 349) {
                pitch = "E4";
            } else if (frequencey < 370) {
                pitch = "F4";
            } else if (frequencey < 392) {
                pitch = "F#4";
            } else if (frequencey < 415) {
                pitch = "G4";
            } else if (frequencey < 440) {
                pitch = "G#4";
            } else if (frequencey < 466) {
                pitch = "A4";
            } else if (frequencey < 494) {
                pitch = "A#4";
            } else if (frequencey < 523) {
                pitch = "B4";
            } else if (frequencey < 554) {
                pitch = "C5";
            }
            */
        }
    }
}
