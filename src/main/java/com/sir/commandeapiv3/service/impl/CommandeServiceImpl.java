/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commandeapiv3.service.impl;

import com.sir.commandeapiv3.bean.Commande;
import com.sir.commandeapiv3.bean.CommandeItem;
import com.sir.commandeapiv3.dao.CommandeDao;
import com.sir.commandeapiv3.service.CommandeItemService;
import com.sir.commandeapiv3.service.CommandeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Keita Moussa
 */
@Service
public class CommandeServiceImpl implements CommandeService{
    
    @Autowired
     private CommandeDao commandeDao;
    @Autowired
    private CommandeItemService commandeItemService;
     
    @Autowired
    //private ProduitService produitService; //le proxy//
    @Override
    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    @Override
    public int payer(String reference, double montant) {
       Commande commande = findByReference(reference);
       if(commande==null){
           return -1;
       }
       else if(commande.getTotalPaiement()+montant > commande.getTotal()){
           return -2;
       }
       else{
           double nvPaiement = commande.getTotalPaiement()+montant;
           commande.setTotalPaiement(nvPaiement);
           commandeDao.save(commande);
 
           return 1;
       }
    }

//    @Override
//    public int creer(Commande commande) {
//       Commande c = findByReference(commande.getReference());
//       if(c!=null){
//           return -1;
//       }
//       else{
//           double total=0.0;
//           List<CommandeItem> commandeItems = commande.getCommandeItems();
//           for(CommandeItem commandeItem : commandeItems)
//           {              
//           total+=commandeItem.getPrix()*commandeItem.getQuantite();
//           }
//           commande.setTotal(total);
//           /***************************************/
//           commande.setTotalPaiement(0D);
//           commandeDao.save(commande);
//           return 1;
//         }
//    }
//  

    public CommandeDao getCommandeDao() {
        return commandeDao;
    }

    public void setCommandeDao(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }



    public CommandeItemService getCommandeItemService() {
        return commandeItemService;
    }

    public void setCommandeItemService(CommandeItemService commandeItemService) {
        this.commandeItemService = commandeItemService;
    }

    private void calculerTotalCommande(Commande commande , List<CommandeItem> commandeItems) {
        double total=0.D;
        for(CommandeItem commandeItem : commandeItems){
            total+=commandeItem.getPrix()*commandeItem.getQuantite();
        }
            commande.setTotal(total);
    }
    

    @Override
    public Commande saveCommandeWithCommandeItems(Commande commande) {
        calculerTotalCommande(commande ,commande.getCommandeItems());
        commandeDao.save(commande);
        commandeItemService.saveCommandeItem(commande, commande.getCommandeItems());
        return commande;
    }
}
