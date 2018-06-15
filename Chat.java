import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
public class Chat extends Application{
	
	private ObservableList<String> items = FXCollections.observableArray
	private TextField content = null;
	private TextField topic = null;
	
	@Override
	public void start(Stage primaryStage){
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(5);
		pane.setVgap(5);
		
		topic = new TextField();
		pane.add(new Label("Topic:"),0,0);
		
		ListView<String> lvLogs = new ListView<>(items);
		pane.add(new Label("Log:"),0,1);
		pane.add(lvLogs,1,1);
		
		content = new TextField();
		content.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				items.add(content.getText());
				content.clear();
			}
		});
		pane.add(new Label("Content:"),0,2);
		pane.add(content,1,2);
		
		Scene scene = new Scene(pane,600,400);
		primaryStage.setTitle("Chat Together");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}