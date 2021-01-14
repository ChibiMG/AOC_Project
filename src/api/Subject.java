package api;

public interface Subject {

    /**
     * @param o an Observer
     */
    public void attach(Observer o);

    /**
     * @param o an Observer
     */
    public void detach(Observer o);

}
