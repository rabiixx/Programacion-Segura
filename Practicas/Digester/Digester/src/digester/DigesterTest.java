package digester;
/**
 *
 * @author MAZ
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public final class DigesterTest {
  
  private static
  String toHex (final byte[] bytes) {

    final BigInteger x = new BigInteger(1, bytes);
    return String.format("%0" + (bytes.length << 1) + "x", x);
  }
  
  public static
  void main (final String[] args)
          throws FileNotFoundException, IOException, NoSuchAlgorithmException {
        
    final Digester d0 = new Digester("MD5");
    final Digester d1 = new Digester("SHA-1");
    final Digester d2 = new Digester("SHA-256");

    System.out.println("Cadena vacía:");
    final byte[] m0 = "".getBytes();    
    System.out.println("MD5:     " + toHex(d0.digest(m0)));
    System.out.println("SHA-1:   " + toHex(d1.digest(m0)));
    System.out.println("SHA-256: " + toHex(d2.digest(m0)));

    System.out.println("\nCadena abc:");
    final byte[] m1 = "abc".getBytes();
    System.out.println("MD5:     " + toHex(d0.digest(m1)));
    System.out.println("SHA-1:   " + toHex(d1.digest(m1)));
    System.out.println("SHA-256: " + toHex(d2.digest(m1)));
    
    System.out.println("\nCadena pepe:");
    final byte[] m2 = "pepe".getBytes();
    System.out.println("MD5:     " + toHex(d0.digest(m2)));
    System.out.println("SHA-1:   " + toHex(d1.digest(m2)));
    System.out.println("SHA-256: " + toHex(d2.digest(m2))); 
    
    System.out.println("\nCadena pepa:");
    final byte[] m3 = "pepa".getBytes();
    System.out.println("MD5:     " + toHex(d0.digest(m3)));
    System.out.println("SHA-1:   " + toHex(d1.digest(m3)));
    System.out.println("SHA-256: " + toHex(d2.digest(m3)));     
    
    final String fileName = System.getProperty("user.dir")
            + File.separator + "data"
            + File.separator + "Ligeia.txt";
    final File file = new File(fileName);
    FileInputStream fis;
    
    fis = new FileInputStream(file);
    System.out.println("\nFichero Ligeia.txt:");
    System.out.println("MD5:     " + toHex(d0.digest(fis)));
    fis = new FileInputStream(file);
    System.out.println("SHA-1:   " + toHex(d1.digest(fis)));
    fis = new FileInputStream(file);        
    System.out.println("SHA-256: " + toHex(d2.digest(fis)));

  }  
  
}