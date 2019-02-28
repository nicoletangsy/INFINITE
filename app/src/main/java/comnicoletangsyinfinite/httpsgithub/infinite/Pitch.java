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
            if (frequencey < 16.5) {
                pitch = "C0";
            } else if (frequencey < 17.5) {
                pitch = "C#0";
            } else if (frequencey < 19) {
                pitch = "D0";
            } else if (frequencey < 20.5) {
                pitch = "D#0";
            } else if (frequencey < 21.5) {
                pitch = "E0";
            } else if (frequencey < 22.5) {
                pitch = "F0";
            } else if (frequencey < 24) {
                pitch = "F#0";
            } else if (frequencey < 25.5) {
                pitch = "G0";
            }else if (frequencey < 27) {
                pitch = "G#0";
            } else if (frequencey < 28.5) {
                pitch = "A0";
            } else if (frequencey < 30) {
                pitch = "A#0";
            } else if (frequencey < 32) {
                pitch = "B0";
            } else if (frequencey < 34) {
                pitch = "C1";
            } else if (frequencey < 36) {
                pitch = "C#1";
            } else if (frequencey < 38) {
                pitch = "D1";
            }else if (frequencey < 40) {
                pitch = "D#1";
            } else if (frequencey <42.5) {
                pitch = "E1";
            } else if (frequencey < 45) {
                pitch = "F1";
            } else if (frequencey < 47.5) {
                pitch = "F#1";
            } else if (frequencey < 50.5) {
                pitch = "G1";
            } else if (frequencey < 53.5) {
                pitch = "G#1";
            } else if (frequencey < 56.5) {
                pitch = "A1";
            }else if (frequencey < 60) {
                pitch = "A#1";
            }else if (frequencey < 63.5) {
                pitch = "B1";
            }else if (frequencey < 67) {
                pitch = "C2";
            }else if (frequencey < 71) {
                pitch = "C#2";
            }else if (frequencey < 75.5) {
                pitch = "D2";
            }else if (frequencey < 80) {
                pitch = "D#2";
            }else if (frequencey < 84.5) {
                pitch = "E2";
            }else if (frequencey < 90) {
                pitch = "F2";
            }else if (frequencey < 95.5) {
                pitch = "F#2";
            }else if (frequencey < 101) {
                pitch = "G2";
            }else if (frequencey < 107) {
                pitch = "G#2";
            }else if (frequencey < 113.5) {
                pitch = "A2";
            }else if (frequencey < 120.5) {
                pitch = "A#2";
            }else if (frequencey < 127.5) {
                pitch = "B2";
            }else if (frequencey < 135) {
                pitch = "C3";
            }else if (frequencey < 143) {
                pitch = "C#3";
            }else if (frequencey < 151.5) {
                pitch = "D3";
            }else if (frequencey < 160.5) {
                pitch = "D#3";
            }else if (frequencey < 170) {
                pitch = "E3";
            }else if (frequencey < 180) {
                pitch = "F3";
            }else if (frequencey < 190.5) {
                pitch = "F#3";
            }else if (frequencey < 202) {
                pitch = "G3";
            }else if (frequencey < 214) {
                pitch = "G#3";
            }else if (frequencey < 226.5) {
                pitch = "A3";
            }else if (frequencey < 240) {
                pitch = "A#3";
            }else if (frequencey < 254.5) {
                pitch = "B3";
            }else if (frequencey < 270) {
                pitch = "C4";
            }else if (frequencey < 286) {
                pitch = "C#4";
            }else if (frequencey < 302.5) {
                pitch = "D4";
            }else if (frequencey < 320.5) {
                pitch = "D#4";
            }else if (frequencey < 339.5) {
                pitch = "E4";
            }else if (frequencey < 359.5) {
                pitch = "F4";
            }else if (frequencey < 381) {
                pitch = "F#4";
            }else if (frequencey < 403.5) {
                pitch = "G4";
            }else if (frequencey < 427.5) {
                pitch = "G#4";
            }else if (frequencey < 453) {
                pitch = "A4";
            }else if (frequencey < 480) {
                pitch = "A#4";
            }else if (frequencey < 508.5) {
                pitch = "B4";
            }else if (frequencey < 538.5) {
                pitch = "C5";
            }else if (frequencey < 570.5) {
                pitch = "C#5";
            }else if (frequencey < 604.5) {
                pitch = "D5";
            }else if (frequencey < 640.5) {
                pitch = "D#5";
            }else if (frequencey < 679) {
                pitch = "E5";
            }else if (frequencey < 719.5) {
                pitch = "F5";
            }else if (frequencey < 762) {
                pitch = "F#5";
            }else if (frequencey < 807.5) {
                pitch = "G5";
            }else if (frequencey < 855.5) {
                pitch = "G#5";
            }else if (frequencey < 906) {
                pitch = "A5";
            }else if (frequencey < 960) {
                pitch = "A#5";
            }else if (frequencey < 1017.5) {
                pitch = "B5";
            }else if (frequencey < 1078) {
                pitch = "C6";
            }else if (frequencey < 1142) {
                pitch = "C#6";
            }else if (frequencey < 1210) {
                pitch = "D6";
            }else if (frequencey < 1282) {
                pitch = "D#6";
            }else if (frequencey < 1358) {
                pitch = "E6";
            }else if (frequencey < 1436) {
                pitch = "F6";
            }else if (frequencey < 1521.5) {
                pitch = "F#6";
            }else if (frequencey < 1614.5) {
                pitch = "G6";
            }else if (frequencey < 1710.5) {
                pitch = "G#6";
            }else if (frequencey < 1812.5) {
                pitch = "A6";
            }else if (frequencey < 1920.55) {
                pitch = "A#6";
            }else if (frequencey < 2034.5) {
                pitch = "B6";
            }else if (frequencey < 2155.5) {
                pitch = "C7";
            }else if (frequencey < 2283.5) {
                pitch = "C#7";
            }else if (frequencey < 2419) {
                pitch = "D7";
            }else if (frequencey < 2563) {
                pitch = "D#7";
            }else if (frequencey < 2715.5) {
                pitch = "E7";
            }else if (frequencey < 2877) {
                pitch = "F7";
            }else if (frequencey < 3048) {
                pitch = "F#7";
            }else if (frequencey < 3229) {
                pitch = "G7";
            }else if (frequencey < 3421) {
                pitch = "G#7";
            }else if (frequencey < 3624.5) {
                pitch = "A7";
            }else if (frequencey < 3840) {
                pitch = "A#7";
            }else if (frequencey < 4068.5) {
                pitch = "B7";
            }else if (frequencey < 4310.5) {
                pitch = "C8";
            }else if (frequencey < 4567) {
                pitch = "C#8";
            }else if (frequencey < 4838.5) {
                pitch = "D8";
            }else if (frequencey < 5126) {
                pitch = "D#8";
            }else if (frequencey < 5431) {
                pitch = "E8";
            }else if (frequencey < 5754) {
                pitch = "F8";
            }else if (frequencey < 6096) {
                pitch = "F#8";
            }else if (frequencey < 6458.5) {
                pitch = "G8";
            }else if (frequencey < 6842.5) {
                pitch = "G#8";
            }else if (frequencey < 7249.5) {
                pitch = "A8";
            }else if (frequencey < 7680.5) {
                pitch = "A#8";
            }else if (frequencey < 7903) {
                pitch = "B8";
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
