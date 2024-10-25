package org.insset.client.service;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class PourcentageService_Proxy extends RemoteServiceProxy implements org.insset.client.service.PourcentageServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.insset.client.service.PourcentageService";
  private static final String SERIALIZATION_POLICY ="43F4931FED7307202EF7E81F43351F8A";
  private static final org.insset.client.service.PourcentageService_TypeSerializer SERIALIZER = new org.insset.client.service.PourcentageService_TypeSerializer();
  
  public PourcentageService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "pourcentage", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void DivisionEntier(java.lang.Integer Dividende, java.lang.Integer Diviseur, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("PourcentageService_Proxy", "DivisionEntier");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeObject(Dividende);
      streamWriter.writeObject(Diviseur);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  
  public void Pourcentage(java.lang.Integer MontantDepart, java.lang.Integer Pourcentage, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("PourcentageService_Proxy", "Pourcentage");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 2);
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeString("java.lang.Integer/3438268394");
      streamWriter.writeObject(MontantDepart);
      streamWriter.writeObject(Pourcentage);
      helper.finish(callback, ResponseReader.STRING);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
