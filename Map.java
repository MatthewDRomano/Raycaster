import java.awt.*;
import javax.swing.*;

public class Map extends JPanel {    
    private boolean resizer = false;
    private Player player;
    private int cubeSize; //pixels
    private boolean mapView = false;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int[][] mapW = new int[][]
    {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    private int[][] floor = new int[][]
    {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    private int[] texture = new int[]
    {
        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,
        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,
        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,
        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,
        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,
        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,
        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,
        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,


        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,



        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,
        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,
        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,
        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,
        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,
        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,
        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,
        0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,



        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,
        1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0,    1, 1, 1, 1, 1, 1, 1, 1,    0, 0, 0, 0, 0, 0, 0, 0, 



        1, 1, 1, 1, 1, 1, 1, 1,    1, 1, 1, 1, 1, 1, 1, 1,    1, 1, 1, 1, 1, 1, 1, 1,    1, 1, 1, 1, 1, 1, 1, 1,
        1, 1, 1, 1, 1, 1, 1, 1,    1, 1, 1, 1, 1, 1, 1, 1,    1, 1, 1, 1, 1, 1, 1, 1,    1, 1, 1, 1, 1, 1, 1, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,


        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 1, 1, 0, 1, 0,    0, 1, 0, 1, 1, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,



        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 1, 1, 0, 1, 0,    0, 1, 0, 1, 1, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 1, 1, 0, 1, 0,    0, 1, 0, 1, 1, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 1, 1, 0, 1, 0,    0, 1, 0, 1, 1, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,



        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 1, 0,    0, 1, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1,
        1, 0, 1, 1, 1, 1, 1, 1,    1, 1, 1, 1, 1, 1, 1, 0,    0, 1, 1, 1, 1, 1, 1, 1,    1, 1, 1, 1, 1, 1, 0, 1,
        1, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 1
               
    };

    public Map(int size, Player p)
    {
        player = p;
        //add(player);
        setBackground(Color.darkGray);
        cubeSize = size / 8;
    }

    public int returnSize() { return cubeSize * 8; }
    public int[][] getMap() { return mapW; }
    public void changeView() 
    { 
        mapView = !mapView; 
        if (mapView) {  player.setVisible(true); }
        else if (!mapView) {  player.setVisible(false); }
    } 

    public void paintComponent(Graphics g)
    {       
        //screenSize = getParent().getSize();
        //screenSize.setSize(screenSize.getWidth(), (9*screenSize.getWidth())/16);//keeps 16:9 aspect ratio
        //screenSize.setSize((screenSize.getHeight()*16)/9, screenSize.getHeight());//keeps 16:9 aspect ratio
        int mapVal = 0;
        super.paintComponent(g);
        if (mapView)
            for (int i = 0; i < mapW.length; i++)
                for (int q = 0; q < mapW[i].length; q++)
                {      
                    if (mapW[i][q] == 1) g.setColor(Color.white);
                    else g.setColor(Color.black);
                    if (mapW[i][q] == 2) g.setColor(Color.green);
                    g.fillRect(q*cubeSize+1, i*cubeSize+1, cubeSize-1, cubeSize-1);                
                }
         
            double ra; int r;
            int mx, my, dof; double rx = 0, ry = 0, xo = 0, yo = 0;  
            ra = player.getAngle() + Math.PI/6; if (ra < 0) {ra += (Math.PI * 2);} if (ra > Math.PI * 2) {ra -= (Math.PI * 2);}

            
            for (r = 0; r < 120; r++)
            {      
                g.setColor(new Color(188,5,5));                      
                //---Check Horizontal---
                dof = 0;
                double aTan = (-1/Math.tan(ra));
                if (ra == Math.PI/2 || ra == Math.PI*3/2) { ra += Math.toRadians(0.1); }//left right
                if (ra > Math.PI) { ry = (((int)(player.getY() + player.getHeight()/2)>>6)<<6)-0.0001; rx = (player.getY() + (player.getHeight()/2) -ry) * aTan+(player.getX() + player.getWidth()/2); yo = -64; xo= -yo*aTan; }//up
                if (ra < Math.PI) { ry = (((int)(player.getY() + player.getHeight()/2)>>6)<<6)+64;     rx = (player.getY() + (player.getHeight()/2) -ry) * aTan+(player.getX() + player.getWidth()/2); yo = 64; xo = -yo*aTan; }//down
                
                while (dof < 15)
                {
                    mx = (int)(rx)>>6; my = (int) (ry)>>6; 
                    if (mx < 15 && my < 15 && my >= 0 && mx >= 0 && mapW[my][mx] > 0) {mapVal = mapW[my][mx]; dof = 15; }//8 = size/dubeSize
                    else {rx += xo; ry += yo; dof++; }
                }                

                double distance1 = calcDistance(player.getX() + player.getWidth()/2, player.getY() + player.getHeight()/2, rx, ry);
                Point sRay = new Point((int)rx, (int)ry);
                
                //---Check Vertical---
                dof = 0;
                double nTan = -Math.tan(ra);
                if (ra == 0 || ra == Math.PI) { ra += Math.toRadians(0.1); }//up down (return to original)?
                if (ra > Math.PI/2 && ra < Math.PI*3/2) { rx = (((int)(player.getX() + player.getWidth()/2)>>6)<<6)-0.0001; ry = (player.getX() + (player.getWidth()/2) -rx) * nTan+(player.getY() + player.getHeight()/2); xo = -64; yo= -xo*nTan; }//left 
                if (ra < Math.PI/2 || ra > Math.PI*3/2) { rx = (((int)(player.getX() + player.getWidth()/2)>>6)<<6)+64;     ry = (player.getX() + (player.getWidth()/2) -rx) * nTan+(player.getY() + player.getHeight()/2); xo = 64; yo = -xo*nTan; }//right
                
                
                while (dof < 15)
                {
                    mx = (int)(rx)>>6; my = (int) (ry)>>6; 
                    if (mx < 15 && my < 15 && my >= 0 && mx >= 0 && mapW[my][mx] > 0) { dof = 15; }
                    else {rx += xo; ry += yo; dof++; }
                }                
                double distance2 = calcDistance(player.getX() + player.getWidth()/2, player.getY() + player.getHeight()/2, rx, ry);
                if (distance2 < distance1) {mapVal = mapW[(int)(ry)>>6][(int)(rx)>>6]; sRay = new Point((int)rx, (int)ry); g.setColor(new Color(255,0,0)); }
                //--- Draw Rays---
                
                if (mapView) {
                    g.drawLine(player.getX() + player.getWidth()/2, player.getY() + player.getHeight()/2, (int)sRay.x, (int)sRay.y);
                    ra -= Math.toRadians(0.5); if (ra < 0) {ra+= Math.PI * 2;} if (ra > Math.PI * 2) {ra -= Math.PI * 2;}
                    continue;
                }
                //---Draw 3D walls---
                double ca = player.getAngle()-ra; if (ca < 0) {ca+= Math.PI * 2;} if (ca > Math.PI * 2) {ca -= Math.PI * 2;}//fixes fish eye               
                double lineH = (64 * (0.78 * screenSize.getWidth()))/((Math.min(distance1, distance2))*Math.cos(ca)); 
                double ty_step = 32.0/lineH;
                double ty_offset = 0;
                if (lineH > (0.78 * screenSize.getWidth())) {ty_offset = (lineH-(0.78 * screenSize.getWidth()))/2.0; lineH = (0.78 * screenSize.getWidth()); }//320 default value (roughly 1.6 times less than screen width) + some for visuals
                double lineO = screenSize.getHeight()/2.4 - lineH/2;//160 / 230 if rest is doubled // 400 at home
                Graphics2D g2 = (Graphics2D)g;
                //g.setColor(Color.gree);
                int rLen = (int)(screenSize.getWidth() / 120);//
                g2.setStroke(new BasicStroke(rLen));//(screen width / 120)
                //g.drawLine(r*rLen, (int)lineO, r*rLen, (int)(lineH + lineO));//wall
                

                int i;
                double ty = ty_offset*ty_step;

                double tx = 0;
                if (distance1 < distance2) { tx = (int)(sRay.x/2.0)%32; if (ra > Math.PI) tx = 31-tx; }
                else if (distance2 < distance1) { tx = (int)(sRay.y/2.0)%32; if (ra > Math.PI/2 && ra < Math.PI*3/2) tx = 31-tx; }
                //^^^must be x of shortest ray
                

                //walls
                if (mapVal == 2) ty+=32;
                for (i = 0; i < lineH; i++)
                {
                    int c = texture[(int)ty *32 + (int)(tx)];
                    g.setColor(new Color(c*255, c, c));
                    if (distance2 < distance1) g.setColor(new Color((int)(c*255*0.745), (int)(c*0.745), (int)(c*0.745)));//shading
                    g.drawLine(r*rLen, i+(int)lineO, r*rLen, i+(int)lineO);
                    ty += ty_step;
                }
                
                //floors
                for (int q = (int)(lineO + lineH); q < (0.78 * screenSize.getWidth()); q++)
                {
                   double dy = q-((0.78 * screenSize.getWidth())/2.0), raFix = Math.cos(player.getAngle()-ra);
                   tx  = (player.getX() + player.getWidth()/2)/2 + Math.cos(ra)*((0.78 * screenSize.getWidth()))*32/dy/raFix;
                   ty  = (player.getY() + player.getHeight()/2)/2 - Math.sin(ra)*((0.78 * screenSize.getWidth()))*32/dy/raFix;
                   int c = (int)(texture[((int)(ty)&31)*32 + (int)(tx)&31] * 0.7);
                   g.setColor(new Color(c*255, c, c));
                   g.drawLine(r*rLen, q, r*rLen, q);
                }

                g.setColor(Color.cyan);
                g.drawLine(r*rLen, 0, r*rLen, (int)lineO);//ceiling // (screen width / 120)
                //g.setColor(new Color(57, 57, 57));
                //g.drawLine(r*rLen, (int)(lineH + lineO), r*rLen, cubeSize*rLen);//floor / black
                g2.setStroke(new BasicStroke(1));
                ra -= Math.toRadians(0.5); if (ra < 0) {ra+= Math.PI * 2;} if (ra > Math.PI * 2) {ra -= Math.PI * 2;}
            }
    }
    public double calcDistance(int x, int y, double _x, double _y) { return Math.sqrt((_x - x)*(_x - x) + (_y - y)*(_y - y)); } 
}
/*public class Map extends JPanel{    
    private Player player;
    private int cubeSize; //pixels
    private int[][] map = new int[][]
    {
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public Map(int size, Player p)
    {
        player = p;
        //add(player);
        setBackground(Color.darkGray);
        cubeSize = size / 8;
    }

    public int returnSize() { return cubeSize * 8; }
    public int[][] getMap() { return map; }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //for (int i = 0; i < map.length; i++)
            //for (int q = 0; q < map[i].length; q++)
            //{
            //    if (map[i][q] == 1) g.setColor(Color.white);
             //   else g.setColor(Color.black);
             //   g.fillRect(q*cubeSize+1, i*cubeSize+1, cubeSize-1, cubeSize-1);                
            //}
            
            double ra; int r;
            int mx, my, dof; double rx = 0, ry = 0, xo = 0, yo = 0;  
            ra = player.getAngle() + Math.PI/6; if (ra < 0) {ra += (Math.PI * 2);} if (ra > Math.PI * 2) {ra -= (Math.PI * 2);}

            
            for (r = 0; r < 120; r++)
            {            
                g.setColor(new Color(188,5,5));                      
                //---Check Horizontal---
                dof = 0;
                double aTan = (-1/Math.tan(ra));
                if (ra == Math.PI/2 || ra == Math.PI*3/2) { ra += Math.toRadians(0.1); }//left right
                if (ra > Math.PI) { ry = (((int)(player.getY() + player.getHeight()/2)>>6)<<6)-0.0001; rx = (player.getY() + (player.getHeight()/2) -ry) * aTan+(player.getX() + player.getWidth()/2); yo = -64; xo= -yo*aTan; }//up
                if (ra < Math.PI) { ry = (((int)(player.getY() + player.getHeight()/2)>>6)<<6)+64;     rx = (player.getY() + (player.getHeight()/2) -ry) * aTan+(player.getX() + player.getWidth()/2); yo = 64; xo = -yo*aTan; }//down
                
                while (dof < 11)
                {
                    mx = (int)(rx)>>6; my = (int) (ry)>>6; 
                    if (mx < 11 && my < 11 && my >= 0 && mx >= 0 && map[my][mx] == 1) {dof = 11;}//8 = size/dubeSize
                    else {rx += xo; ry += yo; dof++; }
                }                
                double distance1 = calcDistance(player.getX() + player.getWidth()/2, player.getY() + player.getHeight()/2, rx, ry);
                Point sRay = new Point((int)rx, (int)ry);
                
                //---Check Vertical---
                dof = 0;
                double nTan = -Math.tan(ra);
                if (ra == 0 || ra == Math.PI) { ra += Math.toRadians(0.1); }//up down (return to original)?
                if (ra > Math.PI/2 && ra < Math.PI*3/2) { rx = (((int)(player.getX() + player.getWidth()/2)>>6)<<6)-0.0001; ry = (player.getX() + (player.getWidth()/2) -rx) * nTan+(player.getY() + player.getHeight()/2); xo = -64; yo= -xo*nTan; }//left 
                if (ra < Math.PI/2 || ra > Math.PI*3/2) { rx = (((int)(player.getX() + player.getWidth()/2)>>6)<<6)+64;     ry = (player.getX() + (player.getWidth()/2) -rx) * nTan+(player.getY() + player.getHeight()/2); xo = 64; yo = -xo*nTan; }//right
                
                
                while (dof < 11)
                {
                    mx = (int)(rx)>>6; my = (int) (ry)>>6; 
                    if (mx < 11 && my < 11 && my >= 0 && mx >= 0 && map[my][mx] == 1) {dof = 11;}
                    else {rx += xo; ry += yo; dof++; }
                }                
                double distance2 = calcDistance(player.getX() + player.getWidth()/2, player.getY() + player.getHeight()/2, rx, ry);
                
                //--- Draw Rays---
                if (distance2 < distance1) { sRay = new Point((int)rx, (int)ry); g.setColor(new Color(255,0,0));     }
                //g.drawLine(player.getX() + player.getWidth()/2, player.getY() + player.getHeight()/2, (int)sRay.x, (int)sRay.y);
                
                //---Draw 3D walls---
                double ca = player.getAngle()-ra; if (ca < 0) {ca+= Math.PI * 2;} if (ca > Math.PI * 2) {ca -= Math.PI * 2;}//fixes fish eye
                double lineH = (64 * 500)/((Math.min(distance1, distance2))*Math.cos(ca)); if (lineH > 500) lineH = 500;
                double lineO = 230 - lineH/2;
                Graphics2D g2 = (Graphics2D)g;
                //g.setColor(Color.gree);
                g2.setStroke(new BasicStroke(8));
                g.drawLine(r*8, (int)lineO, r*8, (int)(lineH + lineO));//wall
                g.setColor(Color.black);
                g.drawLine(r*8, 0, r*8, (int)lineO);//ceiling
                g.setColor(new Color(57, 57, 57));
                g.drawLine(r*8, (int)(lineH + lineO), r*8, cubeSize*8);//floor ?black
                g2.setStroke(new BasicStroke(1));
                ra -= Math.toRadians(0.5); if (ra < 0) {ra+= Math.PI * 2;} if (ra > Math.PI * 2) {ra -= Math.PI * 2;}
            } 
    }
    public double calcDistance(int x, int y, double _x, double _y) { return Math.sqrt((_x - x)*(_x - x) + (_y - y)*(_y - y)); } 
}
*/