/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.pourcentage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResetButton;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.TextBox;
import org.insset.client.message.Messages;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
import org.insset.client.service.PourcentageService;
import org.insset.client.service.PourcentageServiceAsync;
import org.insset.shared.FieldVerifier;

/**
 *
 * @author user
 */
public class PourcentagePresenter extends Composite {

    @UiField
    public ResetButton boutonClear;
    @UiField
    public SubmitButton boutonDivision;
    @UiField
    public TextBox Dividende;
    @UiField
    public TextBox Diviseur;
    @UiField
    public Label errorLabel;
    @UiField
    public ResetButton boutonClearPourcentage;
    @UiField
    public SubmitButton boutonPourcentage;
    @UiField
    public TextBox MontantDepart;
    @UiField
    public TextBox Pourcentage;
    @UiField
    public Label errorLabelPourcentage;
    

    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    private  PourcentageServiceAsync service = GWT.create(PourcentageService.class);

    private final Messages messages = GWT.create(Messages.class);

    interface AddUiBinder extends UiBinder<HTMLPanel, PourcentagePresenter> {
    }

    /**
     * Create UiBinder for the view
     */
    private static AddUiBinder ourUiBinder = GWT.create(AddUiBinder.class);

    /**
     * Constructeur
     */
    public PourcentagePresenter() {
        //bind de la page
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }

    /**
     * Methode qui innitialise les handler pour les cliques sur les boutons
     */
    protected void initHandler() {
        boutonClear.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Dividende.setText("");
                Diviseur.setText("");
                errorLabel.setText("");
            }
        });
        boutonDivision.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                DivisionEntierService();
            }

        });
        boutonClearPourcentage.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                MontantDepart.setText("");
                Pourcentage.setText("");
                errorLabelPourcentage.setText("");
            }
        });
        boutonPourcentage.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                PourcentageService();
            }

        });
    }

    private void DivisionEntierService() {
        errorLabel.setText("");
        final String DividendeToServer = Dividende.getText();
        final String DiviseurToServer = Diviseur.getText();
        if (!FieldVerifier.isValidDividende(DividendeToServer)) {
            errorLabel.addStyleName("serverResponseLabelError");
            errorLabel.setText("Dividende Invalide");
            return;
        }else if(!FieldVerifier.isValidDiviseur(DiviseurToServer)){
           errorLabel.addStyleName("serverResponseLabelError");
            errorLabel.setText("Diviseur Invalide");
            return; 
        }
        service.DivisionEntier(Integer.parseInt(DividendeToServer),Integer.parseInt(DiviseurToServer), new AsyncCallback<Integer>()
        {
            @Override
            public void onFailure(Throwable caught) {
            if(caught instanceof IllegalArgumentException) {
               // System.out.println(caught.getMessage());
                errorLabel.addStyleName("serverResponseLabelError");
                errorLabel.setText(caught.getMessage());
                //Window.alert(caught.toString());
    }
        
            }
            
            public void onSuccess(Integer result) {
                errorLabel.setText(" ");

                new DialogBoxInssetPresenter("Quotient de votre division", DividendeToServer +"/"+DiviseurToServer, String.valueOf(result));  /// ? 
            }
        });
    }
    private void PourcentageService() {
        errorLabel.setText("");
        final String MontantDepartToServer = MontantDepart.getText();
        final String PourcentageToServer = Pourcentage.getText();
        if (!FieldVerifier.isValidMontantDepart(MontantDepartToServer)) {
            errorLabelPourcentage.addStyleName("serverResponseLabelError");
            errorLabelPourcentage.setText("Montant de depart invalide");
            return;
        }else if(!FieldVerifier.isValidPourcentage(PourcentageToServer)){
           errorLabelPourcentage.addStyleName("serverResponseLabelError");
            errorLabelPourcentage.setText("Pourcentage Invalide");
            return; 
        }
        service.Pourcentage(Integer.parseInt(MontantDepartToServer),Integer.parseInt(PourcentageToServer), new AsyncCallback<String>()
        {
            @Override
            public void onFailure(Throwable caught) {
            if(caught instanceof IllegalArgumentException) {
               // System.out.println(caught.getMessage());
                errorLabel.addStyleName("serverResponseLabelError");
                errorLabel.setText(caught.getMessage());
                //Window.alert(caught.toString());
    }
        
            }
            
            public void onSuccess(String result) {
                errorLabel.setText(" ");

                new DialogBoxInssetPresenter("Resultat de votre pourcentage", PourcentageToServer +"% de"+MontantDepartToServer, String.valueOf(result));  /// ? 
            }
        });
    }
}
