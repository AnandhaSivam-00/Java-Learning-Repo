import { ComponentFixture, TestBed } from '@angular/core/testing';
import { InterpolationComponent } from './interpolation.component';

describe('InterpolationComponent', () => {
  let component: InterpolationComponent;
  let fixture: ComponentFixture<InterpolationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InterpolationComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InterpolationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should display tsVariable2 value in the second paragraph', () => {
    const paragraphElement = fixture.nativeElement.querySelectorAll('p')[3];
    expect(paragraphElement.textContent).toContain(component.tsVariable2);
  });

  it('should update tsVariable2 value in the component and reflect the change in the template', () => {
    const newVariableValue = 'new text';
    component.tsVariable2 = newVariableValue;
    fixture.detectChanges();
    const paragraphElement = fixture.nativeElement.querySelectorAll('p')[3];
    expect(paragraphElement.textContent).toContain(newVariableValue);
  });
});