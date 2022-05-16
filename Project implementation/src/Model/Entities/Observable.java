package Model.Entities;



public interface Observable {
    public void getObservers();
    public void notifyUpdate();
}
