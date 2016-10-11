/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcslength;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author sdhandap
 */
public class LCSlength {

//                      lcs("AXYT", "AYZX")
//                       /                 \
//         lcs("AXY", "AYZX")            lcs("AXYT", "AYZ")
//         /            \                  /               \
//lcs("AX", "AYZX") lcs("AXY", "AYZ")   lcs("AXY", "AYZ") lcs("AXYT", "AY")
       
                      /* string str1 and compariing from m to length -1*/
    public static int findLCSlen(String str1, String str2, int m, int n) {
        
        
        if(str1.length() == m || str2.length() == n){
            return 0;
        }
        else
        {
            if(str1.charAt(m) == str2.charAt(n)){
                System.out.println("match"+str1.charAt(m));
                return (1+ findLCSlen(str1,  str2,  m+1, n+1));
            }
            else
            {
                return Math.max(findLCSlen(str1, str2, m, n+1) , findLCSlen(str1,str2, m+1,n));
            }
            
           
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
                
                String inputStr[] = line.split(" ");
                System.out.println(inputStr[0]);
                  System.out.println(inputStr[1]);
                  System.out.println(findLCSlen(inputStr[0], inputStr[1], 0, 0));
           
                
            }
        }catch (IOException    f)
        {
            System.out.println("IO exception");
        }
    }
    
}
