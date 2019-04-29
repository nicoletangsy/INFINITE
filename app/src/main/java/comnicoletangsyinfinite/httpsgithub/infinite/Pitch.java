package comnicoletangsyinfinite.httpsgithub.infinite;

public class Pitch {
    String pitch = "";  //value: C0~B8
    double note;        //value: 0~107
    int noteDuration;   //value:[1, 2, 4, 8, 16]

    public Pitch(float pitchInHz) {
        pitchConverted(pitchInHz);
    }

    public String getPitch () {
        return "" + pitch;
    }
    public double getNote () { return this.note; }
    public int getNoteDuration () { return this.noteDuration; }

    public void setNoteDuration (int x) {
        noteDuration = x;
    }

    //frequency table
    public void pitchConverted (float frequencey) {
        if (frequencey > 16) {
            if (frequencey < 16.5) {
                pitch = "C0";
                note = 0;
            } else if (frequencey < 17.5) {
                pitch = "C#0";
                note = 1;
            } else if (frequencey < 19) {
                pitch = "D0";
                note = 2;
            } else if (frequencey < 20.5) {
                pitch = "D#0";
                note = 3;
            } else if (frequencey < 21.5) {
                pitch = "E0";
                note = 4;
            } else if (frequencey < 22.5) {
                pitch = "F0";
                note = 5;
            } else if (frequencey < 24) {
                pitch = "F#0";
                note = 6;
            } else if (frequencey < 25.5) {
                pitch = "G0";
                note = 7;
            } else if (frequencey < 27) {
                pitch = "G#0";
                note = 8;
            } else if (frequencey < 28.5) {
                pitch = "A0";
                note = 9;
            } else if (frequencey < 30) {
                pitch = "A#0";
                note = 10;
            } else if (frequencey < 32) {
                pitch = "B0";
                note = 11;
            } else if (frequencey < 34) {
                pitch = "C1";
                note = 12;
            } else if (frequencey < 36) {
                pitch = "C#1";
                note = 13;
            } else if (frequencey < 38) {
                pitch = "D1";
                note = 14;
            } else if (frequencey < 40) {
                pitch = "D#1";
                note = 15;
            } else if (frequencey < 42.5) {
                pitch = "E1";
                note = 16;
            } else if (frequencey < 45) {
                pitch = "F1";
                note = 17;
            } else if (frequencey < 47.5) {
                pitch = "F#1";
                note = 18;
            } else if (frequencey < 50.5) {
                pitch = "G1";
                note = 19;
            } else if (frequencey < 53.5) {
                pitch = "G#1";
                note = 20;
            } else if (frequencey < 56.5) {
                pitch = "A1";
                note = 21;
            } else if (frequencey < 60) {
                pitch = "A#1";
                note = 22;
            } else if (frequencey < 63.5) {
                pitch = "B1";
                note = 23;
            } else if (frequencey < 67) {
                pitch = "C2";
                note = 24;
            } else if (frequencey < 71) {
                pitch = "C#2";
                note = 25;
            } else if (frequencey < 75.5) {
                pitch = "D2";
                note = 26;
            } else if (frequencey < 80) {
                pitch = "D#2";
                note = 27;
            } else if (frequencey < 84.5) {
                pitch = "E2";
                note = 28;
            } else if (frequencey < 90) {
                pitch = "F2";
                note = 29;
            } else if (frequencey < 95.5) {
                pitch = "F#2";
                note = 30;
            } else if (frequencey < 101) {
                pitch = "G2";
                note = 31;
            } else if (frequencey < 107) {
                pitch = "G#2";
                note = 32;
            } else if (frequencey < 113.5) {
                pitch = "A2";
                note = 33;
            } else if (frequencey < 120.5) {
                pitch = "A#2";
                note = 34;
            } else if (frequencey < 127.5) {
                pitch = "B2";
                note = 35;
            } else if (frequencey < 135) {
                pitch = "C3";
                note = 36;
            } else if (frequencey < 143) {
                pitch = "C#3";
                note = 37;
            } else if (frequencey < 151.5) {
                pitch = "D3";
                note = 38;
            } else if (frequencey < 160.5) {
                pitch = "D#3";
                note = 39;
            } else if (frequencey < 170) {
                pitch = "E3";
                note = 40;
            } else if (frequencey < 180) {
                pitch = "F3";
                note = 41;
            } else if (frequencey < 190.5) {
                pitch = "F#3";
                note = 42;
            } else if (frequencey < 202) {
                pitch = "G3";
                note = 43;
            } else if (frequencey < 214) {
                pitch = "G#3";
                note = 44;
            } else if (frequencey < 226.5) {
                pitch = "A3";
                note = 45;
            } else if (frequencey < 240) {
                pitch = "A#3";
                note = 46;
            } else if (frequencey < 254.5) {
                pitch = "B3";
                note = 47;
            } else if (frequencey < 270) {
                pitch = "C4";
                note = 48;
            } else if (frequencey < 286) {
                pitch = "C#4";
                note = 49;
            } else if (frequencey < 302.5) {
                pitch = "D4";
                note = 50;
            } else if (frequencey < 320.5) {
                pitch = "D#4";
                note = 51;
            } else if (frequencey < 339.5) {
                pitch = "E4";
                note = 52;
            } else if (frequencey < 359.5) {
                pitch = "F4";
                note = 53;
            } else if (frequencey < 381) {
                pitch = "F#4";
                note = 54;
            } else if (frequencey < 403.5) {
                pitch = "G4";
                note = 55;
            } else if (frequencey < 427.5) {
                pitch = "G#4";
                note = 56;
            } else if (frequencey < 453) {
                pitch = "A4";
                note = 57;
            } else if (frequencey < 480) {
                pitch = "A#4";
                note = 58;
            } else if (frequencey < 508.5) {
                pitch = "B4";
                note = 59;
            } else if (frequencey < 538.5) {
                pitch = "C5";
                note = 60;
            } else if (frequencey < 570.5) {
                pitch = "C#5";
                note = 61;
            } else if (frequencey < 604.5) {
                pitch = "D5";
                note = 62;
            } else if (frequencey < 640.5) {
                pitch = "D#5";
                note = 63;
            } else if (frequencey < 679) {
                pitch = "E5";
                note = 64;
            } else if (frequencey < 719.5) {
                pitch = "F5";
                note = 65;
            } else if (frequencey < 762) {
                pitch = "F#5";
                note = 66;
            } else if (frequencey < 807.5) {
                pitch = "G5";
                note = 67;
            } else if (frequencey < 855.5) {
                pitch = "G#5";
                note = 68;
            } else if (frequencey < 906) {
                pitch = "A5";
                note = 69;
            } else if (frequencey < 960) {
                pitch = "A#5";
                note = 70;
            } else if (frequencey < 1017.5) {
                pitch = "B5";
                note = 71;
            } else if (frequencey < 1078) {
                pitch = "C6";
                note = 72;
            } else if (frequencey < 1142) {
                pitch = "C#6";
                note = 73;
            } else if (frequencey < 1210) {
                pitch = "D6";
                note = 74;
            } else if (frequencey < 1282) {
                pitch = "D#6";
                note = 75;
            } else if (frequencey < 1358) {
                pitch = "E6";
                note = 76;
            } else if (frequencey < 1436) {
                pitch = "F6";
                note = 77;
            } else if (frequencey < 1521.5) {
                pitch = "F#6";
                note = 78;
            } else if (frequencey < 1614.5) {
                pitch = "G6";
                note = 79;
            } else if (frequencey < 1710.5) {
                pitch = "G#6";
                note = 80;
            } else if (frequencey < 1812.5) {
                pitch = "A6";
                note = 81;
            } else if (frequencey < 1920.55) {
                pitch = "A#6";
                note = 82;
            } else if (frequencey < 2034.5) {
                pitch = "B6";
                note = 83;
            } else if (frequencey < 2155.5) {
                pitch = "C7";
                note = 84;
            } else if (frequencey < 2283.5) {
                pitch = "C#7";
                note = 85;
            } else if (frequencey < 2419) {
                pitch = "D7";
                note = 86;
            } else if (frequencey < 2563) {
                pitch = "D#7";
                note = 87;
            } else if (frequencey < 2715.5) {
                pitch = "E7";
                note = 88;
            } else if (frequencey < 2877) {
                pitch = "F7";
                note = 89;
            } else if (frequencey < 3048) {
                pitch = "F#7";
                note = 90;
            } else if (frequencey < 3229) {
                pitch = "G7";
                note = 91;
            } else if (frequencey < 3421) {
                pitch = "G#7";
                note = 92;
            } else if (frequencey < 3624.5) {
                pitch = "A7";
                note = 93;
            } else if (frequencey < 3840) {
                pitch = "A#7";
                note = 94;
            } else if (frequencey < 4068.5) {
                pitch = "B7";
                note = 95;
            } else if (frequencey < 4310.5) {
                pitch = "C8";
                note = 96;
            } else if (frequencey < 4567) {
                pitch = "C#8";
                note = 97;
            } else if (frequencey < 4838.5) {
                pitch = "D8";
                note = 98;
            } else if (frequencey < 5126) {
                pitch = "D#8";
                note = 99;
            } else if (frequencey < 5431) {
                pitch = "E8";
                note = 100;
            } else if (frequencey < 5754) {
                pitch = "F8";
                note = 101;
            } else if (frequencey < 6096) {
                pitch = "F#8";
                note = 102;
            } else if (frequencey < 6458.5) {
                pitch = "G8";
                note = 103;
            } else if (frequencey < 6842.5) {
                pitch = "G#8";
                note = 104;
            } else if (frequencey < 7249.5) {
                pitch = "A8";
                note = 105;
            } else if (frequencey < 7680.5) {
                pitch = "A#8";
                note = 106;
            } else if (frequencey < 7903) {
                pitch = "B8";
                note = 107;
            }
        }
    }
            private void hardcode ( float frequencey){
                if (frequencey > 254.5) {
                    if (frequencey < 277.7) {
                        pitch = "C4";
                        note = 48;
                    } else if (frequencey < 311.6) {
                        pitch = "D4";
                        note = 50;
                    } else if (frequencey < 339.5) {
                        pitch = "E4";
                        note = 52;
                    } else if (frequencey < 370.0) {
                        pitch = "F4";
                        note = 53;
                    } else if (frequencey < 416) {
                        pitch = "G4";
                        note = 55;
                    } else if (frequencey < 466.0) {
                        pitch = "A4";
                        note = 57;
                    } else if (frequencey < 508.5) {
                        pitch = "B4";
                        note = 59;
                    } else if (frequencey < 555.0) {
                        pitch = "C5";
                        note = 60;
                    } else if (frequencey < 623.5) {
                        pitch = "D5";
                        note = 62;
                    } else if (frequencey < 680) {
                        pitch = "E5";
                        note = 64;
                    }
                }
            }
        }
