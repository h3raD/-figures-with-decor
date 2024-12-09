package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ellipse extends Shape {
    private double radiusX;
    private double radiusY;

    public Ellipse(Color fillColor, Color strokeColor, double radiusX, double radiusY, double x, double y) {
        super(fillColor, strokeColor, x, y);
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    @Override
    double area() {
        return Math.PI * radiusX * radiusY;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(fillColor);
        gc.fillOval(x - radiusX, y - radiusY, radiusX * 2, radiusY * 2); // Рисуем эллипс
        gc.setStroke(strokeColor);
        gc.strokeOval(x - radiusX, y - radiusY, radiusX * 2, radiusY * 2); // Рисуем контур эллипса
    }

    @Override
    public String toString() {
        return "Ellipse color is " + fillColor + " and area is: " + area();
    }
}

