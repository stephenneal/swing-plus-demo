package com.swing.demo.person;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.swing.binding.bbb.AbstractPanel;
import com.swing.binding.bbb.BindingService;
import com.swing.binding.bbb.StateBinding;
import com.swing.binding.bbb.TextBinding;
import com.swing.demo.layout.LayoutFactory2;

@SuppressWarnings("serial")
public class PersonPanel extends AbstractPanel<PersonModel> {

    private JLabel dateOfBirthLabel;
    private JTextField dateOfBirth;
    private JLabel idLabel;
    private JTextField id;
    private JLabel surnameLabel;
    private JTextField surname;
    private JLabel middleNamesLabel;
    private JTextField middleNames;
    private JLabel firstNameLabel;
    private JTextField firstName;

    public PersonPanel(PersonModel model, BindingService bindingService) {
        super(model, bindingService);

        // Create all the Swing components
        this.dateOfBirthLabel = newFieldLabel("Date of Birth");
        this.dateOfBirth = new JTextField();
        this.idLabel = newFieldLabel("Id");
        this.id = new JTextField();
        this.firstNameLabel = newFieldLabel("First name");
        this.firstName = new JTextField();
        this.middleNamesLabel = newFieldLabel("Middle name(s)");
        this.middleNames = new JTextField();
        this.surnameLabel = newFieldLabel("Surname");
        this.surname = new JTextField();

        // Bind the Swing components to the model
        bind(TextBinding.text(model, "dateOfBirth", this.dateOfBirth));
        bind(StateBinding.editable(model, "dateOfBirthEditable", this.dateOfBirth));
        bind(TextBinding.text(model, "id", this.id));
        bind(StateBinding.editable(model, "idEditable", this.id));
        bind(TextBinding.text(model, "firstName", this.firstName));
        bind(StateBinding.editable(model, "firstNameEditable", this.firstName));
        bind(TextBinding.text(model, "middleNames", this.middleNames));
        bind(StateBinding.editable(model, "middleNamesEditable", this.middleNames));
        bind(TextBinding.text(model, "surname", this.surname));
        bind(StateBinding.editable(model, "surnameEditable", this.surname));

        // Lay out the components.
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(LayoutFactory2.componentColumnSpec(1, 1),
                        LayoutFactory2.relatedRowSpec(5)), this);
        builder.append(this.firstNameLabel);
        builder.append(this.firstName);
        builder.nextLine(2);
        builder.append(this.middleNamesLabel);
        builder.append(this.middleNames);
        builder.nextLine(2);
        builder.append(this.surnameLabel);
        builder.append(this.surname);
        builder.nextLine(2);
        builder.append(this.dateOfBirthLabel);
        builder.append(this.dateOfBirth);
        builder.nextLine(2);
        builder.append(this.idLabel);
        builder.append(this.id);
    }

    private static JLabel newFieldLabel(String label) {
        JLabel l = new JLabel(label);
        // l.setBorder(BorderFactory.createEtchedBorder());
        return l;
    }
}
