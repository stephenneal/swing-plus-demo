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
import com.swing.demo.layout.LayoutFactory2;
import com.swing.plus.mvc.DualModePresentationModel.ViewMode;

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
        pModel.setOtherNames("Robert");
        pModel.setSurname("Giles");
        pModel.setDateOfBirth(Calendar.getInstance().getTime());
        pModel.setId("A001");
        pModel.setTitle("Person");
        pModel.setMode(ViewMode.READ_ONLY);
        PersonPanel personPanel = new PersonPanel(pModel, bindingService);
        setDefaultBorder(personPanel, personPanel.getModel().getTitle());

        AddressModel aModel = new AddressModel();
        aModel.setAddress1("35 Runway Drive");
        aModel.setAddress2("");
        aModel.setSuburb("Happyville");
        aModel.setState("SA");
        aModel.setPostcode("5000");
        aModel.setTitle("Address");
        aModel.setMode(ViewMode.READ_ONLY);
        AddressPanel addressPanel = new AddressPanel(aModel, bindingService);
        setDefaultBorder(addressPanel, addressPanel.getModel().getTitle());

        ContactsModel cModel = new ContactsModel();
        cModel.setEmail("blah@blah.com");
        cModel.setFax("08 8111 1111");
        cModel.setPhoneHome("08 8111 1112");
        cModel.setPhoneWork("08 8111 1111");
        cModel.setPhoneMobile("0444 111 111");
        cModel.setTitle("Contact");
        cModel.setMode(ViewMode.READ_ONLY);
        ContactsPanel contactsPanel = new ContactsPanel(cModel, bindingService);
        setDefaultBorder(contactsPanel, contactsPanel.getModel().getTitle());

        JPanel panel = new JPanel();
        panel.setBorder(Borders.DIALOG);
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(LayoutFactory2.relatedColumnSpec(2, 1, 2),
                        LayoutFactory2.relatedRowSpec(2)), panel);
        builder.append(personPanel);
        builder.append(addressPanel);
        builder.nextLine(2);
        builder.append(contactsPanel);
        return panel;
    }

    private static void setDefaultBorder(JPanel panel, String title) {
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(title), Borders.DIALOG));
    }
}
