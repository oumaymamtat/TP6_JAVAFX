package melordi;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Touche extends Parent {
    
    public String lettre = new String("X");
    private int positionX = 0;
    private int positionY = 0;
    private int note = 0;    
    private final Instru instru;//on déclare un objet de type Instru
    Rectangle fond_touche = new Rectangle(75,75,Color.WHITE);
    Text lettre_touche ;
    
    public Touche(String l, int posX, int posY, int n,  Instru ins){
        lettre = l;
        positionX = posX;
        positionY = posY;
        note = n;
        instru = ins;
        fond_touche.setArcHeight(10);
        fond_touche.setArcWidth(10);
        this.getChildren().add(fond_touche);
        lettre_touche = new Text(lettre);
        lettre_touche.setFont(new Font(25));
        lettre_touche.setFill(Color.GREY);
        lettre_touche.setX(25);
        lettre_touche.setY(45);
        this.getChildren().add(lettre_touche);
        this.setTranslateX(positionX);
        this.setTranslateY(positionY);
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent me){
                fond_touche.setFill(Color.LIGHTGREY);
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent me){
                fond_touche.setFill(Color.WHITE);
            }
        });
        this.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent me){
                appuyer();
            }
        });
        this.setOnMouseReleased(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent me){
                relacher();
            }
        });
    }
    public void appuyer(){
        fond_touche.setFill(Color.DARKGREY);
        this.setTranslateY(positionY+2);
        instru.note_on(note);
    }
    
    public void relacher(){
        fond_touche.setFill(Color.WHITE);
        this.setTranslateY(positionY);
        instru.note_off(note);
    }
    

    
}



