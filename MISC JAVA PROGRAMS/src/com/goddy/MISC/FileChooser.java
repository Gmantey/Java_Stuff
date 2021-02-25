package com.goddy.MISC;

import javax.swing.*;
import java.io.File;

public class FileChooser {
    public static void main(String[] args) {
        System.out.println("Hello Guy");
        JFileChooser  fc = new JFileChooser();
        fc.setDialogTitle("Choose Important File");
        int val = fc.showOpenDialog(null);
        System.out.println(val);

        File f = fc.getSelectedFile();
        System.out.println(f);
    }
}
