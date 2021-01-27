import java.util.*;

  class tetris2
{
static Scanner scan = new Scanner(System.in);
    static char board[][] = new char[14][17];
    static char shapet[][] = new char[3][3];
    static char square[][] = new char[3][3];
  static char shapel[][] = new char[3][3];
    static char shapei[][] = new char[3][3];
    static char arr[][] = new char[3][3];
    static int row_start=1, col_start=7,rotations=0,moves=0,points=0,flag=0;
    static int rotations_save=0,moves_save=0,points_save=0;
    static char input;
    static String player_name,player_name_save="__";
    public static void clr_scr()
        {
    	    try
            {
    		    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }
            catch(Exception E)
    		{
    			System.out.println(E);
    		}
        }
        static void  score_screen()
        {
          System.out.println(rotations+" "+moves+" "+points);
        }
    public static void gameboard()
    {
        int i,j;
        for(char[] Temp_board : board)
        {
            Arrays.fill(Temp_board, ' ');
        }
        for(i=0;i<14;i++)
        {
            board[i][0] = '|';
            board[i][16] = '|';
        }
        for(j=0;j<17;j++)
        {
            board[0][j] = '-';
            board[13][j] = '-';
        }
    }
public static void tetris_main_logic()
    {
        int i,j,k,l,flag_3;
        int flag_a=0,flag_s=0,flag_d=0;
        char rand_shape[][] = random_shape();
        k=0;
        for(i=1;i<4;i++)
        {
            l=0;
            for(j=7;j<10;j++)
            {
                if(board[i][j]==' ')
                {
                    board[i][j] = rand_shape[k][l];
                    l++;
                }
                else
                {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            {
                break;
            }
            else
            {
                k++;
            }
        }
        if(flag==1)
        {
            clr_scr();
            print_board();
            score_screen();
            System.exit(0);
        }
        print_board();
        while(true)
        {
            flag_3=0;
            for(j=1;j<16;j++)
            {
                if(board[12][j]==' ')
                {
                    flag_3=1;
                    break;
                }
            }
            if(flag_3==0)
            {
                clr_scr();
                for(j=1;j<16;j++)
                {
                    board[12][j] = ' ';
                }
                for(i=11;i>=1;i--)
                {
                    for(j=1;j<16;j++)
                    {
                        board[i+1][j] = board[i][j];
                        board[i][j] = ' ';
                    }
                }
                points++;
                break;
            }
            try
            {

                System.out.println("\t     Points= " + points + "");
                System.out.println("\t     Moves= " + moves + "");
                System.out.println("\t     Rotations= " + rotations + "\n");
                System.out.print("\t     Enter Your Input: ");
                input = scan.nextLine().charAt(0);

            }
            catch(Exception e)
            {
                clr_scr();
                print_board();
                System.out.println("\t----------------------------------------------------------");
                System.out.println("\t    No Input");
                System.out.println("\t---------------------------------------------------------\n");
                continue;
            }
            if(input=='A' || input=='a')
            {
                clr_scr();
                for(i=row_start;i<row_start+3;i++)
                {
                    if(board[i][col_start-1]=='#' || board[i][col_start-1]=='|')
                    {
                        flag_a=1;
                    }
                }
                if(flag_a==1)
                {
                    print_board();
                    System.out.println("\t>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    System.out.println("\t  Invalid Move, Try Again!!");
                    System.out.println("\t>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
                    continue;
                }
                else
                {
                    for(i=row_start;i<row_start+3;i++)
                    {
                        for(j=col_start;j<col_start+3;j++)
                        {
                            board[i][j-1] = board[i][j];
                            board[i][j] = ' ';
                        }
                    }
                    col_start = col_start-1;
                    moves++;
                }
            }
            else if(input=='D' || input=='d')
            {
                clr_scr();
                for(i=row_start;i<row_start+3;i++)
                {
                    if(board[i][col_start+3]=='#' || board[i][col_start+3]=='|')
                    {
                        flag_d=1;
                    }
                }
                if(flag_d==1)
                {
                    print_board();
                    System.out.println("\t___________________________________________________");
                    System.out.println("\t  Invalid Move, Try Again!!");
                    System.out.println("\t___________________________________________________\n");
                    continue;
                }
                else
                {
                    for(i=row_start;i<row_start+3;i++)
                    {
                        for(j=col_start+2;j>=col_start;j--)
                        {
                            board[i][j+1] = board[i][j];
                            board[i][j] = ' ';
                        }
                    }
                    col_start = col_start+1;
                    moves++;
                }
            }
            else if(input=='s' || input=='S')
            {
                clr_scr();
                for(j=col_start;j<col_start+3;j++)
                {
                    if(board[row_start+3][j]=='#' || board[row_start+3][j]=='-')
                    {
                        flag_s=1;
                    }
                }
                if(flag_s==1)
                {
                    break;
                }
                else
                {
                    for(i=row_start+2;i>=row_start;i--)
                    {
                        for(j=col_start;j<col_start+3;j++)
                        {
                            board[i+1][j] = board[i][j];
                            board[i][j] = ' ';
                        }
                    }
                    row_start = row_start+1;
                    moves++;
                }
            }
            else if(input=='q' || input=='Q')
            {
                clr_scr();
                int x=0,y;
                for(i=row_start;i<row_start+3;i++)
                {
                    y=0;
                    for(j=col_start;j<col_start+3;j++)
                    {
                        arr[x][y] = board[i][j];
                        y++;
                    }
                    x++;
                }
                rotate_shape_anti_clk(arr);
                x=0;
                for(i=row_start;i<row_start+3;i++)
                {
                    y=0;
                    for(j=col_start;j<col_start+3;j++)
                    {
                        board[i][j] = arr[x][y];
                        y++;
                    }
                    x++;
                }
                rotations++;
            }
            else if(input=='e' || input=='E')
            {
                clr_scr();
                int x=0,y;
                for(i=row_start;i<row_start+3;i++)
                {
                    y=0;
                    for(j=col_start;j<col_start+3;j++)
                    {
                        arr[x][y] = board[i][j];
                        y++;
                    }
                    x++;
                }
                rotate_shape_clk(arr);
                x=0;
                for(i=row_start;i<row_start+3;i++)
                {
                    y=0;
                    for(j=col_start;j<col_start+3;j++)
                    {
                        board[i][j] = arr[x][y];
                        y++;
                    }
                    x++;
                }
                rotations++;
            }
            else if(input=='z' || input=='Z')
            {
                clr_scr();
            System.exit(0);
            }
            else
            {
                clr_scr();
                print_board();
                System.out.println("\t~~~~~~~~~~~~");
                System.out.println("\t  Invalid Input, Try Again!!");
                System.out.println("\t~~~~~~~~~~~~\n");
                continue;
            }
            print_board();
        }
        row_start=1;
        col_start=7;
        tetris_main_logic();
    }
    static void  print_board()
{
  for(int i=0;i<14;i++)
  {
    System.out.print("\t\t\t\t\t");
  for(int j=0;j<17;j++)
  {
  System.out.printf(board[i][j]+" ");
  }
  System.out.println();
  }
}
public static void shapes1()
    {
        shapet[0][0] = '#';
        shapet[0][1] = '#';
        shapet[0][2] = '#';
        shapet[1][1] = '#';
        shapet[2][1] = '#';
        shapet[1][0] = ' ';
        shapet[2][0] = ' ';
        shapet[1][2] = ' ';
        shapet[2][2] = ' ';
       square[0][0] = '#';
       square[0][1] = '#';
       square[0][2] = '#';
       square[1][0] = '#';
       square[1][1] = '#';
       square[1][2] = '#';
       square[2][0] = '#';
       square[2][1] = '#';
       square[2][2] = '#';
        shapel[0][0] = '#';
        shapel[1][0] = '#';
        shapel[2][0] = '#';
        shapel[2][1] = '#';
        shapel[2][2] = '#';
        shapel[0][1] = ' ';
        shapel[0][2] = ' ';
        shapel[1][1] = ' ';
        shapel[1][2] = ' ';
        shapei[0][1] = '#';
        shapei[1][1] = '#';
        shapei[2][1] = '#';
        shapei[0][0] = '#';
        shapei[1][0] = ' ';
        shapei[2][0] = '#';
        shapei[0][2] = '#';
        shapei[1][2] = ' ';
        shapei[2][2] = '#';
    }
public static char[][] random_shape()
    {
        int range,min,max,rand;
        min = 1;
        max = 5;
        range = max-min+1;
        rand = (int)(Math.random()*range)+min;
        if(rand==1)
        {
            return shapet;
        }
        else if(rand==2)
        {
            return square;
        }
        else if(rand==3)
        {
            return shapel;
        }
        else
        {
            return shapei;
        }
      }
public static void rotate_shape_anti_clk(char mat[][])
    {
        int x,y;
        char temp_1;
        for(x=0;x<3/2;x++)
        {
            for(y=x;y<3-x-1;y++)
            {
                temp_1 = mat[x][y];
                mat[x][y] = mat[y][3-1-x];
                mat[y][3-1-x] = mat[3-1-x][3-1-y];
                mat[3-1-x][3-1-y] = mat[3-1-y][x];
                mat[3-1-y][x] = temp_1;
            }
        }
    }
    public static void  rotate_shape_clk(char mat[][])
        {
            int x,y;
            char temp_2;
            for(x=0;x<3/2;x++)
            {
                for(y=x;y<3-x-1;y++)
                {

                            temp_2 = mat[x][y];
                           mat[x][y] = mat[3 - 1 - y][x];
                           mat[3 - 1 - y][x] = mat[3 - 1 - x][3 - 1 - y];
                           mat[3 - 1 - x][3 - 1 - y] = mat[y][3 - 1 - x];
                           mat[y][3 - 1 - x] = temp_2;
                       }
                   }
                }


public static void main(String arg[])
{

shapes1();
       gameboard();
        tetris_main_logic();
}

}
