import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SleepDepMachine {
    private final static int[][] STATE_TABLE = {
//         1   4  9
        {  1,  2, 3 }, // A(0)
        {  4,  6, 5 }, // B(1)
        {  6,  5, 4 }, // C(2)
        {  5,  4, 6 }, // D(3)
        {  4,  6, 5 }, // E(Out1) - 4
        {  6,  5, 4 }, // F(Out4) - 5 
        {  5,  4, 6 }, // G(Out9) - 6
    };

    private BufferedReader in;


    public SleepDepMachine() {
        in = new BufferedReader(
                 new InputStreamReader(System.in));
    }


    public void run() throws IOException {
        char ch;
        int  state;

        for (;;) {
            System.out.print("Enter a string of containing the digits of"
            + " only 1, 4 or 9: ");
            ch    = (char) in.read();
            state = 0;

            while (ch != '\n') {
               state = STATE_TABLE[state][charToColumn(ch)];
               ch    = (char) in.read();
            }
            

            if (state == 4) {
                System.out.println("1\n");
            }
           else if (state == 5) {
                System.out.println("4\n");
            }
           else if (state == 6) {
                System.out.println("9\n");
            }
           else {
                System.out.println("Does not include 1,4 or 9. Please enter numbers 1, 4 or 9.\n");
            }
        }
   } 



    public int charToColumn(char ch) {
        int column = 0;

        switch( ch ) {
        case '1':
            column = 0;
            break;

        case '4':
            column = 1;
            break;

        case '9':
            column = 2;
            break;
        }


        return column;
    }


    public static void main(String[] args) {
        try {
            SleepDepMachine sdm = new SleepDepMachine();
            sdm.run();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}

