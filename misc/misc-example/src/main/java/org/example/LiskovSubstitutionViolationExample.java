package org.example;

public class LiskovSubstitutionViolationExample {

    public static void main(String[] args){
        Rectangle rectangle = new Square(5);
        rectangle.setHeight(10);
        rectangle.setWidth(20);
        System.out.println("Area : "+rectangle.area());
    }
}

class Rectangle{
    protected int height;
    protected int width;
    public void setHeight(int height){ this.height = height; }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public Rectangle(int height, int width){ this.height = height; this.width = width; }

    public int area(){ return height * width; }
}

class Square extends Rectangle {
    public Square(int s){
        super(s, s);
    }

    @Override
    public void setHeight(int height){
        super.height = height;
        super.width = height;//breaking LSP here
    }

    @Override
    public void  setWidth(int width){
        super.height = width; //breaking LSP here
        super.width = width;
    }

    public int area(){
        return super.height * super.width;
    }
}
