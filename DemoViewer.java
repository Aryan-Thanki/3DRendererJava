import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class DemoViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container pane =  frame.getContentPane();
        pane.setLayout(new BorderLayout());

        //slider to control horizontal rotation
        JSlider headingSlider = new JSlider(0, 360, 180);
        pane.add(headingSlider, BorderLayout.SOUTH);

        //slider to control vertical rotation
        JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
        pane.add(pitchSlider, BorderLayout.EAST);

        //panel to display render results
        JPanel renderPanel = new JPanel(){
            public void paintComponent(Graphics g){
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK); 
                g2.fillRect(0, 0, getWidth(), getHeight());

                //rendering magic will happen here
                List<Triangle> tris = new ArrayList<>();
                tris.add(new Triangle(new Vertex(100, 100, 100), 
                                        new Vertex(-100, -100, 100),
                                        new Vertex(-100, 100, -100),
                                        Color.WHITE));
            }

        };
        pane.add(renderPanel, BorderLayout.CENTER);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}

class Vertex{
    double x;
    double y;
    double z;
    Vertex(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Triangle{
    Vertex v1;
    Vertex v2;
    Vertex v3;
    Color color;
    Triangle(Vertex v1, Vertex v2, Vertex v3, Color color){
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.color = color;
    }
}


