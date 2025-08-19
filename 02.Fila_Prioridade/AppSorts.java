import java.util.Random;

public class AppSorts {

    public static void main(String args[]) {
        Random r = new Random();
        for (int max = 500; max < 500000; max += 1000) {
            Integer[] data = new Integer[max];
            for (int i = 0; i < data.length; i++)
                data[i] = r.nextInt(data.length * 10);

            //Mergesort<Integer> s = new Mergesort<>();
            Quicksort<Integer> s = new Quicksort<>();
            //MaxHeap s = new MaxHeap(data);
            long start = System.nanoTime();
            s.sort(data);
            // s.sort(); // apenas para heapsort
            long end = System.nanoTime();
            double tempo = (end - start) / 1e9; // 1.000.000 (para transformar em ms)
            System.out.printf("%d %.7f\n", max, tempo);
        }
    }
}
