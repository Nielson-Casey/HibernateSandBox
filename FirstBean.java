package sand.HibernateSandBox;

public class FirstBean implements java.io.Serializable {

	/**This defines which version**/
	private static final long serialVersionUID = -879972165483850L;
	private String userName;
	private String password;
	int length;
	int width;
	public FirstBean(){}
	public FirstBean(int x, int y)
	{
		
		this.length = 0;
		this.width = 0;
	}
	
	public String getUserName()
	{
		return userName;
	}
	public String getPassword()
	{
		return password;
	}
	public String setUserName()
	{
		return userName;
	}
	public String setPassword()
	{
		return password;
	}
}
