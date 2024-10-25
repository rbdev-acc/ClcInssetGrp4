package org.insset.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("pourcentage")
public interface PourcentageService extends RemoteService {

    Integer DivisionEntier(Integer Dividende, Integer diviseur ) throws IllegalArgumentException;
    String Pourcentage(Integer MontantDepart, Integer Pourcentage) throws IllegalArgumentException;
}
