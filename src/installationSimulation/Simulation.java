package installationSimulation;

import parameters.logo.LogoView;
import parameters.parametar.view.ParametarView;
import tree.treeModel.Module;
import tree.treeModel.Node;
import tree.treeModel.Parametar;
import tree.treeModel.Product;

import javax.swing.*;
import java.util.ArrayList;

public class Simulation
{

    private Product product;

    private ArrayList<Parametar> productParametars;
    public int window = 0;

    private String logoUrl;
    private String lookAndFeel;

    public Simulation(Product product)
    {
        this.product = product;
        productParametars = new ArrayList<>();
        parametarsFill((Node)product, productParametars, 0);

        logoUrl = getLogo();
        lookAndFeel = getLookAndFeel();

        startWindow();




//        for (Parametar par: productParametars)
//        {
//            JPanel panel = ParametarView.createGUI(par.getParametar().isPredefined(),
//                    par.getParametar().getGUI(),
//                    par.getParametar().getContent(),
//                    par.getParametar().getLabel(), //<USED TO TEST WINDOWS>
//                    par,
//                    true,
//                    lookAndFeel);
//            InstallationDialog id = new InstallationDialog(panel, lookAndFeel, logoUrl);
//        }


    }

    public void startWindow()
    {
        Parametar par = productParametars.get(window);
                    JPanel panel = ParametarView.createGUI(par.getParametar().isPredefined(),
                    par.getParametar().getGUI(),
                    par.getParametar().getContent(),
                    par.getParametar().getLabel(),
                    par,
                    true,
                    lookAndFeel);
            InstallationDialog id = new InstallationDialog(panel, lookAndFeel, logoUrl, this);
    }

    private String getLookAndFeel()
    {
        String lookAndFeel = "";
        boolean set = false;
        ArrayList<Parametar> removeParametars = new ArrayList<>();
        for (Parametar par: productParametars)
        {
            if(par.getParametar().isPredefined() && par.getParametar().getGUI().equals("LOOK_AND_FEEL"))
            {
                if(set)
                {
                    removeParametars.add(par);
                }
                else
                {

                    lookAndFeel = par.getParametar().getContent();
                    set = true;
                    removeParametars.add(par);
                }

            }
        }
        productParametars.removeAll(removeParametars);
        return lookAndFeel;
    }

    private String getLogo()
    {
        String url = "";
        boolean set = false;
        ArrayList<Parametar> removeParametars = new ArrayList<>();
        for (Parametar par: productParametars)
        {
            if(par.getParametar().isPredefined() && par.getParametar().getGUI().equals("LOGO"))
            {
                if(set)
                {
                    removeParametars.add(par);
                }
                    else
                {

                    url = par.getParametar().getContent();
                    set = true;
                    removeParametars.add(par);
                }

            }
        }
        productParametars.removeAll(removeParametars);
        return url;
    }

    private void parametarsFill(Node product, ArrayList<Parametar> parametars, int counter)
    {
        if(counter == product.getChildCount())
            return;

        if(product.getChildAt(counter) instanceof Parametar)
            parametars.add((Parametar) product.getChildAt(counter));

        if(product.getChildAt(counter) instanceof Module)
            parametarsFill((Node)product.getChildAt(counter), parametars, 0);

        parametarsFill(product, parametars, counter+1);
    }

    public ArrayList<Parametar> getProductParametars()
    {
        return productParametars;
    }
}
