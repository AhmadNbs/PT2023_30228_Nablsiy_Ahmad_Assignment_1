import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private Map<Integer, Double> polynomial; // map from degree to coefficient

    public Polynomial() {
        polynomial = new TreeMap<>();
    }
    
    
    public void setPolynomial(Map<Integer, Double> polynomial) {
		this.polynomial = polynomial;
	}


	public Map<Integer, Double> getPolynomial1() {
        return polynomial;
    }

    public Polynomial(Polynomial polynomial) {
        this.polynomial = new TreeMap<>();
    }

    public boolean containsKey(int degree) {
        return polynomial.containsKey(degree);
    }

    public double get(int degree) {
        return polynomial.get(degree);
    }

    public int degree() {
        if (polynomial.isEmpty()) {
            return 0;
        }
        return ((TreeMap<Integer, Double>) polynomial).lastKey();
    }


    public void newTerm(int degree, double coefficient) {
        if (coefficient != 0) {
            if (degree >= 0 && !polynomial.containsKey(degree)) {
                // if degree is non-negative and not already in the polynomial, add a new term
                polynomial.put(degree, coefficient);
            } else if (degree >= 0) {
                // if degree is non-negative and already in the polynomial, add the coefficients
                double new_coefficient = polynomial.get(degree) + coefficient;
                if (new_coefficient == 0) {
                    // if the new coefficient is 0, remove the term from the polynomial
                    polynomial.remove(degree);
                } else {
                    // otherwise, update the coefficient of the existing term
                    polynomial.put(degree, new_coefficient);
                }
            } else {
                // if degree is negative, add the term with the opposite coefficient
                if (coefficient < 0) {
                    polynomial.put(degree, -coefficient);
                } else {
                    polynomial.put(degree, coefficient);
                }
            }
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Create a StringBuilder object to hold the string representation
        boolean isFirst = true; // A flag to keep track of whether the current term is the first term in the polynomial
        for (Map.Entry<Integer, Double> term : polynomial.entrySet()) { // Loop through each term in the polynomial
            int exponent = term.getKey(); // Get the exponent of the current term
            double coefficient = term.getValue(); // Get the coefficient of the current term
            if (coefficient != 0) { // Only include the term if the coefficient is non-zero
                String sign = ""; // Initialize the sign string
                if (coefficient < 0) { // If the coefficient is negative, set the sign to "-"
                    sign = "-";
                    coefficient = -coefficient; // Take the absolute value of the coefficient
                } else if (coefficient > 0) { // If the coefficient is positive, set the sign to "+"
                    sign = "+";
                    coefficient = +coefficient; // No need to change the sign, but keep the coefficient positive
                }
                String termStr = ""; // Initialize the string representation of the current term
                if (exponent == 0) { // If the exponent is zero, the term is a constant
                    termStr = Double.toString(coefficient);
                } else if (exponent == 1) { // If the exponent is one, the term is linear
                    termStr = (Math.abs(coefficient) == 1) ? "x" : Double.toString(Math.abs(coefficient)) + "x";
                    // If the absolute value of the coefficient is 1, only include "x", otherwise include the coefficient and "x"
                } else { // If the exponent is greater than one, the term is a polynomial term
                    termStr = (Math.abs(coefficient) == 1) ? "x^" + exponent : Double.toString(Math.abs(coefficient)) + "x^" + exponent;
                    // If the absolute value of the coefficient is 1, only include "x^exponent", otherwise include the coefficient and "x^exponent"
                }
                sb.insert(0, sign + termStr); // Add the sign and term string to the StringBuilder object
                isFirst = false; // Set the flag to false since we have now processed the first term
            }
        }
        return (sb.length() == 0) ? "0" : sb.toString(); // If the StringBuilder object is empty, the polynomial is zero, otherwise return the string representation
    }

    
 private Map<Integer, Double> getPolynomial() {
		// TODO Auto-generated method stub
		return null;
	}
 

}
  