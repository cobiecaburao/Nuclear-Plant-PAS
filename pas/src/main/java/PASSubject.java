/**
 * @author CobieCaburao
 *
 */
interface PASSubject {
    void registerObserver(PASObserver observer);
    void removeObserver(PASObserver observer);
    void notifyObservers();
}
