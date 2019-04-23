package comnicoletangsyinfinite.httpsgithub.infinite;

public class aNote {
    double note;
    int noteDuration;
    double dbSPL;
    double timeStamp;

    public double getNote() {
        return note;
    }
    public int getNoteDuration() {
        return noteDuration;
    }
    public double getDbSPL() { return dbSPL; }
    public double getTimeStamp() { return timeStamp; }

    public void setNote(double note) {
        this.note = note;
    }
    public void setNoteDuration(int noteDuration) {
        this.noteDuration = noteDuration;
    }
    public void setDbSPL(double dbSPL) { this.dbSPL = dbSPL;}
    public void setTimeStamp(double timeStamp) { this.timeStamp = timeStamp; }

    //Constructor for a record note
    public aNote(double note, double dbSPL, double timeStamp) {
        this.note = note;
        this.dbSPL = dbSPL;
        this.timeStamp = timeStamp;
    }

    //Constructor for a generated note
    public aNote(double note, int noteDuration) {
        this.note = note;
        this.noteDuration = noteDuration;
    }
}
