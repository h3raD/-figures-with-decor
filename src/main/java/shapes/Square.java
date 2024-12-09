package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {
    private double sideLength;

    public Square(Color fillColor, Color strokeColor, double sideLength, double x, double y) {
        super(fillColor, strokeColor, x, y);
        this.sideLength = sideLength;
    }

    @Override
    double area() {
        return sideLength * sideLength;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(fillColor);
        gc.fillRect(x - sideLength / 2, y - sideLength / 2, sideLength, sideLength); // Рисуем квадрат
        gc.setStroke(strokeColor);
        gc.strokeRect(x - sideLength / 2, y - sideLength / 2, sideLength, sideLength); // Рисуем контур квадрата
    }

    @Override
    public String toString() {
        return "Square color is " + fillColor + " and area is: " + area();
    }
}
