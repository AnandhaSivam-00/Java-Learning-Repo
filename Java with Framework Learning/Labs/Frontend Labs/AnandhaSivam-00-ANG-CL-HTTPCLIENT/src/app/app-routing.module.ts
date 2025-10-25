import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ReportByIdComponent} from "./components/report-by-id/report-by-id.component";
import {AllReportsComponent} from "./components/all-reports/all-reports.component";
import {AllArticlesComponent} from "./components/all-articles/all-articles.component";
import {HomeComponent} from "./components/home/home.component";

const routes: Routes = [
  {path:"reportbyid", component:ReportByIdComponent},
  {path:"reports", component:AllReportsComponent},
  {path:"articles", component:AllArticlesComponent},
  {path:"**", component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
