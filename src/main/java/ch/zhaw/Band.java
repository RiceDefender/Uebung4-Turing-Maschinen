package ch.zhaw;

import java.util.HashMap;
import java.util.Map;

public class Band {
    private Map<Integer, Integer> band = new HashMap<>();
    private static final int DEFAULT_BAND_SIZE = 100;
    private int position = 0;

    public Band() {
        for (int i = 0; i < DEFAULT_BAND_SIZE; i++) {
            band.put(i, 0);
        }
        for (int i = 0; i >= -DEFAULT_BAND_SIZE; i--) {
            band.put(i, 0);
        }
    }

    public void goLeft() {
        position--;
    }
    public void goRight() {
        position++;
    }

    public int read() {
        return band.get(position);
    }

    public void write(int value) {
        band.put(position, value);
    }
}
