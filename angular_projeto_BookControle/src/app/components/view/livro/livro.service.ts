import { environment } from './../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Livro } from './livro.model';


@Injectable({
  providedIn: 'root'
})
export class LivroService {

  baseUrl: String = environment.baseUrl;

  constructor(private http: HttpClient, private _snack: MatSnackBar) { }

  findAllByCategoria(id_cat: String): Observable<Livro[]> {
    const url = `${this.baseUrl}/livros?categoria=${id_cat}`;
    return this.http.get<Livro[]>(url);
  }

  create(livro: Livro, id_cat: String): Observable<Livro>{
    const url = `${this.baseUrl}/livros?categoria=${id_cat}`;
    return this.http.post<Livro>(url, livro);
  }

  mensagem(msg: string): void {
    this._snack.open(`${msg}`, 'OK!', {horizontalPosition: 'center', verticalPosition: 'bottom', duration: 50000,})
  }


  findById(id: String): Observable<Livro> {
    const url = `${this.baseUrl}/livros/${id}`;
    return this.http.get<Livro>(url);
  }

  findAll ():Observable<Livro[]> {
    const url = `${this.baseUrl}/livros`
    return this.http.get<Livro[]>(url);
  }

  update(livro: Livro): Observable<void> {
    const url = `${this.baseUrl}/livros/${livro.id}`;
    return this.http.put<void>(url, livro);
  }

  delete (id: String): Observable<void> {
    const url = `${this.baseUrl}/livros/${id}`;
    return this.http.delete<void>(url);
  }

  

}
