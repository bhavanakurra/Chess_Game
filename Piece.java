package Piece_pack; 
public abstract class Piece
{

public String colour;
//initial positions//
public int a;
public int b;		
//abstract method//
public abstract boolean Possible(int c,int d);

public String getName()
{
	Class c=this.getClass();
	return c.getSimpleName();
}

}