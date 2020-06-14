import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { User } from '../user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url:string;

  constructor(private http:HttpClient) {
    this.url = "http://54.244.36.228:9000/";
  }

  user: User;

  public setCurrentUser(user: User){
    this.user = user;
    return user;
  }

  public getCurrentUser(){
    return this.user;
  }
  
  public loginUser(username, password) {
    return this.http.post<User>(this.url+"login", [username, password]);
  }

  public createUser(user:User): Observable<User> {
    return this.http.post<User>(this.url+"user", user);

  }

  public getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.url+"users");
  } 
}