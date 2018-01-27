	/*Seemien Ahmed
	 * Assignment 3
	 * ExpressionSolver
	 * Assignment 3
	 * CSC 201
	 * Design and implement a utility class "ExpressionSolver" to solve any expression.
	 * Precondition: Create five tokens,three floats, two operators. 
	 * Post-condition: Evaluate the three operands using the two operators. Bring
	 * in one more operator and one more operand and evaluate until the end of expression is reached.
	 * Write a driver program to read expressions from a text file (one expression on each line)
	 * and print out the original expressions and their evaluated results on screen. 
	 */
	public class ExpressionSolver
	{
		private static String expression = " Expression";
		private static int index = 0;
		private static double r = 0;
	
	
		//solve is the method to get the operators and operands and evaluate the expression//
		public static double solve(String exp)
		{   System.out.println("Original expression is [" + exp + "]");
		index = 0;
		expression = exp;
		double r = 0;
		double o1, o2, o3;
		char op1, op2=0;
		///first evaluate the contents of the brackets of the expression/////
	
		if(exp.contains("(")||exp.contains(")"))
		{System.out.println("Bracketed expression "+getParenContent(exp));
		exp=exp.substring(exp.indexOf('(')+1,exp.indexOf(')'));
		o1=evalParen(getParenContent(exp));
		op1 = getOperator();
		o2 = getOperand();
		try {
			while(index<exp.length()) //use the while loop to move through the expression
			{   op2 = getOperator();
			o3 = getOperand();
			if(op1=='*'||op1=='/')
			{o1=evaluateTwoOp( o1, op1, o2);
			op1=op2;
			o2=o3;
			r=o1;
			}
			else
				if(op2=='*'||op2=='/')
				{	
					o2=evaluateTwoOp( o2, op2, o3);
					r=o2;
				}
				else
					if(op1=='+'||op1=='-')
					{  o1=evaluateTwoOp(o1,op1,o2);
					op1=op2;
					o2=o3;
					r=o1;	
					}
					else
					{if(op2=='+'||op2=='-')
						o2=evaluateTwoOp( o2, op2, o3);
					r=o2;
					}
			}
		}
		catch (Exception e)
		{
			System.out.println("Some exception occurred..."+e.getMessage() );
		}
		} 
		else
		{o1 = getOperand();
		op1 = getOperator();
		o2 = getOperand();
	
		try {
			while(index<exp.length()) //use the while loop to move through the expression
			{   op2 = getOperator();
			o3 = getOperand();
			if(op1=='*'||op1=='/')
			{o1=evaluateTwoOp( o1, op1, o2);
			op1=op2;
			o2=o3;
			r=o1;
			}
			else
	
				if(op2=='*'||op2=='/')
	
				{	o2=evaluateTwoOp( o2, op2, o3);
	
				r=o2;
				}
				else
					if(op1=='+'||op1=='-')
					{  o1=evaluateTwoOp(o1,op1,o2);
					op1=op2;
					o2=o3;
					r=o1;	
					}
					else
					{if(op2=='+'||op2=='-')
						o2=evaluateTwoOp( o2, op2, o3);
					r=o2;
					}
			}
		}
		catch (Exception e)
		{
			System.out.println("Some exception occurred..."+e.getMessage() );
		}
		}
		return (r);
		}
		////following method evaluates expression inside the brackets//////
	
		public static double evalParen(String exp)
		{ 
			String m=getParenContent(exp);
			return(solve(m));
		}
	
		///////following method extracts the contents in the expression//////
	
		public static String getParenContent(String exp)
		{try {
			exp=exp.substring(exp.indexOf('(')+1,exp.indexOf(')'));
			//index++;
	
			System.out.println("Bracket is Evaulated:  "+ solve(exp));
		}
		catch (Exception e)
		{
			System.out.println("Some exception w/brackets..."+e.getMessage());
		}
		return (exp)	;
		}
	
		// use if-else to evaluate operator and operand////
	
		private static double evaluateTwoOp(double o1, char op1, double o2) {
			double r = 0;
			try {
	
				if (op1 == '+') {
					r = o1 + o2;
				} else if (op1 == '-') {
					r = o1 - o2;
				} else if (op1 == '*') {
					r = o1 * o2;
				} else if (op1 == '/') {
					r = o1 / o2;
	
				}
			} 
			catch (Exception e) {
				System.out.println("Some exception occurred..." + e.getMessage());
			}
			return (r);
		}
	
		// use method getOperand to get the operand from expression
		private static double getOperand() {
			String s = "";
			try {
				while (index < expression.length() && // NOTE: moved this line up here to avoid
						// java.lang.StringIndexOutOfBoundsException thrown
	
						expression.charAt(index) != '+'
						&& expression.charAt(index) != '-'
						&& expression.charAt(index) != '*'
						&& expression.charAt(index) != '/'
						&& expression.charAt(index) != '.' 
						&& expression.charAt(index) != '('
						&& expression.charAt(index) != ')')
	
				{
					s += expression.charAt(index);
					index++;
				}
	
			} 
			catch (Exception e) {
				System.out.println( e.getMessage());
			}
			try{
				r = Double.parseDouble(s);
			}
			catch (Exception e) {
				System.out.println(  e.getMessage());
			}
	
	
			return r;
	
		}
	
		private static char getOperator() {
	
			char o = 0;
			try {
				o = expression.charAt(index);
				index++;
	
			} catch (Exception e) {
				System.out.println( e.getMessage());
			}
	
			return o;
		}
	}
