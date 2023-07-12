package br.ufc.tpii.vmsys.inventory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ufc.tpii.vmsys.inventory.exceptions.ItemAlreadyAdded;
import br.ufc.tpii.vmsys.inventory.exceptions.ItemNotFound;

public class HashMapInventoryTest {

    private HashMapInventory inventory;

    @BeforeEach
    public void setUp() {
        inventory = new HashMapInventory();
    }

    @Test
    public void testAddItem() throws ItemAlreadyAdded {
        Item item = new Item("Item 1", 10.0, 5);
        inventory.addItem(item);
        assertEquals(1, inventory.numberOfItems());
    }

    @Test
    public void testRemoveItem() throws ItemAlreadyAdded, ItemNotFound {
        Item item = new Item("Item 1", 10.0, 5);
        inventory.addItem(item);
        inventory.removeItem("Item 1");
        assertEquals(0, inventory.numberOfItems());
    }

    @Test
    public void testGetItem() throws ItemAlreadyAdded, ItemNotFound {
        Item item = new Item("Item 1", 10.0, 5);
        inventory.addItem(item);
        Item retrievedItem = inventory.getItem("Item 1");
        assertEquals(item, retrievedItem);
    }

    @Test
    public void testAddItemAlreadyAdded() throws ItemAlreadyAdded {
        Item item = new Item("Item 1", 10.0, 5);
        inventory.addItem(item);
        assertThrows(ItemAlreadyAdded.class, () -> inventory.addItem(item));
    }

    @Test
    public void testRemoveItemNotFound() throws ItemNotFound {
        assertThrows(ItemNotFound.class, () -> inventory.removeItem("Item 1"));
    }

    @Test
    public void testGetItemNotFound() throws ItemNotFound {
        assertThrows(ItemNotFound.class, () -> inventory.getItem("Item 1"));
    }

}
