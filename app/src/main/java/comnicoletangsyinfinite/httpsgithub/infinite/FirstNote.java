package comnicoletangsyinfinite.httpsgithub.infinite;

public class FirstNote {
    private double x;
    private double y;
    private double height;
    private double speed;
    private double line2;
    private double line3;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) { this.y = y; }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSpeed() { return speed; }

    public void setSpeed(double speed) { this.speed = speed; }

    public double getLine2() { return line2; }

    public double getLine3() {return line3; }

    public void setLine2(double lineWidth) { line2 = y + lineWidth; }

    public void setLine3(double lineWidth) { line3 = y + lineWidth; }

    public void setXandY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void addXandY(double x, double y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

}


