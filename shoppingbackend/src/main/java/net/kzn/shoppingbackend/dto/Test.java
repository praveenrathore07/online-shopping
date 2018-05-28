package net.kzn.shoppingbackend.dto;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.  */
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();                 // Reading input from STDIN
        BigInteger big;
        
        for (int i=0;i<testCases;i++) {
            String str = s.nextLine();
            String[] strArr = str.split(" ");
            String s1 = strArr[0];
            String s2 = strArr[1];
            char[] s1Arr = s1.toCharArray();
            char[] s2Arr = s2.toCharArray();
            Arrays.sort(s1Arr);
            Arrays.sort(s2Arr);
            
            String b= new String(s1Arr);
            String c= new String(s2Arr);
            if (b.equals(c)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            
        }

    }
}
