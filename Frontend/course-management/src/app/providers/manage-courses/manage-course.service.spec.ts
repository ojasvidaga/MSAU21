import { TestBed } from '@angular/core/testing';

import { ManageCourseService } from './manage-course.service';

describe('ManageCourseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ManageCourseService = TestBed.get(ManageCourseService);
    expect(service).toBeTruthy();
  });
});
