package todoList.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Task> getAllTasks(){
        return taskServiceImpl.getAllTask();
    }
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id){
        return taskServiceImpl.getTaskById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskServiceImpl.createTask(task);
    }
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task task){
        return taskServiceImpl.updateTask(id,task);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id){
        taskServiceImpl.deleteTask(id);
    }


}
