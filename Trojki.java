   class Trojki
   {
     public static void main(String[] args)
     {
       for (int x = 1; x <= 20; x++)
         for (int y = 1; y <= 20; y++)
           for (int z = 1; z <= 20; z++)
             if (x*x + y*y == z*z) System.out.println(x + " " + y + " " + z);
     }
   }