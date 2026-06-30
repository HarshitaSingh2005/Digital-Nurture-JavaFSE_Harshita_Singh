package EngineeringConcepts.designpatterns.FactoryPattern.code;

public class WordDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}