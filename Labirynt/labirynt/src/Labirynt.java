public class Labirynt {

    public static class Maze {
        char [][] maze =
                {
                        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                        {'1','0','0','0','0','1','1','0','0','0','0','0','0','1','1'},
                        {'1','1','1','1','0','1','1','0','1','1','1','1','0','1','1'},
                        {'1','0','0','0','0','0','0','0','1','1','1','1','0','1','1'},
                        {'1','0','1','0','1','1','1','0','0','0','1','1','0','1','1'},
                        {'0','0','1','0','1','1','1','1','1','1','1','1','0','1','1'},
                        {'1','1','1','0','1','0','1','1','0','0','0','0','0','0','1'},
                        {'1','0','0','0','0','0','1','1','0','1','1','1','1','0','1'},
                        {'1','0','1','1','1','0','1','1','0','1','0','0','0','0','1'},
                        {'1','1','1','1','1','1','1','1','0','1','1','1','1','1','1'}

                };



        boolean [][] czy_byl; int lWierszy,lKolumn;


        public Maze()
        {
            this.lWierszy = maze.length;
            this.lKolumn = maze[0].length;
            czy_byl = new boolean[lWierszy][lKolumn];

            for (int i=0; i<lWierszy; i++)
                for (int j=0; j<lKolumn; j++)
                    czy_byl[i][j] = false;
        }

        void droga()
        {
            System.out.println("/START/");
            System.out.println("       ");
            for (char[] iterator : maze) {

                String slad = "";
                for (int j = 0; j< maze[0].length; j++) {
                    slad = switch (iterator[j]) {
                        case '1' -> slad + "X";
                        case '0' -> slad + " ";
                        default -> slad + iterator[j];
                    };
                }
                System.out.println(slad);

            }
            System.out.println("       ");
            System.out.println("/KONIEC/");
            System.out.println("       ");
        }


        boolean jestNaPozycji(int i, int j) {
            return (i>=0) && (i<lWierszy) && (j>=0) && (j<lKolumn);
        }


        public boolean szukajWyjscia(int i, int j)
        {
            if (!jestNaPozycji(i,j)) return true;
            if (maze[i][j]=='1') return false;
            if (czy_byl[i][j]) return false;
            czy_byl[i][j] = true;
            maze[i][j] = '*';
            if (szukajWyjscia(i,j+1)) { return true;}
            if (szukajWyjscia(i,j-1)) { return true;}
            if (szukajWyjscia(i+1,j)) { return true;}

            if (szukajWyjscia(i-1,j)) {
                return true;
            } else {}
            maze[i][j] = '0';
            return false;
        }

        public void znajdz() {

            boolean czyZnalazl = szukajWyjscia(13, 21);
        }
    }



    public static void main(String[] args) {

        Maze maze1 = new Maze();
        System.out.println("WYNIK działania:");
        maze1.droga();
        maze1.znajdz();
    }

}
