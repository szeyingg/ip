# Mira User Guide

ଘ(= ' u ' =) --*.

Mira is a Command-Line Interface (CLI) task assistant, which aids users in storing and managing tasks with a hint of magic ⸝*₊͛.

Using Mira, users will be able to cast "spells" to add, delete, mark, list, and find tasks they have conjured! 🔮✨\
Mira also has the powers to rekindle previously saved tasks, so no need to ever worry about losing track!

## Features
### Viewing help - `help`

*Lists all valid commands and their functions.*

**Format:** `help`

<br/>

### Adding tasks - `todo`, `deadline`, `event`

Mira features 3 types of tasks:
- `Todo`: contains a description only
- `Deadline`: contains description and deadline
- `Event`: contains description, start and end time/date

#### Adding a Todo task
*Adds a `Todo` task to the task list.*

**Format:** `todo <description>`

**Example:**
`todo make potion`\
↓
```
Ta-da! A new task has been conjured: 
[T][ ] make potion
Phew! A total of 1 magical tasks awaits you!
```

#### Adding a Deadline task
*Adds a `Deadline` task to the task list.*

**Format:** `deadline <description> /by <deadline>`

**Example:**
`deadline finish potion /by tuesday`\
↓
```
Ta-da! A new task has been conjured: 
[D][ ] finish potion (by: tuesday)
Phew! A total of 2 magical tasks awaits you!
```

#### Adding an Event task
*Adds an `Event` task to the task list.*

**Format:** `event <description> /from <start> /to <end>`

**Example:**
`event witch dinner /from 6pm /to 7pm`\
↓
```
Ta-da! A new task has been conjured: 
[E][ ] witch dinner (from: 6pm to: 7pm)
Phew! A total of 3 magical tasks awaits you!
```

<br/>

### Listing tasks - `list`

*Displays list of all tasks.*

**Format:** `list`

**Example:**
`list`\
↓
```
Abra-Cadabra! Here's your task list:
1.[T][ ] make potion
2.[D][ ] try potion (by: tuesday)
3.[E][ ] witch dinner (from: 6pm to: 7pm)
```
<br/>

### Marking tasks- `mark`, `unmark`

`mark`: *Marks specified task as done*

**Format:** `mark <list index>`

**Example:**
`mark 1`\
↓
```
Presto, you did it! Task 1 has been conquered!
[T][X] make potion
```

`unmark`: *Marks specified task as undone*

**Format:** `unmark <list index>`

**Example:**
`unmark 1`\
↓
```
Tough luck! Task 1 has come back stronger!
[T][ ] make potion
```
<br/>

### Deleting tasks - `delete`

*Deletes task from list.*

**Format:** `delete <list index>`

**Example:**
`delete 1`\
↓
```
And...Poof! The task vanishes into thin air: 
[T][ ] make potion
Phew! A total of 2 magical tasks awaits you!
```
<br/>

### Finding tasks - `find`

*Finds task(s) in list which contains searched keyword.*

**Format:** `find <keyword>`

**Example:**
`find potion`\
↓
```
Woohoo! I have traced the magic to the following tasks:
1. [D][ ] try potion (by: tuesday)
```
<br/>

### Exiting program - `bye`

*Exits the program.*

**Format:** `bye`

<br/>

### Saving data
Task data is saved automatically after every command.\
Saved tasks will be loaded upon program start.

## Command Summary

| Action              | Format                                        |
|---------------------|-----------------------------------------------|
| List commands       | `help`                                        |
| Add Todo task       | `todo <description>`                          |
| Add Deadline task   | `deadline <description>`                      |
| Add Event task      | `event <description> /from <start> /to <end>` |
| List tasks          | `list`                                        |
| Mark task as done   | `mark <index>`                                |
| Mark task as undone | `unmark <index>`                              |
| Delete task         | `delete <index>`                              |
| Find tasks          | `find <keyword>`                              |
| Exit program        | `bye`                                         |