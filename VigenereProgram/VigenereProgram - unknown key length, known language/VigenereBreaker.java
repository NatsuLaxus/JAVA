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
    
    public HashSet<String> readDictionary(FileResource fr)
    {
        HashSet<String> hs = new HashSet<String>();
        for(String s:fr.lines())
        {
            s = s.toLowerCase();
            if(!hs.contains(s))
            {
                hs.add(s);
            }
        }
        return hs;
    }
    
    public int countWords(String msg, HashSet<String> hs)
    {
        int cnt = 0;
        for(String s:msg.split("\\W+"))
        {
            if(hs.contains(s))
            {
                cnt++;
            }
        }
        return cnt;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> hs)
    {
        int max_cnt = 0;
        String ans = "";
        for(int j=1;j<=100;j++)
        {
            int key[] = tryKeyLength(encrypted, j, 'e');
            VigenereCipher vc = new VigenereCipher(key);
            String output = vc.decrypt(encrypted);
            int a = countWords(output, hs);
            if(a > max_cnt)
            {
                max_cnt = a;
                ans = output;
            }
        }
        System.out.println(max_cnt);
        return ans;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource();
        String message = fr.asString();
        FileResource fr2 = new FileResource();
        HashSet<String> hs = readDictionary(fr2);
        String ans = breakForLanguage(message, hs);
        System.out.println(ans);
    }
    
}
