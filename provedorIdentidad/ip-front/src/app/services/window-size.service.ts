import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';

@Injectable() // could be @Injectable({ providedIn: 'root' }) in 6+ version
export class ResizeService {

  currentSize$: Subject<number|string> = new Subject<number|string>();

  getSize(): Observable<number|string> {
    return this.currentSize$.asObservable();
  }

  setSize(size: number|string): void {
   this.currentSize$.next(size);
  }

}
