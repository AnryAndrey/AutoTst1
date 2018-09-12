package com.luxoft.dbdc.upsilling.implementation;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TodoListItemImplementationTest {

    protected TodoListItemImplementation todoItem;
    protected String title;

    @BeforeAll
    public static void setUpGlobal(){
    }

    @BeforeEach
    public void setUp(){
        title = "Todo list Item to test";
        todoItem = new TodoListItemImplementation(title);
    }

    @Test
    public void itemHaveAssignedTitleAfterCreation(){
        Assertions.assertTrue(title.equalsIgnoreCase(todoItem.getTitle()));
    }

    @Test
    public void itemHaveNewITitleAfterAssigningNewTitle(){
        String newTitle = "New Title for Todo";
        todoItem.setTitle(newTitle);
        Assertions.assertTrue(() -> newTitle.equalsIgnoreCase(todoItem.getTitle()));
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