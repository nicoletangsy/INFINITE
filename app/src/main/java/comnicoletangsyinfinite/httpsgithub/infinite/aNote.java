package comnicoletangsyinfinite.httpsgithub.infinite;

public class aNote {
    double note;
    int noteDuration;

    public double getNote() {
        return note;
    }
    public int getNoteDuration() {
        return noteDuration;
    }

    public void setNote(double note) {
        this.note = note;
    }
    public void setNoteDuration(int noteDuration) {
        this.noteDuration = noteDuration;
    }

    public aNote(double note, int noteDuration) {
        this.note = note;
        this.noteDuration = noteDuration;
    }
}
