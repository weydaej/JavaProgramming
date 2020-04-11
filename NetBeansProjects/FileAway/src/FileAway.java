/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.nio.file.Path;

/**
 *
 * @author weydaej
 */
public class FileAway {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src\\test.txt");    
        System.out.println(target);
        
    }
}
