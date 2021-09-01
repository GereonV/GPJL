package gpjl.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * The {@code Loader} class can load Data from Files.
 * 
 * @param <T> The Data-Type that can be Serialized
 * 
 * @author  Gereon
 * @see     java.io.File
 * @see     java.io.Serializable
 * @since   0.2
 * @version 1.0
 */
public class Loader <T extends Serializable> {

    /**
     * The {@code String} that represents the Directory.
     */
    private String path;

    /**
     * The default Return-Value of Type {@code T}.
     */
    private T defaultValue;


    /**
     * A Short-Form Constructor without a default Return-Value.
     * 
     * @param path The Directory-Path to the Save-Files
     */
    public Loader(String path) {
        this(path, null);
    }

    /**
     * A Constructor for the {@code Loader} that initializes the path and the default Return-Value.
     * 
     * @param path The Directory-Path to the Save-Files
     * @param defaultValue The default Return-Value
     */
    public Loader(String path, T defaultValue) {
        setPath(path);
        setDefaultValue(defaultValue);
    }
    
    /**
     * Sets the Directory-Path.
     * 
     * @param path The Directory-Path to the Save-Files
     */
    public void setPath(String path) {
        if(path.endsWith(File.separator))
            path = path.substring(0, path.length() - 1);
        this.path = path;
    }

    /**
     * Sets the Default-Value.
     * 
     * @param defaultValue The default Return-Value
     */
    public void setDefaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * Loads a {@code T}-Object from a specified File.
     * 
     * @param name The filename including an optional File-Extension
     * @return The Data loaded from the File, or the default Return-Value if anything went wrong
     */
    @SuppressWarnings("unchecked")
    public T load(String name) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + File.separator + name));
            T data = (T) ois.readObject();
            ois.close();
            return data;
        } catch(IOException | ClassNotFoundException e) {
            return defaultValue;
        }
    }

}
