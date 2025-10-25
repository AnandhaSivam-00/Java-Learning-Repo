import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PropertyBindingComponent } from './property-binding.component';

describe('PropertyBindingComponent', () => {
  let component: PropertyBindingComponent;
  let fixture: ComponentFixture<PropertyBindingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PropertyBindingComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PropertyBindingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should bind the urlLink to the href attribute of the anchor tag', () => {
    const anchorElement = fixture.nativeElement.querySelector('a');
    expect(anchorElement.getAttribute('href')).toBe(component.urlLink);
  });

  it('should bind the ngLogo to the src attribute of the image tag', () => {
    const imageElement = fixture.nativeElement.querySelector('img');
    expect(imageElement.getAttribute('src')).toBe(component.ngLogo);
  });
});