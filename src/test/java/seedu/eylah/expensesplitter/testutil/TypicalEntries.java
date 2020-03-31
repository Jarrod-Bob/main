package seedu.eylah.expensesplitter.testutil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import seedu.eylah.expensesplitter.model.item.Item;
import seedu.eylah.expensesplitter.model.person.Person;
import seedu.eylah.expensesplitter.model.receipt.Entry;
import seedu.eylah.expensesplitter.model.receipt.Receipt;

/**
 * A utility class containing a list of {@code Entry} objects to be used in tests.
 */
public class TypicalEntries {

    // default entry
    public static final Entry ENTRY_ONE = new EntryBuilder().build();

    // fields below are to make more entries
    private static final Item PIZZA = new ItemBuilder().withName("Pizza")
            .withPrice(new BigDecimal("19.00")).build();
    private static final Item PASTA = new ItemBuilder().withName("Pasta")
            .withPrice(new BigDecimal("5.00")).build();
    private static final Person ANNABELLE = new PersonBuilder().withName("Annabelle").build();
    private static final Person BOBBY = new PersonBuilder().withName("Bobby").build();
    private static final ArrayList<Person> PERSONS_LIST_TWO = new ArrayList<>(Arrays.asList(ANNABELLE, BOBBY));
    private static final ArrayList<Person> PERSONS_LIST_THREE = new ArrayList<>(Arrays.asList(ANNABELLE));

    // made entries to simulate receipt
    public static final Entry ENTRY_TWO = new EntryBuilder().withItem(PIZZA)
            .withPersons(PERSONS_LIST_TWO).build();
    public static final Entry ENTRY_THREE = new EntryBuilder().withItem(PASTA)
            .withPersons(PERSONS_LIST_THREE).build();

    public static Receipt getTypicalReceipt() {
        Receipt receipt = new Receipt();
        for (Entry entry : getTypicalEntries()) {
            receipt.addEntry(entry);
        }
        return receipt;
    }

    public static ArrayList<Entry> getTypicalEntries() {
        return new ArrayList<>(Arrays.asList(ENTRY_ONE, ENTRY_TWO, ENTRY_THREE));
    }
}
