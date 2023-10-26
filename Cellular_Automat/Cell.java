import java.util.ArrayList;

public class Cell {
    CellStatus status;
    CellStatus nextStatus;
    ArrayList<Cell> near;

    public Cell(){
        status = CellStatus.None;
        
        near = new ArrayList<>();
    }

    void addNear(Cell cell){
        near.add(cell);
    }
    void step1(){
        int around = countNearCell(CellStatus.Live);
        status = status.step1(around);
    }

    private int countNearCell(CellStatus status) {
        int count = 0;
        for (Cell cell : near) {
            if(cell.status == status)
                count++;

        }
        return count;
    }

    void step2(){
        status = status.step2();
    }
}

