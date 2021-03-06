package com.javarush.test.level32.lesson15.big01;

import com.javarush.test.level32.lesson15.big01.listeners.FrameListener;
import com.javarush.test.level32.lesson15.big01.listeners.TabbedPaneChangeListener;
import com.javarush.test.level32.lesson15.big01.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener
{

    private Controller controller;

    private JTabbedPane tabbedPane = new JTabbedPane();

    private JTextPane htmlTextPane = new JTextPane();

    private JEditorPane plainTextPane = new JEditorPane();

    private UndoManager undoManager = new UndoManager();

    private UndoListener undoListener = new UndoListener(undoManager);

    public Controller getController()
    {
        return controller;
    }

    public UndoListener getUndoListener()
    {
        return undoListener;
    }

    public View()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }


    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String actionCommand = e.getActionCommand();
        switch (actionCommand){
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;

        }

    }

    public void init()
    {
        initGui();
        addWindowListener(new FrameListener(this));
        setVisible(true);

    }

    public void exit()
    {
        controller.exit();
    }

    public void initMenuBar()
    {
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }

    public void initEditor()
    {
        htmlTextPane.setContentType("text/html");

        JScrollPane pane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", pane);
        JScrollPane scrollPane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", scrollPane);

        tabbedPane.setPreferredSize(new Dimension(800, 600));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }

    public void initGui()
    {
        initMenuBar();
        initEditor();
        pack();

    }

    public void selectedTabChanged()
    {
        if (isHtmlTabSelected()){
            controller.setPlainText(plainTextPane.getText());
        } else {
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    public boolean canUndo()
    {
        return undoManager.canUndo();
    }

    public boolean canRedo()
    {
        return undoManager.canRedo();
    }

    public void undo()
    {
        try
        {
            undoManager.undo();
        }
        catch (CannotRedoException e)
        {
            ExceptionHandler.log(e);
        }
    }

    public void redo()
    {
        try
        {
            undoManager.redo();
        }
        catch (CannotRedoException e)
        {
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo()
    {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected()
    {
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab()
    {
        tabbedPane.setSelectedIndex(0);
        resetUndo();

    }

    public void update()
    {
        HTMLDocument document = controller.getDocument();
        htmlTextPane.setDocument(document);
    }

    public void showAbout()
    {
        JOptionPane.showMessageDialog(getContentPane(), "Hello,my dear friends!", "About", JOptionPane.INFORMATION_MESSAGE);
    }

}
