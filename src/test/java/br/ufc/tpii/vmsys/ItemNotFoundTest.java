package br.ufc.tpii.vmsys.inventory.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ItemNotFoundTest {

    @Test
    public void testDefaultConstructor() {
        ItemNotFound exception = new ItemNotFound();
        assertEquals(null, exception.getMessage());
    }

    @Test
    public void testMessageConstructor() {
        String message = "Item not found";
        ItemNotFound exception = new ItemNotFound(message);
        assertEquals(message, exception.getMessage());
    }

}
