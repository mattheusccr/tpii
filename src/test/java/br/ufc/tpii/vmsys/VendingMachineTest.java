package br.ufc.tpii.vmsys;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ufc.tpii.vmsys.exceptions.InsufficientFunds;
import br.ufc.tpii.vmsys.exceptions.InvalidSelection;
import br.ufc.tpii.vmsys.exceptions.OutOfStock;
import br.ufc.tpii.vmsys.inventory.Inventory;
import br.ufc.tpii.vmsys.inventory.Item;
import br.ufc.tpii.vmsys.inventory.exceptions.ItemNotFound;

public class VendingMachineTest {

    private VendingMachine vendingMachine;
    private Inventory inventory;

    @BeforeEach
    public void setUp() {
        // Configurar o inventário de teste com itens
        inventory = new TestInventory();
        inventory.addItem(new Item("Item A", 1.0, 5));
        inventory.addItem(new Item("Item B", 2.0, 0));

        // Inicializar a máquina de venda com o inventário de teste
        vendingMachine = new VendingMachine(inventory);
    }

    @Test
    public void testAddCoins() {
        vendingMachine.addCoins(1.0);
        vendingMachine.addCoins(0.5);
        assertEquals(1.5, vendingMachine.howManyCoinsLeft());
    }

    @Test
    public void testWithdrawRemainingCoins() {
        vendingMachine.addCoins(2.0);
        assertEquals(2.0, vendingMachine.withdrawRemainingCoins());
        assertEquals(0.0, vendingMachine.howManyCoinsLeft());
    }

    @Test
    public void testVendValidItem() throws InvalidSelection, OutOfStock, InsufficientFunds {
        vendingMachine.addCoins(2.0);
        vendingMachine.vend("Item A");
        assertEquals(1.0, vendingMachine.howManyCoinsLeft());
    }

    @Test
    public void testVendInvalidItem() {
        assertThrows(InvalidSelection.class, () -> vendingMachine.vend("Invalid Item"));
    }

    @Test
    public void testVendOutOfStockItem() {
        assertThrows(OutOfStock.class, () -> vendingMachine.vend("Item B"));
    }

    @Test
    public void testVendInsufficientFunds() {
        vendingMachine.addCoins(1.0);
        assertThrows(InsufficientFunds.class, () -> vendingMachine.vend("Item A"));
    }

    // Implemente uma classe TestInventory para simular o inventário de teste
    private class TestInventory implements Inventory {
        private Item item;

        public void addItem(Item item) {
            this.item = item;
        }

        public void removeItem(String itemName) {
            // Não implementado para o teste
        }

        public Item getItem(String itemName) throws ItemNotFound {
            if (item != null && item.getName().equals(itemName)) {
                return item;
            }
            throw new ItemNotFound("Item not found: " + itemName);
        }

        public int numberOfItems() {
            return 0; // Não implementado para o teste
        }
    }
}
