package com.cosenza;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import com.oanda.v20.Context;
import com.oanda.v20.account.AccountID;
import com.oanda.v20.account.AccountSummary;

import java.io.IOException;

import static com.cosenza.utils.constants.*;


public class main extends Application
{

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException
    {
        stage.setTitle(WINDOW_NAME);
        Label label = new Label("Hello World!");
        label.setFont(Font.font("Serif", FontWeight.NORMAL, 20));



        StackPane root = new StackPane();
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        root.getChildren().add(label);

        stage.setScene(scene);
        stage.show();


    }

    static void setRoot(String fxml) throws IOException
    {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args)
    {

        Context ctx = new Context(
                "https://api-fxpractice.oanda.com",
                "f508663a3098c2b27f3087a0d9e921e2-266fe6172c4446a0dafb662a713dead9");

        try {
            AccountSummary summary = ctx.account.summary(
                    new AccountID("101-001-10809598-005")).getAccount();
            System.out.println(summary);
        } catch (Exception e) {
            e.printStackTrace();
        }

        launch();


    }

}