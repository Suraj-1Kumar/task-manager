package com.taskmanager.controller;

import com.taskmanager.model.Task;
import com.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Get all tasks for a specific project
    @GetMapping("/project/{projectId}")
    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN')")
    public List<Task> getProjectTasks(@PathVariable Long projectId) {
        return taskService.getTasksByProjectId(projectId);
    }

    // Create a task - restricted to ADMIN
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    // Update status - both MEMBER and ADMIN can do this
    @PatchMapping("/{id}/status")
    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN')")
    public ResponseEntity<Task> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(taskService.updateTaskStatus(id, status));
    }
}
