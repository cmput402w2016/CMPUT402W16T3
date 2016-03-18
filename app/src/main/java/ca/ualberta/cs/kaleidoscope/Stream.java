package ca.ualberta.cs.kaleidoscope;

import java.net.URI;
import java.util.ArrayList;

/**
 * Created by timotei on 17-Mar-2016.
 */
public class Stream {
    public String name;
    public String location;
    public URI address;

    public Stream(String name, String location) {
        this.setName(name);
        this.setLocation(location);
    }

    public static ArrayList<Stream> getStreams() {
        ArrayList<Stream> streams = new ArrayList<>();
        streams.add(new Stream("Stream 1 :", "SUB"));
        streams.add(new Stream("Stream 2 :", "CAB"));
        streams.add(new Stream("Stream 3 :", "CSC"));
        return streams;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URI getAddress() {
        return address;
    }

    public void setAddress(URI address) {
        this.address = address;
    }
}
