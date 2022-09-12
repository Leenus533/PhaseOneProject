import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Arrays;

public class Directory {
    public static String pathName = "directory";
    static Path path = FileSystems.getDefault().getPath(pathName).toAbsolutePath();
    static File dirFiles = path.toFile();

    static public void listFiles(){
        File[] fileList = dirFiles.listFiles();
        assert fileList != null;
        if (fileList.length != 0) {
            Arrays.sort(fileList);
            for (File file : fileList) {
                System.out.println(file.getName());
            }
        }else {
            System.out.println("No files exist yet! Try adding some files");
        }
    }

    static public void addFile(String fileName){
        try{
            File file = new File(path + "/" + fileName);
            if(file.createNewFile()){
                System.out.println("\nSuccessfully created a file");
                System.out.println("File name: " + fileName);
            }else {
                System.out.println("This File Already Exists!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static public void deleteFile(String fileName){
        try{
            File file = new File(path + "/" + fileName);
            if (file.delete()){
                System.out.println("Successfully Deleted the File : " + fileName);
            }else{
                System.out.println("File was not found.");
                System.out.println("Unable to delete file: " + fileName );

            }
        }catch (Exception e){
        throw new RuntimeException(e);
        }
    }

    static public void findFile(String fileName){
        File[] fileList = dirFiles.listFiles();
        assert fileList != null;
        boolean found = false;
        for (File file : fileList) {
            if(file.getName().equals(fileName)){
                System.out.println("File Was Found: " + fileName);
                found = true;
            }
        }
        if (!found){
            System.out.println("File Was Not Found");
        }
    }

}
