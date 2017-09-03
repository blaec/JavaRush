package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {

        // create folder if not exist
        Path folder = zipFile.getParent();
        if (!Files.exists(folder))
            Files.createDirectories(folder);
//            new File(folder.toString()).mkdir();

        ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));

        if (Files.isRegularFile(source))
            addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
        else if (Files.isDirectory(source)) {
            FileManager fileManager = new FileManager(source);
            List<Path> fileNames = fileManager.getFileList();
            for (Path fileName : fileNames) {
                addNewZipEntry(zipOutputStream, source, fileName);
            }
        }
        else
            throw new PathIsNotFoundException();

        zipOutputStream.close();
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        InputStream inputStream = Files.newInputStream(filePath.resolve(fileName));
        ZipEntry zipEntry = new ZipEntry(fileName.toString());
        zipOutputStream.putNextEntry(zipEntry);

        copyData(inputStream, zipOutputStream);

        try {
            inputStream.close();
            zipOutputStream.closeEntry();
//            zipOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        while (in.available() > 0) {
            byte[] buffer = new byte[in.available()];
            int count = in.read(buffer);
            out.write(buffer, 0, count);
        }
    }


}