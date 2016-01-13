package MathEquation;

import java.util.ArrayList;

public class Equation{

	private ArrayList<Term> leftSide;
	private ArrayList<Term> rightSide;
	private boolean cancelRight;
	private ArrayList<Double> solution;
//TODO: Make getters for all of the above

 public Equation(ArrayList<Term> leftSide, ArrayList<Term> rightSide){
 //sets values of leftSide and rightSide only
	 this.leftSide = leftSide;
	 this.rightSide = rightSide;
 }

 public boolean isLinear(){
 //returns 'true' if this equation is linear
 //and every term is either constant or has the same variable
	
	   String  [] variableLeft= new String [leftSide.size()];
	   String  [] variableRight= new String [rightSide.size()];
       
	 for(int i=0;i<leftSide.size();i++){
		 int leftExp = leftSide.get(i).getExponent();
		 
		 if(leftExp ==2 || leftExp == 0){
		
		 }
		 else{
			 return false;
		 }
		 
	 } 

	 for(int i=0;i<rightSide.size();i++){
		 int rightExpo = rightSide.get(i).getExponent();
		 if(rightExpo ==1 || rightExpo == 0){
			
			 continue;
		 }
		 else{
			 return false;
		 }
		 
		
	 }
	
	
		 return false;
 }

 public boolean isQuadratic(){
	 return false;
 //returns 'true' if this equation is quadratic
 //and every term is either constant or has the same variable
 }	


 public boolean isSolveable(){
 //returns 'true' if this equation is linear or quadratic, 'false' otherwise 
 //(because in this project we are not programming a means of solving anything other than linear and quadratic equations)
	 if(!isLinear() && !isQuadratic()){
		 return false;
	 }
	 return true;
 }

 public boolean cancelRight(){
 //sets the value of cancelRight and
 //returns 'true' if the equation should be solved by subtracting terms from the right side, false if it is better to subtract terms on the left side
	double highestLeft =getHighestDegreeTerm(leftSide).getCoefficient();
	double highestRight = getHighestDegreeTerm(rightSide).getCoefficient();
	 if( highestLeft> highestRight){
		 return true;
	 }
	 return false;
 }

 public void setLeftSide(ArrayList<Term> leftSide) {
	this.leftSide = leftSide;
}

public void setRightSide(ArrayList<Term> rightSide) {
	this.rightSide = rightSide;
}

public void setCancelRight(boolean cancelRight) {
	this.cancelRight = cancelRight;
}

public void setSolution(ArrayList<Double> solution) {
	this.solution = solution;
}

public ArrayList<Term> getLeftSide() {
	return leftSide;
}

public ArrayList<Term> getRightSide() {
	return rightSide;
}

public boolean isCancelRight() {
	return cancelRight;
}

public ArrayList<Double> getSolution() {
	return solution;
}

public String toString(){
 /**
  *Take your time on this method!
  *There are many things to consider:
  *Every terms should be separated by a '+' UNLESS it has a negative coefficient. 
  *When a term is negative, the negative sign will appear as a minus.
  */
	String expression = "";
	expression = expression + leftSide.get(0).toString();
	for(int i = 1;i<leftSide.size();i++){
		if(leftSide.get(i).getCoefficient()<0){
			expression = expression + leftSide.get(i).toString();
		}
		else{
			expression = expression+ "+" + leftSide.get(i).toString();
		}
	}
	expression= expression + "=";
	expression = expression + rightSide.get(0).getCoefficient() + rightSide.get(0).getVariable()+"^"+rightSide.get(0).getExponent();
	for(int i = 1;i<rightSide.size();i++){
		if(rightSide.get(i).getCoefficient()<0){
			expression = expression + rightSide.get(i).toString();
		}
		else{
			expression = expression + "+" + rightSide.get(i).toString();
		}
	}
	return expression;
 }


    public static Term getHighestDegreeTerm(ArrayList<Term> side){
        //returns the term in the ArrayList that is the highest degree.
        //example
        //3x^2 + 4x^3 - 12x + x^2
        //will return 4x^3 
    	int x = 0;
    	Term theTerm = side.get(0);
    	for(int i=0;i<side.size();i++){
    		if(side.get(i).getExponent()>x){
    			x = side.get(i).getExponent();
    			theTerm = side.get(i);
    		}
    	}
    	
    	return theTerm;
    	
    }
    
    public void toZeroOnOneSide(ArrayList<Term> sideBeingCanceled){
    	// adds the additive to each side for each term.
    	for(int i=0;i<sideBeingCanceled.size();i++){
    		leftSide.add(getHighestDegreeTerm(sideBeingCanceled).getAddInverse());
   			rightSide.add(getHighestDegreeTerm(sideBeingCanceled).getAddInverse());
   		}
    }
    
    
    
    
    public void simplify(ArrayList<Term> side){
    	
    }
    		
    		
  
    
    public void solveLinear(ArrayList<Term> sideWithVariable){
    	for(int i=0;i<sideWithVariable.size();i++){
    		//adds the opposite sign
    		if(sideWithVariable.get(i).isConstant()){
    			leftSide.add(sideWithVariable.get(i).getAddInverse());
    			rightSide.add(sideWithVariable.get(i).getAddInverse());
    			
    		}
    	}
    	for(int i=0;i<sideWithVariable.size();i++){
    		//multiply both side by inverse
    		if(!sideWithVariable.get(i).isConstant()){
    			double scalar = 1/sideWithVariable.get(i).getCoefficient();
    			multiplyScalar(
    					leftSide,scalar);
    			multiplyScalar(rightSide,scalar);
    		}
    	}
    }
    
    public void multiplyScalar(ArrayList<Term> side, double scalar){
    	for(int i=0;i<side.size();i++){
    		side.get(i).setCoefficient(side.get(i).getCoefficient()*scalar);
    	}
    }
}
