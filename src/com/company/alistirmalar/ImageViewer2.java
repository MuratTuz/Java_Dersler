package com.company.alistirmalar;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageViewer2 {
    private static String IMAGE_FILE_NAME = "/Users/itclub/Documents/PROJE_KZO/proje/group-work1/Alistirmalar/src/image/hsr.jpg";
    private BufferedImage image;
    private final JLabel imageLabel;
    private JComboBox comboBox1;

    private ImageViewer2() {
        readInitialImage();
        JFrame frame = new JFrame("Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imageLabel = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(imageLabel, BorderLayout.CENTER);
        JPanel buttonPanel = createButtonPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        SwingUtilities.invokeLater(() -> {
            frame.pack();
            frame.setVisible(true);
        });
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton xButton = new JButton("xButton");
        buttonPanel.add(xButton);
        xButton.addActionListener(event -> classCreate());

        JButton invertButton = new JButton("Invert");
        buttonPanel.add(invertButton);
        invertButton.addActionListener(event -> apply(ImageProcessing::invert));
        JButton rotateButton = new JButton("Rotate");
        buttonPanel.add(rotateButton);
        rotateButton.addActionListener(event -> apply(ImageProcessing::rotate));
        JButton mirrorButton = new JButton("Mirror");
        buttonPanel.add(mirrorButton);
        mirrorButton.addActionListener(event -> apply(ImageProcessing::mirror));
        JButton grayButton = new JButton("Gray");
        buttonPanel.add(grayButton);
        grayButton.addActionListener(event -> apply(ImageProcessing::gray));
        JButton resetButton = new JButton("Reset");
        buttonPanel.add(resetButton);
        resetButton.addActionListener(event -> {
            readInitialImage();
            updateImage();
        });
        return buttonPanel;
    }

    public void classCreate(){
       RecursiveSum rec = new RecursiveSum();
       rec.getId();
        JOptionPane.showMessageDialog(null, String.valueOf(rec.getId()), "Bilgi: ", JOptionPane.INFORMATION_MESSAGE);
    }

    @FunctionalInterface
    private interface ImageFilter {
        int[][] process(int[][] pixels);
    }

    private void apply(ImageFilter filter) {
        image = createImage(filter.process(extractImage(image)));
        updateImage();
    }

    private void updateImage() {
        imageLabel.setIcon(new ImageIcon(image));
    }

    private void readInitialImage() {
        try {
            image = ImageIO.read(new File(IMAGE_FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int[][] extractImage(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        int[][] pixels = new int[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[y][x] = image.getRGB(x, y);
            }
        }
        return pixels;
    }

    private BufferedImage createImage(int[][] pixels) {
        int height = pixels.length;
        int width = pixels[0].length;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setRGB(x, y, pixels[y][x]);
            }
        }
        return image;
    }

    public static void main(String[] args) {
        new ImageViewer2();
    }
}
