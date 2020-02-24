// Finite State Machine
// Counts the number of occurrences of 5 words: 
// Cheetah, Hatch, Teach, Cheat, Ache
package solution;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SydneyMageeP2 {

   private static final int cheetahACCEPT = 7;  
   private static final int hatchACCEPT = 12;  
   private static final int teachACCEPT = 17;  
   private static final int cheatACCEPT = 19;
   private static final int acheACCEPT = 23;  

   //   C  H  E   T   A  ?
   private static final int[][] STATE_TABLE = {
       {1, 8, 0, 13, 20, 0}, // state 0
       {1, 2, 0, 13, 20, 0}, // state 1:  c
       {1, 8, 3, 13, 9, 0}, // state 2:  ch
       {1, 8, 4, 13, 18, 0}, // state 3:  che
       {1, 8, 0, 5, 20, 0}, // state 4:  chee
       {1, 8, 14, 13, 6, 0}, // state 5:  cheet
       {21, 7, 0, 13, 20, 0}, // state 6:  cheeta
       {1, 8, 0, 13, 9, 0}, // state 7: cheetah
       {1, 8, 0, 13, 9, 0}, // state 8: h
       {1, 8, 0, 10, 20, 0}, // state 9: ha
       {11, 8, 14, 13, 20, 0}, // state 10: hat
       {1, 12, 0, 13, 20, 0}, // state 11: hatc
       {1, 8, 3, 13, 9, 0}, // state 12: hatch
       {1, 8, 14, 13, 20, 0}, // state 13: t
       {1, 8, 0, 13, 15, 0}, // state 14: te 
       {16, 8, 0, 13, 20, 0},  // state 15: tea
       {1, 17, 0, 13, 20, 0}, // state 16: teac 
       {1, 8, 23, 13, 9, 0}, // state 17: teach
       {21, 8, 0, 19, 20, 0}, // state 18: chea
       {1, 8, 14, 13, 20, 0},   // state 19: cheat
       {21, 8, 0, 13, 20, 0},  // state 20: a
       {1, 22, 0, 13, 20, 0},  // state 21: ac
       {1, 8, 23, 13, 20, 0}, // state 22: ach
       {1, 8, 4, 13, 18, 0}  // state 23: ache
   };

    private BufferedReader in;
    private int cheetahCount; 
    private int hatchCount;
    private int teachCount;
    private int cheatCount;
    private int acheCount;


    public SydneyMageeP2(String filename) throws IOException {
        in = new BufferedReader(
                 new FileReader(filename));
       cheetahCount = 0; 
       hatchCount = 0;
       teachCount = 0;
       cheatCount = 0;
       acheCount = 0;
    }

    public void run() throws IOException {
        char ch;
        int unicode;
        int state = 0;

        unicode = in.read();
        while (unicode != -1) {
           ch    = (char) unicode;
           state = STATE_TABLE[state][charToColumn(ch)];
           if (state == cheetahACCEPT) {
              cheetahCount++;}
           if (state == hatchACCEPT){ 
              hatchCount++;}
           if (state == teachACCEPT){ 
              teachCount++;}
           if (state == cheatACCEPT){ 
              cheatCount++;}
           if (state == acheACCEPT){
               acheCount++;}
           unicode = in.read();
        }
        
        System.out.println( "Occurrence counts: ");
        System.out.println( "cheetah count is " + cheetahCount);
        System.out.println( "hatch    count is " + hatchCount);
        System.out.println( "teach    count is " + teachCount);
        System.out.println( "cheat    count is " + cheatCount);
        System.out.println( "ache     count is " + acheCount);
    }

    public int charToColumn(char ch) {
        if (ch == 'C' || ch == 'c') 
           return 0;
        if (ch == 'H' || ch == 'h') 
           return 1;
        if (ch == 'E' || ch == 'e') 
           return 2;
        if (ch == 'T' || ch == 't') 
           return 3;
        if (ch == 'A' || ch == 'a') 
           return 4;
        return 5;
    }

    public static void main(String[] args) {
        if (args.length < 1)
           System.out.println 
                ("Run again, entering a filename at the commandline");
        else {
           try {
               SydneyMageeP2 fsm = new SydneyMageeP2(args[0]);
               fsm.run();
           } catch (IOException ex) {
               ex.printStackTrace();
               System.exit(1);
           }
       }
    }
}
