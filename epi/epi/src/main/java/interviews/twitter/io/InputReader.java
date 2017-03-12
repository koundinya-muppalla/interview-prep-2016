package interviews.twitter.io;

import java.io.IOException;

public interface InputReader {
    String readInput() throws IOException;
    void close() throws IOException;
}
