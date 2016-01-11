package mandelbrotSet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by laura on 10.01.2016.
 */
public class Mandelbrot extends JFrame {

    private InputData inputData;
    private BufferedImage bufferedImage;

    private double xMin;
    private double xMax;
    private double yMin;
    private double yMax;
    private double resolution;
    private int steps;
    private int height;
    private int width;

    private int color;
    private Random random;
    private int angle_rot;

    private static final float[] randomColorVector = {0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f,
            1.0f, 1.3f, 1.4f, 1.9f, 2.4f, 2.9f, 3.7f, 4.0f, 4.5f};
    //private static final float[] randomColorVector = {0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f,
    //       1.0f};
    private static final int randomRotAngles = 36;

    public Mandelbrot(InputData inputData) {
        super("Mandelbrot Set");
        random = new Random();

        this.inputData = inputData;
        extractInputData();

        setBounds(50, 0, width, height);
//        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        color = getColor();
        generateImage();
        angle_rot = random.nextInt(randomRotAngles);
    }

    private void extractInputData() {
        this.xMin = inputData.getXmin();
        this.xMax = inputData.getXmax();
        this.yMin = inputData.getYmin();
        this.yMax = inputData.getYmax();
        this.resolution = inputData.getResolution();
        this.steps = inputData.getSteps();

        this.width = (int) Math.floor(Math.abs((xMax - xMin) / resolution));
        this.height = (int) Math.floor(Math.abs((yMax - yMin) / resolution));

    }

    private void generateImage() {


        double x, y, re, im, newRe, newIm;
        int i, j, currentStep;

        for (i = 0; i < height; i++) {
            y = yMin + i * resolution;

            for (j = 0; j < width; j++) {
                re = 0;
                im = 0;
                currentStep = 0;

                x = xMin + j * resolution;

                while (re * re + im * im < 4 && currentStep < steps) {

                    newRe = re * re - im * im + x;
                    newIm = 2 * re * im + y;
                    re = newRe;
                    im = newIm;
                    currentStep++;

                }
                bufferedImage.setRGB(i, j, color * currentStep);
            }
        }
    }

    private int getColor() {
        //This needs to be done for a better coloring of the image : SMOOTH COLORING ALGORITHM
        double zMaxAbsValue = Math.sqrt(Math.pow(xMax, 2) + Math.pow(yMax, 2));

        double smoothcolor = height + 1 - Math.log(Math.log(Math.abs(zMaxAbsValue))) / Math.log(2);

        int colorVectorSize = randomColorVector.length;
        float hue = randomColorVector[random.nextInt(colorVectorSize)];
        float saturation = randomColorVector[random.nextInt(colorVectorSize)];
        float brightness = randomColorVector[random.nextInt(colorVectorSize)];

        System.out.println(hue);
        System.out.println(saturation);
        System.out.println(brightness);

        return Color.HSBtoRGB(hue + 10 * (float) smoothcolor, saturation, brightness);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.translate(bufferedImage.getHeight() / 2, bufferedImage.getWidth() / 2);
        graphics2D.rotate(Math.toRadians(angle_rot * 10));
        graphics2D.scale(1.5, 1.5);
        graphics2D.translate(-bufferedImage.getHeight() / 2, -bufferedImage.getWidth() / 2);
        angle_rot++;
        if(angle_rot >= randomRotAngles) {
            angle_rot = 0;
        }

        graphics2D.drawImage(bufferedImage, 0, 0, this);

    }

    public void reDraw() {
        //color = getColor();
        generateImage();
        revalidate();
        repaint();
    }
}
