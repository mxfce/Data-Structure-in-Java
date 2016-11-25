
import java.io.*;
import java.util.*;
public class ShuntingYard 
{
	public static void main(String[] args) throws Exception 
	{
		String expression = "A ^ 2 + 2 * A * B + B ^ 2";
		Stack<String> sign = new Stack<String>();
		Queue<String> output = new LinkedList<String>();
		StringTokenizer st = new StringTokenizer(expression," ");
		while(st.hasMoreTokens())
		{
			String curr_token = st.nextToken();
			if(getPrecedence(curr_token) == -1)
			{
				output.add(curr_token);
			}
			else
			{
				if(curr_token.equals("("))
					sign.push("(");
				else if(curr_token.equals(")"))
				{
					while(!sign.peek().equals("("))
					{
						output.add(sign.pop());
					}
					sign.pop();
				}
				else
				{
					while(!sign.isEmpty() && getPrecedence(sign.peek()) >= getPrecedence(curr_token))
					{
						output.add(sign.pop());
					}
					sign.push(curr_token);
				}
			}
		}
		while(!output.isEmpty())
			System.out.print(output.poll());
		while(!sign.isEmpty())
			System.out.print(sign.pop());
		
	}
	public static int getPrecedence(String sign)
	{
		int prec = -1;
		if(sign.equals("+") || sign.equals("-"))
			prec = 1;
		else if(sign.equals("*") || sign.equals("/"))
			prec = 2;
		else if(sign.equals("^"))
			prec = 3;
		else if(sign.equals(")") || sign.equals("("))
			prec = 4;
		return prec;
	}

	
}
