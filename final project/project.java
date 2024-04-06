import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class project extends Application {
    
    private double iX, iY, eX, eY;
    private GraphicsContext graphicsContext;
    
    @Override
    public void start(Stage primaryStage) {
               
        BorderPane bPane = new BorderPane();
        Canvas canvas = new Canvas(800, 600);
        graphicsContext = canvas.getGraphicsContext2D();
        
        canvas.setOnMousePressed(e -> {
            iX = e.getX();
            iY = e.getY();
        });
        
        canvas.setOnMouseDragged(e -> {
            eX = e.getX();
            eY = e.getY();
            draw();
            iX = eX;
            iY = eY;
        });
        
        bPane.setCenter(canvas);
        primaryStage.setScene(new Scene(bPane, 1000, 800));
        primaryStage.setTitle("Drawing Program");
        primaryStage.show();
    }
    
    private void draw() {
        int r = 0;
        int g = 0;
        int b = 0;
        
        graphicsContext.setStroke(Color.rgb(r, g, b));
        graphicsContext.setLineWidth(1);
        graphicsContext.strokeLine(iX, iY, eX, eY);
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}