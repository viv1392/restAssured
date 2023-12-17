package api.EndPoint;

public class Route {
	// 'https://petstore.swagger.io/v2/user'
public static String base_url  ="https://petstore.swagger.io/v2/user";
 	
 	//User Model
    public static String post_url  = base_url;
    public static String get_url=base_url+"/{username}";
    public static String update_url=base_url+"/{username}";
    public static String delete_url=base_url+"/{username}";
     
    
    //Store Model
    	//Here you can add Store url's
    
    
    //Pet Model
    	//Here you can add Pet url's


}
