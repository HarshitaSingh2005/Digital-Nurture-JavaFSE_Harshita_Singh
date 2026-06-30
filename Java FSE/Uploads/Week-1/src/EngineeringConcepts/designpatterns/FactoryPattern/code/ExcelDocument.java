package EngineeringConcepts.designpatterns.FactoryPattern.code;

public class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Excel Document");
    }
}
