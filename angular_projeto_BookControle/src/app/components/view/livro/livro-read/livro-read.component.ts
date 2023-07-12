import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livro-read',
  templateUrl: './livro-read.component.html',
  styleUrls: ['./livro-read.component.css']
})
export class LivroReadComponent  implements OnInit {
  livro: Livro = {
    id: '',
    titulo: '',
    nome_autor: '',
    texto: ''
  }

  id_cat!: String;

  constructor(private serviceLivro: LivroService, private router: Router, private routerActive: ActivatedRoute) { }

  ngOnInit(): void {
    this.livro.id = this.routerActive.snapshot.paramMap.get('id')!;
    this.id_cat = this.routerActive.snapshot.paramMap.get('id_cat')!;
    this.findById()
  }

  findById(): void {
    this.serviceLivro.findById(this.livro.id!).subscribe(
      (res)=>{
        this.livro = res;
      }
    )
  }

  volta (): void{
    this.router.navigate([`categorias/${this.id_cat}/livros`]);
  }

}
