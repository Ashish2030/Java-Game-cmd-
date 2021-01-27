import java.awt.Font;
import java.awt.event.KeyEvent;
import java.applet.Applet;
import java.lang.Math;
import java.io.*;
import java.util.Scanner;
class snakegamewithwall123
{
static int a,b,c,d,score=0,flag=0,h,b1, x,y,z1,z2,flag11=0,heighscore=0;
static char e;
static int x1,y1,x2,y2,x3,y3,x4,y4;
 static  char[][] array=new char [30][30];
 static int[] array_row=new int [100];
  static int[] array_col=new int [100];
  static int head_row,size=2;
  static int head_col;
  static boolean gameover=true;
  static  String playername,highscoreplayername;
//-------------------------------------------------------- clear screen----------------------------------------------------------------------
public static void cls()
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

//-------------------------------------------------------- array ----------------------------------------------------------------------
 public  void makearray()
{
       for(int i=0;i<30;i++)
         {
        for(int j=0;j<30;j++)
        {
           array[i][j]=' ';
        }
        }
    //-------------------------------------------------------border----------------------------------------------------------------------------------------
         for(int i=0;i<30;i++)
        {
        array[i][0]='|';
        array[i][29]='|';
        }
        for(int j=0;j<30;j++)
        {
        array[29][j]='=';
        array[0][j]='=';
       }
    //-------------------------------------------------------border----------------------------------------------------------------------------------------       //-------------------------------------------------------WALL----------------------------------------------------------------------------------------
    array[22][1]='W';
       array[22][2]='W';
         array[22][3]='W';
        array[22][4]='W';
        array[22][5]='W';
       array[22][6]='W';
       array[22][7]='W';
       array[22][8]='W';

         array[22][9]='W';
         array[16][9]='W';
           array[17][9]='W';
          array[18][9]='W';
            array[19][9]='W';
                array[20][9]='W';
                array[21][9]='W';
               array[22][9]='W';
              array[5][1]='W';
                   array[5][2]='W';
                 array[5][3]='W';
                     array[5][4]='W';
                        array[5][5]='W';
                           array[5][6]='W';
                           array[5][7]='W';
                           array[6][7]='W';
                          array[7][7]='W';
                         array[8][7]='W';
                     array[9][7]='W';
                        array[25][18]='W';
                       array[24][18]='W';
                               array[23][18]='W';
                          array[22][18]='W';
                         array[21][18]='W';
                           array[20][18]='W';
                             array[19][18]='W';
                           array[18][18]='W';
                              array[17][18]='W';
                        array[16][18]='W';
                            array[16][19]='W';
                             array[16][20]='W';
                             array[16][21]='W';
                              array[16][22]='W';
                             array[16][23]='W';
                             array[16][24]='W';
                              array[3][18]='W';
                             array[4][18]='W';
                             array[5][18]='W';
                             array[6][18]='W';
                                array[7][18]='W';
                              array[8][18]='W';
                            array[9][18]='W';
                               array[9][19]='W';
                         array[9][20]='W';
                           array[9][21]='W';
                          array[9][22]='W';
                            array[9][23]='W';
                        array[9][24]='W';
                        array[21][13]='W';
                          array[20][13]='W';
                            array[19][13]='W';
                              array[18][13]='W';
                                array[17][13]='W';

                        array[16][13]='W';
                        array[16][14]='W';
                          array[16][15]='W';
                            array[15][15]='W';
                              array[14][15]='W';
                              array[13][15]='W';
                              array[12][15]='W';
                              array[11][15]='W';
                              array[12][1]='W';
                                array[12][2]='W';
                                  array[12][3]='W';
                                    array[12][4]='W';
                                      array[12][5]='W';
                                        array[12][6]='W';
                                        array[13][6]='W';
                                          array[14][6]='W';
                                            array[15][6]='W';
                                              array[16][6]='W';
                                                array[17][6]='W';
                                  array[26][25]='W';
                                      array[25][25]='W';
                                          array[24][25]='W';
                                              array[23][25]='W';
                                              array[22][25]='W';
                                                array[21][25]='W';
                                                array[2][11]='W';
                                                  array[3][11]='W';
                                                    array[4][11]='W';
                                                      array[5][11]='W';
                                                        array[6][11]='W';
                                                          array[7][11]='W';
                                                            array[7][12]='W';
                                                              array[7][13]='W';
                                                                array[7][14]='W';
                                                                  array[7][15]='W';
                                                                    array[27][11]='W';
                                                                        array[27][12]='W';
                                                                            array[27][13]='W';
                                                                                array[27][14]='W';
                                                                                    array[27][15]='W';
                                                                                        array[27][16]='W';
                                                                                          array[26][16]='W';
                                                                                            array[25][16]='W';
                                                                                              array[24][16]='W';
                                                                                                array[23][16]='W';

  //------------------------------------------------------------------------------------WALL----------------------------------------------------------------------
}
static void print1()
{
  cls();
 for (int i = 29; i >=0; i--)
              {
              for (int j = 0; j < array[i].length; j++)
               {
               System.out.print(array[i][j]+" ");
               }
             System.out.println();
             }

}
//--------------------------------------------------------------------------fruit--------------------------------------------------------------------------
static  void fruit()
{
 a=rollDice();
 b=rollDice();
if(array[a][b]!='W')
{
array[a][b]='F';
}
else
{
fruit();
}
}
//------------------------------------------------------------------------fruit-----------------------------------------------------------------------
//---------------------------------------------------------------random function--------------------------------------------------------------------
       static int rollDice()
        {
        int range,min,max,rand;
        min = 1;
        max = 28;
        range = max-min+1;
        rand = (int)(Math.random()*range)+min;
        return rand;
         }
//---------------------------------------------------------------random function--------------------------------------------------------------------
//----------------------------------------------------------------take input-------------------------------------------------------------------------
public void input()
{
Scanner sc=new Scanner(System.in);
 e=sc.nextLine().charAt(0);
switch(e)
{
  case 'a':
  {
    flag=1;
    break;
  }
  case 'A':
  {
    flag=1;
    break;
  }
  case 's':
  {
    flag=2;
    break;
  }
  case 'S':
  {
    flag=2;
    break;
  }
  case 'w':
  {
    flag=3;
    break;
  }
  case 'W':
  {
    flag=3;
    break;
  }

  case 'd':
  {
    flag=4;
    break;
  }
  case 'D':
  {
    flag=4;
    break;
  }
  case 'q':
  {
    gameover=false;
    break;
  }
  default :
  {
     break;
  }
}
}
//---------------------------------------------------------------------snakemove---------------------------------------------------------------------------
public void logic()
{
  switch(flag)
  {
     case 4:
     {
       if( array[head_row][head_col+1]=='x')
       {
          System.out.println("GAMEOVER");
         gameover=false;
         break;
       }
        if( array[head_row][head_col+1]=='F')
          {
             score++;
             fruit();
             array[head_row][head_col+1]=array[head_row][head_col];
             y=head_col;
             x=head_row;
             for( int i=0;i<size;i++)
             {
                    array[x][y]=array[array_row[i]][array_col[i]];
                    z1=x;
                    z2=y;
                    x=array_row[i];
                    y=array_col[i];
                    array_row[i]=z1;
                      array_col[i]=z2;
               }
               array[x][y]='x';
                 size++;
               array_row[size-1] = x;
                array_col[size-1] = y;
               head_col= head_col+1;
             break;
        }
      else
      {
       array[head_row][head_col+1]=array[head_row][head_col];
       y=head_col;
       x=head_row;
       for( int i=0;i<size;i++)
       {
              array[x][y]=array[array_row[i]][array_col[i]];
              z1=x;
              z2=y;
              x=array_row[i];
              y=array_col[i];
              array_row[i]=z1;
                array_col[i]=z2;
       }
       array[x][y]=' ';
       head_col= head_col+1;
       break;
     }
  }
     case 3:
     if( array[head_row+1][head_col]=='x')
     {
        System.out.println("GAMEOVER");
       gameover=false;
       break;
     }
     if( array[head_row+1][head_col]=='F')
     {
        array[head_row+1][head_col]=array[head_row][head_col];
        score++;
        fruit();
        y=head_col;
        x=head_row;
        for( int i=0;i<size;i++)
        {
               array[x][y]=array[array_row[i]][array_col[i]];
               z1=x;
               z2=y;
               x=array_row[i];
               y=array_col[i];
               array_row[i]=z1;
                 array_col[i]=z2;
          }
          array[x][y]='x';
         size++;
          array_row[size-1] = x;
           array_col[size-1] = y;
          head_row= head_row+1;
        break;
   }
   else
     {
       array[head_row+1][head_col]=array[head_row][head_col];
       y=head_col;
       x=head_row;
       for( int i=0;i<size;i++)
       {
              array[x][y]=array[array_row[i]][array_col[i]];
              z1=x;
              z2=y;
              x=array_row[i];
              y=array_col[i];
              array_row[i]=z1;
                array_col[i]=z2;
         }
       array[x][y]=' ';
       head_row= head_row+1;
       break;
     }
     case 2:
     if( array[head_row-1][head_col]=='x')
     {
          System.out.println("GAMEOVER");
       gameover=false;
       break;
     }
     if( array[head_row-1][head_col]=='F')
     {
        score++;
        fruit();
        array[head_row-1][head_col]=array[head_row][head_col];
        y=head_col;
        x=head_row;
        for( int i=0;i<size;i++)
        {
               array[x][y]=array[array_row[i]][array_col[i]];
               z1=x;
               z2=y;
               x=array_row[i];
               y=array_col[i];
               array_row[i]=z1;
                 array_col[i]=z2;
          }
          array[x][y]='x';
       size++;
          array_row[size-1] = x;
           array_col[size-1] = y;
          head_row= head_row-1;
        break;
   }
   else
     {
       array[head_row-1][head_col]=array[head_row][head_col];
       y=head_col;
       x=head_row;
       for( int i=0;i<size;i++)
       {
              array[x][y]=array[array_row[i]][array_col[i]];
              z1=x;
              z2=y;
              x=array_row[i];
              y=array_col[i];
              array_row[i]=z1;
                array_col[i]=z2;

       }
       array[x][y]=' ';
       head_row= head_row-1;
       break;
     }
     case 1:
     if( array[head_row][head_col-1]=='x')
     {
        System.out.println("GAMEOVER");
       gameover=false;
       break;
     }
       if( array[head_row][head_col-1]=='F')
       {
          score++;
          fruit();
          array[head_row][head_col-1]=array[head_row][head_col];
          y=head_col;
          x=head_row;
          for( int i=0;i<size;i++)
          {
                 array[x][y]=array[array_row[i]][array_col[i]];
                 z1=x;
                 z2=y;
                 x=array_row[i];
                 y=array_col[i];
                 array_row[i]=z1;
                   array_col[i]=z2;
          }
            array[x][y]='x';
            size++;
            array_row[size-1] = x;
             array_col[size-1] = y;
            head_col= head_col-1;
          break;
     }
     else
     {
         array[head_row][head_col-1]=array[head_row][head_col];
       y=head_col;
       x=head_row;
       for( int i=0;i<size;i++)
       {
              array[x][y]=array[array_row[i]][array_col[i]];
              z1=x;
              z2=y;
              x=array_row[i];
              y=array_col[i];
              array_row[i]=z1;
                array_col[i]=z2;
              }
       array[x][y]=' ';
       head_col= head_col-1;
       break;
     }
  }
}
//---------------------------------------------------------------------snakemove---------------------------------------------------------------------------
//--------------------------------------------------------------------------------------taking array index-------------------------------------------------
static void head()
{
h=rollDice();
b1=rollDice();
if(array[h][b1]==' '&&array[h][b1+1]==' '&&array[h][b1+2]==' '&&array[h][b1+3]==' ')
{
                 array[h][b1+2]='@';//xx@
                 array[h][b1+1]='x';
                array[h][b1]='x';
                 y1=b1+2;
                x1=h;
                x2=h;
                y2=b1+1;
                x3=h;
                y3=b1;
  }
  else if (array[h][b1]==' '&&array[h][b1-1]==' '&&array[h][b1-2]==' '&&array[h][b1-3]==' ')
  {
    array[h][b1-2]='@';//@xx
    array[h][b1-1]='x';
    array[h][b1]='x';
     y1=b1-2;
     x1=h;
     x2=h;
     y2=b1-1;
    x3=h;
    y3=b1;
  }
  else if (array[h][b1]==' '&&array[h+1][b1]==' '&&array[h+2][b1]==' '&&array[h+3][b1]==' ')
  {
    array[h+2][b1]='@';    //@
    array[h+1][b1]='x';   //x
    array[h][b1]='x';    //x
    y1=b1;
    x1=h+2;
    x2=h+1;
    y2=b1;
    x3=h;
    y3=b1;
  }
  else if (array[h][b1]==' '&&array[h-1][b1]==' '&&array[h-2][b1]==' '&&array[h-3][b1]==' ')
  {
    array[h][b1]='x';               //x
    array[h-1][b1]='x';            //x
    array[h-2][b1]='@';            //@
    y1=b1;
    x1=h-2;
    x2=h-1;
    y2=b1;
    x3=h;
    y3=b1;
  }
  else
  {
    head();
  }
  head_row=x1;
  head_col=y1;
   array_row[0]=x2;
   array_col[0]=y2;
   array_row[1]=x3;
   array_col[1]=y3;
}
//--------------------------------------------------------------taking array index------------------------------------------------------------------------

//------------------------------------------------------------------------take input-------------------------------------------------------------------

