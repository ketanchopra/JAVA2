import java.io.*;
public class CSX_351_HW2_16103042 {
     
	 public static void main(String[] args)
		    {    
		        BufferedReader reader = null; 
		        BufferedReader reader1 = null;
		        BufferedWriter writer = null;
		        int count=0;
		                 
		        //Create an ArrayList object to hold the lines of input file
		         
		        String dict[]=new String [16000];
	               String key[]=new String [84];
		        try
		        {
		            //Creating BufferedReader object to read the input file
		             
		            reader = new BufferedReader(new FileReader("C:\\Users\\ACER\\Desktop\\csx-351-hw2-ketanchopra-master\\csx-351-hw2-ketanchopra-master\\HW2-dictionary.txt"));
		            reader1 = new BufferedReader(new FileReader("C:\\Users\\ACER\\Desktop\\csx-351-hw2-ketanchopra-master\\csx-351-hw2-ketanchopra-master\\HW2-keywords.txt"));
		            writer = new BufferedWriter(new FileWriter("HW2_output_16103042.txt "));
		            //Reading all the lines of input file one by one and adding them into ArrayList
		             
		            for(int i=0;i<16000;i++)
		             {
		            	 dict[i]=reader.readLine();					//store them in array
		             }
		             for(int i=0;i<84;i++)
		             {
		            	 key[i]=reader1.readLine();					//store them in array
		             }
		            //Sorting the ArrayList
		             
		             String tempStr,temp;
		             for (int t = 0; t < 16000 - 1; t++) {
		                 for (int i= 0; i < 16000 - t-1; i++) {		//bubble sort
		                     if(dict[i+1].compareTo(dict[i])<0) {		//comparing them using compareTo whic returns integer value 
		                         tempStr = dict[i];					
		                         dict[i] = dict[i + 1];
		                         dict[i + 1] = tempStr;
		                      }
		                 }   
		             }
		             for (int t = 0; t < 84 - 1; t++) {					//bubble sort	
		                 for (int i= 0; i < 84 - t-1; i++) {
		                     if(key[i+1].compareTo(key[i])<0) {			//sorting the strings in array
		                         temp = key[i];
		                         key[i] = key[i + 1];
		                         key[i + 1] = temp;
		                      }
		                 }  
		             }
		             int flag=0;
		             try {
		            	 for(int t=0;t<84;t++)
		            	 {
		            		 for(int i=0;i<16000;i++)
		            		 {
		            			 if(key[t].equals(dict[i])) {			//matching words from keywords file to dictionary file & equals returns boolean 
		            			 flag=1;								//if match found flag is set
		            			 }
		            		 }
		            		 if(flag==0) {							
		            			 writer.write("Keyword not found: " + key[t] );	 
		            			 writer.newLine();						//if match not found flag is reset and count is increased for counting unmatched words
		            			 count++;
		            		 }
		            		 flag=0;									//flag is again reset to 0 for first case
		            	 }
		            	 writer.newLine();
		            	 writer.write("No. of keywords not found: "+ count);
		            	 writer.close();
		            	 reader1.close();
		            	 reader.close();
		             }

		           
		             catch (Exception e) {
		                 System.out.println("Exception occurred");
		              }
		        }
		             
		        catch(FileNotFoundException fne){
		        fne.printStackTrace();
		        }
		        catch(IOException io){
		        io.printStackTrace();
		        }
        }
}
