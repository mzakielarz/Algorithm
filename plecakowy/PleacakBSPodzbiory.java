package plecakowy;

/*
 Rozwiazanie decyzyjnego problemu plecakowego
 Metoda brutalnej sily - przegladanie wszystkich podzbiorow
*/


public class PleacakBSPodzbiory
{
   final static int N = 6;                // liczba przedmiotów
   final static int MAX_V = 10;           // objetość plecaka
   
   final static int[] V = {2,6,3,3,1,2};  // objetości przedmiotów
   final static int[] W = {4,6,5,10,2,7}; // wartości przedmiotów

    public static void main(String[] args)
    {        
        int[] tab = new int[N + 1];
        int[] rozw = new int[N];
        int maxW = 0;
        int s = (int) Math.pow(2, N);
        for (int l = 0; l < s; l++)
        {
            //------------------

            int v = 0;
            for (int k = 0; k < N; k++) v = v + tab[k] * V[k];

            if (v <= MAX_V)
            {
                int w = 0;
                for (int k = 0; k < N; k++) w = w + tab[k] * W[k];

                if (w > maxW)
                {
                    maxW = w;
                    for (int k = 0; k < N; k++) rozw[k] = tab[k];
                }
            }

            //------------------

            int i = 0;
            do
            {
                if (tab[i] == 1)
                {
                    tab[i] = 0;
                    i++;
                }
                else
                {
                    tab[i] = 1;
                    break;
                }
            }
            while (true);
                        
        }

        System.out.println("Wartosc optymalnie zapakowanego plecaka: " + maxW);
        System.out.print("Przedmioty w plecaku: ");
        for (int i = 0; i < N; i++)
        {
            if (rozw[i] == 1) System.out.print(i + " ");            
        }

        System.out.println();
    }

}
