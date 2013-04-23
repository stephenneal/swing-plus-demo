package com.swing.demo;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

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
import com.swing.demo.data.EnumConverter;
import com.swing.demo.data.EyeColours;
import com.swing.demo.data.Genders;
import com.swing.demo.data.States;
import com.swing.demo.layout.LayoutFactory2;
import com.swing.demo.panels.AddressModel;
import com.swing.demo.panels.AddressPanel;
import com.swing.demo.panels.ContactsModel;
import com.swing.demo.panels.ContactsPanel;
import com.swing.demo.panels.NameModel;
import com.swing.demo.panels.NamePanel;
import com.swing.demo.panels.PersonDetailsModel;
import com.swing.demo.panels.PersonDetailsPanel;
import com.swing.demo.panels.PersonModel;
import com.swing.demo.panels.PersonPanel;
import com.swing.plus.mvc.DualModePresentationModel.ViewMode;

@SuppressWarnings("serial")
public class PanelsDemo extends JPanel {

    @SuppressWarnings("unused")
    private static final Logger LOGGER = LoggerFactory.getLogger(PanelsDemo.class);

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
        pModel.setTitle("Details");
        pModel.setMode(ViewMode.READ_ONLY);
        PersonPanel personPanel = new PersonPanel(pModel, bindingService);
        setDefaultBorder(personPanel, personPanel.getModel().getTitle());

        NameModel nModel = new NameModel();
        nModel.setName("");
        nModel.setTitle("Trading As");
        nModel.setMode(ViewMode.READ_ONLY);
        NamePanel namePanel = new NamePanel(nModel, bindingService);
        setDefaultBorder(namePanel, namePanel.getModel().getTitle());

        final AddressModel raModel = new AddressModel();
        raModel.setAddress1("35 Runway Drive");
        // aModel.setAddress2("Doo Dah");
        raModel.setPostcodes(ObservableCollections.observableList(getPostcodes()));
        raModel.setPostcode("5000");
        raModel.setStates(ObservableCollections.observableList(getStates()));
        raModel.setState("SA");
        raModel.setSuburb("Happyville");
        raModel.setSuburbs(ObservableCollections.observableList(getSuburbs()));
        raModel.setTitle("Residential");
        raModel.setMode(ViewMode.READ_ONLY);
        AddressPanel resAddressPanel = new AddressPanel(raModel, bindingService);
        setDefaultBorder(resAddressPanel, resAddressPanel.getModel().getTitle());

        final AddressModel paModel = new AddressModel();
        paModel.setAddress1("PO BOX 31");
        // aModel.setAddress2("Doo Dah");
        paModel.setPostcodes(ObservableCollections.observableList(getPostcodes()));
        paModel.setPostcode("5000");
        paModel.setStates(ObservableCollections.observableList(getStates()));
        paModel.setState("SA");
        paModel.setSuburb("Happyville");
        paModel.setSuburbs(ObservableCollections.observableList(getSuburbs()));
        paModel.setTitle("Postal");
        paModel.setMode(ViewMode.READ_ONLY);
        AddressPanel posAddressPanel = new AddressPanel(paModel, bindingService);
        setDefaultBorder(posAddressPanel, posAddressPanel.getModel().getTitle());

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

        PersonDetailsModel pdModel = new PersonDetailsModel();
        pdModel.setEyeColour("Brown");
        pdModel.setEyeColours(ObservableCollections.observableList(getEyeColours()));
        pdModel.setGender("Male");
        pdModel.setGenders(ObservableCollections.observableList(getGenders()));
        pdModel.setHeight("180");
        pdModel.setTitle("Personal Details");
        pdModel.setMode(ViewMode.READ_ONLY);
        PersonDetailsPanel personDetailsPanel = new PersonDetailsPanel(pdModel, bindingService);
        setDefaultBorder(personDetailsPanel, personDetailsPanel.getModel().getTitle());

        JPanel panel = new JPanel();
        panel.setBorder(Borders.DIALOG);
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(LayoutFactory2.relatedColumnSpec(2, 1, 2),
                        LayoutFactory2.relatedRowSpec(4, "top")), panel);
        builder.append(personPanel);
        builder.append(resAddressPanel);
        builder.nextLine(2);
        builder.append(namePanel);
        builder.append(posAddressPanel);
        builder.nextLine(2);
        builder.append(contactsPanel);
        builder.nextLine(2);
        builder.append(personDetailsPanel);

        return panel;
    }

    private static void setDefaultBorder(JPanel panel, String title) {
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(title), Borders.DIALOG));
    }

    private static List<String> getEyeColours() {
        return Arrays.asList(EnumConverter.wordsTitleCase(EyeColours.values()));
    }

    private static List<String> getGenders() {
        return Arrays.asList(EnumConverter.wordsTitleCase(Genders.values()));
    }

    private static List<String> getPostcodes() {
        List<String> l = new ArrayList<String>();
        l.add("5000");
        l.add("5001");
        l.add("5003");
        l.add("5004");
        l.add("5005");
        l.add("5006");
        return l;
    }

    private static List<String> getStates() {
        return Arrays.asList(EnumConverter.nameToString(States.values()));
    }

    private static List<String> getSuburbs() {
        List<String> l = new ArrayList<String>();
        l.add("Anywhere");
        l.add("Happyville");
        l.add("Here And There");
        l.add("Suburbia");
        return l;
    }

}
