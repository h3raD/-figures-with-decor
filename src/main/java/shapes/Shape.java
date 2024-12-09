package shapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    protected Color fillColor;
    protected Color strokeColor;
    protected double x, y;

    public Shape(Color fillColor, Color strokeColor, double x, double y) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.x = x;
        this.y = y;
    }

    abstract double area();
    public abstract void draw(GraphicsContext gc);

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }
}


