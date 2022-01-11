package Coureurs;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
		
		/*Création d'object image*/
		ImageView emptyHeart =  new ImageView(getClass().getResource("/Ressources/Images/emptyHeart.png").toString());
		ImageView emptyDislike = new ImageView(getClass().getResource("/Ressources/Images/emptyDislike.png").toString());
		ImageView fullHeart =  new ImageView(getClass().getResource("/Ressources/Images/fullHeart.png").toString());
		ImageView fullDislike = new ImageView(getClass().getResource("/Ressources/Images/fullDislike.png").toString());
		
		
		
		addGirlFriend = new Button("I have a new girlfriend");
		
		/*Insertion de l'object image*/
	//	addGirlFriend.setGraphic(emptyHeart);
		
		 /*Évènement hover avec binding et Insertion de l'image avec changement de propriété*/
		addGirlFriend.graphicProperty().bind(Bindings.when(addGirlFriend.hoverProperty()).then(emptyHeart).otherwise(fullHeart));		
		
		
		/*Modification de l'emplacement de l'image*/
		addGirlFriend.setContentDisplay(ContentDisplay.TOP);
		
		
		/*Évènement hover en forme LambdaExpressions*/
	//	addGirlFriend.setOnMouseEntered(e->addGirlFriend.setGraphic(fullHeart));			
		
	//	addGirlFriend.setOnMouseExited(e ->addGirlFriend.setGraphic(emptyHeart));	
		
		
		removeGirlsFriend =  new Button("I lost a grilfriend");
		removeGirlsFriend.setGraphic(emptyDislike);
		removeGirlsFriend.setContentDisplay(ContentDisplay.TOP);
		
		/*Évènement en forme détailée(Non contractée)*/
		removeGirlsFriend.setOnMouseEntered(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				removeGirlsFriend.setGraphic(fullDislike);				
			}
		});
		

		removeGirlsFriend.setOnMouseExited(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				removeGirlsFriend.setGraphic(emptyDislike);				
			}
		});


	
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
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
