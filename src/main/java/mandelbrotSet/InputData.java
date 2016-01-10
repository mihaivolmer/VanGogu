package mandelbrotSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;


/**
 * Created by laura on 10.01.2016.
 */

public class InputData {

    private double xmin;
    private double xmax;
    private double ymin;
    private double ymax;
    private double resolution;
    private int steps;

    public InputData(String filename) {
        readData(filename);
    }

    private void readData(String filename) {
        Scanner scanner;

            try {
                scanner = new Scanner(new File(filename));


                xmin = scanner.nextDouble();
                xmax = scanner.nextDouble();
                ymin = scanner.nextDouble();
                ymax = scanner.nextDouble();

                resolution = scanner.nextDouble();
                steps = scanner.nextInt();

            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
    }

    public double getXmin() {
        return xmin;
    }

    public double getXmax() {
        return xmax;
    }

    public double getYmin() {
        return ymin;
    }

    public double getYmax() {
        return ymax;
    }

    public double getResolution() {
        return resolution;
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return "InputData{" +
                "xmin=" + xmin +
                ", xmax=" + xmax +
                ", ymin=" + ymin +
                ", ymax=" + ymax +
                ", resolution=" + resolution +
                ", steps=" + steps +
                '}';
    }
}
