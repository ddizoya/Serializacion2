package productsstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.w3c.dom.css.DocumentCSS;

public class Producsstream {
	private String ruta = "/datos/local/ddizoya/Escritorio/produtos.txt";
	private File file = new File(ruta);
	private ObjectOutputStream oos;
	private ObjectInputStream ois;


	public void serializar(Product pro) {
		try {
			if (!file.exists())
				file.createNewFile();

			oos = new ObjectOutputStream(new FileOutputStream(file, true)); // Importante
			oos.writeObject(pro);													// el
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void leerSerializacion(Product obj) {
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
                        
                        while (true){
                            
                        }
		

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] belenEsteban) {
		// Creaci�n de dos objetos con atributos, y uno con nulos.
		Product po1 = new Product("cod1", "parafusos", 3);
		Product po2 = new Product("cod2", "arandelas", 4);
		Product po3 = new Product("cod3","tachas",5);

		
		Producsstream aux = new Producsstream();

		aux.serializar(po1);
		aux.serializar(po2);
                aux.serializar(po3);
                aux.serializar(null);
                
                
                
                
	}

}
