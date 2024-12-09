package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    private double radius;

    public Circle(Color fillColor, Color strokeColor, double radius, double x, double y) {
        super(fillColor, strokeColor, x, y);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(fillColor);
        gc.fillOval(x - radius, y - radius, radius * 2, radius * 2); // Рисуем круг
        gc.setStroke(strokeColor);
        gc.strokeOval(x - radius, y - radius, radius * 2, radius * 2); // Рисуем контур круга
    }

    @Override
    public String toString() {
        return "Circle color is " + fillColor + " and area is: " + area();
    }
}
