package testgenviewsemiautomatico.repository;


public class Sample1 {
  
    public int addition (int x, int y) {
        return (x + y);
    }

    public int subtraction (int x, int y) {
        return (x - y);
    }

    public float division (int x, int y) {
        if (y != 0) {
           return (x / y);
        } else {
           return 0;
        }
    }
	 public float OtraCosa (float x, char y,short z ) {
        if (y != 0) {
           return (x / y);
        } else {
           return 0;
        }
    }
	 public float AlgoRaro (long x, long y,byte zoo) {
        if (y != 0) {
           return (x / y);
        } else {
           return 0;
        }
    }
} 
