package pl.tp;

public class ClassicGameController extends GameController {
    @Override
    void setBoard() {
        boardController = new ClassicBoardController();
        boardController.resetBoard();
    }

    @Override
    void setStartMessage() {
        this.startMessage = "The Classic game is on";
    }
}
