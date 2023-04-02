package todoList.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todoList.backend.model.Task;
import todoList.backend.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements TaskServiceImpl{
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(String id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()){
            return optionalTask.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Task updateTask(String id, Task taskDetails) {
        Task task= getTaskById(id);
        if(task!=null){
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setCompleted(taskDetails.isCompleted());
            return taskRepository.save(task);
        }else {
        return null;
        }
    }

    @Override
    public void deleteTask(String id) {
        Task task = getTaskById(id);
        if(task!=null){
            taskRepository.delete(task);
        }
    }
}
