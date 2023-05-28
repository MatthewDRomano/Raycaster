import java.awt.event.*;

public class KeyListenerMod implements KeyListener
{
    private Player player;
    private Map map;

    public KeyListenerMod(Player p, Map m)
    {
        player = p;
        map = m;
    }
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {   /*
            case KeyEvent.VK_W ->  player.up = true;   
            case KeyEvent.VK_S -> player.down = true;
            case KeyEvent.VK_A ->  player.left = true;
            case KeyEvent.VK_D ->  player.right = true;
            case KeyEvent.VK_Q -> player.lookLeft = true;  
            case KeyEvent.VK_E ->  player.lookRight = true; 
            case KeyEvent.VK_F -> player.interact = true;
            case KeyEvent.VK_M -> map.changeView();
            */
            case KeyEvent.VK_W:
            player.up = true;    
            break;
            case KeyEvent.VK_S: 
            player.down = true;
            break;
            case KeyEvent.VK_A:
            player.left = true;
            break;
            case KeyEvent.VK_D:
            player.right = true;
            break;
            case KeyEvent.VK_Q:
            player.lookLeft = true; 
            break;
            case KeyEvent.VK_E:
            player.lookRight = true; 
            break;
            case KeyEvent.VK_F:
            player.interact = true;
            break;
            case KeyEvent.VK_M: 
            map.changeView();
            break;
            
        }
        //player.interact = false;
    }
    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            /*
            case KeyEvent.VK_W -> player.up = false;
            case KeyEvent.VK_S -> player.down = false;             
            case KeyEvent.VK_A -> player.left = false;
            case KeyEvent.VK_D -> player.right = false;
            case KeyEvent.VK_Q -> player.lookLeft = false;
            case KeyEvent.VK_E -> player.lookRight = false;
            */
            case KeyEvent.VK_W:
            player.up = false;    
            break;
            case KeyEvent.VK_S: 
            player.down = false;
            break;
            case KeyEvent.VK_A:
            player.left = false;
            break;
            case KeyEvent.VK_D:
            player.right = false;
            break;
            case KeyEvent.VK_Q:
            player.lookLeft = false; 
            break;
            case KeyEvent.VK_E:
            player.lookRight = false; 
            break;
            
        }
    }
    public void keyTyped(KeyEvent e) 
    { 
        
    }
}
