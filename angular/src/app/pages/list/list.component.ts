import { Component, OnInit } from '@angular/core';
import { Country } from 'src/app/models/Country';
import { CountryserviceService } from 'src/app/services/countryservice.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  countries: Country[]= [];

  constructor(
    private countryService: CountryserviceService
    ) { }

  ngOnInit(): void {
      this.countryService.getCountries().subscribe(data => this.countries = data)
  }

}
