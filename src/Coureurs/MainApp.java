package Coureurs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp extends Application
{

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Label labelStatut = new Label("Hello World");
		Rectangle rect = new Rectangle(400, 200, Color.LIGHTBLUE);
		StackPane root = new StackPane();

		root.getChildren().add(labelStatut);
		root.getChildren().add(rect);
		
		Button addGirlFriend = new Button("I have a new girlfriend");
		

		rect.toBack();

		Scene scene = new Scene(root, 621, 500);

		primaryStage.setScene(scene);

		primaryStage.show();
		primaryStage.setTitle("Coureurs De Jupons");

	}

}
