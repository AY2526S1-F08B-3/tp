---
layout: page
title: User Guide
---

ConnectEd is a **desktop app for managing tutors and students, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, ConnectEd can get your contact management tasks done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `17` or above installed in your Computer.<br>
   **Mac users:** Ensure you have the precise JDK version prescribed [here](https://se-education.org/guides/tutorials/javaInstallationMac.html).

1. Download the latest `.jar` file from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar connected.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/UiNew.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * `list tutors` : Lists all tutors (use `list students` to list all students).

   * `add student aaron /hp 91234567 /a Blk 30 Geylang Street 29, #06-40 /s mathematics /l 3 /p 20-30` : Adds a **student** with subject, level, and price range.
     (Example for tutor: `add tutor Mary /hp 98765432 /a Tampines Ave 1 /s english /l 2-5 /p 25-40`)

   * `delete t1` : Deletes the 1st **tutor** shown in the current list.  
     (Use `delete s2` to delete the 2nd **student**.)

   * `clear` : Deletes all entries.

   * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Parameters & placeholders  
  Commands follow the below exactly:  
  • Add: `add <tutor/student> <name> /hp <phone> /a <address> /s <subject> /l <level> /p <min-max>`  
  • List: `list <tutors/students>`  
  • Find: `find <tutor/student> /<field> <filter_value>` where `<field>` is `/s`, `/l`, or `/p`  
  • Match/Unmatch: `match t<INDEX> s<INDEX>` · `unmatch t<INDEX>` or `unmatch s<INDEX>` 


* Accepted values (validators)  
  • `<tutor/student>`: exactly “tutor” or “student” (case-insensitive).  
  • `<tutors/students>` for `list`: exactly “tutors” or “students” (case-insensitive).  
  • `/hp` phone: 8 digits (spaces allowed), digits only.  
  • `/s` subject: one of {english, mathematics, chinese, science} (case-insensitive).  
  • `/l` level:  
  – Student: single integer 1–6  
  – Tutor: single integer 1–6 **or** range `x-y` (1–6 to 1–6; no internal spaces)  
  • `/p` price range: `min-max`, integers 1–200.  


* Typed indices  
  • Use `t<INDEX>` for tutors and `s<INDEX>` for students (1-indexed; visible list indices; no spaces).  
  • Examples: `delete t1`, `delete s2`, `match t1 s2`, `unmatch s2`.  

* Errors (shape & value)  
  The app guides with specific messages on: wrong command format, missing/invalid `<tutor/student>` or `<tutors/students>`, invalid field (`/s` `/l` `/p`), malformed values (non-integer level, bad `min-max`, min>max), duplicates, and empty lists.  


* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.


* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a tutor or student: `add`

Adds a **tutor** or **student** with subject, level, and price range.

Format: `add <tutor/student> <name> /hp <phone> /a <address> /s <subject> /l <level> /p <min-max>`



Examples:
* `add student aaron /hp 91234567 /a Blk 30 Geylang Street 29, #06-40 /s mathematics /l 3 /p 20-30`  
* `add tutor Mary /hp 98765432 /a Tampines Ave 1 /s english /l 2-5 /p 25-40`
### Listing all persons : `list`

Shows a list of either tutors or students.

Format: `list tutors`  |  `list students`

Examples: `list tutors` , `list students`



### Locating persons by name: `find`

Finds persons whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### Deleting a person : `delete`

Deletes the specified person from the address book.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the AddressBook to behave in unexpected ways (e.g., if a value entered is outside of the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List** | `list`
**Help** | `help`
