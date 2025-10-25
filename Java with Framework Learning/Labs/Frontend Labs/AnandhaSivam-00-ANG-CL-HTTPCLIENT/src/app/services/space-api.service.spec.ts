import { TestBed } from '@angular/core/testing';

import { SpaceApiService } from './space-api.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';

describe('SpaceApiService', () => {
  let service: SpaceApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({
        imports: [HttpClientModule],
    });
    service = TestBed.inject(SpaceApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should make a GET request to the reports API', () => {
    // Arrange
    const httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    // inject http spy into the service:
    service = new SpaceApiService(httpClientSpy);
    const expectedUrl = 'https://api.spaceflightnewsapi.net/v3/reports';

    // Invoke the function
    service.getReportsAPI();

    // Assert that the api was called with the expected URL
    expect(httpClientSpy.get).toHaveBeenCalledWith(expectedUrl);
  });
});
