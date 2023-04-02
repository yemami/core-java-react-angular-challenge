package todoList.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todoList.backend.model.Task;
import todoList.backend.service.TaskServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskServiceImpl taskServiceImpl;

    @GetMapping
    public ResponseEntity<?> getAllTasks(){
        List<Task> tasks = taskServiceImpl.getAllTask();
        return ResponseEntity.ok(tasks);
    }
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id){
        return taskServiceImpl.getTaskById(id);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task createdTask = taskServiceImpl.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task task){
        return taskServiceImpl.updateTask(id,task);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable String id){
        taskServiceImpl.deleteTask(id);
        return new ResponseEntity<>("Task deleted successfully",HttpStatus.OK);
    }


}
