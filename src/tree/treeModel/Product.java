package tree.treeModel;

@SuppressWarnings("serial")
public class Product extends Node {


	private String instalationUrl = "";

	public Product(String name)
	{
		super(name);
	}

	public Product(Node node)
	{
		super(node);
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}

	public String getInstalationUrl()
	{
		return instalationUrl;
	}

	public void setInstalationUrl(String instalationUrl)
	{
		this.instalationUrl = instalationUrl;
	}
}
