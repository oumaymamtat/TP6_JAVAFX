package melordi;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Melordi extends Application {

    public static void main(String[] args) {
        Application.launch(Melordi.class, args);
        
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Clavier Musical");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.BLUE);
        
        
         Instru mon_instru = new Instru();
         ChangeInstru mon_changeinstru = new ChangeInstru(mon_instru);//on créé notre nouvel objet
        root.getChildren().add(mon_changeinstru);
         
        Clavier mon_clavier = new Clavier(mon_instru);//on créé un objet clavier
        root.getChildren().add(mon_clavier);//on l'ajoute à notre groupe root
        mon_clavier.requestFocus();

        Son mon_son = new Son(mon_clavier);//on créer notre nouvel objet
        mon_instru.volume.bind(mon_son.slider.valueProperty());//on lie les deux paramètres
        root.getChildren().add(mon_son);//on l'ajoute à la scène
        
        primaryStage.setScene(scene);
       primaryStage.show();
    }
}
