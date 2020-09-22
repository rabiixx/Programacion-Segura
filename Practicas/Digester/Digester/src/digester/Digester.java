package digester;
/**
 *
 * @author MAZ
 */

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Digester {
  
    static private final String CLASS_NAME = Digester.class.getName();
    static private final Logger LOGGER = Logger.getLogger(CLASS_NAME);
    
    private final MessageDigest md;

    public Digester (final String algorithm) throws NoSuchAlgorithmException {
        md = MessageDigest.getInstance( algorithm );
        
    }

    /* Devuelve el algoritmo de hash */
    public String getAlgorithm () {
        return md.getAlgorithm();
    }

    public byte[] digest (final byte[] bytes) {
        
        md.update(bytes);
         
        return md.digest();
    
    }

    public byte[] digest (final InputStream is) throws IOException {
    
      
        try (DigestInputStream dis = new DigestInputStream( is, md )) {
            byte[] bytes = new byte[ 1024 * 8 ];
            
            while ( dis.read( bytes ) != -1 ) {
                
            }
        } catch ( Throwable t) {
            LOGGER.setLevel(Level.INFO);
            LOGGER.log(Level.SEVERE, "Fallo en fichero: %s{0}", t);
            return null;
        }
        return md.digest();
    
  }

}