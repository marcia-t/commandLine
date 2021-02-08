
/*El contexto hace referencia a los elementos y ubicaciones en donde
se van a ejecutar los comandos.
En un principio se iniciaría en "/" */
public class Context {

    public static Folder fileSystem = new Folder("root", "/");

    public static Folder currentDirectory = fileSystem;


    public Context(){
    }

    public static void cd (String folder) {
        if (folder.equals("..")){
            currentDirectory = currentDirectory.getParent();
        }
        else if (currentDirectory.containsFolder(folder)) {
            currentDirectory = currentDirectory.getFolder(folder);
        } else {
            System.out.println("Directory not found");
            System.exit(1);
        }
    }


    public static void pwd() {
        System.out.println(currentDirectory.getPath());
    }

    public static Folder getCurrentFolder() {
        return currentDirectory;
    }
}
