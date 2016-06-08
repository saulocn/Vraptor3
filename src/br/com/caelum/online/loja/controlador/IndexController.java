package br.com.caelum.online.loja.controlador;

import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

@Resource
public class IndexController {
	
	
	private Validator validator;

	public IndexController(Validator validator) {
		this.validator = validator;
	}

	@Path("/")
	public void root() {
		System.out.println("Meu sistema com vraptor");
	}

	public void adicionar(final Produto produto) {

	    validator.checking(new Validations(){{
	        that(produto.getPreco() > 0.1,"erro", "produto.preco.invalido");
	        that((3<produto.getDescricao().length() && produto.getDescricao().length() <100), "erro", "produto.desricao.tamanho");
	        that(produto.getDescricao().isEmpty(), "erro", "produto.desricao.vazio");
	    }});

	    validator.onErrorUsePageOf(ProdutoController.class).formulario();
	}
}
