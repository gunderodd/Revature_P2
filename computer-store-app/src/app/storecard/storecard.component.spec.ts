import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StorecardComponent } from './storecard.component';

describe('StorecardComponent', () => {
  let component: StorecardComponent;
  let fixture: ComponentFixture<StorecardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StorecardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StorecardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
