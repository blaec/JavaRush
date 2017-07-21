package com.javarush.task.task16.task1631;


import com.javarush.task.task16.task1631.common.*;

/**
 * Created by blaec on 31\05\17.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        ImageReader ir = null;
        if (type == ImageTypes.BMP) {
            ir = new BmpReader();
        }
        else if (type == ImageTypes.JPG) {
            ir = new JpgReader();
        }
        else if (type == ImageTypes.PNG) {
            ir = new PngReader();
        }
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");
        return ir;
    }
}
