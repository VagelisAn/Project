import { Component, Input } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { CountryStat } from 'src/app/models/CountryStat';

@Component({
  selector: 'app-expand',
  templateUrl: './expand.component.html',
  styleUrls: ['./expand.component.css']
})
export class ExpandComponent {

  @Input() countryStats!: CountryStat[];
  @Input() displayHeading : boolean = false;
  displayedColumns = ['year','population', 'gdp'];
  dataSource!: MatTableDataSource<CountryStat>;

  ngOnInit() {
    if (this.areDataValid(this.countryStats)) {
      this.dataSource = new MatTableDataSource(this.countryStats);
    }

  }

  areDataValid(countryStats : CountryStat[]) : boolean {
    return typeof countryStats != "undefined" && countryStats != null && countryStats.length > 0;
  }

}
