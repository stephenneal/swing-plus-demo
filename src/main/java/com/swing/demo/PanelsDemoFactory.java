package com.swing.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jdesktop.observablecollections.ObservableCollections;

import com.jgoodies.forms.factories.Borders;
import com.swing.binding.bbb.BindingService;
import com.swing.demo.data.EnumConverter;
import com.swing.demo.data.EyeColours;
import com.swing.demo.data.Genders;
import com.swing.demo.data.States;
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
import com.swing.plus.PanelFactory;
import com.swing.demo.mvc.DualModePresentationModel.ViewMode;

public class PanelsDemoFactory {

    private PanelsDemoFactory() {
    }

    protected static AddressPanel newAddressPanel(BindingService bindingService, String title, boolean readOnly,
                    boolean populateDefault) {
        AddressModel model = new AddressModel();
        model.setTitle(title);
        if (readOnly) {
            model.setMode(ViewMode.READ_ONLY);
        }
        model.setStates(ObservableCollections.observableList(getStates()));
        model.setPostcodes(ObservableCollections.observableList(getPostcodes()));
        model.setSuburbs(ObservableCollections.observableList(getSuburbs()));
        if (populateDefault) {
            model.setAddress1("35 Runway Drive");
            // aModel.setAddress2("Doo Dah");
            model.setPostcode("5000");
            model.setState("SA");
            model.setSuburb("Happyville");
        }
        AddressPanel panel = new AddressPanel(model, bindingService);
        setDefaultBorder(panel, title);
        return panel;
    }

    protected static JPanel newAddressesPanel(BindingService bindingService, String title, boolean readOnly,
                    boolean populateDefault) {
        AddressPanel comboResAdd = newAddressPanel(bindingService, "Residential Address", true, true);
        AddressPanel comboPosAdd = newAddressPanel(bindingService, "Postal Address", true, true);
        JPanel panel = PanelFactory.grid(0, 1, comboResAdd, comboPosAdd);
        setDefaultBorder(panel, title);
        return panel;
    }

    protected static ContactsPanel newContactsPanel(BindingService bindingService, String title, boolean readOnly,
                    boolean populateDefault) {
        ContactsModel model = new ContactsModel();
        model.setTitle(title);
        if (readOnly) {
            model.setMode(ViewMode.READ_ONLY);
        }
        if (populateDefault) {
            model.setEmail("blah@blah.com");
            model.setFax("08 8111 1111");
            model.setPhoneHome("08 8111 1112");
            model.setPhoneWork("08 8111 1111");
            model.setPhoneMobile("0444 111 111");
        }
        ContactsPanel panel = new ContactsPanel(model, bindingService);
        setDefaultBorder(panel, title);
        return panel;
    }

    protected static NamePanel newNamePanel(BindingService bindingService, String title, boolean readOnly,
                    boolean populateDefault) {
        NameModel model = new NameModel();
        model.setTitle(title);
        if (readOnly) {
            model.setMode(ViewMode.READ_ONLY);
        }
        if (populateDefault) {
            model.setName("Some Other Name");
        }
        NamePanel panel = new NamePanel(model, bindingService);
        setDefaultBorder(panel, title);
        return panel;
    }

    protected static PersonPanel newPersonPanel(BindingService bindingService, String title, boolean readOnly,
                    boolean populateDefault) {
        PersonModel model = new PersonModel();
        model.setTitle(title);
        if (readOnly) {
            model.setMode(ViewMode.READ_ONLY);
        }
        if (populateDefault) {
            model.setFirstName("Geoff");
            model.setOtherNames("Robert");
            model.setSurname("Giles");
            model.setDateOfBirth(Calendar.getInstance().getTime());
            model.setId("A001");
        }
        PersonPanel panel = new PersonPanel(model, bindingService);
        setDefaultBorder(panel, title);
        return panel;
    }

    protected static PersonDetailsPanel newPersonDetailsPanel(BindingService bindingService, String title,
                    boolean readOnly, boolean populateDefault) {
        PersonDetailsModel model = new PersonDetailsModel();
        model.setTitle(title);
        if (readOnly) {
            model.setMode(ViewMode.READ_ONLY);
        }
        model.setEyeColours(ObservableCollections.observableList(getEyeColours()));
        model.setGenders(ObservableCollections.observableList(getGenders()));
        if (populateDefault) {
            model.setEyeColour("Brown");
            model.setGender("Male");
            model.setHeight("180");
            model.setTitle("Personal Details");
        }
        PersonDetailsPanel panel = new PersonDetailsPanel(model, bindingService);
        setDefaultBorder(panel, title);
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
