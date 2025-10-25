import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';

import { ButtonMenuComponent } from './button-menu.component';

describe('ButtonMenuComponent', () => {
  let component: ButtonMenuComponent;
  let fixture: ComponentFixture<ButtonMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ButtonMenuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ButtonMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should invoke increment function when increment button is clicked', () => {
    const incrementFunctionSpy = spyOn(component, 'increment');

    // Find the increment button element and trigger a click event
    const incrementButton = fixture.debugElement.query(By.css('#incrementButton'));
    incrementButton.triggerEventHandler('click', null);

    // Assert that the incrementEvent emitter was called
    expect(incrementFunctionSpy).toHaveBeenCalled();
  });

  it('should emit incrementEvent when increment function is called', () => {
    // Create a spy object for the incrementEvent emitter
    const incrementEventSpy = spyOn(component.incrementEvent, 'emit');

    // invoke the increment function:
    component.increment();

    // Assert that the incrementEvent emitter was called
    expect(incrementEventSpy).toHaveBeenCalled();
  });

  it('should invoke decrement function when decrement button is clicked', () => {
    const decrementFunctionSpy = spyOn(component, 'decrement');

    // Find the decrement button element and trigger a click event
    const decrementButton = fixture.debugElement.query(By.css('#decrementButton'));
    decrementButton.triggerEventHandler('click', null);

    // Assert that the decrementEvent emitter was called
    expect(decrementFunctionSpy).toHaveBeenCalled();
  });

  it('should emit decrementEvent when decrement function is called', () => {
    // Create a spy object for the decrementEvent emitter
    const decrementEventSpy = spyOn(component.decrementEvent, 'emit');

    // invoke the decrement function:
    component.decrement();

    // Assert that the decrementEvent emitter was called
    expect(decrementEventSpy).toHaveBeenCalled();
  });
  
});
