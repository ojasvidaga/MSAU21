import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDeleteFileComponent } from './view-delete-file.component';

describe('ViewDeleteFileComponent', () => {
  let component: ViewDeleteFileComponent;
  let fixture: ComponentFixture<ViewDeleteFileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewDeleteFileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewDeleteFileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
