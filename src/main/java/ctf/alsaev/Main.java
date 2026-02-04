package ctf.alsaev;

import com.beust.jcommander.JCommander;
import ctf.alsaev.cmd.Args;
import ctf.alsaev.file.FileManager;
import ctf.alsaev.file.WriterContainer;
import ctf.alsaev.statistics.fileStatistics;

public class Main {
    public static void main(String[] args) {
        Args pArgs = new Args();
        JCommander jc = JCommander.newBuilder()
                .addObject(pArgs)
                .build();

        jc.parse(args);


        if (pArgs.isHelp()) {
            jc.usage();
        }

        WriterContainer container = new WriterContainer(
                pArgs.getOutputPath(),
                pArgs.getPrefixName(),
                pArgs.isAppendMode()
        );

        FileManager fileManager = new FileManager();

    }
}
