package ch.zhaw;

public class TransitionChange {
    String state;
    char character;
    Transition transition;


    public TransitionChange(String input, char character, Transition transition) {
        state = input;
        this.character = character;
        this.transition = transition;
    }

    public Transition getTransition() {
        return transition;
    }

    public char getCharacter() {
        return character;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "("+state + ", "+ character +") => " + transition.toString();
    }
}
