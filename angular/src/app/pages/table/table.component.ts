import { Component, ComponentFactoryResolver, OnInit, ViewChild, ViewChildren, ViewContainerRef } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Country } from 'src/app/models/Country';
import { CountryserviceService } from 'src/app/services/countryservice.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { CountryStat } from 'src/app/models/CountryStat';
import { animate, state, style, transition, trigger } from '@angular/animations';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({ height: '0px', minHeight: '0' })),
      state('expanded', style({ height: '*' })),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class TableComponent implements OnInit {
displayedColumns: string[] = ['name', 'countryCode3'];
displayedColumnsVersion: string[] = ['year', 'population', 'gdp'];
dataSource!: MatTableDataSource<Country>;
expandedElement: any;
@ViewChild(MatPaginator) paginator!: MatPaginator;
@ViewChild(MatSort) sort!: MatSort;
@ViewChildren("tableRow", { read: ViewContainerRef }) rowContainers: any;
countries: Country[]= [];

  constructor(
    private countryService: CountryserviceService,
    private resolver: ComponentFactoryResolver
    ) { }

  ngOnInit(): void {
    this.countryService.getCountriesWithStats().subscribe(data =>{ 
      // this.dataSources = new  Array<MatTableDataSource<Country>>();
      // for (let country of data) {
      //   this.setDataSources(country);
      // }
      this.dataSource = new MatTableDataSource<Country>(data);
      this.dataSource.paginator = this.paginator;
      // this.dataSource.sort = this.countryTbSort;
      this.countries = data;
      console.log(data);
  });
}

}
