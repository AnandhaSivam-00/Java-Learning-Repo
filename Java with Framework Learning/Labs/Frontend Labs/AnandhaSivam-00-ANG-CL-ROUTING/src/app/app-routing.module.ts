import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {FeedComponent} from "./components/feed/feed.component";
import {SearchComponent} from "./components/search/search.component";
import { ProfileComponent } from './components/profile/profile.component';

/**
 * This array contains all of the routes. Every route constitutes of a 'path' and a component which is used as a
 * 'page' - in a real application, components are actually hierarchically organized between pages and components,
 * with potentially multiple layers of components organized by their size.
 *
 * Notice that the path for the home component is '**'. This is a wildcard, meaning, 'any path'. So, going to a random
 * url on localhost:4200 will lead the user back to home. Typically, this would be used as a '404 page not found' type
 * of page. It's also important that this route is last, as Angular picks the first matching route.
 *
 * If you would like to look into how to also prevent users from accessing off-limits routes, look into route guards.
 * Route guards ensure that some condition must be met for users to access some route.
 *
 * TODO: add a route to 'profile', where the ProfileComponent is displayed. Be sure that the component is properly
 * imported, and that you link to the 'profile' route within the navbar component.
 */
export const routes: Routes = [
  {path: 'feed', component: FeedComponent},
  {path: 'search', component: SearchComponent},
  //add the 'profile' route
  {path: 'profile', component: ProfileComponent},
  {path: '**', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
