package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
//import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
//import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListCommand.
 */
public class ListCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_listIsFiltered_showsTutors() {
        ListCommand listTutorsCommand = new ListCommand("tutors");
        expectedModel.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_TUTORS);
        assertCommandSuccess(listTutorsCommand, model, ListCommand.MESSAGE_SUCCESS_TUTORS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsStudents() {
        ListCommand listStudentsCommand = new ListCommand("students");
        expectedModel.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_STUDENTS);
        assertCommandSuccess(listStudentsCommand, model, ListCommand.MESSAGE_SUCCESS_STUDENTS, expectedModel);
    }
}
