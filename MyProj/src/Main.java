import java.awt.EventQueue;

public class Main {

		 public static void main(String[] args) {
		        EventQueue.invokeLater(new Runnable() {
		            public void run() {
		                try {
		                    MainFrame frame = new MainFrame();
		                    frame.setVisible(true);
		                    frame.setSize(700,700);
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        });
		        
		        	        
		// TODO Auto-generated method stub
        Operations op = new Operations();
		Polynomial p1 = new Polynomial();
		p1.newTerm(3, 1);
		p1.newTerm(2, -2);
		p1.newTerm(1, 6);
		p1.newTerm(0, -5);
		System.out.println("p1 = " + p1);

		Polynomial p2 = new Polynomial();
		p2.newTerm(2, 1);
		p2.newTerm(0, -1);
		System.out.println("p2 = " + p2);

		Polynomial p3 = op.add(p1,p2);
		System.out.println("p1 + p2 = " + p3);

		Polynomial p4 = op.substract(p1,p2);
		System.out.println("p1 - p2 = " + p4);

		Polynomial p5 = op.multiply(p1,p2);
		System.out.println("p1 * p2 = " + p5);

		Polynomial p6 = op.divide(p1,p2);
		System.out.println("p1 / p2 = " + p6);

		Polynomial p7 = op.integrate(p1);
		System.out.println("integral of p1 = " + p7);

		Polynomial p8 = op.derivative(p1);
		System.out.println("derivative of p1 = " + p8);
}

}

