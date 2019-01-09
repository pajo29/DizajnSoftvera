<<<<<<< HEAD
package parameters.parametar.model;

import tree.treeModel.Parametar;

import java.io.Serializable;

public class ParametarModel implements Serializable
{

    private String name;
    private String label;
    private String GUI;
    private String content = "";

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

    public ParametarModel(ParametarModel parametarModel)
    {
        this.name = parametarModel.getName();
        this.label = parametarModel.getLabel();
        this.GUI = parametarModel.getGUI();
        this.predefined = parametarModel.isPredefined();
        this.content = parametarModel.getContent();
    }

    private void formGUI(PredefinedParametarType type)
    {
        if(type == PredefinedParametarType.TERMS_OF_USE)
            GUI = type.toString();
        if(type == PredefinedParametarType.DESKTOP_SHORTCUT)
            GUI = type.toString();
        if(type == PredefinedParametarType.LOGO)
            GUI = type.toString();
        if(type == PredefinedParametarType.LOOK_AND_FEEL)
            GUI = type.toString();
        if(type == PredefinedParametarType.NAME)
            GUI = type.toString();
        if(type == PredefinedParametarType.AUTHOR)
            GUI = type.toString();
        if(type == PredefinedParametarType.START_AFTER_INSTALL)
            GUI = type.toString();
        if(type == PredefinedParametarType.PATH)
        {
            GUI = type.toString();
        }
    }

    private void formLabel(PredefinedParametarType type)
    {
        if(type == PredefinedParametarType.TERMS_OF_USE)
            label = "USLOVI KORISCENJA:";
        if(type == PredefinedParametarType.DESKTOP_SHORTCUT)
            label = "Da li zelite precicu na Vasem Desktopu?";
        if(type == PredefinedParametarType.LOGO)
            label = "Izaberite Vas logo";
        if(type == PredefinedParametarType.LOOK_AND_FEEL)
            label = "Izaberite Vas izgled";
        if(type == PredefinedParametarType.NAME)
            label = "IME PROIZVODA:";
        if(type == PredefinedParametarType.AUTHOR)
            label = "O AUTORU";
        if(type == PredefinedParametarType.START_AFTER_INSTALL)
            label = "Pokrenuti nakon instalacije";
        if(type == PredefinedParametarType.PATH)
            label = "Izaberite putanju instalacije";
    }

    @Override
    public String toString()
    {
        return name;
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

    public void setContent(String content)
    {
        this.content = content;
    }
}
=======
package parameters.parametar.model;

import tree.treeModel.Parametar;

import java.io.Serializable;

public class ParametarModel implements Serializable
{

    private String name;
    private String label;
    private String GUI;
    private String content = "";

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

    public ParametarModel(ParametarModel parametarModel)
    {
        this.name = parametarModel.getName();
        this.label = parametarModel.getLabel();
        this.GUI = parametarModel.getGUI();
        this.predefined = parametarModel.isPredefined();
        this.content = parametarModel.getContent();
    }

    private void formGUI(PredefinedParametarType type)
    {
        if(type == PredefinedParametarType.TERMS_OF_USE)
            GUI = type.toString();
        if(type == PredefinedParametarType.DESKTOP_SHORTCUT)
            GUI = type.toString();
        if(type == PredefinedParametarType.LOGO)
            GUI = type.toString();
        if(type == PredefinedParametarType.LOOK_AND_FEEL)
            GUI = type.toString();
        if(type == PredefinedParametarType.NAME)
            GUI = type.toString();
        if(type == PredefinedParametarType.AUTHOR)
            GUI = type.toString();
        if(type == PredefinedParametarType.START_AFTER_INSTALL)
            GUI = type.toString();
        if(type == PredefinedParametarType.PATH)
        {
            GUI = type.toString();
        }
    }

    private void formLabel(PredefinedParametarType type)
    {
        if(type == PredefinedParametarType.TERMS_OF_USE)
            label = "USLOVI KORISCENJA:";
        if(type == PredefinedParametarType.DESKTOP_SHORTCUT)
            label = "Da li zelite precicu na Vasem Desktopu?";
        if(type == PredefinedParametarType.LOGO)
            label = "Izaberite Vas logo";
        if(type == PredefinedParametarType.LOOK_AND_FEEL)
            label = "Izaberite Vas izgled";
        if(type == PredefinedParametarType.NAME)
            label = "IME PROIZVODA:";
        if(type == PredefinedParametarType.AUTHOR)
            label = "O AUTORU";
        if(type == PredefinedParametarType.START_AFTER_INSTALL)
            label = "Pokrenuti nakon instalacije";
        if(type == PredefinedParametarType.PATH)
            label = "Izaberite putanju instalacije";
    }

    @Override
    public String toString()
    {
        return name;
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

    public void setContent(String content)
    {
        this.content = content;
    }
}
>>>>>>> 4ffd20ae8b5902ea28b0c604686b86a6f030c2fa
