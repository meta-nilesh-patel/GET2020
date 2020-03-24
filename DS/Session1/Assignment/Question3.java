import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question3 {

    /**
     * This function converts an multivariate polynomial expression into nested list
     * form.
     * 
     * @param expression
     * @param noOfvariable
     * @return List which contain int type array which denotes an individual entity
     *         in expresiion. eg.- 2xy + x^2 + 3xy - [[2, 1, 1], [1, 2, 0], [3, 1,
     *         1]]
     */
    public static List<int[]> convertExpressionIntoNestedList(String expression, char[] variables) throws IOException {
        HashMap<Character, Integer> variablesIndex = new HashMap<>();
        for (int i = 0; i < variables.length; i++) {
            variablesIndex.put(variables[i], i);
        }
        expression = expression.replace(" ", "");

        if (expression == null) {
            throw new IOException("Input can't be null");
        }
        String[] expressionElementList = expression.split("[+-]");
        List<int[]> multivariatePolymomial = new ArrayList<>();
        int expressionIndex = 0;
        int i;
        boolean isNegative;
        for (String s : expressionElementList) {
            int[] elementArray = new int[variables.length + 1];
            i = 0;
            isNegative = expression.charAt(expressionIndex) == '-';
            while (i < s.length()) {
                if (Character.isLetter(s.charAt(0))) {
                    if (isNegative) {
                        elementArray[0] = -1;
                    } else {
                        elementArray[0] = 1;
                    }
                } else if (i == 0) {

                    String cofiecient = "";
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        cofiecient += s.charAt(i);
                        i++;
                    }
                    if (isNegative) {
                        elementArray[0] = -Integer.parseInt(cofiecient);
                    } else {
                        elementArray[0] = Integer.parseInt(cofiecient);
                    }

                    if (i >= s.length()) {
                        break;
                    }
                }
                int variableIndex = variablesIndex.get(s.charAt(i));
                if (i == s.length() - 1) {
                    elementArray[variableIndex + 1] = 1;
                    break;
                }
                if (Character.isLetter(s.charAt(i + 1))) {
                    elementArray[variableIndex + 1] = 1;
                    i++;
                } else {
                    i += 2;
                    if (i >= s.length()) {
                        break;
                    }
                    String cofiecient = "";
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        cofiecient += s.charAt(i);
                        i++;
                    }

                    elementArray[variableIndex + 1] = Integer.parseInt(cofiecient);

                }
            }
            multivariatePolymomial.add(elementArray);

        }
        return multivariatePolymomial;
    }

    /**
     * This function returns degree of multivariate polynomial
     * @param expression
     * @param variables
     * @return
     * @throws IOException
     */
    public static int getDegreeOfMultivariatePolynomial(String expression, char[] variables) throws IOException {
        List<int[]> multivariatePolymomial = convertExpressionIntoNestedList(expression, variables);
        int degree = 0;
        int[] degreeArr = new int[multivariatePolymomial.size()];
        for (int i = 0; i < multivariatePolymomial.size(); i++) {
            for (int j = 1; j < multivariatePolymomial.get(i).length; j++) {
                degreeArr[i] += multivariatePolymomial.get(i)[j];
            }
        }
        for (int i : degreeArr) {
            if (i > degree) {
                degree = i;
            }
        }
        return degree;
    }
    /*
     * public static void main(String[] args) { char[] c = { 'x', 'y' }; try { List
     * <int[]> multivariatePolymomial =
     * convertExpressionIntoNestedList("2xy + x^2 + 3xy + 424", c); for (int j = 0;
     * j < multivariatePolymomial.size(); j++) { for (int k = 0; k <
     * multivariatePolymomial.get(j).length; k++)
     * System.out.print(multivariatePolymomial.get(j)[k] + ", ");
     * System.out.print("\n"); } System.out.println(
     * getDegreeOfMultivariatePolynomial("2xy^100 + x^2 + 3xy + 424", c)); } catch
     * (Exception e) { e.printStackTrace(); } }
     */
}