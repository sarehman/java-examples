package org.example;

public class LiskovSubstitutionExample {

    public static void main(String[] args) {
        Shape rectangle = new RectangleNew(10, 20);

        Shape square = new SquareNew(10);

        System.out.println(rectangle.area());
        System.out.println(square.area());
    }
}

interface Shape {
    int area();
}

class RectangleNew implements Shape {
    protected int height;
    protected int width;

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public RectangleNew(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int area() {
        return height * width;
    }
}

class SquareNew implements Shape {

    private int side;

    public SquareNew() {
    }

    public SquareNew(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int area() {
        return side * side;
    }
}
