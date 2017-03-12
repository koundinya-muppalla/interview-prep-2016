package interviews.twitter.io;


public interface OutputWriter {

    void write(String message);
    
    void writeNewLine(String message);
    
    void close();
}
