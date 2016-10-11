
package permutationgen;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author sdhandap
 */
public class PermutationGen {

  
    public static void permuteGen(String inStr, int pos){
        char stringtokens[] = inStr.toCharArray();
        
      
        if(pos >= stringtokens.length){
            System.out.println(inStr);
            return;
        }
        for(int i = pos; i < stringtokens.length; i++) {
            char tempch = stringtokens[pos];
            stringtokens[pos] =stringtokens[i];
            stringtokens[i] = tempch;
   
            permuteGen(new String(stringtokens), pos+1);
        }
        
        
        
    }
    
    public static void iterativePermute(String inStr) {
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            File dir = new File(".");
            //File fin = new File(dir.getCanonicalPath() + File.separator + "in.txt");
            //FileInputStream fis = new FileInputStream(fin);
            InputStreamReader fis = new InputStreamReader(System.in);


            //BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            BufferedReader br = new BufferedReader(fis);
            String line = null;
            line = br.readLine();
            int numlines = Integer.parseInt(line);
            int count = 0;
            while ((line = br.readLine()) != null) {
                
                permuteGen(line, 0);
                
            }
        }catch (IOException    f)
        {
            System.out.println("IO exception");
        }


    }
    
}
