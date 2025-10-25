import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';

import { NgIfComponent } from './ng-if.component';

describe('NgIfComponent', () => {
    let fixture: ComponentFixture<NgIfComponent>;
    let component: NgIfComponent;
  
    beforeEach(async () => {
      TestBed.configureTestingModule({
        declarations: [NgIfComponent],
        imports: [FormsModule]
      }).compileComponents();
    });
  
    beforeEach(() => {
      fixture = TestBed.createComponent(NgIfComponent);
      component = fixture.componentInstance;
      fixture.detectChanges();
    });
  
    it("should display the text when 'num' is greater than 0", () => {
      // Set 'num' to a value greater than 0
      component.num = 5;
      fixture.detectChanges();
  
      // Get the rendered text element
      const textElement = fixture.nativeElement.querySelector('#result');

      console.log(textElement);
  
      // Assert that the text is displayed
      expect(textElement.textContent).toContain("This text should only be displayed when 'num' is greater than 0");
      expect(textElement.textContent).toContain("Current value of 'num': 5");
    });
  
    it("should not display the text when 'num' is 0", () => {
      // Set 'num' to 0
      component.num = 0;
      fixture.detectChanges();
  
      // Get the rendered text element
      const textElement = fixture.nativeElement.querySelector('#result');
  
      // Assert that the text is not displayed
      expect(textElement).toBeNull();
    });
  
    it("should not display the text when 'num' is less than 0", () => {
      // Set 'num' to a negative value
      component.num = -5;
      fixture.detectChanges();
  
      // Get the rendered text element
      const textElement = fixture.nativeElement.querySelector('#result');
  
      // Assert that the text is not displayed
      expect(textElement).toBeNull();
    });
  });
