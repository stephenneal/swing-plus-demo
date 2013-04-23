package com.swing.demo;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jdesktop.observablecollections.ObservableCollections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.layout.FormLayout;
import com.swing.binding.bbb.BindingService;
import com.swing.demo.layout.LayoutFactory2;
import com.swing.plus.mvc.DualModePresentationModel.ViewMode;

@SuppressWarnings("serial")
public class View extends JPanel {

    private static final Logger LOGGER = LoggerFactory.getLogger(View.class);

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

        final AddressModel aModel = new AddressModel();
        aModel.setAddress1("35 Runway Drive");
        // aModel.setAddress2("Doo Dah");
        aModel.setPostcodes(ObservableCollections.observableList(getPostcodes()));
        aModel.setPostcode("5000");
        aModel.setSuburb("Happyville");
        aModel.setStates(ObservableCollections.observableList(getStates()));
        aModel.setState("SA");
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
                        LayoutFactory2.relatedRowSpec(2, "top")), panel);
        builder.append(personPanel);
        builder.append(addressPanel);
        builder.nextLine(2);
        builder.append(contactsPanel);

        // Schedule some tasks to update combo boxes (they are properly updated)
        final ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        pool.schedule(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("changing states list");
                aModel.setStates(ObservableCollections.observableList(getStates2()));
            }
        }, 5, TimeUnit.SECONDS);
        pool.schedule(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("adding postcodes");
                aModel.getPostcodes().addAll(getPostcodes2());
            }
        }, 10, TimeUnit.SECONDS);
        pool.shutdown();

        return panel;
    }

    private static void setDefaultBorder(JPanel panel, String title) {
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(title), Borders.DIALOG));
    }

    private static List<String> getPostcodes() {
        List<String> postcodes = new ArrayList<String>();
        postcodes.add("5000");
        postcodes.add("5001");
        postcodes.add("5003");
        postcodes.add("5004");
        postcodes.add("5005");
        postcodes.add("5006");
        return postcodes;
    }

    private static List<String> getPostcodes2() {
        List<String> postcodes = new ArrayList<String>();
        postcodes.add("5007");
        postcodes.add("5008");
        postcodes.add("5009");
        postcodes.add("5010");
        postcodes.add("5011");
        postcodes.add("5012");
        return postcodes;
    }

    private static List<String> getStates() {
        List<String> states = new ArrayList<String>();
        states.add("SA");
        states.add("NSW");
        states.add("QLD");
        states.add("TAS");
        states.add("VIC");
        states.add("WA");
        return states;
    }

    private static List<String> getStates2() {
        List<String> states = new ArrayList<String>();
        states.add("QLD");
        states.add("VIC");
        return states;
    }
}
