package com.swing.demo;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.Property;
import org.jdesktop.observablecollections.ObservableList;

import com.swing.binding.bbb.BindingService;
import com.swing.binding.bbb.TextBinding;
import com.swing.binding.bbb.mvc.PresentationModel;
import com.swing.demo.SwingBindingDemo.BindingPrototypeModel.Properties;
import com.swing.plus.PanelFactory;

@SuppressWarnings("serial")
public class SwingBindingDemo extends JPanel {

    public static void main(String[] args) {
        final BindingService binding = new BindingService();
        final SwingBindingDemo prototype = createPrototype(binding);
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
                frame.getContentPane().add(prototype, BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private static SwingBindingDemo createPrototype(BindingService bindingService) {
        BindingPrototypeModel model = new BindingPrototypeModel();
        model.setField1Label("String");
        model.setField2Label("Double");
        model.setField3Label("Date");
        model.setField4Label("Date/Time");
        model.setString("Some value");
        model.setDuble(new Double(20.00));
        model.setDate(Calendar.getInstance().getTime());
        model.setDateTime(Calendar.getInstance().getTime());
        return new SwingBindingDemo(model, bindingService);
    }

    // Input components
    private JLabel field1Label;
    private JTextField field1;
    private JLabel field2Label;
    private JTextField field2;
    private JLabel field3Label;
    private JTextField field3;
    private JLabel field4Label;
    private JTextField field4;

    // Output components
    private JLabel field1OutputLabel;
    private JLabel field1Output;
    private JLabel field2OutputLabel;
    private JLabel field2Output;
    private JLabel field3OutputLabel;
    private JLabel field3Output;
    private JLabel field4OutputLabel;
    private JLabel field4Output;

    private BindingService bindingService;

    public SwingBindingDemo(BindingPrototypeModel model, BindingService bindingService) {
        super();
        this.bindingService = bindingService;
        // Create all the Swing components
        this.field1Label = new JLabel();
        this.field1 = new JTextField();
        this.field2Label = new JLabel();
        this.field2 = new JTextField();
        this.field3Label = new JLabel();
        this.field3 = new JTextField();
        this.field4Label = new JLabel();
        this.field4 = new JTextField();

        this.field1OutputLabel = new JLabel();
        this.field1Output = new JLabel();
        this.field1Output.setBorder(BorderFactory.createEtchedBorder());
        this.field2OutputLabel = new JLabel();
        this.field2Output = new JLabel();
        this.field2Output.setBorder(BorderFactory.createEtchedBorder());
        this.field3OutputLabel = new JLabel();
        this.field3Output = new JLabel();
        this.field3Output.setBorder(BorderFactory.createEtchedBorder());
        this.field4OutputLabel = new JLabel();
        this.field4Output = new JLabel();
        this.field4Output.setBorder(BorderFactory.createEtchedBorder());

        // Bind the Swing components to the model
        bind(TextBinding.text(model, Properties.FIELD1_LABEL, this.field1Label));
        bind(TextBinding.text(model, Properties.FIELD2_LABEL, this.field2Label));
        bind(TextBinding.text(model, Properties.FIELD3_LABEL, this.field3Label));
        bind(TextBinding.text(model, Properties.FIELD3_LABEL, this.field4Label));
        bind(TextBinding.text(model, Properties.FIELD1_LABEL, this.field1OutputLabel));
        bind(TextBinding.text(model, Properties.FIELD2_LABEL, this.field2OutputLabel));
        bind(TextBinding.text(model, Properties.FIELD3_LABEL, this.field3OutputLabel));
        bind(TextBinding.text(model, Properties.FIELD3_LABEL, this.field4OutputLabel));

        bind(TextBinding.text(model, Properties.STRING, this.field1));
        bind(TextBinding.text(model, Properties.DOUBLE, this.field2));
        bind(TextBinding.text(model, Properties.DATE, this.field3));
        bind(TextBinding.text(model, Properties.DATE_TIME, this.field4, DateFormat.getDateTimeInstance()));

        bind(TextBinding.text(model, Properties.STRING, this.field1Output));
        bind(TextBinding.text(model, Properties.DOUBLE, this.field2Output));
        bind(TextBinding.text(model, Properties.DATE, this.field3Output));
        bind(TextBinding.text(model, Properties.DATE_TIME, this.field4Output, DateFormat.getDateTimeInstance()));

        // Lay the components. For simplicity this just uses box layout, its not pretty. Better Swing layouts
        // include MigLayout and JGoodies FormLayout but that is outside the scope of this prototype.
        JPanel input = PanelFactory.boxY();
        input.setBorder(BorderFactory.createTitledBorder("Input"));
        input.add(PanelFactory.boxX(this.field1Label, this.field1));
        input.add(PanelFactory.boxX(this.field2Label, this.field2));
        input.add(PanelFactory.boxX(this.field3Label, this.field3));
        input.add(PanelFactory.boxX(this.field4Label, this.field4));

        JPanel output = PanelFactory.boxY();
        output.setBorder(BorderFactory.createTitledBorder("Output"));
        output.add(PanelFactory.boxX(this.field1OutputLabel, this.field1Output));
        output.add(PanelFactory.boxX(this.field2OutputLabel, this.field2Output));
        output.add(PanelFactory.boxX(this.field3OutputLabel, this.field3Output));
        output.add(PanelFactory.boxX(this.field4OutputLabel, this.field4Output));

        PanelFactory.box(this, BoxLayout.Y_AXIS, input, output);
    }

    private void bind(Binding<?, ?, ?, ?> binding) {
        if (binding == null) {
            return;
        }
        this.bindingService.bind(binding);
    }

    /**
     * Model for this prototype, must be public for BetterBeansBinding to work
     */
    public static class BindingPrototypeModel extends PresentationModel {

        /**
         * Defines properties that can be bound on this model.
         */
        public static class Properties extends PresentationModel.Properties {
            public static Property<BindingPrototypeModel, Date> DATE = create("date");
            public static Property<BindingPrototypeModel, Date> DATE_TIME = create("dateTime");
            public static Property<BindingPrototypeModel, Double> DOUBLE = create("duble");
            public static Property<BindingPrototypeModel, String> STRING = create("string");
            public static Property<BindingPrototypeModel, List<String>> STRING_LIST = create("stringList");
            public static Property<BindingPrototypeModel, List<BindingPrototypeModel>> TEST_BEANS = create("testBeans");
            public static Property<BindingPrototypeModel, List<BindingPrototypeModel>> TEST_BEANS_SELECTED = create("testBeansSelected");

            public static Property<BindingPrototypeModel, String> FIELD1_LABEL = create("field1Label");
            public static Property<BindingPrototypeModel, String> FIELD2_LABEL = create("field2Label");
            public static Property<BindingPrototypeModel, String> FIELD3_LABEL = create("field3Label");
            public static Property<BindingPrototypeModel, String> FIELD4_NAMES_LABEL = create("field4Label");
        }

        private String field1Label;
        private String field2Label;
        private String field3Label;
        private String field4Label;

        private Date date;
        private Date dateTime;
        private Double duble;
        private ObservableList<String> stringList;
        private String string;
        private ObservableList<BindingPrototypeModel> testBeans;
        private ObservableList<BindingPrototypeModel> testBeansSelected;

        private BindingPrototypeModel() {
            super();
        }

        public String getField1Label() {
            return this.field1Label;
        }

        public void setField1Label(String newValue) {
            String oldValue = this.field1Label;
            this.field1Label = newValue;
            firePropertyChange("field1Label", oldValue, newValue);
        }

        public String getField2Label() {
            return this.field2Label;
        }

        public void setField2Label(String newValue) {
            String oldValue = this.field2Label;
            this.field2Label = newValue;
            firePropertyChange("field2Label", oldValue, newValue);
        }

        public String getField3Label() {
            return this.field3Label;
        }

        public void setField3Label(String newValue) {
            String oldValue = this.field3Label;
            this.field3Label = newValue;
            firePropertyChange("field3Label", oldValue, newValue);
        }

        public String getField4Label() {
            return this.field4Label;
        }

        public void setField4Label(String newValue) {
            String oldValue = this.field4Label;
            this.field4Label = newValue;
            firePropertyChange("field4Label", oldValue, newValue);
        }

        public Date getDate() {
            return this.date;
        }

        public void setDate(Date newValue) {
            Date oldValue = this.date;
            this.date = newValue;
            firePropertyChange("date", oldValue, newValue);
        }

        public Date getDateTime() {
            return this.dateTime;
        }

        public void setDateTime(Date newValue) {
            Date oldValue = this.dateTime;
            this.dateTime = newValue;
            firePropertyChange("dateTime", oldValue, newValue);
        }

        public Double getDuble() {
            return this.duble;
        }

        public void setDuble(Double newValue) {
            Double oldValue = this.duble;
            this.duble = newValue;
            firePropertyChange("duble", oldValue, newValue);
        }

        public ObservableList<String> getStringList() {
            return this.stringList;
        }

        public void setStringList(ObservableList<String> newValue) {
            ObservableList<String> oldValue = this.stringList;
            this.stringList = newValue;
            firePropertyChange("stringList", oldValue, newValue);
        }

        public String getString() {
            return this.string;
        }

        public void setString(String newValue) {
            String oldValue = this.string;
            this.string = newValue;
            firePropertyChange("string", oldValue, newValue);
        }

        public ObservableList<BindingPrototypeModel> getTestBeans() {
            return this.testBeans;
        }

        public void setTestBeans(ObservableList<BindingPrototypeModel> newValue) {
            ObservableList<BindingPrototypeModel> oldValue = this.testBeans;
            this.testBeans = newValue;
            firePropertyChange("testBeans", oldValue, newValue);
        }

        public ObservableList<BindingPrototypeModel> getTestBeansSelected() {
            return this.testBeansSelected;
        }

        public void setTestBeansSelected(ObservableList<BindingPrototypeModel> newValue) {
            ObservableList<BindingPrototypeModel> oldValue = this.testBeansSelected;
            this.testBeansSelected = newValue;
            firePropertyChange("testBeansSelected", oldValue, newValue);
        }

    }

}
