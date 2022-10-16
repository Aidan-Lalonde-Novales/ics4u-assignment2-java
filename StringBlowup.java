/*
* Assignment 2 - String Manipulation
* This program multiplies characters together and prints them out.
*
* @author  Aidan Lalonde-Novales
* @version 1.0
* @since   2022-10-13
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This is Main class.
 */
final class StringBlowup {
    /**
     * Prevent instantiation.
     * Throw an exception IllegalStateException.
     * if this ever is called
     *
     * @throws IllegalStateException
     *
     */
    private StringBlowup() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * The strBlowup() function.
     *
     * @param baseString this is the unmodified user string input.
     * @return finalString this is the final string to be outputted.
     */
    public static String strBlowup(final String baseString) {
        final ArrayList<String> finalList = new ArrayList<String>();

        // Allows more versitile string manipulation
        final String[] splitArray = baseString.split("");
        final List<String> splitString = new ArrayList<String>();
        Collections.addAll(splitString, splitArray);

        final String numCheck = "[0-9.]+";

        for (int counter = 0; counter < splitString.size(); counter++) {
            final String item = splitString.get(counter);
            String tempString = "";

            // Run if letter appears
            if (!(splitString.get(counter)).matches(numCheck)) {
                if (counter != 0) {
                    if (!(splitString.get(counter - 1)).matches(numCheck)) {
                        tempString = item;
                        finalList.add(tempString);
                    }
                } else {
                    tempString = item;
                    finalList.add(tempString);
                }

            // Run if number appears
            } else {
                if ((counter + 1) < splitString.size()) {
                    final int itemCount = Integer.parseInt(item);
                    for (int mCounter = 0; mCounter < itemCount; mCounter++) {
                        tempString =
                            tempString.concat(splitString.get(counter + 1));
                    }
                    if (!(splitString.get(counter + 1)).matches(numCheck)) {
                        splitString.remove(counter);
                    }
                }
                finalList.add(tempString);
            }
        }
        // Final Output is formed here
        final String finalString = String.join("", finalList);
        return finalString;
    }

    /**
     * The starting main() function.
     *
     * @param args No args will be used
     */
    public static void main(String[] args) {
        // Input
        final Scanner stringObj = new Scanner(System.in);
        System.out.printf("Enter numbers/letters to multiply them: ");
        final String baseString = stringObj.nextLine();

        // Process
        final String finalString = strBlowup(baseString);

        // Output
        System.out.println("\n" + finalString);

        System.out.println("\nDone.");
    }
}
