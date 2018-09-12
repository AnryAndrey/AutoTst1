package com.luxoft.dbdc.upsilling.implementation;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TodoListItemImplementationTest {

    protected TodoListItemImplementation todoItem;

    @BeforeAll
    public static void setUpGlobal(){
    }

    @BeforeEach
    public void setUp(){
        //TodoListItemImplementation todoItem = new TodoListItemImplementation("Todo list Item to test");
        String title = "Todo list Item to test";
        todoItem = new TodoListItemImplementation(title);
    }

    @Test
    public void todoItemIsNotNullAfterCreation(){

    }

    @AfterEach
    public void tearDown(){

    }

    @AfterAll
    public static void tearDownGlobal(){

    }

}