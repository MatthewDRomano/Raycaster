import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Gui{
    static JFrame gui;
    static int fps = 60;
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static void main(String[] args)
    {        
        JPanel screen = makeGui();
        Player p = new Player(new Point(200,300));   
        Map m = new Map(512, p);//gets divided by 8

        

        screen.add(p);
        m.setBounds(0,0, (int)screenSize.getWidth(), (int)screenSize.getHeight());
        screen.add(m);

        gui.addKeyListener(new KeyListenerMod(p, m));
        gui.setVisible(true);

        ActionListener taskPerformer = new ActionListener() //trig may be wrong
        {
            int[][] map = m.getMap();
            public void actionPerformed(ActionEvent evt) 
            {

                if (p.lookLeft) p.setAngle(p.getAngle()+Math.toRadians(fps/15));
                if (p.lookRight) p.setAngle(p.getAngle()-Math.toRadians(fps/15));
                //collisions below
                double pdx = Math.cos(p.getAngle()), pdy = Math.sin(p.getAngle());
                int xo = 0; if (pdx < 0) xo = -25; else xo = 25;
                int yo = 0; if (pdy < 0) yo = -25; else yo = 25;
                int ipx = (p.getLocation().x + p.getWidth()/2)/64, ipx_add_xo = ((p.getLocation().x + p.getWidth()/2) + xo)/64, ipx_sub_xo = ((p.getLocation().x + p.getWidth()/2) - xo)/64;
                int ipy = (p.getLocation().y + p.getHeight()/2)/64, ipy_add_yo = ((p.getLocation().y + p.getHeight()/2) + yo)/64, ipy_sub_yo = ((p.getLocation().y + p.getHeight()/2) - yo)/64;
    
                if (p.up) 
                //p.setLocation(p.getLocation().x + (int)(5*Math.cos(p.getAngle())), p.getLocation().y + (int)(5*Math.sin(p.getAngle())));   
                {
                    if (map[ipy][ipx_add_xo] == 0) p.setLocation(p.getLocation().x + (int)Math.round(((5)*Math.cos(p.getAngle()))), p.getLocation().y);  
                    if (map[ipy_add_yo][ipx] == 0) p.setLocation(p.getLocation().x, p.getLocation().y + (int)Math.round((5*Math.sin(p.getAngle())))); 
                }
                
                if (p.down) 
                //p.setLocation(p.getLocation().x - (int)(5*Math.cos(p.getAngle())), p.getLocation().y - (int)(5*Math.sin(p.getAngle())));   
                {
                    if (map[ipy][ipx_sub_xo] == 0) p.setLocation(p.getLocation().x - (int)Math.round(((5)*Math.cos(p.getAngle()))), p.getLocation().y);  
                    if (map[ipy_sub_yo][ipx] == 0) p.setLocation(p.getLocation().x, p.getLocation().y - (int)Math.round((5*Math.sin(p.getAngle()))));  
                }

                if (p.interact && map[ipy_add_yo][ipx_add_xo] == 2) map[ipy_add_yo][ipx_add_xo] = 0;//opening doors

                 pdx = Math.cos(p.getAngle() + Math.PI/2); pdy = Math.sin(p.getAngle() + Math.PI/2);
                 xo = 0; if (pdx < 0) xo = -25; else xo = 25;
                 yo = 0; if (pdy < 0) yo = -25; else yo = 25;
                 ipx = (p.getLocation().x + p.getWidth()/2)/64; ipx_add_xo = ((p.getLocation().x + p.getWidth()/2) + xo)/64; ipx_sub_xo = ((p.getLocation().x + p.getWidth()/2) - xo)/64;
                 ipy = (p.getLocation().y + p.getHeight()/2)/64; ipy_add_yo = ((p.getLocation().y + p.getHeight()/2) + yo)/64; ipy_sub_yo = ((p.getLocation().y + p.getHeight()/2) - yo)/64;

                if (p.left) 
                {
                    if (map[ipy][ipx_add_xo] == 0) p.setLocation(p.getLocation().x + (int)(5*Math.cos(p.getAngle() + (Math.PI/2))), p.getLocation().y); 
                    if (map[ipy_add_yo][ipx] == 0) p.setLocation(p.getLocation().x, p.getLocation().y + (int)Math.round(5*Math.sin(p.getAngle() + (Math.PI/2)))); 
                }                 
                if (p.right)
                {
                    if (map[ipy][ipx_sub_xo] == 0) p.setLocation(p.getLocation().x - (int)(5*Math.cos(p.getAngle() + (Math.PI/2))), p.getLocation().y);  
                    if (map[ipy_sub_yo][ipx] == 0)p.setLocation(p.getLocation().x, p.getLocation().y - (int)Math.round(5*Math.sin(p.getAngle() + (Math.PI/2))));  
                }          
                m.repaint();
                p.repaint();
                p.interact = false;
            }
        };

        Timer timer = new Timer(1000/fps ,taskPerformer);//1 second / fps = delay
        timer.start();    

    }
    public static JPanel makeGui()
    {
        gui = new JFrame()
        {
            {
                setSize(new Dimension((int)screenSize.getWidth(), (int)screenSize.getHeight()));
                setTitle("Raycaster");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        };
        return new JPanel()
        {
            {
                setLayout(null);
                setBackground(Color.darkGray);     
                gui.add(this);              
            }
        };
    }
}