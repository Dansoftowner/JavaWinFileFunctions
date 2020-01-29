package com.dansoftware.winfilefunctions;

import com.dansoftware.winfilefunctions.exception.UnsupportedFileFormatException;
import com.dansoftware.winfilefunctions.exception.UnsupportedOperatingSystemException;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileHandler {

    private FileHandler(){
    }

    private static void checkTheSystemAndFileData(File toCheck) throws UnsupportedOperatingSystemException, UnsupportedFileFormatException, FileNotFoundException {
        if (!System.getProperty("os.name").startsWith("Windows"))
            throw new UnsupportedOperatingSystemException("Your os is not supported for this operation!");

        if (!toCheck.exists())
            throw new FileNotFoundException("The file ('" + toCheck.getPath() + "') does not exists!");

        String extension = FilenameUtils.getExtension(toCheck.toString());
        String fileExtensions = "exe bat cmd";
        if (!fileExtensions.contains(extension))
            throw new UnsupportedFileFormatException("This file with this extension: '" + extension + "' is cannot executed by the system!");

    }

    public static void openInExplorer(File file) throws IOException, UnsupportedOperatingSystemException, UnsupportedFileFormatException {
        checkTheSystemAndFileData(file);
        Runtime.getRuntime().exec("explorer.exe /select, \"" + file.getAbsolutePath() + "\"");
    }

    public static void runExecutableFileAsAdmin(File file) throws IOException, UnsupportedOperatingSystemException, UnsupportedFileFormatException {
        checkTheSystemAndFileData(file);

        StringBuilder command = new StringBuilder();
        command.append("powershell.exe ");
        command.append("Start-Process ");
        command.append("\"\\\"");
        command.append(file.getAbsolutePath());
        command.append("\\\"\"");
        command.append(" -Verb runas");

        Runtime.getRuntime().exec(command.toString());
    }

}
