import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { TwoWayBindingComponent } from './two-way-binding.component';

describe('TwoWayBindingComponent', () => {
  let component: TwoWayBindingComponent;
  let fixture: ComponentFixture<TwoWayBindingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TwoWayBindingComponent],
      imports: [FormsModule]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TwoWayBindingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should bind the inputText1 to the input box and update its value on user input', () => {
    const inputElement = fixture.nativeElement.querySelector('input');
    const newValue = 'New Value';
    inputElement.value = newValue;
    inputElement.dispatchEvent(new Event('input'));
    fixture.detectChanges();
    expect(component.inputText1).toBe(newValue);
  });


  it('should bind the inputText2 to the input box and update its value on user input', () => {
    const inputElement = fixture.nativeElement.querySelectorAll('input')[1];
    const newValue = 'New Value';
    inputElement.value = newValue;
    inputElement.dispatchEvent(new Event('input'));
    fixture.detectChanges();
    expect(component.inputText2).toBe(newValue);
  });

  it('should bind the inputText2 to the text content of the second paragraph and update it on user input', () => {
    const inputElement = fixture.nativeElement.querySelectorAll('input')[1];
    const newValue = 'New Value';
    inputElement.value = newValue;
    inputElement.dispatchEvent(new Event('input'));
    fixture.detectChanges();
    const paragraphElement = fixture.nativeElement.querySelectorAll('p')[3];
    expect(paragraphElement.textContent).toBe(newValue);
  });
});