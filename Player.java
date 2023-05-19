import java.awt.*;
import javax.swing.*;

public class Player extends JPanel{
    private final int size = 8;
    public boolean up, down, left, right;
    public boolean lookLeft, lookRight;
    public boolean interact;
    private double deltaX, deltaY, angle = 0;

    public Player(Point pos)
    {
        setBounds(pos.x, pos.y, size, size);
        setVisible(false);
        setBackground(Color.yellow);      
    }
    public double getDeltaX() { return deltaX; }
    public double getDeltaY() { return deltaY; }
    public void setAngle(double theta) 
    { 
        angle = theta; 
        if (angle > Math.PI * 2) angle -= Math.PI*2;
        else if (angle < 0) angle += Math.PI*2;
    }
    public double getAngle() { return angle; }       
}