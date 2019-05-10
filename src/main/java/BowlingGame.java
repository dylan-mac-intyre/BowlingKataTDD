public class BowlingGame {

    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins){
        rolls[currentRoll++] = pins;
    }

    public int score(){
        int score = 0;
        int frameIndex = 0;

        for(int frame = 0; frame < 10; frame++){
            if(isStrike(frameIndex)){
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            }
            else if(isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            }
            else{
                score+= sumOfPinsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    public boolean isSpare(int frameIndex){
        return ((rolls[frameIndex] + rolls[frameIndex+1]) == 10);
    }

    public boolean isStrike(int frameIndex){
        return rolls[frameIndex] == 10;
    }

    public int strikeBonus(int frameIndex){
        return rolls[frameIndex+1] + rolls[frameIndex+2];
    }

    public int spareBonus(int frameIndex){
        return rolls[frameIndex+2] ;
    }

    public int sumOfPinsInFrame(int frameIndex){
        return rolls[frameIndex] + rolls[frameIndex+1];
    }
}
