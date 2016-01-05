package lineFractals;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


public class TestClass {
//    private static final float START_X = 100;
//    private static final float START_Y = 400;

    private static final float LENGTH = 100;

    static ArrayList<KochLine> lines;


    static HashMap<Point, ArrayList<KochLine>> snowflakeMap;

    private static void createStartingPoints(float startX, float startY) {

        float endX = startX + LENGTH;
        float endY = startY;

        //first vertice: bottom vertice : start -> end

        PVector start = new PVector(startX, startY);
        PVector end = new PVector(endX, endY);

        lines.add(new KochLine(start, end, "DOWN"));

        //second vertice: left side vertice: start -> top

        //endY is currentY + height
        float height = (float) ((Math.sqrt(3) * LENGTH)/2.0);
        System.out.println("height:" + height);
        endY = startY - height;
        endX = startX + LENGTH/2;

        PVector top = new PVector(endX, endY);
        lines.add(new KochLine(start, top, "UP"));

        //third vertice: right side

        lines.add(new KochLine(top, end, "UP"));

    }

    static void setup() {
        lines = new ArrayList<>();

        snowflakeMap = new HashMap<>();

        createStartingPoints(100, 400);
        createStartingPoints(300, 400);
        createStartingPoints(500, 400);
        createStartingPoints(100, 200);
//        createStartingPoints(100, 400);

        for (int i = 0; i < 5; i++) {
            generate();
        }
    }

    static void draw(final JFrame frame) {
        System.out.println(lines.size());
        for (final KochLine l : lines) {
            frame.add(l);
            frame.setVisible(true);
//            try {
//                SwingUtilities.invokeAndWait(new Runnable() {
//                    @Override
//                    public void run() {
//                        frame.setContentPane(l);
//                        frame.setVisible(true);
//                    }
//                });
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }

        }
    }

    static void generate() {
        ArrayList next = new ArrayList<>();
        for (KochLine l : lines) {

            PVector a = l.kochA();
            PVector b = l.kochB();
            PVector c = l.kochC();
            PVector d = l.kochD();
            PVector e = l.kochE();

            next.add(new KochLine(a, b, l.getType()));
            next.add(new KochLine(b, c, l.getType()));
            next.add(new KochLine(c, d, l.getType()));
            next.add(new KochLine(d, e, l.getType()));
        }

        lines.addAll(next);
//        THIS DOESN"T WORK BECAUSE IT"S FUCKING JAVA
//        lines = next;
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("KochLine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.black);
        frame.setVisible(true);

        long startTime = System.currentTimeMillis();
        setup();
        long endTime = System.currentTimeMillis();

        long timeConsumed = endTime - startTime;
        System.out.println("Time for setup():" + timeConsumed);

        draw(frame);
    }
}
