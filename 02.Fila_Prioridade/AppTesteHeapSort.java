import java.util.Random;

public class AppTesteHeapSort {

    public static void main(String args[]) {
        Random r = new Random();
        Integer[] data = new Integer[201];
        for (int i = 1; i < data.length; i++)
            data[i] = r.nextInt(data.length * 10);
        //Integer[] data = { -1, 15, 1, 30, 12, 50, 12, 39,78};
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
    }
}
