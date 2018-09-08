package Chat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.AccessController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application{
	private String UserName = null;
	private String Password = null;
	@Override
    public void start(Stage primaryStage) {
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);//将grid移至Scene的中间
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text scenetitle = new Text("Welcome");  
        scenetitle.setFont(Font.font("Times New Roman", FontWeight.BOLD,FontPosture.ITALIC,25));  
        grid.add(scenetitle, 1, 0, 2, 1); //放入的组件，第几列，第几行，跨几列,跨几行   
        Label userName = new Label("User Name:");  
        grid.add(userName, 0, 2);            
        TextField userTextField = new TextField();  //文本输入框
        grid.add(userTextField, 1, 2);
        Label pw = new Label("Password:");  
        grid.add(pw, 0, 3);  
        PasswordField pwBox = new PasswordField();  //密码输入框
        grid.add(pwBox, 1, 3);

        Button btn1 = new Button("Register");  
        HBox hbBtn1 = new HBox(10);  
        hbBtn1.setAlignment(Pos.BOTTOM_LEFT);  
        hbBtn1.getChildren().add(btn1);  
        grid.add(hbBtn1, 0, 5);
        Button btn2 = new Button("Sign in");  
        HBox hbBtn2 = new HBox(10);  
        hbBtn2.setAlignment(Pos.BOTTOM_RIGHT);  
        hbBtn2.getChildren().add(btn2);  
        grid.add(hbBtn2, 1, 5);
        
        Text actiontarget = new Text();  
        grid.add(actiontarget, 1, 6);
        btn1.setOnAction(e->{
        	this.UserName = userTextField.getText();
        	this.Password = pwBox.getText();
        	
        	File file = new File("C:\\Users\\刘雨轩\\Desktop\\Test.txt");
        	try {
				file.createNewFile();
				FileWriter writer = new FileWriter(file,true);
			    writer.write(UserName+" "+Password+"\r\n"); 
			    writer.flush();
			    writer.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        	actiontarget.setFill(Color.FIREBRICK);  
            actiontarget.setText("Register button pressed"); 
        });
        btn2.setOnAction(e->{ 
        	this.UserName = userTextField.getText();
        	this.Password = pwBox.getText();
        	actiontarget.setFill(Color.FIREBRICK);  
            actiontarget.setText("Sign in button pressed"); 
            //创建Chat对象并调用start打开舞台且关闭当前舞台
            Chat open = new Chat();
            open.start(new Stage());
            primaryStage.hide();
        });
        
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setTitle("JavaFX Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
		
	}

}
