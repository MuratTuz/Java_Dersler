package hafta_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rectangle {
    Point topLeft;
    Point bottomRight;

    List<Integer> surface = new ArrayList<>();

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        surface();
    }


    public Rectangle(Point topLeft, int size) {
        this.topLeft = topLeft;
        this.bottomRight = new Point();
        this.bottomRight.setX(topLeft.getX()+size);
        this.bottomRight.setY(topLeft.getY()+size);
        surface();
    }

    public boolean isSame(Rectangle rectangle){

        return topLeft.equal(rectangle.topLeft) && bottomRight.equal(rectangle.bottomRight);
    }

    public boolean isSquare(){

        return (this.topLeft.getX() - this.bottomRight.getX()) == (this.topLeft.getY() - this.bottomRight.getY());
    }

    public boolean encloses(Rectangle rectangle){

        return topLeft.greatOnTop(rectangle.topLeft) && bottomRight.greatOnBottom(rectangle.bottomRight);
    }

    public boolean overlaps(Rectangle rectangle){

        return !Collections.disjoint(surface, rectangle.surface);
    }

    public Rectangle stretch(int factor){

        int x = (bottomRight.getX() - topLeft.getX()) * factor;
        int y = (bottomRight.getY() - topLeft.getY()) * factor;
        Point newBottom = new Point(topLeft.getX() + x, topLeft.getY() + y);

        return new Rectangle(topLeft, newBottom);
    }

    public Rectangle shrink(int factor){

        int x = (bottomRight.getX() - topLeft.getX()) / factor;
        int y = (bottomRight.getY() - topLeft.getY()) / factor;
        Point newBottom = new Point(topLeft.getX() + x, topLeft.getY() + y);

        return new Rectangle(topLeft, newBottom);
    }

    public void surface(){

        int x1 = topLeft.getX();
        int x2 = bottomRight.getX();
        int y1 = topLeft.getY();
        int y2 = bottomRight.getY();

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                surface.add(i*10 + j);
            }
        }
    }


}
