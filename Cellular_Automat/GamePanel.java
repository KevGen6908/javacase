import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class GamePanel extends JPanel {
    private Box[][] boxes;
    public GamePanel(Box[][] boxes){
        this.boxes = boxes;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();
                int selectRow = mouseY / Config.SIZE;
                int selectCol = mouseX / Config.SIZE;

                if(selectRow >= 0 && selectRow < Config.HEIGHT && selectCol >= 0 && selectCol < Config.WIDTH){
                    boxes[selectRow][selectCol].cell.status = CellStatus.Live;
                    boxes[selectRow][selectCol].setColor();
                    System.out.println("Log: choose cell with coordinates Row" + selectRow + " Col " + selectCol);
                }
            }
        });
    }
}
