package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField output;
    private Model operation = new Model();
    private String operator = "";
    private long num = 0;

    public void controllerNumbers(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    public void controllerOperations(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (output.getText().isEmpty()) {
            return;
        }
        if (!"=".equals(value)) {
            operator = value;
            num = Long.parseLong(output.getText());
            output.setText("");
        } else {
            output.setText(String.valueOf(operation.calculation(num, Long.parseLong(output.getText()), operator)));
            operator = "";
        }
    }
}
