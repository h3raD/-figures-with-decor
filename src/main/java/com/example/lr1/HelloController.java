package com.example.lr1;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import shapes.Circle;
import shapes.Ellipse;
import shapes.Rectangle;
import shapes.Square;

public class HelloController {
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker fillColorPicker;
    @FXML
    private ColorPicker strokeColorPicker;
    @FXML
    private TextField countField;
    @FXML
    private TextField sizeField; // Поле для ввода размера
    @FXML
    private TextField positionXField; // Поле для ввода X позиции
    @FXML
    private TextField positionYField; // Поле для ввода Y позиции
    @FXML
    private Label lastShapeLabel;

    @FXML
    private void drawSquare() {
        double size = getSize();
        double x = getPositionX();
        double y = getPositionY();
        drawShapes(new Square(fillColorPicker.getValue(), strokeColorPicker.getValue(), size, x, y));
    }

    @FXML
    private void drawEllipse() {
        double radiusX = getSize();
        double radiusY = getSize();
        double x = getPositionX();
        double y = getPositionY();
        drawShapes(new Ellipse(fillColorPicker.getValue(), strokeColorPicker.getValue(), radiusX, radiusY, x, y));
    }

    @FXML
    private void drawRectangle() {
        double width = getSize();
        double height = getSize();
        double x = getPositionX();
        double y = getPositionY();
        drawShapes(new Rectangle(fillColorPicker.getValue(), strokeColorPicker.getValue(), width, height, x, y));
    }

    @FXML
    private void drawCircle() {
        double radius = getSize();
        double x = getPositionX();
        double y = getPositionY();
        drawShapes(new Circle(fillColorPicker.getValue(), strokeColorPicker.getValue(), radius, x, y));
    }

    @FXML
    private void clearCanvas() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); // Очищаем канвас
        lastShapeLabel.setText("Последняя фигура: "); // Сбрасываем информацию о последней фигуре
    }

    private void drawShapes(shapes.Shape shape) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        shape.draw(gc); // Рисуем фигуру на канвасе
        lastShapeLabel.setText("Последняя фигура: " + shape.toString()); // Обновляем метку с информацией о последней фигуре
    }

    private double getSize() {
        try {
            return Double.parseDouble(sizeField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный размер, будет использовано значение 50.");
            return 50; // Значение по умолчанию
        }
    }

    private double getPositionX() {
        try {
            return Double.parseDouble(positionXField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Некорректная позиция X, будет использовано значение 50.");
            return 50; // Значение по умолчанию
        }
    }

    private double getPositionY() {
        try {
            return Double.parseDouble(positionYField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Некорректная позиция Y, будет использовано значение 50.");
            return 50; // Значение по умолчанию
        }
    }
}
