   import java.io.*; 
   class ResztaZachlanny
   {
     public static void main(String[] args) throws IOException
     {
       InputStreamReader str = new InputStreamReader(System.in);
       BufferedReader wejscie = new BufferedReader(str);
       String tekst;
       final int[] M = {500,200,100,50,20,10,5,2,1};
       int zl, gr, r, i = 0;
       System.out.println("Podaj reszte..");
       System.out.print("zlotych: ");
       tekst = wejscie.readLine();
       zl = Integer.parseInt(tekst);
       System.out.print("groszy: ");
       tekst = wejscie.readLine();
       gr = Integer.parseInt(tekst);
       System.out.print("Reszta: ");
       r = zl*100 + gr;
       while (r > 0)
       {
         if (r >= M[i])
         {
           System.out.print(M[i]/100.0 + " ");
           r = r - M[i];
         }
         else
           i++;  
       }
       System.out.println();
     }
   }
