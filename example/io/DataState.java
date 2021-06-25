package example.io;

import java.io.Serializable;

import gpjl.io.Loader;
import gpjl.io.Saver;

public class DataState implements Serializable {
    
    public static void main(String[] args) {
        String path = "test";   //directory, either absolute or relative
        String name = "test1.sav";  //file-name
        Saver saver = new Saver(path);  //Saver-Object
        Loader<DataState> loader = new Loader<>(path, new DataState("empty", "this hasn't been loaded"));   //Loader-Object
        saver.save(name, new DataState("Title", "Message"));    //Save a DataState
        System.out.println(loader.load(name));  //Print the loaded DataState
    }

    private String title;
    private String message;

    private DataState(String title, String message) {
        this.title = title;
        this.message = message;
    }

    @Override
    public String toString() {
        return title + "\n" + message;  //called by System.out.println(this);
    }

}
