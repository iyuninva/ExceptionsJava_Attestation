package Data.Directory;

import java.io.IOException;

public class GetDirectory {
    public static String PathDirectory() throws IOException {
        String currentPath = new java.io.File(".").getCanonicalPath() + "\\Data\\UserList";
        return currentPath;
    }
    
}
