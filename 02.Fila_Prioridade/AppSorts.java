import java.util.Random;

public class AppSorts {

    public static void main(String args[]) {
        Random r = new Random();
        Integer[] data = new Integer[101];
        for (int i = 1; i < data.length; i++)
            data[i] = r.nextInt(data.length * 10);
        //Integer[] data = { -1, 15, 1, 3, 30, 8 };
        MaxHeap<Integer> s = new MaxHeap<>(data);
        System.out.println("Antes de ordenar:");
        for(int i=0; i<data.length; i++)
            System.out.print(data[i]+" ");
        System.out.println();
        s.sort();
        System.out.println("Depois de ordenar:");
        for(int i=0; i<data.length; i++)
            System.out.print(data[i]+" ");
        System.out.println();

        // for (int max = 500; max < 500000; max += 1000) {
        //     Integer[] data = new Integer[max];
        //     for (int i = 0; i < data.length; i++)
        //         data[i] = r.nextInt(data.length * 10);

        //     //Mergesort<Integer> s = new Mergesort<>();
        //     Quicksort<Integer> s = new Quicksort<>();
        //     //MaxHeap s = new MaxHeap(data);
        //     long start = System.nanoTime();
        //     s.sort(data);
        //     // s.sort(); // apenas para heapsort
        //     long end = System.nanoTime();
        //     double tempo = (end - start) / 1e9; // 1.000.000 (para transformar em ms)
        //     System.out.printf("%d %.7f\n", max, tempo);
        // }
    }
}
