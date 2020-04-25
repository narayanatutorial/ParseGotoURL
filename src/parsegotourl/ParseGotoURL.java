package parsegotourl;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ParseGotoURL {

	public static void main(String args[]) throws UnsupportedEncodingException {
		try {
			String gotoURLEncoded="http%3A%2F%2Fopenam.narayanatutorial.com%3A8991%2Fam%2Foauth2%2Fauthorize%3Fresponse_type%3Did_token%2520token%26client_id%3DmyClientID%26realm%3D%252F%26scope%3Dopenid%2520profile%26redirect_uri%3Dhttp%253A%252F%252Fopenam.narayanatutorial.com%253A8080%252FImplicitGrantTypeDemo%252Fcb-implicit.html%26state%3Daf0ifjsldkj%26nonce%3Dn-0S6_WzA2Mj#login/";
			System.out.println("gotoURLEncoded:"+gotoURLEncoded);
			String gotoURLDecoded=URLDecoder.decode(gotoURLEncoded, "UTF-8");
			System.out.println("gotoURLDecoded:"+gotoURLDecoded);
			 Map<String, String> map =getQueryMap(gotoURLDecoded);
			System.out.println("client_id:"+map.get("client_id"));
			
			Set<Map.Entry<String, String>> set=map.entrySet();
			
			for(Map.Entry<String, String> keyValue:set) {
				System.out.println(keyValue.getKey()+"="+keyValue.getValue());
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Map<String, String> getQueryMap(String query)
	{
	    String[] params = query.split("&");
	    Map<String, String> map = new HashMap<String, String>();
	    for (String param : params)
	    {
	        String name = param.split("=")[0];
	        String value = param.split("=")[1];
	        map.put(name, value);
	    }
	    return map;
	}
}
