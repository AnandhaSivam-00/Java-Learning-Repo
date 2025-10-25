import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PipesComponent } from './pipes.component';

describe('PipesComponent', () => {
  let component: PipesComponent;
  let fixture: ComponentFixture<PipesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PipesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PipesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should be lowercase', () => {
    const pElement = fixture.nativeElement.querySelectorAll('.todo-container p')[1];
    expect(pElement.textContent).toBe('hello, world!');
  })
});
