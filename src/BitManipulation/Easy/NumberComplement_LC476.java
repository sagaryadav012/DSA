package BitManipulation.Easy;

public class NumberComplement_LC476 {
    public static void main(String[] args) {
        int num = 1;
        System.out.println(findComplement(num));
    }
    public static int findComplement(int num) {
        int ans = 0;
        int lastPos = 0;
        for(int bit = 0; bit <= 31; bit++){
            if(((num>>bit)&1) == 1) lastPos = bit;
        }

        for(int bit = 0; bit <= lastPos; bit++){
            int digit = ((num>>bit)&1)^1;
            digit <<= bit;
            ans += digit;
        }

        return ans;
    }
}

/*
-> Iterate over each bit of num, take last bit and then flip it. To flip XOR operation is best.
-> Once we get flipped bit, then do left shift. so it gives to get exact value.
-> Before all these find lastPos, means for example num = 5, binary representation 101, and we are iterating
   till 31st bit so when we come to 3rd bit it's 0, but it's XOR value is 1, and it gives wrong value.
   So calculate last bit pos, and ignore other bits.
 */
