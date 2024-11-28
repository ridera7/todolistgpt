package com.todolistgpt.service;

import com.todolistgpt.entity.Todo;
import com.todolistgpt.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void testFindAll() {
        // Arrange
        Todo todo1 = new Todo();
        todo1.setId(1L);
        todo1.setTitle("Test Todo 1");

        Todo todo2 = new Todo();
        todo2.setId(2L);
        todo2.setTitle("Test Todo 2");

        when(todoRepository.findAll()).thenReturn(Arrays.asList(todo1, todo2));

        // Act
        List<Todo> todos = todoService.findAll();

        // Assert
        assertNotNull(todos);
        assertEquals(2, todos.size());
        assertEquals("Test Todo 1", todos.get(0).getTitle());
        verify(todoRepository, times(1)).findAll();
    }

    @Test
    void testFindById_TodoExists() {
        // Arrange
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setTitle("Test Todo");

        when(todoRepository.findById(1L)).thenReturn(Optional.of(todo));

        // Act
        Todo result = todoService.findById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Test Todo", result.getTitle());
        verify(todoRepository, times(1)).findById(1L);
    }

    @Test
    void testFindById_TodoNotFound() {
        // Arrange
        when(todoRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> todoService.findById(1L));
        assertEquals("Todo not found", exception.getMessage());
        verify(todoRepository, times(1)).findById(1L);
    }

    @Test
    void testSave() {
        // Arrange
        Todo todo = new Todo();
        todo.setTitle("New Todo");

        Todo savedTodo = new Todo();
        savedTodo.setId(1L);
        savedTodo.setTitle("New Todo");

        when(todoRepository.save(todo)).thenReturn(savedTodo);

        // Act
        Todo result = todoService.save(todo);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("New Todo", result.getTitle());
        verify(todoRepository, times(1)).save(todo);
    }

    @Test
    void testDeleteById() {
        // Act
        todoService.deleteById(1L);

        // Assert
        verify(todoRepository, times(1)).deleteById(1L);
    }
}