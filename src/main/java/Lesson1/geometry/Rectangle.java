package Lesson1.geometry;

public class Rectangle {
    private Point sw;
    private Point ne;

    public Rectangle(Point sw, Point ne) {
        this.sw = sw;
        this.ne = ne;
    }

    public int getArea(){
        return  (ne.getX()- sw.getX())*(ne.getY()- sw.getY());
    }

}
