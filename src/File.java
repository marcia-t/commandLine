/*File representa un archivo.
Tiene solamente nombre porque la información
de ubicación de los archivos está en las carpetas*/
public class File {
    public String name;

    public File(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
