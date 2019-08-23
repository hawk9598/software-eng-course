class Min_Max_Average {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sum = 0;
        int min = 0;
        int max = 0; //initialize the sum, min and max variables to be 0 initially
        int i ;
        for (i = 0; i < args.length; i++){ //loops over from i = 0 to i = length of arguments - 1, such that every argument input in the command line is considered.
            sum = sum + Integer.parseInt(args[i]);  // updates the value of sum.
            if (i == 0){
                min = Integer.parseInt(args[i]); //initializes the value of min and max to be the first input argument when i = 0.
                max = Integer.parseInt(args[i]);
            }
            else{
                if (Integer.parseInt(args[i]) < min){ //updates the value of min when the next argument is smaller than min
                    min = Integer.parseInt(args[i]);
                }
                if (Integer.parseInt(args[i]) > max){ //updates the value of max when the next argument is bigger than max
                    max = Integer.parseInt(args[i]);
                }
            }  
        }
	double sum_divide = sum; //type cast int sum to be a double
	double i_divide =  i; //type cast i to be a double as well, because a double being divided by a double gives a double.
	double average = sum_divide / i_divide; //finds the average of the input values.
	//System.out.println("i is " + String.valueOf(i));
        System.out.println("The average is " + String.valueOf(average));
        System.out.println("The minimum is " + String.valueOf(min));
        System.out.println("The maximum is " + String.valueOf(max));   //Prints out the average, min and max of the input arguments. Works for any number of arguments.
        // TODO code application logic here
    }
}
