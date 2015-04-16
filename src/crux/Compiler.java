package crux;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import crux.Token.Kind;

public class Compiler {
    public static String studentName = "Christian Collosi";
    public static String studentID = "11233529";
    public static String uciNetID = "ccollosi@uci.edu";
	
	public static void main(String[] args)
	{
        String sourceFile = args[0];
        Scanner s = null;
        PrintWriter output = null;

        try {
            s = new Scanner(new FileReader(sourceFile));
            // used this out file to test with diff on the expected testxx.out file
            output = new PrintWriter(new FileWriter("out.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error accessing the source file: \"" + sourceFile + "\"");
            System.exit(-2);
        }

        Token t = s.next();
        while (!(t.is(Kind.EOF))) {
                System.out.println(t);
                output.println(t);
                t = s.next();
                
        }
        System.out.println(t);
        output.println(t);
        output.close();
    }
}
