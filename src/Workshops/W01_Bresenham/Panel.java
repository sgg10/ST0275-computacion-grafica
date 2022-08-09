package Workshops.W01_Bresenham;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.util.ArrayList;

public class Panel extends JPanel implements MouseListener {

    private final ArrayList<Point> points = new ArrayList<Point>();
    private Point currentPoint = null;

    Panel() {
        setPreferredSize(new Dimension(600, 500));
        setBackground(Color.WHITE);
    }

    private void plot(Graphics g, int x, int y) {
        int pixelSize = 1;
        g.setColor(Color.black);
        g.drawOval(x, y, pixelSize, pixelSize);
    }

    public void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        // delta of exact value and rounded value of the dependent variable
        int d = 0;

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int dx2 = 2 * dx; // slope scaling factors to
        int dy2 = 2 * dy; // avoid floating point

        int ix = x1 < x2 ? 1 : -1; // increment direction
        int iy = y1 < y2 ? 1 : -1;

        int x = x1;
        int y = y1;

        if (dx >= dy) {
            while (true) {
                plot(g, x, y);
                if (x == x2)
                    break;
                x += ix;
                d += dy2;
                if (d > dx) {
                    y += iy;
                    d -= dx2;
                }
            }
        } else {
            while (true) {
                plot(g, x, y);
                if (y == y2)
                    break;
                y += iy;
                d += dx2;
                if (d > dy) {
                    x += ix;
                    d -= dy2;
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < points.size(); i++){
            drawLine(
                    g,
                    points.get(i).x1,
                    points.get(i).y1,
                    points.get(i).x2,
                    points.get(i).y2
            );
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        currentPoint = new Point();
        currentPoint.x1 = e.getX();
        currentPoint.y1 = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        currentPoint.x2 = e.getX();
        currentPoint.y2 = e.getY();
        points.add(currentPoint);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}

