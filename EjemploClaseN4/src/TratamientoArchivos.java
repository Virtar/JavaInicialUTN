import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
public class TratamientoArchivos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Path unArchivo = Paths.get("C:\\Users\\Silvina Laurent\\eclipse-workspace\\manejoArchivos\\martinfierro.txt");
		try
		{

		for (String linea : Files.readAllLines(unArchivo))
			{
				System.out.println(linea);
			}
		}
		catch (IOException e) {
            System.err.println(e);
        }
		System.out.println(unArchivo.toAbsolutePath());
		*/
		/*
		FileTime lastModifiedTime = Files.getLastModifiedTime(unArchivo);
		System.out.println(lastModifiedTime);
		*/
		/*try
		{
			for (String linea : Files.readAllLines(Paths.get("texto1.txt"))){
				System.out.println(linea);
			}
		}
		 catch (IOException e) {
	            System.err.println(e);
	        }
		*/
		/*try
		{

			System.out.println(Files.exists(otroArch));
			Files.createFile(otroArch);
			System.out.println(Files.exists(otroArch));
		}
		catch (IOException e) {
            System.err.println(e);
        }*/ 
	/*	try
		{
			Path otroArch = Paths.get("algoQueNoExiste.txt");
			Files.writeString(otroArch, "Prueba\n archivo nuevo\n sin contenido\n");
			for (String linea : Files.readAllLines(otroArch))
			{
				System.out.println(linea);
			}
		}
		catch (IOException e) {
            System.err.println(e);
        }*/
		try
		{
			Path masArch = Paths.get("nuevoArchivo2.txt");
			System.out.println(Files.exists(masArch));
			Files.createFile(masArch);
			//System.out.println(Files.exists(masArch));
			Files.writeString(masArch, "Nuevo archivo\n en la carpeta\n  de manejoArchivos\n");
			for (String linea : Files.readAllLines(masArch))
			{
				System.out.println(linea);
			}
		}
		catch (IOException e) {

            System.err.println(e);
        }
	}
}