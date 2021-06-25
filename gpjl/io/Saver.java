package gpjl.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * The {@code Saver} class can save Data to a File.
 * 
 * @author  Gereon
 * @see     java.io.File
 * @see     java.io.Serializable
 * @since   0.2
 * @version 1.0
 */
public class Saver {
    
    /**
     * The {@code String} that represents the Directory.
     */
    private String path;


    /**
     * A Constructor for the {@code Saver} that initializes the path.
     * 
     * @param path The Directory-Path to the Save-Files
     */
    public Saver(String path) {
        setString(path);
    }

    /**
     * Sets the Directory-Path.
     * 
     * @param path The Directory-Path to the Save-Files
     */
    public void setString(String path) {
        this.path = path;
    }

    /**
     * Saves a {@code T}-Object to a specified File.
     * 
     * @param <T> The Data-Type
     * @param name The filename including an optional File-Extension
     * @param data The Data to be written to the File
     * @return {@code true} if saving was successfull, {@code false} otherwise
     */
    public <T extends Serializable> boolean save(String name, T data) {
        try {
            File dir = new File(path);
            if(!dir.exists())
                dir.mkdirs();   //create Directory
            File f = new File(dir, name);
            f.delete(); //delete already written data
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(data);
            oos.flush();
            oos.close();
            return true;
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
