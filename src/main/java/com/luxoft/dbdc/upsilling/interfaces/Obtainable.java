package com.luxoft.dbdc.upsilling.interfaces;

import com.luxoft.dbdc.upsilling.implementation.TodoListItemImpl;

public interface Obtainable {
    TodoListItemImpl getItem(String title);
    TodoListItemImpl getItem(int number);
}
