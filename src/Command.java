/*
Esta clase representa los comandos.
Los comandos compuestos tendrán la var "parameter"
 */

public class Command {
    public String name;
    public String parameter;

    public Command(String command) {
        this.name = command;
    }

    public Command(String name, String parameter) {
        this.name = name;
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }

    public String getName() {
        return name;
    }


}