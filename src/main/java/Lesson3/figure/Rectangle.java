package Lesson3.figure;

import Lesson3.figure.FigureInterface;

public class Rectangle implements FigureInterface {
    double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea()
    {
        return height*width;
    }

    @Override
    public double getPerimeter()
    {
        return 2*(width + height);
    }

}
