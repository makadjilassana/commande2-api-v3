/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commandeapiv3.rest;

import com.sir.commandeapiv3.bean.Commande;
import com.sir.commandeapiv3.rest.converter.CommandeConverter;
import com.sir.commandeapiv3.rest.vo.CommandeVo;
import com.sir.commandeapiv3.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Keita Moussa
 */
@RestController()/* indique que la class est un controller REST :Spring sait alors que les réponses 
aux requêtes qu'il vous passe devront
être très probablement en format JSON.*/
@RequestMapping("/commande-api-v3/commandes")//lien entre l'uri et la methode//

public class CommandeRest {
    @Autowired
    private CommandeService commandeService;

    @GetMapping("reference/{reference}")
    public Commande findByReference(@PathVariable String reference) {
        return commandeService.findByReference(reference);
    }
    @PutMapping("reference/{reference}/montant/{montant}")
    public int payer(@PathVariable String reference, @PathVariable Double montant) {
        return commandeService.payer(reference, montant);
    }
//    @PostMapping("/")
//    public int creer( @RequestBody Commande commande) {
//        return commandeService.creer(commande);
//    }
//    

    public CommandeVo saveCommandeWithCommandeItems(CommandeVo commandeVo) {
       final CommandeConverter commandeConverter = new CommandeConverter();
        Commande commande = commandeConverter.toItem(commandeVo);
        return commandeConverter.toVo(commandeService.saveCommandeWithCommandeItems(commande));
    }
    
    public CommandeService getCommandeService() {
        return commandeService;
    }

    public void setCommandeService(CommandeService commandeService) {
        this.commandeService = commandeService;
    }
    
    
    
}
