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
        {
            case KeyEvent.VK_W ->  player.up = true;    
            case KeyEvent.VK_S -> player.down = true;
            case KeyEvent.VK_A ->  player.left = true;
            case KeyEvent.VK_D ->  player.right = true;
            case KeyEvent.VK_Q -> player.lookLeft = true;  
            case KeyEvent.VK_E ->  player.look = true; 
            case KeyEvent.VK_F -> player.interact = true;
            case KeyEvent.VK_M -> map.changeView();
        }
        //player.interact = false;
    }
    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_W -> player.up = false;
            case KeyEvent.VK_S -> player.down = false;             
            case KeyEvent.VK_A -> player.left = false;
            case KeyEvent.VK_D -> player.right = false;
            case KeyEvent.VK_Q -> player.lookLeft = false;
            case KeyEvent.VK_E -> player.lookRight = false;
        }
    }
    public void keyTyped(KeyEvent e) 
    { 
        
    }
}
