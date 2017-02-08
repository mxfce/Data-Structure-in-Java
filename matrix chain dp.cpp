#include <iostream>
#include <fstream>
#include <random>
#include <iomanip>
#include <math.h>
#include <vector>
#include <limits>
#include <map>
using namespace std;
int bot_dp_mat_multiplication(int A[],int n)
{
    int dp[n][n] = {0};
   for(int L = 1; L < n; ++L)
   {

       for(int i = 1; i < n-L + 1;++i)
       {
           int j = L + i;
           dp[i][j] = 10000000;
           for(int k = i; k < j; ++k)
           {
                dp[i][j] = min(dp[i][k] + dp[k+1][j] + A[i-1]*A[k]*A[j],dp[i][j]);
           }
       }
   }
   return dp[1][n-1];
}
