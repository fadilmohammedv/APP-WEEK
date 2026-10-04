import javax.swing.*;
import java.awt.*;

public class Q6_TextEditor extends JFrame {
    JTextArea textArea = new JTextArea();

    public Q6_TextEditor() {
        setTitle("Simple Text Editor");

        JMenuBar bar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem exitItem = new JMenuItem("Exit");
        file.add(newItem); file.add(clearItem); file.addSeparator(); file.add(exitItem);

        JMenu edit = new JMenu("Edit");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem selectAll = new JMenuItem("Select All");
        edit.add(cut); edit.add(copy); edit.add(paste); edit.addSeparator(); edit.add(selectAll);

        bar.add(file); bar.add(edit);
        setJMenuBar(bar);

        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        newItem.addActionListener(e -> {
            if (!textArea.getText().isEmpty()) {
                int c = JOptionPane.showConfirmDialog(this, "Discard current text and start new?", "New", JOptionPane.YES_NO_OPTION);
                if (c != JOptionPane.YES_OPTION) return;
            }
            textArea.setText("");
        });
        clearItem.addActionListener(e -> textArea.setText(""));
        exitItem.addActionListener(e -> System.exit(0));

        cut.addActionListener(e -> textArea.cut());
        copy.addActionListener(e -> textArea.copy());
        paste.addActionListener(e -> textArea.paste());
        selectAll.addActionListener(e -> textArea.selectAll());

        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Q6_TextEditor::new);
    }
}
