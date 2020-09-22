package digester;
/**
 *
 * @author rabiixx
 */

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Digester {
  
    static private final String CLASS_NAME = Digester.class.getName();
    static private final Logger LOGGER = Logger.getLogger(CLASS_NAME);
    
    private final MessageDigest md;

    public Digester (final String algorithm) throws NoSuchAlgorithmException {
        
        try {
            md = MessageDigest.getInstance( algorithm );
        } catch ( final NoSuchAlgorithmException ex ) {
            LOGGER.log(Level.SEVERE, "Algoritmo no encontrado", ex);
            throw ex;
        }
    }
    
    public String getAlgorithm () {
        return md.getAlgorithm();
    }

    public byte[] digest (final byte[] bytes) {
        
        md.update(bytes);
         
        return md.digest();
    
    }

    public byte[] digest (final InputStream is) throws IOException {
    
      
        try ( DigestInputStream dis = new DigestInputStream( is, md ) ) {
            
            byte[] bytes = new byte[ 1024 * 8 ];
            
            while ( dis.read( bytes ) != -1 ) {}
            
            return md.digest();
            
        } catch ( final IOException ex ) {
        
            LOGGER.setLevel(Level.SEVERE);
            LOGGER.log(Level.SEVERE, "Excepcion de E/S: %s{0}", ex);
            throw ex;
        
        }        
    
  }

}