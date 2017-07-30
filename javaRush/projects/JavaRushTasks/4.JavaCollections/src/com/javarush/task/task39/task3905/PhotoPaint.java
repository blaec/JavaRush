package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int r, int c, Color desiredColor) {
        boolean result = false;

        // proceed if point's within boundaries
        if ( c >= 0 && r >= 0 && c < image.length && r < image[c].length ) {

            // proceed if color's not the same
            if (image[c][r] != desiredColor) {

                // update image
                result = true;
                image[c][r] = desiredColor;
            }
        }

        return result;
    }
}
