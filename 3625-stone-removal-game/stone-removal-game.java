class Solution {
    public boolean canAliceWin(int n) {
        int stones = n;
        int remove = 10;
        boolean aliceTurn = true;

        while (true) {
            if (stones < remove) {
                return !aliceTurn;
            }

            stones -= remove;
            remove--;
            aliceTurn = !aliceTurn;
        }
    }
}