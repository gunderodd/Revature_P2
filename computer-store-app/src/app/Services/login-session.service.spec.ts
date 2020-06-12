import { TestBed } from '@angular/core/testing';

import { LoginSessionService } from './login-session.service';
import { RouterTestingModule } from '@angular/router/testing'
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { LoginPageComponent } from '../login-page/login-page.component';

describe('LoginSessionService', () => {
  let service: LoginSessionService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule, HttpClientTestingModule],
      providers: [LoginPageComponent]
    });
    service = TestBed.inject(LoginSessionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
