import { TestBed } from '@angular/core/testing';

import { HeaderAddingInterceptorService } from './header-adding-interceptor.service';

describe('HeaderAddingInterceptorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HeaderAddingInterceptorService = TestBed.get(HeaderAddingInterceptorService);
    expect(service).toBeTruthy();
  });
});
