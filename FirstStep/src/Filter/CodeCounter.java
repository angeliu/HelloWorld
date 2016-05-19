package Filter;

import java.io.*;



public class CodeCounter {
	static long normalLines = 0;
	static long commentLines = 0;
	static long whiteLines = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:\\test");
		File[] codeFiles = file.listFiles();
		for(File child : codeFiles)
		{
			if(child.getName().matches(".*\\.java$"))
			{
				parse(child);
			}
		
		}
		System.out.println("normalLines" + normalLines);
		System.out.println("commentsLines"+commentLines);
		System.out.println("whileLines" + whiteLines);
	}

	private static void parse(File f) {
		BufferedReader br = null;
		boolean comment = false;
		try
		{
			br = new BufferedReader(new FileReader(f));
			String line = "";
			while((line = br.readLine()) != null)
			{
				line = line.trim();
				if(line.matches("^[\\s&&[^\\n]]*$"))
				{
					whiteLines ++;
					
				} else if (line.startsWith("/*") && !line.endsWith("*/"))
				{
					commentLines++;
					comment = true;
				} else if (line.startsWith("/*") && line.endsWith("*/"))
				{
					commentLines ++;
				} else if(true == comment)
				{
					commentLines ++;
					if(line.endsWith("*/"))
					{
						comment = false;
					}
				}  else if(line.startsWith("//"))
				{
					commentLines ++;
				} else
				{
					normalLines++;
				}
			}
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}  finally
		{
			if(br != null)
			{
				try
				{
					br.close();
					br = null;
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		
		
	}

}