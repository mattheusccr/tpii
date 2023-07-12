package br.ufc.tpii.vmsys.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InsufficientFundsTest {

    @Test
    public void testDefaultConstructor() {
        InsufficientFunds exception = new InsufficientFunds();
        assertEquals(null, exception.getMessage());
    }

    @Test
    public void testMessageConstructor() {
        String message = "Insufficient funds";
        InsufficientFunds exception = new InsufficientFunds(message);
        assertEquals(message, exception.getMessage());
    }

}
