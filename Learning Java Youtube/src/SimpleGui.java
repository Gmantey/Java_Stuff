import javax.swing.*;

public class SimpleGui {

    public static void main(String[] args) {


        //input variables
        String name;
        String age;
        String occupation;
        String email;
        int greeting;

        do {
            greeting = JOptionPane.showConfirmDialog(null, "Would you like to generate a business card?",
                    "Business Card", JOptionPane.YES_NO_OPTION);
            if (greeting == JOptionPane.NO_OPTION){
                return;
            }

            name = JOptionPane.showInputDialog(null, "What is your name?", "Business Card",
                    JOptionPane.QUESTION_MESSAGE);
            age = JOptionPane.showInputDialog(null, "How old are you?", "Business Card",
                    JOptionPane.QUESTION_MESSAGE);
            occupation = JOptionPane.showInputDialog(null, "Occupation?", "Business Card",
                    JOptionPane.QUESTION_MESSAGE);
            email = JOptionPane.showInputDialog(null, "What is your email?", "Business Card",
                    JOptionPane.QUESTION_MESSAGE);

            // Show Business Card
            JOptionPane.showMessageDialog(null, "Name: " + name + "\nAge: " + age + "\nOccupation: " +
                    occupation + "\nEmail: " + email, "Business Card", JOptionPane.INFORMATION_MESSAGE);



        } while (greeting == JOptionPane.YES_OPTION);




    }
}
