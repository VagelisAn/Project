import { Component, OnInit, ViewChild } from '@angular/core';
import { Country } from 'src/app/models/Country';
import { CountryserviceService } from 'src/app/services/countryservice.service';
import { PageEvent } from '@angular/material/paginator';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import { DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material/core';
import { MomentDateAdapter } from '@angular/material-moment-adapter';

const MY_DATE_FORMAT = {
  parse: {
    dateInput: 'YYYY', 
  },
  display: {
    dateInput: 'YYYY', 
    monthYearLabel: 'YYYY',
    dateA11yLabel: 'YYYY',
    monthYearA11yLabel: 'YYYY'
  }
};

@Component({
  selector: 'app-table2',
  templateUrl: './table2.component.html',
  styleUrls: ['./table2.component.css'],
  // providers: [
  //   { provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE] },
  //   { provide: MAT_DATE_FORMATS, useValue: MY_DATE_FORMAT }
  // ],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({ height: '0px', minHeight: '0' })),
      state('expanded', style({ height: '*' })),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class Table2Component implements OnInit {
  displayedColumns: string[] = ['name_country', 'name_region', 'name_continets'];
  displayedColumnsVersion: string[] = ['year', 'population', 'gdp'];
  dataSource!: MatTableDataSource<Country>;
  expandedElement: any;
  @ViewChild(MatSort) sort!: MatSort;
  countries: Country[]= [];
  totalElements: number = 0;
  regions: String[] = [];



  public searchForm!: FormGroup;
  public regionSelected = '';
  public startDate = '';
  public endDate = '';
  
  constructor(
    private countryService: CountryserviceService,
    private fb: FormBuilder
    ) { }

  ngOnInit(): void {
    this.searchFormInit();
    this.countryService.getCountriesPageble(5,15).subscribe(data =>{ 
      this.countries = data.content;
      this.totalElements = data.numberOfElements;
      this.dataSource = new MatTableDataSource<Country>(data.content);
      this.dataSource.sort = this.sort;
      this.dataSource.filterPredicate = this.getFilterPredicate();
        }, error => {
          console.log(error.error.message);
        }
      )
      this.countryService.getRegions().subscribe(
        data => this.regions = data
        )
  }

  nextPage(event: PageEvent) {
    const page = event.length;
    const size = event.pageSize;
    this.getCountries(page,size);
}

  getCountries(page: number, size: number){
    this.countryService.getCountriesPageble(page,size).subscribe(data =>{ 
      this.countries = data.content;
      this.totalElements = data.numberOfElements;
      this.dataSource = new MatTableDataSource<Country>(data.content);
    }, error => {
      console.log(error.error.message);
    }
  )
  };


  searchFormInit() {
    this.searchForm = this.fb.group({
      regionSelected: [],
      startDate: [],
      endDate: []
    });
  }

  getFilterPredicate() {
    return (row: Country, filters: string) => {
      const filterArray = filters.split('$');
      const regionSelected = filterArray[0];
      const startDate = filterArray[1].split(' ');
      const endDate = filterArray[2].split(' ');

      const matchFilter = [];
      
      const columnRegion = row.regions.name;
      const columnYears = row.countryStats.map(({ year }) => year);

      const customFilterRegion = columnRegion.toLowerCase().includes(regionSelected);
      const customFilterDS = columnYears.includes(Number(startDate[3]));
      const customFilterAS = columnYears.includes(Number(endDate[3]));

      matchFilter.push(customFilterRegion);
      matchFilter.push(customFilterDS);
      matchFilter.push(customFilterAS);

      return matchFilter.every(Boolean);
    };
  }

 
  applyFilter() {
   
    const region = this.searchForm.get('regionSelected');
    const dateStart = this.searchForm.get('startDate');
    const dateEnd = this.searchForm.get('endDate');

console.log(dateEnd?.value)
    this.regionSelected = region?.value === null ? '' : region?.value;
    this.startDate = (dateStart?.value === null || dateStart?.value === '') ? '' : dateStart?.value.toDateString();
    this.endDate = (dateEnd?.value === null || dateEnd?.value === '') ? '' : dateEnd?.value.toDateString();


    const filterValue = this.regionSelected + '$' + this.startDate + '$' + this.endDate;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
