package com.interoperabilite.inter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;


@RestController
public class CommandeController {

	@Autowired
	private CommandeRepository commandeRepo;
	
	@GetMapping("/commandes")
	public List<Commande> getAllCommande() {
		return commandeRepo.findAll();
	}
	

	  @PostMapping("/commandes")
	  Commande newCommande(@RequestBody Commande newCommande) {
	    return commandeRepo.save(newCommande);
	  }

	  // Single item
	  
	  @GetMapping("/commande/{id}")
	  Commande one(@PathVariable BigDecimal id) throws Exception {
	    
	    return commandeRepo.findById(id)
	      .orElseThrow(Exception::new);
	  }

	  @PutMapping("/commande/{id}")
	  Commande replaceCommande(@RequestBody Commande newCommande, @PathVariable BigDecimal id) {
	    
	    return commandeRepo.findById(id)
	      .map(commande -> {
	    	  commande.setDateCommande(newCommande.getDateCommande());
	    	  commande.setNomEmmeteur(newCommande.getNomEmmeteur());
	        return commandeRepo.save(commande);
	      })
	      .orElseGet(() -> {
	        newCommande.setId(id);
	        return commandeRepo.save(newCommande);
	      });
	  }

	  @DeleteMapping("/commande/{id}")
	  void deleteCommande(@PathVariable BigDecimal id) {
	    commandeRepo.deleteById(id);
	  }
}
