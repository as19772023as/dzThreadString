import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//       int x = Runtime.getRuntime().availableProcessors(); // сколько возможных max поктоков в системе
//        System.out.println(x);

        String[] texts = new String[25];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("aab", 30_000);
        }

        List<Future> futureList = new ArrayList<>();
        int maxValue = 0;
        final ExecutorService threadPoll = Executors.newFixedThreadPool(3);

        long startTs = System.currentTimeMillis(); // start time

        for (String text : texts) {
            futureList.add(threadPoll.submit(new CollableTask(text)));
        }

        for (Future future : futureList) {
            maxValue = Math.max((int) future.get(), maxValue);
        }
        System.out.println(maxValue);
        threadPoll.shutdown();

        long endTs = System.currentTimeMillis();
        System.out.println("Time: " + (endTs - startTs) + ".");
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}

