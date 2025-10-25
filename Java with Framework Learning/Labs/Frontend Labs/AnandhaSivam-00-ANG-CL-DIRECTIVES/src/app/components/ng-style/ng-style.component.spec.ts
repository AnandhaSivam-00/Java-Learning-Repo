import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NgStyleComponent } from './ng-style.component';

describe('NgStyleComponent', () => {
  let component: NgStyleComponent;
  let fixture: ComponentFixture<NgStyleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NgStyleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NgStyleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it("should have a p tag with font-size that matches the given variable", () => {
    // Set the font size variable in the component
    const fontSize = '14px';
    component.fontSize = fontSize;
    fixture.detectChanges();

    // Get the rendered p tag element
    const pElement = fixture.nativeElement.querySelector('.todo-container p');

    // Get the computed font size style of the p tag
    const computedFontSize = window.getComputedStyle(pElement).getPropertyValue('font-size');

    // Assert that the computed font size matches the given variable
    expect(computedFontSize).toEqual(fontSize);
  });
});
