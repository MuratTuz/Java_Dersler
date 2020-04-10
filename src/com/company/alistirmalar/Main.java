package com.company.alistirmalar;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedImage image = ImageIO.read(new File("/image/hsr.jpg"));

        System.out.println( "Yükseklik : %d" + image.getHeight());


    }
}

