package com.valeo.example_project;



public class BadCode {
    public void bad_function() {
	int x = -2;
	System.out.println("This is an example of a code smell");
        while(x < 5){
		while (x<4){
			if (x == 2){
				System.out.println("X = 2");	
			}else{
				if (x==0){	
					System.out.println("X = 0");	
				}else{
					System.out.println("X != 0");	
				}
			}
		}
		x += 1;

	};
    }

}
