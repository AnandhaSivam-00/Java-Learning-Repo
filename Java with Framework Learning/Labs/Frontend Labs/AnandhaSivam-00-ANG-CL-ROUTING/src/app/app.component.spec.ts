import { TestBed, ComponentFixture } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { Router } from '@angular/router';
import { ProfileComponent } from './components/profile/profile.component';
import { routes } from './app-routing.module';

describe('AppComponent', () => {
    let fixture: ComponentFixture<AppComponent>;
    let router: Router;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule.withRoutes(routes)
      ],
      declarations: [
        AppComponent
      ],
    }).compileComponents();
    
    fixture = TestBed.createComponent(AppComponent);
    router = TestBed.inject(Router);
    fixture.detectChanges();
  });

  it('should create the app', () => {
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'routing'`, () => {
    const app = fixture.componentInstance;
    expect(app.title).toEqual('routing');
  });

  it('should navigate to profile route and render ProfileComponent', async () => {
    await router.navigate(['profile']);
    fixture.detectChanges();

    expect(fixture.nativeElement.querySelector('app-profile')).toBeTruthy();
  });

});
