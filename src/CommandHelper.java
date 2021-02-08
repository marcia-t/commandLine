import java.util.Arrays;
import java.util.List;

/*CommandHelper valida loss comandos y crea las entidades que se ejecutarán luego*/
public class CommandHelper {

    static String[] availableCommands = {"quit", "pwd", "ls", "mkdir", "cd", "touch"};
    public static List<String> commandsList = Arrays.asList(availableCommands);

    /*Valida que el comando se encuentre entre los comandos
   válidos
   Hay un bug: si, por ejemplo, mkdir tuviera más de un parámetro esta
   validación funcionaría aunque no debiera*/
    public static Boolean commandIsValid(String command) {
        return (command.startsWith("touch") || command.startsWith("cd")
                || command.startsWith("mkdir") || commandsList.contains(command));
    }

    /*Valida que el último comando a ejecutar sea quit*/
    public static Boolean endsCorrectly(List<Command> commands) {
        return (commands.get(commands.size() - 1).getName() == "quit");
    }

    /*Crea los objetos comando que serán ejecutados
    * Diferenciando entre los que llevan parámetros y los que no
    * Hay un bug, ver commandIsValid*/
    public static Command createCommand(String command) {
        if (command.startsWith("touch") || command.startsWith("cd")
                || command.startsWith("mkdir")) {
            String[] parts = command.split(" ");
            return new Command(parts[0], parts[1]);
        } else return new Command(command);
    }
}
