import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NgClassComponent } from './ng-class.component';

describe('NgClassComponent', () => {
  let component: NgClassComponent;
  let fixture: ComponentFixture<NgClassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NgClassComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NgClassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should be red initially', () => {
    fixture.detectChanges();
    const pElement = fixture.nativeElement.querySelectorAll('.todo-container p')[1];

    expect(pElement.classList).toContain('RedElement');
  })

  it('should be change to blue when button is clicked', () => {
    const button = fixture.nativeElement.querySelector('button');
    button.click();
    
    fixture.detectChanges();
    const pElement = fixture.nativeElement.querySelectorAll('.todo-container p')[1];

    expect(pElement.classList).toContain('BlueElement');
  })


});
