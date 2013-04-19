package com.swing.demo.person;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.swing.binding.bbb.BindingService;
import com.swing.binding.bbb.StateBinding;
import com.swing.binding.bbb.TextBinding;
import com.swing.demo.layout.LayoutFactory2;
import com.swing.plus.mvc.PlusJPanel;

@SuppressWarnings("serial")
public class PersonPanel extends PlusJPanel<PersonModel> {

    private JLabel dateOfBirthLabel;
    private JTextField dateOfBirth;
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
        this.dateOfBirth = new JTextField();
        this.idLabel = newFieldLabel();
        this.id = new JTextField();
        this.firstNameLabel = newFieldLabel();
        this.firstName = new JTextField();
        this.otherNamesLabel = newFieldLabel();
        this.otherNames = new JTextField();
        this.surnameLabel = newFieldLabel();
        this.surname = new JTextField();

        // Bind the Swing components to the model
        bind(TextBinding.text(model, "dateOfBirth", this.dateOfBirth));
        bind(TextBinding.text(model, "dateOfBirthLabel", this.dateOfBirthLabel));
        bind(StateBinding.editable(model, "dateOfBirthEditable", this.dateOfBirth));
        bind(TextBinding.text(model, "id", this.id));
        bind(TextBinding.text(model, "idLabel", this.idLabel));
        bind(StateBinding.editable(model, "idEditable", this.id));
        bind(TextBinding.text(model, "firstName", this.firstName));
        bind(TextBinding.text(model, "firstNameLabel", this.firstNameLabel));
        bind(StateBinding.editable(model, "firstNameEditable", this.firstName));
        bind(TextBinding.text(model, "otherNames", this.otherNames));
        bind(TextBinding.text(model, "otherNamesLabel", this.otherNamesLabel));
        bind(StateBinding.editable(model, "otherNamesEditable", this.otherNames));
        bind(TextBinding.text(model, "surname", this.surname));
        bind(TextBinding.text(model, "surnameLabel", this.surnameLabel));
        bind(StateBinding.editable(model, "surnameEditable", this.surname));

        // Lay out the components.
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(LayoutFactory2.componentColumnSpec(1, 1),
                        LayoutFactory2.relatedRowSpec(5)), this);
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
        builder.append(this.idLabel);
        builder.append(this.id);
    }

}
