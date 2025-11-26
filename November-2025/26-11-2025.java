// AND In Range
// Difficulty: MediumAccuracy: 33.68%Submissions: 4K+Points: 4
// // You are given two integers l and r. Find the result after applying the series of Bitwise AND ( & ) operation on every natural number between the range l to r (including both).



class Solution {
    
    int cnt(int n){
        
        int ans=0;
        while(n>0){
            
            n=n/2;
            ans++;
        }
        
        return ans;
    }
  public:
    int andInRange(int l, int r) {
    

    int n=cnt(l);
    
  int m=cnt(r);
  
  if(n!=m){
      return 0;
  }
  
  int ans=0;
  
 for(int i=cnt(l);i>=0;i--){
     
     int left=((l>>i)&1);
     int right= ((r>>i)&1);
     
     if(left!=right){
     break;
     }
    
else if(left==1){
    
    ans=ans+(1<<i);
}
     
 }
 

  return ans;
        
    }
};