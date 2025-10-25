import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IncrementorComponent } from './incrementor.component';

describe('IncrementorComponent', () => {
  let component: IncrementorComponent;
  let fixture: ComponentFixture<IncrementorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IncrementorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IncrementorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
