package Player_pack;
import java.util.*;
import Piece_pack.*;
import Board_pack.*;
import Rook_pack.*;
import Knight_pack.*;
import Soldier_pack.*;
import Bishop_pack.*;
import Queen_pack.*;
import King_pack.*;
public class Player
{
String colour1;
public King king;

 public Player(String colour2)
 {
	 this.colour1=colour2;
	 int baserow=0,secondrow=0;
	 
	 if(colour1.equals("white"))
	 {
		 baserow=0;
		 secondrow=1;
		 
	 }
	 else if(colour1.equals("black"))
	 {
		 baserow=7;
		 secondrow=6;
	 }
	 
	 Rook R_R=new Rook(7,baserow,colour1);
	 Board.Board_piece[7][baserow]=R_R;
	 Rook R_L=new Rook(0,baserow,colour1);
	 Board.Board_piece[0][baserow]=R_L;
	 
	 Knight K_R=new Knight(6,baserow,colour1);
	 Board.Board_piece[6][baserow]=K_R;
	  Knight K_L=new Knight(1,baserow,colour1);
	 Board.Board_piece[1][baserow]=K_L;
	 
	Bishop B_R=new Bishop(5,baserow,colour1);
	Board.Board_piece[5][baserow]=B_R;
	Bishop B_L=new Bishop(2,baserow,colour1);
	Board.Board_piece[2][baserow]=B_L;
	  
	Queen Q=new Queen(3,baserow,colour1);
    Board.Board_piece[3][baserow]=Q;
   
    king=new King(4,baserow,colour1);
    Board.Board_piece[4][baserow]=king;
     
	 
	for(int i=0;i<=7;i++)
	{
		Soldier S=new Soldier(i,secondrow,colour1);
		Board.Board_piece[i][secondrow]=S;
		
	}		
    	
	 
 }

 
 public void move(int a1,int b1,int c1,int d1)
	{
		Board.Board_piece[a1][b1].a=c1;
		Board.Board_piece[a1][b1].b=d1;
		Board.Board_piece[c1][d1]=Board.Board_piece[a1][b1];
		Board.Board_piece[a1][b1]=null;
		changepiece(c1,d1);		
	}
	
 public void changepiece(int c,int d)
	{
		Piece tpiece=Board.Board_piece[c][d];
		
			if(tpiece.getName().equals("Soldier") && tpiece.colour.equals(colour1))
			{
				if((tpiece.colour.equals("white") && d==7) || (tpiece.colour.equals("black") && d==0))
				{
					Board.Board_piece[c][d]=getpiece(c,d);
				}
			}
	}	
	
	
	public Piece getpiece(int c,int d)
	{
		Scanner scan=new Scanner(System.in);
		Piece tpiece=null;
		System.out.println();
		System.out.println("      Changing the Sepoy");
		System.out.println();
		System.out.println("Enter     1 - Rook");
		System.out.println("          2 - Knight");
		System.out.println("          3 - Bishop");
		System.out.println("          4 - Queen");
		int choice=scan.nextInt();

			while(choice<=0 || choice>4)
			{
				System.out.println();
				System.out.println("    Enter a valid choice   ");
				choice=scan.nextInt();
			}
			
			switch(choice)
			{
					
				case 1:
			
					Rook roo=new Rook(c,d,colour1);
					tpiece=roo;
					break;
				
				case 2:
			
					Knight kni=new Knight(c,d,colour1);
					tpiece=kni;
					break;
				
				case 3:
					
					Bishop bis=new Bishop(c,d,colour1);
					tpiece=bis;
					break;
					
				case 4:
				
					Queen Q=new Queen(c,d,colour1);
					tpiece=Q;
					break;					
			}
			
		return tpiece;
	}
	
	public void turn()
	{
		Scanner scan=new Scanner(System.in);
		Piece tpiece;

		
		System.out.println("enter intial x-coordinate");
		int a2=scan.nextInt();
		System.out.println("enter intial y-coordinate");
		int b2=scan.nextInt();
		System.out.println();
		tpiece=Board.Board_piece[a2][b2];
	
			while(tpiece==null)
			{
				System.out.println("no piece");
				System.out.println("enter valid move");
				System.out.println();
				System.out.println("intial x:");
		         a2=scan.nextInt();
		        System.out.println("final x:");
		        b2=scan.nextInt();
		
				System.out.println();
				tpiece=Board.Board_piece[a2][b2];
			}
			
			while(!tpiece.colour.equals(colour1))
			{
				System.out.println(colour1+" player turn ");
				System.out.println("Enter the "+colour1+" player coordinates  ");
				System.out.println();
				System.out.println("intial x:");
		        a2=scan.nextInt();
		        System.out.println("intial y:");
		         b2=scan.nextInt();
		
				System.out.println();
				tpiece=Board.Board_piece[a2][b2];
			
					while(tpiece==null)
					{
						System.out.println("no piece ");
						System.out.println("Please enter a valid position ");
						System.out.println();
						System.out.println("intial x:");
						a2=scan.nextInt();
						System.out.println("intial y:");
						b2=scan.nextInt();
		
						System.out.println();
						tpiece=Board.Board_piece[a2][b2];
					}
			}
			
		System.out.println("Final position's ");
		System.out.println("final x:");
		int c=scan.nextInt();
		System.out.println("final y:");
		int d=scan.nextInt();
		
		System.out.println();		
		boolean can=tpiece.Possible(c,d);
		
		int change=0;
		
			while(can==false)
			{
				System.out.println("  Cannot move to the defined position ");
				System.out.println("Enter 1 - Change the initial position");
				System.out.println("      2 - Enter a valid move ");
				System.out.println("      3 - Exit");
				int choice=scan.nextInt();
					
					if(choice==1)
					{
						change=1;
						break;
					}
					else if(choice==2)
					{
					System.out.println("final x:");
					    c=scan.nextInt();
						System.out.println("enter final y-coordinate");
						d=scan.nextInt();
		
					can=tpiece.Possible(c,d);
					}
					else if(choice==3)
					{
						System.exit(0);
					}
			}
			
			if(can)
			{
				Piece initial_piece=Board.Board_piece[a2][b2];
				Piece final_piece=Board.Board_piece[c][d];
				move(a2,b2,c,d);
				
				if(king.check())
					{
						System.out.println();
						System.out.println(" not possible since it is check ");
						System.out.println();
						Board.Board_piece[a2][b2]=initial_piece;
						Board.Board_piece[a2][b2].a=a2;
						Board.Board_piece[a2][b2].b=b2;
						Board.Board_piece[c][d]=final_piece;
							if(final_piece!=null)
							{
							Board.Board_piece[c][d].a=c;
							Board.Board_piece[c][d].b=d;

							}
							
							if(initial_piece.getName().equals("King"))
							{
								king.a=a2;
								king.b=b2;
							}
						
							turn();
					}
					else
					{
						System.out.println("step finished");
					}
					
					
			}
			
			if(change==1)
			{
				turn();
			}
	}


 
 
 
 
}