public class AddCommand extends Command {
  private Task task;

  public AddCommand(Task task) {
    super(false);
    this.task = task;
  }

  public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
    taskList.add(task);
    ui.printIndented("Got it. I've added this task:");
    ui.printIndented(String.format("  %s", task));
    ui.printIndented(String.format("Now you have %d tasks in the list.", taskList.size()));
    storage.write(taskList.toDataString());
    throw new DukeException("Unable to write task list to file.");
  }
}
