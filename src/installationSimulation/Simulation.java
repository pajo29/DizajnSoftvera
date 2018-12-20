package installationSimulation;

import tree.treeModel.Module;
import tree.treeModel.Node;
import tree.treeModel.Parametar;
import tree.treeModel.Product;

import java.util.ArrayList;

public class Simulation
{

    private Product product;

    private ArrayList<Parametar> productParametars;

    public Simulation(Product product)
    {
        this.product = product;
        productParametars = new ArrayList<>();
        parametarsFill((Node)product, productParametars, 0);

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
}
