import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operations {
	 public Polynomial add(Polynomial p1, Polynomial p2) { // a = op.add(b,c)
	        Polynomial result = new Polynomial();
	        for (int degree : p1.getPolynomial1().keySet()) {
	            double coefficient = p1.get(degree); // return the coefficient
	            result.newTerm(degree, coefficient); // add all the monom from p1 to the polynomial result
	        }
	        for (int degree : p2.getPolynomial1().keySet()) {
	            double coefficient = p2.getPolynomial1().get(degree);
	            result.newTerm(degree, coefficient); //add all the monom from p2 to the polynomial result
	        }
	        return result;
	    }

	   
		public Polynomial substract(Polynomial p1, Polynomial p2) {
	        Polynomial result = new Polynomial();
	        for (int degree : p1.getPolynomial1().keySet()) {
	        	double coefficient = p1.get(degree);
	            result.newTerm(degree, coefficient);
	        }
	        for (int degree : p2.getPolynomial1().keySet()) {
	            double coefficient = p2.getPolynomial1().get(degree);
	            result.newTerm(degree, -coefficient);
	        }
	        return result;
	    }

	    public Polynomial multiply(Polynomial p1, Polynomial p2) {
	        Polynomial result = new Polynomial();
	        for (int degree1 : p1.getPolynomial1().keySet()) {
	            for (int degree2 : p2.getPolynomial1().keySet()) {
	                int degree = degree1 + degree2;
	                double coefficient = p1.getPolynomial1().get(degree1) * p2.getPolynomial1().get(degree2);
	                result.newTerm(degree, coefficient);
	            }
	        }
	        return result;
	    }
	    
	    
	    
	    public Polynomial divide(Polynomial p1, Polynomial p2) throws ArithmeticException {
	        Polynomial quotient = new Polynomial();
	        Polynomial remainder = new Polynomial(p2);

	        while (remainder.degree() >= p2.degree()) {
	            double coefficient = remainder.get(remainder.degree()) / p2.get(p2.degree());
	            int degree = remainder.degree() - p2.degree();
	            Polynomial term = new Polynomial();
	            term.newTerm(degree, coefficient);
	            quotient = add(quotient,term);
	            remainder = substract(remainder,multiply(p2,term));
	        }
	        if (remainder.getPolynomial1().isEmpty()) {
	            return quotient;
	        } else {
	            throw new ArithmeticException("Polynomial division not exact");
	        }
	    }

	    public Polynomial integrate(Polynomial p1) {
	        Polynomial result = new Polynomial();
	        for (int degree : p1.getPolynomial1().keySet()) {
	            double coefficient = p1.getPolynomial1().get(degree); //get the coefficient of the current degree
	            int newDegree = degree + 1;
	            double newCoefficient = coefficient / newDegree;
	            result.newTerm(newDegree, newCoefficient); // add this term to the polynomial 
	        }
	        return result;
	    }

	    public Polynomial derivative(Polynomial p1) {
	        Polynomial result = new Polynomial();
	        for (int degree : p1.getPolynomial1().keySet()) {
	            double coefficient = p1.getPolynomial1().get(degree);
	            if (degree > 0) {
	                double newCoefficient = coefficient * degree;
	                result.newTerm(degree - 1, newCoefficient);
	            }
	        }
	        return result;
	    }
	    
	    public Map<Integer, Double> parsePolynomial(String polynomialString) {
		    Map<Integer, Double> parsedPolynomial = new TreeMap<>();
		    Pattern termPattern = Pattern.compile("([-+])?\\s*(\\d*\\.?\\d*)?\\s*\\*?\\s*x\\s*(\\^\\s*(\\d+)?)?");

		    Matcher matcher = termPattern.matcher(polynomialString);
		    while (matcher.find()) {
		        double coefficient = 1.0;
		        if (matcher.group(1) != null && !matcher.group(1).isEmpty()) {
		            if (matcher.group(1).equals("-")) {
		                coefficient = -1.0;
		            }
		        }
		        if (matcher.group(2) != null && !matcher.group(2).isEmpty()) {
		            coefficient *= Double.parseDouble(matcher.group(2));
		        }
		        int exponent = 1;
		        if (matcher.group(4) != null && !matcher.group(4).isEmpty()) {
		            exponent = Integer.parseInt(matcher.group(4));
		        }
		        parsedPolynomial.put(exponent, coefficient);
		    }

		    return parsedPolynomial;
		}
}
