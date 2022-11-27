public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    Match(Fighter f1,Fighter f2,int minWeight,int maxWeight){
        this.f1=f1;
        this.f2=f2;
        this.minWeight=minWeight;
        this.maxWeight=maxWeight;
    }

    void run(){
        if (checkWeight()){
            System.out.println("-----YENİ ROUND-----");
            if (whoStart()){
                System.out.println("Maça "+ this.f1.name + " başladı.");
                this.f2.health=this.f2.health-this.f1.damage;
                System.out.println(this.f1.name + " => " +this.f2.name + "'ye " + this.f1.damage + " hasar vurdu");
            }else {
                System.out.println("Maça "+ this.f2.name + " başladı.");
                this.f1.health=this.f1.health-f2.damage;
                System.out.println(this.f2.name + " => " +this.f1.name + "'ye " + this.f2.damage + " hasar vurdu");
            }
            while (this.f1.health > 0 && this.f2.health > 0 ){
                f2.health=f1.hit(f2);
                if (isWin()){
                    break;
                }
                f1.health=f2.hit(f1);
                if (isWin()){
                    break;
                }

                printScore();
            }

        }else {
            System.out.println("Sporcuların ağırlıkları uyuşmuyor.");
        }


    }

    void printScore() {
        System.out.println("Kalan can :  " + f1.health);
        System.out.println("Kalan can :  " + f2.health);
    }

    boolean isWin() {
        if(f1.health==0){
            System.out.println("Maçı kazanan " + f2.name);
            return true;
        } else if (f2.health==0) {
            System.out.println("Maçı kazanan " +f1.name);
            return true;
        }

        return false;
    }

    boolean checkWeight(){
        return (f1.weight>=minWeight && f1.weight<=maxWeight) && (f2.weight>=minWeight && f2.weight<=maxWeight);
    }

    boolean whoStart(){
        double start =Math.random()*100;
        return start >= 50;
    }
}
