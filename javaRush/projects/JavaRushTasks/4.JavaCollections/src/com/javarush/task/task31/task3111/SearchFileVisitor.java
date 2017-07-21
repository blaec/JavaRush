package com.javarush.task.task31.task3111;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if ((minSize == 0 || Files.size(file) >= minSize) && (maxSize == 0 || Files.size(file) <= maxSize)) {
                if (partOfName == null || file.getFileName().toString().contains(partOfName)) {
                    if (partOfContent == null) {
                        foundFiles.add(file);
                    } else {
                        String string = new String(Files.readAllBytes(file));
                        if (string.contains(partOfContent)) {
                            foundFiles.add(file);
                        }
                    }
                }
            }
            return super.visitFile(file, attrs);
        }

//
//
//    @Override
//    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//        boolean hasContent = false;
//        boolean hasName;
//        boolean matchSize;
//
//        if (partOfName != null) {
//            hasName = String.valueOf(file.getFileName()).contains(partOfName);
//        }
//        else
//            hasName = false;
//
//        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(file)));
//            while (reader.ready()) {
//                String line = reader.readLine();
//                if (line.contains(partOfContent)) {
//                    hasContent = true;
//                    break;
//                }
//            }
//        reader.close();
//
//
//        matchSize = attrs.size() > minSize && attrs.size() < maxSize;
//
//        if (hasContent && hasName && matchSize) {
//            foundFiles.add(file);
//        }
//
//        return super.visitFile(file, attrs);
//    }
}
