import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from '../categoria.model';
import { CategoriaService } from '../categoria.service';

@Component({
  selector: 'app-categoria-update',
  templateUrl: './categoria-update.component.html',
  styleUrls: ['./categoria-update.component.css']
})
export class CategoriaUpdateComponent implements OnInit {

  categoria: Categoria = {
    nome: "",
    descricao: ""
  }

  constructor(private serviceCategoria: CategoriaService, private routerActivated: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.categoria.id = this.routerActivated.snapshot.paramMap.get("id")!;
    this.findById();
  }

  findById(): void {
    this.serviceCategoria.findById(this.categoria.id!).subscribe(
      resposta => {
        this.categoria = resposta;
      }
    )
  }

  update(): void {
    this.serviceCategoria.update(this.categoria).subscribe(
      (res)=>{
        this.router.navigate(["/categorias"]);
        this.serviceCategoria.mensagem("Atualização realizada com Sucesso");
      }, 
      ( err) => {
        let msg: string = '';
        for (let i = 0; i<err.error.errors.length; i++){
          msg += `Coluna: ${err.error.errors[i].fildName} - Mensagem: ${err.error.errors[i].message} \n`;
        }
        this.serviceCategoria.mensagem(msg);
      }
    );
  }


  cancel(): void {
    this.router.navigate(["categorias"]);
  }

}
