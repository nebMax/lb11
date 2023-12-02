package chess_game.lb_11;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.MenuBar;

import javax.net.ssl.SNIHostName;

public class ChessGame extends Application {

    private static final int BOARD_SIZE = 8;
    private static final String[] imageUrlsBlack = {
            "C:\\Users\\Max\\Desktop\\forlb11\\Chess_rdt45.svg.png",//Ладья ч
            "C:\\Users\\Max\\Desktop\\forlb11\\Chess_ndt45.svg.png",//Конь ч
            "C:\\Users\\Max\\Desktop\\forlb11\\Chess_bdt45.svg.png",//Слон ч
            "C:\\Users\\Max\\Desktop\\forlb11\\Chess_qdt45.svg.png",//Ферза ч
            "C:\\Users\\Max\\Desktop\\forlb11\\Chess_kdt45.svg.png",//Король ч
            "C:\\Users\\Max\\Desktop\\forlb11\\Chess_pdt45.svg.png", //пешка ч
    };
    private static final String[] imageUrlsWhite = {
            "C:\\Users\\Max\\Desktop\\forlb11\\Chess_rlt45.svg.png",//Ладья б
            "C:\\Users\\Max\\Desktop\\forlb11\\Chess_nlt45.svg.png",//Конь б
            "C:\\Users\\Max\\Desktop\\forlb11\\Chess_blt45.svg.png",//Слон б
            "C:\\Users\\Max\\Desktop\\forlb11\\Chess_qlt45.svg.png",//Ферза б
            "C:\\Users\\Max\\Desktop\\forlb11\\Chess_klt45.svg.png",//Король б
            "C:\\Users\\Max\\Desktop\\forlb11\\Chess_plt45.svg.png", //пешка б

    };
    private static final String[] imageUrlBackground = {
            "C:\\Users\\Max\\Desktop\\forlb11\\Снимок экрана 2023-11-30 022714.png",//
            "C:\\Users\\Max\\Desktop\\forlb11\\Снимок экрана 2023-11-30 022803.png",//
    };

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        primaryStage.setTitle("Chess Game");

        Scene scene = new Scene(root);
        HBox box = new HBox();
        VBox pane =new VBox();
        box.getChildren().addAll(initializeChessBoard(),configureScore());
        root.getChildren().addAll(configureMenu(),box);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private GridPane initializeChessBoard() {
        GridPane grid = new GridPane();
        //виводе цифри
        for (int i = 1; i < BOARD_SIZE + 1; i++) {

            Label topLabel = new Label(String.valueOf(i));
            grid.add(topLabel, 0, i);


            Label bottomLabel = new Label(String.valueOf(i));
            grid.add(bottomLabel, 9, i);
        }
        //виводе букви
        String[] letters = { "      a", "     b", "      c", "       d", "      e", "       f", "       g", "     h"};
        for (int i = 1; i < BOARD_SIZE + 1; i++) {
            Label leftLabel = new Label(letters[i - 1]);  // Corrected index
            grid.add(leftLabel, i, 0);

            Label rightLabel = new Label(letters[i - 1]);  // Corrected index
            grid.add(rightLabel, i, 9);
        }


        for (int row = 1; row < BOARD_SIZE + 1; row++) {
            for (int col = 1; col < BOARD_SIZE + 1; col++) {
                ImageView square = new ImageView();
                square.setFitWidth(50);
                square.setFitHeight(50);
                if ((row + col) % 2 == 0) {
                    square.setImage(new Image("file:" + imageUrlBackground[0]));
                } else {
                    square.setImage(new Image("file:" + imageUrlBackground[1]));
                }
                grid.add(square, col, row);
            }
        }


        for (int i=1,y=2;i<BOARD_SIZE+1;i++){
            ImageView square = new ImageView();
            square.setFitWidth(50);
            square.setFitHeight(50);
            if(i<6){
                square.setImage(new Image("file:" + imageUrlsBlack[i-1]));
            }
            else{
                square.setImage(new Image("file:" + imageUrlsBlack[y]));
                y--;
            }
            grid.add(square, i, 1);
         }

        for (int i=1;i<BOARD_SIZE+1;i++){
            ImageView square = new ImageView();
            square.setFitWidth(50);
            square.setFitHeight(50);
            square.setImage(new Image("file:" + imageUrlsBlack[5]));
            grid.add(square, i, 2);
        }

        for (int i=1;i<BOARD_SIZE+1;i++){
            ImageView square = new ImageView();
            square.setFitWidth(50);
            square.setFitHeight(50);
            square.setImage(new Image("file:" + imageUrlsWhite[5]));
            grid.add(square, i, 7);
        }

        for (int i=1,y=2;i<BOARD_SIZE+1;i++){
            ImageView square = new ImageView();
            square.setFitWidth(50);
            square.setFitHeight(50);
            if(i<6){
                square.setImage(new Image("file:" + imageUrlsWhite[i-1]));
            }
            else{
                square.setImage(new Image("file:" + imageUrlsWhite[y]));
                y--;
            }
            grid.add(square, i, 8);
        }

        return grid;
    }
    private HBox configureScore(){
        VBox rightSide = new VBox();
        VBox leftSide = new VBox();
        HBox box = new HBox();
        Label whitePlayer = myLabel("cba");
        Label blackPlayer = myLabel("abc");
        Label whiteSroce = myLabel("00:00");
        Label blackSroce = myLabel("00:00");
        rightSide.getChildren().addAll(whitePlayer,whiteSroce);
        leftSide.getChildren().addAll(blackPlayer,blackSroce);
        box.getChildren().addAll(rightSide,leftSide);
        box.setStyle("-fx-padding: 10 5 10 20;");
        return box;
    }

    private Label myLabel(String s){
        Label label = new Label(s);
        label.setStyle("-fx-padding:10;" +
                "-fx-border-width:1;" +
                "-fx-border-color:black");
        label.setAlignment(Pos.CENTER);
        return label;
    }

    private static MenuBar configureMenu() {
        MenuBar bar = new MenuBar();

        Menu file = new Menu("_File");
        Menu game = new Menu("_Game");
        Menu options = new Menu("_Options");
        Menu help = new Menu("_Help");

        bar.getMenus().addAll(file, game,options, help);

        return bar;
    }


}