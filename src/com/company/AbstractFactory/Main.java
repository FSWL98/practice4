package com.company.AbstractFactory;


abstract class CarFactory {
    public abstract AbstractCar CreateCar();
    public abstract AbstractEngine CreateEngine();
    public abstract AbstractBody CreateBody();
}

abstract class AbstractCar {
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public abstract int MaxSpeed(AbstractEngine engine);
    public abstract String BodyType(AbstractBody body);
}

abstract class AbstractEngine {
    private int max_speed;

    public int getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }
}

abstract class AbstractBody {
    private String bodyType;

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
}

class FordFactory extends CarFactory {
    @Override
    public AbstractCar CreateCar() {
        return new FordCar("Ford");
    }
    @Override
    public AbstractEngine CreateEngine() {
        return new FordEngine();
    }
    @Override
    public AbstractBody CreateBody() {
        return new FordBody();
    }
}

class FordCar extends AbstractCar {
    public FordCar(String name) {
        this.setName(name);
    }
    @Override
    public int MaxSpeed(AbstractEngine engine) {
        return engine.getMax_speed();
    }
    @Override
    public String BodyType(AbstractBody body) {
        return body.getBodyType();
    }
    @Override
    public String toString() {
        return "Auto " + this.getName();
    }
}
class FordEngine extends AbstractEngine {
    public FordEngine() {
        this.setMax_speed(220);
    }
}
class FordBody extends AbstractBody {
    public FordBody() {
        this.setBodyType("Sedan");
    }
}

class AudiFactory extends CarFactory {
    private AudiFactory() {}
    private static AudiFactory instance = null;

    public static AudiFactory getInstance() {
        if (instance == null) {
            instance = new AudiFactory();
        }
        return instance;
    }

    @Override
    public AbstractCar CreateCar() {
        return new AudiCar("Audi");
    }
    @Override
    public AbstractEngine CreateEngine() {
        return new AudiEngine();
    }
    @Override
    public AbstractBody CreateBody() {
        return new AudiBody();
    }
}

class AudiCar extends AbstractCar {
    public AudiCar(String name) {
        this.setName(name);
    }
    @Override
    public int MaxSpeed(AbstractEngine engine) {
        return engine.getMax_speed();
    }
    @Override
    public String BodyType(AbstractBody body) {
        return body.getBodyType();
    }
    @Override
    public String toString() {
        return "Auto " + this.getName();
    }
}
class AudiEngine extends AbstractEngine {
    public AudiEngine() {
        this.setMax_speed(280);
    }
}
class AudiBody extends AbstractBody {
    public AudiBody() {
        this.setBodyType("Sedan");
    }
}

class Client {
    private AbstractCar car;
    private AbstractEngine engine;
    private AbstractBody body;
    public Client(CarFactory factory) {
        car = factory.CreateCar();
        engine = factory.CreateEngine();
        body = factory.CreateBody();
    }

    public int RunMaxSpeed() {
        return car.MaxSpeed(engine);
    }
    public String getBodyType() {
        return car.BodyType(body);
    }
    @Override
    public String toString() {
        return car.toString();
    }
}


public class Main {

    public static void main(String[] args) {
        // write your code here
        CarFactory fordFactory = AudiFactory.getInstance();
        Client client = new Client(fordFactory);
        System.out.println("Max speed of " + client.toString() + " is " + client.RunMaxSpeed() + " km/h. Body type is " + client.getBodyType());
    }
}
