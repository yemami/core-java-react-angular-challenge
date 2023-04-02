import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit{
  tasks: any []=[];
  constructor(private taskService:TaskService){}
  ngOnInit(): void {
    this.taskService.getAllTasks().subscribe((tasks: any) => {
      this.tasks = tasks;
    });
  }

  deleteTask(id: string): void {
    this.taskService.deleteTask(id).subscribe(() => {
      this.tasks = this.tasks.filter((task: any) => task._id !== id);
    });
  }

  createTask(title: string, description: string): void {
    const task = {
      title: title,
      description: description
    };
    this.taskService.createTask(task).subscribe((newTask: any) => {
      this.tasks.push(newTask);
    });
  }

}
