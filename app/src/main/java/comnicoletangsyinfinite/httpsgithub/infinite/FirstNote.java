package comnicoletangsyinfinite.httpsgithub.infinite;

public class FirstNote {
    private double x;
    private double y;
    private double height;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setXandY(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void addXandY(double x,double y){
        this.x = this.x + x;
        this.y = this.y + y;
    }

}


