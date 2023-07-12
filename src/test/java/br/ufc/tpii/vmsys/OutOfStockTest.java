package br.ufc.tpii.vmsys.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OutOfStockTest {

    @Test
    public void testConstructorWithMessage() {
        OutOfStock exception = new OutOfStock("Item out of stock");
        assertEquals("Item out of stock", exception.getMessage());
    }
}
