package ldap;

import java.util.*;
import com.novell.ldap.*;


public class LdapSearch implements Runnable{
	public void run() {
		
		try
		{
		LDAPConnection lc= new LDAPConnection();
		//Date d1 = new Date();
		
	//	long  startTime = System.nanoTime();
	//	System.out.println(d1.getTime());
//		Calendar now1 = Calendar.getInstance();
//		System.out.println(now1.getTime());
	//	System.out.println(startTime);
		for(int j=0;j<10;j++)
		{
			lc.connect("10.108.101.233",000000);
			lc.bind(null, null);
			Random r= new Random();
			int n = r.nextInt(100000);
			String t = String.valueOf(n);
			System.out.println(n);
			String s = "(InsideNumber=" + t + ")";
			LDAPSearchResults res = lc.search("dc=1", LDAPConnection.SCOPE_SUB, s, null, false);
			while(res.hasMore())
			{ 
				LDAPEntry le = res.next();
				System.out.println();
				System.out.println("DN :"+le.getDN());
				LDAPAttributeSet attr = le.getAttributeSet();
				Set sortedAttributes=new TreeSet(attr);
				Iterator allAttributes = sortedAttributes.iterator();
				while(allAttributes.hasNext())
				{
					LDAPAttribute attribute =(LDAPAttribute)allAttributes.next();
					String attributeName =attribute.getName();
					System.out.print(attributeName + ":");
					
					Enumeration allValues = attribute.getStringValues();
					if(allValues != null)
					{
						while(allValues.hasMoreElements())
						{
							String value = (String)allValues.nextElement();
							System.out.println(value);
							
						}
					}
					
				}
				//lc.disconnect();
				//lc = null;
	//			Date d2 = new Date();
			
		}
	//	long endTime = System.currentTimeMillis();
	//	System.out.println("程序运行时间：" + (endTime-startTime)/10+ "ms");
		lc.disconnect();
		}
		}catch (Exception e)
		{
			
			e.printStackTrace();
		} 
	
	}
	public static void main(String[] args)  throws Exception
	{ 
		long startTime = System.currentTimeMillis();
		
			System.out.println(Thread.currentThread().getName() );
			LdapSearch ls = new LdapSearch();
			new Thread(ls).start();
		
		
		long endTime = System.currentTimeMillis();
				
		System.out.println("程序运行时间"+(endTime-startTime)/10);
		
		
		
	}
}
