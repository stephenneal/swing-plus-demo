package com.swing.demo.address;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.swing.binding.bbb.BindingService;

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
        AddressModel model = new AddressModel();
        model.setAddress1("35 Runway Drive");
        model.setAddress2("");
        model.setSuburb("Happyville");
        model.setState("SA");
        model.setPostcode("5000");
        return new AddressPanel(model, bindingService);
    }

}
