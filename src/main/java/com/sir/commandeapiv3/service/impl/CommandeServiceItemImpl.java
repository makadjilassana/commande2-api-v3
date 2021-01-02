/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commandeapiv3.service.impl;

import com.sir.commandeapiv3.bean.Commande;
import com.sir.commandeapiv3.bean.CommandeItem;
import com.sir.commandeapiv3.dao.CommandeItemDao;
import com.sir.commandeapiv3.rest.proxy.ProduitProxy;
import com.sir.commandeapiv3.service.CommandeItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Keita Moussa
 */
@Service
public class CommandeServiceItemImpl implements CommandeItemService{
   @Autowired
    private CommandeItemDao commandeItemDao;
   @Autowired
   private ProduitProxy produitProxy;
    
    @Override
    public List<CommandeItem> findByCommandeReference(String reference) {
       return commandeItemDao.findByCommandeReference(reference);
    }
//    @Override
//    public int saveItem(Commande commande) {
//        
//     List<CommandeItem> commandeItems = commande.getCommandeItems();
//     for(CommandeItem commandeItem : commandeItems){
//         ProduitVo produitVo = produitProxy.findByReference(commandeItem.getRefProduit());
//         if(produitVo!=null && !produitVo.getReference())
//         commandeItem.setCommande(commande);
//         commandeItemDao.save(commandeItem);
//     }
//     return 1;
//    }
//   

    public CommandeItemDao getCommandeItemDao() {
        return commandeItemDao;
    }

    public void setCommandeItemDao(CommandeItemDao commandeItemDao) {
        this.commandeItemDao = commandeItemDao;
    }

    public ProduitProxy getProduitProxy() {
        return produitProxy;
    }

    public void setProduitProxy(ProduitProxy produitProxy) {
        this.produitProxy = produitProxy;
    }

    @Override
    public int saveCommandeItem(Commande commande, List<CommandeItem> commandeItems) {
      for(CommandeItem commandeItem : commandeItems){
          commandeItem.setCommande(commande);
          commandeItemDao.save(commandeItem);
          
      }
      return 1;
    }


    }

    
   

   
    
    /*******************************/
//           if(commande==null){
//           return -1;
//       }
//       else{
//           double montant=0;
//           List<CommandeItem> commandeItems = commande.getCommandeItems();
//           for(CommandeItem commandeItem:commandeItems){
//               montant=commandeItem.getPrix()*commandeItem.getQuantite();
//           }
//           commande.setTotalPaiement(montant);
//           commandeItemDao.save(commande);
//           for(int i=0 ; i< commandeItems.size();i++){
//               CommandeItem commandeItem = commandeItems.get(i);
//               commandeItems.setC
//           }
//       }

