package tree.treeModel;

@SuppressWarnings("serial")
public class Product extends Node {


	private String instalationUrl = "";
	private String logoURL = "";
	private String logoName = "";

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
	
	public String getLogoURL()
	{
		return logoURL;
	}
	
	public void setLogoURL(String logoURL)
	{
		this.logoURL = logoURL;
	}
	
	public String getLogoName()
	{
		return logoName;
	}
	
	public void setLogoName(String logoName)
	{
		this.logoName = logoName;
	}
}
