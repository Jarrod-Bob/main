package seedu.eylah.expensesplitter.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.eylah.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.eylah.expensesplitter.logic.parser.CliSyntax.PREFIX_ITEM;
import static seedu.eylah.expensesplitter.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.eylah.expensesplitter.logic.parser.CliSyntax.PREFIX_PRICE;

import java.util.ArrayList;

import seedu.eylah.expensesplitter.logic.commands.exceptions.CommandException;
import seedu.eylah.expensesplitter.model.Model;
import seedu.eylah.expensesplitter.model.item.Item;
import seedu.eylah.expensesplitter.model.person.Amount;
import seedu.eylah.expensesplitter.model.person.Person;
import seedu.eylah.expensesplitter.model.receipt.Entry;


/**
 * Used to add entries to the receipt.
 */
public class AddItemCommand extends Command {

    public static final String COMMAND_WORD = "additem";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an item to the receipt. "
            + "Parameters: "
            + PREFIX_ITEM + "ITEM NAME "
            + PREFIX_PRICE + "PRICE "
            + PREFIX_NAME + "PERSON NAME";

    public static final String MESSAGE_SUCCESS = "The entry: \n  -> %1$s\nhas been added.";

    // note:
    // if receipt is done, can only do paid, back, listamount and listreceipt. CANNOT: add/deleteitem.
    // if receipt is undone, can only additem, back, deleteitem, listreceipt, listamount. CANNOT: paid.
    public static final String MESSAGE_RECEIPT_DONE = "The current receipt is marked as completed. You may not use "
            + "the additem command.";

    private Entry toBeAdded;
    private ArrayList<Person> persons;
    private Amount amount;

    /**
     * Creates an AddItemCommand to add the specified {@code Item}
     *
     * @param item    Item to be added.
     * @param persons String array of persons to be added.
     */
    public AddItemCommand(Item item, ArrayList<Person> persons, Amount amount) {
        requireAllNonNull(item, persons, amount);
        this.persons = persons;
        this.amount = amount;
        this.toBeAdded = new Entry(item, persons);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (model.isReceiptDone()) {
            return new CommandResult(MESSAGE_RECEIPT_DONE);
        } else {
            model.addEntry(toBeAdded);
            for (Person person : persons) {
                if (!model.hasPerson(person)) {
                    model.addPerson(person);
                } else {
                    model.addAmount(model.getPerson(person), amount);
                }
            }
            return new CommandResult(String.format(MESSAGE_SUCCESS, toBeAdded));
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddItemCommand // instanceof handles nulls
                && toBeAdded.equals(((AddItemCommand) other).toBeAdded));
    }

}
