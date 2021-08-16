import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Fighter } from '../models/fighter';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FightService {

  // private baseUrl = 'http://localhost:8084/';
  private url = environment.baseUrl + 'api/fighters';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
    })
  };

  constructor(
      private http: HttpClient
  ) { }

  index(): Observable<Fighter[]> {
    return this.http.get<Fighter[]>(this.url, this.httpOptions).pipe(
      catchError((err: any) => {
        console.error('FightService.index(): error retrieving fighter list');
        return throwError(err);
      })
    );
  }

  show(fighterId: any): Observable<Fighter> {
    return this.http.get<Fighter>(`${this.url}/${fighterId}`).pipe(
      catchError((err: any) => {
        console.error('FightService.show(): error retrieving fighter id ' + fighterId);
        return throwError(err);
      })
    );
  }

  create(fighter: Fighter): Observable<Fighter> {
    fighter.strength = 0;
    fighter.speed = 0;
    fighter.intelligence = 0;
    fighter.health = 0;
    fighter.head.id = 1;
    fighter.torso.id = 1;
    fighter.legs.id = 1;
    return this.http.post<Fighter>(this.url, fighter, this.httpOptions).pipe(
      catchError((err: any) => {
        console.error('FightService.create(): error creating fighter');
        return throwError(err);
      })
    );
  }

  update(fighter: Fighter): Observable<Fighter> {
    return this.http.put<Fighter>(`${this.url}/${fighter.id}`, fighter, this.httpOptions).pipe(
      catchError((err: any) => {
        console.error('FightService.update(): error updating fighter');
        return throwError(err);
      })
    );
  }

  destroy(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`, this.httpOptions).pipe(
      catchError((err: any) => {
        console.error('FightService.destroy(): error deleting fighter');
        return throwError(err);
      })
    );
  }

}
