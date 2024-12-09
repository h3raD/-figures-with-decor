package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(Color fillColor, Color strokeColor, double width, double height, double x, double y) {
        super(fillColor, strokeColor, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(fillColor);
        gc.fillRect(x, y, width, height); // Рисуем прямоугольник
        gc.setStroke(strokeColor);
        gc.strokeRect(x, y, width, height); // Рисуем контур прямоугольника
    }

    @Override
    public String toString() {
        return "Rectangle color is " + fillColor + " and area is: " + area();
    }
}
