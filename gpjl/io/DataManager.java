package gpjl.io;

import java.io.Serializable;

/**
 * The {@code DataManager} class is an easy-to-use Wrapper for the {@code Loader} and {@code Saver} classes.
 * 
 * @param <T> The Data-Type that can be Serialized
 * 
 * @author  Gereon
 * @see     gpjl.io.Loader
 * @see     gpjl.io.Saver
 * @since   0.2
 * @version 1.0
 */
public class DataManager <T extends Serializable> {

    /**
     * The {@code Loader} that loads Data.
     */
    private Loader<T> loader;

    /**
     * The {@code Saver} that saves Data.
     */
    private Saver saver;


    /**
     * Initializes the Loader and Saver.
     * 
     * @param path The Directory-Path
     */
    public DataManager(String path) {
        loader = new Loader<>(path);
        saver = new Saver(path);
    }


    /**
     * Initializes the Loader and Saver.
     * 
     * @param path The Directory-Path
     * @param defaultValue The default Return-Value
     */
    public DataManager(String path, T defaultValue) {
        loader = new Loader<>(path);
        saver = new Saver(path);
    }

    /**
     * Loads a {@code T}-Object from a specified File.
     * 
     * @param name The filename including an optional File-Extension
     * @return The Data loaded by the Loader {@link gpjl.io.Loader#load(String)} method
     */
    public T load(String name) {
        return loader.load(name);
    }

    /**
     * Saves a {@code T}-Object to a specified File.
     * 
     * @param name The filename including an optional File-Extension
     * @param data The Data to be written to the File
     * @return The Result from Saver's {@link gpjl.io.Saver#save(String, Serializable)} method
     */
    public boolean save(String name, T data) {
        return saver.save(name, data);
    }
    
}
