import java.io.*;
import java.util.*;


public class Solution {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String args[] ) throws Exception {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Command> commands = new ArrayList<>();
        List<String> comms = new ArrayList<>();
        comms.add("mkdir first");
        comms.add("ls");
        comms.add("cd first");
        comms.add("pwd");
        comms.add("touch cfg");
        comms.add("ls");
        comms.add("mkdir sec");
        comms.add("cd sec");
        comms.add("pwd");
        comms.add("ls");
        comms.add("cd ..");
        comms.add("pwd");
        comms.add("ls");
        comms.add("quit");

        for (String comm:
             comms) {
            if (! CommandHelper.commandIsValid(comm)){
                System.out.println("Invalid Command");
                return;
            }
            else {
                Command command = CommandHelper.createCommand(comm);
                commands.add(command);
            }
        }

        if (!CommandHelper.endsCorrectly(commands)){
            System.out.println("Not ending properly");
            return;
        }

        Shell.execute(commands);
    }


}





