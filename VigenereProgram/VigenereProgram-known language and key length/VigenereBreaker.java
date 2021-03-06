import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder sb = new StringBuilder();
        for(int i=whichSlice;i<message.length();i+=totalSlices)
        {
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for(int i=0;i<klength;i++)
        {
            String encrypt = sliceString(encrypted,i,klength);
            int k = cc.getKey(encrypt);
            key[i] = k;
        }
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource();
        String message = fr.asString();
        int[] key = new int[5];
        key = tryKeyLength(message,5,'e');
        VigenereCipher vc = new VigenereCipher(key);
        String output = vc.decrypt(message);
        System.out.println(output);
    }
    
}
