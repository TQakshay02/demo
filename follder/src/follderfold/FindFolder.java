package follderfold;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FindFolder {

    public static void main(String[] args) {
        // Define the path to your user profile folder on the C drive
        String userProfilePath = System.getProperty("user.home");

        // Create a File object for your user profile folder
        File userProfileFolder = new File(userProfilePath);

        // Get the list of files and folders in your user profile folder
        File[] filesAndFolders = userProfileFolder.listFiles();

        // Define the date you want to check for modifications (e.g., September 10, 2023)
        Date targetDate = new Date(123, 8, 10); // Note: Month is zero-based (0 for January)

        // Create a SimpleDateFormat to format the dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Iterate through the files and folders
        for (File fileOrFolder : filesAndFolders) {
            if (fileOrFolder.isDirectory()) {
                // Get the last modification date of the folder
                long lastModified = fileOrFolder.lastModified();
                Date modifiedDate = new Date(lastModified);

                // Compare the modification date with the target date
                if (dateFormat.format(modifiedDate).equals(dateFormat.format(targetDate))) {
                    // Folder was modified on the target date
                    System.out.println("FolderSSSSSSSSSSSSSSS: " + fileOrFolder.getName() + " was modified on " + dateFormat.format(modifiedDate));
                }
            }
        }
    }
}
