import static java.lang.Thread.sleep;

public class Robot {
    private String name;
    private boolean working = false;

    public String getName() {
        return name;
    }

    public Robot(String name) {
        setName(name);
    }

    private void setName(String name) {
        if(name.isEmpty()){ throw new IllegalArgumentException();}
        this.name = name;
    }

    public boolean isWorking(){
        return working;
    }

    public void talktoRobot(){
        working = true;
    }


    public String getWorkingMsg(){
        if(!working){
            throw new IllegalStateException();
        }
        return "I am in working mode";
    }

    public void waitTillWorking() throws InterruptedException {
        sleep(1000);


    }



}
