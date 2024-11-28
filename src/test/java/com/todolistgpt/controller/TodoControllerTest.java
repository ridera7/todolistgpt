package com.todolistgpt.controller;

import com.todolistgpt.entity.Todo;
import com.todolistgpt.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoControllerTest {
    @Mock
    private TodoService todoService;

    @InjectMocks
    private TodoController todoController;

    @Test
    void testGetAllTodos() {
        // Arrange
        Todo todo1 = new Todo();
        todo1.setId(1L);
        todo1.setTitle("Todo 1");

        Todo todo2 = new Todo();
        todo2.setId(2L);
        todo2.setTitle("Todo 2");

        when(todoService.findAll()).thenReturn(Arrays.asList(todo1, todo2));

        // Act
        List<Todo> todos = todoController.getAllTodos();

        // Assert
        assertNotNull(todos);
        assertEquals(2, todos.size());
        assertEquals("Todo 1", todos.get(0).getTitle());
        verify(todoService, times(1)).findAll();
    }

    @Test
    void testGetTodoById() {
        // Arrange
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setTitle("Todo 1");

        when(todoService.findById(1L)).thenReturn(todo);

        // Act
        Todo result = todoController.getTodoById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Todo 1", result.getTitle());
        verify(todoService, times(1)).findById(1L);
    }

    @Test
    void testCreateTodo() {
        // Arrange
        Todo todo = new Todo();
        todo.setTitle("New Todo");

        Todo savedTodo = new Todo();
        savedTodo.setId(1L);
        savedTodo.setTitle("New Todo");

        when(todoService.save(todo)).thenReturn(savedTodo);

        // Act
        Todo result = todoController.createTodo(todo);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("New Todo", result.getTitle());
        verify(todoService, times(1)).save(todo);
    }

    @Test
    void testUpdateTodo() {
        // Arrange
        Todo todo = new Todo();
        todo.setTitle("Updated Todo");

        Todo updatedTodo = new Todo();
        updatedTodo.setId(1L);
        updatedTodo.setTitle("Updated Todo");

        when(todoService.save(todo)).thenReturn(updatedTodo);

        // Act
        Todo result = todoController.updateTodo(1L, todo);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Updated Todo", result.getTitle());
        verify(todoService, times(1)).save(todo);
    }

    @Test
    void testDeleteTodoById() {
        // Act
        todoController.deleteTodoById(1L);

        // Assert
        verify(todoService, times(1)).deleteById(1L);
    }

}