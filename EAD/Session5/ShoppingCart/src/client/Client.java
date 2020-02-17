package client;

import java.io.IOException;

import controller.ShoppingCartController;

/**
 * 
 * @author Nilesh Patel
 * This is client class.
 */
public class Client 
{
	public static void main(String[] args)throws IOException 
	{
		ShoppingCartController control=new ShoppingCartController();
		control.inputChoice();
	}
}
