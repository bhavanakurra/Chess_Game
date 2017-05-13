package Bishop_pack;
import Piece_pack.*;
import Board_pack.*;
public class Bishop extends Piece
{
public Bishop(int a1,int b1,String col)
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
int x_ref=diff_x;
int y_ref=diff_y;
		
	if(diff_x<0)
			{
				x_ref=-diff_x;
			}
			if(diff_y<0)
			{
				y_ref=-diff_y;
			}
			
		//System.out.println(diff_x+"   "+diff_y+"    "+x_ref+"   "+y_ref);
			
			if(x_ref==y_ref)
			{
				int count=0;
				int i=a;
				int j=b;
				
				//System.out.println(i+"   "+j);
					
					while(y_ref!=1)
					{
						y_ref--;
						
							
							if(diff_y<0)
							{
								j--;
							}
							else
							{
								j++;
							}
							
						    if(diff_x<0)
							{
								i--;
							}
							else
							{
								i++;
							}
						
						//System.out.println(i+"   "+j);
						
						tpiece=Board.Board_piece[i][j];
						
							if(tpiece==null)
							{
								count++;
							}
							else
							{
								break;
							}
					}
					//System.out.println(count+"   "+x_ref);
					if(count==x_ref-1)
					{
						tpiece=Board.Board_piece[c][d];
				
							if(tpiece!=null)
							{
								if(!tpiece.colour.equals(colour))
								{
									result=true;
								}
							}
							else if(tpiece==null)
							{
								result=true;
							}
					}
			}
			
		return result;
	
	
	
	
}

public String toString()
	{
		Class c=this.getClass();
		return colour.charAt(0)+" Bi";
	}

}