import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllReportsComponent } from './all-reports.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('AllReportsComponent', () => {
  let component: AllReportsComponent;
  let fixture: ComponentFixture<AllReportsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      declarations: [ AllReportsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllReportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
