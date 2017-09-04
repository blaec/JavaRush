package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    // Полный путь zip файла
    private final Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        // Проверяем, существует ли директория, где будет создаваться архив
        // При необходимости создаем ее
        Path zipDirectory = zipFile.getParent();
        if (Files.notExists(zipDirectory))
            Files.createDirectories(zipDirectory);

        // Создаем zip поток
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {

            if (Files.isDirectory(source)) {
                // Если архивируем директорию, то нужно получить список файлов в ней
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();

                // Добавляем каждый файл в архив
                for (Path fileName : fileNames)
                    addNewZipEntry(zipOutputStream, source, fileName);

            } else if (Files.isRegularFile(source)) {

                // Если архивируем отдельный файл, то нужно получить его директорию и имя
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else {

                // Если переданный source не директория и не файл, бросаем исключение
                throw new PathIsNotFoundException();
            }
        }
    }

    public List<FileProperties> getFilesList() throws Exception {
        // Проверяем существует ли zip файл
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }

        List<FileProperties> files = new ArrayList<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                // Поля "размер" и "сжатый размер" не известны, пока элемент не будет прочитан
                // Давайте вычитаем его в какой-то выходной поток
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                copyData(zipInputStream, baos);

                FileProperties file = new FileProperties(zipEntry.getName(), zipEntry.getSize(), zipEntry.getCompressedSize(), zipEntry.getMethod());
                files.add(file);
                zipEntry = zipInputStream.getNextEntry();
            }
        }

        return files;
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        Path fullPath = filePath.resolve(fileName);
        try (InputStream inputStream = Files.newInputStream(fullPath)) {
            ZipEntry entry = new ZipEntry(fileName.toString());

            zipOutputStream.putNextEntry(entry);

            copyData(inputStream, zipOutputStream);

            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }

    // https://www.mkyong.com/java/how-to-decompress-files-from-a-zip-file/
    public void extractAll(Path outputFolder) throws Exception {

        // Проверяем существует ли zip файл
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }


        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {

            // Проверяем, существует ли директория
            // При необходимости создаем ее
            if (Files.notExists(outputFolder))
                Files.createDirectories(outputFolder);

            ZipEntry zipEntry;
//            byte[] buffer = new byte[1024];

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {

                // get full file name
                String fileName = zipEntry.getName();
//                File newFile = new File(outputFolder + File.separator + fileName);
                Path fileFullName = outputFolder.resolve(fileName);

                // add non-existing folders
                Path parent = fileFullName.getParent();
                if (Files.notExists(parent))
                    Files.createDirectories(parent);
//            new File(newFile.getParent()).mkdirs();

//                FileOutputStream fos = new FileOutputStream(newFile);
//
//                int len;
//                while ((len = zipInputStream.read(buffer)) > 0) {
//                    fos.write(buffer, 0, len);
//                }
//
//                fos.close();

                try (OutputStream os = Files.newOutputStream(fileFullName)) {
                    copyData(zipInputStream, os);
                }
            }

//            zipInputStream.closeEntry();
//            zipInputStream.close();
        }
    }
}
