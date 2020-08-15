
public class Calculator implements java.io.Serializable {

	private double operandOne;
	private double operandTwo;
	private String operation;
	private double result= 0;	
	
	public Calculator() {
		//empty constructor when using Serializable JavaBeans
	} 
	 
	  //getters and setters
		public double getOperandOne() {
			return operandOne;
		}

		public void setOperandOne(double operandOne) {
			this.operandOne = operandOne;
		}

		public double getOperandTwo() {
			return operandTwo;
		}
		
		public void setOperandTwo(double operandTwo) {
			this.operandTwo = operandTwo;
		}

		public String getOperation() {
			return operation;
		}

		public void setOperation(String operation) {
			this.operation = operation;
		}
		
	
	  private double performOperation() {
	        if (this.operation.equals("+")) {
	        	result = (this.getOperandOne() + this.getOperandTwo());
	        	//System.out.println("The sum result is: " + result);

	        } else if (this.operation.equals("-")) {
	        	result = (this.getOperandOne() - this.getOperandTwo());
	        }
	        
			return result;
	    }

	    public double getResult() {
	    	return performOperation();
	    }

}
