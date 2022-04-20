package textsummary;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author fahry
 */
public class FileHandler {
    
    public FileHandler(){}
    
    public static List<String> readFile(String filePath){
        
        List<String> lines = null;
        
        Path sourceFile = Paths.get(filePath);
        Charset charset = Charset.forName("ISO-8859-1");
        
        
        
        try{
            lines = Files.readAllLines(sourceFile, charset);
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        return lines;
    }
}
