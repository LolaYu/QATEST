import java.util.Arrays;
import java.util.Random;

public class CitySim9002 {
	
final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,99999999, 999999999, Integer.MAX_VALUE };
    
    static int sizeOfInt(int x) {    
        for (int i = 0;; i++)    
            if (x <= sizeTable[i])    
                return i + 1;    
    }    

	public static void main(String[] args){
	
	   
	Choose choose=new Choose();

        int seed= Integer.parseInt(args[0]);
		 
        // check whether the passed-in argument is a valid integer 
        // if false, then cease execution 
	if (seed == (int)seed && seed > 0 && sizeOfInt(seed)==1) {
	      System.out.println("Welcome to CitySim!  Your seed is "  + seed +".");
		} else {
			System.out.println("Please enter one integer argument, seed");
		    System.exit(0);
		}
       
  

	    
		// start 5 visits
		for (int j = 1; j < 6; j++){
			System.out.println("Visitor "+j+" is a "+ visitortype(seed,choose)[j-1]+".");
			for (int pn=0; pn<100; pn++){
				if(pn == 0)
				{
					String firstplace=firstplace();
					System.out.println("Visitor "+j+" is going to "  +firstplace+"!");
					boolean like=preference(visitortype(seed,choose)[0],firstplace);
					
					if ( like=true)
					{ 
						System.out.println("Visitor "+j+" did like " +firstplace+".");
					} else {
						System.out.println("Visitor "+j+" did not like " +firstplace+".");
					}
				} else
				{
					String otherplace=otherplace();
					if (otherplace == "leave")
					{
						System.out.println("Visitor "+j+" has left the city.");
						break;
					} else
					{
						System.out.println("Visitor "+j+" is going to " +otherplace+"!");
						boolean like2=preference(visitortype(seed,choose)[j-1],otherplace);
						if ( like2=true)
						{ 
							System.out.println("Visitor "+j+" did like " +otherplace+".");
						} else 
						{
							System.out.println("Visitor "+j+" did not like " +otherplace+".");
						}
					}
				}
			}
				System.out.println("***");
		}
		
}

	//Each Visitor shall be of one of four types: a Student, a Professor, a Business Person, or a Blogger.

	public static String[] visitortype(int seed,Choose list1) {
		String [] numbers = new String[5];
		Random random = new Random(seed);
		for (int j = 0; j < 5; j++){
			int n= random.nextInt(4);
			switch(n){
			case 0:
				numbers[j]=list1.visitor()[0];
			break;
			case 1:
				numbers[j]=list1.visitor()[1];
			break;
			case 2:
				numbers[j]=list1.visitor()[2];
			break;
			case 3:
				numbers[j]=list1.visitor()[3];
			break;
			}
		}
		String [] list ={numbers[0],numbers[1],numbers[2],numbers[3],numbers[4]};
		return list;
}
	
	//FUN-FIRST-VISIT. For the first visit for a given Visitor, the Visitor cannot leave the City.  The Visitor must visit at least one Location.

	public static String firstplace() {
		
		int randomNumber=(int)(Math.random()*4)+1;
		String place = null;
		Choose list1=new Choose(); 
		
		if (randomNumber==1)
		{
			place =list1.firstplace()[0];
		} else if(randomNumber==2) {
			place =list1.firstplace()[1];
		} else if(randomNumber==3) {
			place =list1.firstplace()[2];
		} else if(randomNumber==4) {
		   place =list1.firstplace()[3];
		}
		return place;
		}
	
	//FUN-ITERATIONS. For each iteration, the program shall randomly select a location for the visitor to visit. 
	public static String otherplace() {
		int randomNumber=(int)(Math.random()*5)+1;
		String place = null;
		Choose list1=new Choose(); 
		if (randomNumber==1)
		{
			place =list1.otherplace()[0];
		} else if(randomNumber==2) {
			place =list1.otherplace()[1];
		} else if(randomNumber==3) {
			place =list1.otherplace()[2];
		} else if(randomNumber==4) {
		   place =list1.otherplace()[3];
		} else if(randomNumber==5) {
			place =list1.otherplace()[4];
		}
		return place;
		}
	
	// FUN-PREFERENCES. 
	//A Student shall like Squirrel Hill, Downtown, and The Point, and dislike The Cathedral of Learning.  
	//A Business Person shall like Squirrel Hill and Downtown, and dislike all other locations. 
	//A Professor shall like all locations.  
	//A Blogger shall dislike all locations.
	public static boolean preference(String visitor,String place ) {
		boolean like = true;
		if(visitor=="Student" )
		{
			if (place=="Squirrel Hill" || place=="The Point"|| place=="Downtown"){
				like=true;
			} else{
				like=false;
			}
		} else if (visitor=="Business Person" )
		{
			if (place=="Squirrel Hill" || place=="Downtown")
			{
				like=true;
			} else{
				like=false;
			}
		} else if (visitor=="Professor" )
		{
			like=true;
		}else if  (visitor=="Blogger")
		{
			like=false;
		}
		return like;
	}
}
