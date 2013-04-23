package com.swing.demo.panels;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.swing.binding.bbb.BindingService;
import com.swing.binding.bbb.ListBinding;
import com.swing.binding.bbb.StateBinding;
import com.swing.binding.bbb.TextBinding;
import com.swing.demo.layout.LayoutFactory2;
import com.swing.demo.panels.PersonDetailsModel.Properties;
import com.swing.plus.mvc.PlusJPanel;

@SuppressWarnings("serial")
public class PersonDetailsPanel extends PlusJPanel<PersonDetailsModel> {

    private JLabel heightLabel;
    private JTextField height;
    private JLabel genderLabel;
    // private JTextField gender;
    private JComboBox genders;
    private JLabel eyeColourLabel;
    // private JTextField eyeColour;
    private JComboBox eyeColours;

    public PersonDetailsPanel(PersonDetailsModel model, BindingService bindingService) {
        super(model, bindingService);

        // Create all the Swing components
        this.heightLabel = newFieldLabel();
        this.height = new JTextField();
        this.genderLabel = newFieldLabel();
        // this.gender = new JTextField();
        this.genders = new JComboBox();
        this.eyeColourLabel = newFieldLabel();
        // this.eyeColour = new JTextField();
        this.eyeColours = new JComboBox();

        // Bind the Swing components to the model
        bind(TextBinding.text(model, Properties.HEIGHT_LABEL, this.heightLabel));
        bind(TextBinding.text(model, Properties.HEIGHT, this.height));
        bind(StateBinding.editable(model, Properties.HEIGHT_EDITABLE, this.height));

        bind(TextBinding.text(model, Properties.GENDER_LABEL, this.genderLabel));
        // bind(TextBinding.text(model, Properties.GENDER, this.gender));
        // bind(StateBinding.editable(model, Properties.GENDER_EDITABLE, this.gender));
        bind(ListBinding.model(model, Properties.GENDERS, this.genders));
        bind(ListBinding.selection(model, Properties.GENDER, this.genders));
        bind(StateBinding.editable(model, Properties.GENDER_EDITABLE, this.genders));

        bind(TextBinding.text(model, Properties.EYE_COLOUR_LABEL, this.eyeColourLabel));
        // bind(TextBinding.text(model, Properties.EYE_COLOUR, this.eyeColour));
        // bind(StateBinding.editable(model, Properties.EYE_COLOUR_EDITABLE, this.eyeColour));
        bind(ListBinding.model(model, Properties.EYE_COLOURS, this.eyeColours));
        bind(ListBinding.selection(model, Properties.EYE_COLOUR, this.eyeColours));
        bind(StateBinding.editable(model, Properties.EYE_COLOUR_EDITABLE, this.eyeColours));

        // Lay out the components.
        DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout(LayoutFactory2.componentColumnSpec(2, 1, 2),
                        LayoutFactory2.relatedRowSpec(3)), this);
        builder.append(this.genderLabel);
        // builder.append(this.gender);
        builder.append(this.genders);
        builder.nextLine(2);
        builder.append(this.heightLabel);
        builder.append(this.height, 5);
        builder.nextLine(2);
        builder.append(this.eyeColourLabel);
        // builder.append(this.eyeColour);
        builder.append(this.eyeColours);
    }

}
