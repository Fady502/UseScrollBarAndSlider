//Fady Zaki SDEV200 14Feb2024
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UseScrollBarAndSlider extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label textLabel = new Label("Colorful Text");
        textLabel.setFont(new Font(24));

        Slider redSlider = new Slider(0, 1, 0.5);
        Slider greenSlider = new Slider(0, 1, 0.5);
        Slider blueSlider = new Slider(0, 1, 0.5);
        Slider opacitySlider = new Slider(0, 1, 1);


        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.addRow(0, new Label("Red:"), redSlider);
        gridPane.addRow(1, new Label("Green:"), greenSlider);
        gridPane.addRow(2, new Label("Blue:"), blueSlider);
        gridPane.addRow(3, new Label("Opacity:"), opacitySlider);
        gridPane.addRow(4, textLabel);


        redSlider.valueProperty().addListener((observable, oldValue, newValue) ->
                updateColor(textLabel, redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue(), opacitySlider.getValue()));

        greenSlider.valueProperty().addListener((observable, oldValue, newValue) ->
                updateColor(textLabel, redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue(), opacitySlider.getValue()));

        blueSlider.valueProperty().addListener((observable, oldValue, newValue) ->
                updateColor(textLabel, redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue(), opacitySlider.getValue()));

        opacitySlider.valueProperty().addListener((observable, oldValue, newValue) ->
                updateColor(textLabel, redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue(), opacitySlider.getValue()));

        Scene scene = new Scene(gridPane, 400, 200);

        primaryStage.setTitle("Use ScrollBar and Slider");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateColor(Label textLabel, double red, double green, double blue, double opacity) {
        textLabel.setTextFill(Color.rgb((int) (red * 255), (int) (green * 255), (int) (blue * 255), opacity));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
