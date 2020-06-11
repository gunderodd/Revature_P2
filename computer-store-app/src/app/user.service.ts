import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { User } from './user';
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

  public loginUser(username, password) {
    this.user = new User();

    console.log(username);
    console.log(password);
    
    this.user.username = username;
    this.user.password = password;
    console.log(this.user + "this is the user object");
    
    return this.http.post<User>(this.url+"login", this.user);
  }

  public createUser(user:User){
    return this.http.post<User>(this.url+"user", user);

  }

  public getAllUsers():Observable<User[]>{
    return this.http.get<User[]>(this.url+"users");
  }
  
}
