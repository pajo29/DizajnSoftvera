package installationSimulation;

import net.jimmc.jshortcut.JShellLink;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Install
{
    private static Install instance = null;

    private Install()
    {

    }

    public void copyToDestination(String installPath, String productURL, String fileName)
    {
        Path source = Paths.get(productURL);
        Path destination = Paths.get(installPath + File.separatorChar + fileName);

        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createDesktopShortcut(String productURL, String fileName)
    {
        try {

            JShellLink link = new JShellLink();
            link.setFolder(JShellLink.getDirectory("desktop"));
            link.setName(fileName);
            link.setPath(productURL);
            link.save();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void startAfterUse(String productURL, String fileName)
    {
        try
        {
            Process process = Runtime.getRuntime().exec(productURL + File.separatorChar + fileName);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static Install getInstance()
    {
        if(instance == null) instance = new Install();
        return instance;
    }
}
