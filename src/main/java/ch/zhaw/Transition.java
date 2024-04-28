package ch.zhaw;

public class Transition {
    private String nextState;
    private char writeChar;
    private Direction direction;

    public Transition(String nextState, char writeChar, Direction direction) {
        this.nextState = nextState;
        this.writeChar = writeChar;
        this.direction = direction;
    }

    public String getNextState() {
        return nextState;
    }

    public char getWriteChar() {
        return writeChar;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "("+nextState + ", "+ writeChar +", "+ direction +")";
    }
}
