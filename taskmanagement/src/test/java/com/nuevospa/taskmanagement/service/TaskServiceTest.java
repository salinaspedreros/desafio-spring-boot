package com.nuevospa.taskmanagement.service;

import com.nuevospa.taskmanagement.entity.*;
import com.nuevospa.taskmanagement.repository.TaskRepository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task task;
    private Task updatedTask;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        TaskStatus status = new TaskStatus();
        status.setId(1L);
        status.setName("PENDING");

        task = new Task();
        task.setId(1L);
        task.setTitle("Test TaskEntity");
        task.setDescription("Test Description");
        task.setStatus(status);

        updatedTask = new Task();
        updatedTask.setTitle("Updated TaskEntity");
        updatedTask.setDescription("Updated Description");
        updatedTask.setStatus(status);
    }

    @Test
    void testSave() {
        when(taskRepository.save(task)).thenReturn(task);
        Task result = taskService.save(task);
        assertEquals(task, result);
    }

    @Test
    void testUpdate() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task result = taskService.update(1L, updatedTask);
        assertEquals(updatedTask.getTitle(), result.getTitle());
        assertEquals(updatedTask.getDescription(), result.getDescription());
    }

    @Test
    void testDelete() {
        taskService.delete(1L);
        verify(taskRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetById() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        Task result = taskService.getById(1L);
        assertEquals(task, result);
    }

    @Test
    void testListAll() {
        when(taskRepository.findAll()).thenReturn(Arrays.asList(task));
        List<Task> result = taskService.listAll();
        assertEquals(1, result.size());
        assertEquals(task, result.get(0));
    }

    @Test
    void testUpdated_TaskNotFound() {
        when(taskRepository.findById(2L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            taskService.update(2L, updatedTask);
        });

        assertEquals("Tarea no encontrada", exception.getMessage());
    }

    @Test
    void testGetById_TaskNotFound() {
        when(taskRepository.findById(2L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            taskService.getById(2L);
        });

        assertEquals("Tarea no encontrada", exception.getMessage());
    }
}
