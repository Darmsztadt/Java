package lab13;

import observer.CConsoleObserver;
import observer.CFileObserver;
import observer.CJListObserver;
import solver.CSolver;
import solver.CSolverCreator;
import solver.CStepData;
import solver.ESolverType;

import javax.swing.*;
import java.awt.*;

//  tryCatch w CMAinForm w solveActionPerformed

public class CMainForm extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuPlik;
    private JMenu menuOptions;
    private JMenuItem itemExit;
    private JMenuItem itemSolve;
    private JMenuItem itemAbout;
    private JRadioButton rbFirst;
    private JRadioButton rbSecond;
    private JRadioButton rbFourth;
    private JTextField alphaTextField;
    private JTextField tkTextField;
    private JCheckBox cbPanel;
    private JCheckBox cbConsole;
    private JCheckBox cbFile;
    private JList list1;
    private JTextField omegaTextField;
    private JPanel mainPanel;

    DefaultListModel<Object> model;

    public CMainForm(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        model = new DefaultListModel<>();
        list1.setModel(model);


        itemExit.addActionListener(actionEvent -> {CMainForm.this.dispose();});

        itemAbout.addActionListener(actionEvent -> JOptionPane.showMessageDialog(
                CMainForm.this, "Programowanie obiektowe\n lab nr 11",
                "O programie", JOptionPane.INFORMATION_MESSAGE));

        itemSolve.addActionListener(actionEvent -> solveActionPerform());


    }

    private void solveActionPerform(){

        CSolverCreator sc = new CSolverCreator();

        ESolverType st = ESolverType.FIRST_ORDER;

        if (rbSecond.isSelected()) st = ESolverType.SECOND_ORDER;
        else if (rbFourth.isSelected()) st = ESolverType.FIRST_ORDER;

        try {
            CStepData init = new CStepData(
                    Double.parseDouble(tkTextField.getText().trim()),
                    Double.parseDouble(alphaTextField.getText().trim()),
                    Double.parseDouble(omegaTextField.getText().trim())
            );
            CSolver solverObj = sc.getSolver(st, init);
            if (cbPanel.isSelected())
                solverObj.addObserver(new CJListObserver(model));
            if (cbConsole.isSelected())
                solverObj.addObserver(new CConsoleObserver());
            if (cbFile.isSelected())
                solverObj.addObserver(new CFileObserver());

            solverObj.solve();
        } catch (Exception e){
            JOptionPane.showMessageDialog(
                    CMainForm.this, "Niepoprawna wartość",
                    "Błąd", JOptionPane.ERROR_MESSAGE);
        }


    }




}
