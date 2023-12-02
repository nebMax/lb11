module com.example.lb_11 {
    exports Calculator;
    requires javafx.controls;
    requires javafx.fxml;


    opens chess_game.lb_11 to javafx.fxml;
    exports chess_game.lb_11;
}