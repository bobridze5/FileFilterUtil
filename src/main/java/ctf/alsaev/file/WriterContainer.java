package ctf.alsaev.file;

import ctf.alsaev.file.Interfaces.IWriter;

public class WriterContainer {
    private final IWriter intWriter;
    private final IWriter floatWriter;
    private final IWriter stringWriter;

    public WriterContainer(String path, String prefix, boolean append){
        this.intWriter = new FileWriter(path, prefix, "integers.txt", append);
        this.floatWriter = new FileWriter(path, prefix, "floats.txt", append);
        this.stringWriter = new FileWriter(path, prefix, "strings.txt", append);
    }

    public void write(long value) {
        intWriter.write(String.valueOf(value));
    }

    public void write(double value){
        floatWriter.write(String.valueOf(value));
    }

    public void write(String value){
        stringWriter.write(value);
    }

    public void close(){
        intWriter.close();
        floatWriter.close();
        stringWriter.close();
    }
}
