package Soldier_pack;
import Piece_pack.*;
import Board_pack.*;
public class Soldier extends Piece
{
public Soldier(int a1,int b1,String col)
	{
		a=a1;
		b=b1;
		colour=col;
	}
public boolean Possible(int c,int d)
{
int diff_x=c-a;
int diff_y=d-b;
Piece tpiece;
boolean result=false;
int count=0,i;	
     if(diff_y<0 && colour.equals("black"))
			{
				if((diff_x==-1 || diff_x==1) && diff_y==-1)
				{
					tpiece=Board.Board_piece[c][d];
					
						if(tpiece!=null)
						{
							if((tpiece.colour).equals("white"))
							{
								
								result=true;
							}
						}
				}
				else if(diff_x==0)
				{
					if(diff_y==-1)
					{
						tpiece=Board.Board_piece[c][d];
						
							if(tpiece==null)
							{
								result=true;
							}
					}
					else if(diff_y==-2 && b==6)
					{
						i=1;
						count=0;
						
							while(i<=2)
							{
								tpiece=Board.Board_piece[a][b-i];
									
									if(tpiece==null)
									{
										count++;
									}
									
									else
									{
										break;
									}
								i++;
							}
							
							if(count==2)
							{
								result=true;
							}
					}
				}
			}
			


	else if(diff_y>0 && (colour).equals("white"))
			{
				if((diff_x==-1 || diff_x==1) && diff_y==1)
				{
					tpiece=Board.Board_piece[c][d];
					
						if(tpiece!=null)
						{
							if((tpiece.colour).equals("black"))
							{
								//System.out.println("you are removing the "+tpiece.getName());
								result=true;
							}
						}
				}
				else if(diff_x==0)
				{
					if(diff_y==1)
					{
						tpiece=Board.Board_piece[c][d];
						//System.out.println(tpiece);
						
							if(tpiece==null)
							{
								result=true;
							}
					}
					else if(diff_y==2 && b==1)
					{
						i=1;
						count=0;
						
							while(i<=2)
							{
								tpiece=Board.Board_piece[a][b+i];
								
									if(tpiece!=null)
									{
										break;
									}
									else
									{
										count++;
									}
								i++;
							}
							
							if(count==2)
							{
								result=true;
							}
					}
				}
			}
			
		return result;
		
	
	
	
	
}
public String toString()
	{
		Class c=this.getClass();
		return colour.charAt(0)+" So";
	}


}