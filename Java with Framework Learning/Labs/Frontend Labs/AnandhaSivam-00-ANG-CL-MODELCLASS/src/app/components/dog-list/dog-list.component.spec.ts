import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DogListComponent } from './dog-list.component';

import { Dog } from 'src/app/models/dog';

describe('DogListComponent', () => {
  let component: DogListComponent;
  let fixture: ComponentFixture<DogListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DogListComponent ],
    })
    .compileComponents();

    fixture = TestBed.createComponent(DogListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should add dog to list of all dogs', () => {

    // create a dog service spy:
    const dogsServiceSpy = jasmine.createSpyObj('DogsService', ['addDog']);

    // inject the spy into the component:
    component = new DogListComponent(dogsServiceSpy);

    // configure the inputs:
    component.nameInput = 'Mr. Dog';
    component.ageInput = 8;
    component.breedInput = 'Golden Retriever';

    // create an expected dog object:
    const expectedDog: Dog = {name : 'Mr. Dog', age: 8, breed: 'Golden Retriever'}

    // invoke the function:
    component.addDog();

    // ensure that the dog service is called with the correct dog object:
    expect(dogsServiceSpy.addDog).toHaveBeenCalledWith(expectedDog);
  })
});
