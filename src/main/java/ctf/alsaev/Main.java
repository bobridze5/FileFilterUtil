package ctf.alsaev;

import com.beust.jcommander.JCommander;
import ctf.alsaev.cmd.Args;
import ctf.alsaev.file.FileManager;

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

        FileManager fileManager = new FileManager(pArgs.getPaths());
        fileManager.process();
    }
}
