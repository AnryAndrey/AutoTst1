package com.luxoft.dbdc.upsilling.interfaces;


import com.luxoft.dbdc.upsilling.implementation.TodoListItemImpl;

public interface TodoList extends Obtainable {
    void toggleAll();
    void deleteItem(String title);
    void deleteItem(int number);
    int addItem(String title);
    int addItem(TodoListItemImpl item);
    boolean toggle(String item);
    int length();
}
