// ISTO NÃO É HEAPSORT, é "outra coisa"
// (dá para dizer que é uma forma de usar um maxheap
// para ordenar um vetor, mas não da melhor forma!)

public class SortWithHeap {

    public static void main(String[] args) {
        MaxHeap<Integer> h = new MaxHeap<>(11);
        int[] v = { 5, 9, 12, 8, 32, 1, 44, 22, 0, 31 };

        for (int valor : v)
            h.put(valor);

        for (int i = v.length - 1; i >= 0; i--)
            v[i] = h.get();

        for (int valor : v)
            System.out.print(valor + " ");
        System.out.println();
    }
}