    public static void main(String argc[])
    {
      Scanner sc=new Scanner (System.in);
System.out.println("Name :");
playername=sc.nextLine();
      try
      {
        FileInputStream fin1=new  FileInputStream(".snake_high_score.dat");
        BufferedReader bf1=new BufferedReader(new FileReader("snake_player.dat"));
        heighscore=fin1.read();
        highscoreplayername=bf1.readLine();
      fin1.close();
      bf1.close();
      }
      catch(Exception e)
      {
      heighscore=0;
      highscoreplayername=" ";
      }
      snakegamewithwall123 a=new snakegamewithwall123();
       a.makearray();
       fruit();
       fruit();
       fruit();
       fruit();
       fruit();
       head();
     print1();
     System.out.println("score = "+score);
      System.out.println("heighscore = "+heighscore);
       System.out.println("High_scorername = "+highscoreplayername);
     while(gameover)
      {
       a.input();
       if(gameover==false)
       {
         System.out.println("GAMEOVER");
         try
         {
           FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
           FileWriter fw1=new FileWriter("snake_player.dat",false);
           BufferedWriter bf1=new BufferedWriter(fw1);
      if(score>heighscore)
      {
        fout1.write(score);
        bf1.write(playername);
      }
      else
      {
          fout1.write(heighscore);
          bf1.write(highscoreplayername);

      }
      fout1.close();
      bf1.close();
         }
         catch(Exception e)
         {
         System.out.println("Error");
         }

         break;
       }
      if(flag11!=1)
        {
         if(flag==4)
         {
           flag11=4;
           if(array[head_row][head_col+1]=='W'||array[head_row][head_col+1]=='|'||array[head_row][head_col+1]=='=')
          {
           System.out.println("GAMEOVER");
           try
           {
             FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
             FileWriter fw1=new FileWriter("snake_player.dat",false);
             BufferedWriter bf1=new BufferedWriter(fw1);
        if(score>heighscore)
        {
          fout1.write(score);
          bf1.write(playername);
        }
        else
        {
            fout1.write(heighscore);
            bf1.write(highscoreplayername);
             System.out.println("High_scorername = "+highscoreplayername);

        }
        fout1.close();
        bf1.close();
           }
           catch(Exception e)
           {
           System.out.println("Error");
           }
           break;
          }
          else
          {
               a.logic();
               if(gameover==false)
               {
                 break;
               }
               else
               {

              print1();
              System.out.println("score = "+score);
               System.out.println("heighscore = "+heighscore);
                System.out.println("High_scorername = "+highscoreplayername);
            }
          }
       }
}
if(flag11!=2)
{
       if(flag==3)
        {
          flag11=3;
          if(array[head_row+1][head_col]=='W'||array[head_row+1][head_col]=='|'||array[head_row+1][head_col]=='=')
          {
               System.out.println("GAMEOVER");
               try
               {
                 FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
                 FileWriter fw1=new FileWriter("snake_player.dat",false);
                 BufferedWriter bf1=new BufferedWriter(fw1);
            if(score>heighscore)
            {
              fout1.write(score);
              bf1.write(playername);
            }
            else
            {
                fout1.write(heighscore);
                bf1.write(highscoreplayername);

            }
            fout1.close();
            bf1.close();
               }
               catch(Exception e)
               {
               System.out.println("Error");
               }
          break;
        }
        else
        {
             a.logic();
            print1();
            System.out.println("score = "+score);
             System.out.println("heighscore = "+heighscore);
             System.out.println("High_scorername = "+highscoreplayername);
        }
      }
    }
    if(flag11!=3)
    {
      if(flag==2)
       {
         flag11=2;
         if(array[head_row-1][head_col]=='W'||array[head_row-1][head_col]=='|'||array[head_row-1][head_col]=='=')
         {
              System.out.println("GAMEOVER");
              try
              {
                FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
                FileWriter fw1=new FileWriter("snake_player.dat",false);
                BufferedWriter bf1=new BufferedWriter(fw1);
           if(score>heighscore)
           {
             fout1.write(score);
             bf1.write(playername);
           }
           else
           {
               fout1.write(heighscore);
               bf1.write(highscoreplayername);

           }
           fout1.close();
           bf1.close();
              }
              catch(Exception e)
              {
              System.out.println("Error");
              }
         break;
       }
       else
       {
            a.logic();
           print1();
           System.out.println("score = "+score);
            System.out.println("heighscore = "+heighscore);
             System.out.println("High_scorername = "+highscoreplayername);
       }
     }
   }
     if(flag11!=4)
     {
     if(flag==1)
      {
        flag11=1;
     if(array[head_row][head_col-1]=='W'||array[head_row][head_col-1]=='|'||array[head_row][head_col-1]=='=')
        {
             System.out.println("GAMEOVER");
             try
             {
               FileOutputStream fout1=new  FileOutputStream(".snake_high_score.dat");
               FileWriter fw1=new FileWriter("snake_player.dat",false);
               BufferedWriter bf1=new BufferedWriter(fw1);
          if(score>heighscore)
          {
            fout1.write(score);
            bf1.write(playername);
          }
          else
          {
              fout1.write(heighscore);
              bf1.write(highscoreplayername);

          }
          fout1.close();
          bf1.close();
             }
             catch(Exception e)
             {
             System.out.println("Error");
             }
        break;
      }
      else
      {
          a.logic();
          print1();
          System.out.println("score = "+score);
           System.out.println("heighscore = "+heighscore);
            System.out.println("High_scorername = "+highscoreplayername);
      }
    }
    }
  }
   }
}
