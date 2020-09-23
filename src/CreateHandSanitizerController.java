import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateHandSanitizerController implements Initializable {

    @FXML
    private TextField brandTextField;

    @FXML
    private Spinner<Integer> volumeSpinner;

    @FXML
    private ComboBox<String> materialComboBox;

    @FXML
    private TextField alcoholTextField;

    @FXML
    void submitButtonClicked() {
        HandSanitizerBottle hs = new HandSanitizerBottle(
                                brandTextField.getText(),
                                volumeSpinner.getValue(),
                                materialComboBox.getValue(),
                                Double.parseDouble(alcoholTextField.getText()));
        System.out.println(hs.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        alcoholTextField.setPromptText("Enter Alcohol %");

        //configure the combobox
        materialComboBox.getItems().addAll("glass","plastic","metal");
        materialComboBox.setPromptText("Select a material");

        //configure the spinner
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 100, 30);
        volumeSpinner.setValueFactory(valueFactory);
        volumeSpinner.setEditable(true);

    }
}
