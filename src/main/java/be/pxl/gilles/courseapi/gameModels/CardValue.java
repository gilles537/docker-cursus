package be.pxl.gilles.courseapi.gameModels;

public enum CardValue {
    TWO(2,0),
    THREE(3,0),
    FOUR(4,0),
    FIVE(5,0),
    SIX(6,0),
    SEVEN(7,0),
    EIGHT(8,0),
    NINE(9,0),
    TEN(10,0),
    JACK(11,1),
    QUEEN(12,2),
    KING(13,3),
    ACE(14,4);

    private int cardValue;
    private int pointValue;

    private CardValue(int value, int pointValue)
    {
        this.cardValue = value;
        this.pointValue = pointValue;
    }

    public int getCardValue() {
        return cardValue;
    }
    public int getPointValue() {  return pointValue; }

}
