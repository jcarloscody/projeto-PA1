import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Livro } from '../livro.model';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livro-all',
  templateUrl: './livro-all.component.html',
  styleUrls: ['./livro-all.component.css']
})
export class LivroAllComponent implements OnInit {

  displayedColumns: string[] = ['id', 'titulo', 'livros', 'acoes'];
  livros: Livro[] = [];
  id_cat = this.routerActivated.snapshot.paramMap.get('id_cat')!;

  constructor(private livroService: LivroService, private router: Router, private routerActivated: ActivatedRoute) { }

  ngOnInit(): void {
    this.findAllByCategoria(this.id_cat);
  }

  findAllByCategoria (id_cat: String): void {
    this.livroService.findAllByCategoria(id_cat).subscribe((livros)=>{
      this.livros = livros;
    })
  }

  navegarParaLivroCreate(): void {
    this.router.navigate([`categorias/${this.id_cat}/livros/create`]);
  }


}
