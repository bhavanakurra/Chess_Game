package Knight_pack;
import Piece_pack.*;
import Board_pack.*;

public class Knight extends Piece
{

public Knight(int a1,int b1,String col)
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
	 if(diff_x==1 || diff_x==-1)
			{
				if(diff_y==2 || diff_y==-2)
				{
					tpiece=Board.Board_piece[c][d];
					
						if(tpiece==null)
						{
							result=true;
						}
						else if(tpiece!=null)
						{
							if(!tpiece.colour.equals(colour))
							{
								result=true;
							}
						}
				}
			}
			
		
	else if(diff_x==2 || diff_x==-2)
			{
				if(diff_y==1 || diff_y==-1)
				{
					tpiece=Board.Board_piece[c][d];
					
						if(tpiece==null)
						{
							result=true;
						}
						else if(tpiece!=null)
						{
							if(!tpiece.colour.equals(colour))
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
		return colour.charAt(0)+" Kn";
	}



}