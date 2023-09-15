import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Country } from '../models/Country';
import { Language } from '../models/Language';

const baseUrl = 'http://localhost:8081';

@Injectable({
  providedIn: 'root'
})
export class CountryserviceService {

  constructor(private http: HttpClient) { }

  getCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(`${baseUrl}/countries`)
  }

  getCountryNameById(id: number): Observable<Country> {
    return this.http.get<Country>(`${baseUrl}/country/${id}`)
  }

  getLanguagesByCountryId(id: number): Observable<Language[]> {
    return this.http.get<Language[]>(`${baseUrl}/languages/${id}`)
  }
}
