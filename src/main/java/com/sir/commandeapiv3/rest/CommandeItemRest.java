/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commandeapiv3.rest;

import com.sir.commandeapiv3.bean.Commande;
import com.sir.commandeapiv3.bean.CommandeItem;
import com.sir.commandeapiv3.rest.converter.CommandeConverter;
import com.sir.commandeapiv3.service.CommandeItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Keita Moussa
 */
@RestController()
@RequestMapping("/commande-api-v3/commandeItems")
public class CommandeItemRest {
    @Autowired
    private CommandeItemService commandeItemService;
//@GetMapping("/reference/{reference}")
//    public List<CommandeItem> findByCommandeReference(@PathVariable String reference) {
//        return new CommandeConverter().toVo(commandeItemService.findByCommandeReference(reference));
//    }
//@PostMapping("/")
//    public int saveItem(@RequestBody Commande commande) {
//        return commandeItemService.saveItem(commande);
//    }
//    

    
    public CommandeItemService getCommandeItemService() {
        return commandeItemService;
    }

    public void setCommandeItemService(CommandeItemService commandeItemService) {
        this.commandeItemService = commandeItemService;
    }
    
    
}
