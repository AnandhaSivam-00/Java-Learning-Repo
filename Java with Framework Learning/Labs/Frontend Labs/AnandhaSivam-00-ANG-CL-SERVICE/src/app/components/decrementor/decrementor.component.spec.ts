import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DecrementorComponent } from './decrementor.component';
import { CountService} from '../../services/count.service';

describe('DecrementorComponent', () => {
  let component: DecrementorComponent;
  let fixture: ComponentFixture<DecrementorComponent>;
  let countService: CountService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DecrementorComponent],
      providers: [CountService]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DecrementorComponent);
    component = fixture.componentInstance;
    countService = TestBed.inject(CountService); // Inject the CountService
    fixture.detectChanges();
  });

  it('should inject the CountService', () => {
    expect(countService).toBeTruthy();
  });

  it('should call decrementNum when emitDecrementEvent is called', () => {
    spyOn(countService, 'decrementNum'); // Spy on the decrementNum method

    component.emitDecrementEvent();

    expect(countService.decrementNum).toHaveBeenCalled();
  });
});