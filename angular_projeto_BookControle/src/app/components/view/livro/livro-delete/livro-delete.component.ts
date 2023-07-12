import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livro-delete',
  templateUrl: './livro-delete.component.html',
  styleUrls: ['./livro-delete.component.css']
})
export class LivroDeleteComponent implements OnInit {
  livro: Livro = {
    id: '',
    titulo: '',
    nome_autor: '',
    texto: ''
  }
  

  id_cat!: String;

  constructor(private serviceLivro: LivroService, private router: Router, private routerActive: ActivatedRoute) { }

  ngOnInit(): void {
    this.id_cat= this.routerActive.snapshot.paramMap.get("id_cat")!;
    this.livro.id = this.routerActive.snapshot.paramMap.get('id')!;
    this.findById();
  }

  findById(): void {
    this.serviceLivro.findById(this.livro.id!).subscribe(
      (res)=>{
        this.livro = res;
      }
    )
  }

  delete(): void {
    this.serviceLivro.delete(this.livro.id!).subscribe(
      (res)=>{
        this.serviceLivro.mensagem(`Excluido com sucesso o livro ${this.livro.titulo}`);
        this.router.navigate([`categorias/${this.id_cat}/livros`])
      },
      (er) =>{
        this.serviceLivro.mensagem("Erro na exclusão! Não foi possível excluir!");
      }
    );
  }

  cancel (): void{
    this.router.navigate([`categorias/${this.id_cat}/livros`]);
  }

}
