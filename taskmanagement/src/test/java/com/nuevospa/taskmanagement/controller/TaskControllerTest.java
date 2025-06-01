package com.nuevospa.taskmanagement.controller;

import com.nuevospa.taskmanagement.controller.TaskController;
import com.nuevospa.taskmanagement.entity.Task;
import com.nuevospa.taskmanagement.entity.TaskStatus;
import com.nuevospa.taskmanagement.service.TaskService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskControllerTest {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskService taskService;

    private Task task;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        task = new Task();
        task.setId(1L);
        task.setTitle("Unit test");
        task.setDescription("Testing TaskController");

        TaskStatus status = new TaskStatus();
        status.setId(1L);
        status.setName("PENDING");
        task.setStatus(status);
    }

    @Test
    void listAll_shouldReturnListOfTasks() {
        when(taskService.listAll()).thenReturn(Arrays.asList(task));
        List<Task> result = taskController.listAll();

        assertEquals(1, result.size());
        assertEquals("Unit test", result.get(0).getTitle());
        verify(taskService, times(1)).listAll();
    }

    @Test
    void save_shouldReturnSavedTask() {
        when(taskService.save(any(Task.class))).thenReturn(task);
        Task result = taskController.save(task);

        assertNotNull(result);
        assertEquals("Unit test", result.getTitle());
        verify(taskService, times(1)).save(any(Task.class));
    }

    @Test
    void update_shouldReturnUpdatedTask() {
        when(taskService.update(eq(1L), any(Task.class))).thenReturn(task);
        Task result = taskController.update(1L, task);

        assertNotNull(result);
        assertEquals("Unit test", result.getTitle());
        verify(taskService, times(1)).update(eq(1L), any(Task.class));
    }

    @Test
    void delete_shouldReturnNoContent() {
        ResponseEntity<Void> response = taskController.delete(1L);

        assertEquals(204, response.getStatusCodeValue());
        verify(taskService, times(1)).delete(1L);
    }

    @Test
    void getById_shouldReturnTask() {
        when(taskService.getById(1L)).thenReturn(task);
        Task result = taskController.getById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(taskService, times(1)).getById(1L);
    }
}
