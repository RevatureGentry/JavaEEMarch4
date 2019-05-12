import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderAddingInterceptorService } from './http/header-adding-interceptor.service';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AuthGuardService } from './services/auth-guard.service';
import { RegistrationComponent } from './components/registration/registration.component';
import { TweetTimelineComponent } from './components/tweet-timeline/tweet-timeline.component';
import { CreateTweetComponent } from './components/create-tweet/create-tweet.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    NavbarComponent,
    RegistrationComponent,
    TweetTimelineComponent,
    CreateTweetComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    AuthGuardService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HeaderAddingInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
