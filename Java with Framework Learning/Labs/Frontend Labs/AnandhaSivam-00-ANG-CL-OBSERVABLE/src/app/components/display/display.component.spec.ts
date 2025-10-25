import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DisplayComponent } from './display.component';
import { CounterService } from '../../services/counter.service';
import { of } from 'rxjs';

describe('DisplayComponent', () => {
  let component: DisplayComponent;
  let fixture: ComponentFixture<DisplayComponent>;
  let counterService: CounterService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DisplayComponent],
      providers: [CounterService]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayComponent);
    component = fixture.componentInstance;
    counterService = TestBed.inject(CounterService);
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should set seconds on ngOnInit', () => {
    const seconds = 10;

    spyOn(counterService, 'getCounterSeconds').and.returnValue(of(seconds));

    fixture.detectChanges();
    component.ngOnInit();

    expect(counterService.getCounterSeconds).toHaveBeenCalled();
    expect(component.seconds).toBe(seconds);
  });

  it('should set milliseconds on ngOnInit', () => {
    const milliseconds = 500;

    spyOn(counterService, 'getCounterMilliseconds').and.returnValue(of(milliseconds));

    fixture.detectChanges();
    component.ngOnInit();

    expect(counterService.getCounterMilliseconds).toHaveBeenCalled();
    expect(component.milliseconds).toBe(milliseconds);
  });
});
