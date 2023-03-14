package ro.tuc.tp.gui;

import ro.tuc.tp.logic.Operations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private View view;

    private Operations operations = new Operations();

    public Controller(View v){
        this.view = v;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command == "COMPUTE"){
            int firstNumber = Integer.valueOf(view.getFirstNumberTextField().getText());
            int secondNumber = Integer.valueOf(view.getSecondNumberTextField().getText());
            String operation = String.valueOf(view.getOperationsComboBox().getSelectedItem());
            int result = 0;
            switch(operation){
                case "Add": result = operations.add(firstNumber, secondNumber);
                            break;
                case "Subtract": result = operations.subtract(firstNumber, secondNumber);
                                break;
                case "Multiply": result = operations.multiply(firstNumber, secondNumber);
                                break;
            }
            view.getResultValueLabel().setText(String.valueOf(result));
        }
    }

}
