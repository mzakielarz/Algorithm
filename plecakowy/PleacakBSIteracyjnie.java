package plecakowy;

/* 
 Rozwiazanie decyzyjnego problemu plecakowego
 Metoda brutalnej sily - iteracyjnie (za pomoca petli zagniezdzonych)
*/


public class PleacakBSIteracyjnie
{

  final static int N = 6;                // liczba przedmiotów
  final static int MAX_V = 10;           // objetość plecaka

  final static int[] V = {2,6,3,3,1,2};  // objetości przedmiotów
  final static int[] W = {4,6,5,10,2,7}; // wartości przedmiotów


    public static void main(String[] args)
    {
        int maxW = 0;
        int v, w;
        int b1, b2, b3, b4, b5, b6;
        int[] tab = new int[N]; // tablica na info o przedmiotach w plecaku
        for (b1 = 0; b1 <= 1; b1++)
        {
            for (b2 = 0; b2 <= 1; b2++)
            {
                for (b3 = 0; b3 <= 1; b3++)
                {
                    for (b4 = 0; b4 <= 1; b4++)
                    {
                        for (b5 = 0; b5 <= 1; b5++)
                        {
                            for (b6 = 0; b6 <= 1; b6++)
                            {
                                v = b1 * V[0] + b2 * V[1] + b3 * V[2] +
                                              b4 * V[3] + b5 * V[4] + b6 * V[5];
                                if (v <= MAX_V)
                                {
                                    w = b1 * W[0] + b2 * W[1] + b3 * W[2] +
                                              b4 * W[3] + b5 * W[4] + b6 * W[5];
                                    if (w>maxW)
                                    {
                                        maxW = w;
                                        tab[0] = b1;
                                        tab[1] = b2;
                                        tab[2] = b3;
                                        tab[3] = b4;
                                        tab[4] = b5;
                                        tab[5] = b6;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Wartosc optymalnie zapakowanego plecaka: " + maxW);
        System.out.print("Przedmioty w plecaku: ");
        for (int i = 0; i < N; i++)
        {
            if (tab[i] == 1) System.out.print(i + " ");
        }

        System.out.println();
    }
}
