package Calculator;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class EngineeringCalc {

    public static void openWindow(Stage primaryStage){
        Stage newStage = new Stage();
        VBox newRoot = new VBox();
        newRoot.setStyle("-fx-background-color: #EDF0F2");

        Scene newScene = new Scene(newRoot);

        // Добавляем меню
        newRoot.getChildren().add(Calc.configureMenu(primaryStage));

        // Получаем HBox с текстовым полем внутри
        HBox box = Calc.configureResultView();
        // Добавляем HBox в root-вершину
        newRoot.getChildren().add(box);
        // Устанавливаем отступы для HBox
        VBox.setMargin(box, new Insets(20, 10, 2, 10));

        newRoot.getChildren().add(EngineeringCalc.configureButtons());

        newStage.setTitle("My calc");
        newStage.setResizable(false);
        newStage.setScene(newScene);
        newStage.show();
        primaryStage.hide();
    }
    private static GridPane configureButtons() {
        GridPane pane = new GridPane();

        // 1ый ряд
        HBox box = new HBox();
        RadioButton grd =new RadioButton("Градусы");
        RadioButton rd =new RadioButton("Радианы");
        RadioButton gr =new RadioButton("Грады");
        ToggleGroup group = new ToggleGroup();
        grd.setToggleGroup(group);
        rd.setToggleGroup(group);
        gr.setToggleGroup(group);
        box.getChildren().addAll(grd,rd,gr);
        pane.add(box,0,0,5,1);
        pane.add(new Calc.MyButton("MC"), 5, 0);
        pane.add(new Calc.MyButton("MR"), 6, 0);
        pane.add(new Calc.MyButton("MS"), 7, 0);
        pane.add(new Calc.MyButton("M+"), 8, 0);
        pane.add(new Calc.MyButton("M-"), 9, 0);

        // 2ой ряд
        pane.add(new Calc.MyButton(""), 0, 1);
        pane.add(new Calc.MyButton("Inv"), 1, 1);
        pane.add(new Calc.MyButton("ln"),  2, 1);
        pane.add(new Calc.MyButton("("),  3, 1);
        pane.add(new Calc.MyButton(")"),  4, 1);
        pane.add(new Calc.MyButton("<-"), 5, 1);
        pane.add(new Calc.MyButton("CE"), 6, 1);
        pane.add(new Calc.MyButton("C"),  7, 1);
        pane.add(new Calc.MyButton("±"),  8, 1);
        pane.add(new Calc.MyButton("√"),  9, 1);

        // 3ий ряд
        pane.add(new Calc.MyButton("Int"), 0, 2);
        pane.add(new Calc.MyButton("sinh"), 1, 2);
        pane.add(new Calc.MyButton("sin"),  2, 2);
        pane.add(new Calc.MyButton("x²"),  3, 2);
        pane.add(new Calc.MyButton("n!"),  4, 2);
        pane.add(new Calc.MyButton("7"), 5, 2);
        pane.add(new Calc.MyButton("8"), 6, 2);
        pane.add(new Calc.MyButton("9"), 7, 2);
        pane.add(new Calc.MyButton("/"), 8, 2);
        pane.add(new Calc.MyButton("%"), 9, 2);

        // 4ый ряд
        pane.add(new Calc.MyButton("dms"), 0, 3);
        pane.add(new Calc.MyButton("cosh"), 1, 3);
        pane.add(new Calc.MyButton("cos"),  2, 3);
        pane.add(new Calc.MyButton("xʸ"),  3, 3);
        pane.add(new Calc.MyButton("ʸ√x"),  4, 3);
        pane.add(new Calc.MyButton("4"),  5, 3);
        pane.add(new Calc.MyButton("5"),  6, 3);
        pane.add(new Calc.MyButton("6"),  7, 3);
        pane.add(new Calc.MyButton("*"),  8, 3);
        pane.add(new Calc.MyButton("1/х"),9, 3);

        // 5ый ряд
        pane.add(new Calc.MyButton("π"), 0, 4);
        pane.add(new Calc.MyButton("tahh"), 1, 4);
        pane.add(new Calc.MyButton("tan"),  2, 4);
        pane.add(new Calc.MyButton("x³"),  3, 4);
        pane.add(new Calc.MyButton("³√x"),  4, 4);
        pane.add(new Calc.MyButton("1"), 5, 4);
        pane.add(new Calc.MyButton("2"), 6, 4);
        pane.add(new Calc.MyButton("3"), 7, 4);
        pane.add(new Calc.MyButton("-"), 8, 4);
        pane.add(new Calc.MyButton("="), 9, 4, 1, 2);

        // 6ой ряд
        pane.add(new Calc.MyButton("F-E"), 0, 5);
        pane.add(new Calc.MyButton("Exp"), 1, 5);
        pane.add(new Calc.MyButton("Mod"),  2, 5);
        pane.add(new Calc.MyButton("log"),  3, 5);
        pane.add(new Calc.MyButton("10ˣ"),  4, 5);
        pane.add(new Calc.MyButton("0"), 5, 5, 2, 1);
        pane.add(new Calc.MyButton(","), 7, 5);
        pane.add(new Calc.MyButton("+"), 8, 5);

        // Свойства колонок
        ColumnConstraints cc = new ColumnConstraints();
        cc.setFillWidth(true);
        cc.setHgrow(Priority.ALWAYS);
        pane.getColumnConstraints().addAll(cc,cc,cc,cc,cc);

        pane.setStyle("-fx-padding: 2 10 4 10");
        pane.setHgap(6);
        pane.setVgap(6);
        return pane;
    }
}