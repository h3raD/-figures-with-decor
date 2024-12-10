package model;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Memento {
    private Shape shape;
    private double width;
    private Color color;

    // Создание снимка
    public Memento(Shape state) {
        this.shape = state;
        this.width = shape.getStrokeWidth();
        this.color = (Color) shape.getStroke();
    }

    // Вернуть первоначальные свойства
    public Shape getState() {
        shape.setStrokeWidth(width);
        shape.setStroke(color);
        return shape;
    }

    // Метод для инициализации состояния выделенной фигуры
    public Shape initState() {
        shape.setStrokeWidth(2);
        shape.setStroke(Color.RED);
        return shape;
    }
}
