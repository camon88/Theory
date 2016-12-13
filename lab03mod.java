import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class lab03mod {
    private final static int[][] STATE_TABLE = {
        {  1,  3, 4 },
        {  2,  0, 4 },
        {  3,  1, 4 },
        {  0,  2, 4 },
        {  4,  4, 4 },
    };

    private BufferedReader in;


    public lab03mod() {
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

            if (state == 0) {
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
            lab03mod lab3 = new lab03mod();
            lab3.run();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
