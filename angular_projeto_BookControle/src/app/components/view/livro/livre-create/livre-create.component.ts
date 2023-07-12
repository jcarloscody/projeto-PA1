import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livre-create',
  templateUrl: './livre-create.component.html',
  styleUrls: ['./livre-create.component.css']
})
export class LivreCreateComponent implements OnInit {

  titulo = new FormControl('', [Validators.minLength(3)]);
  autor = new FormControl('', [Validators.minLength(3)]);
  texto = new FormControl('', [Validators.minLength(3)]);

  id_cat!: String;

  constructor(private serviceLivro: LivroService, private router: Router, private routerActive: ActivatedRoute) { }

  ngOnInit(): void {
    this.id_cat= this.routerActive.snapshot.paramMap.get("id_cat")!;
  }

  getMessage() {
    if (this.titulo.invalid) {
      return "O campo título deve ter no mínimo 3 Caracteres e no máximo 100"
    }
    if (this.autor.invalid) {
      return "O campo Autor deve ter no mínimo 3 Caracteres e no máximo 100"
    }
    if (this.texto.invalid) {
      return "O campo Texto deve ter no mínimo 3 Caracteres e no máximo 100"
    }
    return false;
  }

  create(): void {
    this.serviceLivro.create({titulo: this.titulo.value, nome_autor: this.autor.value, texto: this.texto.value}, this.id_cat!).subscribe((resposta)=>{
      this.serviceLivro.mensagem("Livro Inserido com Sucesso!");
      this.router.navigate([`categorias/${this.id_cat}/livros`]);
    }, erro => {
      console.warn(erro)
      if (erro.error.errors){
        for (let i=0; i<erro.error.errors.length; i++) {
          this.serviceLivro.mensagem(`\n Coluna: ${erro.error.errors[i].fildName}  Mensagem: ${erro.error.errors[i].message} \n`)
        }
      } else {
        this.serviceLivro.mensagem(` ${erro.error.error} `)
      }
    })
  }

  cancel (): void{
    this.router.navigate([`categorias/${this.id_cat}/livros`]);
  }

}
