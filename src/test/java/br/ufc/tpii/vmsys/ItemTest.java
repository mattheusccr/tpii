package br.ufc.tpii.vmsys.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemTest {

    private Item item;

    @BeforeEach
    public void setUp() {
        item = new Item("Item", 10.0, 5);
    }

    @Test
    public void testGetName() {
        assertEquals("Item", item.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(10.0, item.getPrice());
    }

    @Test
    public void testSetPrice() {
        item.setPrice(15.0);
        assertEquals(15.0, item.getPrice());
    }

    @Test
    public void testGetCount() {
        assertEquals(5, item.getCount());
    }

    @Test
    public void testDecCount() {
        item.decCount();
        assertEquals(6, item.getCount());
    }

    @Test
    public void testIncCount() {
        item.incCount();
        assertEquals(4, item.getCount());
    }
}
