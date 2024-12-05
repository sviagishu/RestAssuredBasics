package api_endpoints;

//post: https://petstore.swagger.io/v2/user
//Get: https://petstore.swagger.io/v2/user/{username}
//Put: https://petstore.swagger.io/v2/user/{username}
//Delete: https://petstore.swagger.io/v2/user/{username}

public class rootNodes {
	
	public static String base_url= "https://petstore.swagger.io/v2/user";
	public static String get_url = base_url+"/{username}";
	public static String put_url = base_url+"/{username}";
	public static String del_url = base_url+"/{username}";
	

}
