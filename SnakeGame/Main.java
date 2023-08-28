import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.charset.MalformedInputException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel implements KeyListener{

    public static final int CELL_SIZE=20;
    public static int width=400;
    public static int height = 400;
    public static int row=height/CELL_SIZE;
    public static int column=width/CELL_SIZE;
    private Snake snake;
    private Fruit fruit;
    private Timer t ;
    private int speed = 100;
    private static String direction ;
    private boolean allowKeyPress;

    public Main(){
        snake= new Snake();
        fruit= new Fruit();
        t=new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run(){
                repaint();
            }
        },0,speed);
        direction= "Right";
        addKeyListener(this);
        allowKeyPress=true;

    }

    @Override
    public void paintComponent(Graphics g){
        g.fillRect(0,0,width,height);
        snake.drawSnake(g);
        fruit.drawFruit(g);
        int snakeX =snake.getSnakeBody().get(0).x;
        int snakeY =snake.getSnakeBody().get(0).y;
        //right,x +=CELL_SIZE;
        //left,x -=CELL_SIZE;
        //down,y +=CELL_SIZE;
        //up,y _=CELL_SIZE;
        if(direction.equals("Left")){
            snakeX -=CELL_SIZE;
        }else if(direction.equals("Up")){
            snakeY -=CELL_SIZE;
        }else if (direction.equals("Right")){
            snakeX +=CELL_SIZE;
        }else if (direction.equals("Down")){
            snakeY+=CELL_SIZE;
        }
        Node newHead = new Node(snakeX,snakeY);
        snake.getSnakeBody().remove(snake.getSnakeBody().size()-1);
        snake.getSnakeBody().add(0,newHead);
        allowKeyPress=true;
        requestFocusInWindow();
    }


    @Override
    public Dimension getPreferredSize(){
        return new Dimension(width,height);
    }


    public static void main(String[] args) {
        JFrame window = new JFrame("Snake Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Main());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (allowKeyPress){
                if(e.getKeyCode()==37 && !direction.equals("Right")){
                direction="Left";
            }else if (e.getKeyCode()== 38 && !direction.equals("Down")){
                direction ="Up";
            }else if (e.getKeyCode()== 39 && !direction.equals("Left")){
                direction = "Right";
            }else if (e.getKeyCode()== 40 && !direction.equals("Up")){    
                direction = "Down";
            }
            allowKeyPress =false;   
        }
         
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }

}