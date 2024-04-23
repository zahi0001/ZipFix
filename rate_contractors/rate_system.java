import javax.swing.JOptionPane;

public class rate_system {
    // Calculates new rating by figuring out what the new user choose and including it in the new total
    public static double[] addNewRating(int[] numberOfType, int totalRatings) {
        double newRating = 0;
        while (newRating > 5 || newRating < 1) {
            newRating = Integer.parseInt(JOptionPane.showInputDialog("Enter your Rating from numbers 1-5:"));
            if (newRating == 1) {
                numberOfType[0]++;
                totalRatings++;
            } else if (newRating == 2) {
                numberOfType[1]++;
                totalRatings++;
            } else if (newRating == 3) {
                numberOfType[2]++;
                totalRatings++;
            } else if (newRating == 4) {
                numberOfType[3]++;
                totalRatings++;
            } else if (newRating == 5) {
                numberOfType[4]++;
                totalRatings++;
            }
        }
        // Rounds the rating and stores the information to be sent back and updates
        double rating = ((1 * numberOfType[0] + 2 * numberOfType[1] + 3 * numberOfType[2] + 4 * numberOfType[3] + 5 * numberOfType[4]) / (double) totalRatings);
        rating = Math.round(rating * 10) / 10.0;
        double[] ratingData = new double[numberOfType.length + 2];
        for (int i = 0; i < numberOfType.length; i++) {
            ratingData[i] = numberOfType[i];
        }
        ratingData[numberOfType.length] = rating;
        ratingData[numberOfType.length + 1] = totalRatings;
        return ratingData;
    }

    public static void main(String[] args) {
        String contractor = "bobTheBuilder|4.1|2|1|3|10|15";
        String[] contractorData = contractor.split("\\|");
        String username = contractorData[0];
        double rating = Double.parseDouble(contractorData[1]);
        int[] numberOfType = new int[5];
        int totalRatings = 0;

        // Gathers types of rating and send it to function
        for (int i = 0; i < 5; i++) {
            numberOfType[i] = Integer.parseInt(contractorData[i + 2]);
            totalRatings += numberOfType[i];
        }
        double[] ratingData = addNewRating(numberOfType, totalRatings);

        // Puts new info together and overrides old info
        String newInfo = username + "|" + ratingData[ratingData.length - 2] + "|";
        for (int i = 0; i < 5; i++) {
            newInfo += (int) ratingData[i] + "|";
        }
        newInfo += (int) ratingData[ratingData.length - 1];
        System.out.println(newInfo);
    }
}
