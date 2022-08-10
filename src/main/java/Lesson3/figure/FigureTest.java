package Lesson3.figure;

import java.util.ArrayList;
import java.util.List;

public class FigureTest {
    public static void main(String[] args) {
        List<FigureInterface> figures = new ArrayList();

        figures.add(new Rectangle(2,3));
        figures.add(new Ellipse(2,3));

        double perimetr = 0;
        double area = 0;
        for (int i = 0; i < figures.size(); i++) {
            perimetr += figures.get(i).getPerimeter();
            area += figures.get(i).getArea();

        }
    }


}
