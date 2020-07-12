import { CommonModule } from '@angular/common'
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatTabsModule} from '@angular/material/tabs'
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { CreateTestComponent } from './components/create-test/create-test.component';
import { TestComponent } from './components/test/test.component';
import { ShowComponent } from './components/show/show.component';
import { RouterModule, Routes } from '@angular/router'
import { MatFormFieldModule} from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatInputModule } from '@angular/material/input'
import { TestServiceService } from './shared/test-service.service';
import { HttpClientModule } from '@angular/common/http';

const myAppRoutes:Routes = [
  { path: 'addQ', component: CreateTestComponent },
  { path: 'test', component: TestComponent },
  { path: 'show', component: ShowComponent },
  { path: '', redirectTo: 'addQ', pathMatch: 'full' }
]
@NgModule({
  declarations: [
    AppComponent,
    CreateTestComponent,
    TestComponent,
    ShowComponent,
    //
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatTabsModule,
    RouterModule.forRoot(
      myAppRoutes,
    ),
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [TestServiceService,],
  bootstrap: [AppComponent]
})
export class AppModule { }
