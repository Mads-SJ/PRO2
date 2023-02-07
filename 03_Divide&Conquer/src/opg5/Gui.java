package opg5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Gui extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    private Pane pane;

    @Override
    public void start(Stage stage)
    {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Sierpinski Curve");
        stage.setScene(scene);
        stage.show();
    }


    private Pane initContent()
    {
        Pane pane = new Pane();
        this.pane = pane;
        pane.setPrefSize(400, 400);
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane)
    {
        sierpinski(4, 50, 350, 300);
    }

    private void sierpinski(int n, double x, double y, double size) {
        if (n == 0) {
            drawTriangle(x, y, x + size / 2, y - size, x + size, y);
        } else {
            sierpinski(n - 1, x, y, size / 2);
            sierpinski(n - 1,x + size / 4, y - size + size / 2, size / 2);
            sierpinski(n - 1, x + size / 2, y, size / 2);
        }
    }

    private void drawTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        Polygon triangle = new Polygon(x1, y1, x2, y2, x3, y3);
        triangle.setStroke(Color.BLACK);
        triangle.setFill(Color.TRANSPARENT);
        pane.getChildren().add(triangle);
    }
}
