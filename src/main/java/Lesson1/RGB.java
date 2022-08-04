package Lesson1;

import java.util.Arrays;

public class RGB {
    public static void main(String[] args) {
        RGB n = new RGB(100,100,200);
        n.RGBtoHSV();
        System.out.println(n.RGBtoHSV());

    }

    private int r;
    private int g;
    private int b;

    public RGB (int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    @Override
    public String toString() {
        return "RGB{" +
                "r=" + r +
                ", g=" + g +
                ", b=" + b +
                '}';
    }

    public  float [] RGBtoHSV() {
        float max = Math.max(getG(), Math.max(getB(), getR()));
        float min = Math.min(getB(), Math.min(getG(), getR()));

        float h = 0;
        if (max == min)
            h = 0;
        else if (max == getR())
            h = ((60 * (getG() - getB()) / (max - min)) + 360) % 360;
        else if (max == getG())
            h = (60 * (getB() - getR()) / (max - min)) + 120;
        else if (max == getB())
            h = (60 * (getR() - getG()) / (max - min)) + 240;


        float l = (max + min) / 2;


        float s = 0;
        if (max == min)
            s = 0;
        else if (l <= .5f)
            s = (max - min) / (max + min);
        else
            s = (max - min) / (2 - max - min);
        return new float[] { h, s * 100, l * 100 };


    }
}
