import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Language } from 'src/app/models/Language';
import { CountryserviceService } from 'src/app/services/countryservice.service';

@Component({
  selector: 'app-languages',
  templateUrl: './languages.component.html',
  styleUrls: ['./languages.component.css']
})
export class LanguagesComponent implements OnInit {
  id!: number;
  languages: Language[]=[];
  countryName!: string;

  constructor(
    private route: ActivatedRoute,
    private countryService: CountryserviceService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.countryService.getCountryNameById(this.id)
    .subscribe(data => {
      this.countryName = data.name;
    });
    this.countryService.getLanguagesByCountryId(this.id)
    .subscribe(data => this.languages = data);
  }

}
