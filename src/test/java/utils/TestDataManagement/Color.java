package utils.TestDataManagement;

public class Color {
    private int locationX;
    private int locationY;
    public Color (int locationX, int locationY){
        this.locationX = locationX;
        this.locationY = locationY;
    }
    public int getLocationX(){return this.locationX;}
    public void setLocationX(int value){this.locationX = value;}
    public int getLocationY(){return this.locationY;}
    public void setLocationY(int value){this.locationY = value;}
}
