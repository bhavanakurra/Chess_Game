package King_pack;
import Piece_pack.*;
import Board_pack.*;
public class King extends Piece
{
public King(int a1,int b1,String col)
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

    if(diff_x==-1 || diff_x==0 || diff_x==1)
	{
	   if(diff_y==-1 || diff_y==0 || diff_y==1)
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
		
		return colour.charAt(0)+" ki";
	}
public boolean check()
{
	boolean result=false;
	Piece tpiece;
	for(int i=0;i<=7;i++)
	{
		for(int j=0;j<=7;j++)
		{
			tpiece=Board.Board_piece[i][j];
			if(tpiece!=null)
			{
			 if(!tpiece.colour.equals(colour))
			 {
				if(tpiece.Possible(a,b)==true)
				{
					result=true;
					break;
				}
				 
			 }
			}
		}
		if(result==true)
		{
			break;
		}
	}
	
	return result;
}	
	
	
	
	
	
	

}