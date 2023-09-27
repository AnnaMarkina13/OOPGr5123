package ru.markina.solid.principles.task4;

//public class Rectangle {
//    private int width;
//    private int height;
//    public void setWidth(int width) {
//        this.width = width;
//    }
//    public void setHeight(int height) {
//        this.height = height;
//    }
//    public int area() {
//        return this.width * this.height;
//    }
//}
//public class Square extends Rectangle {
//    @Override
//    public void setWidth(int width) {
//        super.width = width;
//        super.height = width;
//    }
//    @Override
//    public void setHeight(int height) {
//        super.width = height;
//        super.height = height;
//    }
//}

public class Rectangle implements AreaCalculator {

    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int area() {
        return this.width * this.height;
    }
}
