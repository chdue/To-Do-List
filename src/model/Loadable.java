package model;

import java.io.IOException;

public interface Loadable {
    void load(String s1, String s2, String s3) throws IOException, ClassNotFoundException;
}
