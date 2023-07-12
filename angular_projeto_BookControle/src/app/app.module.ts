import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSnackBarModule } from '@angular/material/snack-bar';

// componentes
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/template/header/header.component';
import { FooterComponent } from './components/template/footer/footer.component';
import { NavComponent } from './components/template/nav/nav.component';
import { HomeComponent } from './components/view/home/home.component';
import { CategoriaReadComponent } from './components/view/categoria/categoria-read/categoria-read.component';
import { CategoriaCreateComponent } from './components/view/categoria/categoria-create/categoria-create.component';
import { CategoriaDeleteComponent } from './components/view/categoria/categoria-delete/categoria-delete.component';
import { CategoriaUpdateComponent } from './components/view/categoria/categoria-update/categoria-update.component';
import { LivroReadComponent } from './components/view/livro/livro-read/livro-read.component';
import { LivroAllComponent } from './components/view/livro/livro-all/livro-all.component';
import { LivreCreateComponent } from './components/view/livro/livre-create/livre-create.component';
import { LivroDeleteComponent } from './components/view/livro/livro-delete/livro-delete.component';
import { LivroUpdateComponent } from './components/view/livro/livro-update/livro-update.component';

@NgModule({
  declarations: [
    CategoriaReadComponent,
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    HomeComponent,
    CategoriaCreateComponent,
    CategoriaDeleteComponent,
    CategoriaUpdateComponent,
    LivroReadComponent,
    LivroAllComponent,
    LivreCreateComponent,
    LivroDeleteComponent,
    LivroUpdateComponent,
    
  ],
  imports: [
    BrowserModule,
    MatTableModule,
    MatIconModule,
    AppRoutingModule,
    MatSidenavModule,
    MatListModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatCardModule,
    HttpClientModule,
    MatButtonModule,
    FormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatSnackBarModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
