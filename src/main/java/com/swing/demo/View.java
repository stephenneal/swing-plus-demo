package com.swing.demo;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.layout.FormLayout;
import com.swing.binding.bbb.BindingService;
import com.swing.demo.address.AddressModel;
import com.swing.demo.address.AddressPanel;
import com.swing.demo.layout.LayoutFactory2;
import com.swing.demo.person.PersonModel;
import com.swing.demo.person.PersonPanel;

@SuppressWarnings("serial")
public class View extends JPanel {

    public static void main(String[] args) {
        final BindingService binding = new BindingService();
        final JPanel panel = createPanel(binding);
        final JFrame frame = new JFrame("Swing Plus Binding Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                binding.release();
            }
        });
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.getContentPane().add(panel, BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private static JPanel createPanel(BindingService bindingService) {
        PersonModel pModel = new PersonModel();
        pModel.setFirstName("Geoff");
        pModel.setMiddleNames("Robert");
        pModel.setSurname("Giles");
        pModel.setDateOfBirth(Calendar.getInstance().getTime());
        pModel.setId("A001");
        pModel.setTitle("Person");
        PersonPanel personPanel = new PersonPanel(pModel, bindingService);
        setDefaultBorder(personPanel, personPanel.getModel().getTitle());

        AddressModel aModel = new AddressModel();
        aModel.setAddress1("35 Runway Drive");
        aModel.setAddress2("");
        aModel.setSuburb("Happyville");
        aModel.setState("SA");
        aModel.setPostcode("5000");
        aModel.setTitle("Address");
        AddressPanel addressPanel = new AddressPanel(aModel, bindingService);
        setDefaultBorder(addressPanel, addressPanel.getModel().getTitle());

        JPanel panel = new JPanel();
        panel.setBorder(Borders.DIALOG);
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(LayoutFactory2.componentColumnSpec(2, 1, 2),
                        LayoutFactory2.relatedRowSpec(1)), panel);
        builder.append(personPanel);
        builder.append(addressPanel);
        return panel;
    }

    private static void setDefaultBorder(JPanel panel, String title) {
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(title), Borders.DIALOG));
    }
}
