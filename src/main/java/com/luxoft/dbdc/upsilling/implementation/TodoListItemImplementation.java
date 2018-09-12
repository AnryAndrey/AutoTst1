package com.luxoft.dbdc.upsilling.implementation;


import com.luxoft.dbdc.upsilling.interfaces.Togglable;

public class TodoListItemImplementation implements Togglable {

    private boolean toggled ;

    private String title;

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TodoListItemImplementation(String title){
        this.title = title;
        toggled = false;
    }

    @Override
    public void toggle(){
    }

    public boolean isToggled(){
        return toggled;
    }

}
