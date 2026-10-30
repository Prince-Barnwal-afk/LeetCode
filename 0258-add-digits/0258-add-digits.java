// class Solution {
//     public int addDigits(int num) {
//         if(num < 9){
//             return num;
//         }
//         return sum(num);
//     }
//     public static int sum(int num){
//         if(num == 9) return num;
//         int summ =  0;
//         while(num > 0){
//             int temp = num % 10;
//             summ += temp;
//             num = num/10;
//         }
//         if(summ < 9){
//             return summ;
//         }
//             return sum(summ);
//     }
// }

class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        return 1 + (num - 1) % 9;
    }
}