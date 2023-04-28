module tercerparcial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;

    opens tercerparcial to javafx.fxml;
    exports tercerparcial;
}
