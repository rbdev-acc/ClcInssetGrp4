/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;

/**
 *
 * @author user
 */
public interface PourcentageServiceAsync {
  void DivisionEntier(Integer Dividende,Integer Diviseur, AsyncCallback<Integer> callback) throws IllegalArgumentException;
      void Pourcentage(Integer MontantDepart, Integer Pourcentage, AsyncCallback<String> callback) throws IllegalArgumentException;

}

