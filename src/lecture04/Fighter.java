package lecture04;

public class Fighter {

    private int hitPoint;
    private int power;
    private String name;

    public Fighter(int hitPoint,int power,String name){
        this.hitPoint=hitPoint;
        this.power=power;
        this.name=name;
    }

    public int getHitPoint(){
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public String getName(){
        return this.name;
    }

    public void attack(Fighter enemy){

        enemy.setHitPoint(enemy.getHitPoint()-this.power);
        System.out.println(this.name+"は"+enemy.getName()+"に"+this.power+"ダメージを与えた。");
        System.out.println(enemy.getName()+"の残り hitpoint : "+enemy.getHitPoint());

    }

    public boolean isAlive(){
        if(hitPoint>0){
            return true;
        } else {

            return false;
        }
    }
}
