import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ListComponent } from './pages/list/list.component';
import { TableComponent } from './pages/table/table.component';
import { Table2Component } from './pages/table2/table2.component';
import { LanguagesComponent } from './components/languages/languages.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'list', component: ListComponent },
  { path: 'table', component: TableComponent },
  { path: 'table2', component: Table2Component },
  { path: 'languages/:id/view', component: LanguagesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
