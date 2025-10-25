import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NgForComponent } from './ng-for.component';

describe('NgForComponent', () => {
  let component: NgForComponent;
  let fixture: ComponentFixture<NgForComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NgForComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NgForComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });


  it("should display all names from the array", () => {
    // Define the test data
    const names = ['John', 'Jane', 'Alice'];

    // Set the names array in the component
    component.names = names;
    fixture.detectChanges();

    // Get the rendered list items
    const listItems = fixture.nativeElement.querySelectorAll('.result');

    // Assert that the number of rendered items matches the length of the names array
    expect(listItems.length).toEqual(names.length);

    // Assert that each name from the array is rendered
    listItems.forEach((item: any, index: number) => {
      expect(item.textContent).toContain(names[index]);
    });
  });
});
