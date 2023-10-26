
import javax.swing.*;
import java.awt.event.*;

public class Window implements Runnable{

    JFrame frame;
    Box[][] boxes;
    private Timer timer;
    boolean isAutomatonActive  = false;
    private int currentX = 0;
    private int currentY = 0;

    @Override
    public void run() {
        initFrame();
        initBoxes();
        initKeyboardListener();
        initTimer();
        frame.setVisible(true);

    }

    void initTimer() {
        System.out.println("If tis massage write after 'timer start now' so all is good" );
        TimerListener t1 = new TimerListener();
        timer = new Timer(Config.SLEEP, t1);
        //timer.start();
    }


    void initBoxes() {
        boxes = new Box[Config.WIDTH][Config.HEIGHT];
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                boxes[x][y] = new Box(x, y);
                frame.add(boxes[x][y]);
            }
        }

        GamePanel gamePanel = new GamePanel(boxes);

        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                Box box = boxes[x][y];
                box.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        box.cell.status = CellStatus.Live;
                        box.setColor();
                    }
                });

            }
        }
        frame.add(gamePanel);
    }

    private void initKeyboardListener(){
        System.out.println("Now program listen keyboard");
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("your Key code " + e.getKeyCode() + " and ENTER code = " + KeyEvent.VK_ENTER);
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    isAutomatonActive = true;
                    timer.start();
                    System.out.println("timer is start now");
                }
            }
        });
        frame.setFocusable(true);
        frame.requestFocus();
    }
    void initFrame() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(Config.SIZE * Config.WIDTH,Config.SIZE * Config.HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Cellular Automaton");
    }

    private class TimerListener implements ActionListener {
        boolean flop = false;
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isAutomatonActive) {
                // update only one cell in one tic of timer
                System.out.println("isAutomatonActive: true. And now program start repaint frame");
                if (currentX < Config.WIDTH) {
                    if (currentY < Config.HEIGHT) {
                        if (!flop) {
                            boxes[currentX][currentY].step1();
                            System.out.println("Cell Status 1: " + boxes[currentX][currentY].cell.status);
                        } else {
                           boxes[currentX][currentY].step2();
                            System.out.println("Cell Status 2: " + boxes[currentX][currentY].cell.status);
                        }
                        currentY++;
                    } else {
                        currentX++;
                        currentY = 0;
                    }

                    if (currentX == Config.WIDTH) {
                        // all cells is update, timer -> stop
                        timer.stop();
                        System.out.println("Timer stop:");
                    }
                    frame.repaint();
                }
                System.out.println("current x : " + currentX + " current y :" + currentY + " after repaint");
            }
        }
    }
}
