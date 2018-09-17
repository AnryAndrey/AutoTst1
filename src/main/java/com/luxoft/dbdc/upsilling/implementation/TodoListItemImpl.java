package com.luxoft.dbdc.upsilling.implementation;


import com.luxoft.dbdc.upsilling.interfaces.TodoListItem;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TodoListItemImpl implements TodoListItem {

    private final String title;
    private boolean toggled;
    //final static Logger logger = LogManager.getLogger(TodoListItemImpl.class);

    public TodoListItemImpl setTitle(String title) {
        if (title.isEmpty()) throw new IllegalArgumentException("New title cannot be empty");
        return new TodoListItemImpl(title);
    }

    public String getTitle() {
        return title;
    }

    public boolean isToggled() {
        return toggled;
    }

    public TodoListItemImpl(String title) {
        if (title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty");
        this.title = title;
        this.toggled = false;
    }

          @Override
        public void toggle() {
            if (toggled) {toggled = false; return;}
            toggled = true;
    }

}