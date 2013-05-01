package com.swing.demo.panels;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.swing.binding.bbb.BindingService;
import com.swing.binding.bbb.StateBinding;
import com.swing.binding.bbb.TextBinding;
import com.swing.binding.bbb.ToedterCalendarBinding;
import com.swing.demo.layout.LayoutFactory2;
import com.swing.demo.panels.PersonModel.Properties;
import com.swing.plus.mvc.PlusJPanel;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class PersonPanel extends PlusJPanel<PersonModel> {

    private JLabel dateOfBirthLabel;
    // private JTextField dateOfBirth;
    private JDateChooser dateOfBirth;
    private JLabel dateDeceasedLabel;
    private JTextField dateDeceased;
    private JLabel idLabel;
    private JTextField id;
    private JLabel surnameLabel;
    private JTextField surname;
    private JLabel otherNamesLabel;
    private JTextField otherNames;
    private JLabel firstNameLabel;
    private JTextField firstName;

    public PersonPanel(PersonModel model, BindingService bindingService) {
        super(model, bindingService);

        // Create all the Swing components
        this.dateOfBirthLabel = newFieldLabel();
        this.dateOfBirth = new JDateChooser();
        this.dateDeceasedLabel = newFieldLabel();
        this.dateDeceased = new JTextField();
        this.idLabel = newFieldLabel();
        this.id = new JTextField();
        this.firstNameLabel = newFieldLabel();
        this.firstName = new JTextField();
        this.otherNamesLabel = newFieldLabel();
        this.otherNames = new JTextField();
        this.surnameLabel = newFieldLabel();
        this.surname = new JTextField();

        // Bind the Swing components to the model
        bind(TextBinding.text(model, Properties.DATE_OF_BIRTH_LABEL, this.dateOfBirthLabel));
        // bind(TextBinding.text(model, Properties.DATE_OF_BIRTH, this.dateOfBirth));
        bind(ToedterCalendarBinding.date(model, Properties.DATE_OF_BIRTH, this.dateOfBirth));
        // bind(StateBinding.editable(model, Properties.DATE_OF_BIRTH_EDITABLE, this.dateOfBirth));

        bind(TextBinding.text(model, Properties.DATE_DECEASED_LABEL, this.dateDeceasedLabel));
        bind(TextBinding.text(model, Properties.DATE_DECEASED, this.dateDeceased));
        bind(StateBinding.editable(model, Properties.DATE_DECEASED_EDITABLE, this.dateDeceased));
        bind(StateBinding.foreground(model, Properties.DATE_DECEASED_FG, this.dateDeceased));

        bind(TextBinding.text(model, Properties.ID_LABEL, this.idLabel));
        bind(TextBinding.text(model, Properties.ID, this.id));
        bind(StateBinding.editable(model, Properties.ID_EDITABLE, this.id));

        bind(TextBinding.text(model, Properties.FIRST_NAME_LABEL, this.firstNameLabel));
        bind(TextBinding.text(model, Properties.FIRST_NAME, this.firstName));
        bind(StateBinding.editable(model, Properties.FIRST_NAME_EDITABLE, this.firstName));

        bind(TextBinding.text(model, Properties.OTHER_NAMES_LABEL, this.otherNamesLabel));
        bind(TextBinding.text(model, Properties.OTHER_NAMES, this.otherNames));
        bind(StateBinding.editable(model, Properties.OTHER_NAMES_EDITABLE, this.otherNames));

        bind(TextBinding.text(model, Properties.SURNAME_LABEL, this.surnameLabel));
        bind(TextBinding.text(model, Properties.SURNAME, this.surname));
        bind(StateBinding.editable(model, Properties.SURNAME_EDITABLE, this.surname));

        // Lay out the components.
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(LayoutFactory2.componentColumnSpec(1, 1),
                        LayoutFactory2.relatedRowSpec(6)), this);
        builder.append(this.firstNameLabel);
        builder.append(this.firstName);
        builder.nextLine(2);
        builder.append(this.otherNamesLabel);
        builder.append(this.otherNames);
        builder.nextLine(2);
        builder.append(this.surnameLabel);
        builder.append(this.surname);
        builder.nextLine(2);
        builder.append(this.dateOfBirthLabel);
        builder.append(this.dateOfBirth);
        builder.nextLine(2);
        builder.append(this.dateDeceasedLabel);
        builder.append(this.dateDeceased);
        builder.nextLine(2);
        builder.append(this.idLabel);
        builder.append(this.id);
    }

}
