package Game;

import Piece_pack.*;
import Board_pack.*;
import java.util.*;
import java.io.*;
import Player_pack.*;

public class Game
{

public static void print_board()
	{
		for(int i=7;i>=0;i--)
		{
			System.out.print("   "+i+" ");
			
			for(int j=0;j<8;j++)
			{
				Piece temperory=Board.Board_piece[j][i];
				
					if(temperory==null)
					{
						System.out.print(" ***  ");
					}
					else
					{
						System.out.print(" "+temperory+" ");
					}
			}
			System.out.println();
			System.out.println();
		}
		
		System.out.println();
		System.out.print("     ");
		
		for(int i=0;i<8;i++)
		{
			System.out.print("   "+i+"  ");
		}
		
		System.out.println();
		System.out.println();
	}	
	
public static void main(String args[])throws Exception
	{
		Scanner scan=new Scanner(System.in);		
		Player white_player=new Player("white");
		Player black_player=new Player("black");	
		System.out.println();
		
		int choice=0;

		System.out.println();
				
			while(choice!=3)
			{
					System.out.println();
					System.out.println();
					System.out.println("Enter  1 - Continue ");
					System.out.println("       2 - Print and Continue");
					System.out.println("       3 - exit ");
					choice=scan.nextInt();
			
						if(choice==2)
						{
							print_board();
						}	
						else if(choice==3)
						{
							System.exit(0);
						
						}
				
					System.out.println("->->White's<-<-");
					white_player.turn();
			
						if(black_player.king.check())
						{
							
							System.out.println();
							System.out.println("B king is in check ");
						
						}	
					
				
					System.out.println();
					System.out.println();
					System.out.println("Enter  1 - Continue ");
					System.out.println("       2 - Print and Continue");
					System.out.println("       3 - exit ");
					choice=scan.nextInt();
			
						if(choice==2)
						{
							print_board();
						}		
						else if(choice==3)
						{
							System.exit(0);
						}
				
					System.out.println("->->Black's<-<-");
					black_player.turn();
			
						if(white_player.king.check())
						{
							System.out.println("W king is in check");
					
								
						}
				
			}		
	}

}