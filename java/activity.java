public class activity {
    public static int[] activitySelection(int a[], int s[], int f[], int n) {
      int[] A = new int[n]; 
      A[0] = 0; 
      A[1] = a[1];
  
      int k=1;
      int iter = 1;
  
      for(int i=2; i<=n; i++) {
        if(s[i] >= f[k]) {
          iter++;
          A[iter] = a[i];
          k=i;
        }
      }
  
      A[0] = iter;
      return A;
    }
  
    public static void main(String[] args) {
      int a[] = {0, 2, 3, 5, 1, 4};
      int s[] = {0, 0, 1, 3, 4, 1};
      int f[] = {0, 2, 3, 4, 6, 6};
      int[] p = activitySelection(a, s, f, 5);
  
      for(int i=1; i<=p[0]; i++) {
        System.out.println(p[i]);
      }
    }
  }
  
  