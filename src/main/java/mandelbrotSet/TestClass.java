package mandelbrotSet;

/**
 * Created by laura on 10.01.2016.
 */
public class TestClass {

    public static void main(String[] args) {
        InputData inputData = new InputData("src/main/java/mandelbrotSet/mandelbrot3.in");

        Mandelbrot mb = new Mandelbrot(inputData);
        mb.setVisible(true);

        long startTime = System.currentTimeMillis();

        while (true){
            long currentTime = System.currentTimeMillis();
            if ( currentTime - startTime >= 60000) {
                break;
            }
            mb.reDraw();
        }

    }
}
