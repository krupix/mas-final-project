package pl.krupix.mas.finalproject.model;


/**
 * Created by krupix on 13.06.2016.
 */
public interface DaoSerivce<T> {

    void persist(T domain);
}
