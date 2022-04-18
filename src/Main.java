import java.io.File;

public class Main {
    public static void main(String[] args) {
        String folderPath = "D:/java";
        File file = new File(folderPath);
        System.out.println(getFolderSize(file));
    }
    public static long getFolderSize(File folder){
        long sum = 0;
        if(folder.isFile()){
            return folder.length();
        }
        File[] files = folder.listFiles();
        for(File file : files){
            sum += getFolderSize(file);
        }
        return sum;
    }
}
