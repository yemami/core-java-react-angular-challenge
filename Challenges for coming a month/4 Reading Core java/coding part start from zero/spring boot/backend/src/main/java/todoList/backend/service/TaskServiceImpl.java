package todoList.backend.service;

import todoList.backend.model.Task;

import java.util.List;

public interface TaskServiceImpl {
    public Task createTask(Task task);
    public List<Task> getAllTask();
    public Task getTaskById(String id);
    public Task updateTask(String id, Task taskDetails);
    public void deleteTask(String id);
}
