package pl.tp;

public class ClassicBoardController extends BoardController {
    public void resetBoard() {
        //board[0][0] to lewy dolny róg, pierwsza współrzędna to wiersz, druga to kolumna ale to i tak tylko tymczasowe
        Piece[][] temp = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 1) {
                    temp[i][j] = null;
                }
                else if(i < 3) {
                    temp[i][j] = new Piece();
                }
                else if(i > 4) {
                    temp[i][j] = new Piece();
                }
                else {
                    temp[i][j] = null;
                }
            }
        }
        board.setBoard(temp);
    }

    // private int getPositionX(String position) {
    //     position.charAt(0);
    // }
    // private int getPositionY(String position) {

    // }
    // public boolean isWhite(String position) {

    // }
    // public boolean isRed(String position) {

    // }
    // public boolean canKill(String position) {
    //     if()
    // }
}
