public class array {

  public static void main(String[] args) {
    int arr[]= {1,2,6,5,3,8,9,10,};
    int len=arr.length;
    int max=0;
    
    for(int i=0;i<len;i++)   
    {
      if (arr[i]>max)
      {
        max=arr[i];
      }
    }

    char [][]dis1=new char[len][max];

    for(int j=0;j<len;j++)   
    { 
      for(int i=0;i<max-arr[j];i++)   
       dis1[j][i]=' ';
    
      for(int k=max-arr[j];k<max;k++)
      {  dis1[j][k]='#';
      
      }
        
    }
    
    for(int i=0;i<max;i++)   
    {
      for(int j=0;j<len;j++)
      System.out.print(dis1[j][i]+" ");  
      System.out.println();
    }
  }
}