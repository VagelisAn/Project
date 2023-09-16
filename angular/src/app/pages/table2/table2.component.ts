import { Component, OnInit } from '@angular/core';
import { Country } from 'src/app/models/Country';
import { CountryserviceService } from 'src/app/services/countryservice.service';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-table2',
  templateUrl: './table2.component.html',
  styleUrls: ['./table2.component.css']
})
export class Table2Component implements OnInit {

  countries: Country[]= [];
  totalElements: number = 0;
  
  constructor(
    private countryService: CountryserviceService
    ) { }

  ngOnInit(): void {
      this.getCountries(0, 8);
  }

  nextPage(event: PageEvent) {
    const page = event.pageIndex;
    const size = event.pageSize;
    this.getCountries(page,size);
}

  getCountries(page: number, size: number){
    this.countryService.getCountriesPageble(page,size).subscribe(data =>{ 
      this.countries = data.content;
      this.totalElements = data.numberOfElements;
      console.log(data)
    }, error => {
      console.log(error.error.message);
    }
  )
  };

}
