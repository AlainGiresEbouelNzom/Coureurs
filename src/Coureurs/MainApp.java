package Coureurs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp extends Application
{

	private int girlfriendCount = 3;
	private Label labelStatut;
	private Button addGirlFriend ;
	private Button removeGirlsFriend ;
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		labelStatut = new Label("Number of girlfriends : 3");
		
		VBox root = new VBox(45);
		root.setPadding(new Insets(20));
		
		root.setAlignment(Pos.CENTER);
		
		
		addGirlFriend = new Button("I have a new girlfriend");
		removeGirlsFriend =  new Button("I lost a grilfriend");

	
		addGirlFriend.setOnAction( new EventHandler<ActionEvent>()
		{			
			@Override
			public void handle(ActionEvent e)
			{
				girlfriendCount++;
				UpdateGirlfriends();			   			
			}
		});
		
		removeGirlsFriend.setOnAction(new EventHandler<ActionEvent>()
		{
			
			@Override
			public void handle(ActionEvent e)
			{
				if(girlfriendCount > 0)
				{
					girlfriendCount--;
				
					UpdateGirlfriends();
				}
			}
		});
		
		root.getChildren().addAll(labelStatut, addGirlFriend, removeGirlsFriend);

		Scene scene = new Scene(root,300,400);

		primaryStage.setScene(scene);

		primaryStage.show();
		primaryStage.setTitle("Coureurs De Jupons");

	}
	private void UpdateGirlfriends()
	{
		labelStatut.setText("New Number of girlfriend " + girlfriendCount);
	}

}
