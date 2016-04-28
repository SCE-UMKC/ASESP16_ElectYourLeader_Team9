import java.security.*;
import java.security.spec.*;

import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class TestEncryptDecrypt {
	
	private final String ALGO = "DES";
	private final String MODE = "ECB";
	private final String PADDING = "PKCS5Padding";
	private static int mode = 0;

	public static void main(String args[]) {
	    TestEncryptDecrypt me = new TestEncryptDecrypt();
	    if(args.length == 0) mode = 2;
	    else mode = Integer.parseInt(args[0]);
	    switch (mode) {
	    case 0:
	        me.encrypt();
	        break;
	    case 1:
	        me.decrypt();
	        break;
	    default:
	        me.encrypt();
	        me.decrypt();
	    }
	}

	public void encrypt() {
	try {
	    System.out.println("Start encryption ...");

	    /* Get Input Data */
	    String input = getInputData();
	    System.out.println("Input data:\n"+input);

	    /* Create Secret Key */
	    KeyGenerator keyGen = KeyGenerator.getInstance(ALGO);
	    SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
	    keyGen.init(56,random);
	      Key sharedKey = keyGen.generateKey();

	    /* Create the Cipher and init it with the secret key */
	    Cipher c = Cipher.getInstance(ALGO+"/"+MODE+"/"+PADDING);
	    //System.out.println("\n" + c.getProvider().getInfo());
	    c.init(Cipher.ENCRYPT_MODE,sharedKey);
	    byte[] ciphertext = c.doFinal(input.getBytes());
	    System.out.println("Input Encrypted: "+new String(ciphertext,"UTF8"));

	    /* Save key to a file */
	    save(sharedKey.getEncoded(),"shared.key");

	    /* Save encrypted data to a file */
	    save(ciphertext,"encrypted.txt");
	} catch (Exception e) {
	    e.printStackTrace();
	}   
	}

	public void decrypt() {
	try {
	    System.out.println("\n \nStart decryption ...");

	    /* Get encoded shared key from file*/
	    byte[] encoded = load("shared.key");
	      SecretKeyFactory kf = SecretKeyFactory.getInstance(ALGO);
	    KeySpec ks = new DESKeySpec(encoded);
	    SecretKey ky = kf.generateSecret(ks);

	    /* Get encoded data */
	    byte[] ciphertext = load("encrypted.txt");
	    System.out.println("Encoded data = " + new String(ciphertext,"UTF8"));

	    /* Create a Cipher object and initialize it with the secret key */
	    Cipher c = Cipher.getInstance(ALGO+"/"+MODE+"/"+PADDING);
	    c.init(Cipher.DECRYPT_MODE,ky);

	    /* Update and decrypt */
	    byte[] plainText = c.doFinal(ciphertext);
	    System.out.println("Plain Text:\n"+new String(plainText,"UTF8"));
	} catch (Exception e) {
	    e.printStackTrace();
	}   
	}

	private String getInputData() {
	    String id = "owner.id=123456";
	    String name = "owner.name= Ramu";
	    String contact = "owner.contact= 8167267055";
	    String tel = "owner.tel= 086345698";
	    final String rc = System.getProperty("line.separator");
	    StringBuffer buf = new StringBuffer();
	    buf.append(id);
	    buf.append(rc);
	    buf.append(name);
	    buf.append(rc);
	    buf.append(contact);
	    buf.append(rc);
	    buf.append(tel);
	    return buf.toString();
	}


	private void save(byte[] buf, String file) throws IOException {
	      FileOutputStream fos = new FileOutputStream(file);
	      fos.write(buf);
	      fos.close();
	}

	private byte[] load(String file) throws FileNotFoundException, IOException {
	    FileInputStream fis = new FileInputStream(file);
	    byte[] buf = new byte[fis.available()];
	    fis.read(buf);
	    fis.close();
	    return buf;
	}

}
