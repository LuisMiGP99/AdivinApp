package dad.AdivinApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application{
		private Label label;
		private Button button;
		private TextField nombreText;
		private int intentos;
		int random=(int)(Math.random()*100);
		int num=0;

		public void start(Stage primaryStage) throws Exception {
			
			label= new Label("Introduce un número del 1 al 100");
			
			nombreText= new TextField();
			nombreText.setPrefColumnCount(5);
			nombreText.setPromptText("Introduce el numero aquí");
			
			button= new Button("Comprobar");
			button.setDefaultButton(true);
			button.setOnAction(e -> onSaluoButtonAction(e));
			
			VBox root = new VBox();
			root.setSpacing(5);
			root.setAlignment(Pos.CENTER);
			root.getChildren().addAll(label,nombreText,button);
			
			Scene scene = new Scene(root,320,200);
			
			primaryStage.setTitle("AdivinApp");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		}
		private void onSaluoButtonAction(ActionEvent e) {
			
			Alert alertError = new Alert(AlertType.ERROR);
			alertError.setTitle("AdivinApp");
			alertError.setHeaderText("Error");
			alertError.setContentText("El número introducido no es valido");
		    
			String numero =nombreText.getText();
			try {
				num=Integer.parseInt(numero);
			} catch (NumberFormatException excp) {
				alertError.showAndWait();
			}
			
			//Alertas
			Alert alertInfo = new Alert(AlertType.INFORMATION);
			alertInfo.setTitle("AdivinApp");
			alertInfo.setHeaderText("¡Has ganado!");
			alertInfo.setContentText(" Solo has necesitado "+intentos+" intentos. \n Vuelve a jugar y hazlo mejor.");
			
			Alert alertWarning1 = new Alert(AlertType.WARNING);
			alertWarning1.setTitle("AdivinApp");
			alertWarning1.setHeaderText("¡Has fallado!");
			alertWarning1.setContentText(" El número a adivinar es mayor que "+num+"\n Vuelve a intentarlo.");
			
			Alert alertWarning2 = new Alert(AlertType.WARNING);
			alertWarning2.setTitle("AdivinApp");
			alertWarning2.setHeaderText("¡Has fallado!");
			alertWarning2.setContentText(" El número a adivinar es menor que "+num+"\n Vuelve a intentarlo.");
			
				
			if(num>100 || num<0) {
				alertError.showAndWait();
			}else {
				if(num==random) {
					intentos++;
					alertInfo.showAndWait();
				}else if(num<random) {
					intentos++;
					alertWarning1.showAndWait();
				}else {
					intentos++;
					alertWarning2.showAndWait();
				}
			}
		}
			
		public static void main(String[] args) {
			launch(args);
		}
}
