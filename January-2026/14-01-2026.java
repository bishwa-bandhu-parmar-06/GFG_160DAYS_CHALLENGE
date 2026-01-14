// Police and Thieves
// Difficulty: MediumAccuracy: 34.03%Submissions: 54K+Points: 4
// Given an array arr[], where each element contains either a 'P' for policeman or a 'T' for thief. Find the maximum number of thieves that can be caught by the police. 
// Keep in mind the following conditions :

// Each policeman can catch only one thief.
// A policeman cannot catch a thief who is more than k units away from him.



class Solution
{
    
    public
    int
    catchThieves
    (
        char [] arr
        , int k
    )
    {
        final ArrayDeque < Integer > legalisedArrayDeque
            = new ArrayDeque <> ();
            
        final ArrayDeque < Integer > nonlegalisedArrayDeque
            = new ArrayDeque <> ();
            
        int answer = 0;
        
        
        for
        (
            Integer i = 0
            ; i < arr.length
            ; i ++
        )
        {
            
            if
            (
                arr[i] == 'P'
            )
            {
                answer += match
                    (
                        nonlegalisedArrayDeque
                        , legalisedArrayDeque
                        , i
                        , k
                    );
            }
            else
            {
                answer += match
                    (
                        legalisedArrayDeque
                        , nonlegalisedArrayDeque
                        , i
                        , k
                    );
            }
            
        }


        return answer;
    }
    
    
    
    
    private
    int
    match
    (
        final ArrayDeque < Integer > arrayDeque1
        , final ArrayDeque < Integer > arrayDeque2
        , final int i
        , final int k
    )
    {
        final int j = i - k;
        
        
        while
        (
            !arrayDeque1.isEmpty()
            && arrayDeque1.peekFirst() < j
        )
        {
            arrayDeque1.pollFirst();
        }


        if
        (
            arrayDeque1.isEmpty()
        )
        {
            arrayDeque2.offerLast( i );


            return 0;
        }
        else
        {
            arrayDeque1.pollFirst();


            return 1;
        }

    }
    
}