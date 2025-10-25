import { ComponentFixture, TestBed } from '@angular/core/testing';
import { EventBindingComponent } from './event-binding.component';

describe('EventBindingComponent', () => {
  let component: EventBindingComponent;
  let fixture: ComponentFixture<EventBindingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EventBindingComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EventBindingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should display "button 2 not clicked" initially', () => {
    const messageElement = fixture.nativeElement.querySelectorAll('p')[3];
    expect(messageElement.textContent).toContain('button 2 not clicked');
  });

  it('should update button2ClickedMessage when button 2 is clicked', () => {
    const button2 = fixture.nativeElement.querySelectorAll('button')[1];
    button2.click();
    fixture.detectChanges();
    const messageElement = fixture.nativeElement.querySelectorAll('p')[3];
    expect(messageElement.textContent).not.toContain('button 2 not clicked');
    expect(messageElement.textContent).toContain('button 2 clicked!');
  });
});
