package lineFractals;

import javax.swing.*;
import java.awt.*;

class KochLine extends JPanel {

    private PVector start;
    private PVector end;

    private String type = "";

    KochLine(PVector a, PVector b, String type) {
        super();
        start = a.get();
        end = b.get();
        this.type = type;
    }

    @Override
    public void paintComponent(Graphics g) {
        Color color = Color.getHSBColor(start.x,start.y, start.x *start.y);

        if (color.equals(Color.black)) {
            color = Color.cyan;
        }

        g.setColor(color);

        Graphics2D graphics2D = (Graphics2D) g.create();
        graphics2D.drawLine((int) start.x, (int) start.y, (int) end.x, (int) end.y);
        graphics2D.scale(1000, 1000);
    }

    public PVector kochA() {
        return start.get();
    }

    public PVector kochB() {
        PVector v = PVector.sub(end, start);
        v.div(3); //splits in 3 pieces
        v.add(start); //add start to position in the right place
        return v;
    }

    public PVector kochC() {
        PVector a = start.get();

        PVector v = PVector.sub(end, start);
        v.div(3);
        a.add(v);

        double angle;

        if (type.equals("UP")) {
            angle = 60;
        } else {
            angle = -60;
        }

        v.rotate((float) -Math.toRadians(angle));
        a.add(v);
        return a;
    }

    public PVector kochD() {
        PVector v = PVector.sub(end, start);
        v.mult((float) 2 / 3); //point d is at 2/3 * segment length = 2/3 * (end - start)
        v.add(start); //position in the right place
        return v;
    }

    public PVector kochE() {
        return end.get();
    }

    public String getType() {
        return type;
    }
}