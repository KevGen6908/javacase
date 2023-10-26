public enum CellStatus {

//    Off, // Клетка выключена
//    On, // Клетка включена
//    Up, // Клетка верхний сосед
//    Down, // Клетка нижний сосед
//    Left, // Клетка левый сосед
//    Right, // Клетка правый сосед
//    Died; // Клетка умирает
//
//    public CellStatus step1(int up, int down, int left, int right) {
//        switch (this) {
//            case Off:
//                if (up > 0 || down > 0 || left > 0 || right > 0) {
//                    return On;
//                } else {
//                    return Died;
//                }
//            case On:
//                if (up == 0 && down == 0 && left == 0 && right == 0) {
//                    return Died;
//                } else {
//                    return this;
//                }
//            default:
//                return this;
//        }
//    }
//
//    public CellStatus step2() {
//        switch (this) {
//            case Up:
//            case Down:
//            case Left:
//            case Right:
//                return On;
//            default:
//                return this;
//        }
//    }
//
//
    None,
    Born,
    Live,
    Died;

    public CellStatus step1(int around) {
        switch (this){
            case None: return (around >= 3) ? Born: None;
            case Live: return (around <= 1 || around >= 4) ? Died : Live;
            default: return  this;
        }
    }
    public CellStatus step2() {
        switch (this){
            case Born: return Live;
            case Died: return None;
            default: return this;
        }
    }
    public boolean isLive() {
        return this == Live || this == Died;
    }

}
