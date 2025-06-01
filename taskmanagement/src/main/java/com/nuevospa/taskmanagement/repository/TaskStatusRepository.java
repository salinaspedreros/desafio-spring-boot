package com.nuevospa.taskmanagement.repository;

import com.nuevospa.taskmanagement.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
    Optional<TaskStatus> findByName(String name);
}
