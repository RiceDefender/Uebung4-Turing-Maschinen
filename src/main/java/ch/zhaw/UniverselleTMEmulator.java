package ch.zhaw;



public class UniverselleTMEmulator {

    public UniverselleTMEmulator() {
        boolean hasPrepend = false;
        String userCodeInput = null;
        String currentState = "q1";
        String currentChar;

        Band band = new Band();
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        //String input = scanner.nextLine();
        String input = "01001000101001100010101001011000100100101001100010001000101011111";
        //String input= "1010010100100110101000101001100010010100100110001010010100";
        if (input.matches("^1*")){
            hasPrepend = true;
            input = input.replaceFirst("^1", "");
        }
        String[] parts = getCharacterSequence(input);
        if (parts.length == 2) {
            userCodeInput = parts[1];
        }
        String[] states = getTransition(parts[0]);
        TransitionChange[] transitions = new TransitionChange[states.length];
        for (int i = 0; i < states.length; i++) {
            char readSymbol = ' ';
            char writeSymbol = ' ';
            String[] operations = states[i].split("1");
            readSymbol = getTapeSymbol(operations[1]);
            writeSymbol = getTapeSymbol(operations[3]);
            if (operations[4].length() == 1) {
                transitions[i] = new TransitionChange("q" + operations[0].length(), readSymbol,
                        new Transition("q" + operations[2].length(), writeSymbol, Direction.LEFT));
            } else if (operations[4].length()==2) {
                transitions[i] = new TransitionChange("q" + operations[0].length(), readSymbol,
                        new Transition("q" + operations[2].length(), writeSymbol, Direction.RIGHT));
            }
        }
        for (TransitionChange transition : transitions) {
            System.out.println(transition.toString());
        }

        if(userCodeInput != null){
            if (hasPrepend){

            } else {
                System.out.println("Current state: " + currentState + " Current input: "+ "q"+userCodeInput);
                for (int i = 0; i < userCodeInput.length(); i++) {
                    char userChar = userCodeInput.charAt(i);
                    currentChar = "";
                    for (int j = 0; j < userCodeInput.length(); j++) {
                        if (j == i) {
                            currentChar += "q";
                        }
                        currentChar += userCodeInput.charAt(j);
                    }
                    for (TransitionChange transition : transitions) {
                        //Check if current state and current char is equal to the avalable transition
                        if (currentState.equals(transition.getState()) && userChar == transition.getCharacter()) {
                            band.write(transition.getTransition().getWriteChar());
                            if (transition.getTransition().getDirection() == Direction.LEFT) {
                                //change state
                                currentState = transition.getTransition().getNextState();
                                //Write char into band
                                band.write(transition.transition.getWriteChar());
                                //Move head to the left
                                band.goLeft();
                            } else {
                                //change state
                                currentState = transition.getTransition().getNextState();
                                //Write char into band
                                band.write(transition.transition.getWriteChar());
                                //Move head to the left
                                band.goRight();
                            }
                            currentState = transition.getTransition().getNextState();
                            break;
                        }
                    }
                    System.out.println("Current state: " + currentState + " Current input: "+ currentChar);
                }
            }
        }
    }
    private String[] getCharacterSequence(String input){
        return input.split("111");
    }
    private String[] getTransition(String input){
        return input.split("11");
    }
    private char getTapeSymbol(String input){
        char tapeSymbol = ' ';
        if (input.length() == 1){
            tapeSymbol = '0';
        } else if (input.length() == 2){
            tapeSymbol = '1';
        } else if (input.length() == 3){
            tapeSymbol = '_';
        } else if (input.length() == 4) {
            tapeSymbol = 'a';
        } else if (input.length() == 5) {
            tapeSymbol = 'b';
        } else if (input.length() == 6) {
            tapeSymbol = 'c';
        }
        return tapeSymbol;
    }
}
