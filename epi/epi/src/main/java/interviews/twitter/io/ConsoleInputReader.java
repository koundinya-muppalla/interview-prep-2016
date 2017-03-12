package interviews.twitter.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader implements InputReader {

    private final BufferedReader reader;

    public ConsoleInputReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readInput() throws IOException {
        return reader.readLine();
    }

    public void close() throws IOException {
        if(reader != null) {
            reader.close();
        }
    }
}
