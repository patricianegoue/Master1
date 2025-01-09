package DECORATOR_OBSERVER;

import java.util.List;

public interface Observer<T> {
    void update(T vehicule);
    void getCatalogue();
}
