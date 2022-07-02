/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melordi;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;



public class ChangeInstru extends Parent{
    
    // ajout de trois bouton radio
    private RadioButton rb_piano;
    private RadioButton rb_guitare;
    private RadioButton rb_orgue;
    
    private Instru instru;  // declaration d'une variable instrument pour faire le chamgement 
                            //d'instrument lors de la selection du bouton radio
    
public ChangeInstru(Instru ins){
      
        //Déclarer un objet instru de type Instru dans notre classe ChangeInstru.
        //Passer la valeur de l'objet mon_instru de la classe Melordi en paramètre
        //du constructeur ChangeInstru().
        //Affecter la valeur du paramètre du constructeur à l'objet instru de la
        //classe ChangeInstru
        instru = ins;
        
        GridPane gridpane = new GridPane();
        
        //création des images des 3 instruments
        //cree un package dans le package melodi puis enregistrer les trois images
        ImageView piano = new ImageView(new Image(ChangeInstru.class.getResourceAsStream("images/327153.png")));
        piano.setFitHeight(50);
        piano.setPreserveRatio(true);
        ImageView guitare = new ImageView(new Image(ChangeInstru.class.getResourceAsStream("images/327154.png")));
        guitare.setFitHeight(50);
        guitare.setPreserveRatio(true);
        ImageView orgue = new ImageView(new Image(ChangeInstru.class.getResourceAsStream("images/327155.png")));
        orgue.setFitHeight(50);
        orgue.setPreserveRatio(true);
        
        
        // creation des boutons Radio
        
             //création des boutons radio
        ToggleGroup groupe = new ToggleGroup();
        rb_piano = new RadioButton();
        rb_guitare = new RadioButton();
        rb_orgue = new RadioButton();
        rb_piano.setToggleGroup(groupe);
        rb_guitare.setToggleGroup(groupe);
        rb_orgue.setToggleGroup(groupe);
        rb_piano.setFocusTraversable(true);
        rb_guitare.setFocusTraversable(true);
        rb_orgue.setFocusTraversable(true);
        rb_piano.setSelected(true);//le piano est l'instrument sélectionné par défaut
        

         //ajout d'un ChangeListener au groupe de boutons radio
        groupe.selectedToggleProperty().addListener(new ChangeListener(){
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(newValue.equals(rb_piano))
                    instru.set_instrument(0);//numéro MIDI du piano = 0
                else if(newValue.equals(rb_guitare))
                    instru.set_instrument(26);//numéro MIDI de la guitare = 26
                else
                    instru.set_instrument(16);//numéro MIDI de l'orgue = 16
            }
        });

        //on ajoute nos images à notre layout
        gridpane.add(piano, 1, 0);
        gridpane.add(guitare, 1, 1);
        gridpane.add(orgue, 1, 2);
        gridpane.setVgap(15);
        
         //on ajoute les boutons radio au layout
        gridpane.add(rb_piano, 0, 0);
        gridpane.add(rb_guitare, 0, 1);
        gridpane.add(rb_orgue, 0, 2);
        gridpane.setHgap(20);
        
        // positionnement du gridlayout
        this.setTranslateX(100);
        this.setTranslateY(30);
        this.getChildren().add(gridpane);
    }

    
    
}
