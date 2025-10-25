import { TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { MyFirstComponentComponent } from './components/my-first-component/my-first-component.component';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'components'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('components');
  });

  it('should render component', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const template = fixture.nativeElement;
    const myFirstComponent = template.querySelector('app-my-first-component');
    expect(myFirstComponent).toBeTruthy();
 
  })
});
