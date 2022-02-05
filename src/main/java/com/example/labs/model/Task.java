package com.example.labs.model;

import java.time.LocalDateTime;

/**
 * This model implements the task.
 */
public class Task {
    private String taskName;
    private LocalDateTime createdAt;
    private TaskStatus status;

    public Task() {
        super();
    }

    public Task(final String taskName) {
        this.taskName = taskName;
        this.createdAt = LocalDateTime.now();
        this.status = TaskStatus.OPENED;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskName='" + taskName + '\'' +
                ", createdAt=" + createdAt +
                ", status=" + status +
                '}';
    }

    public String getTaskName() {
        return taskName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
