import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LifecycleComponent } from './lifecycle.component';

describe('LifecycleComponent', () => {
  let component: LifecycleComponent;
  let fixture: ComponentFixture<LifecycleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LifecycleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LifecycleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should update time when component is mounted', () => {
    // Manually trigger ngOnInit
    fixture.detectChanges();

    // Get the current time in milliseconds
    const currentTime = Date.now();

    // Assert that the component's time variable is set to the current time
    expect(component.time).toBe(currentTime);
    
  })

  it('should trigger alert when component is unmounted', () => {
    // Spy on the alert function
    const alertSpy = spyOn(window, 'alert');

    // Manually call ngOnDestroy to simulate component unmounting
    component.ngOnDestroy();

    // Assert that the alert function was called
    expect(alertSpy).toHaveBeenCalled();
  });
});
