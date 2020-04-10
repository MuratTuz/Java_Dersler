package com.company.alistirmalar;

import com.sun.tools.javac.util.ArrayUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ImageProcessing {
	static int[][] invert(int[][] pixels) {
		// implement image inversion (negate all pixels)
        final int width = pixels.length;
        final int height = pixels[0].length;
        try {
            for (int i = 0; i < width ; i++) {
                for (int j = 0; j < height ; j++) {
                    pixels[i][j]= ~pixels[i][j];
                }
            }

        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString(), "Error: ", JOptionPane.INFORMATION_MESSAGE);

        }

        return pixels;
	}
	
	static int[][] rotate(int[][] pixels) {
		// implement image rotation (90 degrees to the right)
        final int width = pixels.length;
        final int height = pixels[0].length;
        int[][] newPixels = new int[height][width];

  /*      String boyut = String.valueOf(newPixels.length) +" "+ String.valueOf(newPixels[0].length);
        JOptionPane.showMessageDialog(null, boyut, "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
*/

        try {
            for (int i = 0; i < width ; i++) {
                for (int j = 0; j < height ; j++) {
                    newPixels[j][width-i-1] = pixels[i][j];
                }
            }

        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString(), "Error: ", JOptionPane.INFORMATION_MESSAGE);

        }

        return newPixels;
	}
	
	static int[][] mirror(int[][] pixels) {
		// implement image mirroring (horizontal, left <-> right)
        final int width = pixels.length;
        final int height = pixels[0].length;
        int[][] newPixels = new int[width][height];

        try {
            for (int i = 0; i < width ; i++) {
                for (int j = 0; j < height ; j++) {
                    newPixels[i][height-j-1] = pixels[i][j];
                }
            }

        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString(), "Error: ", JOptionPane.INFORMATION_MESSAGE);

        }

        return newPixels;
	}
	
	static int[][] gray(int[][] pixels) {
		// optional task (advanced)
        final int width = pixels.length;
        final int height = pixels[0].length;
        try {
            for (int i = 0; i < width ; i++) {
                for (int j = 0; j < height ; j++) {
                    Color c = new Color(pixels[i][j]);
                    int red = (int) (c.getRed() * 0.299);
                    int green = (int) (c.getGreen() * 0.587);
                    int blue = (int) (c.getBlue() * 0.114);
                    Color newColor = new Color(
                            red + green + blue,
                            red + green + blue,
                            red + green + blue);
                    pixels[i][j]=newColor.getRGB();
                }
            }

        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString(), "Error: ", JOptionPane.INFORMATION_MESSAGE);

        }


        return pixels;
	}
}
