package melordi;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Instru {
    
    //la variable volume de type int de la classe Instru en propriété de type IntegerProperty.
    public SimpleIntegerProperty volume = new SimpleIntegerProperty() ;
    private Synthesizer synthetiseur;
    private final MidiChannel canal;
    
    public Instru(){
        
        try {
            //On récupère le synthétiseur, on l'ouvre et on obtient un canal
            synthetiseur = MidiSystem.getSynthesizer();
            synthetiseur.open();
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Instru.class.getName()).log(Level.SEVERE, null, ex);
        }
        canal = synthetiseur.getChannels()[0];
        
        //On initialise l'instrument 0 (le piano) pour le canal
	canal.programChange(0);
    }
    //Joue la note dont le numéro est en paramètre
    //pour lier les notes au volume
    public void note_on(int note){
        canal.noteOn(note, volume.get());
    }

    //Arrête de jouer la note dont le numéro est en paramètre
    public void note_off(int note){
        canal.noteOff(note);
    }
    //Set le type d'instrument dont le numéro MIDI est précisé en paramètre
    public void set_instrument(int instru){
        canal.programChange(instru);
    }
}
