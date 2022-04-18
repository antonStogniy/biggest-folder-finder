import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderSizeCalculater extends RecursiveTask<Long> {
    private File folder;

    public FolderSizeCalculater(File folder) {
        this.folder = folder;
    }

    @Override
    protected Long compute() {
        if (folder.isFile()) {
            return folder.length();
        }
            long sum = 0;
            List<FolderSizeCalculater> subTasks = new LinkedList<>();
            File[] files = folder.listFiles();
            for (File file : files) {
                FolderSizeCalculater task = new FolderSizeCalculater(file);
                task.fork(); // запустим асинхронно
                subTasks.add(task);
            }

            for (FolderSizeCalculater task : subTasks) {
                sum += task.join(); // дождёмся выполнения задачи и прибавим результат
            }

            return sum;
    }
}
