package console.usecases;
import java.io.*;

public class TextFileLogger {
    private final String filePath;
    public TextFileLogger(final String filePath){
        this.filePath = filePath;
    }

    public void logToFile(final Serializable obj) throws IOException {
            final FileOutputStream fileOut  = new FileOutputStream(filePath);
            final ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
    }

    public Object readFromFile() {
        try{
            final FileInputStream fileIn = new FileInputStream(filePath);
            final ObjectInputStream in = new ObjectInputStream(fileIn);
            final Object item = in.readObject();
            in.close();
            fileIn.close();
            return item;
        } catch (final IOException | ClassNotFoundException e) {
            return null;
        }

    }
}
