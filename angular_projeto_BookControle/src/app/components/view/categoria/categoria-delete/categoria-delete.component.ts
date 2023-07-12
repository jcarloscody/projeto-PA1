import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from '../categoria.model';
import { CategoriaService } from '../categoria.service';

@Component({
  selector: 'app-categoria-delete',
  templateUrl: './categoria-delete.component.html',
  styleUrls: ['./categoria-delete.component.css']
})
export class CategoriaDeleteComponent implements OnInit {

  categoria: Categoria = {
    id: '',
    nome : '',
    descricao : ''
  }


  constructor(private serviceCategoria: CategoriaService, private routerActivated: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.categoria.id = this.routerActivated.snapshot.paramMap.get('id')!;
    this.findById()
  }

  findById(): void {
    this.serviceCategoria.findById(this.categoria.id!).subscribe(
      resposta => {
        this.categoria = resposta;
        console.warn(this.categoria);
      }
    )
  }

  delete(): void{
    this.serviceCategoria.delete(this.categoria.id!).subscribe(
      (res)=>{
        this.serviceCategoria.mensagem("sucesso na exclusão!");
        this.router.navigate(["/categorias"]);
      }, 
      (err)=>{
        console.warn(err)
        this.serviceCategoria.mensagem(err.error.error)
      }
    )
  }

  cancel(): void {
    this.router.navigate(["/categorias"]);
  }



}
