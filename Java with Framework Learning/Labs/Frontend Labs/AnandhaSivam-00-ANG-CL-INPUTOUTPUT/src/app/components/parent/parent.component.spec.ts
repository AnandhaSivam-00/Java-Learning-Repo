import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParentComponent } from './parent.component';
import { ChildComponent } from '../child/child.component';

import { By } from '@angular/platform-browser';

describe('ParentComponent', () => {
  let parentComponent: ParentComponent;
  let parentFixture: ComponentFixture<ParentComponent>;
  let childComponents: ChildComponent[];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParentComponent, ChildComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    parentFixture = TestBed.createComponent(ParentComponent);
    parentComponent = parentFixture.componentInstance;
    // query for child components:
    childComponents = parentFixture.debugElement.queryAll(By.css("app-child")).map(de => de.componentInstance);

    // Set the input values in the parent component
    parentComponent.todoData = 'Todo data Test';

    parentFixture.detectChanges();
  });

  it('should create', () => {
    expect(parentComponent).toBeTruthy();
  });

  it('should pass input data to first child component', () => {
    console.log(childComponents);
    // Assert that the input values in the child components match the expected values
    expect(childComponents[0].todoData).toBe(parentComponent.todoData);
  });

  
  it('should pass input data to second child component', () => {
    console.log(childComponents);
    // Assert that the input values in the child components match the expected values
    expect(childComponents[1].todoData).toBe(parentComponent.todoData);
  });


});
