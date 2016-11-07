/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allpossibleipaddr;






import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllPossibleIPAddr {

    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     *
     * public ArrayList<String> restoreIpAddresses(String s) { // Write your
     * code here }
     */
    public static boolean checkIPValid(String ipstr) {
        
       // System.out.println(ipstr);
        String[] strsplit = ipstr.split("\\.");
        
        for (int i = 0; i < strsplit.length; i++) {
            int octetval = Integer.parseInt(strsplit[i]);
           
            if (octetval >= 0 && octetval <= 255) {

                continue;
            } else {
                return false;
            }

        }
        return true;
    }

    public static void generate_permutation(int length) {

        int sepPoints[] = {0, 0, 0};

        for (int i = 1; i < length; i++) {
            sepPoints[0] = i;
            for (int j = 1; j < length - i; j++) {
                sepPoints[1] = j;
                for (int k = 1; k < length - i - j; k++) {
                    sepPoints[2] = k;

                    System.out.println(": " + sepPoints[0] + ": " + sepPoints[1] + ": " + sepPoints[2]);
                }
            }

        }

    }

    public static void main(String args[]) {

       
        try {
            File dir = new File(".");
            File fin = new File(dir.getCanonicalPath() + File.separator + "input.txt");
            FileInputStream fis = new FileInputStream(fin);
            //InputStreamReader fis = new InputStreamReader(System.in);

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            //BufferedReader br = new BufferedReader(fis);
            String ipaddrStr = null;
            ipaddrStr = br.readLine();
            System.out.println("Ip string" + ipaddrStr);

            //generate_permutation(ipaddrStr.length());
            int sepPoints[] = {0, 0, 0};
            int length = ipaddrStr.length();
            for (int i = 1; i < length; i++) {
                sepPoints[0] = i;
                for (int j = 1; j < length - i; j++) {
                    sepPoints[1] = j;
                    for (int k = 1; k < length - i - j; k++) {
                        sepPoints[2] = k;

                        
                        String ipaddrStrTemp = ipaddrStr.substring(0, sepPoints[0])
                                + "." + ipaddrStr.substring(sepPoints[0],sepPoints[0]+ sepPoints[1])
                                + "." + ipaddrStr.substring(sepPoints[0]+ sepPoints[1], sepPoints[0]+ sepPoints[1]+sepPoints[2])
                                + "." + ipaddrStr.substring(sepPoints[0]+ sepPoints[1]+sepPoints[2], ipaddrStr.length());
                         
                        if (checkIPValid(ipaddrStrTemp)) {
                            System.out.println(": " + sepPoints[0] + ": " + sepPoints[1] + ": " + sepPoints[2]);
                            System.out.println("Ip string" + ipaddrStrTemp);
                        }

                    }
                }

            }

        } catch (IOException f) {
            System.out.println("IO exception");
        }
//
    }
}