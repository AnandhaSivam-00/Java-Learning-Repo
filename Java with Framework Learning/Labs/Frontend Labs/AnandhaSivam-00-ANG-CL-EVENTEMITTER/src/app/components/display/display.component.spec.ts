import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ButtonMenuComponent } from '../button-menu/button-menu.component';

import { By } from '@angular/platform-browser';

import { DisplayComponent } from './display.component';

describe('DisplayComponent', () => {
  let component: DisplayComponent;
  let fixture: ComponentFixture<DisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayComponent, ButtonMenuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();


    // Get a reference to the ButtonMenuComponent instance
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call doIncrement() when incrementEvent is emitted', () => {
    // Spy on the doIncrement() method
    const doIncrementSpy = spyOn(component, 'doIncrement');

    // Find the button menu component
    const buttonMenuComponent = fixture.debugElement.query(By.directive(ButtonMenuComponent)).componentInstance as ButtonMenuComponent;

    // Emit the incrementEvent
    buttonMenuComponent.incrementEvent.emit();

    // Assert that the doIncrement() method was called
    expect(doIncrementSpy).toHaveBeenCalled();
  });

  it('should call doDecrement() when decrementEvent is emitted', () => {
    // Spy on the doDecrement() method
    const doDecrementSpy = spyOn(component, 'doDecrement');
    
    // Find the button menu component
    const buttonMenuComponent = fixture.debugElement.query(By.directive(ButtonMenuComponent)).componentInstance as ButtonMenuComponent;

    // Emit the decrementEvent
    buttonMenuComponent.decrementEvent.emit();

    // Assert that the doDecrement() method was called
    expect(doDecrementSpy).toHaveBeenCalled();
  });

});
