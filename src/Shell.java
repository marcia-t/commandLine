import java.util.List;

/*
El propósito de la clase Shell es ejecutar los comandos en el contexto actual.
*/
public class Shell {

    public static void execute(List<Command> commands) {
        for (Command command:
             commands) {
            Shell.executeCommand(command);
        }
    }

    public static void executeCommand(Command command){
        switch(command.getName()) {
            case "ls":
                Context.currentDirectory.list();
                break;
            case "pwd":
                Context.pwd();
                break;
            case "quit":
                System.out.println("End of commands");
                break;
            case "cd":
                Shell.executeCd(command);
                break;
            case "touch":
                Shell.executeTouch(command);
                break;
            case "mkdir":
                Shell.executeMkdir(command);
                break;
        }
    }

    private static void executeMkdir(Command command) {
        String dirName = command.getParameter();
        Context.getCurrentFolder().addDir(dirName);
    }

    private static void executeTouch(Command command) {
        String param = command.getParameter();
        Context.getCurrentFolder().touch(param);
    }

    private static void executeCd(Command command) {
        String dir = command.getParameter();
        Context.cd(dir);
    }

}
