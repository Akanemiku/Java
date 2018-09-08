package Chat;

import java.awt.ScrollPane;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Chat extends Application{
	
	private ObservableList<String> items = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage){
		
		HBox root = new HBox();
		
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(7);
		pane.setVgap(7);
		pane.setPadding(new Insets(10, 10, 10, 10));		
		    
		TextField topicTextField = new TextField();
		Label topic = new Label("Topic:");
		pane.add(topic,0,0);
		pane.add(topicTextField, 1, 0);
		
		ListView<String> lvLogs = new ListView<>(items);
		Label logs = new Label("Log:");
		pane.add(logs,0,1);
		pane.add(lvLogs,1,1);
		
		TextField content = new TextField();
		content.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				items.add(content.getText());
				content.clear();
			}
		});
		pane.add(new Label("Content:"),0,2);
		pane.add(content,1,2);
		
		BorderPane Bpane = new BorderPane();
		MenuBar menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	    Bpane.setTop(menuBar);
	    
	    Menu fileMenu = new Menu("File");
	    MenuItem newMenuItem = new MenuItem("New");
	    newMenuItem.setOnAction(e->{
	    	Chat a = new Chat();
	    	a.start(new Stage());
	    });
	    MenuItem exitMenuItem = new MenuItem("Exit");
	    exitMenuItem.setOnAction(e-> Platform.exit());
	    fileMenu.getItems().addAll(newMenuItem, new SeparatorMenuItem(), exitMenuItem);
	    menuBar.getMenus().addAll(fileMenu);
	    
	    Bpane.setBottom(pane);
	    
		Scene scene = new Scene(Bpane);
		primaryStage.setTitle("Chat Together");
		primaryStage.setScene(scene); 
        primaryStage.setResizable(false);  
		primaryStage.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}
}
