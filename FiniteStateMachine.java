
        

// Finite State Machine
// Accepts strings over {a,b} that contain babba, bbba, or aabb.


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FiniteStateMachine {
    private final static int[][] STATE_TABLE = {
        {  1,  5, 12 },
        {  2,  5, 12 },
        {  3,  5, 12 },
        {  3,  4, 12 },
        {  9,  11, 12 },
        {  9,  6, 12 },
        {  7,  6, 12 },
        {  8,  10, 12 },
        {  3,  11, 12 },
        {  2,  10, 12 },
        { 11, 6, 12 },
        { 11, 11, 12 },
        { 12, 12, 12 }
    };

    private BufferedReader in;


    public FiniteStateMachine() {
        in = new BufferedReader(
                 new InputStreamReader(System.in));
    }


    public void run() throws IOException {
        char ch;
        int  state;

        for (;;) {
            System.out.print("Enter your string: ");
            ch    = (char) in.read();
            state = 0;

            while (ch != '\n') {
               state = STATE_TABLE[state][charToColumn(ch)];
               ch    = (char) in.read();
            }

            if (state == 11) {
                System.out.println("Accept\n");
            } else {
                System.out.println("Reject\n");
            }
        }
    }



    public int charToColumn(char ch) {
        int column = 2;

        switch( ch ) {
        case 'a':
            column = 0;
            break;

        case 'b':
            column = 1;
            break;
        }

        return column;
    }


    public static void main(String[] args) {
        try {
            FiniteStateMachine fsm = new FiniteStateMachine();
            fsm.run();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
