package com.nuevospa.taskmanagement.repository;

import com.nuevospa.taskmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
