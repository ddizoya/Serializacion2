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
import java.util.logging.Level;
import java.util.logging.Logger;

import org.w3c.dom.css.DocumentCSS;

public class Producsstream {

    private String ruta = "/datos/local/ddizoya/Escritorio/produtos.txt";
    private File file = new File(ruta);
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    
      Product po1 = new Product("cod1", "parafusos", 3);
      Product po2 = new Product("cod2", "arandelas", 4);
      Product po3 = new Product("cod3","tachas",5);

    public void serializar() {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
          
            oos = new ObjectOutputStream(new FileOutputStream(file)); 
            
            oos.writeObject(po1);
            oos.writeObject(po2);
            oos.writeObject(po3);
            oos.writeObject(null);
            
            oos.flush();

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

    public void leerSerializacion() throws IOException{

        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Product x;
            while (( x = (Product) ois.readObject()) != null) {
                System.out.println(x.getCodigo() + " " + x.getDescripcion() + " " + x.getPrecio());
            }
        } catch (IOException ex) {
            Logger.getLogger(Producsstream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Producsstream.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ois.close();
        }

    }
        public static void main(String[] args) {
        try {

            Producsstream aux = new Producsstream();
            aux.serializar();
            aux.leerSerializacion();
        } catch (IOException ex) {
            Logger.getLogger(Producsstream.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
                
	}
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    







