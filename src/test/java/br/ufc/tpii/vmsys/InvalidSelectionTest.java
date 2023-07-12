package br.ufc.tpii.vmsys.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InvalidSelectionTest {

    @Test
    public void testDefaultConstructor() {
        InvalidSelection exception = new InvalidSelection();
        assertEquals(null, exception.getMessage());
    }

    @Test
    public void testMessageConstructor() {
        String message = "Invalid selection";
        InvalidSelection exception = new InvalidSelection(message);
        assertEquals(message, exception.getMessage());
    }

}
