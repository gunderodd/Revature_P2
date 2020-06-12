import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { LoginPageComponent } from '../login-page/login-page.component';

@Injectable({
  providedIn: 'root'
})
export class LoginSessionService {

  constructor(
    private router: Router,
    private loginSessionGuard: LoginPageComponent
  ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.loginSessionGuard.isUserLoggedIn())
      return true;

    this.router.navigate(['loginpage']);
    return false;

  }

}
