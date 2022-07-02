package melordi;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;

public class Son extends Parent {
     public Slider slider; //objet graphique ascenceur
      private Clavier clavier;//création d'un objet de type Clavier
    public Son(Clavier clv){
        clavier = clv;
        //objet graphique ascenceur
        slider = new Slider(0, 127, 10);
        slider.setOrientation(Orientation.VERTICAL);
        slider.setTranslateY(35);
        
         slider.valueProperty().addListener(new ChangeListener(){
            @Override public void changed(ObservableValue o, Object oldVal, Object newVal){
                //rendre le focus au clavier
                
                 clavier.requestFocus();
            }
        });
        
        //un objet ProgressIndicator qui indique
        //le pourcentage du slider (0 = 0% et 127 = 100%) :
        ProgressIndicator indicateur = new ProgressIndicator(0.0);
        
        //Pour que la valeur de l'objet ProgressIndicator varie
        //en même temps que celle du slider, il faudrait lier 
        //la propriété indicateur.progressProperty() de l'indicateur 
        //(propriété esclave) avec la propriété slider.valueProperty()
        //du slider divisée par 127 
         //lier la propriété progressProperty de type DoubleProperty
         //à la propriété valueProperty de type DoubleProperty 
         //en divisant cette valeur par 127 grâce à la fonction divide().
        indicateur.progressProperty().bind(slider.valueProperty().divide(127.0));
        
        this.getChildren().add(slider);
        this.getChildren().add(indicateur);
        this.setTranslateY(260);
        this.setTranslateX(60);
    }

}
