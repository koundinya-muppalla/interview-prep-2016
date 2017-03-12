package interviews.twitter.io;

import java.io.PrintStream;

public class ConsoleOutputWriter implements OutputWriter {

    private final PrintStream outStream;

    public ConsoleOutputWriter() {
        outStream = new PrintStream(System.out);
    }

    public void write(String message) {
        outStream.print(message);
    }

    public void writeNewLine(String message) {
        outStream.println(message);
    }
    
    public void close() {
        if(outStream != null) {
            outStream.close();
        }
    }
}
