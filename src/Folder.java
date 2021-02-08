import java.util.ArrayList;
import java.util.List;

/*La clase folder representa los directorios
La clase folder cuenta con:
name: nombre de la carpeta
path: el path en el que se encuentra, utilizado para pwd
files: los archivos que contiene
folders: las carpetas que contiene
parent: guarda el dato del folder parent para poder volver a él
*/

public class Folder {
    public String name;
    public String path;
    public List<File> files;
    public List<Folder> folders;
    public Folder parent;

    public Folder(String name, String path) {
        this.name = name;
        this.path = path;
        this.files = new ArrayList<>();
        this.folders = new ArrayList<>();
    }

    public Folder(String name, String path, Folder parent) {
        this.name = name;
        this.path = path;
        this.files = new ArrayList<>();
        this.folders = new ArrayList<>();
        this.parent = parent;
    }

    /*
    imprime los archivos y las carpetas contenidas
     */
    public void list(){
        System.out.println("Files: " +files.toString());
        System.out.println("Folders: " +folders.toString());
    }

    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public Boolean isRootFolder(){
        return (path.equals("/"));
    }

    public String getPath() {
        return path;
    }

    /*
    Crea un directorio nuevo y lo agrega a los directorios del presente.
     */
    public void addDir(String name){
        Folder f = new Folder(name, this.path+"/"+name, this);
        this.folders.add(f);
    }

    /*
    Crea un nuevo archivo y lo guarda con el resto de los archivos
     */
    public void touch(String name){
        File f = new File(name);
        this.files.add(f);
    }

    /*
    Busca si contiene el  directorio 'folder' entre sus directorios.
     */
    public Boolean containsFolder (String folder){
        for (Folder f :
                folders) {
            if (f.getName().equals(folder)) return true;
        }
        return false;
    }

    /*
    Retorna un directorio por nombre
    No es elegante el return null, pero el chequeo se hace antes de ejecutar.
    Se podría usar un Optional
     */
    public Folder getFolder(String folder) {
        for (Folder f :
                folders) {
            if (f.getName().equals(folder)) return f;
        }
        return null;
    }

    /*
    Retorna el parent del directorio.
    Si es root, se devuelve a sí mismo.
     */
    public Folder getParent() {
        if (this.isRootFolder()){
            return this;
        }
        return this.parent;
    }
}
