package mandelbrotSet;

/**
 * Created by laura on 10.01.2016.
 */
public class TestClass {

    public static void main(String[] args) {
        InputData inputData = new InputData("/home/laura/IdeaProjects/VanGogu/src/main/java/mandelbrotSet/mandelbrot3.in");

        System.out.println(inputData.toString());

        new Mandelbrot(inputData).setVisible(true);
    }
}
