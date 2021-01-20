package api;

public interface Subject {

    /**
     * @param o an Observer
     * Link the subject with the observer
     */
    public void attach(Observer o);

    /**
     * @param o an Observer
     * delete the link between the subject and the observer
     */
    public void detach(Observer o);

}
