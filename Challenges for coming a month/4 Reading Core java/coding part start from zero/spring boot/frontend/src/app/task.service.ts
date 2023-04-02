import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  private url = 'http://localhost:3000/tasks';
  constructor(private http: HttpClient) {}

  getAllTasks(): Observable<any[]> {
    return this.http.get<any[]>(this.url);
  }
  getTaskById(id: string): Observable<any> {
    const url = `${this.url}/${id}`;
    return this.http.get<any>(url);
  }

  createTask(task: any): Observable<any> {
    return this.http.post<any>(this.url, task);
  }

  updateTask(id: string, task: any): Observable<any> {
    const url = `${this.url}/${id}`;
    return this.http.put<any>(url, task);
  }

  deleteTask(id: string): Observable<any> {
    const url = `${this.url}/${id}`;
    return this.http.delete(url);
  }
}
