package Powers;

public interface Power {
    void executeAction();

    default String getName() {
        return getClass().getSimpleName();
    }
}
