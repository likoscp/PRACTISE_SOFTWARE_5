import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Observer Pattern (Lab 7)
interface Observer1 {
    void update(String message);
}

class Subject1 {
    private List<Observer1> observers = new ArrayList<>();
    private String state;

    public void attach(Observer1 observer) {
        observers.add(observer);
    }

    public void detach(Observer1 observer) {
        observers.remove(observer);
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    public String getState() {
        return state;
    }

    private void notifyAllObservers() {
        for (Observer1 observer : observers) {
            observer.update(state);
        }
    }
}

class ConcreteObserver11 implements Observer1 {

    public void update(String message) {
        System.out.println("Observer 1 received update: " + message);
    }
}

class ConcreteObserver12 implements Observer1 {

    public void update(String message) {
        System.out.println("Observer 2 received update: " + message);
    }
}

// State Pattern (Lab 8)
interface State2 {
    void doAction(Context2 context);
}

class StartState2 implements State2 {

    public void doAction(Context2 context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public String toString() {
        return "Start State";
    }
}

class StopState2 implements State2 {

    public void doAction(Context2 context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString() {
        return "Stop State";
    }
}

class Context2 {
    private State2 state;

    public Context2() {
        state = null;
    }

    public void setState(State2 state) {
        this.state = state;
    }

    public State2 getState() {
        return state;
    }
}

// Strategy Pattern (Lab 9)
interface Strategy3 {
    int doOperation(int num1, int num2);
}

class OperationAdd3 implements Strategy3 {

    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSubtract3 implements Strategy3 {

    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationMultiply3 implements Strategy3 {

    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

class Context3 {
    private Strategy3 strategy;

    public Context3(Strategy3 strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}

// Template Method Pattern (Lab 10)
abstract class Game4 {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    // Template method
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

class Cricket4 extends Game4 {

    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}

class Football4 extends Game4 {

    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}

// Visitor Pattern (Lab 11)
interface ComputerPart5 {
    void accept(ComputerPartVisitor5 computerPartVisitor);
}

class Keyboard5 implements ComputerPart5 {

    public void accept(ComputerPartVisitor5 computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

class Monitor5 implements ComputerPart5 {

    public void accept(ComputerPartVisitor5 computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

class Mouse5 implements ComputerPart5 {

    public void accept(ComputerPartVisitor5 computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

interface ComputerPartVisitor5 {
    void visit(Keyboard5 keyboard);
    void visit(Monitor5 monitor);
    void visit(Mouse5 mouse);
}

class ComputerPartDisplayVisitor5 implements ComputerPartVisitor5 {

    public void visit(Keyboard5 keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    public void visit(Monitor5 monitor) {
        System.out.println("Displaying Monitor.");
    }

    public void visit(Mouse5 mouse) {
        System.out.println("Displaying Mouse.");
    }
}

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            
        
        System.out.println("Select case to run:");
        System.out.println("1 - Observer Pattern (Lab 7)");
        System.out.println("2 - State Pattern (Lab 8)");
        System.out.println("3 - Strategy Pattern (Lab 9)");
        System.out.println("4 - Template Method Pattern (Lab 10)");
        System.out.println("5 - Visitor Pattern (Lab 11)");

        int task = scanner.nextInt();

        switch (task) {
            case 1: // Observer Pattern
                Subject1 subject = new Subject1();
                Observer1 observer1 = new ConcreteObserver11();
                Observer1 observer2 = new ConcreteObserver12();

                subject.attach(observer1);
                subject.attach(observer2);

                subject.setState("New State 1");
                subject.setState("New State 2");
                break;

            case 2: // State Pattern
                Context2 context2 = new Context2();

                StartState2 startState2 = new StartState2();
                startState2.doAction(context2);
                System.out.println("Current State: " + context2.getState());

                StopState2 stopState2 = new StopState2();
                stopState2.doAction(context2);
                System.out.println("Current State: " + context2.getState());
                break;

            case 3: // Strategy Pattern
                Context3 context3 = new Context3(new OperationAdd3());
                System.out.println("10 + 5 = " + context3.executeStrategy(10, 5));

                context3 = new Context3(new OperationSubtract3());
                System.out.println("10 - 5 = " + context3.executeStrategy(10, 5));

                context3 = new Context3(new OperationMultiply3());
                System.out.println("10 * 5 = " + context3.executeStrategy(10, 5));
                break;

            case 4: // Template Method Pattern
                Game4 game4 = new Cricket4();
                game4.play();

                System.out.println();

                game4 = new Football4();
                game4.play();
                break;

            case 5: // Visitor Pattern
                ComputerPart5 keyboard5 = new Keyboard5();
                ComputerPart5 monitor5 = new Monitor5();
                ComputerPart5 mouse5 = new Mouse5();

                ComputerPartVisitor5 visitor5 = new ComputerPartDisplayVisitor5();

                keyboard5.accept(visitor5);
                monitor5.accept(visitor5);
                mouse5.accept(visitor5);
                break;

            default:
                System.out.println("Invalid choice.");
                break;
            
        }

        }
    }
}
