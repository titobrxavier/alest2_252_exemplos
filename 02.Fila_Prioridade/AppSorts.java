import java.util.Random;

public class AppSorts {

    public static void main(String args[]) {
        Random r = new Random();
        for (int max = 500; max < 500000; max += 1000) {
            int[] data = new int[max];
            for (int i = 0; i < data.length; i++)
                data[i] = r.nextInt(data.length * 10);

            //Mergesort s = new Mergesort();
            Quicksort s = new Quicksort();
            //MaxHeap s = new MaxHeap();
            long start = System.nanoTime();
            s.sort(data);
            long end = System.nanoTime();
            double tempo = (end - start) / 1e9; // 1.000.000 (para transformar em ms)
            System.out.printf("%d %.7f\n", max, tempo);
        }
    }
}
