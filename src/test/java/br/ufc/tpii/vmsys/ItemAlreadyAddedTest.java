package br.ufc.tpii.vmsys.inventory.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ItemAlreadyAddedTest {

    @Test
    public void testDefaultConstructor() {
        ItemAlreadyAdded exception = new ItemAlreadyAdded();
        assertEquals(null, exception.getMessage());
    }

    @Test
    public void testMessageConstructor() {
        String message = "Item already added";
        ItemAlreadyAdded exception = new ItemAlreadyAdded(message);
        assertEquals(message, exception.getMessage());
    }

}
