/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sir.commandeapiv3.service;

import com.sir.commandeapiv3.bean.Commande;
import com.sir.commandeapiv3.bean.CommandeItem;
import com.sir.commandeapiv3.dao.CommandeItemDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
 * @author Keita Moussa
 */

public interface CommandeItemService {
     public List<CommandeItem> findByCommandeReference(String reference);
         public int saveCommandeItem(Commande commande, List<CommandeItem> commandeItems);
}
