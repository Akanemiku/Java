package com.bnuz.javafxthread;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Chatter extends Application  {
	private ObservableList<String> items = FXCollections.observableArrayList();
	private TextField content = null ;
	private TextField topic = null ;
	private MQTT client = null ;
	//方式二：传应用
	public void addItem(String msg){
		Platform.runLater(new Runnable(){
		public void run(){
			items.add(msg);
		};
	});
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		client = new MQTT();
		PushCallback callback = new PushCallback() ;
		//方式一：传数据
		//callback.setItems(items);
		//方式二：传应用
		callback.setChatter(this);
		client.start(callback);
				
		
		GridPane pane = new GridPane() ;
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10,10,10,10));
		pane.setHgap(5);
		pane.setVgap(5);
				
		topic = new TextField();
		pane.add(new Label("Topic:"), 0, 0);
		pane.add(topic, 1, 0);
		
		ListView<String> lvLogs = new ListView<>(items);
		
		pane.add(new Label("Log:"), 0, 1);
		pane.add(lvLogs, 1, 1);
		
		content = new TextField();
		content.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// items.add(content.getText());
				try {
					client.sendMessage(MQTT.TOPIC, content.getText());
					content.clear();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
			}
		});//
			
	
		pane.add(new Label("Content:"), 0,2);
		pane.add(content, 1,2);
		
		Scene scene = new Scene(pane,600,400);
		primaryStage.setTitle("Chat together");
		primaryStage.setScene(scene);
		primaryStage.show();
		
    } 
	

	public static void main(String[] args)  {
		Application.launch(args);
	}

}
