package model;

import java.util.ArrayDeque;
import java.util.Queue;

public class MemoSelect {
    private Queue<Memento> mementoList = new ArrayDeque<>();

    // Добавление нового состояния в очередь
    public void push(Memento state) {
        mementoList.add(state);
    }

    // Извлечение последнего состояния из очереди
    public Memento poll() {
        return mementoList.poll();
    }
}
