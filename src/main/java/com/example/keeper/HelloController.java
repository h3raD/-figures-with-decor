package com.example.keeper;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.*;

import model.Memento;
import model.MemoSelect;

public class HelloController {
    private Memento temp;
    private MemoSelect memoSelect = new MemoSelect();

    @FXML
    private Circle circle;

    @FXML
    private Rectangle rectangle;

    @FXML
    private Pane drawingPane;

    @FXML
    public void initialize() {
        addMouseHandlers(circle);
        addMouseHandlers(rectangle);
    }

    private void addMouseHandlers(Shape shape) {
        shape.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            temp = new Memento(shape);
            temp.initState().toFront();
            memoSelect.push(temp);
        });

        shape.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::onDrag);
        shape.addEventHandler(MouseEvent.MOUSE_RELEASED, this::onEnd);
    }

    public void onDrag(MouseEvent mouseEvent) {
        if (temp == null) return;
        temp.initState().relocate(mouseEvent.getX(), mouseEvent.getY());
    }

    public void onEnd(MouseEvent mouseEvent) {
        if (temp == null) return;
        temp.getState().relocate(mouseEvent.getX(), mouseEvent.getY());
        temp = null; // Использовать и как флаг
    }
}
