package gui.parameters.parametar.model;

import gui.parameters.about.AboutView;
import gui.parameters.desktopShortcut.DesktopShortcutView;
import gui.parameters.logo.LogoView;
import gui.parameters.lookAndFeel.LookAndFeelView;
import gui.parameters.parametar.view.ParametarView;
import gui.parameters.path.PathView;

import javax.swing.*;
import java.io.Serializable;
import java.nio.file.Path;

public class ParametarModel implements Serializable
{

    private String name;
    private String label;
    private String GUI;
    private String content;

    private boolean predefined;

    public ParametarModel(String name, String label, String GUI, String content)
    {
        this.name = name;
        this.label = label;
        this.GUI = GUI;
        this.content = content;
        predefined = false;
    }

    public ParametarModel(String name, PredefinedParametarType type)
    {
        this.name = name;
        formLabel(type);
        formGUI(type);
        predefined = true;
    }

    private void formGUI(PredefinedParametarType type)
    {
        if(type == PredefinedParametarType.ABOUT)
            GUI = "ABOUT";
        if(type == PredefinedParametarType.DESKTOP_SHORTCUT)
            GUI = "DESKTOP_SHORTCUT";
        if(type == PredefinedParametarType.LOGO)
            GUI = "LOGO";
        if(type == PredefinedParametarType.LOOK_AND_FEEL)
            GUI = "LOOK_AND_FEEL";
        if(type == PredefinedParametarType.PATH)
            GUI = "PATH";
    }

    private void formLabel(PredefinedParametarType type)
    {
        if(type == PredefinedParametarType.ABOUT)
            label = "Upisite Vas about";
        if(type == PredefinedParametarType.DESKTOP_SHORTCUT)
            label = "Da li zelite precicu na Vasem Desktopu?";
        if(type == PredefinedParametarType.LOGO)
            label = "Izaberite Vas logo";
        if(type == PredefinedParametarType.LOOK_AND_FEEL)
            label = "Izaberite Vas izgled";
        if(type == PredefinedParametarType.PATH)
            label = "Izaberite putanju instalacije";
    }


    public String getContent()
    {
        return content;
    }

    public String getGUI()
    {
        return GUI;
    }

    public String getLabel()
    {
        return label;
    }

    public boolean isPredefined()
    {
        return predefined;
    }

    public String getName()
    {
        return name;
    }
}
