import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        String folderPath = "D:/Thetan_Arena";
        File file = new File(folderPath);
        long start = System.currentTimeMillis();
        FolderSizeCalculater calculater = new FolderSizeCalculater(file);
        ForkJoinPool pool = new ForkJoinPool();
        long size = pool.invoke(calculater);
        System.out.println(size);
        long duration = System.currentTimeMillis() - start;
        System.out.println(duration + " ms");
    }
    /*public static long getFolderSize(File folder){
        long sum = 0;
        if(folder.isFile()){
            return folder.length();
        }
        File[] files = folder.listFiles();
        for(File file : files){
            sum += getFolderSize(file);
        }
        return sum;
    }*/
}
