package com.nuevospa.taskmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "task_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
}
