package br.edu.ifsp.arq.sice.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifsp.arq.sice.model.Servico;

@Controller
public class ServicoController {
	
	@RequestMapping("/estabelecimentos/cadastro-servico")
	public String cadastro(Servico servico) {
		return "estabelecimento/cadastro-servico";
	} 

	@RequestMapping(value = "/estabelecimentos/cadastro-servico", method = RequestMethod.POST)
	public String cadastrar(@Valid Servico servico, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()){		
			//coloca os valores de volta nos campos quando der erro.			
			return cadastro(servico);
		}
		attributes.addFlashAttribute("mensagem", "Serviço salvo com sucesso!");
		
		return "redirect:/estabelecimentos/cadastro-servico";
		
	}
}
