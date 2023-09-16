import { Component, OnInit } from '@angular/core';
import { Country } from 'src/app/models/Country';
import { CountryserviceService } from 'src/app/services/countryservice.service';

@Component({
  selector: 'app-table2',
  templateUrl: './table2.component.html',
  styleUrls: ['./table2.component.css']
})
export class Table2Component implements OnInit {

  countries: Country[]= [];

  constructor(
    private countryService: CountryserviceService
    ) { }

  ngOnInit(): void {
      this.countryService.getCountriesPageble(2,3).subscribe(data =>{ 
        this.countries = data
        console.log(data)
      }
        )
  }

}
