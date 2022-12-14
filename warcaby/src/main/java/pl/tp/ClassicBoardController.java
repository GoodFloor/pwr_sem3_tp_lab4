package pl.tp;

public class ClassicBoardController extends BoardController {
    public void resetBoard() {
        // board[0][0] to lewy dolny róg, pierwsza współrzędna to wiersz, druga to
        // kolumna ale to i tak tylko tymczasowe
        Piece[][] temp = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 1) {
                    temp[i][j] = null;
                } else if (i < 3) {
                    temp[i][j] = new Piece();
                    temp[i][j].type = "White";
                }
                else if(i > 4) {
                    temp[i][j] = new Piece();
                    temp[i][j].type = "Red";
                }
                else {
                    temp[i][j] = null;
                }
            }
        }
        board.setBoard(temp);
    }

    private int getPositionX(String position) {
        return (int) position.charAt(0) - 65;
    }

    private int getPositionY(String position) {
        return Integer.parseInt(position.substring(1, position.length())) - 1;
    }
    private String codePosition(int posX, int posY) {
        String result = "";
        result += (char) (posX + 65);
        result += posY + 1;
        return result;
    }
    public boolean isWhite(String position) {
        return board.getBoard()[this.getPositionX(position)][this.getPositionY(position)].type == "White";
    }
    public boolean isRed(String position) {
        return board.getBoard()[this.getPositionX(position)][this.getPositionY(position)].type == "Red";
    }
    private boolean canKill(int posX, int posY) {
        Piece[][] tempBoard = board.getBoard();
        if(posX > 1 && posY < 6 && tempBoard[posX - 1][posY - 1].getClass() == Piece.class && tempBoard[posX][posY].type != tempBoard[posX - 1][posY - 1].type && tempBoard[posX - 2][posY - 2] == null) {
            return true;
        }
        else if(posX < 6 && posY < 6 && tempBoard[posX + 1][posY + 1].getClass() == Piece.class && tempBoard[posX][posY].type != tempBoard[posX + 1][posY + 1].type && tempBoard[posX + 2][posY + 2] == null) {
            return true;
        }
        else return false;
    }
    public String whoCanKill(String type) {
        Piece[][] tempBoard = board.getBoard();
        String result = "";
        for (int i = 0; i < tempBoard.length; i++) {
            for (int j = 0; j < tempBoard[i].length; j++) {
                if(tempBoard[i][j].type == type && canKill(i, j)) {
                    result += this.codePosition(i, j) + ";";
                }
            }
        }
        return result;
    }
    public SquareStateEnum[][] translateBoard() {
        SquareStateEnum[][] result = new SquareStateEnum[board.getWidth()][board.getHeight()];
        Piece[][] boardContent = board.getBoard();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (boardContent[i][j] == null) {
                    result[i][j] = SquareStateEnum.White;
                } else {
                    result[i][j] = SquareStateEnum.BlackEmpty;
                }
            }
        }

        return result;
    }
}
