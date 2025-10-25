import { TestBed, ComponentFixture } from '@angular/core/testing';
import { of } from 'rxjs';
import { ReportByIdComponent } from './report-by-id.component';
import { SpaceApiMockService } from 'src/app/mocks/space-api-mock.service';
import { SpaceApiService } from 'src/app/services/space-api.service';

describe('ReportById', () => {
  let component: ReportByIdComponent;
  let spaceAPIService: SpaceApiMockService;
  let fixture: ComponentFixture<ReportByIdComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReportByIdComponent],
      providers: [
        { provide: SpaceApiService, useClass: SpaceApiMockService }
      ],
    });

    fixture = TestBed.createComponent(ReportByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();

    spaceAPIService = TestBed.inject(SpaceApiService);
  });


  it('should update the report with mock data', () => {
    spyOn(spaceAPIService, 'getReportsByIdAPI').and.callThrough();

    // Call the method that triggers the service call
    component.loadReport();

    expect(spaceAPIService.getReportsByIdAPI).toHaveBeenCalled();

    console.log(component.report);
  });
});




