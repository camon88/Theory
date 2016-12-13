import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CountingWords {

    // State Table
    private final static int [][] STATE_TABLE =
    {
   // c,   i,   r,   s,   t,   u,   other  
   {  1,   6,   10,  15,  0,   0,   0 },    // State 0
   {  1,   6,   2,   15,  0,   0,   0 },    // State 1
   {  1,   6,   10,  15,  0,   3,   0 },    // State 2
   {  1,   6,   10,  4,   0,   0,   0 },    // State 3
   {  1,   6,   10,  15,  5,   0,   0 },    // State 4
   {  1,   17,  19,  14,  0,   0,   0 },    // State 5
   {  1,   6,   7,   15,  0,   0,   0 },    // State 6
   {  1,   8,   10,  15,  0,   11,  0 },    // State 7
   {  1,   6,   7,  9,   0,   0,   0 },    // State 8
   {  1,   6,   10,  15,  16,  0,   0 },    // State 9
   {  1,   6,   10,  15,  0,   11,  0 },    // State 10
   {  1,   6,   10,  12,  0,   0,   0 },    // State 11
   {  1,   6,   10,  15,  13,  0,   0 },    // State 12
   {  1,   17,  19,  14,  0,   0,   0 },    // State 13
   {  1,   6,   10,  15,  16,  0,   0 },    // State 14
   {  1,   6,   10,  15,  16,  0,   0 },    // State 15
   {  1,   17,  19,  15,  0,   0,   0 },    // State 16
   {  1,   6,   18,  15,  0,   0,   0 },    // State 17
   {  1,   8,   10,  15,  0,   11,  0 },    // State 18
   {  1,   20,  10,  15,  0,   11,  0 },    // State 19
   {  21,  6,   7,   15,  0,   0,  0 },    // State 20
   {  1,   6,   2,   15,  22,  0,   0 },    // State 21
   {  1,   6,   10,  15,  0,   0,   0 }     // State 22

      
    };

    // Table constants
    private final static int c_COLUMN   = 0;
    private final static int i_COLUMN   = 1;
    private final static int r_COLUMN   = 2;
    private final static int s_COLUMN   = 3;
    private final static int t_COLUMN   = 4;
    private final static int u_COLUMN   = 5;
    private final static int other_COLUMN   = 6;
   


    // Special states
    private final static int START = 0;
    private final static int crust_ACCEPT = 5;
    private final static int iris_ACCEPT = 9;
    private final static int rusts_ACCEPT = 14;
    private final static int stir_ACCEPT = 18;
    private final static int strict_ACCEPT = 22;



    private BufferedReader in;


    public CountingWords() {
        in = new BufferedReader(
                 new InputStreamReader(System.in));
    }


    public void run() throws IOException {
        int input;
        int state;
        int crustCount = 0;
        int irisCount = 0;
        int rustsCount = 0;
        int stirCount = 0;
        int strictCount = 0;


        input = in.read();
        state = START;
            
        while (input != -1) {
           char ch = (char) input;
           state = STATE_TABLE[state][charToColumn(ch)];
           input = in.read();
           if( state == crust_ACCEPT)
               crustCount++;
           else if( state == iris_ACCEPT)
               irisCount++;
           else if( state == rusts_ACCEPT)
               rustsCount++;
           else if( state == stir_ACCEPT)
               stirCount++;
           else if( state == strict_ACCEPT)
               strictCount++;
        }

        // display counts
        System.out.println("Occurrence counts:");
        System.out.println("crust: " + crustCount);
        System.out.println("iris: "  + irisCount);
        System.out.println("rusts: " + rustsCount);
        System.out.println("stir: " + stirCount);
        System.out.println("strict: " + strictCount);
    }


    public int charToColumn(char ch) {
        int column = other_COLUMN;

        switch( ch ) {
        case 'c':
            column = c_COLUMN;
            break;
        case 'i':
            column = i_COLUMN;
            break;
        case 'r':
            column = r_COLUMN;
            break;

        case 's':
            column = s_COLUMN;
            break;
        case 't':
            column = t_COLUMN;
            break;
        case 'u':
            column = u_COLUMN;
            break;
        }

        return column;
    }


    public static void main(String[] args) {
        try {
            CountingWords cw  = new CountingWords();
            cw.run();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}


