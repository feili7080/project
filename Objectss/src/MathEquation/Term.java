package MathEquation;



public class Term{
	 double coefficient;
	 String variable;
	 int exponent;
	 boolean constant;//this is true if a Term has no variable expression
	        //TODO: Write getters for all of the above fields

	 public Term(double coefficient, String var, int exp){
	 //set the value of all the fields
	 //if variable is non-empty, sets constant to 'false'
		 this.coefficient = coefficient;
		 this.variable = var;
		 this.exponent = exp;
		 if(!var.equals("")){
			 constant = false;
		 }
		 else{
			 constant = true;
		 }
		 if(coefficient ==0){
			 variable = ""; 
			 exponent = 0;
		 }
		 if(exponent == 0){
			 constant  = true;
			 variable = "";
		 }
	 }

	 /**
	  *a constructor for constant: 
	  */
	 Term(double constant){
	 //sets coefficient to constant, variable to "", exponent to "0" and constant to 'true')
		 coefficient = constant;
		 variable = "";
		 exponent = 1;
		 this.constant = true;
	 }
	 /**
	  *Write getters for each field
	  *Note that the getter for the boolean should be called 'isConstant'
	  */ 

	 public Term getAddInverse(){
	 //returns the additive inverse of this Term
		 return new Term(-coefficient,variable,exponent);
	 }

	 public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	public void setConstant(boolean constant) {
		this.constant = constant;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public String getVariable() {
		return variable;
	}

	public int getExponent() {
		return exponent;
	}

	public boolean isConstant() {
		return constant;
	}

	public int getDegree(){
	 //returns the exponent
		return exponent;
	 }

	    public boolean isPositive(){
	        //returns true if the coefficient is positive (or zero), false otherwise
	    	if(coefficient>=0){
	    		return true;
	    	}
	    	return false;
	    }	

	public String toString(){
	 /**
	  *Some tips to consider:
	                *doubles always print with trailing zeros (i.e. 2.0) This is not desireable
	  *If a term has a coefficient of 1 or -1, the 1 should not be shown. 
	  *If a term has an exponent of 1, the 1 should not be shown
	  *For exponents, use '^'. The GUI will change it into superscript.
	  */
		String x = "";
	
		if(coefficient !=1&&coefficient!=-1){
			x = x+coefficient;
		}
		System.out.println(x);
		if(coefficient ==0)
			return "0";
		
		if(coefficient == -1){
			x = x+"-";
		}
		System.out.println(x);
		x = x+ variable;
		System.out.println(x);
		System.out.println(x);
		if(exponent !=1){
			x = x+"^"+exponent;
		}
		System.out.println(x);
		
		return x.replaceAll("\\.0","");
	 }
	
	public boolean areLikeTerms(Term s,Term t){
		if(s.getVariable().equals(t.getVariable())&& s.getExponent()==t.getExponent()){
			return true;
		}
		return false;
	}
	
	public Term combine(Term s,Term t){
		return new Term(s.getCoefficient()+t.getCoefficient(),s.getVariable(),s.getExponent());
	}
}
